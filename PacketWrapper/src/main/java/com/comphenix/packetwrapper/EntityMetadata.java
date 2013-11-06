package com.comphenix.packetwrapper;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

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

public class EntityMetadata {

	private WrappedDataWatcher metadata;

	public WrappedDataWatcher getMetadata() {
		return metadata;
	}

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
		setMeta(0, flags);
	}

	/**
	 * Index: 1
	 * Type: Entity
	 * Use: Current time in air - only used in game for Falling Sand Entity
	 * @param air - Current time in air
	 */
	public void setAir(short air) {
		setMeta(1, air);
	}

	public Object getFlags() {
		return getMeta(0);
	}

	public Object getAir() {
		return getMeta(1);
	}

	public static class LivingEntityMetadata extends EntityMetadata {
		/**
		 * Index: 6
		 * Type: Living Entity
		 * Use: Sets the living Entity's health
		 * @param health - health of mob as a float
		 */
		public void setHealth(float health) {
			setMeta(6, health);
		}

		/**
		 * Index: 7
		 * Type: Living Entity
		 * Use: Set the potion effect color for the Living Entity
		 * @param color -  color of potion effect particals
		 */
		public void setPotionEffectColor(int color) {
			setMeta(7, color);
		}

		/**
		 * Index: 8
		 * Type: Living Entity
		 * Use: Sets if the potion effect particals are visible or not
		 * @param value - byte 1 or 0 (see potion effect particals = 1, no potion effect particals = 0)
		 */
		public void setPotionEffectAmbient(byte value) {
			setMeta(8, value);
		}

		public void setNumArrowsInEntity(byte arrows) {
			setMeta(9, arrows);
		}

		public void setNameTag(String nameTag) {
			setMeta(10, ChatColor.translateAlternateColorCodes('&', nameTag));
		}

		public void setAlwaysShowNameTag(byte value) {
			setMeta(11, value);
		}

		public Object getHealth() {
			return getMeta(6);
		}

		public Object getPotionEffectColor() {
			return getMeta(7);
		}

		public Object getPotionEffectAmbient() {
			return getMeta(8);
		}

		public Object getNumArrowsInEntity() {
			return getMeta(9);
		}

		public Object getNameTag() {
			return getMeta(10);
		}

		public Object getAlwaysShowNameTag() {
			return getMeta(11);
		}

	}

	public static class AgeableMetadata extends LivingEntityMetadata {
		public void setEntityAge(int age) {
			setMeta(12, age);
		}

		public Object getEntityAge() {
			return getMeta(12);
		}
	}

	public static class HorseMetadata extends AgeableMetadata {
		public void setHorseFlags(int flags) {
			setMeta(16, flags);
		}

		public void setHorseType(byte type) {
			setMeta(19, type);
		}

		public void setHorseColorAndTexture(int value) {
			setMeta(20, value);
		}

		public void setHorseOwnerName(String name) {
			setMeta(21, name);
		}

		public Object getHorseFlags() {
			return getMeta(16);
		}

		public Object getHorgetype() {
			return getMeta(19);
		}

		public Object getHorseColorAndTexture() {
			return getMeta(20);
		}

		public Object getHorseOwnerName() {
			return getMeta(21);
		}
	}

	public static class BatMetadata extends LivingEntityMetadata {
		public void setBatHanging(byte hanging) {
			setMeta(16, hanging);
		}

		public Object getBatHanging() {
			return getMeta(16);
		}
	}

	public static class TameableMetadata extends AgeableMetadata {

		public void setTame(byte tame) {
			setMeta(16, tame);
		}

		public void setOwnersName(String name) {
			setMeta(17, name);
		}

		public Object getTame() {
			return getMeta(16);
		}

		public Object getOwnersName() {
			return getMeta(17);
		}
	}

	public static class OcelotMetadata extends TameableMetadata {
		public void setOcelotType(byte type) {
			setMeta(18, type);
		}

		public Object getOcelotType() {
			return getMeta(18);
		}

	}

	public static class WolfMetadata extends TameableMetadata {
		public void setWolfFlags(byte flags) {
			setMeta(16, flags);
		}

		public void setWolfHealth(float health) {
			setMeta(18, health);
		}

		public void setWolfBegging(byte begging) {
			setMeta(19, begging);
		}

		public void setWolfCollarColor(byte color) {
			setMeta(20, color);
		}

		public Object getWolfFlags() {
			return getMeta(16);
		}

		public Object getWolfHealth() {
			return getMeta(18);
		}

		public Object getWolfBegging() {
			return getMeta(19);
		}

		public Object getWolfCollarColor() {
			return getMeta(20);
		}
	}

	public static class PigMetadata extends AgeableMetadata {
		public void setHasSaddle(byte value) {
			setMeta(16, value);
		}

		public Object getHasSaddle() {
			return getMeta(16);
		}
	}

	public static class SheepMetadata extends AgeableMetadata {
		public void setSheepFlags(byte flags) {
			setMeta(16, flags);
		}

		public Object getSheepFlags() {
			return getMeta(16);
		}
	}

	public static class VilagerMetadata extends AgeableMetadata {

		public void setVillagerType(byte type) {
			setMeta(16, type);
		}

		public Object getVillagerType() {
			return getMeta(16);
		}
	}

	public static class EndermanMetadata extends LivingEntityMetadata {

		public void setEndermanBlock(byte block) {
			setMeta(16, block);
		}

		public void setEndermanBlockData(byte blockData) {
			setMeta(17, blockData);
		}

		public void setEndermanScreaming(byte value) {
			setMeta(18, value);
		}

		public Object getEndermanBlock() {
			return getMeta(16);
		}

		public Object getEndermanBlockData() {
			return getMeta(17);
		}

		public Object getEndermanScreaming() {
			return getMeta(18);
		}

	}

	public static class ZombieMetadata extends LivingEntityMetadata {

		public void setZombieChid(byte child) {
			setMeta(12, child);
		}

		public void setZombieVillager(byte villager) {
			setMeta(13, villager);
		}

		public void setZombieConverting(byte converting) {
			setMeta(14, converting);
		}

		public Object getZombieChid() {
			return getMeta(12);
		}

		public Object getZombieVillager() {
			return getMeta(13);
		}

		public Object getZombieConverting() {
			return getMeta(14);
		}
	}

	public static class PigZombieMetadata extends ZombieMetadata {
	}

	public static class BlazeMetadata extends LivingEntityMetadata {

		public void setBlazeOnFire(byte onFire) {
			setMeta(16, onFire);
		}

		public Object getBlazeOnFire() {
			return getMeta(16);
		}
	}

	public static class SpiderMetadata extends LivingEntityMetadata {

		public void setSpiderClimbing(byte climbing) {
			setMeta(16, climbing);
		}

		public Object getSpiderClimbing() {
			return getMeta(16);
		}
	}

	public static class CaveSpiderMetadata extends SpiderMetadata {
	}

	public static class CreeperMetadata extends LivingEntityMetadata {
		public void setCreeperState(byte flags) {
			setMeta(16, flags);
		}

		public void setCreeperCharged(byte charged) {
			setMeta(17, charged);
		}

		public Object getCreeperState() {
			return getMeta(16);
		}

		public Object getCreeperCharged() {
			return getMeta(17);
		}
	}

	public static class GhastMetadata extends LivingEntityMetadata {

		public void setGhastAttacking(byte attacking) {
			setMeta(17, attacking);
		}

		public Object getGhastAttacking() {
			return getMeta(16);
		}
	}

	public static class SlimeMetadata extends LivingEntityMetadata {
		public void setSlimeSlze(byte size) {
			setMeta(16, size);
		}

		public Object getSlimeSlze() {
			return getMeta(16);
		}

	}

	public static class MagmaCubeMetadata extends SlimeMetadata {

	}

	public static class SkeletonMetadata extends LivingEntityMetadata {
		public void setSkeletonType(byte type) {
			setMeta(13, type);
		}

		public Object getSkeletonType() {
			return getMeta(13);
		}
	}

	public static class WitchMetadata extends LivingEntityMetadata {

		public void setWitchAgro(byte agro) {
			setMeta(21, agro);
		}

		public Object getWitchAgro() {
			return getMeta(21);
		}
	}

	public static class IronGolemMetadata extends LivingEntityMetadata {
		public void setIronGolemPlayerCreated(byte value) {
			setMeta(16, value);
		}

		public Object getIronGolemPlayerCreated() {
			return getMeta(16);
		}
	}

	public static class WitherMetadata extends LivingEntityMetadata {
		public void setWitherHeadTarget1(int target) {
			setMeta(17, target);
		}

		public void setWitherHeadTarget2(int target) {
			setMeta(18, target);
		}

		public void setWitherHeadTarget3(int target) {
			setMeta(19, target);
		}

		public void setWitherInvulnerableTime(int time) {
			setMeta(20, time);
		}

		public Object getWitherHeadTarget1() {
			return getMeta(17);
		}

		public Object getWitherHeadTarget2() {
			return getMeta(18);
		}

		public Object getWitherHeadTarget3() {
			return getMeta(19);
		}

		public Object getWitherInvulnerableTime() {
			return getMeta(20);
		}
	}

	public static class BoatMetadata extends EntityMetadata {
		public void setBoatTimeSinceHit(int time) {
			setMeta(17, time);
		}

		public void setBoatFowardDirection(int dir) {
			setMeta(18, dir);
		}

		public void setBoatDamage(int damage) {
			setMeta(19, damage);
		}

		public Object getBoatTimeSinceHit() {
			return getMeta(17);
		}

		public Object getBoatFowardDirection() {
			return getMeta(18);
		}

		public Object getBoatDamage() {
			return getMeta(19);
		}
	}

	public static class MinecartMetadata extends EntityMetadata {
		public void setMinecraftShakingPower(int power) {
			setMeta(17, power);
		}

		public void setMinecartSkakeingDirection(int dir) {
			setMeta(18, dir);
		}

		public void setMinecartDamage(float damage) {
			setMeta(19, damage);
		}

		public void setBlockInMinecart(int block) {
			setMeta(20, block);
		}

		public void setMinecraftBlockYOffest(int y) {
			setMeta(21, y);
		}

		public void setShowMinecartBlock(byte value) {
			setMeta(22, value);
		}

		public Object getMinecraftShakingPower() {
			return getMeta(17);
		}

		public Object getMinecartSkakeingDirection() {
			return getMeta(18);
		}

		public Object getMinecartDamage() {
			return getMeta(19);
		}

		public Object getBlockInMinecart() {
			return getMeta(20);
		}

		public Object getMinecraftBlockYOffest() {
			return getMeta(21);
		}

		public Object getShowMinecartBlock() {
			return getMeta(22);
		}

	}

	public static class FurnaceMinecartMetadata extends MinecartMetadata {

		public void setFurnaceMinecartPowered(byte powered) {
			setMeta(16, powered);
		}

		public Object getFurnaceMinecartPowered() {
			return getMeta(16);
		}
	}

	public static class ItemMetadata extends EntityMetadata {
		public void setItem(ItemStack item) {
			setMeta(10, item);
		}

		public Object getItem() {
			return getMeta(10);
		}
	}

	public static class ArrowMetadata extends EntityMetadata {
		public void setArrowCriticalHit(byte value) {
			setMeta(16, value);
		}

		public Object getArrowCriticalHit(byte value) {
			return getMeta(16);
		}
	}

	/**
	 * ProtocolLib does not yet support this function
	 */
	public static class FireworkMetadata extends EntityMetadata {
		public void setFireworkInfo() {
		}

		/**
		 * ProtocolLib does not yet support return this function
		 */
		public Object getFireworkInfo() {
			return null;
		}
	}

	public static class ItemFrameMetadata extends EntityMetadata {
		public void setItemFrameItem(ItemStack item) {
			setMeta(2, item);
		}

		public void setItemFrameRotation(byte rotation) {
			setMeta(3, rotation);
		}

		public Object getItemFrameItem() {
			return getMeta(2);
		}

		public Object getItemFrameRotation(byte rotation) {
			return getMeta(3);
		}
	}

	public static class EnderCrystalMetadata extends EntityMetadata {
		public void setEnderCrystalAlive(byte health) {
			setMeta(8, health);
		}

		public Object getEnderCrystalAlive(byte health) {
			return getMeta(8);
		}
	}

	protected void setMeta(int index, Object o) {
		metadata.setObject(index, o);
	}

	protected Object getMeta(int index) {
		return metadata.getObject(index);
	}
}
