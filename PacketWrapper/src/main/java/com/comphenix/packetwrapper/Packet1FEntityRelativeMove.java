package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet1FEntityRelativeMove extends Packet1EEntity {
    public static final int ID = 31;
    
    public Packet1FEntityRelativeMove() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet1FEntityRelativeMove(PacketContainer packet) {
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
}


