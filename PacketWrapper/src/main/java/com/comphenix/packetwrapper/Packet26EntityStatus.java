package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Packet26EntityStatus extends AbstractPacket {
    public static final int ID = 38;
    
    public static class Status {
    	public static final int ENTITY_HURT = 2;
    	public static final int ENTITY_DEAD = 3;
    	public static final int WOLF_TAMING = 6;
    	public static final int WOLF_TAMED = 7;
    	public static final int WOLF_SHAKING_OFF_WATER = 8;
    	public static final int EATING_ACCEPTED = 9;
    	public static final int SHEEP_EATING_GRASS = 10;
    	
		/**
		 * The singleton instance. Can also be retrieved from the parent class.
		 */
		private static Status INSTANCE = new Status();
    	
		/**
		 * Retrieve an instance of the status enum.
		 * @return Status enum.
		 */
		public static Status getInstance() {
			return INSTANCE;
		}
    }
    
    public Packet26EntityStatus() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet26EntityStatus(PacketContainer packet) {
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
     * Set the entity ID.
     * @param value - new value.
    */
    public void setEntityId(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve entity status. See {@link Status}.
     * @return The current Entity Status
    */
    public int getEntityStatus() {
        return handle.getBytes().read(0).intValue();
    }
    
    /**
     * Set the entity status. See {@link Status}.
     * @param value - new value.
    */
    public void setEntityStatus(int value) {
        handle.getBytes().write(0, (byte) value);
    }
}


