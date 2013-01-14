package com.comphenix.packetwrapper;
import com.comphenix.protocol.events.PacketContainer;

public class Packet0BPlayerPosition extends Packet0APlayer {
    public static final int ID = 11;
    
    public Packet0BPlayerPosition() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet0BPlayerPosition(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve absolute position.
     * @return The current X
    */
    public double getX() {
        return handle.getDoubles().read(0);
    }
    
    /**
     * Set absolute position.
     * @param value - new value.
    */
    public void setX(double value) {
        handle.getDoubles().write(0, value);
    }
    
    /**
     * Retrieve absolute position.
     * @return The current Y
    */
    public double getY() {
        return handle.getDoubles().read(1);
    }
    
    /**
     * Set absolute position.
     * @param value - new value.
    */
    public void setY(double value) {
        handle.getDoubles().write(1, value);
    }
    
    /**
     * Retrieve used to modify the players bounding box when going up stairs, crouching, etc….
     * @return The current Stance
    */
    public double getStance() {
        return handle.getDoubles().read(3);
    }
    
    /**
     * Set used to modify the players bounding box when going up stairs, crouching, etc….
     * @param value - new value.
    */
    public void setStance(double value) {
        handle.getDoubles().write(3, value);
    }
    
    /**
     * Retrieve absolute position.
     * @return The current Z
    */
    public double getZ() {
        return handle.getDoubles().read(2);
    }
    
    /**
     * Set absolute position.
     * @param value - new value.
    */
    public void setZ(double value) {
        handle.getDoubles().write(2, value);
    }
}
