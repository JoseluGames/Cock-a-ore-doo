package com.jlgm.caod.main;

import com.jlgm.caod.block.CAODBlock;
import com.jlgm.caod.crafting.CAODCrafting;
import com.jlgm.caod.item.CAODItem;
import com.jlgm.caod.network.CAODPacketHandler;
import com.jlgm.caod.tileentity.CAODTileEntity;
import com.jlgm.caod.creativetab.CAODCreativeTab;
import com.jlgm.caod.entity.CAODEntity;
import com.jlgm.caod.event.CAODEventHandler;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class CAODCommonProxy{

	public void preInit(FMLPreInitializationEvent preInitEvent){
		Configuration config = new Configuration(preInitEvent.getSuggestedConfigurationFile());
		config.load();
		
		config.save();
		
		CAODPacketHandler.registerMessage();
		CAODBlock.main(config);
		CAODItem.main(config);
		CAODTileEntity.main(config);
		CAODCreativeTab.main(config);
		CAODEntity.main(config);
	}

	public void init(FMLInitializationEvent initEvent){
		CAODBlock.registerBlock();
		CAODItem.registerItem();
		CAODCrafting.registerCrafting();
		MinecraftForge.EVENT_BUS.register(new CAODEventHandler());
	}

	public void postInit(FMLPostInitializationEvent postInitEvent){

	}
}
