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

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.reflect.IntEnum;

/**
 * Sent when the client is ready to complete login and when the client is ready to respawn after death.
 * 
 * @author Kristian
 */
public class PacketCDClientStatuses extends AbstractPacket {
    public static final int ID = 205;
    
    /**
     * Enumeration of all the known payload values.
     * 
     * @author Kristian
     */
    public static class Payloads extends IntEnum {
    	public static final int INITIAL_SPAWN = 0;
    	public static final int RESPAWN_AFTER_DEATH = 1;

    	private static final Payloads INSTANCE = new Payloads();
    	
    	public static Payloads getInstance() {
    		return INSTANCE;
    	}
    }
    
    public PacketCDClientStatuses() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public PacketCDClientStatuses(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve whether or not we're logging in or respawning.
     * @see {@link Payloads}.
     * @return The current Payload
    */
    public int getPayload() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set whether or not we're logging in or respawning.
     * @see {@link Payloads}.
     * @param value - new value.
    */
    public void setPayload(int value) {
        handle.getIntegers().write(0, value);
    }
}


