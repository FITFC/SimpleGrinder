package com.rumaruka.simplegrinder.common.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;

public class MachineCoreBlock extends Block {
    public MachineCoreBlock( ) {
        super(Properties.create(Material.ROCK));
    }


    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    

}
