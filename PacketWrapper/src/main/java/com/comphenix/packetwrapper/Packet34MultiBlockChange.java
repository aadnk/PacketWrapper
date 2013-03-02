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
 * Represents a multi-block change.
 * <p>
 * See also {@link BlockChangeArray} for constructing an array of block changes.
 * 
 * @author Kristian
 */
public class Packet34MultiBlockChange extends AbstractPacket {
    public static final int ID = 52;
    
    public Packet34MultiBlockChange() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet34MultiBlockChange(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve chunk X Coordinate.
     * @return The current Chunk X
    */
    public int getOriginChunkX() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set chunk X Coordinate.
     * @param value - new value.
    */
    public void setOriginChunkX(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve chunk Z Coordinate.
     * @return The current Chunk Z
    */
    public int getOriginChunkZ() {
        return handle.getIntegers().read(1);
    }
    
    /**
     * Set chunk Z Coordinate.
     * @param value - new value.
    */
    public void setOriginChunkZ(int value) {
        handle.getIntegers().write(1, value);
    }
    
    /**
     * Retrieve the number of blocks affected.
     * @return The current Record count
    */
    public short getRecordCount() {
        return handle.getIntegers().read(2).shortValue();
    }
    
    /**
     * Set the number of blocks affected.
     * @param value - new value.
    */
    public void setRecordCount(short value) {
        handle.getIntegers().write(2, (int) value);
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
}

