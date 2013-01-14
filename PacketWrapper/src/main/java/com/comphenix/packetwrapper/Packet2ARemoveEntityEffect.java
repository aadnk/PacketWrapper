package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.potion.PotionEffectType;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Packet2ARemoveEntityEffect extends AbstractPacket {
    public static final int ID = 42;
    
    public Packet2ARemoveEntityEffect() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet2ARemoveEntityEffect(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve entity ID of a player.
     * @return The current Entity ID
    */
    public int getEntityId() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set entity ID of a player.
     * @param value - new value.
    */
    public void setEntityId(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the entity.
     * @param world - the current world of the entity.
     * @return The entity.
     */
    public Entity getEntity(World world) {
    	return handle.getEntityModifier(world).read(0);
    }

    /**
     * Retrieve the entity.
     * @param event - the packet event.
     * @return The entity.
     */
    public Entity getEntity(PacketEvent event) {
    	return getEntity(event.getPlayer().getWorld());
    }
    
    /**
     * Retrieve the ID ot the effect to remove.
     * @return The current Effect ID
    */
    public byte getEffectId() {
        return handle.getBytes().read(0);
    }
    
    /**
     * Set the ID ot the effect to remove.
     * @param value - new value.
    */
    public void setEffectId(byte value) {
        handle.getBytes().write(0, value);
    }
    
    /**
     * Retrieve the effect.
     * @return The current effect
    */
    public PotionEffectType getEffect() {
        return PotionEffectType.getById(getEffectId());
    }
    
    /**
     * Set the effect id.
     * @param value - new value.
    */
    public void setEffect(PotionEffectType value) {
        setEffectId((byte) value.getId());
    }
}


