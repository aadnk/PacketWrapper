package com.comphenix.packetwrapper;

import com.comphenix.protocol.events.PacketContainer;

public abstract class AbstractPacket {
	protected PacketContainer handle;

	protected AbstractPacket(PacketContainer handle) {
		this.handle = handle;
	}

	public PacketContainer getHandle() {
		return handle;
	}
}
