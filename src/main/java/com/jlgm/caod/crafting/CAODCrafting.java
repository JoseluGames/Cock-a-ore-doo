package com.jlgm.caod.crafting;

import com.jlgm.caod.item.CAODItem;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CAODCrafting {
	public static void registerCrafting(){
		GameRegistry.addShapelessRecipe(new ItemStack(Items.COAL), new Object[]{CAODItem.coalEgg, CAODItem.coalEgg});
		GameRegistry.addRecipe(new ItemStack(Items.IRON_INGOT), new Object[]{"###", "# #", "###", '#', CAODItem.ironEgg});
		GameRegistry.addRecipe(new ItemStack(Items.GOLD_INGOT), new Object[]{"###", "# #", "###", '#', CAODItem.goldEgg});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 1, 4), new Object[]{CAODItem.lapisEgg, CAODItem.lapisEgg});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.REDSTONE), new Object[]{CAODItem.redstoneEgg, CAODItem.redstoneEgg});
		GameRegistry.addRecipe(new ItemStack(Items.DIAMOND), new Object[]{"###", "###", "###", '#', CAODItem.diamondEgg});
	}
}
