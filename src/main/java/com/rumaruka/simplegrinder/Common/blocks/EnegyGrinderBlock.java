package com.rumaruka.simplegrinder.common.blocks;

import net.minecraft.block.ContainerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class EnegyGrinderBlock extends ContainerBlock {
    public EnegyGrinderBlock() {
        super(Properties.create(Material.ANVIL));
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return null;
    }
}
