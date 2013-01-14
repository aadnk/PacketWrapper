package com.comphenix.packetwrapper;

import org.bukkit.inventory.ItemStack;

import com.comphenix.protocol.events.PacketContainer;

public class Packet68SetWindowItems extends AbstractPacket {
    public static final int ID = 104;
    
    public Packet68SetWindowItems() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet68SetWindowItems(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the ID of the window which is being updated. 
     * <p>
     * Use 0 for the player inventory.
     * @return The current Window id
    */
    public byte getWindowId() {
        return handle.getIntegers().read(0).byteValue();
    }
    
    /**
     * Set the ID of the window which is being updated. 
     * <p>
     * Use 0 for the player inventory.
     * @param value - new value.
    */
    public void setWindowId(byte value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve the items in the inventory indexed by slot index.
     * @return The items that will fill the inventory.
    */
    public ItemStack[] getItems() {
        return handle.getItemArrayModifier().read(0);
    }
    
    /**
     * Set the items in the inventory indexed by slot index.
     * @param value - new value.
    */
    public void setItems(ItemStack[] value) {
        handle.getItemArrayModifier().write(0, value);
    }
}


