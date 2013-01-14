package com.comphenix.packetwrapper;

import org.bukkit.inventory.ItemStack;

import com.comphenix.protocol.events.PacketContainer;

public class Packet0FPlayerBlockPlacement extends AbstractPacket {
    public static final int ID = 15;
    
    public Packet0FPlayerBlockPlacement() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet0FPlayerBlockPlacement(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the x block position.
     * @return The current X
    */
    public int getX() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the x block position.
     * @param value - new value.
    */
    public void setX(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the y block position.
     * @return The current Y
    */
    public byte getY() {
        return handle.getIntegers().read(1).byteValue();
    }
    
    /**
     * Set the y block position.
     * @param value - new value.
    */
    public void setY(byte value) {
        handle.getIntegers().write(1, (int) value);
    }
    
    /**
     * Retrieve the z block position.
     * @return The current Z
    */
    public int getZ() {
        return handle.getIntegers().read(2);
    }
    
    /**
     * Set the z block position.
     * @param value - new value.
    */
    public void setZ(int value) {
        handle.getIntegers().write(2, value);
    }
    
    /**
     * Retrieve the offset to use for block/item placement.
     * @return The current Direction
    */
    public byte getDirection() {
        return handle.getIntegers().read(3).byteValue();
    }
    
    /**
     * Set the offset to use for block/item placement.
     * @param value - new value.
    */
    public void setDirection(byte value) {
        handle.getIntegers().write(3, (int) value);
    }
    
    /**
     * Retrieve the currently held item.
     * @return The current Held item
    */
    public ItemStack getHeldItem() {
        return handle.getItemModifier().read(0);
    }
    
    /**
     * Set the currently held item.
     * @param value - new value.
    */
    public void setHeldItem(ItemStack value) {
        handle.getItemModifier().write(0, value);
    }
    
    /**
     * Retrieve the x position of the crosshair on the block.
     * @return The current cursor position X
    */
    public float getCursorPositionX() {
        return handle.getFloat().read(0);
    }
    
    /**
     * Set the x position of the crosshair on the block.
     * @param value - new value.
    */
    public void setCursorPositionX(float value) {
        handle.getFloat().write(0, value);
    }
    
    /**
     * Retrieve the y position of the cursor.
     * @return The current Cursor position Y
    */
    public float getCursorPositionY() {
        return handle.getFloat().read(1);
    }
    
    /**
     * Set the y position of the cursor.
     * @param value - new value.
    */
    public void setCursorPositionY(float value) {
        handle.getFloat().write(1, value);
    }
    
    /**
     * Retrieve the z position of the cursor.
     * @return The current Cursor position Z
    */
    public byte getCursorPositionZ() {
        return handle.getFloat().read(2).byteValue();
    }
    
    /**
     * Set the z position of the cursor.
     * @param value - new value.
    */
    public void setCursorPositionZ(byte value) {
        handle.getFloat().write(2, (float) value);
    }
}


