package com.hbmax.blockentity;

import com.hbmax.block.HBlastFurnaceBlock;
import com.hbmax.menu.HMenuBlastFurnace;
import com.hbmax.recipe.BlastFurnaceRecipe;
import com.hbmax.recipe.BlastFurnaceRecipeManager;
import com.hbmax.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HBlastFurnaceBlockEntity extends BlockEntity implements MenuProvider {
    public static final int INPUT1_SLOT = 0;
    public static final int INPUT2_SLOT = 1;
    public static final int FUEL_SLOT = 2;
    public static final int OUTPUT_SLOT = 3;

    private final ItemStackHandler inventory = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            if (slot == OUTPUT_SLOT) return false;
            if (slot == FUEL_SLOT) {
                // Уголь и другие топлива
                return stack.is(Items.COAL) ||
                        stack.is(Items.CHARCOAL) ||
                        stack.is(Items.LAVA_BUCKET) ||
                        BlastFurnaceRecipeManager.getFuelHeat(stack) > 0;
            }
            return true;
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    private int fuelAmount = 0;
    private int maxFuel = 10000;
    private int fuelBurnTime = 0;
    private int heat = 0;
    private int maxHeat = 3000;
    private int cookTime = 0;
    private int cookTimeTotal = 0;
    private int requiredHeat = 0;

    private int getFuelPercentage(ItemStack stack) {
        if (stack.isEmpty()) return 0;

        Item item = stack.getItem();

        // Уголь (каменный и древесный) - 64 шт = 100%
        if (item == Items.COAL || item == Items.CHARCOAL) {
            return stack.getCount() * 100 / 64;
        }

        // Бурый уголь (если есть в твоём моде)
        // if (item == ModItems.BROWN_COAL.get()) {
        //     return stack.getCount() * 75 / 64;
        // }

        // Блок угля = 15%
        if (item == Blocks.COAL_BLOCK.asItem()) {
            return 15;
        }

        // Ведро лавы = 100%
        if (item == Items.LAVA_BUCKET) {
            return 100;
        }

        return 0;
    }

    protected final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> cookTime;
                case 1 -> cookTimeTotal;
                case 2 -> fuelAmount;
                case 3 -> maxFuel;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> cookTime = value;
                case 1 -> cookTimeTotal = value;
                case 2 -> fuelAmount = value;
                case 3 -> maxFuel = value;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };

    public HBlastFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BLAST_FURNACE_BE.get(), pos, state);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (level.isClientSide) return;

        boolean changed = false;
        RegistryAccess registryAccess = level.registryAccess();

        boolean wasLit = state.getValue(HBlastFurnaceBlock.LIT);
        boolean isLit = false;

        ItemStack fuel = inventory.getStackInSlot(FUEL_SLOT);
        ItemStack input1 = inventory.getStackInSlot(INPUT1_SLOT);
        ItemStack input2 = inventory.getStackInSlot(INPUT2_SLOT);
        ItemStack output = inventory.getStackInSlot(OUTPUT_SLOT);

        BlastFurnaceRecipe recipe = BlastFurnaceRecipeManager.getRecipe(level, input1, input2);

        // ===== ПОТРЕБЛЕНИЕ ТОПЛИВА =====
        if (fuelAmount < maxFuel && !fuel.isEmpty()) {
            int fuelValue = getFuelValue(fuel);
            if (fuelValue > 0) {
                fuelAmount = Math.min(maxFuel, fuelAmount + fuelValue);
                fuel.shrink(1);
                changed = true;
            }
        }

        // ===== РАСХОД ТОПЛИВА =====
        if (fuelAmount > 0) {
            fuelBurnTime++;
            if (fuelBurnTime >= 120) {
                fuelAmount = Math.max(0, fuelAmount - 156);
                fuelBurnTime = 0;
                changed = true;
            }
        }

        // ===== ПЛАВКА (без температуры) =====
        if (recipe != null && fuelAmount > 0) {
            ItemStack result = recipe.getResultItem(registryAccess);

            boolean canOutput = output.isEmpty() ||
                    (output.getItem() == result.getItem() &&
                            output.getCount() + result.getCount() <= output.getMaxStackSize());

            if (canOutput) {
                if (cookTimeTotal <= 0) {
                    cookTimeTotal = recipe.getProcessingTime();
                    changed = true;
                }

                if (cookTime < cookTimeTotal) {
                    cookTime++;
                    isLit = true;
                    changed = true;
                }

                if (cookTime >= cookTimeTotal) {
                    if (output.isEmpty()) {
                        inventory.setStackInSlot(OUTPUT_SLOT, result.copy());
                    } else {
                        output.grow(result.getCount());
                    }
                    inventory.extractItem(INPUT1_SLOT, 1, false);
                    inventory.extractItem(INPUT2_SLOT, 1, false);
                    cookTime = 0;
                    cookTimeTotal = 0; // сброс, чтобы на следующем крафте подтянулось заново (вдруг рецепт сменился)
                    changed = true;
                }
            } else {
                if (cookTime != 0) {
                    cookTime = 0;
                    cookTimeTotal = 0;
                    changed = true;
                }
            }
        } else {
            if (cookTime != 0 || cookTimeTotal != 0) {
                cookTime = 0;
                cookTimeTotal = 0;
                changed = true;
            }
            isLit = false;
        }

        if (wasLit != isLit) {
            level.setBlock(pos, state.setValue(HBlastFurnaceBlock.LIT, isLit), 3);
        }

        if (changed) {
            setChanged();
            level.sendBlockUpdated(pos, state, state, 3);
        }
    }

    private int getFuelValue(ItemStack stack) {
        if (stack.isEmpty()) return 0;

        Item item = stack.getItem();

        // 1 уголь = 1.5625% (100% / 64)
        // Используем множитель 100 для точности: 156 единиц = 1.5625%
        if (item == Items.COAL || item == Items.CHARCOAL) {
            return 156;  // 1.5625% * 100 = 156.25, округляем до 156
        }

        // Бурый уголь (75% за 64 шт) = 1.171875% за штуку
        // if (item == ModItems.BROWN_COAL.get()) {
        //     return 117;  // 1.171875% * 100 = 117.1875
        // }

        // Блок угля = 15%
        if (item == Blocks.COAL_BLOCK.asItem()) {
            return 1500;  // 15% * 100 = 1500
        }

        // Ведро лавы = 100%
        if (item == Items.LAVA_BUCKET) {
            return 10000;  // 100% * 100 = 10000
        }

        return 0;
    }

    public void drops() {
        SimpleContainer container = new SimpleContainer(inventory.getSlots());
        for (int i = 0; i < inventory.getSlots(); i++) {
            container.setItem(i, inventory.getStackInSlot(i));
        }
        Containers.dropContents(level, worldPosition, container);
    }

    public static boolean isItemFuel(ItemStack stack) {
        return stack.is(Items.COAL) || stack.is(Items.CHARCOAL) ||
                stack.is(Items.LAVA_BUCKET) || BlastFurnaceRecipeManager.getFuelHeat(stack) > 0;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> inventory);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", inventory.serializeNBT());
        tag.putInt("heat", heat);
        tag.putInt("cookTime", cookTime);
        tag.putInt("requiredHeat", requiredHeat);
        tag.putInt("cookTimeTotal", cookTimeTotal);
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        inventory.deserializeNBT(tag.getCompound("inventory"));
        heat = tag.getInt("heat");
        cookTime = tag.getInt("cookTime");
        requiredHeat = tag.getInt("requiredHeat");
        cookTimeTotal = tag.getInt("cookTimeTotal");
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.hbmax.blast_furnace");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new HMenuBlastFurnace(id, inventory, this, this.data);
    }
}