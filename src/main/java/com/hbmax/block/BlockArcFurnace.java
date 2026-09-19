package com.hbmax.block;

import com.hbmax.blockentity.BlockEntityArcFurnace;
import com.hbmax.registry.ModBlockEntities;
import com.hbmax.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class BlockArcFurnace extends BaseEntityBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public static final BooleanProperty HAS_RODS = BooleanProperty.create("rods");

    private final boolean isActive;

    public BlockArcFurnace(Properties props, boolean isActive) {
        super(props);
        this.isActive = isActive;
        registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(LIT, false)
                .setValue(HAS_RODS, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT, HAS_RODS);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState()
                .setValue(FACING, ctx.getHorizontalDirection().getOpposite())
                .setValue(LIT, false)
                .setValue(HAS_RODS, false);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof BlockEntityArcFurnace furnace) {
                NetworkHooks.openScreen((ServerPlayer) player, furnace, pos);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlockEntityArcFurnace(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide) {
            return createTickerHelper(type, ModBlockEntities.MACHINE_ARC_FURNACE.get(), BlockEntityArcFurnace::clientTick);
        }
        return createTickerHelper(type, ModBlockEntities.MACHINE_ARC_FURNACE.get(), BlockEntityArcFurnace::serverTick);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public static void updateBlockState(boolean isProcessing, boolean hasRods, Level level, BlockPos pos) {
        BlockState currentState = level.getBlockState(pos);
        Block block = currentState.getBlock();

        // Определяем нужный блок
        Block newBlock = isProcessing ?
                ModBlocks.MACHINE_ARC_FURNACE_ON.get() :
                ModBlocks.MACHINE_ARC_FURNACE_OFF.get();

        // Если блок уже правильный, не обновляем
        if (currentState.getBlock() == newBlock &&
                currentState.getValue(BlockArcFurnace.HAS_RODS) == hasRods) {
            return;
        }

        // Сохраняем TileEntity
        BlockEntity be = level.getBlockEntity(pos);

        // Меняем блок
        BlockState newState = newBlock.defaultBlockState()
                .setValue(BlockArcFurnace.FACING, currentState.getValue(BlockArcFurnace.FACING))
                .setValue(BlockArcFurnace.LIT, isProcessing)
                .setValue(BlockArcFurnace.HAS_RODS, hasRods);

        level.setBlock(pos, newState, 3);

        // Восстанавливаем TileEntity
        if (be != null && level.getBlockEntity(pos) != be) {
            be.setRemoved();
            level.setBlockEntity(be);
            be.setChanged();
        }
    }
}