package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class PacketCBTabComplete extends AbstractPacket {
    public static final int ID = 203;
    
    public PacketCBTabComplete() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public PacketCBTabComplete(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the tab-completed text.
     * <p>
     * For the client, this is simply the message behind the cursor. For the server, it is
     * the tab-completed message.
     * @return The current Text
    */
    public String getText() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set the tab-completed text.
     * <p>
     * For the client, this is simply the message behind the cursor. For the server, it is
     * the tab-completed message.
     * @param value - new value.
    */
    public void setText(String value) {
        handle.getStrings().write(0, value);
    }
}

