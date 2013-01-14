package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet0APlayer extends AbstractPacket {
    public static final int ID = 10;
    
    public Packet0APlayer() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet0APlayer(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the ground state.
     * <p>
     * True if the client is on the ground, false otherwise.
     * @return The current On Ground
    */
    public boolean getOnGround() {
        return handle.getSpecificModifier(boolean.class).read(0);
    }
    
    /**
     * Set the ground state.
     * <p>
     * True if the client is on the ground, false otherwise.
     * @param value - new value.
    */
    public void setOnGround(boolean value) {
        handle.getSpecificModifier(boolean.class).write(0, value);
    }
}
