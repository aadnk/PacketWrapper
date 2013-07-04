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

import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Packet13EntityAction extends AbstractPacket {
    public static final int ID = 19;
    
    public Packet13EntityAction() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet13EntityAction(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve player ID.
     * @return The current EID
    */
    public int getEntityID() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set player ID.
     * @param value - new value.
    */
    public void setEntityID(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the player's entity object.
     * @param world - the word the player has joined.
     * @return The player's entity.
     */
    public Entity getEntity(World world) {
    	return handle.getEntityModifier(world).read(0);
    }

    /**
     * Retrieve the player's entity object.
     * @param event - the packet event.
     * @return The player's entity.
     */
    public Entity getEntity(PacketEvent event) {
    	return getEntity(event.getPlayer().getWorld());
    }
    
    /**
     * Retrieve the ID of the action, see below..
     * @return The current Action ID
    */
    public byte getActionId() {
        return handle.getIntegers().read(1).byteValue();
    }
    
    /**
     * Set the ID of the action, see below..
     * @param value - new value.
    */
    public void setActionId(byte value) {
        handle.getIntegers().write(1, (int) value);
    }
    
    
    /**
     * Retrieve the unknown field related with horses.
     * @return The unknown field, ranged from 0 to 90.
    */
    public int getUnknown() {
        return handle.getIntegers().read(2);
    }
    
    /**
     * Set the unknown field related with horses.
     * @param value - new value, ranged from 0 to 90.
    */
    public void setUnknown(int value) {
        handle.getIntegers().write(2, value);
    }
}


