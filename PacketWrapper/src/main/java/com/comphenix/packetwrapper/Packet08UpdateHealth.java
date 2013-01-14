package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet08UpdateHealth extends AbstractPacket {
    public static final int ID = 8;
    
    public Packet08UpdateHealth() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet08UpdateHealth(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the health of the current player.
     * <p>
     * Value zero or less is dead. 20 is the full HP.
     * @return The current Health
    */
    public short getHealth() {
        return handle.getIntegers().read(0).shortValue();
    }
    
    /**
     * Set the health of the current player.
     * <p>
     * Value zero or less is dead. 20 is the full HP.
     * @param value - new value.
    */
    public void setHealth(short value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve the food level.
     * <p>
     * Valid range: 0 - 20.
     * @return The current food level.
    */
    public short getFood() {
        return handle.getIntegers().read(1).shortValue();
    }
    
    /**
     * Set the food level.
     * <p>
     * Valid range: 0 - 20.
     * @param value - new value.
    */
    public void setFood(short value) {
        handle.getIntegers().write(1, (int) value);
    }
    
    /**
     * Retrieve the food saturation.
     * <p>
     * Varies from 0.0 to 5.0 in integer increments.
     * @return The current Food Saturation
    */
    public float getFoodSaturation() {
        return handle.getFloat().read(0);
    }
    
    /**
     * Set the food saturation.
     * <p>
     * Varies from 0.0 to 5.0 in integer increments.
     * @param value - new value.
    */
    public void setFoodSaturation(float value) {
        handle.getFloat().write(0, value);
    }
}

