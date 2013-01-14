package com.comphenix.packetwrapper;

import org.bukkit.inventory.ItemStack;

import com.comphenix.protocol.events.PacketContainer;

public class Packet6BCreativeInventoryAction extends AbstractPacket {
    public static final int ID = 107;
    
    public Packet6BCreativeInventoryAction() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet6BCreativeInventoryAction(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the inventory slot index.
     * @return The current Slot
    */
    public short getSlot() {
        return handle.getIntegers().read(0).shortValue();
    }
    
    /**
     * Set the inventory slot index.
     * @param value - new value.
    */
    public void setSlot(short value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve the clicked item stack.
     * @return The current Clicked item
    */
    public ItemStack getClickedItem() {
        return handle.getItemModifier().read(0);
    }
    
    /**
     * Set the clicked item stack.
     * @param value - new value.
    */
    public void setClickedItem(ItemStack value) {
        handle.getItemModifier().write(0, value);
    }
}


