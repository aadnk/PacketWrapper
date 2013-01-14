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

public class PacketCBTabComplete extends AbstractPacket {
    public static final int ID = 203;
    
    public PacketCBTabComplete() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public PacketCBTabComplete(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the tab-completed text.
     * <p>
     * For the client, this is simply the message behind the cursor. For the server, it is
     * the tab-completed message.
     * @return The current Text
    */
    public String getText() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set the tab-completed text.
     * <p>
     * For the client, this is simply the message behind the cursor. For the server, it is
     * the tab-completed message.
     * @param value - new value.
    */
    public void setText(String value) {
        handle.getStrings().write(0, value);
    }
}

