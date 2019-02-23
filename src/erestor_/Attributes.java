package erestor_;

import java.util.Random;

import net.minecraft.server.v1_13_R2.NBTTagCompound;
import net.minecraft.server.v1_13_R2.NBTTagDouble;
import net.minecraft.server.v1_13_R2.NBTTagList;
import net.minecraft.server.v1_13_R2.NBTTagLong;
import net.minecraft.server.v1_13_R2.NBTTagString;
import net.minecraft.server.v1_13_R2.NBTTagByte;

import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class Attributes {

		//setAttribute
			static ItemStack setAttribute(ItemStack itemStack, String attributeName, double value, String slot) {
				net.minecraft.server.v1_13_R2.ItemStack nmsStack = CraftItemStack.asNMSCopy(itemStack);
				
				NBTTagCompound compound = nmsStack.getTag();
				if (compound == null) {
					compound = new NBTTagCompound();
					nmsStack.setTag(compound);
					compound = nmsStack.getTag();
				}
				NBTTagList modifiers = compound.getList("AttributeModifiers", 10);
				
				Random R = new Random();
				long r = R.nextInt(50000) + 1;
				
				Random R2 = new Random();
				long r2 = R2.nextInt(100000) + 50001;
				
				NBTTagCompound attribute = new NBTTagCompound();
				attribute.set("AttributeName", new NBTTagString(attributeName));
				attribute.set("Name", new NBTTagString("IXL-" + attributeName));
				attribute.set("Amount", new NBTTagDouble(value));
				attribute.set("Operation", new NBTTagByte((byte) 0));
				attribute.set("UUIDLeast", new NBTTagLong(r));
				attribute.set("UUIDMost", new NBTTagLong(r2));
				attribute.set("Slot", new NBTTagString(slot));
				
				modifiers.add(attribute);
				// Unbreakable 
				compound.setBoolean("Unbreakable", true);
				//////////////
				compound.set("AttributeModifiers", modifiers);
				nmsStack.setTag(compound);
				
				return CraftItemStack.asBukkitCopy(nmsStack);
			}
			
		//setBreakableAttribute
			static ItemStack setBreakableAttribute(ItemStack itemStack, String attributeName, double value, String slot) {
				net.minecraft.server.v1_13_R2.ItemStack nmsStack = CraftItemStack.asNMSCopy(itemStack);
				
				NBTTagCompound compound = nmsStack.getTag();
				if (compound == null) {
					compound = new NBTTagCompound();
					nmsStack.setTag(compound);
					compound = nmsStack.getTag();
				}
				NBTTagList modifiers = compound.getList("AttributeModifiers", 10);
				
				Random R = new Random();
				long r = R.nextInt(50000) + 1;
				
				Random R2 = new Random();
				long r2 = R2.nextInt(100000) + 50001;
				
				NBTTagCompound attribute = new NBTTagCompound();
				attribute.set("AttributeName", new NBTTagString(attributeName));
				attribute.set("Name", new NBTTagString("IXL-" + attributeName));
				attribute.set("Amount", new NBTTagDouble(value));
				attribute.set("Operation", new NBTTagByte((byte) 0));
				attribute.set("UUIDLeast", new NBTTagLong(r));
				attribute.set("UUIDMost", new NBTTagLong(r2));
				attribute.set("Slot", new NBTTagString(slot));
				
				modifiers.add(attribute);
				// Unbreakable 
				compound.setBoolean("Unbreakable", false);
				//////////////
				compound.set("AttributeModifiers", modifiers);
				nmsStack.setTag(compound);
				
				return CraftItemStack.asBukkitCopy(nmsStack);
			}
}