package com.comphenix.packetwrapper;

import java.util.List;

import com.comphenix.protocol.events.PacketContainer;
import com.google.common.primitives.Ints;

public class Packet1DDestroyEntity extends AbstractPacket {
    public static final int ID = 29;
    
    public Packet1DDestroyEntity() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet1DDestroyEntity(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Retrieve the IDs of the entities that will be destroyed.
     * @return The current entities.
    */
    public List<Integer> getEntities() {
        return Ints.asList(handle.getIntegerArrays().read(0));
    }
    
    /**
     * Set the entities that will be destroyed.
     * @param value - new value.
    */
    public void setEntities(int[] entities) {
        handle.getIntegerArrays().write(0, entities);
    }
    
    /**
     * Set the entities that will be destroyed.
     * @param value - new value.
    */
    public void setEntities(List<Integer> entities) {
        setEntities(Ints.toArray(entities));
    }
}


