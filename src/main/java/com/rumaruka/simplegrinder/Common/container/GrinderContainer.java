package com.rumaruka.simplegrinder.common.container;

import com.rumaruka.simplegrinder.api.AbstractCustomContainer;
import com.rumaruka.simplegrinder.api.AbstractCustomRecipe;
import com.rumaruka.simplegrinder.common.recipes.CrusherRecipe;
import com.rumaruka.simplegrinder.init.SGBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.IIntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GrinderContainer extends AbstractCustomContainer {
    public GrinderContainer(int id, PlayerInventory playerInventoryIn) {
        super(SGBlocks.GRINDER_CONTANER.get(), CrusherRecipe.RECIPE_TYPE, id, playerInventoryIn);
    }

    public GrinderContainer(int id, PlayerInventory playerInventoryIn, IInventory furnaceInventoryIn, IIntArray furnaceDataIn) {
        super(SGBlocks.GRINDER_CONTANER.get(),  CrusherRecipe.RECIPE_TYPE, id, playerInventoryIn, furnaceInventoryIn, furnaceDataIn);
    }


}
