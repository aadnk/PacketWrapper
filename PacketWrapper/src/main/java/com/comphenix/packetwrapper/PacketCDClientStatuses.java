package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

/**
 * Sent when the client is ready to complete login and when the client is ready to respawn after death.
 * 
 * @author Kristian
 */
public class PacketCDClientStatuses extends AbstractPacket {
    public static final int ID = 205;
    
    /**
     * Enumeration of all the known payload values.
     * 
     * @author Kristian
     */
    public static class Payloads {
    	public static final int INITIAL_SPAWN = 0;
    	public static final int RESPAWN_AFTER_DEATH = 1;

    	private static final Payloads INSTANCE = new Payloads();
    	
    	public static Payloads getInstance() {
    		return INSTANCE;
    	}
    }
    
    public PacketCDClientStatuses() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public PacketCDClientStatuses(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve whether or not we're logging in or respawning.
     * @see {@link Payloads}.
     * @return The current Payload
    */
    public int getPayload() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set whether or not we're logging in or respawning.
     * @see {@link Payloads}.
     * @param value - new value.
    */
    public void setPayload(int value) {
        handle.getIntegers().write(0, value);
    }
}


