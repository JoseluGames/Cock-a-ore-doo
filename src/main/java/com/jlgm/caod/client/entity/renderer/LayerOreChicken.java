package com.jlgm.caod.client.entity.renderer;

import com.jlgm.caod.entity.EntityOreChicken;
import com.jlgm.caod.lib.CAODConstants;
import com.jlgm.caod.lib.CAODHelper;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

public class LayerOreChicken implements LayerRenderer<EntityOreChicken>{
	
    private static final ResourceLocation CHICKEN_PLUMAGE = new ResourceLocation(CAODConstants.MODID, "textures/entity/chicken_plumage.png");
    private final RenderOreChicken renderer;
    
    public LayerOreChicken(RenderOreChicken renderer){
    	this.renderer = renderer;
    }
    
	@Override
	public void doRenderLayer(EntityOreChicken entityorechicken, float limbSwing, float limbSwingAmount,
			float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.renderer.bindTexture(CHICKEN_PLUMAGE);
		Vec3d color = entityorechicken.getType().getFloatColor();
		GlStateManager.color((float) color.xCoord, (float) color.yCoord, (float) color.zCoord);
		this.renderer.getMainModel().render(entityorechicken, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}

	@Override
	public boolean shouldCombineTextures() {
		return true;
	}

}
