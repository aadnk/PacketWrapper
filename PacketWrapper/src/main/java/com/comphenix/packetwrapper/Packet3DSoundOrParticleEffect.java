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
import com.comphenix.protocol.reflect.IntEnum;

public class Packet3DSoundOrParticleEffect extends AbstractPacket {
    public static final int ID = 61;
    
    /**
     * Enumeration of all the sound effects this packet can send.
     * 
     * @author Kristian
     */
    public static class SoundEffects extends IntEnum {
    	public static final int RANDOM_CLICK_1 = 1000;
    	public static final int RANDOM_CLICK_2 = 1001;
    	public static final int RANDOM_BOW = 1002;
    	public static final int RANDOM_DOOR = 1003;
    	public static final int RANDOM_FIZZ = 1004;
    	/**
    	 * Data ID: Record ID
    	 */
    	public static final int PLAY_MUSIC_DISK = 1005;
    	public static final int MOB_GHAST_CHARGE = 1007;
    	public static final int MOB_GHAST_FIREBALL = 1008;
    	public static final int MOB_ZOMBIE_WOOD = 1010;
    	public static final int MOB_ZOMBIE_METAL = 1011;
    	public static final int MOB_ZOMBIE_WOODBREAK = 1012;
    	public static final int MOB_WITHER_SPAWN = 1013;

    	private static final SoundEffects INSTANCE = new SoundEffects();
    	
    	/**
    	 * Retrieve an instance of the sound effects enum.
    	 * @return Sound effects enum.
    	 */
    	public static SoundEffects getInstance() {
    		return INSTANCE;
    	}
    }
    
    /**
     * Enumeration of all the particle effects this packet can send.
     * 
     * @author Kristian
     */
    public static class ParticleEffects extends IntEnum {
    	/**
    	 * Spawn 10 smoke particles.
    	 * <p>
    	 * Data: Direction
    	 */
    	public static final int SPAWN_SMOKE_PARTICLES = 2000;
    	/**
    	 * Block break particles.
    	 * <p>
    	 * Data: Block ID.
    	 */
    	public static final int BLOCK_BREAK = 2001;
    	/**
    	 * Splash potion particles.
    	 * <p>
    	 * Data: Potion ID (damage value)
    	 */
    	public static final int SPLASH_POTION = 2002;
    	public static final int EYE_OF_ENDER = 2003;
    	
    	/**
    	 * Mob spawn. Smoke and flames.
    	 */
    	public static final int MOB_SPAWN_EFFECT = 2004;
    	
    	private static final ParticleEffects INSTANCE = new ParticleEffects();
    	
    	/**
    	 * Retrieve an instance of the particle effects enum.
    	 * @return Particle effects enum.
    	 */
    	public static ParticleEffects getInstance() {
    		return INSTANCE;
    	}
    }
    
    public static class SmokeDirections extends IntEnum {
    	public static final int SOUTH_EAST = 0;
    	public static final int SOUTH = 1;
    	public static final int SOUTH_WEST = 2;
    	public static final int EAST = 3;
    	public static final int UP = 4;
    	public static final int WEST = 5;
    	public static final int NORTH_EAST = 6;
    	public static final int NORTH = 7;
    	public static final int NORTH_WEST = 8;
    	
    	private static final SmokeDirections INSTANCE = new SmokeDirections();
    	
    	/**
    	 * Retrieve an instance of the smoke direction enum.
    	 * @return Smoke direction enum.
    	 */
    	public static SmokeDirections getInstance() {
    		return INSTANCE;
    	}
    }
    
    public Packet3DSoundOrParticleEffect() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet3DSoundOrParticleEffect(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the ID of the effect.
     * @see {@link SoundEffects} and {@link ParticleEffects}.
     * @return The current Effect ID
    */
    public int getEffectId() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the ID of the effect.
     * @see {@link SoundEffects} and {@link ParticleEffects}.
     * @param value - new value.
    */
    public void setEffectId(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the X location of the effect..
     * @return The current X
    */
    public int getX() {
        return handle.getIntegers().read(2);
    }
    
    /**
     * Set the X location of the effect..
     * @param value - new value.
    */
    public void setX(int value) {
        handle.getIntegers().write(2, value);
    }
    
    /**
     * Retrieve the Y location of the effect..
     * @return The current Y
    */
    public int getY() {
        return handle.getIntegers().read(3);
    }
    
    /**
     * Set the Y location of the effect..
     * @param value - new value.
    */
    public void setY(int value) {
        handle.getIntegers().write(3, value);
    }
    
    /**
     * Retrieve the Z location of the effect..
     * @return The current Z
    */
    public int getZ() {
        return handle.getIntegers().read(4);
    }
    
    /**
     * Set the Z location of the effect..
     * @param value - new value.
    */
    public void setZ(int value) {
        handle.getIntegers().write(4, value);
    }
    
    /**
     * Retrieve extra data for certain effects.
     * @see {@link SmokeDirections}
     * @return The current Data
    */
    public int getData() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Set extra data for certain effects.
     * @see {@link SmokeDirections}
     * @param value - new value.
    */
    public void setData(int value) {
        handle.getIntegers().write(1, value);
    }
    
    /**
     * Retrieve whether or not to ignore the distance of a sound.
     * <p>
     * If TRUE, the effect will always be played 2 blocks away in the correct direction.
     * @return The current Disable relative volume
    */
    public boolean getDisableRelativeVolume() {
        return handle.getSpecificModifier(boolean.class).read(0);
    }
    
    /**
     * Set whether or not to ignore the distance of a sound.
     * <p>
     * If TRUE, the effect will always be played 2 blocks away in the correct direction.
     * @param value - TRUE to disable distance, FALSE otherwise.
    */
    public void setDisableRelativeVolume(boolean value) {
        handle.getSpecificModifier(boolean.class).write(0, value);
    }
}


