package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class PacketFEServerListPing extends AbstractPacket {
    public static final int ID = 254;
    
    public PacketFEServerListPing() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public PacketFEServerListPing(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the a magic value. Usually one.
     * @return Magic value.
     */
    public byte getMagic() {
    	return handle.getIntegers().read(0).byteValue();
    }
    
    /**
     * Set the a magic value. Usually one.
     * @param value - new value.
     */
    public void setMagic(byte value) {
    	handle.getIntegers().write(0, (int) value);
    }
}


