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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.comphenix.protocol.events.PacketContainer;
import com.google.common.base.Preconditions;

public class Packet03ChatMessage extends AbstractPacket {
    public static final int ID = 3;
    
    public Packet03ChatMessage() {
        super(new PacketContainer(ID), ID);
        handle.getModifier().writeDefaults();
    }
    
    public Packet03ChatMessage(PacketContainer packet) {
        super(packet, ID);
    }
    
    /**
     * Retrieve the message sent by the client.
     * <p>
     * Must be sanitized server-side. 
     * @return The current Message
    */
    public String getClientMessage() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set the message sent by the client.
     * <p>
     * Must be sanitized server-side.
     * @param value - new value.
    */
    public void setClientMessage(String value) {
        handle.getStrings().write(0, value);
    }
    
    /**
     * Retrieve the JSON object that will be sent by the server.
     * @return A JSONObject, JSONArray, String or a Number object.
     * @throws ParseException If the parser encountered corrupt data.
     */
    public Object getServerJson() throws ParseException {
    	JSONParser parser = new JSONParser();
    	return parser.parse(getClientMessage());
    }
    
    /**
     * Set the JSON object that will be sent by the server.
     * @param object - the object to send.
     */
    public void setServerJson(JSONObject object) {
    	Preconditions.checkNotNull(object, "object cannot be NULL.");
    	setClientMessage(object.toJSONString());
    }
}


