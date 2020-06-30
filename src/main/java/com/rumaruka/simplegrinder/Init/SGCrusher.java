package com.rumaruka.simplegrinder.init;


import com.rumaruka.simplegrinder.api.CrusherRecipeSerializer;
import com.rumaruka.simplegrinder.common.recipes.CrusherRecipe;
import net.minecraft.item.crafting.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.rumaruka.simplegrinder.SimpleGrinder.MODID;

public class SGCrusher {



    private static final DeferredRegister<IRecipeSerializer<?>> CRAFT_CRUSHER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MODID);

    public static void setup(){
        CRAFT_CRUSHER.register(FMLJavaModLoadingContext.get().getModEventBus());

    }


    public  static CrusherRecipeSerializer<CrusherRecipe> CRUSHER = IRecipeSerializer.register("simplegrinder:grinder", new CrusherRecipeSerializer<>(CrusherRecipe::new, 100));
}
