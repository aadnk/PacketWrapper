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

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.IntEnum;

/**
 * Sent when the client is ready to complete login and when the client is ready to respawn after death.
 * @author Kristian
 */
public class WrapperPlayClientClientCommand extends AbstractPacket {
    public static final PacketType TYPE = PacketType.Play.Client.CLIENT_COMMAND;
        
    /**
     * Enumeration of all the known commands.
     * 
     * @author Kristian
     */
    public static class Commands extends IntEnum {
    	public static final int INITIAL_SPAWN = 0;
    	public static final int RESPAWN_AFTER_DEATH = 1;
    	public static final int OPEN_INVENTORY_ACHIEVEMENT = 2;
    	
    	private static final Commands INSTANCE = new Commands();
    	
    	public static Commands getInstance() {
    		return INSTANCE;
    	}
    }
    
    public WrapperPlayClientClientCommand() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }
    
    public WrapperPlayClientClientCommand(PacketContainer packet) {
        super(packet, TYPE);
    }
    
    /**
     * Retrieve whether or not we're logging in or respawning.
     * @see {@link Commands}.
     * @return The current command
    */
    public int getCommand() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set whether or not we're logging in or respawning.
     * @see {@link Commands}.
     * @param value - new value.
    */
    public void setCommand(int value) {
        handle.getIntegers().write(0, value);
    }
}