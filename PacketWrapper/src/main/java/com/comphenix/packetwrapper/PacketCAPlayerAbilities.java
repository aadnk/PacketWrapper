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

public class PacketCAPlayerAbilities extends AbstractPacket {
    public static final int ID = 202;
    
    public PacketCAPlayerAbilities() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public PacketCAPlayerAbilities(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve whether or not the current player is in creative mode.
     * @return Creative mode.
    */
    public boolean isCreativeMode() {
        return handle.getSpecificModifier(boolean.class).read(0);
    }
    
    /**
     * Set whether or not the current player is in creative mode.
     * @param value - new value.
    */
    public void setCreativeMode(boolean value) {
        handle.getSpecificModifier(boolean.class).write(0, value);
    }
    
    /**
     * Retrieve whether or not the current player is flying.
     * @return Creative mode.
    */
    public boolean isFlying() {
        return handle.getSpecificModifier(boolean.class).read(1);
    }
    
    /**
     * Set whether or not the current player is flying.
     * @param value - new value.
    */
    public void setFlying(boolean value) {
        handle.getSpecificModifier(boolean.class).write(1, value);
    }
    
    /**
     * Retrieve whether or not the current player is allowed to fly.
     * @return Creative mode.
    */
    public boolean isFlyingAllowed() {
        return handle.getSpecificModifier(boolean.class).read(2);
    }
    
    /**
     * Set whether or not the current player is allowed to fly.
     * @param value - new value.
    */
    public void setFlyingAllowed(boolean value) {
        handle.getSpecificModifier(boolean.class).write(2, value);
    }
    
    /**
     * Retrieve whether or not the current player is in god mode.
     * @return Creative mode.
    */
    public boolean isGodMode() {
        return handle.getSpecificModifier(boolean.class).read(3);
    }
    
    /**
     * Set whether or not the current player is in god mode.
     * @param value - new value.
    */
    public void setGodMode(boolean value) {
        handle.getSpecificModifier(boolean.class).write(3, value);
    }
    
    /**
     * Retrieve the current flying speed.
     * @return The current Flying speed
    */
    public float getFlyingSpeed() {
        return handle.getFloat().read(0);
    }
    
    /**
     * Set the current flying speed.
     * @param value - new value.
    */
    public void setFlyingSpeed(float value) {
        handle.getFloat().write(0, value);
    }
    
    /**
     * Retrieve the current walking speed.
     * @return The current walking speed
    */
    public float getWalkingSpeed() {
        return handle.getFloat().read(1);
    }
    
    /**
     * Set the current walking speed.
     * @param value - walking value.
    */
    public void setWalkingSpeed(float value) {
        handle.getFloat().write(1, value);
    }
}


