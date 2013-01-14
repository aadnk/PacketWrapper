package com.comphenix.packetwrapper;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.injector.PacketConstructor;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;

public class Packet14SpawnNamedEntity extends AbstractPacket {
    public static final int ID = 20;
    
    private static PacketConstructor entityConstructor;
    
    public Packet14SpawnNamedEntity() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet14SpawnNamedEntity(PacketContainer packet) {
        super(packet);
    }
    
    public Packet14SpawnNamedEntity(Player player) {
        super(fromPlayer(player));
    }
    
    // Useful constructor
    private static PacketContainer fromPlayer(Player player) {
        if (entityConstructor == null)
        	entityConstructor = ProtocolLibrary.getProtocolManager().createPacketConstructor(ID, player);
        return entityConstructor.createPacket(player);
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
     * Retrieve the player name.
     * <p>
     * Max length of 16.
     * @return The current Player Name
    */
    public String getPlayerName() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set the player name.
     * <p>
     * Max length of 16.
     * @param value - new value.
    */
    public void setPlayerName(String value) {
    	if (value != null && value.length() > 16)
    		throw new IllegalArgumentException("Maximum player name lenght is 16 characters.");
        handle.getStrings().write(0, value);
    }
    
    /**
     * Retrieve the player X coordinate as an absolute Integer.
     * @return The current X
    */
    public int getX() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Set the player X as an absolute Integer.
     * @param value - new value.
    */
    public void setX(int value) {
        handle.getIntegers().write(1, value);
    }
    
    /**
     * Retrieve player Y as an absolute Integer.
     * @return The current Y
    */
    public int getY() {
        return handle.getIntegers().read(2);
    }
    
    /**
     * Set player Y as an absolute Integer.
     * @param value - new value.
    */
    public void setY(int value) {
        handle.getIntegers().write(2, value);
    }
    
    /**
     * Retrieve player Z as an absolute Integer.
     * @return The current Z
    */
    public int getZ() {
        return handle.getIntegers().read(3);
    }
    
    /**
     * Set player Z as an absolute Integer.
     * @param value - new value.
    */
    public void setZ(int value) {
        handle.getIntegers().write(3, value);
    }
    
    /**
     * Retrieve player yaw rotation.
     * @return The current Yaw
    */
    public float getYaw() {
        return (handle.getBytes().read(0).floatValue() * 360.F) / 256.0F;
    }
    
    /**
     * Set the player yaw rotation.
     * @param value - new value.
    */
    public void setYaw(float value) {
        handle.getBytes().write(0, (byte) (value * 256.0F / 360.0F));
    }
    
    /**
     * Retrieve player pitch rotation.
     * @return The current Pitch
    */
    public float getPitch() {
    	return (handle.getBytes().read(1).floatValue() * 360.F) / 256.0F;
    }
    
    /**
     * Set player pitch rotation.
     * @param value - new value.
    */
    public void setPitch(float value) {
    	 handle.getBytes().write(1, (byte) (value * 256.0F / 360.0F));
    }
    
    /**
     * Retrieve the item the player is currently holding. 
     * <p>
     * Note that this should be 0 for "no item", unlike -1 used in other packets. A negative value crashes clients..
     * @return The current Current Item
    */
    public short getCurrentItem() {
        return handle.getIntegers().read(4).shortValue();
    }
    
    /**
     * Set the item the player is currently holding. 
     * <p>
     * Note that this should be 0 for "no item", unlike -1 used in other packets. A negative value crashes clients..
     * @param value - new value.
    */
    public void setCurrentItem(short value) {
        handle.getIntegers().write(4, (int) value);
    }
    
    /**
     * Retrieve the associated metadata object.
     * <p>
     * Note that the 1.3 client crashes on packets with no metadata, but the server can send any metadata 
     * key of 0, 1 or 8 and the client is fine.
     * @return The current Metadata
    */
    public WrappedDataWatcher getMetadata() {
        return handle.getDataWatcherModifier().read(0);
    }
    
    /**
     * Set the associated metadata object. 
     * <p>
     * Note that the 1.3 client crashes on packets with no metadata, but the server can send any metadata 
     * key of 0, 1 or 8 and the client is fine..
     * @param value - new value.
    */
    public void setMetadata(WrappedDataWatcher value) {
        handle.getDataWatcherModifier().write(0, value);
    }
}


