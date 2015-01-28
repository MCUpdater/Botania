/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Jan 28, 2015, 4:27:39 PM (GMT)]
 */
package vazkii.botania.common.achievement;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.block.ItemBlockSpecialFlower;
import vazkii.botania.common.lib.LibAchievementNames;
import vazkii.botania.common.lib.LibBlockNames;
import vazkii.botania.common.lib.LibItemNames;
import vazkii.botania.common.lib.LibMisc;

public final class ModAchievements {

	public static AchievementPage botaniaPage;
	
	public static Achievement flowerPickup;
	public static Achievement lexiconUse;
	public static Achievement daybloomPickup;
	public static Achievement manaPoolPickup;
	public static Achievement endoflamePickup;
	public static Achievement tinyPotatoPet;
	public static Achievement sparkCraft;
	public static Achievement baubleWear;
	public static Achievement manaCookieEat;
	public static Achievement runePickup;
	public static Achievement dirtRodCraft;
	public static Achievement manaBlasterShoot;
	public static Achievement terrasteelPickup;
	public static Achievement terrasteelWeaponCraft;
	public static Achievement elfPortalOpen;
	public static Achievement kekimurusPickup;
	public static Achievement heiseiDreamPickup;
	public static Achievement gaiaGuardianKill;
	public static Achievement spawnerMoverUse;
	public static Achievement tiaraWings;
	
	public static Achievement signalFlareStun;
	public static Achievement l20ShardUse;
	public static Achievement gaiaGuardianNoArmor;
	public static Achievement terrasteelWills;
	public static Achievement rankSSPick;
	
	public static void init() {
		flowerPickup = new AchievementMod(LibAchievementNames.FLOWER_PICKUP, 0, 0, new ItemStack(ModBlocks.flower, 1, 6), null);
		lexiconUse = new AchievementMod(LibAchievementNames.LEXICON_USE, 1, 1, ModItems.lexicon, flowerPickup);
		daybloomPickup = new AchievementMod(LibAchievementNames.DAYBLOOM_PICKUP, 3, 1, ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_DAYBLOOM), lexiconUse);
		manaPoolPickup = new AchievementMod(LibAchievementNames.MANA_POOL_PICKUP, 3, -1, ModBlocks.pool, daybloomPickup);
		
		endoflamePickup = new AchievementMod(LibAchievementNames.ENDOFLAME_PICKUP, 1, -3, ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_ENDOFLAME), manaPoolPickup);
		tinyPotatoPet = new AchievementMod(LibAchievementNames.TINY_POTATO_PET, 2, -5, ModBlocks.tinyPotato, manaPoolPickup);
		sparkCraft = new AchievementMod(LibAchievementNames.SPARK_CRAFT, 4, -5, ModItems.spark, manaPoolPickup);
		baubleWear = new AchievementMod(LibAchievementNames.BAUBLE_WEAR, 5, -3, ModItems.manaRing, manaPoolPickup);
		manaCookieEat = new AchievementMod(LibAchievementNames.MANA_COOKIE_EAT, 3, -7, ModItems.manaCookie, manaPoolPickup);
		runePickup = new AchievementMod(LibAchievementNames.RUNE_PICKUP, 6, 0, ModBlocks.runeAltar, manaPoolPickup);
		
		dirtRodCraft = new AchievementMod(LibAchievementNames.DIRT_ROD_CRAFT, 8, 0, ModItems.dirtRod, runePickup);
		manaBlasterShoot = new AchievementMod(LibAchievementNames.MANA_BLASTER_SHOOT, 8, -2, ModItems.manaGun, runePickup);
		terrasteelPickup = new AchievementMod(LibAchievementNames.TERRASTEEL_PICKUP, 6, 4, new ItemStack(ModItems.manaResource, 1, 4), runePickup).setSpecial();
		
		terrasteelWeaponCraft = new AchievementMod(LibAchievementNames.TERRASTEEL_WEAPON_CRAFT, 8, 5, ModItems.terraSword, terrasteelPickup); 
		elfPortalOpen = new AchievementMod(LibAchievementNames.ELF_PORTAL_OPEN, 4, 4, ModBlocks.alfPortal, terrasteelPickup).setSpecial();
		
		kekimurusPickup = new AchievementMod(LibAchievementNames.KEKIMURUS_PICKUP, 3, 6, ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_KEKIMURUS), elfPortalOpen);
		heiseiDreamPickup = new AchievementMod(LibAchievementNames.HEISEI_DREAM_PICKUP, 5, 6, ItemBlockSpecialFlower.ofType(LibBlockNames.SUBTILE_HEISEI_DREAM), elfPortalOpen);
		gaiaGuardianKill = new AchievementMod(LibAchievementNames.GAIA_GUARDIAN_KILL, 2, 4, new ItemStack(ModItems.manaResource, 1, 5), elfPortalOpen).setSpecial();
		
		spawnerMoverUse = new AchievementMod(LibAchievementNames.SPAWNER_MOVER_USE, -1, 5, ModItems.spawnerMover, gaiaGuardianKill);
		tiaraWings = new AchievementMod(LibAchievementNames.TIARA_WINGS, -1, 3, ModItems.flightTiara, gaiaGuardianKill);
		
		botaniaPage = new AchievementPage(LibMisc.MOD_NAME, AchievementMod.achievements.toArray(new Achievement[AchievementMod.achievements.size()]));
		AchievementPage.registerAchievementPage(botaniaPage);
	}
	
}