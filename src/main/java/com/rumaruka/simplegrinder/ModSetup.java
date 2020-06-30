package com.rumaruka.simplegrinder;

import com.rumaruka.simplegrinder.init.SGBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

import static com.rumaruka.simplegrinder.SimpleGrinder.MODID;

@Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {

    public static ItemGroup ITEM_GROUP= new ItemGroup(MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(SGBlocks.COALGRINDERBLOCK.get());
        }
    };
}
