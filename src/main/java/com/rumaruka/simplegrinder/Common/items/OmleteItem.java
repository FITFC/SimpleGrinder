package com.rumaruka.simplegrinder.common.items;


import com.rumaruka.simplegrinder.ModSetup;
import com.rumaruka.simplegrinder.init.SGFood;
import net.minecraft.item.Item;

public class OmleteItem extends Item {


    public OmleteItem( ) {
        super(new Properties().group(ModSetup.ITEM_GROUP).food(SGFood.OMLETE));
    }
}
