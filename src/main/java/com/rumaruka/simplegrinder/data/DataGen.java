package com.rumaruka.simplegrinder.data;

import com.rumaruka.simplegrinder.init.SGRecipe;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent evt) {
        if (evt.includeServer()) {
            evt.getGenerator().addProvider(new SGRecipe(evt.getGenerator()));

        }
    }
}
