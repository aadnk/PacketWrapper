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

import java.security.PublicKey;

import com.comphenix.protocol.events.PacketContainer;

public class PacketFDEncryptionKeyRequest extends AbstractPacket {
    public static final int ID = 253;
    
    public PacketFDEncryptionKeyRequest() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public PacketFDEncryptionKeyRequest(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the server ID.
     * @return The current Server id
    */
    public String getServerId() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set the server ID.
     * @param value - new value.
    */
    public void setServerId(String value) {
        handle.getStrings().write(0, value);
    }
    
    /**
     * Retrieve the public key instance.
     * @return The current Public key length
    */
    public PublicKey getPublicKey() {
        return handle.getSpecificModifier(PublicKey.class).read(0);
    }
    
    /**
     * Set the public key instance.
     * @param value - new value.
    */
    public void setPublicKeyLength(PublicKey value) {
        handle.getSpecificModifier(PublicKey.class).write(0, value);
    }
    
    /**
     * Retrieve the verify token.
     * @return The current Public key
    */
    public byte[] getVerifyToken() {
        return handle.getByteArrays().read(0);
    }
    
    /**
     * Set the verify token.
     * @param value - new value.
    */
    public void getVerifyToken(byte[] value) {
        handle.getByteArrays().write(0, value);
    }
}

