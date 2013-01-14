package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet03ChatMessage extends AbstractPacket {
    public static final int ID = 3;
    
    public Packet03ChatMessage() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet03ChatMessage(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve user input must be sanitized server-side.
     * @return The current Message
    */
    public String getMessage() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set user input must be sanitized server-side.
     * @param value - new value.
    */
    public void setMessage(String value) {
        handle.getStrings().write(0, value);
    }
}


