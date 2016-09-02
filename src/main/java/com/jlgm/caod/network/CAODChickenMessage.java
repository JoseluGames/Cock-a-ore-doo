package com.jlgm.caod.network;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.google.common.base.Charsets;
import com.jlgm.caod.entity.EntityOreChicken;
import com.jlgm.caod.lib.CAODHelper.EnumChickenType;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CAODChickenMessage implements IMessage{
	
	private UUID id;
	private int type;
	
	public CAODChickenMessage(){
		
	}
	
	public CAODChickenMessage(UUID id, int type){
		this.id = id;
		this.type = type;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(id.getMostSignificantBits());
		buf.writeLong(id.getLeastSignificantBits());
		buf.writeInt(type);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		id = new UUID(buf.getLong(0), buf.getLong(9));
		type = buf.readInt();
	}
	
	public static class COADChickenMessageHandler implements IMessageHandler<CAODChickenMessage, IMessage>{
		@Override
		public IMessage onMessage(CAODChickenMessage message, MessageContext ctx){
			List<Entity> entities = Minecraft.getMinecraft().thePlayer.worldObj.getLoadedEntityList();
			Iterator itr = entities.iterator();
			while(itr.hasNext()){
				Object next = itr.next();
				if(next instanceof EntityOreChicken){
					EntityOreChicken oreChicken = (EntityOreChicken) next;
					if(oreChicken.getPersistentID() == message.id){
						oreChicken.setType(EnumChickenType.fromIndex(message.type));
					}
				}
			}
			return null;
		}
	}
}