package com.comphenix.packetwrapper;

import javax.annotation.Nonnull;

import com.comphenix.protocol.events.PacketContainer;

public class Packet82UpdateSign extends AbstractPacket {
    public static final int ID = 130;
    
    public Packet82UpdateSign() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet82UpdateSign(PacketContainer packet) {
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
    public short getY() {
        return handle.getIntegers().read(1).shortValue();
    }
    
    /**
     * Set block Y Coordinate.
     * @param value - new value.
    */
    public void setY(short value) {
        handle.getIntegers().write(1, (int) value);
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
     * Retrieve the lines of text represented by a four-element String array.
     * @return The current lines.
    */
    public String[] getLines() {
        return handle.getStringArrays().read(0);
    }
    
    /**
     * Set the lines of text represented by a four-element String array..
     * @param value - new value.
    */
    public void setLines(@Nonnull String[] lines) {
    	if (lines == null)
    		throw new IllegalArgumentException("Array cannot be NULL.");
    	if (lines.length != 4)
    		throw new IllegalArgumentException("The lines array must be four elements long.");
        handle.getStringArrays().write(0, lines);
    }
}

