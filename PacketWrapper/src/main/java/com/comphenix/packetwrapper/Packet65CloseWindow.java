package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet65CloseWindow extends AbstractPacket {
    public static final int ID = 101;
    
    public Packet65CloseWindow() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet65CloseWindow(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve this is the id of the window that was or should be closed.
     * @return The current Window id
    */
    public byte getWindowId() {
        return handle.getIntegers().read(0).byteValue();
    }
    
    /**
     * Set this is the id of the window that was or should be closed. 
     * @param value - new value.
    */
    public void setWindowId(byte value) {
        handle.getIntegers().write(0, (int) value);
    }
}

