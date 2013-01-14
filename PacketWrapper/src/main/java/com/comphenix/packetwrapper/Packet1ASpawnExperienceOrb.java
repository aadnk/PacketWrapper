package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Packet1ASpawnExperienceOrb extends AbstractPacket {
    public static final int ID = 26;
    
    public Packet1ASpawnExperienceOrb() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet1ASpawnExperienceOrb(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the entity ID of the experience orb.
     * @return The current Entity ID
    */
    public int getEntityId() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Retrieve the experience orb entity.
     * @param world - the current world of the entity.
     * @return The spawned entity.
     */
    public Entity getEntity(World world) {
    	return handle.getEntityModifier(world).read(0);
    }

    /**
     * Retrieve the experience orb entity.
     * @param event - the packet event.
     * @return The spawned entity.
     */
    public Entity getEntity(PacketEvent event) {
    	return getEntity(event.getPlayer().getWorld());
    }
    
    /**
     * Set the entity ID of the experience orb to spawn.
     * @param value - new value.
    */
    public void setEntityId(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the x position of the object.
     * <p>
     * Note that the coordinate is rounded off to the nearest 1/32 of a meter.
     * @return The current X
    */
    public double getX() {
        return handle.getIntegers().read(1) / 32.0D;
    }
    
    /**
     * Set the x position of the object.
     * @param value - new value.
    */
    public void setX(double value) {
        handle.getIntegers().write(1, (int) Math.floor(value * 32.0D));
    }
    
    /**
     * Retrieve the y position of the object.
     * <p>
     * Note that the coordinate is rounded off to the nearest 1/32 of a meter.
     * @return The current y
    */
    public double getY() {
        return handle.getIntegers().read(2) / 32.0D;
    }
    
    /**
     * Set the y position of the object.
     * @param value - new value.
    */
    public void setY(double value) {
        handle.getIntegers().write(2, (int) Math.floor(value * 32.0D));
    }
    
    /**
     * Retrieve the z position of the object.
     * <p>
     * Note that the coordinate is rounded off to the nearest 1/32 of a meter.
     * @return The current z
    */
    public double getZ() {
        return handle.getIntegers().read(3) / 32.0D;
    }
    
    /**
     * Set the z position of the object.
     * @param value - new value.
    */
    public void setZ(double value) {
        handle.getIntegers().write(3, (int) Math.floor(value * 32.0D));
    }
    
    /**
     * Retrieve the number of experience orbs to spawn.
     * @return The current count
    */
    public short getCount() {
        return handle.getIntegers().read(4).shortValue();
    }
    
    /**
     * Set the number of experience orbs to spawn.
     * @param value - new value.
    */
    public void setCount(short value) {
        handle.getIntegers().write(4, (int) value);
    }
}


