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
public class ItemAppleBlazeRod extends ItemFood {

    public ItemAppleBlazeRod()
    {
        super(5, 0.6F, false);
        this.setAlwaysEdible();
        this.setUnlocalizedName("appleBlazeRod");
        this.setCreativeTab(CreativeTabsLoader.tabLawyi);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote) {
            // 防火
            player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 4));
            // 夜视
            player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 3000));
            // 自燃
            player.setFire(60);
        }

        super.onFoodEaten(stack, worldIn, player);
    }
}
