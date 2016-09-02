package com.jlgm.caod.network;

import com.jlgm.caod.lib.CAODConstants;
import com.jlgm.caod.network.CAODChickenMessage.COADChickenMessageHandler;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class CAODPacketHandler {
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(CAODConstants.MODID);
	
	public static void registerMessage(){
		INSTANCE.registerMessage(COADChickenMessageHandler.class, CAODChickenMessage.class, 0, Side.CLIENT);
	}
}