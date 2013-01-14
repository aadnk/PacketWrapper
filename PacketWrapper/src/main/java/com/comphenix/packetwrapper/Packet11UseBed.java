package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Packet11UseBed extends AbstractPacket {
    public static final int ID = 17;
    
    public Packet11UseBed() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet11UseBed(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve player ID.
     * @return The current Entity ID
    */
    public int getEntityId() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set player ID.
     * @param value - new value.
    */
    public void setEntityId(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the player's entity object.
     * @param world - the word the player has joined.
     * @return The player's entity.
     */
    public Entity getEntity(World world) {
    	return handle.getEntityModifier(world).read(0);
    }

    /**
     * Retrieve the player's entity object.
     * @param event - the packet event.
     * @return The player's entity.
     */
    public Entity getEntity(PacketEvent event) {
    	return getEntity(event.getPlayer().getWorld());
    }
    
    /**
     * Retrieve bed headboard X as block coordinate.
     * @return The current X coordinate
    */
    public int getX() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Set bed headboard X as block coordinate.
     * @param value - new value.
    */
    public void setX(int value) {
        handle.getIntegers().write(1, value);
    }
    
    /**
     * Retrieve bed headboard Y as block coordinate.
     * @return The current Y coordinate
    */
    public byte getY() {
        return handle.getIntegers().read(2).byteValue();
    }
    
    /**
     * Set bed headboard Y as block coordinate.
     * @param value - new value.
    */
    public void setY(byte value) {
        handle.getIntegers().write(2, (int) value);
    }
    
    /**
     * Retrieve bed headboard Z as block coordinate.
     * @return The current Z coordinate
    */
    public int getZ() {
        return handle.getIntegers().read(3);
    }
    
    /**
     * Set bed headboard Z as block coordinate.
     * @param value - new value.
    */
    public void setZ(int value) {
        handle.getIntegers().write(3, value);
    }
}


