package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Packet37BlockBreakAnimation extends AbstractPacket {
    public static final int ID = 55;
    
    public Packet37BlockBreakAnimation() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet37BlockBreakAnimation(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the entity breaking the block.
     * @return The current EID?
    */
    public int getEntityID() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the entity breaking the block.
     * @param value - new value.
    */
    public void setEntityID(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the entity.
     * @param world - the current world of the entity.
     * @return The entity.
     */
    public Entity getEntity(World world) {
    	return handle.getEntityModifier(world).read(0);
    }

    /**
     * Retrieve the entity.
     * @param event - the packet event.
     * @return The entity.
     */
    public Entity getEntity(PacketEvent event) {
    	return getEntity(event.getPlayer().getWorld());
    }
    
    /**
     * Retrieve the x axis of the block coordinate.
     * @return The current X
    */
    public int getX() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Set the x axis of the block coordinate.
     * @param value - new value.
    */
    public void setX(int value) {
        handle.getIntegers().write(1, value);
    }
    
    /**
     * Retrieve the y axis of the block coordinate.
     * @return The current Y
    */
    public int getY() {
        return handle.getIntegers().read(2);
    }
    
    /**
     * Set the y axis of the block coordinate.
     * @param value - new value.
    */
    public void setY(int value) {
        handle.getIntegers().write(2, value);
    }
    
    /**
     * Retrieve the z axis of the block coordinate.
     * @return The current Z
    */
    public int getZ() {
        return handle.getIntegers().read(3);
    }
    
    /**
     * Set the z axis of the block coordinate.
     * @param value - new value.
    */
    public void setZ(int value) {
        handle.getIntegers().write(3, value);
    }
    
    /**
     * Retrieve how far destroyed this block is.
     * @return The current Destroy Stage
    */
    public byte getDestroyStage() {
        return handle.getIntegers().read(4).byteValue();
    }
    
    /**
     * Set how far destroyed this block is.
     * @param value - new value.
    */
    public void setDestroyStage(byte value) {
        handle.getIntegers().write(4, (int) value);
    }
}

