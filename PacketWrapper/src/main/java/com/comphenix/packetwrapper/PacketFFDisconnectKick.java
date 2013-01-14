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

public class PacketFFDisconnectKick extends AbstractPacket {
    public static final int ID = 255;
    
    public PacketFFDisconnectKick() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public PacketFFDisconnectKick(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the text that is displayed to the client when the connection terminates.
     * @return The current Reason
    */
    public String getReason() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set the text that is displayed to the client when the connection terminates.
     * @param value - new value.
    */
    public void setReason(String value) {
        handle.getStrings().write(0, value);
    }
}


