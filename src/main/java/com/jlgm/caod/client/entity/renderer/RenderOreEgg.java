package com.jlgm.caod.client.entity.renderer;

import com.jlgm.caod.entity.EntityOreEgg;

import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RenderOreEgg extends RenderSnowball<EntityOreEgg>{

	public RenderOreEgg(RenderManager renderManagerIn, RenderItem itemRendererIn) {
		super(renderManagerIn, null, itemRendererIn);
	}

    public ItemStack getStackToRender(EntityOreEgg entityIn){
        return new ItemStack(entityIn.getType().getDrop());
    }
}
