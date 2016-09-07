package com.lawyi.mitems.common;

import com.lawyi.mitems.crafting.CraftingLoader;
import com.lawyi.mitems.creativetab.CreativeTabsLoader;
import com.lawyi.mitems.item.ItemLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by lawyi on 2016/9/1 0001.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event)
    {
        System.out.println("preInit");

        new CreativeTabsLoader(event);
        new ItemLoader(event);
    }

    public void init(FMLInitializationEvent event)
    {
        System.out.println("init");

        new CraftingLoader();
        new EventLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {
        System.out.println("postInit");
    }
}
