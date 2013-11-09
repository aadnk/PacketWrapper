package com.comphenix.packetwrapper;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import com.comphenix.protocol.wrappers.WrappedDataWatcher;

/**
 * A useful wrapper for the Wrapped Data Watcher class, easy to understand and use
 * To be used in the setMetadata(this.getMetadata()) method to set a entity's metadata
 * 
 * YOU MUST SET AT LEAST ONE TYPE OF METADATA OR USERS WILL CRASH APON ENTITY SPAWN
 * 
 * Multiple (type, color, etc...) options generally offer enums, or can be written directly
 * 
 * @author Quantum64
 */

public class EntityMetadata {

	protected WrappedDataWatcher metadata;

	/**
	 * Use: Gets the final metadata for use in the setMetadata(WrappedDataWatcher value) method
	 * @return WrappedDataWatcher - final metadata set
	 */
	public WrappedDataWatcher getMetadata() {
		return metadata;
	}

	public static EntityMetadata newEntityMetadata() {
		return new EntityMetadata();
	}

	public static LivingEntityMetadata newLivingEntityMetadata() {
		return new LivingEntityMetadata();
	}

	public static AgeableMetadata newAgeableMetadata() {
		return new AgeableMetadata();
	}

	public static HorseMetadata newHorseMetadata() {
		return new HorseMetadata();
	}

	public static BatMetadata newBatMetadata() {
		return new BatMetadata();
	}

	public static TameableMetadata newTameableMetadata() {
		return new TameableMetadata();
	}

	public static OcelotMetadata newOcelotMetadata() {
		return new OcelotMetadata();
	}

	public static WolfMetadata newWolfMetadata() {
		return new WolfMetadata();
	}

	public static PigMetadata newPigMetadata() {
		return new PigMetadata();
	}

	public static SheepMetadata newSheepMetadata() {
		return new SheepMetadata();
	}

	public static VillagerMetadata newVillagerMetadata() {
		return new VillagerMetadata();
	}

	public static EndermanMetadata newEndermanMetadata() {
		return new EndermanMetadata();
	}

	public static ZombieMetadata newZombieMetadata() {
		return new ZombieMetadata();
	}

	public static PigZombieMetadata newPigZombieMetadata() {
		return new PigZombieMetadata();
	}

	public static BlazeMetadata newBlazeMetadata() {
		return new BlazeMetadata();
	}

	public static SpiderMetadata newSpiderMetadata() {
		return new SpiderMetadata();
	}

	public static CaveSpiderMetadata newCaveSpiderMetadata() {
		return new CaveSpiderMetadata();
	}

	public static CreeperMetadata newCreeperMetadata() {
		return new CreeperMetadata();
	}

	public static GhastMetadata newGhastMetadata() {
		return new GhastMetadata();
	}

	public static SlimeMetadata newSlimeMetadata() {
		return new SlimeMetadata();
	}

	public static MagmaCubeMetadata newMagmaCubeMetadata() {
		return new MagmaCubeMetadata();
	}

	public static SkeletonMetadata newSkeletonMetadata() {
		return new SkeletonMetadata();
	}

	public static WitchMetadata newWitchMetadata() {
		return new WitchMetadata();
	}

	public static IronGolemMetadata newIronGolemMetadata() {
		return new IronGolemMetadata();
	}

	public static WitherMetadata newWitherMetadata() {
		return new WitherMetadata();
	}

	public static BoatMetadata newBoatMetadata() {
		return new BoatMetadata();
	}

	public static MinecartMetadata newMinecartMetadata() {
		return new MinecartMetadata();
	}

	public static FurnaceMinecartMetadata newFurnaceMinecartMetadata() {
		return new FurnaceMinecartMetadata();
	}

	public static ItemMetadata newItemMetadata() {
		return new ItemMetadata();
	}

	public static ArrowMetadata newArrowMetadata() {
		return new ArrowMetadata();
	}

