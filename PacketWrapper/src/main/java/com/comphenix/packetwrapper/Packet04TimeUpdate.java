package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet04TimeUpdate extends AbstractPacket {
    public static final int ID = 4;
    
    public Packet04TimeUpdate() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet04TimeUpdate(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the age of the world in ticks. 
     * <p>
     * This cannot be changed by server commands.
     * @return The current age of the world
    */
    public long getAgeOfTheWorld() {
        return handle.getLongs().read(0);
    }
    
    /**
     * Set the age of the world in ticks.
     * <p>
     * This cannot be changed by server commands.
     * @param value - new value.
    */
    public void setAgeOfTheWorld(long value) {
        handle.getLongs().write(0, value);
    }
    
    /**
     * Retrieve the world (or region) time, in ticks.
     * @return The current Time of Day
    */
    public long getTimeOfDay() {
        return handle.getLongs().read(1);
    }
    
    /**
     * Set the world (or region) time, in ticks.
     * @param value - new value.
    */
    public void setTimeOfDay(long value) {
        handle.getLongs().write(1, value);
    }
}


