package com.jlgm.caod.block;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraftforge.common.config.Configuration;

public class CAODBlock{

	public static void main(Configuration config){
		initialiseBlock();
	}

	public static void initialiseBlock(){

	}

	public static void registerBlock(){

	}

	public static void renderBlock(){
		ItemModelMesher modelMesherItem = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

	}
}
