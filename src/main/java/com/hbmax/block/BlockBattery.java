package com.hbmax.block;

import com.hbmax.blockentity.BlockEntityBattery;

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
import net.minecraft.world.level.block.RenderShape;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

import net.minecraft.world.phys.BlockHitResult;

import org.jetbrains.annotations.Nullable;

public class BlockBattery extends BaseEntityBlock {

    public static final DirectionProperty FACING =
            BlockStateProperties.HORIZONTAL_FACING;

    private final long capacity;

    public BlockBattery(
            BlockBehaviour.Properties props,
            long capacity
    ) {
        super(props);

        this.capacity = capacity;

        registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
        );
    }

    @Override
    protected void createBlockStateDefinition(
            StateDefinition.Builder<Block, BlockState> builder
    ) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {

        return defaultBlockState()
                .setValue(
                        FACING,
                        ctx.getHorizontalDirection().getOpposite()
                );
    }

    @Override
    public InteractionResult use(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hit
    ) {

        if (!level.isClientSide) {

            BlockEntity entity =
                    level.getBlockEntity(pos);

            if (entity instanceof BlockEntityBattery battery) {

                net.minecraftforge.network.NetworkHooks.openScreen(
                        (ServerPlayer) player,
                        battery,
                        pos
                );
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(
            BlockPos pos,
            BlockState state
    ) {

        return new BlockEntityBattery(
                pos,
                state
        );
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level,
            BlockState state,
            BlockEntityType<T> type
    ) {

        return level.isClientSide
                ? null
                : (lvl, pos, st, be) -> {

            if (be instanceof BlockEntityBattery battery) {

                BlockEntityBattery.tick(
                        lvl,
                        pos,
                        st,
                        battery
                );
            }
        };
    }
}