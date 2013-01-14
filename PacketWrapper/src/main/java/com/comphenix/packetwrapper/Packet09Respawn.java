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
import org.bukkit.WorldType;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.StructureModifier;

public class Packet09Respawn extends AbstractPacket {
    public static final int ID = 9;
    
    public Packet09Respawn() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet09Respawn(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve -1: The Nether, 0: The Overworld, 1: The End.
     * @return The current Dimension
    */
    public int getDimension() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set -1: The Nether, 0: The Overworld, 1: The End.
     * @param value - new value.
    */
    public void setDimension(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the difficulty level.
     * <p>
     * This is 0 to 3 for peaceful, easy, normal and hard respectively.
     * <p>
     * The client may diregard this and simply set the value to one.
     * @return The current Difficulty
    */
    public byte getDifficulty() {
        return handle.getIntegers().read(1).byteValue();
    }
    
    /**
     * Set the difficulty level. 
     * <p>
     * This is 0 to 3 for peaceful, easy, normal and hard respectively.
     * <p>
     * The client may diregard this and simply set the value to one.
     * @param value - new value.
    */
    public void setDifficulty(byte value) {
        handle.getIntegers().write(1, (int) value);
    }
    
    /**
     * Retrieve the game mode of the current player.
     * @return The current game mode
    */
    public GameMode getGameMode() {
        return GameMode.getByValue(handle.getSpecificModifier(Enum.class).read(0).ordinal());
    }
    
    /**
     * Set the game mode of the current player.
     * @param mode - new value.
    */
    public void setGameMode(GameMode mode) {
        @SuppressWarnings("rawtypes")
		StructureModifier<Enum> enumModifier = handle.getSpecificModifier(Enum.class);
        Enum<?> value = (Enum<?>) enumModifier.getField(0).getType().getEnumConstants()[mode.getValue()];
        
        // Save the updated value
        enumModifier.write(0, value);
    }
    
    /**
     * Retrieve the maximum world height.
     * <p>
     * Defaults to 256.
     * @return The maximum world height
    */
    public short getWorldHeight() {
        return handle.getIntegers().read(2).shortValue();
    }
    
    /**
     * Set the maximum world height.
     * <p>
     * defaults to 256.
     * @param value - new maximum value.
    */
    public void setWorldHeight(short value) {
        handle.getIntegers().write(2, (int) value);
    }
    
    /**
     * Retrieve the current level type.
     * @return The current level type
    */
    public WorldType getLevelType() {
        return handle.getWorldTypeModifier().read(0);
    }
    
    /**
     * Set see 0x01 login.
     * @param value - new world type.
    */
    public void setLevelType(WorldType value) {
        handle.getWorldTypeModifier().write(0, value);
    }
}