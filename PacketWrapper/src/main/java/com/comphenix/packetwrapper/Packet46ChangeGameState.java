package com.comphenix.packetwrapper;

import org.bukkit.GameMode;

import com.comphenix.protocol.events.PacketContainer;

public class Packet46ChangeGameState extends AbstractPacket {
    public static final int ID = 70;
    
    public Packet46ChangeGameState() {
        super(new PacketContainer(ID));
        handle.getModifier().writeDefaults();
    }
    
    public Packet46ChangeGameState(PacketContainer packet) {
        super(packet);
    }
    
    /**
     * Enumeration of all the reason codes in Minecraft.
     * 
     * @author Kristian
     */
    public static class Reasons {
    	public static final int INVALID_BED = 0;
    	public static final int BEGIN_RAINING = 1;
    	public static final int END_RAINING = 2;
    	public static final int CHANGE_GAME_MODE = 3;
    	public static final int ENTER_CREDITS = 4;
    	
    	private static final Reasons INSTANCE = new Reasons();
    	
    	/**
    	 * Retrieve the reasons enum.
    	 * @return Reasons enum.
    	 */
    	public static Reasons getInstance() {
    		return INSTANCE;
    	}
    }
    
    /**
     * Retrieve the reason the game state changed.
     * @see {@link Reasons}.
     * @return The current Reason
    */
    public int getReason() {
        return handle.getIntegers().read(0);
    }
    
    /**
     * Set the reason the game state changed.
     * @see {@link Reasons}.
     * @param value - new value.
    */
    public void setReason(int value) {
        handle.getIntegers().write(0, value);
    }
    
    /**
     * Retrieve the new game mode.
     * <p>
     * Only used when reason is 3.
     * @return The current Game mode
    */
    public GameMode getGameMode() {
        return GameMode.getByValue(handle.getIntegers().read(1));
    }
    
    /**
     * Set the new game mode.
     * <p>
     * Only used when reason is 3.
     * @param value - new value.
    */
    public void setGameMode(GameMode value) {
        handle.getIntegers().write(1, value.getValue());
    }
}

