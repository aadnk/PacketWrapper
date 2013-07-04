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

public class PacketC8IncrementStatistic extends AbstractPacket {
    public static final int ID = 200;
    
    public PacketC8IncrementStatistic() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public PacketC8IncrementStatistic(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the ID of the statistic. See List of statistics..
     * @return The current Statistic ID
    */
    public int getStatisticId() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the ID of the statistic. See List of statistics..
     * @param value - new value.
    */
    public void setStatisticId(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the amount to increment the statistic.
     * @return The current Amount
    */
    public int getAmount() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Set the amount to increment the statistic.
     * @param value - new value.
    */
    public void setAmount(int value) {
        handle.getIntegers().write(1, value);
    }
}

