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

import javax.annotation.Nonnull;

import com.comphenix.protocol.events.PacketContainer;

public class Packet83ItemData extends AbstractPacket {
    public static final int ID = 131;
    
    public Packet83ItemData() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet83ItemData(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve type of item (item ID) being modified.
     * @return The current Item Type
    */
    public short getItemType() {
        return handle.getShorts().read(0);
    }
    
    /**
     * Set type of item (item ID) being modified.
     * @param value - new value.
    */
    public void setItemType(short value) {
        handle.getShorts().write(0, value);
    }
    
    /**
     * Retrieve the damage value of the item being modified.
     * @return The current damage value.
    */
    public short getItemId() {
        return handle.getShorts().read(1);
    }
    
    /**
     * Set the damage value of the item being modified.
     * @param value - new value.
    */
    public void setItemId(short value) {
        handle.getShorts().write(1, value);
    }
    
    /**
     * Retrieve length of following byte array.
     * @return The current Text length
    */
    public byte[] getData() {
        return handle.getByteArrays().read(0);
    }
    
    /**
     * Set length of following byte array.
     * @param value - new value.
    */
    public void setData(@Nonnull byte[] value) {
    	if (value == null)
    		throw new IllegalArgumentException("Array cannot be NULL.");
        handle.getByteArrays().write(0, value);
    }
}


