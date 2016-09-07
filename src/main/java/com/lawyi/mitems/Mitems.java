package com.lawyi.mitems;

import com.lawyi.mitems.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by lawyi on 2016/9/1 0001.
 */
@Mod(modid = Mitems.MODID, name = Mitems.NAME, version = Mitems.VERSION, acceptedMinecraftVersions = "1.8.9")
public class Mitems {

    public static final String MODID = "mitems";
    public static final String NAME = "More Useful Items";
    public static final String VERSION = "1.0.0";

    @Instance(Mitems.MODID)
    public static Mitems instance;

    @SidedProxy(clientSide = "com.lawyi.mitems.client.ClientProxy", serverSide = "com.lawyi.mitems.common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
