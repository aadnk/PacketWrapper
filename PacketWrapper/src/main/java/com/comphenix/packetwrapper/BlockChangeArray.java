package com.comphenix.packetwrapper;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.bukkit.block.Block;

/**
 * Utility class for creating arrays of block changes.
 * <p>
 * See also {@link Packet34MultiBlockChange}.
 * 
 * @author Kristian
 */
public class BlockChangeArray {
	/**
	 * Represents a single block change. 
	 * <p>
	 * Retrieved by {@link BlockChangeArray#getBlockChange(int)}.
	 * 
	 * @author Kristian
	 */
	public class BlockChange {
		// Index of the block change entry that we may change
		private final int index;
		
		private BlockChange(int index) {
			this.index = index;
		}

		/**
		 * Set the relative x-axis position of current block change in the chunk.
		 * @param relativeX - relative block change location.
		 * @return This block change, for chaining.
		 */
		public BlockChange setRelativeX(int relativeX) {
			setValue(relativeX, 28, 0xF0000000);
			return this;
		}
		
		/**
		 * Retrieve the relative x-axis position of the current block change.
		 * @return X-axis position of the block change.
		 */
		public int getRelativeX() {
			return getValue(28, 0xF0000000);
		}
		
		/**
		 * Set the relative z-axis position of current block change in the chunk.
		 * @param relativeZ - relative block change location.
		 * @return This block change, for chaining.
		 */
		public BlockChange setRelativeZ(int relativeX) {
			setValue(relativeX, 24, 0xF000000);
			return this;
		}
		
		/**
		 * Retrieve the relative z-axis position of the current block change.
		 * @return Z-axis position of the block change.
		 */
		public byte getRelativeZ() {
			return (byte) getValue(24, 0xF000000);
		}
		
		/**
		 * Set the absolute y-axis position of the current block change.
		 * @param absoluteY - the absolute y-axis position.
		 * @return This block change, for chaining.
		 */
		public BlockChange setAbsoluteY(int absoluteY) {
			setValue(absoluteY, 16, 0xFF0000);
			return this;
		}
		
		/**
		 * Retrieve the absolute y-axis position of the current block change.
		 * @return Y-axis position of the block change.
		 */
		public int getAbsoluteY() {
			return getValue(16, 0xFF0000);
		}
		
		/**
		 * Set the block ID of the current block change.
		 * @param blockID - ID that the changed block will have.
		 * @return This block change, for chaining.
		 */
		public BlockChange setBlockID(int blockID) {
			setValue(blockID, 4, 0xFFF0);
			return this;
		}
		
		/**
		 * Retrieve the block ID of the current block change.
		 * @return The block ID that the block will change into.
		 */
		public int getBlockID() {
			return getValue(4, 0xFFF0);
		}
		
		/**
		 * Set the block metadata of the current block change.
		 * @param metadata - metadata that the changed block will have.
		 * @return This block change, for chaining.
		 */
		public BlockChange setMetadata(int metadata) {
			setValue(metadata, 0, 0xF);
			return this;
		}
		
		/**
		 * Retrieve the block metadata of the current block change.
		 * @return The block metadata that the block will change into.
		 */
		public int getMetadata() {
			return getValue(0, 0xF);
		}
		
		/**
		 * Retrieve the index of the current block change.
		 * @return Index of the current block change.
		 */
		public int getIndex() {
			return index;
		}
		
		// Should be inlined
		private void setValue(int value, int leftShift, int updateMask) {
			data[index] = ((value << leftShift) & updateMask) | (data[index] & ~updateMask);
		}
		
		private int getValue(int rightShift, int updateMask) {
			return (data[index] & updateMask) >> rightShift;
		}
	}
	
	/**
	 * Single of a single block change record in bytes.
	 */
	private static final int RECORD_SIZE = 4;
	
	/**
	 * The internally backed array.
	 */
	private int[] data;

	/**
	 * Construct a new array of block changes.
	 * @param blockChanges - the number of blocks that have been changed.
	 */
	public BlockChangeArray(int blockChanges) {
		data = new int[blockChanges];
	}
	
	/**
	 * Construct a new block change array from the copy of a given data array.
	 * @param data - the data array to store internally.
	 */
	public BlockChangeArray(byte[] input) {
		if ((data.length % RECORD_SIZE) != 0)
			throw new IllegalArgumentException("The lenght of the input data array should be a multiple of " + RECORD_SIZE + ".");
		
		IntBuffer source = ByteBuffer.wrap(input).asIntBuffer();
		IntBuffer destination = IntBuffer.allocate(input.length / RECORD_SIZE);
		destination.put(source);

		// Get the copied array
		data = destination.array();
	}
	
	/**
	 * Retrieve a view of the block change entry at the given index.
	 * <p>
	 * Any modification to this view will be stored in the block change array itself.
	 * @param index - index of the block change to retrieve. 
	 * @return A view of the block change entry.
	 */
	public BlockChange getBlockChange(int index) {
		if (index < 0 || index >= getBlockChanges())
			throw new IllegalArgumentException("Index is out of bounds.");
		return new BlockChange(index);
	}
	
	/**
	 * Set the block change at the specified index to contain the given block.
	 * <p>
	 * The coordinates will be correctly converted to relative coordinates, provided that the blocks
	 * are all from the same chunk (16x16 column of blocks).
	 * @param index - the block change index.
	 * @param block - the new content of the block change.
	 */
	public void setBlock(int index, Block block) {
		if (block == null)
			throw new IllegalArgumentException("Block cannot be NULL.");
		getBlockChange(index).
			setRelativeX(block.getX() & 0xF).
			setRelativeZ(block.getZ() & 0xF).
			setAbsoluteY(block.getY()).
			setBlockID(block.getTypeId()).
			setMetadata(block.getData());
	}
	
	/**
	 * Retrieve the number of block changes.
	 * @return The number of block changes.
	 */
	public int getBlockChanges() {
		return data.length;
	}
	
	/**
	 * Convert this block change array to a byte array.
	 * @return The resulting byte array.
	 */
	public byte[] toByteArray() {
		ByteBuffer copy = ByteBuffer.allocate(data.length * RECORD_SIZE);
		
		// Copy in the integer array
		copy.asIntBuffer().put(data);
		return copy.array();
	}
}

