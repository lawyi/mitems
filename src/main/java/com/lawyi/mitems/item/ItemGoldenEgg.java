package com.lawyi.mitems.item;


import com.lawyi.mitems.creativetab.CreativeTabsLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

/**
 * Created by lawyi on 2016/9/1 0001.
 */
public class ItemGoldenEgg extends Item {

    public ItemGoldenEgg()
    {
        super();
        this.setUnlocalizedName("goldenEgg");
        this.setCreativeTab(CreativeTabsLoader.tabLawyi);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {

        if (!playerIn.capabilities.isCreativeMode) {
            --itemStackIn.stackSize;
        }

        worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote) {
            worldIn.spawnEntityInWorld(new EntityEgg(worldIn, playerIn));
        }

        playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);

        return itemStackIn;
    }
}
