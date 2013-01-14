package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet0CPlayerLook extends Packet0APlayer {
    public static final int ID = 12;
    
    public Packet0CPlayerLook() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet0CPlayerLook(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve absolute rotation on the X Axis, in degrees.
     * @return The current Yaw
    */
    public float getYaw() {
        return handle.getFloat().read(0);
    }
    
    /**
     * Set absolute rotation on the X Axis, in degrees.
     * @param value - new value.
    */
    public void setYaw(float value) {
        handle.getFloat().write(0, value);
    }
    
    /**
     * Retrieve absolute rotation on the Y Axis, in degrees.
     * @return The current Pitch
    */
    public float getPitch() {
        return handle.getFloat().read(1);
    }
    
    /**
     * Set absolute rotation on the Y Axis, in degrees.
     * @param value - new value.
    */
    public void setPitch(float value) {
        handle.getFloat().write(1, value);
    }
}


