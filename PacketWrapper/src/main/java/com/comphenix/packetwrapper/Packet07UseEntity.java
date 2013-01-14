package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Packet07UseEntity extends AbstractPacket {
    public static final int ID = 7;
    
    public Packet07UseEntity() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet07UseEntity(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the entity ID of the player, which is ignored by the server.
     * @return The current user
    */
    public int getUserID() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Retrieve the entity of the player.
     * @param event - the world this event occured in.
     * @return The entity of the player.
     */
    public Entity getUser(World world) {
    	return handle.getEntityModifier(world).read(0);
    }
    
    /**
     * Retrieve the entity of the player.
     * @param event - the current packet event.
     * @return The entity of the player.
     */
    public Entity getUser(PacketEvent event) {
    	return getUser(event.getPlayer().getWorld());
    }
    
    /**
     * Set the entity ID of the player (ignored by the server).
     * @param value - new value.
    */
    public void setUserID(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the entity ID the player is interacting with.
     * @return The current Target
    */
    public int getTargetID() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Retrieve the entity the player is interacting with.
     * @param event - the world this event occured in.
     * @return The target entity.
     */
    public Entity getTarget(World world) {
    	return handle.getEntityModifier(world).read(1);
    }
    
    /**
     * Retrieve the entity the player is interacting with.
     * @param event - the current packet event.
     * @return The target entity.
     */
    public Entity getTarget(PacketEvent event) {
    	return getTarget(event.getPlayer().getWorld());
    }
    
    /**
     * Set the entity ID the player is interacting with.
     * @param value - new value.
    */
    public void setTargetID(int value) {
        handle.getIntegers().write(1, value);
    }
    
    /**
     * Retrieve the ID of the clicked mouse button.
     * <p>
     * This is one when the player is left-clicking and zero when right-clicking.
     * @return The current Mouse button
    */
    public int getMouseButton() {
        return handle.getIntegers().read(2);
    }
    
    /**
     * Set the ID of the clicked mouse button.
     * <p>
     * This is one when the player is left-clicking and zero when right-clicking.
     * @param value - new value.
    */
    public void setMouseButton(int value) {
        handle.getIntegers().write(2, (int) value);
    }
}


