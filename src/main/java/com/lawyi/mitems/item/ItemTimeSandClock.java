package com.lawyi.mitems.item;

import com.lawyi.mitems.creativetab.CreativeTabsLoader;
import net.minecraft.item.Item;

/**
 * Created by lawyi on 2016/9/6 0006.
 */
public class ItemTimeSandClock extends Item {

    public ItemTimeSandClock()
    {
        super();
        this.setUnlocalizedName("timeSandClock");
        this.setCreativeTab(CreativeTabsLoader.tabLawyi);
    }

}
