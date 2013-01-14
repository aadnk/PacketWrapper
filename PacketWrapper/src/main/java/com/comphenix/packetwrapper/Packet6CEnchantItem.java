package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet6CEnchantItem extends AbstractPacket {
    public static final int ID = 108;
    
    public Packet6CEnchantItem() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet6CEnchantItem(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the ID sent by open window.
     * @return The current Window ID
    */
    public byte getWindowId() {
        return handle.getIntegers().read(0).byteValue();
    }
    
    /**
     * Set the ID sent by open window.
     * @param value - new value.
    */
    public void setWindowId(byte value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve the position of the enchantment on the enchantment table window, starting with 0 as the top-most one.
     * @return The current Enchantment
    */
    public byte getEnchantment() {
        return handle.getIntegers().read(1).byteValue();
    }
    
    /**
     * Set the position of the enchantment on the enchantment table window, starting with 0 as the top-most one.
     * @param value - new value.
    */
    public void setEnchantment(byte value) {
        handle.getIntegers().write(1, (int) value);
    }
}


