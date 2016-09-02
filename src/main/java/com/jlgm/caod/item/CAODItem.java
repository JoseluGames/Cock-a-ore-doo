package com.jlgm.caod.item;

import com.jlgm.caod.lib.CAODConstants;
import com.jlgm.caod.lib.CAODHelper.EnumChickenType;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CAODItem{
	
	public static Item coalEgg;
	public static Item ironEgg;
	public static Item goldEgg;
	public static Item lapisEgg;
	public static Item redstoneEgg;
	public static Item emeraldEgg;
	public static Item diamondEgg;
	
	public static void main(Configuration config){
		initialiseItem();
	}

	public static void initialiseItem(){
		coalEgg = new ItemOreEgg(EnumChickenType.COAL).setUnlocalizedName("oreEgg_coal").setCreativeTab(CreativeTabs.MATERIALS);
		ironEgg = new ItemOreEgg(EnumChickenType.IRON).setUnlocalizedName("oreEgg_iron").setCreativeTab(CreativeTabs.MATERIALS);
		goldEgg = new ItemOreEgg(EnumChickenType.GOLD).setUnlocalizedName("oreEgg_gold").setCreativeTab(CreativeTabs.MATERIALS);
		lapisEgg = new ItemOreEgg(EnumChickenType.LAPIS).setUnlocalizedName("oreEgg_lapis").setCreativeTab(CreativeTabs.MATERIALS);
		redstoneEgg = new ItemOreEgg(EnumChickenType.REDSTONE).setUnlocalizedName("oreEgg_redstone").setCreativeTab(CreativeTabs.MATERIALS);
		emeraldEgg = new ItemOreEgg(EnumChickenType.EMERALD).setUnlocalizedName("oreEgg_emerald").setCreativeTab(CreativeTabs.MATERIALS);
		diamondEgg = new ItemOreEgg(EnumChickenType.DIAMOND).setUnlocalizedName("oreEgg_diamond").setCreativeTab(CreativeTabs.MATERIALS);
	}

	public static void registerItem(){
		GameRegistry.register(coalEgg.setRegistryName("oreEgg_coal"));
		GameRegistry.register(ironEgg.setRegistryName("oreEgg_iron"));
		GameRegistry.register(goldEgg.setRegistryName("oreEgg_gold"));
		GameRegistry.register(lapisEgg.setRegistryName("oreEgg_lapis"));
		GameRegistry.register(redstoneEgg.setRegistryName("oreEgg_redstone"));
		GameRegistry.register(emeraldEgg.setRegistryName("oreEgg_emerald"));
		GameRegistry.register(diamondEgg.setRegistryName("oreEgg_diamond"));
	}

	public static void renderItem(){
		ItemModelMesher modelMesherItem = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		modelMesherItem.register(coalEgg, 0, new ModelResourceLocation(CAODConstants.MODID + ":" + "oreEgg_coal", "inventory"));
		modelMesherItem.register(ironEgg, 0, new ModelResourceLocation(CAODConstants.MODID + ":" + "oreEgg_iron", "inventory"));
		modelMesherItem.register(goldEgg, 0, new ModelResourceLocation(CAODConstants.MODID + ":" + "oreEgg_gold", "inventory"));
		modelMesherItem.register(lapisEgg, 0, new ModelResourceLocation(CAODConstants.MODID + ":" + "oreEgg_lapis", "inventory"));
		modelMesherItem.register(redstoneEgg, 0, new ModelResourceLocation(CAODConstants.MODID + ":" + "oreEgg_redstone", "inventory"));
		modelMesherItem.register(emeraldEgg, 0, new ModelResourceLocation(CAODConstants.MODID + ":" + "oreEgg_emerald", "inventory"));
		modelMesherItem.register(diamondEgg, 0, new ModelResourceLocation(CAODConstants.MODID + ":" + "oreEgg_diamond", "inventory"));
	}
}
