package com.lawyi.mitems.item;

import com.lawyi.mitems.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by lawyi on 2016/9/5 0005.
 */
public class ItemAppleRedstone extends ItemFood {

    public ItemAppleRedstone()
    {
        super(5, 0.6F, false);
        this.setAlwaysEdible();
        this.setUnlocalizedName("appleRedstone");
        this.setCreativeTab(CreativeTabsLoader.tabLawyi);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote) {
            // 再生
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 600, 0));
            // 挖掘
            player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 3000, 1));
        }

        super.onFoodEaten(stack, worldIn, player);
    }
}
