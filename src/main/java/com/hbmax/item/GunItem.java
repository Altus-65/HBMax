package com.hbmax.item;

import com.hbmax.client.render.GunItemGeoRenderer;
import com.hbmax.gun.GunShootLogic;
import com.hbmax.item.ammo.AmmoItem;
import com.hbmax.network.AmmoSyncPacket;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.function.Consumer;

/**
 * ВАЖНО О ЛОГИКЕ АНИМАЦИЙ (читай перед изменением):
 *
 * Все RawAnimation НЕ содержат .thenLoop(...) — только сам play-клип.
 * Состояние "куда встать после триггера" решает ИСКЛЮЧИТЕЛЬНО Java-код
 * в predicate контроллера, через NBT-флаг "Zooming".
 *
 * Это единственный надёжный способ в GeckoLib 4.4.4 избежать гонки между
 * "автоматический дефолт idle" и "доигрывание триггера" — два источника
 * управления анимацией конфликтуют, если оба пытаются решать, что играть
 * после завершения play-клипа.
 *
 * Правило: predicate (дефолтный лямбда-блок) решает ТОЛЬКО когда нет
 * активного триггера (controller.isPlayingTriggeredAnimation() == false).
 * Если триггер играет — predicate его не трогает.
 */
public class GunItem extends net.minecraft.world.item.Item implements GeoItem {

    // ── Анимации — БЕЗ .thenLoop, только чистый клип ──────────────────────
    private static final RawAnimation ANIM_IDLE       = RawAnimation.begin().thenLoop("idle");
    private static final RawAnimation ANIM_ZOOM_IDLE  = RawAnimation.begin().thenLoop("zoom_idle");
    private static final RawAnimation ANIM_SHOOT      = RawAnimation.begin().thenPlay("shoot");
    private static final RawAnimation ANIM_SHOOT_ZOOM = RawAnimation.begin().thenPlay("shoot_zoom");
    private static final RawAnimation ANIM_RELOAD     = RawAnimation.begin().thenPlay("reload");
    private static final RawAnimation ANIM_ZOOM_IN    = RawAnimation.begin().thenPlay("zoom_in");
    private static final RawAnimation ANIM_ZOOM_OUT   = RawAnimation.begin().thenPlay("zoom_out");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private final String acceptedAmmoType;
    private final int magazineSize;
    private final int reloadTime;
    private final int shootCooldown;
    private final String modelName;

