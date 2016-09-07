package com.lawyi.mitems.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by lawyi on 2016/9/5 0005.
 */
public class CreativeTabsLoader {

    public static CreativeTabs tabLawyi;

    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
        tabLawyi = new CreativeTabsLawyi();
    }
}
