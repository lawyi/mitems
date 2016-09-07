package com.lawyi.mitems.item;

import com.lawyi.mitems.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by lawyi on 2016/9/7 0007.
 */
public class ItemAppleRedstoneEnhanced extends ItemFood {
    public ItemAppleRedstoneEnhanced()
    {
        super(10, 2F, false);
        this.setAlwaysEdible();
        this.setUnlocalizedName("appleRedstoneEnhanced");
        this.setCreativeTab(CreativeTabsLoader.tabLawyi);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote) {
            // 再生
            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 6000, 4));
            // 挖掘
            player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 6000, 4));
            // 移动速度
            player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 6000));
        }

        super.onFoodEaten(stack, worldIn, player);
    }
}
