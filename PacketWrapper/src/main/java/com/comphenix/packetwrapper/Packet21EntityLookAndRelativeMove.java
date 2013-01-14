package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet21EntityLookAndRelativeMove extends Packet1EEntity {
    public static final int ID = 33;
    
    public Packet21EntityLookAndRelativeMove() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet21EntityLookAndRelativeMove(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the relative movement in the x axis as an absolute integer.
     * @return The current dX
    */
    public byte getDx() {
        return handle.getBytes().read(0);
    }
    
    /**
     * Set the relative movement in the x axis as an absolute integer.
     * @param value - new value.
    */
    public void setDx(byte value) {
        handle.getBytes().write(0, value);
    }
    
    /**
     * Retrieve the relative movement in the y axis as an absolute integer.
     * @return The current dY
    */
    public byte getDy() {
        return handle.getBytes().read(1);
    }
    
    /**
     * Set the relative movement in the y axis as an absolute integer.
     * @param value - new value.
    */
    public void setDy(byte value) {
        handle.getBytes().write(1, value);
    }
    
    /**
     * Retrieve the relative movement in the z axis as an absolute integer.
     * @return The current dZ
    */
    public byte getDz() {
        return handle.getBytes().read(2);
    }
    
    /**
     * Set the relative movement in the z axis as an absolute integer.
     * @param value - new value.
    */
    public void setDz(byte value) {
        handle.getBytes().write(2, value);
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


