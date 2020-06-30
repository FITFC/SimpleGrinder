package com.rumaruka.simplegrinder.data;


import com.google.gson.JsonObject;
import com.rumaruka.simplegrinder.api.AbstractCustomRecipe;
import com.rumaruka.simplegrinder.api.CrusherRecipeSerializer;
import com.rumaruka.simplegrinder.init.SGCrusher;
import net.minecraft.advancements.Advancement;

import net.minecraft.data.IFinishedRecipe;
import net.minecraft.item.Item;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class CrushingRecipeBuilder {



    private final Item result;
    private final Ingredient ingredient;
    private final float experience;
    private final int cookingTime;
    private  final int count ;

    private final Advancement.Builder advancementBuilder = Advancement.Builder.builder();
    private String group;
    private final CrusherRecipeSerializer<?> recipeSerializer;

    private CrushingRecipeBuilder(IItemProvider resultIn, Ingredient ingredientIn, float experienceIn, int cookingTimeIn, int count, CrusherRecipeSerializer<?> serializer) {
        this.result = resultIn.asItem();
        this.ingredient = ingredientIn;
        this.experience = experienceIn;
        this.cookingTime = cookingTimeIn;
        this.count = count;
        this.recipeSerializer = serializer;
    }
    private CrushingRecipeBuilder(ItemStack resultIn, Ingredient ingredientIn, float experienceIn, int cookingTimeIn, int count, CrusherRecipeSerializer<?> serializer) {
        this.result = resultIn.getItem();
        this.ingredient = ingredientIn;
        this.experience = experienceIn;
        this.cookingTime = cookingTimeIn;
        this.count = count;
        this.recipeSerializer = serializer;
    }
    public static CrushingRecipeBuilder crusherRecipe(Ingredient ingredientIn, IItemProvider resultIn,  int count,float experienceIn, int cookingTimeIn) {
        return new CrushingRecipeBuilder(resultIn, ingredientIn, experienceIn, cookingTimeIn, count, SGCrusher.CRUSHER);
    }


    public static CrushingRecipeBuilder crusherRecipe(Ingredient ingredientIn, ItemStack resultIn, int count,float experienceIn, int cookingTimeIn) {
        return new CrushingRecipeBuilder(resultIn, ingredientIn, experienceIn, cookingTimeIn, count, SGCrusher.CRUSHER);
    }


    public void build(Consumer<IFinishedRecipe> consumerIn) {
        this.build(consumerIn, Registry.ITEM.getKey(this.result));
    }

    public void build(Consumer<IFinishedRecipe> consumerIn, String save) {
        ResourceLocation resourcelocation = Registry.ITEM.getKey(this.result);
        ResourceLocation resourcelocation1 = new ResourceLocation(save);
        if (resourcelocation1.equals(resourcelocation)) {
            throw new IllegalStateException("Recipe " + resourcelocation1 + " should remove its 'save' argument");
        } else {
            this.build(consumerIn, resourcelocation1);
        }
    }

    public void build(Consumer<IFinishedRecipe> consumerIn, ResourceLocation id) {
        this.validate(id);
        consumerIn.accept(new CrushingRecipeBuilder.Result(id, this.group == null ? "" : this.group, this.ingredient, this.result, this.count, this.experience, this.cookingTime, this.advancementBuilder, new ResourceLocation(id.getNamespace(), "recipes/" + this.result.getGroup().getPath() + "/" + id.getPath()), this.recipeSerializer));
    }

    /**
     * Makes sure that this obtainable.
     */
    private void validate(ResourceLocation id) {
        if (this.advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }

    public static class Result implements IFinishedRecipe {
        private final ResourceLocation id;
        private final String group;
        private final Ingredient ingredient;
        private final Item result;
        private  final int count ;
        private final float experience;
        private final int cookingTime;

        private final IRecipeSerializer<? extends AbstractCustomRecipe> serializer;

        public Result(ResourceLocation idIn, String groupIn, Ingredient ingredientIn, Item resultIn, int count, float experienceIn, int cookingTimeIn, Advancement.Builder advancementBuilderIn, ResourceLocation advancementIdIn, IRecipeSerializer<? extends AbstractCustomRecipe> serializerIn) {
            this.id = idIn;
            this.group = groupIn;
            this.ingredient = ingredientIn;
            this.result = resultIn;
            this.count = count;
            this.experience = experienceIn;
            this.cookingTime = cookingTimeIn;

            this.serializer = serializerIn;
        }

        public void serialize(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }

            json.add("ingredient", this.ingredient.serialize());
            JsonObject jsonobject1 = new JsonObject();
            jsonobject1.addProperty("item", Registry.ITEM.getKey(this.result).toString());
            if (this.count >= 1) {
                jsonobject1.addProperty("count", this.count);
            }

            json.add("result", jsonobject1);
            json.addProperty("experience", this.experience);
            json.addProperty("cookingtime", this.cookingTime);
        }

        public IRecipeSerializer<?> getSerializer() {
            return this.serializer;
        }

        @Nullable
        @Override
        public JsonObject getAdvancementJson() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementID() {
            return null;
        }

        /**
         * Gets the ID for the recipe.
         */
        public ResourceLocation getID() {
            return this.id;
        }



    }




}
