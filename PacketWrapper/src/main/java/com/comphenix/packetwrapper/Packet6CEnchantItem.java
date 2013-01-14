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

public class Packet6CEnchantItem extends AbstractPacket {
    public static final int ID = 108;
    
    public Packet6CEnchantItem() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet6CEnchantItem(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the ID sent by open window.
     * @return The current Window ID
    */
    public byte getWindowId() {
        return handle.getIntegers().read(0).byteValue();
    }
    
    /**
     * Set the ID sent by open window.
     * @param value - new value.
    */
    public void setWindowId(byte value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve the position of the enchantment on the enchantment table window, starting with 0 as the top-most one.
     * @return The current Enchantment
    */
    public byte getEnchantment() {
        return handle.getIntegers().read(1).byteValue();
    }
    
    /**
     * Set the position of the enchantment on the enchantment table window, starting with 0 as the top-most one.
     * @param value - new value.
    */
    public void setEnchantment(byte value) {
        handle.getIntegers().write(1, (int) value);
    }
}


