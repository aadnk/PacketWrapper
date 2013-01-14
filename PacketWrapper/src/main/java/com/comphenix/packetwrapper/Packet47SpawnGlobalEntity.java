package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet47SpawnGlobalEntity extends AbstractPacket {
    public static final int ID = 71;
    
    public Packet47SpawnGlobalEntity() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet47SpawnGlobalEntity(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the entity ID of the thunderbolt.
     * @return The current Entity ID
    */
    public int getEntityId() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the entity ID of the thunderbolt.
     * @param value - new value.
    */
    public void setEntityId(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the global entity type.
     * <p>
     * Currently always 1 for thunderbolt..
     * @return The current Type
    */
    public byte getType() {
        return handle.getIntegers().read(4).byteValue();
    }
    
    /**
     * Set the global entity type.
     * <p>
     * Currently always 1 for thunderbolt..
     * @param value - new value.
    */
    public void setType(byte value) {
        handle.getIntegers().write(4, (int) value);
    }
    
    /**
     * Retrieve the x coordinate of the thunderbolt.
     * @return The current X
    */
    public double getX() {
        return handle.getIntegers().read(1) / 32.0D;
    }
    
    /**
     * Set the x coordinate of the thunderbolt.
     * @param value - new value.
    */
    public void setX(double value) {
        handle.getIntegers().write(1, (int) (value * 32.0D));
    }
    
    /**
     * Retrieve the y coordinate of the thunderbolt.
     * @return The current y
    */
    public double getY() {
        return handle.getIntegers().read(2) / 32.0D;
    }
    
    /**
     * Set the y coordinate of the thunderbolt.
     * @param value - new value.
    */
    public void setY(double value) {
        handle.getIntegers().write(2, (int) (value * 32.0D));
    }
    
    /**
     * Retrieve the z coordinate of the thunderbolt.
     * @return The current z
    */
    public double getZ() {
        return handle.getIntegers().read(3) / 32.0D;
    }
    
    /**
     * Set the z coordinate of the thunderbolt.
     * @param value - new value.
    */
    public void setZ(double value) {
        handle.getIntegers().write(3, (int) (value * 32.0D));
    }
}


