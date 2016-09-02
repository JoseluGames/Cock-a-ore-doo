package com.jlgm.caod.main;

import com.jlgm.caod.block.CAODBlock;
import com.jlgm.caod.item.CAODItem;
import com.jlgm.caod.tileentity.CAODTileEntity;
import com.jlgm.caod.entity.CAODEntity;
import com.jlgm.caod.lib.CAODVersionChecker;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

public class CAODClientProxy extends CAODCommonProxy{

	@Override
	public void preInit(FMLPreInitializationEvent preInitEvent){
		super.preInit(preInitEvent);
		CAODEntity.renderEntity();
	}

	@Override
	public void init(FMLInitializationEvent initEvent){
		super.init(initEvent);
		CAODBlock.renderBlock();
		CAODItem.renderItem();
		CAODTileEntity.renderTileEntity();
	}

	@Override
	public void postInit(FMLPostInitializationEvent postInitEvent){
		super.postInit(postInitEvent);
		CAODMain.versionChecker = new CAODVersionChecker();
		Thread versionCheckThread = new Thread(CAODMain.versionChecker, "VersionCheck");
		versionCheckThread.start();
	}
}
