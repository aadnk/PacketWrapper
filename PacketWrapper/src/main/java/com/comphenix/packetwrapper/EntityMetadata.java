package com.comphenix.packetwrapper;

import org.bukkit.ChatColor;

import com.comphenix.protocol.wrappers.WrappedDataWatcher;

/**
 * A useful wrapper for the Wrapped Data Watcher class, easy to understand and use
 * To be used in the setMetadata(EntityMetadata value) method to set a entity's metadata
 * 
 * YOU MUST SET AT LEAST ONE TYPE OF METADATA OR USERS WILL CRASH APON ENTITY SPAWN
 * 
 * You must also have a basic understanding of bitmasking to use this class
 * 
 * @author Quantum64
 */
public class EntityMetadata extends WrappedDataWatcher {

	/**
	 * Index: 0
	 * Type: Entity
	 * Use: Set entity flags as byte
	 * @param flags - Entity flags bit mask: 
	 * 0x01 = On Fire 
	 * 0x02	= Crouched
	 * 0x08 = Sprinting
	 * 0x10 = Eating/Drinking/Blocking
	 * 0x20	 Invisible
	 */
	public void setFlags(byte flags) {
		this.setObject(0, flags);
	}

	/**
	 * Index: 1
	 * Type: Entity
	 * Use: Current time in air - only used in game for Falling Sand Entity
	 * @param air - Current time in air
	 */
	public void setAir(short air) {
		this.setObject(1, air);
	}

	/**
	 * Index: 6
	 * Type: Living Entity
	 * Use: Sets the living Entity's health
	 * @param health - health of mob as a float
	 */
	public void setHealth(float health) {
		this.setObject(6, health);
	}

	/**
	 * Index: 7
	 * Type: Living Entity
	 * Use: Set the potion effect color for the Living Entity
	 * @param color -  color of potion effect particals
	 */
	public void setPotionEffectColor(int color) {
		this.setObject(7, color);
	}

	/**
	 * Index: 8
	 * Type: Living Entity
	 * Use: Sets if the potion effect particals are visible or not
	 * @param value - byte 1 or 0 (see potion effect particals = 1, no potion effect particals = 0)
	 */
	public void setPotionEffectAmbient(byte value) {
		this.setObject(8, value);
	}

	public void setNumArrowsInEntity(byte arrows) {
		this.setObject(9, arrows);
	}

	public void setNameTag(String nameTag) {
		this.setObject(10, ChatColor.translateAlternateColorCodes('&', nameTag));
	}

	public void setAlwaysShowNameTag(byte value) {
		this.setObject(11, value);
	}

	public void setEntityAge(int age) {
		this.setObject(12, age);
	}

	public void setHorseFlags(int flags) {
		this.setObject(16, flags);
	}

	public void setHorseType(byte type) {
		this.setObject(19, type);
	}

	public void setHorseColorAndTexture(int value) {
		this.setObject(20, value);
	}

	public void setHorseOwnerName(String name) {
		this.setObject(21, name);
	}

	public void setBatHanging(byte hanging) {
		this.setObject(16, hanging);
	}

	public void setTame(byte tame) {
		this.setObject(16, tame);
	}

	public void setOwnersName(String name) {
		this.setObject(17, name);
	}

	public void setOcelotType(byte type) {
		this.setObject(18, type);
	}

	public void setWolfFlags(byte flags) {
		this.setObject(18, flags);
	}

	public void setWolfHealth(float health) {
		this.setObject(18, health);
	}

	public void setWolfBegging(byte begging) {
		this.setObject(18, begging);
	}

	public void setWolfCollarColor(byte color) {
		this.setObject(18, color);
	}

	public void setHasSaddle(byte value) {
		this.setObject(18, value);
	}

	public void setSheepFlags(byte flags) {
		this.setObject(18, flags);
	}

	public void setVillagerType(byte type) {
		this.setObject(18, type);
	}

	public void setEndermanBlock(byte block) {
		this.setObject(18, block);
	}

	public void setEndermanBlockData(byte blockData) {
		this.setObject(18, blockData);
	}

	public void setEndermanScreaming(byte value) {
		this.setObject(18, value);
	}

	public void setZombieChid(byte child) {
		this.setObject(18, child);
	}

	public void setZombieVillager(byte villager) {
		this.setObject(18, villager);
	}

	public void setZombieConverting(byte converting) {
		this.setObject(18, converting);
	}

	public void setBlazeOnFire(byte onFire) {
		this.setObject(18, onFire);
	}

	public void setSpiderClimbing(byte climbing) {
		this.setObject(18, climbing);
	}

	public void setCreeperState(byte flags) {
		this.setObject(18, flags);
	}

	public void setCreeperCharged(byte charged) {
		this.setObject(18, charged);
	}

	public void setGhastAttacking(byte attacking) {
		this.setObject(18, attacking);
	}

	public void setSlimeSlze(byte size) {
		this.setObject(18, size);
	}

	public void setMagmaCubeSize(byte size) {
		this.setObject(18, size);
	}

	public void setSkeletonType(byte type) {
		this.setObject(18, type);
	}

	public void setWitchAgro(byte agro) {
		this.setObject(18, agro);
	}

	public void setIronGolemPlayerCreated(byte value) {
		this.setObject(18, value);
	}

	public void setWitherHeadTarget1(int target) {
		this.setObject(18, target);
	}

	public void setWitherHeadTarget2(int target) {
		this.setObject(18, target);
	}

	public void setWitherHeadTarget3(int target) {
		this.setObject(18, target);
	}

	public void setWitherInvulnerableTime(int time) {
		this.setObject(18, time);
	}

	public void setBoatTimeSinceHit(int time) {
		this.setObject(18, time);
	}

	public void setBoatFowardDirection(int dir) {
		this.setObject(18, dir);
	}

	public void setBoatDamage(int damage) {
		this.setObject(18, damage);
	}

	public void setMinecraftShakingPower(int power) {
		this.setObject(18, power);
	}

	public void setMinecartSkakeingDirection(int dir) {
		this.setObject(18, dir);
	}

	public void setMinecartDamage(float damage) {
		this.setObject(18, damage);
	}

	public void setBlockInMinecart(int block) {
		this.setObject(18, block);
	}

	public void setMinecraftBlockYOffest(int y) {
		this.setObject(18, y);
	}
	
	public void setShowMinecartBlock(byte value){
		this.setObject(18, value);
	}

	public void setFurnaceMinecartPowered(byte powered) {
		this.setObject(18, powered);
	}

	/**
	 * ProtocolLib does not yet support this function
	 */
	public void setItem() {
	}

	public void setArrowCriticalHit(byte value) {
		this.setObject(18, value);
	}

	/**
	 * ProtocolLib does not yet support this function
	 */
	public void setFireworkInfo() {
	}
	
	/**
	 * ProtocolLib does not yet support this function
	 */
	public void setItemFrameItem() {
	}

	public void setItemFrameRotation() {
		this.setObject(18, type);
	}

	public void setEnderCrystalAlive() {
		this.setObject(18, type);
	}

}
