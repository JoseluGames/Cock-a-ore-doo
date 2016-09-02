package com.jlgm.caod.lib;

import java.util.Map;

import com.google.common.collect.Maps;
import com.jlgm.caod.item.CAODItem;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;

public class CAODHelper {
	public static boolean isOreValid(ItemStack stack){
		return stack.getItem() == Items.EMERALD || stack.getItem() == Items.DIAMOND || stack.getItem() == Items.GOLD_INGOT
				|| stack.getItem() == Items.IRON_INGOT || stack.getItem() == Items.COAL
				|| stack.getItem() == Item.getItemFromBlock(Blocks.REDSTONE_BLOCK)
				|| stack.isItemEqual(new ItemStack(Items.DYE, 1, 4));
	}
	
	public static EnumChickenType getTypeFromItem(ItemStack stack){
		if(stack.getItem() == Items.EMERALD){
			return EnumChickenType.EMERALD;
		}else if(stack.getItem() == Items.DIAMOND){
			return EnumChickenType.DIAMOND;
		}else if(stack.getItem() == Items.GOLD_INGOT){
			return EnumChickenType.GOLD;
		}else if(stack.getItem() == Items.IRON_INGOT){
			return EnumChickenType.IRON;
		}else if(stack.getItem() == Items.COAL){
			return EnumChickenType.COAL;
		}else if(stack.getItem() == Item.getItemFromBlock(Blocks.REDSTONE_BLOCK)){
			return EnumChickenType.REDSTONE;
		}else if(stack.isItemEqual(new ItemStack(Items.DYE, 1, 4))){
			return EnumChickenType.LAPIS;
		}
		return null;
	}
	
	public static enum EnumChickenType{
		COAL(0, "coal", new Vec3d(20, 20, 20)),
		IRON(1, "iron", new Vec3d(198, 198, 198)),
		GOLD(2, "gold", new Vec3d(234, 238, 87)),
		LAPIS(3, "lapis", new Vec3d(52, 94, 195)),
		REDSTONE(4, "redstone", new Vec3d(159, 0, 0)),
		EMERALD(5, "emerald", new Vec3d(23, 221, 98)),
		DIAMOND(6, "diamond", new Vec3d(51, 235, 203));

		private final int index;
		private final String type;
		private final Vec3d color;
		
		private static final EnumChickenType[] VALUES = new EnumChickenType[7];
		private static final Map<String, EnumChickenType> NAME_LOOKUP = Maps.<String, EnumChickenType>newHashMap();
		
		private EnumChickenType(int index, String type, Vec3d color){
			this.index = index;
			this.type = type;
			this.color = color;
		}
		
		public String toString(){
			return this.type;
		}
		
		public int getIndex(){
			return this.index;
		}
		
		public Item getDrop(){
			switch(this){
				case COAL:
					return CAODItem.coalEgg;
				case IRON:
					return CAODItem.ironEgg;
				case GOLD:
					return CAODItem.goldEgg;
				case LAPIS:
					return CAODItem.lapisEgg;
				case REDSTONE:
					return CAODItem.redstoneEgg;
				case EMERALD:
					return CAODItem.emeraldEgg;
				case DIAMOND:
					return CAODItem.diamondEgg;
				default:
					return CAODItem.coalEgg;
			}
		}
		
		public Vec3d getRGBColor(){
			return this.color;
		}
		
		public Vec3d getFloatColor(){
			return new Vec3d(this.color.xCoord/255, this.color.yCoord/255, this.color.zCoord/255);
		}
		
		public static EnumChickenType fromName(String name){
			return (EnumChickenType)NAME_LOOKUP.get(name.toLowerCase());
		}
		
		public static EnumChickenType fromIndex(int index){
			return VALUES[index];
		}
		
		static{
			for(EnumChickenType enumChickenType : values()){
				VALUES[enumChickenType.getIndex()] = enumChickenType;
				NAME_LOOKUP.put(enumChickenType.toString().toLowerCase(), enumChickenType);
			}
		}
	}
}
