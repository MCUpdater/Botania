/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * File Created @ [Mar 21, 2014, 8:44:35 PM (GMT)]
 */
package vazkii.botania.common.item;

import java.util.Locale;

import javax.annotation.Nonnull;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vazkii.botania.client.lib.LibResources;
import vazkii.botania.client.render.IModelRegister;
import vazkii.botania.common.achievement.ModAchievements;
import vazkii.botania.common.core.BotaniaCreativeTab;
import vazkii.botania.common.lib.LibItemNames;
import vazkii.botania.common.lib.LibMisc;

public class ItemManaCookie extends ItemFood implements IModelRegister {

	public ItemManaCookie() {
		super(0, 0.1F, false);
		setPotionEffect(new PotionEffect(MobEffects.SATURATION, 20, 0), 1F);
		setCreativeTab(BotaniaCreativeTab.INSTANCE);
		GameRegistry.register(this, new ResourceLocation(LibMisc.MOD_ID, LibItemNames.MANA_COOKIE));
		setUnlocalizedName(LibItemNames.MANA_COOKIE);
		addPropertyOverride(new ResourceLocation(LibMisc.MOD_ID, "totalbiscuit"),
				(stack, worldIn, entityIn) -> stack.getDisplayName().toLowerCase(Locale.ROOT).contains("totalbiscuit") ? 1F : 0F);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, @Nonnull EntityPlayer player) {
		super.onFoodEaten(stack, world, player);
		player.addStat(ModAchievements.manaCookieEat, 1);
	}

	@Nonnull
	@Override
	public String getUnlocalizedNameInefficiently(@Nonnull ItemStack par1ItemStack) {
		return super.getUnlocalizedNameInefficiently(par1ItemStack).replaceAll("item.", "item." + LibResources.PREFIX_MOD);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}
