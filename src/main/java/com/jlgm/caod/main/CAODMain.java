package com.jlgm.caod.main;

import com.jlgm.caod.lib.CAODConfigStorage;
import com.jlgm.caod.lib.CAODConstants;
import com.jlgm.caod.lib.CAODVersionChecker;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = CAODConstants.MODID,
	name = CAODConstants.NAME,
	version = CAODConstants.VERSION,
	acceptedMinecraftVersions = CAODConstants.ACCEPTEDMINECRAFTVERSIONS)

public class CAODMain{

	public static CAODConfigStorage configStorage;
	public static CAODVersionChecker versionChecker;
	public static boolean haveWarnedVersionOutOfDate = false;

	@SidedProxy(clientSide = CAODConstants.CLIENT_PROXY, serverSide = CAODConstants.SERVER_PROXY)
	public static CAODCommonProxy proxy;
	@Instance(CAODConstants.MODID)
	public static CAODMain instance;

	@EventHandler
	public static void PreInit(FMLPreInitializationEvent preInitEvent){
		configStorage = new CAODConfigStorage();
		proxy.preInit(preInitEvent);
	}

	@EventHandler
	public static void Init(FMLInitializationEvent initEvent){
		proxy.init(initEvent);
	}

	@EventHandler
	public static void PostInit(FMLPostInitializationEvent postInitEvent){
		proxy.postInit(postInitEvent);
	}
}
