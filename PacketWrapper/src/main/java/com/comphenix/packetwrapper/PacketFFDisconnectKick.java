package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class PacketFFDisconnectKick extends AbstractPacket {
    public static final int ID = 255;
    
    public PacketFFDisconnectKick() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public PacketFFDisconnectKick(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the text that is displayed to the client when the connection terminates.
     * @return The current Reason
    */
    public String getReason() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set the text that is displayed to the client when the connection terminates.
     * @param value - new value.
    */
    public void setReason(String value) {
        handle.getStrings().write(0, value);
    }
}


