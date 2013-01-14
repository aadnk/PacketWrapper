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

public class PacketFEServerListPing extends AbstractPacket {
    public static final int ID = 254;
    
    public PacketFEServerListPing() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public PacketFEServerListPing(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the a magic value. Usually one.
     * @return Magic value.
     */
    public byte getMagic() {
    	return handle.getIntegers().read(0).byteValue();
    }
    
    /**
     * Set the a magic value. Usually one.
     * @param value - new value.
     */
    public void setMagic(byte value) {
    	handle.getIntegers().write(0, (int) value);
    }
}


