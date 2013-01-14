package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Packet23EntityHeadLook extends AbstractPacket {
    public static final int ID = 35;
    
    public Packet23EntityHeadLook() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet23EntityHeadLook(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the entity ID.
     * @return The current Entity ID
    */
    public int getEntityId() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the entity ID.
     * @param value - new value.
    */
    public void setEntityId(int value) {
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
     * Retrieve the yaw of the entity's head.
     * @return The current yaw.
    */
    public float getHeadYaw() {
        return (handle.getBytes().read(0) * 360.F) / 256.0F;
    }
    
    /**
     * Set the yaw of the entity's head.
     * @param value - new yaw.
    */
    public void setHeadYaw(float value) {
        handle.getBytes().write(0, (byte) (value * 256.0F / 360.0F));
    }
}


