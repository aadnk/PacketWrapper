package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Packet13EntityAction extends AbstractPacket {
    public static final int ID = 19;
    
    public Packet13EntityAction() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet13EntityAction(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve player ID.
     * @return The current EID
    */
    public int getEntityID() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set player ID.
     * @param value - new value.
    */
    public void setEntityID(int value) {
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
     * Retrieve the ID of the action, see below..
     * @return The current Action ID
    */
    public byte getActionId() {
        return handle.getIntegers().read(1).byteValue();
    }
    
    /**
     * Set the ID of the action, see below..
     * @param value - new value.
    */
    public void setActionId(byte value) {
        handle.getIntegers().write(1, (int) value);
    }   
}


