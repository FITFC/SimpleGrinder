package com.rumaruka.simplegrinder.init;

import com.rumaruka.simplegrinder.common.items.*;
import net.minecraft.item.Food;
import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.rumaruka.simplegrinder.SimpleGrinder.MODID;

public class SGItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);



    public static void setup(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<DustItem> IRON_DUST = ITEMS.register("dust_iron", DustItem::new);
    public static final RegistryObject<DustItem> GOLD_DUST = ITEMS.register("dust_gold", DustItem::new);
    public static final RegistryObject<FlourItem> FLOUR = ITEMS.register("flour", FlourItem::new);

     public static final RegistryObject<MashPotatoItem> MASH_POTATO = ITEMS.register("mash_potato", MashPotatoItem::new);
     public static final RegistryObject<MashCarrotItem> MASH_CARROT = ITEMS.register("mash_carrot", MashCarrotItem::new);
     public static final RegistryObject<OmleteItem> OMLETE = ITEMS.register("omlete", OmleteItem::new);


}
