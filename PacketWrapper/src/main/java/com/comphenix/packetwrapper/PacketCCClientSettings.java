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

public class PacketCCClientSettings extends AbstractPacket {
    public static final int ID = 204;
    
    public PacketCCClientSettings() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public PacketCCClientSettings(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the language option.
     * @return The current Locale
    */
    public String getLocale() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set the language option.
     * @param value - new value.
    */
    public void setLocale(String value) {
        handle.getStrings().write(0, value);
    }
    
    /**
     * Retrieve the view distance.
     * <p>
     * Here 0-3 is 'far', 'normal', 'short', 'tiny' respectively.
     * @return The current View distance
    */
    public byte getViewDistance() {
        return handle.getIntegers().read(0).byteValue();
    }
    
    /**
     * Set the view distance.
     * <p>
     * Here 0-3 is 'far', 'normal', 'short', 'tiny' respectively..
     * @param value - new value.
    */
    public void setViewDistance(byte value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve chat settings.
     * <p>
     * Bits 0-1. 00: Enabled. 01: Commands only. 10: Hidden. 
     * @return The current Chat flags
    */
    public byte getChatFlags() {
        return handle.getIntegers().read(1).byteValue();
    }
    
    /**
     * Set chat settings. 
     * <p>
     * Bits 0-1. 00: Enabled. 01: Commands only. 10: Hidden. 
     * @param value - new value.
    */
    public void setChatFlags(byte value) {
        handle.getIntegers().write(1, (int) value);
    }
    
    /**
     * Retrieve client-side difficulty.
     * @return The current Difficulty
    */
    public byte getDifficulty() {
        return handle.getIntegers().read(2).byteValue();
    }
    
    /**
     * Set client-side difficulty.
     * @param value - new value.
    */
    public void setDifficulty(byte value) {
        handle.getIntegers().write(2, (int) value);
    }
    
    /**
     * Retrieve client-side "show cape" option.
     * @return The current Show Cape
    */
    public boolean isShowCape() {
        return handle.getSpecificModifier(boolean.class).read(1);
    }
    
    /**
     * Set client-side "show cape" option.
     * @param value - new value.
    */
    public void setShowCape(boolean value) {
        handle.getSpecificModifier(boolean.class).write(1, value);
    }
}


