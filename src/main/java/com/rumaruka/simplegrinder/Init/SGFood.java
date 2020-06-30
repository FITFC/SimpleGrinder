package com.rumaruka.simplegrinder.init;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SGFood {


    public static Food MASH_CARROT;
    public static Food MASH_POTATO;
    public static Food OMLETE;

    static {
        MASH_CARROT = new Food.Builder().hunger(4).effect(new EffectInstance(Effects.NIGHT_VISION,2000,1),1.0f).saturation(2.9f).build();
        MASH_POTATO = new Food.Builder().hunger(4).effect(new EffectInstance(Effects.STRENGTH,2000,1),1.0f).saturation(2.9f).build();
        OMLETE = new Food.Builder().hunger(2).saturation(2.6f).build();
    }
}
