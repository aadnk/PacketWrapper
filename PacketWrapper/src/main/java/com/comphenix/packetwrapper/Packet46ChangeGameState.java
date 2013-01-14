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

import com.comphenix.protocol.events.PacketContainer;

public class Packet46ChangeGameState extends AbstractPacket {
    public static final int ID = 70;
    
    public Packet46ChangeGameState() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet46ChangeGameState(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Enumeration of all the reason codes in Minecraft.
     * 
     * @author Kristian
     */
    public static class Reasons {
    	public static final int INVALID_BED = 0;
    	public static final int BEGIN_RAINING = 1;
    	public static final int END_RAINING = 2;
    	public static final int CHANGE_GAME_MODE = 3;
    	public static final int ENTER_CREDITS = 4;
    	
    	private static final Reasons INSTANCE = new Reasons();
    	
    	/**
    	 * Retrieve the reasons enum.
    	 * @return Reasons enum.
    	 */
    	public static Reasons getInstance() {
    		return INSTANCE;
    	}
    }
    
    /**
     * Retrieve the reason the game state changed.
     * @see {@link Reasons}.
     * @return The current Reason
    */
    public int getReason() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the reason the game state changed.
     * @see {@link Reasons}.
     * @param value - new value.
    */
    public void setReason(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the new game mode.
     * <p>
     * Only used when reason is 3.
     * @return The current Game mode
    */
    public GameMode getGameMode() {
        return GameMode.getByValue(handle.getIntegers().read(1));
    }
    
    /**
     * Set the new game mode.
     * <p>
     * Only used when reason is 3.
     * @param value - new value.
    */
    public void setGameMode(GameMode value) {
        handle.getIntegers().write(1, value.getValue());
    }
}

