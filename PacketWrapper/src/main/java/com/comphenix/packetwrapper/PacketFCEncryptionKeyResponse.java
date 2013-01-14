package com.comphenix.packetwrapper;

import javax.crypto.SecretKey;

import com.comphenix.protocol.events.PacketContainer;

public class PacketFCEncryptionKeyResponse extends AbstractPacket {
    public static final int ID = 252;
    
    public PacketFCEncryptionKeyResponse() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public PacketFCEncryptionKeyResponse(PacketContainer packet) {
        super(packet);
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


