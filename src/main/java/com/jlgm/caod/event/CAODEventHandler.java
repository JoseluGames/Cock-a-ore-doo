package com.jlgm.caod.event;

import java.util.UUID;

import com.jlgm.caod.entity.EntityOreChicken;
import com.jlgm.caod.lib.CAODHelper;
import com.jlgm.caod.main.CAODMain;
import com.jlgm.caod.network.CAODChickenMessage;
import com.jlgm.caod.network.CAODPacketHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;

public class CAODEventHandler{

	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onPlayerTickEvent(PlayerTickEvent event){
		if(!CAODMain.haveWarnedVersionOutOfDate && event.player.worldObj.isRemote && !CAODMain.versionChecker.isLatestVersion()){
			ClickEvent versionCheckChatClickEvent = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://minecraft.curseforge.com/projects/Cock-an-ore-doo");
			Style clickableChatStyle = new Style().setClickEvent(versionCheckChatClickEvent).setColor(TextFormatting.GREEN);
			TextComponentString versionWarningChatComponent = new TextComponentString("Cock-an-ore-doo is outdated! Click here to update to ");
			TextComponentString versionComponent = new TextComponentString(CAODMain.versionChecker.getLatestVersionInfo().get(0));
			versionComponent.setStyle(new Style().setColor(TextFormatting.RED).setBold(true).setUnderlined(true));
			versionWarningChatComponent.setStyle(clickableChatStyle);
			versionWarningChatComponent.appendSibling(versionComponent);
			event.player.addChatMessage(versionWarningChatComponent);
			event.player.addChatComponentMessage(new TextComponentString("Changelog: ").setStyle(new Style().setColor(TextFormatting.YELLOW)));
			for(int i = 1; i < CAODMain.versionChecker.getLatestVersionInfo().size(); i++){
				event.player.addChatMessage(new TextComponentString("- " + CAODMain.versionChecker.getLatestVersionInfo().get(i)).setStyle(new Style().setColor(TextFormatting.YELLOW)));
			}
			CAODMain.haveWarnedVersionOutOfDate = true;
		}
	}
	
	
	private Entity currentChicken;
	
	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent.EntityInteractSpecific event){
		if(event.getTarget() instanceof EntityChicken && !(event.getTarget() instanceof EntityOreChicken)
				&& event.getTarget() != currentChicken && !event.getWorld().isRemote && event.getSide() == Side.SERVER){
			if(CAODHelper.isOreValid(event.getItemStack())){
				currentChicken = event.getTarget();
				NBTTagCompound chickenTag = event.getTarget().serializeNBT();
				event.getTarget().setDead();
				chickenTag.setString("id", EntityList.getEntityStringFromClass(EntityOreChicken.class));
				EntityOreChicken newChicken = (EntityOreChicken) EntityList.createEntityFromNBT(chickenTag, event.getWorld());
				newChicken.setUniqueId(UUID.randomUUID());
				event.getWorld().spawnEntityInWorld(newChicken);
				newChicken.setType(CAODHelper.getTypeFromItem(event.getItemStack()));
				if(!event.getEntityPlayer().isCreative()){
					event.getEntityPlayer().inventory.decrStackSize(event.getEntityPlayer().inventory.currentItem, 1);
				}
				CAODPacketHandler.INSTANCE.sendToAll(new CAODChickenMessage(newChicken.getPersistentID(), newChicken.getType().getIndex()));
			}
		}
	}
}
