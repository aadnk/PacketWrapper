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

public class Packet1FEntityRelativeMove extends Packet1EEntity {
    public static final int ID = 31;
    
    public Packet1FEntityRelativeMove() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet1FEntityRelativeMove(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the relative movement in the x axis as an absolute integer.
     * @return The current dX
    */
    public byte getDx() {
        return handle.getBytes().read(0);
    }
    
    /**
     * Set the relative movement in the x axis as an absolute integer.
     * @param value - new value.
    */
    public void setDx(byte value) {
        handle.getBytes().write(0, value);
    }
    
    /**
     * Retrieve the relative movement in the y axis as an absolute integer.
     * @return The current dY
    */
    public byte getDy() {
        return handle.getBytes().read(1);
    }
    
    /**
     * Set the relative movement in the y axis as an absolute integer.
     * @param value - new value.
    */
    public void setDy(byte value) {
        handle.getBytes().write(1, value);
    }
    
    /**
     * Retrieve the relative movement in the z axis as an absolute integer.
     * @return The current dZ
    */
    public byte getDz() {
        return handle.getBytes().read(2);
    }
    
    /**
     * Set the relative movement in the z axis as an absolute integer.
     * @param value - new value.
    */
    public void setDz(byte value) {
        handle.getBytes().write(2, value);
    }   
}


