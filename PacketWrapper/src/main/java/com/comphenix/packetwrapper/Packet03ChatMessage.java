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

public class Packet03ChatMessage extends AbstractPacket {
    public static final int ID = 3;
    
    public Packet03ChatMessage() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet03ChatMessage(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve user input must be sanitized server-side.
     * @return The current Message
    */
    public String getMessage() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set user input must be sanitized server-side.
     * @param value - new value.
    */
    public void setMessage(String value) {
        handle.getStrings().write(0, value);
    }
}


