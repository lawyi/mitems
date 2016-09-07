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
public class ItemAppleCoal extends ItemFood {

    public ItemAppleCoal()
    {
        super(5, 0.6F, false);
        this.setAlwaysEdible();
        this.setUnlocalizedName("appleCoal");
        this.setCreativeTab(CreativeTabsLoader.tabLawyi);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote) {
            // 防火
            player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2400, 3));
            // 失明
            player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100));
        }

        super.onFoodEaten(stack, worldIn, player);
    }
}
