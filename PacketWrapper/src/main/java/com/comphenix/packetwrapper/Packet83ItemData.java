package com.comphenix.packetwrapper;

import javax.annotation.Nonnull;

import com.comphenix.protocol.events.PacketContainer;

public class Packet83ItemData extends AbstractPacket {
    public static final int ID = 131;
    
    public Packet83ItemData() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet83ItemData(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve type of item (item ID) being modified.
     * @return The current Item Type
    */
    public short getItemType() {
        return handle.getShorts().read(0);
    }
    
    /**
     * Set type of item (item ID) being modified.
     * @param value - new value.
    */
    public void setItemType(short value) {
        handle.getShorts().write(0, value);
    }
    
    /**
     * Retrieve the damage value of the item being modified.
     * @return The current damage value.
    */
    public short getItemId() {
        return handle.getShorts().read(1);
    }
    
    /**
     * Set the damage value of the item being modified.
     * @param value - new value.
    */
    public void setItemId(short value) {
        handle.getShorts().write(1, value);
    }
    
    /**
     * Retrieve length of following byte array.
     * @return The current Text length
    */
    public byte[] getData() {
        return handle.getByteArrays().read(0);
    }
    
    /**
     * Set length of following byte array.
     * @param value - new value.
    */
    public void setData(@Nonnull byte[] value) {
    	if (value == null)
    		throw new IllegalArgumentException("Array cannot be NULL.");
        handle.getByteArrays().write(0, value);
    }
}


