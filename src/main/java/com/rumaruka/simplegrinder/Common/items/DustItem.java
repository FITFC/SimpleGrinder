package com.rumaruka.simplegrinder.common.items;


import com.rumaruka.simplegrinder.ModSetup;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;

public class DustItem extends Item implements IItemProvider {


    public DustItem( ) {
        super(new Properties().group(ModSetup.ITEM_GROUP));
    }

    @Override
    public Item asItem() {
        return this;
    }
}
