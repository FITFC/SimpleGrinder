package com.rumaruka.simplegrinder;


import com.rumaruka.simplegrinder.data.DataGen;
import com.rumaruka.simplegrinder.init.SGBlocks;
import com.rumaruka.simplegrinder.init.SGCrusher;
import com.rumaruka.simplegrinder.init.SGItems;
import com.rumaruka.simplegrinder.init.SGRecipe;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static com.rumaruka.simplegrinder.SimpleGrinder.MODID;

@Mod(SimpleGrinder.MODID)
public class SimpleGrinder {
    public static final String MODID ="simplegrinder";




    public SimpleGrinder() {
        SGBlocks.setup();
        SGItems.setup();

        SGCrusher.setup();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::init);
    }


}
