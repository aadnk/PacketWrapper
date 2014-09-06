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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Chunk;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.ChunkCoordIntPair;

/**
 * Represents a multi-block change.
 * <p>
 * See also {@link BlockChangeArray} for constructing an array of block changes.
 * 
 * @author Kristian
 */
public class WrapperPlayServerMultiBlockChange extends AbstractPacket {
    public static final PacketType TYPE = PacketType.Play.Server.MULTI_BLOCK_CHANGE;
    
    public WrapperPlayServerMultiBlockChange() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }
    
    public WrapperPlayServerMultiBlockChange(PacketContainer packet) {
        super(packet, TYPE);
    }
    
    /**
     * Retrieve the chunk x position.
     * @return The chunk x.
     */
    public int getChunkX() {
    	return getChunk().getChunkX();
    }
    
    /**
     * Set the chunk x position.
     * @param index - the new position.
     */
    public void setChunkX(int index) {
    	setChunk(new ChunkCoordIntPair(index, getChunkZ()));
    }
    
    /**
     * Retrieve the chunk Z position.
     * @return The chunk z.
     */
    public int getChunkZ() {
    	return getChunk().getChunkZ();
    }
    
    /**
     * Set the chunk Z position.
     * @param index - the new position.
     */
    public void setChunkZ(int index) {
    	setChunk(new ChunkCoordIntPair(getChunkX(), index));
    }
    
    /**
     * Retrieve the chunk that has been altered.
     * @return The current chunk
    */
    public ChunkCoordIntPair getChunk() {
        return handle.getChunkCoordIntPairs().read(0);
    }
    
    /**
     * Set chunk that has been altered.
     * @param value - new value.
    */
    public void setChunk(ChunkCoordIntPair value) {
        handle.getChunkCoordIntPairs().write(0, value);
    }
    
    /**
     * Set chunk that has been altered.
     * @param value - new value.
    */
    public void setChunk(Chunk value) {
        setChunkX(value.getX());
        setChunkZ(value.getZ());
    }
    
    /**
     * Retrieve the number of blocks affected.
     * @return The current Record count
    */
    public short getRecordCount() {
        return handle.getIntegers().read(0).shortValue();
    }
    
    /**
     * Set the number of blocks affected.
     * @param value - new value.
    */
    public void setRecordCount(short value) {
        handle.getIntegers().write(0, (int) value);
    }
    
    /**
     * Retrieve the record data.
     * <p>
     * Each record is four bytes, containing the following data:
     * <table border="1" cellpadding="3">
     *  <tr>
     *   <th>Bit mask</th>
     *   <th>Width</th>
     *   <th>Meaning</th>
     *  </tr>
     *  <tr>
     *   <td>00 00 00 0F</td>
     *   <td>4 bits</td>
     *   <td>Block metadata</td>
     *  </tr>
     *  <tr>
     *   <td>00 00 FF F0</td>
     *   <td>12 bits</td>
     *   <td>Block ID</td>
     *  </tr>
     *  <tr>
     *   <td>00 FF 00 00</td>
     *   <td>8 bits</td>
     *   <td>Y co-ordinate</td>
     *  </tr>
     *  <tr>
     *   <td>0F 00 00 00</td>
     *   <td>4 bits</td>
     *   <td>Z co-ordinate, relative to chunk </td>
     *  </tr>
     *  <tr>
     *   <td>F0 00 00 00 </td>
     *   <td>4 bits</td>
     *   <td>X co-ordinate, relative to chunk</td>
     *  </tr>
     * </table>
     * 
     * @return The current Record count
    */
    public byte[] getRecordData() {
        return handle.getByteArrays().read(0);
    }
    
    /**
     * Set the record data.
     * <p>
     * Each record is four bytes. See {@link #getRecordData()} for more information.
     * @param value - new value.
    */
    public void setRecordData(byte[] value) {
    	setRecordCount((short) value.length);
        handle.getByteArrays().write(0, value);
    }
    
    /**
     * Set the record data using the given helper array.
     * @param array - useful helper array.
     */
    public void setRecordData(BlockChangeArray array) {
    	setRecordData(array.toByteArray());
    }
    
    /**
     * Retrieve a copy of the record data as a block change array.
     * @return The copied block change array.
     */
    public BlockChangeArray getRecordDataArray() {
    	return new BlockChangeArray(getRecordData());
    }
    
    /**
     * Retrieve a block change array from the wide representation sent to 1.8 clients.
     * @return Block change array based on the wide representation.
     */
    public BlockChangeArray getWideRecordData() {
    	short[] locations = handle.getModifier().<short[]>withType(short[].class).read(0);
    	int[] blocks = handle.getModifier().<int[]>withType(int[].class).read(0);

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(blocks.length * 4);
        DataOutputStream dataStream = new DataOutputStream(byteStream);
        
        try {
	        for (int i = 0; i < blocks.length; i++) {
	        	dataStream.writeShort(locations[i]);
	        	dataStream.writeShort((short) blocks[i]);
			}
        } catch (IOException e) {
        	// There's no underlying I/O device, so this shouldn't happen
        	throw new AssertionError("Should not occur.", e);
        }
        return new BlockChangeArray(byteStream.toByteArray());
    }
    
    /**
     * Set the wide record data only sent to the 1.8 client.
     * @param array - the data.
     */
    public void setWideRecordData(BlockChangeArray array) {
    	setWideRecordData(array.toByteArray());
    }
    
    /**
     * Set the record data only sent to the 1.8 client.
     * @param data - the wide data.
     */
    public void setWideRecordData(byte[] data) {
    	int count = data.length / 4;
    	
    	if ((data.length % 4) != 0) {
    		throw new IllegalArgumentException("Input byte array must be a multiple of four.");
    	}
    	ByteArrayInputStream byteStream = new ByteArrayInputStream(data);
        DataInputStream dataStream = new DataInputStream(byteStream);
        
        short[] locations = new short[count];
        int[] blocks = new int[count];
        
        try {
	        for (int i = 0; i < blocks.length; i++) {
				locations[i] = dataStream.readShort();
				blocks[i] = dataStream.readShort();
			}
        } catch (IOException e) {
        	throw new AssertionError("Should not occur.", e);
        }
        // Write back the changes
        handle.getModifier().<short[]>withType(short[].class).write(0, locations);
        handle.getModifier().<int[]>withType(int[].class).write(0, blocks);
        setRecordCount((short) count);
    }
}