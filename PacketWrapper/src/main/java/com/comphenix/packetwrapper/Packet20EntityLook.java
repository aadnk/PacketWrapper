package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet20EntityLook extends Packet1EEntity {
    public static final int ID = 32;
    
    public Packet20EntityLook() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet20EntityLook(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the yaw of the current entity.
     * @return The current Yaw
    */
    public float getYaw() {
        return (handle.getBytes().read(3) * 360.F) / 256.0F;
    }
    
    /**
     * Set the yaw of the current entity.
     * @param value - new yaw.
    */
    public void setYaw(float value) {
        handle.getBytes().write(3, (byte) (value * 256.0F / 360.0F));
    }
    
    /**
     * Retrieve the pitch of the current entity.
     * @return The current pitch
    */
    public float getPitch() {
        return (handle.getBytes().read(4) * 360.F) / 256.0F;
    }
    
    /**
     * Set the pitch of the current entity.
     * @param value - new pitch.
    */
    public void setPitch(float value) {
        handle.getBytes().write(4, (byte) (value * 256.0F / 360.0F));
    }
}


