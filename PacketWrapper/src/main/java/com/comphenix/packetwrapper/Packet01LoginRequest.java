/*
 *  PacketWrapper - Contains wrappers for each packet in Minecraft.
 *  Copyright (C) 2012 Kristian S. Stangeland
 *
 *  This program is free software; you can redistribute it and/or modify it under the terms of the 
 *  GNU Lesser General Public License as published by the Free Software Foundation; either version 2 of 
 *  the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 *  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with this program; 
 *  if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 
 *  02111-1307 USA
 */

package com.comphenix.packetwrapper;

import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.reflect.StructureModifier;

/**
 * Server to Client.
 * <p>
 * Sent by the server as a response to a client's login attempt.
 * 
 * @author Kristian
 */
public class Packet01LoginRequest extends AbstractPacket {
    public static final int ID = 1;
    
    public Packet01LoginRequest() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet01LoginRequest(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the player's entity ID.
     * @return The current entity ID
    */
    public int getEntityId() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the player's entity ID.
     * @param value - new value.
    */
    public void setEntityId(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the player's entity object.
     * @param world - the word the player has joined.
     * @return The player's entity.
     */
    public Entity getEntity(World world) {
    	return handle.getEntityModifier(world).read(0);
    }

    /**
     * Retrieve the player's entity object.
     * @param event - the packet event.
     * @return The player's entity.
     */
    public Entity getEntity(PacketEvent event) {
    	return getEntity(event.getPlayer().getWorld());
    }
    
    /**
     * Retrieve the world type.
     * <p>
     * This is the level-type settign (default, flat, or largeBiomes) in server.properties.
     * @return The current level type
    */
    public WorldType getLevelType() {
        return handle.getWorldTypeModifier().read(0);
    }
    
    /**
     * Set the world type.
     * <p>
     * This is the level-type settign (default, flat, or largeBiomes) in server.properties.
     * @param value - new value.
    */
    public void setLevelType(WorldType value) {
        handle.getWorldTypeModifier().write(0, value);
    }
    
    /**
     * Retrieve the game mode of the current player.
     * @return The current Game mode
    */
    public GameMode getGameMode() {
        return GameMode.getByValue(handle.getSpecificModifier(Enum.class).read(0).ordinal());
    }
    
    /**
     * Set the game mode of the current player.
     * @param value - new value.
    */
    public void setGameMode(GameMode mode) {
        @SuppressWarnings("rawtypes")
		StructureModifier<Enum> enumModifier = handle.getSpecificModifier(Enum.class);
        Enum<?> value = (Enum<?>) enumModifier.getField(0).getType().getEnumConstants()[mode.getValue()];
        
        // Save the updated value
        enumModifier.write(0, value);
    }
    
    /**
     * Retrieve the dimension of the current world.
     * <p>
     * This is -1 for the nether, 0 for the overworld and 1 for the end.
     * @return The current dimension
    */
    public int getDimension() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Set the dimension of the current world.
     * <p>
     * This is -1 for the nether, 0 for the overworld and 1 for the end.
     * @param value - new value.
    */
    public void setDimension(int value) {
        handle.getIntegers().write(1, value);
    }
    
    /**
     * Retrieve the difficulty level.
     * <p>
     * This is 0 to 3 for peaceful, easy, normal and hard respectively.
     * @return The current Difficulty
    */
    public byte getDifficulty() {
        return handle.getBytes().read(0);
    }
    
    /**
     * Set the difficulty level.
     * <p>
     * This is 0 to 3 for peaceful, easy, normal and hard respectively.
     * @param value - new value.
    */
    public void setDifficulty(byte value) {
        handle.getBytes().write(0, value);
    }
    
    /**
     * Retrieve whether or not this is a hardcore world.
     * @return TRUE if this is a hardcore world, FALSE otherwise.
    */
    public boolean isHardcore() {
        return handle.getSpecificModifier(boolean.class).read(0);
    }
    
    /**
     * Set whether or not this is a hardcore world.
     * @param value - TRUE if it is hardcore, FALSE otherwise.
    */
    public void setHardcore(boolean value) {
        handle.getSpecificModifier(boolean.class).write(0, value);
    }
    
    /**
     * Retrieve used by the client to draw the player list.
     * @return The current Max players
    */
    public byte getMaxPlayers() {
        return handle.getBytes().read(2);
    }
    
    /**
     * Set used by the client to draw the player list.
     * @param value - new value.
    */
    public void setMaxPlayers(byte value) {
        handle.getBytes().write(2, value);
    }
}


