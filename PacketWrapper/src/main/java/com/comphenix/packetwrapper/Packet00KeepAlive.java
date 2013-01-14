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

/**
 * Two-Way.
 * 
 * @author Kristian
 */
public class Packet00KeepAlive extends AbstractPacket {
    public static final int ID = 0;
    
    public Packet00KeepAlive() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet00KeepAlive(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the server-generated random ID.
     * @return The current Keep-alive ID
    */
    public int getKeepAliveId() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the server-generated random id.
     * @param value - new value.
    */
    public void setKeepAliveId(int value) {
        handle.getIntegers().write(0, value);
    }
}