    public GunItem(Properties properties, String acceptedAmmoType,
                   int magazineSize, int reloadTime, int shootCooldown,
                   String modelName) {
        super(properties);
        this.acceptedAmmoType = acceptedAmmoType;
        this.magazineSize = magazineSize;
        this.reloadTime = reloadTime;
        this.shootCooldown = shootCooldown;
        this.modelName = modelName;
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    // ── GeckoLib ───────────────────────────────────────────────────────────

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

        AnimationController<GunItem> controller =
                new AnimationController<>(this, "controller", 0,
                        state -> {
                            // Если сейчас доигрывает триггер (shoot/reload/zoom_in/zoom_out/shoot_zoom)
                            // — НЕ трогаем анимацию, даём GeckoLib довести её до конца.
                            if (state.getController().isPlayingTriggeredAnimation()) {
                                return PlayState.CONTINUE;
                            }

                            // Триггер закончился (или их не было) — решаем ЧТО держать
                            // на основе текущего NBT-флага Zooming.
                            ItemStack stack = state.getData(DataTickets.ITEMSTACK);
                            boolean zooming = stack != null
                                    && stack.getOrCreateTag().getBoolean("Zooming");

                            state.getController().setAnimation(zooming ? ANIM_ZOOM_IDLE : ANIM_IDLE);
                            return PlayState.CONTINUE;
                        });

        controller.triggerableAnim("shoot",      ANIM_SHOOT);
        controller.triggerableAnim("reload",     ANIM_RELOAD);
        controller.triggerableAnim("zoom_in",    ANIM_ZOOM_IN);
        controller.triggerableAnim("zoom_out",   ANIM_ZOOM_OUT);
        controller.triggerableAnim("shoot_zoom", ANIM_SHOOT_ZOOM);

        controllers.add(controller);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() { return cache; }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GunItemGeoRenderer renderer;
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null) renderer = new GunItemGeoRenderer(GunItem.this);
                return renderer;
            }
        });
    }

    // ── Полоска патронов ───────────────────────────────────────────────────

    @Override
    public boolean isBarVisible(ItemStack stack) { return true; }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0f * getCurrentAmmo(stack) / magazineSize);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        float pct = (float) getCurrentAmmo(stack) / magazineSize;
        if (pct > 0.5f) return 0x55FF55;
        if (pct > 0.25f) return 0xFFAA00;
        return 0xFF5555;
    }

    @Override
    public boolean isDamaged(ItemStack stack) { return false; }

    // ── Tooltip ────────────────────────────────────────────────────────────

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltip, TooltipFlag flag) {
        int ammo   = getCurrentAmmo(stack);
        int reload = getReloadTimer(stack);

        tooltip.add(Component.literal("§7Патроны: §e" + ammo + "§7/§e" + magazineSize));
        tooltip.add(Component.literal("§7Тип: §b" + acceptedAmmoType));

        if (reload > 0)
            tooltip.add(Component.literal(
                    "§cПерезарядка: " + String.format("%.1f", reload / 20.0f) + "с"));
        else if (ammo == 0)
            tooltip.add(Component.literal("§cМагазин пуст! [R] для перезарядки"));
    }

    // ── NBT ────────────────────────────────────────────────────────────────

    public int getCurrentAmmo(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        if (!tag.contains("CurrentAmmo")) tag.putInt("CurrentAmmo", 0);
        return tag.getInt("CurrentAmmo");
    }

    public void setCurrentAmmo(ItemStack stack, int ammo) {
        stack.getOrCreateTag().putInt("CurrentAmmo",
                Math.max(0, Math.min(ammo, magazineSize)));
    }

    public int getReloadTimer(ItemStack stack) {
        return stack.getOrCreateTag().getInt("ReloadTimer");
    }

    public int getCooldown(ItemStack stack) {
        return stack.getOrCreateTag().getInt("Cooldown");
    }

    // ── Патроны в инвентаре ────────────────────────────────────────────────

    public boolean acceptsAmmo(ItemStack ammoStack) {
        if (!(ammoStack.getItem() instanceof AmmoItem ammo)) return false;
        return ammo.getAmmoType().getId().equals(acceptedAmmoType);
    }

    public int countAmmoInInventory(Player player) {
        int total = 0;
        for (ItemStack s : player.getInventory().items)
            if (acceptsAmmo(s)) total += s.getCount();
        return total;
    }

    @Override
    public int getUseDuration(ItemStack stack) { return 72000; }

    @Override
    public net.minecraft.world.item.UseAnim getUseAnimation(ItemStack stack) {
        return net.minecraft.world.item.UseAnim.NONE;
    }

    // ── Перезарядка ────────────────────────────────────────────────────────

    public void startReload(ItemStack stack, Player player) {
        if (player.level().isClientSide) return;

        CompoundTag tag = stack.getOrCreateTag();
        if (tag.getInt("ReloadTimer") > 0) return;
        if (getCurrentAmmo(stack) >= magazineSize) return;
        if (countAmmoInInventory(player) <= 0) return;

        tag.putInt("ReloadTimer", reloadTime);
        // Перезарядка прерывает прицел — целиться во время неё нельзя.
        tag.putBoolean("Zooming", false);

        triggerAnim(player, GeoItem.getId(stack), "controller", "reload");

        if (player instanceof ServerPlayer sp)
            AmmoSyncPacket.sendToPlayer(sp, stack);
    }

    public void finishReload(ItemStack stack, Player player) {
        CompoundTag tag = stack.getOrCreateTag();
        int current = getCurrentAmmo(stack);
        int needed  = magazineSize - current;
        int taken   = 0;

        for (ItemStack s : player.getInventory().items) {
            if (taken >= needed) break;
            if (acceptsAmmo(s)) {
                if (!tag.contains("LoadedAmmo"))
                    tag.putString("LoadedAmmo",
                            net.minecraftforge.registries.ForgeRegistries.ITEMS
                                    .getKey(s.getItem()).toString());
                int canTake = Math.min(s.getCount(), needed - taken);
                s.shrink(canTake);
                taken += canTake;
            }
        }

        setCurrentAmmo(stack, current + taken);
        tag.putInt("ReloadTimer", 0);
        // Zooming уже false (выставлен в startReload) — после доигрывания
        // "reload" контроллер сам встанет в ANIM_IDLE через predicate.

        if (player instanceof ServerPlayer sp)
            AmmoSyncPacket.sendToPlayer(sp, stack);
    }

    public void reload(Player player, ItemStack stack) {
        startReload(stack, player);
    }

    // ── Выстрел ────────────────────────────────────────────────────────────

    public void shoot(Level level, Player player, ItemStack stack) {
        if (level.isClientSide) return;

        CompoundTag tag = stack.getOrCreateTag();
        if (tag.getInt("ReloadTimer") > 0) return;
        if (tag.getInt("Cooldown") > 0) return;

        int current = getCurrentAmmo(stack);
        if (current <= 0) return;

        AmmoItem ammoItem = getLoadedAmmo(stack);
        if (ammoItem == null) return;

        GunShootLogic.execute(player, stack, ammoItem);

        setCurrentAmmo(stack, current - 1);
        tag.putInt("Cooldown", shootCooldown);

        // Решаем какой клип выстрела играть — НО Zooming-флаг НЕ трогаем,
        // поэтому после доигрывания shoot/shoot_zoom predicate вернёт ТО ЖЕ
        // состояние (zoom_idle или idle), что было до выстрела.
        boolean isAiming = tag.getBoolean("Zooming");
        triggerAnim(player, GeoItem.getId(stack), "controller",
                isAiming ? "shoot_zoom" : "shoot");

        if (player instanceof ServerPlayer sp)
            AmmoSyncPacket.sendToPlayer(sp, stack);
    }

    private AmmoItem getLoadedAmmo(ItemStack stack) {
        String id = stack.getOrCreateTag().getString("LoadedAmmo");
        if (id.isEmpty()) return null;
        var item = net.minecraftforge.registries.ForgeRegistries.ITEMS
                .getValue(new net.minecraft.resources.ResourceLocation(id));
        return item instanceof AmmoItem a ? a : null;
    }

    // ── Use — ПКМ = прицел (зажми и держи) ────────────────────────────────

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return true;
    }

    // ── Тик — единственное место где меняется флаг Zooming ────────────────

    public void tick(ItemStack stack, Player player) {
        if (player.level().isClientSide) return;

        CompoundTag tag = stack.getOrCreateTag();

        // Перезарядка блокирует прицел полностью — пока она идёт,
        // не даём isAiming стать true, даже если игрок держит ПКМ.
        boolean reloading = tag.getInt("ReloadTimer") > 0;

        boolean isAiming = !reloading
                && player.isUsingItem()
                && player.getUseItem().getItem() == this;

        boolean wasAiming = tag.getBoolean("Zooming");

        if (isAiming && !wasAiming) {
            tag.putBoolean("Zooming", true);
            triggerAnim(player, GeoItem.getId(stack), "controller", "zoom_in");
            if (player instanceof ServerPlayer sp) AmmoSyncPacket.sendToPlayer(sp, stack);
        }

        if (!isAiming && wasAiming) {
            tag.putBoolean("Zooming", false);
            triggerAnim(player, GeoItem.getId(stack), "controller", "zoom_out");
            if (player instanceof ServerPlayer sp) AmmoSyncPacket.sendToPlayer(sp, stack);
        }

        int cooldown = tag.getInt("Cooldown");
        if (cooldown > 0) tag.putInt("Cooldown", cooldown - 1);

        int reload = tag.getInt("ReloadTimer");
        if (reload > 0) {
            tag.putInt("ReloadTimer", --reload);
            if (reload == 0) finishReload(stack, player);
        }
    }

    // ── Геттеры ────────────────────────────────────────────────────────────

    public String getModelName()        { return modelName; }
    public String getAcceptedAmmoType() { return acceptedAmmoType; }
    public int getMagazineSize()        { return magazineSize; }
    public int getReloadTime()          { return reloadTime; }
    public int getShootCooldown()       { return shootCooldown; }
}