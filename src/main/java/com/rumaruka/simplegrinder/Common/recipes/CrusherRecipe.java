package com.rumaruka.simplegrinder.common.recipes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.rumaruka.simplegrinder.api.AbstractCustomRecipe;
import com.rumaruka.simplegrinder.init.SGBlocks;
import com.rumaruka.simplegrinder.init.SGCrusher;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class CrusherRecipe  extends AbstractCustomRecipe {
    public static final IRecipeType<CrusherRecipe> RECIPE_TYPE = new IRecipeType<CrusherRecipe>() {
        @Override
        public String toString() {
            return "simplegrinder:grinder";
        }
    };

    public CrusherRecipe(ResourceLocation idIn, String groupIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
        super(RECIPE_TYPE, idIn, groupIn, ingredientIn, resultIn, experienceIn, cookTimeIn);
    }

    public ItemStack getIcon() {
        return new ItemStack(SGBlocks.COALGRINDERBLOCK.get());
    }

    public IRecipeSerializer<?> getSerializer() {
        return SGCrusher.CRUSHER;
    }



}
