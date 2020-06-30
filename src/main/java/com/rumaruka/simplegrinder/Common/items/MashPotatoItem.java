package com.rumaruka.simplegrinder.common.items;


import com.rumaruka.simplegrinder.ModSetup;
import com.rumaruka.simplegrinder.init.SGFood;
import net.minecraft.item.Item;

public class MashPotatoItem extends Item {


    public MashPotatoItem( ) {
        super(new Properties().group(ModSetup.ITEM_GROUP).food(SGFood.MASH_POTATO));
    }
}
