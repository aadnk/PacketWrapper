package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet2BSetExperience extends AbstractPacket {
    public static final int ID = 43;
    
    public Packet2BSetExperience() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet2BSetExperience(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the new amount of experience in the experience bar as a value between 0 and 1.
     * @return The current Experience bar
    */
    public float getExperienceBar() {
        return handle.getFloat().read(0);
    }
    
    /**
     * Set the new amount of experience in the experience bar as a value between 0 and 1.
     * @param value - new value.
    */
    public void setExperienceBar(float value) {
        handle.getFloat().write(0, value);
    }
    
    /**
     * Retrieve the displayed level.
     * @return The current Level
    */
    public short getLevel() {
        return handle.getIntegers().read(1).shortValue();
    }
    
    /**
     * Set the displayed level.
     * @param value - new value.
    */
    public void setLevel(short value) {
        handle.getIntegers().write(1, (int) value);
    }
    
    /**
     * Retrieve the total amount of experienced gained.
     * @return The current Total experience
    */
    public short getTotalExperience() {
        return handle.getIntegers().read(0).shortValue();
    }
    
    /**
     * Set the total amount of experience gained.
     * @param value - new value.
    */
    public void setTotalExperience(short value) {
        handle.getIntegers().write(0, (int) value);
    }
}


