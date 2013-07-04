package com.comphenix.packetwrapper;

import java.util.Map;

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Packet2CEntityProperties extends AbstractPacket {
    public static final int ID = 44;
    
    public Packet2CEntityProperties() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet2CEntityProperties(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the ID of the entity affected by these properties.
     * @return The current EntityID
    */
    public int getEntityid() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the ID of the entity affected by these properties.
     * @param value - new value.
    */
    public void setEntityid(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the entity affected by these properties.
     * @param world - the current world of the entity.
     * @return The entity.
     */
    public Entity getEntity(World world) {
    	return handle.getEntityModifier(world).read(0);
    }

    /**
     * Retrieve the entity affected by these properties.
     * @param event - the packet event.
     * @return The entity.
     */
    public Entity getEntity(PacketEvent event) {
    	return getEntity(event.getPlayer().getWorld());
    }
    
	/**
	 * Retrieve the map of attribute/property name and value.
	 * <p>
	 * <b>Known values:</b>
	 * <table>
	 * <tbody>
	 * <tr>
	 * <td>Key</td>
	 * <td>Default</td>
	 * <td>Min</td>
	 * <td>Max</td>
	 * <td>Label</td>
	 * </tr>
	 * <tr>
	 * <td>generic.maxHealth</td>
	 * <td>20.0</td>
	 * <td>0.0</td>
	 * <td>Double.MaxValue</td>
	 * <td>Max Health</td>
	 * </tr>
	 * <tr>
	 * <td>generic.followRange</td>
	 * <td>32.0</td>
	 * <td>0.0</td>
	 * <td>2048.0</td>
	 * <td>Follow Range</td>
	 * </tr>
	 * <tr>
	 * <td>generic.knockbackResistance</td>
	 * <td>0.0</td>
	 * <td>0.0</td>
	 * <td>1.0</td>
	 * <td>Knockback Resistance</td>
	 * </tr>
	 * <tr>
	 * <td>generic.movementSpeed</td>
	 * <td>0.699999988079071</td>
	 * <td>0.0</td>
	 * <td>Double.MaxValue</td>
	 * <td>Movement Speed</td>
	 * </tr>
	 * <tr>
	 * <td>generic.attackDamage</td>
	 * <td>2.0</td>
	 * <td>0.0</td>
	 * <td>Double.MaxValue</td>
	 * <td>
	 * </td>
	 * </tr>
	 * <tr>
	 * <td>horse.jumpStrength</td>
	 * <td>0.7</td>
	 * <td>0.0</td>
	 * <td>2.0</td>
	 * <td>Jump Strength</td>
	 * </tr>
	 * <tr>
	 * <td>zombie.spawnReinforcements</td>
	 * <td>0.0</td>
	 * <td>0.0</td>
	 * <td>1.0</td>
	 * <td>Spawn Reinforcements Chance</td>
	 * </tr>
	 * </tbody>
	 * </table>
	 * @return A map of each property.
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Double> getProperties() {
    	return handle.getSpecificModifier(Map.class).read(0);
    }
	
    /**
     * Set the map of attribute/property name and value.
     * <p>
     * See {@link #getProperties()} for more information.
     * @param properties - the new map.
    */
    public void setProperties(Map<String, Double> properties) {
        handle.getSpecificModifier(Map.class).write(0, properties);
    }
}


