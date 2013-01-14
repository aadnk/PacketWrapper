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

import javax.crypto.SecretKey;

import com.comphenix.protocol.events.PacketContainer;

public class PacketFCEncryptionKeyResponse extends AbstractPacket {
    public static final int ID = 252;
    
    public PacketFCEncryptionKeyResponse() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public PacketFCEncryptionKeyResponse(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the shared secret data.
     * @return The shared data.
    */
    public byte[] getSharedSecret() {
        return handle.getByteArrays().read(0);
    }
    
    /**
     * Set the shared secret data.
     * @param value - new value.
    */
    public void getSharedSecret(byte[] value) {
        handle.getByteArrays().write(0, value);
    }
    
    /**
     * Retrieve the token response.
     * @return The shared data.
    */
    public byte[] getVerifyTokenResponse() {
        return handle.getByteArrays().read(1);
    }
    
    /**
     * Set token reponse.
     * @param value - new value.
    */
    public void setVerifyTokenResponse(byte[] value) {
        handle.getByteArrays().write(1, value);
    }

    /**
     * Retrieve the secret key instance.
     * @return The shared data.
    */
    public SecretKey getSecretKey() {
        return handle.getSpecificModifier(SecretKey.class).read(0);
    }
    
    /**
     * Set the secret key instance.
     * @param value - new value.
    */
    public void setSecretKey(SecretKey value) {
        handle.getSpecificModifier(SecretKey.class).write(0, value);
    }
}


