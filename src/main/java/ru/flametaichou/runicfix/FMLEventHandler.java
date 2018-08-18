package ru.flametaichou.runicfix;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class FMLEventHandler {

    public static final FMLEventHandler INSTANCE = new FMLEventHandler();

    @SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event) {
        String craftingClass = event.crafting.getItem().getClass().getName().toLowerCase();
        if (craftingClass.contains("runic") && craftingClass.contains("key")) {
            boolean duplicateCraft = false;
            EntityPlayer player = event.player;
            for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
                ItemStack is = event.craftMatrix.getStackInSlot(i);
                if (is != null) {
                    String itemClass = is.getItem().getClass().getName().toLowerCase();
                    if (itemClass.contains("runic") && itemClass.contains("key")) {
                        event.craftMatrix.setInventorySlotContents(i, null);
                        duplicateCraft = true;
                        break;
                    }
                }
            }
            if (duplicateCraft) {
                for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
                    ItemStack is = player.inventory.getStackInSlot(i);
                    if (is != null) {
                        String itemClass = is.getItem().getClass().getName().toLowerCase();
                        if (itemClass.contains("runic") && itemClass.contains("key")) {
                            player.inventory.setInventorySlotContents(i, null);
                            break;
                        }
                    }
                }
            }
        }
    }
}
