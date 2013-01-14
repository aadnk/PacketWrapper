package com.comphenix.packetwrapper;
import com.comphenix.protocol.events.PacketContainer;

public class Packet10HeldItemChange extends AbstractPacket {
    public static final int ID = 16;
    
    public Packet10HeldItemChange() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet10HeldItemChange(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the slot which the player has selected (0-8).
     * @return The current Slot ID
    */
    public short getSlotId() {
        return handle.getIntegers().read(0).shortValue();
    }
    
    /**
     * Set the slot which the player has selected (0-8).
     * @param value - new value.
    */
    public void setSlotId(short value) {
        handle.getIntegers().write(0, (int) value);
    }
}

