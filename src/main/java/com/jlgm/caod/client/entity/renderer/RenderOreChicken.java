package com.jlgm.caod.client.entity.renderer;

import com.jlgm.caod.entity.EntityOreChicken;
import com.jlgm.caod.lib.CAODConstants;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderOreChicken extends RenderLiving<EntityOreChicken>{

    private static final ResourceLocation CHICKEN_BODY = new ResourceLocation(CAODConstants.MODID, "textures/entity/chicken_body.png");
    
	public RenderOreChicken(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
		this.addLayer(new LayerOreChicken(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityOreChicken entity) {
        return CHICKEN_BODY;
	}

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityOreChicken livingBase, float partialTicks)
    {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}
