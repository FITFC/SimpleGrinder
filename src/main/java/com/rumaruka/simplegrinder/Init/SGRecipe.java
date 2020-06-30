package com.rumaruka.simplegrinder.init;

import com.rumaruka.simplegrinder.data.CrushingRecipeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;


import java.util.function.Consumer;

public class SGRecipe extends RecipeProvider {
    public SGRecipe(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {


    }

    @Override
    public String getName() {
        return "SimpleGrinder Crushing recipe";
    }
}
