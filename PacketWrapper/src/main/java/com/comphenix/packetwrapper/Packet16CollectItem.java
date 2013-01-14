package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

/**
 * Sent by the server when an iten stack is collected from the ground. This packet simply
 * initiates the collect item animation, nothing more.
 * 
 * @author Kristian
 */
public class Packet16CollectItem extends AbstractPacket {
    public static final int ID = 22;
    
    public Packet16CollectItem() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet16CollectItem(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the entity ID of the item we collected.
     * @return The current collected entity ID.
    */
    public int getCollectedEntityID() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Retrieve the item stack that has been collected.
     * @param world - the current world of the item stack.
     * @return The item stack entity.
     */
    public Entity getCollectedEntity(World world) {
    	return handle.getEntityModifier(world).read(0);
    }

    /**
     * Retrieve the item stack that has been collected.
     * @param event - the packet event.
     * @return The item stack entity.
     */
    public Entity getCollectedEntity(PacketEvent event) {
    	return getCollectedEntity(event.getPlayer().getWorld());
    }
    
    /**
     * Set the entity ID of the item we collected.
     * @param value - new value.
    */
    public void setCollectedEntityID(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the entity ID of the player that collected the item.
     * @return The current Collector EID
    */
    public int getCollectorEntityID() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Set the entity ID of the player that collected the item.
     * @param value - new value.
    */
    public void setCollectorEntityID(int value) {
        handle.getIntegers().write(1, value);
    }
    
    /**
     * Retrieve the player that has collected the item.
     * @param world - the current world of the player.
     * @return The player.
     */
    public Entity getCollectorEntity(World world) {
    	return handle.getEntityModifier(world).read(1);
    }

    /**
     * Retrieve the player that has collected the item.
     * @param event - the packet event.
     * @return The player.
     */
    public Entity getCollectorEntity(PacketEvent event) {
    	return getCollectorEntity(event.getPlayer().getWorld());
    }
}


