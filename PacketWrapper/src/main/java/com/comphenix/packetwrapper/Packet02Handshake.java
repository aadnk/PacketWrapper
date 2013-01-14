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

/**
 * Client to server.
 * 
 * @author Kristian
 */
public class Packet02Handshake extends AbstractPacket {
    public static final int ID = 2;
    
    public Packet02Handshake() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet02Handshake(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the protocol version.
     * <p>
     * As of 1.4.6 the protocol version is 51.
     * @return The current Protocol Version
    */
    public byte getProtocolVersion() {
        return handle.getIntegers().read(0).byteValue();
    }
    
    /**
     * Set the protocol version.
     * <p>
     * As of 1.4.6 the protocol version is 51.
     * @param value - new value.
    */
    public void setProtocolVersion(byte value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve the username of the player attempting to connect.
     * @return The current Username
    */
    public String getUsername() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set the username of the player attempting to connect.
     * @param value - new value.
    */
    public void setUsername(String value) {
        handle.getStrings().write(0, value);
    }
    
    /**
     * Retrieve the server host name.
     * @return The current Server Host
    */
    public String getServerHost() {
        return handle.getStrings().read(1);
    }
    
    /**
     * Set the server host name.
     * @param value - new value.
    */
    public void setServerHost(String value) {
        handle.getStrings().write(1, value);
    }
    
    /**
     * Retrieve the current TCP port number.
     * @return The current Server Port
    */
    public int getServerPort() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Set the server TCP port number.
     * @param value - new value.
    */
    public void setServerPort(int value) {
        handle.getIntegers().write(1, value);
    }
}


