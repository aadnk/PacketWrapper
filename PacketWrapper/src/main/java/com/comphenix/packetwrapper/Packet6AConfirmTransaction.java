package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class Packet6AConfirmTransaction extends AbstractPacket {
    public static final int ID = 106;
    
    public Packet6AConfirmTransaction() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet6AConfirmTransaction(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the id of the window that the action occurred in.
     * @return The current Window id
    */
    public byte getWindowId() {
        return handle.getIntegers().read(0).byteValue();
    }
    
    /**
     * Set the id of the window that the action occurred in..
     * @param value - new value.
    */
    public void setWindowId(byte value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve every action that is to be accepted has a unique number. 
     * <p>
     * This field corresponds to that number..
     * @return The current Action number
    */
    public short getActionNumber() {
        return handle.getShorts().read(0);
    }
    
    /**
     * Set every action that is to be accepted has a unique number. 
     * <p>
     * This field corresponds to that number.
     * @param value - new value.
    */
    public void setActionNumber(short value) {
        handle.getShorts().write(0, value);
    }
    
    /**
     * Retrieve whether or not the action was accepted.
     * @return The current Accepted?
    */
    public boolean getAccepted() {
        return handle.getSpecificModifier(boolean.class).read(0);
    }
    
    /**
     * Set whether or not the action was accepted.
     * @param value - new value.
    */
    public void setAccepted(boolean value) {
        handle.getSpecificModifier(boolean.class).write(0, value);
    }
}

