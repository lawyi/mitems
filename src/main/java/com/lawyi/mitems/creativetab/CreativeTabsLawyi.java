package com.lawyi.mitems.creativetab;

import com.lawyi.mitems.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by lawyi on 2016/9/5 0005.
 */
public class CreativeTabsLawyi extends CreativeTabs {

    public CreativeTabsLawyi()
    {
        super("lawyi");
    }

    @Override
    public Item getTabIconItem()
    {
        return ItemLoader.goldenEgg;
    }
}
