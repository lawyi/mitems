package com.lawyi.mitems.crafting;

import com.lawyi.mitems.item.ItemLoader;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by lawyi on 2016/9/5 0005.
 */
public class CraftingLoader {

    public CraftingLoader()
    {
        registerRecipe();
        registerSmelting();
        registerFuel();
    }

    private static void registerRecipe()
    {
        // 金蛋
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.goldenEgg), new Object[]{
                "###", "#*#", "###", '#', Items.gold_nugget, '*', Items.egg
        });
        // 一捆烈焰棒
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.blazeRodGroup), new Object[]{
                "###", "###", "###", '#', Items.blaze_rod
        });
        // 红石苹果
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.appleRedstone), new Object[]{
                "###", "#*#", "###", '#', Items.redstone, '*', Items.apple
        });
        // 烈焰苹果
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.appleBlazeRod), new Object[]{
                "###", "#*#", "###", '#', Items.blaze_rod, '*', Items.apple
        });
        // 钻石苹果
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.appleDiamond), new Object[]{
                "###", "#*#", "###", '#', Items.diamond, '*', Items.apple
        });
        // 时光沙漏
        GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.timeSandClock), new Object[]{
                "313",
                "262",
                "415",
                '1', Blocks.wooden_slab,
                '2', Blocks.glass_pane,
                '3', Items.clock,
                '4', Blocks.diamond_block,
                '5', Blocks.emerald_block,
                '6', Blocks.sand
        });

    }

    private static void registerSmelting()
    {

        GameRegistry.addSmelting(new ItemStack(ItemLoader.goldenEgg), new ItemStack(Items.gold_ingot), 0.5F);
        GameRegistry.addSmelting(new ItemStack(ItemLoader.appleDiamond), new ItemStack(Items.diamond, 8), 0.5F);

    }

    private static void registerFuel()
    {
        GameRegistry.registerFuelHandler(new IFuelHandler() {
            @Override
            public int getBurnTime(ItemStack fuel)
            {
                return ItemLoader.blazeRodGroup != fuel.getItem() ? 0 : 25000;
            }
        });

        GameRegistry.registerFuelHandler(new IFuelHandler() {
            @Override
            public int getBurnTime(ItemStack fuel)
            {
                return ItemLoader.appleBlazeRod != fuel.getItem() ? 0 : 18000;
            }
        });
    }

}
