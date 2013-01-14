package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public class PacketFAPluginMessage extends AbstractPacket {
    public static final int ID = 250;
    
    public PacketFAPluginMessage() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public PacketFAPluginMessage(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve name of the "channel" used to send the data..
     * @return The current Channel
    */
    public String getChannel() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set name of the "channel" used to send the data..
     * @param value - new value.
    */
    public void setChannel(String value) {
        handle.getStrings().write(0, value);
    }
    
    /**
     * Retrieve length of the byte array.
     * @return The current length
    */
    public short getLength() {
        return handle.getIntegers().read(0).shortValue();
    }
    
    /**
     * Set length of the byte array.
     * @param value - new value.
    */
    public void setLength(short value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve the custom data that sent in this message.
     * @return The current data
    */
    public byte[] getData() {
        return handle.getByteArrays().read(0);
    }
    
    /**
     * Set the custom data that is sent.
     * <p>
     * This method will automatically update the lenght property to a correct value.
     * @param value - new value.
    */
    public void setData(byte[] value) {
    	if (value == null)
    		throw new IllegalArgumentException("Byte array cannot be NULL.");
    	
    	handle.getIntegers().write(0, value.length);
        handle.getByteArrays().write(0, value);
    }
}


