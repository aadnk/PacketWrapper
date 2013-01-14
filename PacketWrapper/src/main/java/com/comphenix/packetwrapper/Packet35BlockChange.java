package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet35BlockChange extends AbstractPacket {
    public static final int ID = 53;
    
    public Packet35BlockChange() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet35BlockChange(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve block X Coordinate.
     * @return The current X
    */
    public int getX() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set block X Coordinate.
     * @param value - new value.
    */
    public void setX(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve block Y Coordinate.
     * @return The current Y
    */
    public int getY() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Set block Y Coordinate.
     * @param value - new value.
    */
    public void setY(int value) {
        handle.getIntegers().write(1, value);
    }
    
    /**
     * Retrieve block Z Coordinate.
     * @return The current Z
    */
    public int getZ() {
        return handle.getIntegers().read(2);
    }
    
    /**
     * Set block Z Coordinate.
     * @param value - new value.
    */
    public void setZ(int value) {
        handle.getIntegers().write(2, value);
    }
    
    /**
     * Retrieve the new block type for the block.
     * @return The current Block Type
    */
    public short getBlockType() {
        return handle.getIntegers().read(3).shortValue();
    }
    
    /**
     * Set the new block type for the block.
     * @param value - new value.
    */
    public void setBlockType(short value) {
        handle.getIntegers().write(3, (int) value);
    }
    
    /**
     * Retrieve the new Metadata for the block.
     * @return The current Block Metadata
    */
    public byte getBlockMetadata() {
        return handle.getIntegers().read(4).byteValue();
    }
    
    /**
     * Set the new Metadata for the block.
     * @param value - new value.
    */
    public void setBlockMetadata(byte value) {
        handle.getIntegers().write(4, (int) value);
    }
}


