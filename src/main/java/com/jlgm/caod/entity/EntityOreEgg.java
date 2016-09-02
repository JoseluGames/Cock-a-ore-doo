package com.jlgm.caod.entity;

import com.jlgm.caod.lib.CAODHelper.EnumChickenType;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.item.Item;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityOreEgg extends EntityEgg{
	
	private static final DataParameter<Integer> TYPE = EntityDataManager.<Integer>createKey(EntityOreChicken.class, DataSerializers.VARINT);
	
	public EntityOreEgg(World worldIn){
	    super(worldIn);
	}
	
	public EntityOreEgg(World worldIn, EntityLivingBase throwerIn){
	    super(worldIn, throwerIn);
	}
	
	public EntityOreEgg(World worldIn, double x, double y, double z){
	    super(worldIn, x, y, z);
	}
	
	@Override
    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(TYPE, 0);
    }
	
    protected void onImpact(RayTraceResult result){
        if (result.entityHit != null)
        {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0)
        {
            int i = 1;

            if (this.rand.nextInt(32) == 0)
            {
                i = 4;
            }

            for (int j = 0; j < i; ++j)
            {
                EntityOreChicken entityorechicken = new EntityOreChicken(this.worldObj);
                entityorechicken.setType(this.getType());
                entityorechicken.setGrowingAge(-24000);
                entityorechicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                this.worldObj.spawnEntityInWorld(entityorechicken);
            }
        }

        double d0 = 0.08D;

        for (int k = 0; k < 8; ++k)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, new int[] {Item.getIdFromItem(this.getType().getDrop())});
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
	
	public void setType(EnumChickenType type){
		this.dataManager.set(TYPE, type.getIndex());
	}
	
	public EnumChickenType getType(){
		return EnumChickenType.fromIndex(this.dataManager.get(TYPE));
	}
}
