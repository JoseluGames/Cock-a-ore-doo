package com.jlgm.caod.crafting;

import com.jlgm.caod.item.CAODItem;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CAODCrafting {
	public static void registerCrafting(){
		GameRegistry.addRecipe(new ItemStack(Items.COAL, 2), new Object[]{"##", "##", '#', CAODItem.coalEgg});
		GameRegistry.addRecipe(new ItemStack(Items.IRON_INGOT), new Object[]{"##", "##", '#', CAODItem.ironEgg});
		GameRegistry.addRecipe(new ItemStack(Items.GOLD_INGOT), new Object[]{"##", "##", '#', CAODItem.goldEgg});
		GameRegistry.addRecipe(new ItemStack(Items.DYE, 4, 4), new Object[]{"##", "##", '#', CAODItem.lapisEgg});
		GameRegistry.addRecipe(new ItemStack(Items.REDSTONE, 4), new Object[]{"##", "##", '#', CAODItem.redstoneEgg});
		GameRegistry.addRecipe(new ItemStack(Items.GLOWSTONE_DUST, 4), new Object[]{"##", "##", '#', CAODItem.glowstoneEgg});
		GameRegistry.addRecipe(new ItemStack(Items.EMERALD), new Object[]{"##", "##", '#', CAODItem.emeraldEgg});
		GameRegistry.addRecipe(new ItemStack(Items.DIAMOND), new Object[]{"##", "##", '#', CAODItem.diamondEgg});
	}
}