	public static FireworkMetadata newFireworkMetadata() {
		return new FireworkMetadata();
	}

	public static ItemFrameMetadata newItemFrameMetadata() {
		return new ItemFrameMetadata();
	}

	public static EnderCrystalMetadata newEnderCrystalMetadata() {
		return new EnderCrystalMetadata();
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
	 * Index: 0
	 * Type: Entity
	 * Use: Set entity flags as EntityFlags enum option
	 * @param flags - EntityFlags as an enum
	 */
	public void setFlags(EntityFlags flags) {
		byte a;
		switch (flags) {
		case ON_FIRE:
			a = 0x01 & 0x01;
			break;
		case CROUCHED:
			a = 0x01 & 0x02;
			break;
		case SPRINTING:
			a = 0x01 & 0x08;
			break;
		case EATING_DRINKING_BLOCKING:
			a = 0x01 & 0x10;
			break;
		case INVISIBLE:
			a = 0x01 & 0x20;
			break;
		default:
			a = 0;
		}
		setMeta(0, a);
	}

	/**
	 * Use: Used with the setFlags(EntityFlags flags) method
	 * Contains: Options for entity flags (basic data)
	 */
	public enum EntityFlags {
		ON_FIRE, CROUCHED, SPRINTING, EATING_DRINKING_BLOCKING, INVISIBLE
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

	/**
	 * Index: 0
	 * Type: Entity
	 * Use: Get entity flags as byte
	 * @return flags - Entity flags bit mask: (flags as byte, cast if needed)
	 * 0x01 = On Fire      
	 * 0x02	= Crouched      
	 * 0x08 = Sprinting     
	 * 0x10 = Eating/Drinking/Blocking      
	 * 0x20	 Invisible     
	 */
	public Object getFlags() {
		return getMeta(0);
	}

	/**
	 * Index: 1
	 * Type: Entity
	 * Use: Current time in air - only used in game for Falling Sand Entity
	 * @return air - Current time in air (as a short, cast if needed)
	 */
	public Object getAir() {
		return getMeta(1);
	}

	/**
	 * 
	 * Represents the Metadata of a Living Entity
	 *
	 */
	protected static class LivingEntityMetadata extends EntityMetadata {
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
		 * Use: Set the potion effect color for the Living Entity (Do not assign if you are not going to use potion effect particals!)
		 * @param color -  color of potion effect particals
		 */
		public void setPotionEffectColor(int color) {
			setMeta(7, color);
		}

		/**
		 * Index: 8
		 * Type: Living Entity
		 * Use: Sets if the potion effect particals are visible or not (required feild for a Named Entity, set to zero if you do not want potion effect particals)
		 * @param value - byte 1 or 0 (see potion effect particals = 1, no potion effect particals = 0)
		 */
		public void setPotionEffectAmbient(byte value) {
			setMeta(8, value);
		}

		/**
		 * Index: 9
		 * Type: Living Entity
		 * Use: Sets number of arrows in entity, client will crash if it is more than 254, or less than 1 (do not assign if 0)
		 * @param arrows - number of arrows in entity
		 */
		public void setNumArrowsInEntity(byte arrows) {
			setMeta(9, arrows);
		}

		/**
		 * Index: 10
		 * Type: Living Entity
		 * Use: Sets the name (name tag) of the entity
		 * @param nameTag - Name of Living Entity as a String use '&' for color codes
		 */
		public void setNameTag(String nameTag) {
			setMeta(10, ChatColor.translateAlternateColorCodes('&', nameTag));
		}

		/**
		 * Index: 11
		 * Type: Living Entity
		 * Use: Sets if the name tag of the entity is always visible, even if the player is not looking directly at it
		 * If spawning a Named Entity (Player) the name tag is always visible regardless of this option
		 * @param value - Always see name tag even if not looking at entity (as a byte 0 = false, 1 = true)
		 */
		public void setAlwaysShowNameTag(byte value) {
			setMeta(11, value);
		}

		/**
		 * @return health - returns the health of the Living Entity (as a float, cast if needed)
		 */
		public Object getHealth() {
			return getMeta(6);
		}

		/**
		 * Use: Get the color of the potion effect particals of the Living Entity 
		 * @return color - color of potion effect particals (as an int, cast if needed)
		 */
		public Object getPotionEffectColor() {
			return getMeta(7);
		}

		/**
		 * 
		 * @return value - returns if the potion effect particals are visible (as a byte 0 = false, 1 = true)
		 */
		public Object getPotionEffectAmbient() {
			return getMeta(8);
		}

		/**
		 * 
		 * @return arrows - the number of arrows in the entity (as an byte, cast if needed)
		 */
		public Object getNumArrowsInEntity() {
			return getMeta(9);
		}

		/**
		 * 
		 * @return name - the name (name tag) of the Living Entity (as a String, cast if needed)
		 */
		public Object getNameTag() {
			return getMeta(10);
		}

		/**
		 * 
		 * @return value - Always see name tag even if not looking at entity (as a byte 0 = false, 1 = true)
		 */
		public Object getAlwaysShowNameTag() {
			return getMeta(11);
		}

	}

	/**
	 * 
	 * Represents an Ageable metadata - extends Living Entity
	 * Ageable - can be a child or adult
	 *
	 */
	protected static class AgeableMetadata extends LivingEntityMetadata {
		/**
		 * Index: 12
		 * Type: Ageable
		 * Use: Set the Ageable Entity's age (this effects how soon the entity will grow, age = time adult, really)
		 * @param age - Entity's Age (Negative = Child)
		 */
		public void setEntityAge(int age) {
			setMeta(12, age);
		}

		/**
		 * 
		 * @return age - returns the entity's age (as an int, cast if needed)
		 */
		public Object getEntityAge() {
			return getMeta(12);
		}
	}

	protected static class HorseMetadata extends AgeableMetadata {
		public void setHorseFlags(int flags) {
			setMeta(16, flags);
		}

		public void setHorseFLags(HorseFlags flags) {
			int a;
			switch (flags) {
			case IS_TAME:
				a = 0x01 & 0x02;
				break;
			case HAS_SADDLE:
				a = 0x01 & 0x04;
				break;
			case HAS_CHEST:
				a = 0x01 & 0x08;
			case IS_BRED:
				a = 0x01 & 0x10;
				break;
			case IS_EATING:
				a = 0x01 & 0x20;
				break;
			case IS_REARING:
				a = 0x01 & 0x40;
				break;
			case MOUTH_OPEN:
				a = 0x01 & 0x80;
				break;
			default:
				a = 0;
			}
			setMeta(16, a);
		}

		public enum HorseFlags {
			IS_TAME, HAS_SADDLE, HAS_CHEST, IS_BRED, IS_EATING, IS_REARING, MOUTH_OPEN
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

		public Object getHorseType() {
			return getMeta(19);
		}

		public Object getHorseColorAndTexture() {
			return getMeta(20);
		}

		public Object getHorseOwnerName() {
			return getMeta(21);
		}
	}

	protected static class BatMetadata extends LivingEntityMetadata {
		public void setBatHanging(byte hanging) {
			setMeta(16, hanging);
		}

		public Object getBatHanging() {
			return getMeta(16);
		}
	}

	protected static class TameableMetadata extends AgeableMetadata {

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

	protected static class OcelotMetadata extends TameableMetadata {
		public void setOcelotType(byte type) {
			setMeta(18, type);
		}

		public Object getOcelotType() {
			return getMeta(18);
		}

	}

	protected static class WolfMetadata extends TameableMetadata {
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

	protected static class PigMetadata extends AgeableMetadata {
		public void setHasSaddle(byte value) {
			setMeta(16, value);
		}

		public Object getHasSaddle() {
			return getMeta(16);
		}
	}

	protected static class SheepMetadata extends AgeableMetadata {
		public void setSheepFlags(byte flags) {
			setMeta(16, flags);
		}

		public Object getSheepFlags() {
			return getMeta(16);
		}
	}

	protected static class VillagerMetadata extends AgeableMetadata {

		public void setVillagerType(byte type) {
			setMeta(16, type);
		}

		public Object getVillagerType() {
			return getMeta(16);
		}
	}

	protected static class EndermanMetadata extends LivingEntityMetadata {

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

	protected static class ZombieMetadata extends LivingEntityMetadata {

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

	protected static class PigZombieMetadata extends ZombieMetadata {
	}

	protected static class BlazeMetadata extends LivingEntityMetadata {

		public void setBlazeOnFire(byte onFire) {
			setMeta(16, onFire);
		}

		public Object getBlazeOnFire() {
			return getMeta(16);
		}
	}

	protected static class SpiderMetadata extends LivingEntityMetadata {

		public void setSpiderClimbing(byte climbing) {
			setMeta(16, climbing);
		}

		public Object getSpiderClimbing() {
			return getMeta(16);
		}
	}

	protected static class CaveSpiderMetadata extends SpiderMetadata {
	}

	protected static class CreeperMetadata extends LivingEntityMetadata {
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

	protected static class GhastMetadata extends LivingEntityMetadata {

		public void setGhastAttacking(byte attacking) {
			setMeta(17, attacking);
		}

		public Object getGhastAttacking() {
			return getMeta(16);
		}
	}

	protected static class SlimeMetadata extends LivingEntityMetadata {
		public void setSlimeSlze(byte size) {
			setMeta(16, size);
		}

		public Object getSlimeSlze() {
			return getMeta(16);
		}

	}

	protected static class MagmaCubeMetadata extends SlimeMetadata {

	}

	protected static class SkeletonMetadata extends LivingEntityMetadata {
		public void setSkeletonType(byte type) {
			setMeta(13, type);
		}

		public Object getSkeletonType() {
			return getMeta(13);
		}
	}

	protected static class WitchMetadata extends LivingEntityMetadata {

		public void setWitchAgro(byte agro) {
			setMeta(21, agro);
		}

		public Object getWitchAgro() {
			return getMeta(21);
		}
	}

	protected static class IronGolemMetadata extends LivingEntityMetadata {
		public void setIronGolemPlayerCreated(byte value) {
			setMeta(16, value);
		}

		public Object getIronGolemPlayerCreated() {
			return getMeta(16);
		}
	}

	protected static class WitherMetadata extends LivingEntityMetadata {
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

	protected static class BoatMetadata extends EntityMetadata {
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

	protected static class MinecartMetadata extends EntityMetadata {
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

	protected static class FurnaceMinecartMetadata extends MinecartMetadata {

		public void setFurnaceMinecartPowered(byte powered) {
			setMeta(16, powered);
		}

		public Object getFurnaceMinecartPowered() {
			return getMeta(16);
		}
	}

	protected static class ItemMetadata extends EntityMetadata {
		public void setItem(ItemStack item) {
			setMeta(10, item);
		}

		public Object getItem() {
			return getMeta(10);
		}
	}

	protected static class ArrowMetadata extends EntityMetadata {
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
	protected static class FireworkMetadata extends EntityMetadata {
		public void setFireworkInfo() {
		}

		/**
		 * ProtocolLib does not yet support return this function
		 */
		public Object getFireworkInfo() {
			return null;
		}
	}

	protected static class ItemFrameMetadata extends EntityMetadata {
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

	protected static class EnderCrystalMetadata extends EntityMetadata {
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

	protected boolean getFlag(int index, int mask) {
		return ((Integer) getMeta(index) & mask) != 0;
	}

	protected void setFlag(int index, int mask, boolean value) {
		setMeta(index, ((Integer) getMeta(index) & ~mask) | (value ? mask : 0));
	}
}
