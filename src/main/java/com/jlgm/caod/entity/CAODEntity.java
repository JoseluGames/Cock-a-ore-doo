package com.jlgm.caod.entity;

import com.jlgm.caod.client.entity.renderer.RenderOreChicken;
import com.jlgm.caod.client.entity.renderer.RenderOreEgg;
import com.jlgm.caod.main.CAODMain;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class CAODEntity{

	public static void main(Configuration config){
		registerEntity();
	}

	public static void registerEntity(){
		EntityRegistry.registerModEntity(EntityOreChicken.class, "oreChicken", 0, CAODMain.instance, 80, 3, false/*, 0xFF0000, 0xAA0000*/);
		EntityRegistry.registerModEntity(EntityOreEgg.class, "oreEgg", 1, CAODMain.instance, 80, 3, true);
		addNaturalSpawns();
	}

	public static void addNaturalSpawns(){

	}

	public static void renderEntity(){
		RenderingRegistry.registerEntityRenderingHandler(EntityOreChicken.class, new IRenderFactory<EntityOreChicken>(){
			@Override
			public Render <? super EntityOreChicken> createRenderFor(RenderManager manager){
				return new RenderOreChicken(manager, new ModelChicken(), 0.3F);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntityOreEgg.class, new IRenderFactory<EntityOreEgg>(){
			@Override
			public Render <? super EntityOreEgg> createRenderFor(RenderManager manager){
				return new RenderOreEgg(manager, Minecraft.getMinecraft().getRenderItem());
			}
		});
	}
}
