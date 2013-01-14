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

public class Packet07UseEntity extends AbstractPacket {
    public static final int ID = 7;
    
    public Packet07UseEntity() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet07UseEntity(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the entity ID of the player, which is ignored by the server.
     * @return The current user
    */
    public int getUserID() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Retrieve the entity of the player.
     * @param event - the world this event occured in.
     * @return The entity of the player.
     */
    public Entity getUser(World world) {
    	return handle.getEntityModifier(world).read(0);
    }
    
    /**
     * Retrieve the entity of the player.
     * @param event - the current packet event.
     * @return The entity of the player.
     */
    public Entity getUser(PacketEvent event) {
    	return getUser(event.getPlayer().getWorld());
    }
    
    /**
     * Set the entity ID of the player (ignored by the server).
     * @param value - new value.
    */
    public void setUserID(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the entity ID the player is interacting with.
     * @return The current Target
    */
    public int getTargetID() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Retrieve the entity the player is interacting with.
     * @param event - the world this event occured in.
     * @return The target entity.
     */
    public Entity getTarget(World world) {
    	return handle.getEntityModifier(world).read(1);
    }
    
    /**
     * Retrieve the entity the player is interacting with.
     * @param event - the current packet event.
     * @return The target entity.
     */
    public Entity getTarget(PacketEvent event) {
    	return getTarget(event.getPlayer().getWorld());
    }
    
    /**
     * Set the entity ID the player is interacting with.
     * @param value - new value.
    */
    public void setTargetID(int value) {
        handle.getIntegers().write(1, value);
    }
    
    /**
     * Retrieve the ID of the clicked mouse button.
     * <p>
     * This is one when the player is left-clicking and zero when right-clicking.
     * @return The current Mouse button
    */
    public int getMouseButton() {
        return handle.getIntegers().read(2);
    }
    
    /**
     * Set the ID of the clicked mouse button.
     * <p>
     * This is one when the player is left-clicking and zero when right-clicking.
     * @param value - new value.
    */
    public void setMouseButton(int value) {
        handle.getIntegers().write(2, (int) value);
    }
}


