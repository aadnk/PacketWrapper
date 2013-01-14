package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class PacketC8IncrementStatistic extends AbstractPacket {
    public static final int ID = 200;
    
    public PacketC8IncrementStatistic() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public PacketC8IncrementStatistic(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the ID of the statistic. See List of statistics..
     * @return The current Statistic ID
    */
    public int getStatisticId() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the ID of the statistic. See List of statistics..
     * @param value - new value.
    */
    public void setStatisticId(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the amount to increment the statistic.
     * @return The current Amount
    */
    public byte getAmount() {
        return handle.getIntegers().read(1).byteValue();
    }
    
    /**
     * Set the amount to increment the statistic.
     * @param value - new value.
    */
    public void setAmount(byte value) {
        handle.getIntegers().write(1, (int) value);
    }
}

