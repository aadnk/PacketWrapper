package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.IntEnum;

public class Packet12Animation extends AbstractPacket {
    public static final int ID = 18;
    
    /**
     * Represents the different animations sent by notchian clients.
     * 
     * @author Kristian
     */
    public static class Animations extends IntEnum {
    	public static final int NO_ANIMATION = 0;
    	public static final int SWING_ARM = 1;
    	public static final int DAMAGE_ANIMATION = 2;
    	public static final int LEAVE_BED = 3;
    	public static final int EAT_FOOD = 5;
    	public static final int UNKNOWN = 102;
    	public static final int CROUCH = 104;
    	public static final int UNCROUCH = 105;
    	
		/**
		 * The singleton instance. Can also be retrieved from the parent class.
		 */
		private static Animations INSTANCE = new Animations();
    	
		/**
		 * Retrieve an instance of the Animation enum.
		 * @return Animation enum.
		 */
		public static Animations getInstance() {
			return INSTANCE;
		}
    }
    
    public Packet12Animation() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet12Animation(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the player ID.
     * @return The current EID
    */
    public int getEntityID() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the player ID.
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
     * Retrieve animation ID.
     * @return The current Animation
    */
    public byte getAnimation() {
        return handle.getIntegers().read(1).byteValue();
    }
    
    /**
     * Set animation ID.
     * @param value - new value.
    */
    public void setAnimation(byte value) {
        handle.getIntegers().write(1, (int) value);
    }
}


