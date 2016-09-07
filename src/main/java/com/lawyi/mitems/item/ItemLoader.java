package com.lawyi.mitems.item;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by lawyi on 2016/9/1 0001.
 */
public class ItemLoader {

    public static Item goldenEgg = new ItemGoldenEgg();
    public static Item blazeRodGroup = new ItemBlazeRodGroup();
    public static Item timeSandClock = new ItemTimeSandClock();
    public static ItemFood appleRedstone = new ItemAppleRedstone();
    public static ItemFood appleBlazeRod = new ItemAppleBlazeRod();
    public static ItemFood appleDiamond = new ItemAppleDiamond();

    public ItemLoader(FMLPreInitializationEvent event)
    {
        register(goldenEgg, "golden_egg");
        register(blazeRodGroup, "blaze_rod_group");
        register(appleRedstone, "apple_redstone");
        register(appleBlazeRod, "apple_blaze_rod");
        register(appleDiamond, "apple_diamond");
        register(timeSandClock, "time_sand_clock");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerRender(goldenEgg);
        registerRender(blazeRodGroup);
        registerRender(appleRedstone);
        registerRender(appleBlazeRod);
        registerRender(appleDiamond);
        registerRender(timeSandClock);
    }

    private static void register(Item item, String name)
    {
        GameRegistry.registerItem(item, name);
    }

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        String name = GameData.getItemRegistry().getNameForObject(item).toString();
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name, "inventory"));
    }
}
