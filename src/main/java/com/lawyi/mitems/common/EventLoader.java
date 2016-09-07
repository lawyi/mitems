package com.lawyi.mitems.common;

import com.lawyi.mitems.item.ItemTimeSandClock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ListIterator;

/**
 * Created by lawyi on 2016/9/5 0005.
 */
public class EventLoader {

    public Item keepItem = new ItemTimeSandClock();

    public EventLoader()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onPlayerDropsEvent(PlayerDropsEvent event)
    {
        if (event.entityPlayer == null || event.entityPlayer instanceof FakePlayer || event.isCanceled()) {
            return;
        }
        if (event.entityPlayer.worldObj.getGameRules().getBoolean("keepInventory")) {
            return;
        }

        ListIterator<EntityItem> iter = event.drops.listIterator();
        if (checkeepInventory(iter)) {

            iter = event.drops.listIterator();
            keepInventory(iter, event);
        }
    }



    private void keepInventory(ListIterator<EntityItem> iter, PlayerDropsEvent event)
    {

        Boolean flag = true;
        while (iter.hasNext()) {
            EntityItem ei = iter.next();
            ItemStack item = ei.getEntityItem();

            if (iskeepItem(item) && flag) {
                --item.stackSize;
                if (item.stackSize > 0) {
                    if (addToPlayerInventory(event.entityPlayer, item)) {
                        iter.remove();
                    }
                }
                flag = false;
            } else {
                if (addToPlayerInventory(event.entityPlayer, item)) {
                    iter.remove();
                }
            }
        }
    }

    private boolean checkeepInventory(ListIterator<EntityItem> iter)
    {
        while (iter.hasNext()) {
            EntityItem ei = iter.next();
            ItemStack item = ei.getEntityItem();

            if (iskeepItem(item)) {
                return true;
            }
        }

        return false;
    }

    private boolean iskeepItem(ItemStack item)
    {
        return item.getUnlocalizedName().equals(keepItem.getUnlocalizedName());
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone evt)
    {
        if (!evt.wasDeath || evt.isCanceled()) {
            return;
        }
        if (evt.original == null || evt.entityPlayer == null || evt.entityPlayer instanceof FakePlayer) {
            return;
        }
        if (evt.entityPlayer.worldObj.getGameRules().getBoolean("keepInventory")) {
            return;
        }

        for (int i = 0; i < evt.original.inventory.mainInventory.length; i++) {
            ItemStack item = evt.original.inventory.mainInventory[i];
            if (addToPlayerInventory(evt.entityPlayer, item)) {
                evt.original.inventory.mainInventory[i] = null;
            }
        }

        for (int i = 0; i < evt.original.inventory.armorInventory.length; i++) {
            ItemStack item = evt.original.inventory.armorInventory[i];
            if (addToPlayerInventory(evt.entityPlayer, item)) {
                evt.original.inventory.armorInventory[i] = null;
            }
        }
    }

    private boolean addToPlayerInventory(EntityPlayer entityPlayer, ItemStack item)
    {
        if (item == null || entityPlayer == null) {
            return false;
        }
        if (item.getItem() instanceof ItemArmor) {
            ItemArmor arm = (ItemArmor) item.getItem();
            int index = 3 - arm.armorType;
            if (entityPlayer.inventory.armorItemInSlot(index) == null) {
                entityPlayer.inventory.armorInventory[index] = item;
                return true;
            }
        }

        InventoryPlayer inv = entityPlayer.inventory;
        for (int i = 0; i < inv.mainInventory.length; i++) {
            if (inv.mainInventory[i] == null) {
                inv.mainInventory[i] = item.copy();
                return true;
            }
        }

        return false;
    }

}
