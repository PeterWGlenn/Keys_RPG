package erestor_;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Drops {
	
	// DropItems
	public static void dropsMethod(int percent, Location l, ItemStack item, int amount) {
		Random i = new Random();
	    int trueI = i.nextInt(100 - 1 + 1) + 1;
	    
	    if(trueI <= percent) {
	    	for (int n = 0; n < amount; n++) {
	    		l.getWorld().dropItem(l, item);
	    	}
	    }
	}
	
	// DropCoins
	public static void dropCoinsMethod(int percent, Location l, ItemStack item, int minAmount, int maxAmount) {
		Random i = new Random();
	    int trueI = i.nextInt(100 - 1 + 1) + 1;
	    
		Random a = new Random();
	    int trueA = a.nextInt(maxAmount - minAmount + 1) + minAmount;
	    
	    if(trueI <= percent) {
	    	for (int n = 0; n < trueA; n++) {
	    		l.getWorld().dropItem(l, item);
	    	}
	    }
	}
	
	public static void dropsFunction(Entity e) {
		Location l = e.getLocation();
		
		    // Animals
	    	if(e.getCustomName() == null && !(e instanceof Player)) {
	    		Drops.dropCoinsMethod(100, l, Items.BronzeCoin, 1, 50);
	    	}
	    	
	    	//Arena.arenaMobDeath(e);
		
	 		if (!(e instanceof Player) && (e.getCustomName() != null)) {
	 			//////////////////////////////////////////////////////////// B O S S /////////////////////////////////////////////////////////////////////
	 			if (e.getCustomName().equals(ChatColor.RED + "Governor")) {
	 				Drops.dropsMethod(100, l, Items.IronKey, 1);
	 				Drops.dropsMethod(10, l, Items.GoldHelmet, 1);
	 				Drops.dropsMethod(10, l, Items.GoldSword, 1);
	 				Drops.dropsMethod(10, l, Items.GoldIngot, 5);
	 				Drops.dropsMethod(50, l, Items.IronIngot, 10);
	 				Drops.dropCoinsMethod(100, l, Items.BronzeCoin, 10, 50);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 1, 8);
	 			}
	 			if (e.getCustomName().equals(ChatColor.RED + "Captain of the Guard")) {
	 				Drops.dropsMethod(100, l, Items.GoldKey, 1);
	 				Drops.dropsMethod(10, l, Items.DiamondHelmet, 1);
	 				Drops.dropsMethod(10, l, Items.DiamondChestplate, 1);
	 				Drops.dropsMethod(10, l, Items.GoldLeggings, 1);
	 				Drops.dropsMethod(10, l, Items.DiamondBoots, 1);
	 				Drops.dropsMethod(10, l, Items.DiamondSword, 1);
	 				Drops.dropsMethod(10, l, Items.Diamond, 5);
	 				Drops.dropsMethod(50, l, Items.GoldIngot, 10);
	 				Drops.dropCoinsMethod(100, l, Items.BronzeCoin, 1, 50);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 10, 40);
	 				Drops.dropCoinsMethod(100, l, Items.GoldCoin, 1, 2);
	 			}
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Undead Wall Guard")) {
	 				Drops.dropsMethod(10, l, Items.DiamondHelmet, 1);
	 				Drops.dropsMethod(10, l, Items.IronChestplate, 1);
	 				Drops.dropsMethod(10, l, Items.IronLeggings, 1);
	 				Drops.dropsMethod(10, l, Items.IronBoots, 1);
	 				Drops.dropsMethod(10, l, Items.GoldSword, 1);
	 				Drops.dropsMethod(30, l, Items.GoldIngot, 2);
	 				Drops.dropCoinsMethod(100, l, Items.BronzeCoin, 50, 75);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 5, 20);
	 			}
	 			if (e.getCustomName().equals(ChatColor.RED + "Queen Spider")) {
	 				Drops.dropsMethod(75, l, Items.GoldIngot, 30);
	 				Drops.dropsMethod(75, l, Items.Diamond, 5);
	 				Drops.dropsMethod(75, l, Items.Sapphire, 10);
	 				Drops.dropsMethod(75, l, Items.Ruby, 10);
	 				Drops.dropsMethod(75, l, Items.Emerald, 20);
	 				Drops.dropsMethod(25, l, Items.RustedIronKey, 1);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 10, 20);
	 			}
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Spider Minion")) {
	 				Drops.dropsMethod(33, l, Items.Sapphire, 1);
	 				Drops.dropsMethod(33, l, Items.Ruby, 1);
	 				Drops.dropsMethod(33, l, Items.Emerald, 2);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 1, 2);
	 			}
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Strong Spider Minion")) {
	 				Drops.dropsMethod(33, l, Items.Sapphire, 2);
	 				Drops.dropsMethod(33, l, Items.Ruby, 2);
	 				Drops.dropsMethod(33, l, Items.Emerald, 4);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 5, 10);
	 			}
	 			if (e.getCustomName().equals(ChatColor.RED + "Lake Elder Guardian")) {
	 				Drops.dropsMethod(100, l, Items.PrismarineCrystals, 50);
	 				Drops.dropsMethod(100, l, Items.DiamondKey, 1);
	 				Drops.dropCoinsMethod(100, l, Items.GoldCoin, 1, 1);
	 			}
	 			if (e.getCustomName().equals(ChatColor.BLUE + "Strong Lake Guardian")) {
	 				Drops.dropsMethod(100, l, Items.PrismarineCrystals, 10);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 1, 10);
	 			}
	 			////////////////////////////////////////////////////////// M I N E S //////////////////////////////////////////////////////////////////
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Undead Villager")) {
	 				Drops.dropsMethod(10, l, Items.StrangeIronKey, 1);
	 				Drops.dropsMethod(10, l, Items.WoodHelmet, 1);
	 				Drops.dropsMethod(10, l, Items.WoodKnife, 1);
	 				Drops.dropsMethod(15, l, Items.IronIngot, 2);
	 				Drops.dropCoinsMethod(100, l, Items.BronzeCoin, 10, 75);
	 			}
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Undead Guard")) {
	 				Drops.dropsMethod(15, l, Items.StrangeIronKey, 1);
	 				Drops.dropsMethod(10, l, Items.IronHelmet, 1);
	 				Drops.dropsMethod(10, l, Items.IronChestplate, 1);
	 				Drops.dropsMethod(10, l, Items.WoodLeggings, 1);
	 				Drops.dropsMethod(10, l, Items.WoodBoots, 1);
	 				Drops.dropsMethod(10, l, Items.StoneSword, 1);
	 				Drops.dropsMethod(30, l, Items.IronIngot, 2);
	 				Drops.dropCoinsMethod(100, l, Items.BronzeCoin, 20, 90);
	 			}
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Undead Warrior")) {
	 				Drops.dropsMethod(5, l, Items.RustedIronKey, 1);
	 				Drops.dropsMethod(10, l, Items.IronHelmet, 1);
	 				Drops.dropsMethod(10, l, Items.GoldChestplate, 1);
	 				Drops.dropsMethod(10, l, Items.IronLeggings, 1);
	 				Drops.dropsMethod(10, l, Items.IronBoots, 1);
	 				Drops.dropsMethod(10, l, Items.DiamondBattleaxe, 1);
	 				Drops.dropsMethod(30, l, Items.GoldIngot, 2);
	 				Drops.dropsMethod(5, l, Items.StrangeGoldKey, 1);
	 				Drops.dropCoinsMethod(100, l, Items.BronzeCoin, 1, 10);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 2, 5);	
	 			}
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Strong Undead Warrior")) {
	 				Drops.dropsMethod(5, l, Items.RustedIronKey, 1);
	 				Drops.dropsMethod(10, l, Items.IronHelmet, 1);
	 				Drops.dropsMethod(10, l, Items.DiamondChestplate, 1);
	 				Drops.dropsMethod(10, l, Items.IronLeggings, 1);
	 				Drops.dropsMethod(10, l, Items.IronBoots, 1);
	 				Drops.dropsMethod(10, l, Items.DiamondSword, 1);
	 				Drops.dropsMethod(30, l, Items.Diamond, 2);
	 				Drops.dropsMethod(5, l, Items.StrangeGoldKey, 1);
	 				Drops.dropCoinsMethod(100, l, Items.BronzeCoin, 1, 10);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 3, 6);	
	 			}
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Undead Knight")) {
	 				Drops.dropsMethod(5, l, Items.RustedIronKey, 1);
	 				Drops.dropsMethod(5, l, Items.DiamondHelmet, 1);
	 				Drops.dropsMethod(1, l, Items.MithrilChestplate, 1);
	 				Drops.dropsMethod(5, l, Items.DiamondLeggings, 1);
	 				Drops.dropsMethod(1, l, Items.MithrilBoots, 1);
	 				Drops.dropsMethod(2, l, Items.MithrilSword, 1);
	 				Drops.dropsMethod(30, l, Items.Diamond, 4);
	 				Drops.dropsMethod(30, l, Items.MithrilOre, 2);
	 				Drops.dropsMethod(5, l, Items.MithrilIngot, 1);
	 				Drops.dropsMethod(5, l, Items.StrangeGoldKey, 1);
	 				Drops.dropCoinsMethod(100, l, Items.BronzeCoin, 1, 10);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 5, 8);	
	 			}
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Forest Spider")) {
	 				Drops.dropsMethod(10, l, Items.Emerald, 1);
	 				Drops.dropsMethod(5, l, Items.Ruby, 1);
	 				Drops.dropsMethod(5, l, Items.Sapphire, 1);
	 				Drops.dropCoinsMethod(100, l, Items.BronzeCoin, 1, 90);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 1, 2);
	 			}
	 			if (e.getCustomName().equals(ChatColor.BLUE + "Lake Guardian")) {
	 				Drops.dropsMethod(75, l, Items.PrismarineCrystals, 1);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 1, 10);
	 			}
	 			if (e.getCustomName().equals(ChatColor.BLUE + "Minor Guardian")) {
	 				Drops.dropsMethod(75, l, Items.PrismarineCrystals, 1);
	 				Drops.dropsMethod(15, l, Items.IronIngot, 2);
	 				Drops.dropCoinsMethod(100, l, Items.BronzeCoin, 1, 10);
	 			}
	 			if (e.getCustomName().equals(ChatColor.BLUE + "Guardian")) {
	 				Drops.dropsMethod(75, l, Items.PrismarineCrystals, 1);
	 				Drops.dropsMethod(30, l, Items.IronIngot, 2);
	 				Drops.dropCoinsMethod(100, l, Items.BronzeCoin, 5, 30);
	 			}
	 			if (e.getCustomName().equals(ChatColor.BLUE + "Greater Guardian")) {
	 				Drops.dropsMethod(75, l, Items.PrismarineCrystals, 2);
	 				Drops.dropsMethod(30, l, Items.GoldIngot, 2);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 10, 12);
	 			}
	 			if (e.getCustomName().equals(ChatColor.BLUE + "Strong Guardian")) {
	 				Drops.dropsMethod(75, l, Items.PrismarineCrystals, 3);
	 				Drops.dropsMethod(30, l, Items.Diamond, 2);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 10, 15);
	 			}
	 			if (e.getCustomName().equals(ChatColor.BLUE + "Guardian Elite")) {
	 				Drops.dropsMethod(75, l, Items.PrismarineCrystals, 5);
	 				Drops.dropsMethod(5, l, Items.OldDiamondKey, 1);
	 				Drops.dropsMethod(50, l, Items.MithrilIngot, 1);
	 				Drops.dropsMethod(60, l, Items.MithrilOre, 45);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 10, 40);
	 			}
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Undead Elite")) {
	 				Drops.dropsMethod(2, l, Items.MithrilHelmet, 1);
	 				Drops.dropsMethod(2, l, Items.MithrilChestplate, 1);
	 				Drops.dropsMethod(2, l, Items.MithrilLeggings, 1);
	 				Drops.dropsMethod(2, l, Items.MithrilBoots, 1);
	 				Drops.dropsMethod(2, l, Items.MithrilKnife, 1);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 10, 40);	
	 			}
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Undead Archer")) {
	 				Drops.dropsMethod(10, l, Items.IronHelmet, 1);
	 				Drops.dropsMethod(10, l, Items.IronChestplate, 1);
	 				Drops.dropsMethod(33, l, Items.Emerald, 15);
	 				Drops.dropsMethod(33, l, Items.Sapphire, 7);
	 				Drops.dropsMethod(33, l, Items.Ruby, 7);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 1, 75);	
	 			}
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Undead Scorpion")) {
	 				Drops.dropsMethod(33, l, Items.Emerald, 5);
	 				Drops.dropsMethod(33, l, Items.Ruby, 2);
	 				Drops.dropsMethod(33, l, Items.Sapphire, 2);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 1, 10);
	 			}
	 			
	 			// ARENA
	 			if (e.getCustomName().equals(ChatColor.RED + "Untrained Eastcliff Warrior")) {
	 				Drops.dropsMethod(15, l, Items.Ruby, 2);
	 				Drops.dropCoinsMethod(100, l, Items.PlatinumCoin, 1, 2);
	 				Drops.dropCoinsMethod(100, l, Items.GoldCoin, 1, 2);
	 			}
	 			if (e.getCustomName().equals(ChatColor.RED + "Lesser Eastcliff Warrior")) {
	 				Drops.dropsMethod(15, l, Items.Ruby, 3);
	 				Drops.dropCoinsMethod(100, l, Items.PlatinumCoin, 1, 2);
	 				Drops.dropCoinsMethod(100, l, Items.GoldCoin, 2, 3);
	 			}
	 			if (e.getCustomName().equals(ChatColor.RED + "Greater Eastcliff Warrior")) {
	 				Drops.dropsMethod(20, l, Items.Ruby, 4);
	 				Drops.dropCoinsMethod(100, l, Items.PlatinumCoin, 1, 2);
	 				Drops.dropCoinsMethod(100, l, Items.GoldCoin, 4, 6);
	 			}
	 			if (e.getCustomName().equals(ChatColor.RED + "Eastcliff Champion")) {
	 				Drops.dropsMethod(20, l, Items.Ruby, 8);
	 				Drops.dropCoinsMethod(100, l, Items.PlatinumCoin, 3, 4);
	 				Drops.dropCoinsMethod(100, l, Items.GoldCoin, 2, 9);
	 			}
	 			
	 			// PYRAMID
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Pyramid Archer")) {
	 				Drops.dropsMethod(10, l, Items.GoldHelmet, 1);
	 				Drops.dropsMethod(10, l, Items.GoldChestplate, 1);
	 				Drops.dropsMethod(33, l, Items.Emerald, 30);
	 				Drops.dropsMethod(33, l, Items.Sapphire, 15);
	 				Drops.dropsMethod(33, l, Items.Ruby, 15);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 1, 75);	
	 			}
	 			if (e.getCustomName().equals(ChatColor.GREEN + "Pyramid Scorpion")) {
	 				Drops.dropsMethod(33, l, Items.Emerald, 10);
	 				Drops.dropsMethod(33, l, Items.Ruby, 5);
	 				Drops.dropsMethod(33, l, Items.Sapphire, 5);
	 				Drops.dropCoinsMethod(100, l, Items.SilverCoin, 1, 20);
	 			}
	 			
	 			
	 			
	 			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 		}	 		
	}
}