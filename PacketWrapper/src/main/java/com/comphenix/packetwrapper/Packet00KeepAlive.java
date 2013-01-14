package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

/**
 * Two-Way.
 * 
 * @author Kristian
 */
public class Packet00KeepAlive extends AbstractPacket {
    public static final int ID = 0;
    
    public Packet00KeepAlive() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet00KeepAlive(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the server-generated random ID.
     * @return The current Keep-alive ID
    */
    public int getKeepAliveId() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the server-generated random id.
     * @param value - new value.
    */
    public void setKeepAliveId(int value) {
        handle.getIntegers().write(0, value);
    }
}

