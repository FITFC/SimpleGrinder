package com.rumaruka.simplegrinder.common.tiles;

import com.rumaruka.simplegrinder.api.AbstractCustomRecipe;
import com.rumaruka.simplegrinder.common.container.GrinderContainer;
import com.rumaruka.simplegrinder.common.recipes.CrusherRecipe;
import com.rumaruka.simplegrinder.init.SGBlocks;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class  TileEntityCoalGrinder extends TileEntityAbstractGrinder {
    public TileEntityCoalGrinder() {
        super(SGBlocks.TILE_ENTITY_COAL_GRINDER.get(), CrusherRecipe.RECIPE_TYPE);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.coal_grinder");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new GrinderContainer(id,player,this,this.furnaceData);
    }
}
