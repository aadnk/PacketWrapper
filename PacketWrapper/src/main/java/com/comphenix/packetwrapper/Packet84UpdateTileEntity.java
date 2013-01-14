package com.comphenix.packetwrapper;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.nbt.NbtBase;

public class Packet84UpdateTileEntity extends AbstractPacket {
    public static final int ID = 132;
    
    public Packet84UpdateTileEntity() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet84UpdateTileEntity(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the x coordinate of the block associated with this tile entity.
     * @return The current X
    */
    public int getX() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the x coordinate of the block associated with this tile entity.
     * @param value - new value.
    */
    public void setX(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the y coordinate of the block associated with this tile entity.
     * @return The current Y
    */
    public short getY() {
        return handle.getIntegers().read(1).shortValue();
    }
    
    /**
     * Set the y coordinate of the block associated with this tile entity.
     * @param value - new value.
    */
    public void setY(short value) {
        handle.getIntegers().write(1, (int) value);
    }
    
    /**
     * Retrieve the z coordinate of the block associated with this tile entity.
     * @return The current Z
    */
    public int getZ() {
        return handle.getIntegers().read(2);
    }
    
    /**
     * Set the z coordinate of the block associated with this tile entity.
     * @param value - new value.
    */
    public void setZ(int value) {
        handle.getIntegers().write(2, value);
    }
    
    /**
     * Retrieve the type of update to perform.
     * @return The current Action
    */
    public byte getAction() {
        return handle.getIntegers().read(3).byteValue();
    }
    
    /**
     * Set the type of update to perform.
     * @param value - new value.
    */
    public void setAction(byte value) {
        handle.getIntegers().write(3, (int) value);
    }
    
    /**
     * Retrieve the NBT data of the current tile entity.
     * @return The current tile entity.
    */
    public NbtBase<?> getNbtData() {
        return handle.getNbtModifier().read(0);
    }
    
    /**
     * Set the NBT data of the current tile entity.
     * @param value - new value.
    */
    public void setNbtData(NbtBase<?> value) {
        handle.getNbtModifier().write(0, value);
    }
}


