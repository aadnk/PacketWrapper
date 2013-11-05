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
		this.setObject(16, flags);
	}

	public void setWolfHealth(float health) {
		this.setObject(18, health);
	}

	public void setWolfBegging(byte begging) {
		this.setObject(19, begging);
	}

	public void setWolfCollarColor(byte color) {
		this.setObject(20, color);
	}

	public void setHasSaddle(byte value) {
		this.setObject(16, value);
	}

	public void setSheepFlags(byte flags) {
		this.setObject(16, flags);
	}

	public void setVillagerType(byte type) {
		this.setObject(16, type);
	}

	public void setEndermanBlock(byte block) {
		this.setObject(16, block);
	}

	public void setEndermanBlockData(byte blockData) {
		this.setObject(17, blockData);
	}

	public void setEndermanScreaming(byte value) {
		this.setObject(18, value);
	}

	public void setZombieChid(byte child) {
		this.setObject(12, child);
	}

	public void setZombieVillager(byte villager) {
		this.setObject(13, villager);
	}

	public void setZombieConverting(byte converting) {
		this.setObject(14, converting);
	}

	public void setBlazeOnFire(byte onFire) {
		this.setObject(16, onFire);
	}

	public void setSpiderClimbing(byte climbing) {
		this.setObject(16, climbing);
	}

	public void setCreeperState(byte flags) {
		this.setObject(16, flags);
	}

	public void setCreeperCharged(byte charged) {
		this.setObject(17, charged);
	}

	public void setGhastAttacking(byte attacking) {
		this.setObject(17, attacking);
	}

	public void setSlimeSlze(byte size) {
		this.setObject(16, size);
	}

	public void setMagmaCubeSize(byte size) {
		this.setObject(16, size);
	}

	public void setSkeletonType(byte type) {
		this.setObject(13, type);
	}

	public void setWitchAgro(byte agro) {
		this.setObject(21, agro);
	}

	public void setIronGolemPlayerCreated(byte value) {
		this.setObject(16, value);
	}

	public void setWitherHeadTarget1(int target) {
		this.setObject(17, target);
	}

	public void setWitherHeadTarget2(int target) {
		this.setObject(18, target);
	}

	public void setWitherHeadTarget3(int target) {
		this.setObject(19, target);
	}

	public void setWitherInvulnerableTime(int time) {
		this.setObject(20, time);
	}

	public void setBoatTimeSinceHit(int time) {
		this.setObject(17, time);
	}

	public void setBoatFowardDirection(int dir) {
		this.setObject(18, dir);
	}

	public void setBoatDamage(int damage) {
		this.setObject(19, damage);
	}

	public void setMinecraftShakingPower(int power) {
		this.setObject(17, power);
	}

	public void setMinecartSkakeingDirection(int dir) {
		this.setObject(18, dir);
	}

	public void setMinecartDamage(float damage) {
		this.setObject(19, damage);
	}

	public void setBlockInMinecart(int block) {
		this.setObject(20, block);
	}

	public void setMinecraftBlockYOffest(int y) {
		this.setObject(21, y);
	}

	public void setShowMinecartBlock(byte value) {
		this.setObject(22, value);
	}

	public void setFurnaceMinecartPowered(byte powered) {
		this.setObject(16, powered);
	}

	/**
	 * ProtocolLib does not yet support this function
	 */
	public void setItem() {
	}

	public void setArrowCriticalHit(byte value) {
		this.setObject(16, value);
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

	public void setItemFrameRotation(byte rotation) {
		this.setObject(3, rotation);
	}

	public void setEnderCrystalAlive(byte health) {
		this.setObject(8, health);
	}

	public Object getFlags() {
		return this.getObject(0);
	}

	public Object getAir() {
		return this.getObject(1);
	}

	public Object getHealth() {
		return this.getObject(6);
	}

	public Object getPotionEffectColor() {
		return this.getObject(7);
	}

	public Object getPotionEffectAmbient() {
		return this.getObject(8);
	}

	public Object getNumArrowsInEntity() {
		return this.getObject(9);
	}

	public Object getNameTag() {
		return this.getObject(10);
	}

	public Object getAlwaysShowNameTag() {
		return this.getObject(11);
	}

	public Object getEntityAge() {
		return this.getObject(12);
	}

	public Object getHorseFlags() {
		return this.getObject(16);
	}

	public Object getHorgetype() {
		return this.getObject(19);
	}

	public Object getHorseColorAndTexture() {
		return this.getObject(20);
	}

	public Object getHorseOwnerName() {
		return this.getObject(21);
	}

	public Object getBatHanging() {
		return this.getObject(16);
	}

	public Object getTame() {
		return this.getObject(16);
	}

	public Object getOwnersName() {
		return this.getObject(17);
	}

	public Object getOcelotType() {
		return this.getObject(18);
	}

	public Object getWolfFlags() {
		return this.getObject(16);
	}

	public Object getWolfHealth() {
		return this.getObject(18);
	}

	public Object getWolfBegging() {
		return this.getObject(19);
	}

	public Object getWolfCollarColor() {
		return this.getObject(20);
	}

	public Object getHasSaddle() {
		return this.getObject(16);
	}

	public Object getSheepFlags() {
		return this.getObject(16);
	}

	public Object getVillagerType() {
		return this.getObject(16);
	}

	public Object getEndermanBlock() {
		return this.getObject(16);
	}

	public Object getEndermanBlockData() {
		return this.getObject(17);
	}

	public Object getEndermanScreaming() {
		return this.getObject(18);
	}

	public Object getZombieChid() {
		return this.getObject(12);
	}

	public Object getZombieVillager() {
		return this.getObject(13);
	}

	public Object getZombieConverting() {
		return this.getObject(14);
	}

	public Object getBlazeOnFire() {
		return this.getObject(16);
	}

	public Object getSpiderClimbing() {
		return this.getObject(16);
	}

	public Object getCreeperState() {
		return this.getObject(16);
	}

	public Object getCreeperCharged() {
		return this.getObject(17);
	}

	public Object getGhastAttacking() {
		return this.getObject(16);
	}

	public Object getSlimeSlze() {
		return this.getObject(16);
	}

	public Object getMagmaCubeSize() {
		return this.getObject(16);
	}

	public Object getSkeletonType() {
		return this.getObject(13);
	}

	public Object getWitchAgro() {
		return this.getObject(21);
	}

	public Object getIronGolemPlayerCreated() {
		return this.getObject(16);
	}

	public Object getWitherHeadTarget1() {
		return this.getObject(17);
	}

	public Object getWitherHeadTarget2() {
		return this.getObject(18);
	}

	public Object getWitherHeadTarget3() {
		return this.getObject(19);
	}

	public Object getWitherInvulnerableTime() {
		return this.getObject(20);
	}

	public Object getBoatTimeSinceHit() {
		return this.getObject(17);
	}

	public Object getBoatFowardDirection() {
		return this.getObject(18);
	}

	public Object getBoatDamage() {
		return this.getObject(19);
	}

	public Object getMinecraftShakingPower() {
		return this.getObject(17);
	}

	public Object getMinecartSkakeingDirection() {
		return this.getObject(18);
	}

	public Object getMinecartDamage() {
		return this.getObject(19);
	}

	public Object getBlockInMinecart() {
		return this.getObject(20);
	}

	public Object getMinecraftBlockYOffest() {
		return this.getObject(21);
	}

	public Object getShowMinecartBlock() {
		return this.getObject(22);
	}

	public Object getFurnaceMinecartPowered() {
		return this.getObject(16);
	}

	/**
	 * ProtocolLib does not yet support return this function
	 */
	public Object getItem() {
		return null;
	}

	public Object getArrowCriticalHit(byte value) {
		return this.getObject(16);
	}

	/**
	 * ProtocolLib does not yet support return this function
	 */
	public Object getFireworkInfo() {
		return null;
	}

	/**
	 * ProtocolLib does not yet support return this function
	 */
	public Object getItemFrameItem() {
		return null;
	}

	public Object getItemFrameRotation(byte rotation) {
		return this.getObject(3);
	}

	public Object getEnderCrystalAlive(byte health) {
		return this.getObject(8);
	}
}
