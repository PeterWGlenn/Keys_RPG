package erestor_;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Enchanting {
	
	// Enchant
	public static void enchant(ItemStack i, Enchantment e, int l) {
		// Remove Enchantment
		if(i.containsEnchantment(e)) { i.removeEnchantment(e); }
		
		// Add Enchantment
		i.addUnsafeEnchantment(e, l);
	}
	
	// Enchantment Level
	public static int enchantLvl(int maxLevel) {
		Random random = new Random();
		int randNumber = random.nextInt(maxLevel - 1 + 1) + 1;	
		return randNumber;
	}
	
	// Enchant Weapon
	public static void enchantWeapon(ItemStack i, int extendEnchantMax) {
		
		// Random Number Creation
		Random random = new Random();
		int randNumber = random.nextInt(5 - 1 + 1) + 1;
		
		/* Sharpness : */          if(randNumber == 1) { enchant(i, Enchantment.DAMAGE_ALL, enchantLvl(3 + extendEnchantMax)); }
		/* Smite : */              if(randNumber == 2) { enchant(i, Enchantment.DAMAGE_UNDEAD, enchantLvl(3 + extendEnchantMax)); }
		/* Bane of Arthropods : */ if(randNumber == 3) { enchant(i, Enchantment.DAMAGE_ARTHROPODS, enchantLvl(3 + extendEnchantMax)); }
		/* Knockback : */          if(randNumber == 4) { enchant(i, Enchantment.KNOCKBACK, enchantLvl(2 + extendEnchantMax)); }
		/* Fire Aspect : */        if(randNumber == 5) { enchant(i, Enchantment.FIRE_ASPECT, enchantLvl(1 + extendEnchantMax)); }
		
	}
	
	// Enchant Armor
	public static void enchantArmor(ItemStack i, int extendEnchantMax) {
		
		// Random Number Creation
		Random random = new Random();
		int randNumber = random.nextInt(5 - 1 + 1) + 1;
		
		/* Protection : */            if(randNumber == 1) { enchant(i, Enchantment.PROTECTION_ENVIRONMENTAL, enchantLvl(3 + extendEnchantMax)); }
		/* Projectile Protection : */ if(randNumber == 2) { enchant(i, Enchantment.PROTECTION_PROJECTILE, enchantLvl(3 + extendEnchantMax)); }
		/* Explosion Protection : */  if(randNumber == 3) { enchant(i, Enchantment.PROTECTION_EXPLOSIONS, enchantLvl(3 + extendEnchantMax)); }
		/* Protection Fire : */       if(randNumber == 4) { enchant(i, Enchantment.PROTECTION_FIRE, enchantLvl(2 + extendEnchantMax)); }
		/* Thorns : */                if(randNumber == 5) { enchant(i, Enchantment.THORNS, enchantLvl(2 + extendEnchantMax)); }
		
	}
	
	// Enchant Boots
	public static void enchantBoots(ItemStack i, int extendEnchantMax) {
		
		// Random Number Creation
		Random random = new Random();
		int randNumber = random.nextInt(7 - 1 + 1) + 1;
		
		/* Protection : */            if(randNumber == 1) { enchant(i, Enchantment.PROTECTION_ENVIRONMENTAL, enchantLvl(2 + extendEnchantMax)); }
		/* Projectile Protection : */ if(randNumber == 2) { enchant(i, Enchantment.PROTECTION_PROJECTILE, enchantLvl(2 + extendEnchantMax)); }
		/* Explosion Protection : */  if(randNumber == 3) { enchant(i, Enchantment.PROTECTION_EXPLOSIONS, enchantLvl(2 + extendEnchantMax)); }
		/* Protection Fire : */       if(randNumber == 4) { enchant(i, Enchantment.PROTECTION_FIRE, enchantLvl(2 + extendEnchantMax)); }
		/* Thorns : */                if(randNumber == 5) { enchant(i, Enchantment.THORNS, enchantLvl(2 + extendEnchantMax)); }
		
		/* Protection Fall : */       if(randNumber == 6) { enchant(i, Enchantment.PROTECTION_FALL, enchantLvl(2 + extendEnchantMax)); }
		/* Depth Strider : */         if(randNumber == 7) { enchant(i, Enchantment.DEPTH_STRIDER, enchantLvl(2 + extendEnchantMax)); }
		/* Frost Walker : */          //if(randNumber == 8) { enchant(i, Enchantment.FROST_WALKER, enchantLvl(2)); }
		
	}
	
	// Enchant Helmet
	public static void enchantHelmet(ItemStack i, int extendEnchantMax) {
		
		// Random Number Creation
		Random random = new Random();
		int randNumber = random.nextInt(7 - 1 + 1) + 1;
		
		/* Protection : */            if(randNumber == 1) { enchant(i, Enchantment.PROTECTION_ENVIRONMENTAL, enchantLvl(2 + extendEnchantMax)); }
		/* Projectile Protection : */ if(randNumber == 2) { enchant(i, Enchantment.PROTECTION_PROJECTILE, enchantLvl(2 + extendEnchantMax)); }
		/* Explosion Protection : */  if(randNumber == 3) { enchant(i, Enchantment.PROTECTION_EXPLOSIONS, enchantLvl(2 + extendEnchantMax)); }
		/* Protection Fire : */       if(randNumber == 4) { enchant(i, Enchantment.PROTECTION_FIRE, enchantLvl(2 + extendEnchantMax)); }
		/* Thorns : */                if(randNumber == 5) { enchant(i, Enchantment.THORNS, enchantLvl(2 + extendEnchantMax)); }
		
		/* Aqua Affinity : */         if(randNumber == 6) { enchant(i, Enchantment.WATER_WORKER, enchantLvl(2 + extendEnchantMax)); }
		/* Respiration : */           if(randNumber == 7) { enchant(i, Enchantment.OXYGEN, enchantLvl(2 + extendEnchantMax)); }
		
	}
	
	// Enchantment Gem Manager
	public static boolean EnchantmentGemManager(PlayerInventory inv, int amountE, int amountS, int amountR) {
		
		if(inv.containsAtLeast(Items.Sapphire, amountS) && inv.containsAtLeast(Items.Ruby, amountR) && inv.containsAtLeast(Items.Emerald, amountE)) {
			
		for (int i = 0; i < amountS; i++) { inv.removeItem(Items.Sapphire);  }
		for (int i = 0; i < amountR; i++) { inv.removeItem(Items.Ruby);  }
		for (int i = 0; i < amountE; i++) { inv.removeItem(Items.Emerald);  }
		
		return true;
		} else {
			return false;
		}
	}
	
	// Enchant Method
	public static void EnchantMethod(Player p) {
		
		PlayerInventory inv = p.getInventory();
		
		if(inv.getItemInMainHand().getType() != Material.AIR && inv.getItemInMainHand().hasItemMeta()) {
		ItemStack item = inv.getItemInMainHand();
		String itemName = item.getItemMeta().getDisplayName();
		
		
		////////////////////////////////////// ExLvl Calc ///////////////////////////////////////////////////
		int exLvl = 0;
		
		if(itemName.contains("Gold")) { for (int n = 0; n < 5; n++) { exLvl++; } }
		if(itemName.contains("Mithril")) { for (int n = 0; n < 2; n++) { exLvl++; } }
		if(itemName.contains("Adamantite")) { for (int n = 0; n < 4; n++) { exLvl++; } }
		if(itemName.contains("Void")) { for (int n = 0; n < 6; n++) { exLvl++; } }
		/////////////////////////////////////////////////////////////////////////////////////////////////////
			
		    // Weapons
			if(itemName.contains("Sword") || itemName.contains("Battleaxe") || itemName.contains("Knife")) {
			if(EnchantmentGemManager(inv, 5, 1, 10)) {
			enchantWeapon(item, exLvl);
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP , 10, 1); 
			} else {
			p.sendMessage(ChatColor.RED + "You need more gems to do that! In total you need 5 Emeralds, 1 Sapphire, and 10 Rubies.");
			}
			}
			
			// Armor
			if(itemName.contains("Chestplate") || itemName.contains("Leggings")) {
			if(EnchantmentGemManager(inv, 5, 10, 1)) {
			enchantArmor(item, exLvl);
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP , 10, 1); 
			} else {
			p.sendMessage(ChatColor.RED + "You need more gems to do that! In total you need 5 Emeralds, 10 Sapphires, and 1 Ruby.");
			}
			}
			
			// Helmet
			if(itemName.contains("Helmet")) {
			if(EnchantmentGemManager(inv, 5, 10, 1)) {
			enchantHelmet(item, exLvl);
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP , 10, 1); 
			} else {
			p.sendMessage(ChatColor.RED + "You need more gems to do that! In total you need 5 Emeralds, 10 Sapphires, and 1 Ruby.");
			}
			}
			
			// Boots
			if(itemName.contains("Boots")) {
			if(EnchantmentGemManager(inv, 5, 10, 1)) {
			enchantBoots(item, exLvl);
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP , 10, 1); 
			} else {
			p.sendMessage(ChatColor.RED + "You need more gems to do that! In total you need 5 Emeralds, 10 Sapphires, and 1 Ruby.");
			}
			}
			
		} else {
			p.sendMessage(ChatColor.RED + "You must be holding either a weapon or a piece of armor to enchant it!");
		}
		
	}
	
	// Enchanting Confirmation Inventory
	public static Inventory EnInv;
	public static void openEnInv(Player p){
		EnInv = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "Enchant your held item?"); 
				
		EnInv.setItem(2, Items.createChoiceItem(ChatColor.GREEN + "Yes", Material.LIME_WOOL));
		EnInv.setItem(6, Items.createChoiceItem(ChatColor.RED + "No", Material.RED_WOOL));

		p.openInventory(EnInv);	    
	}
	
	// Enchantment Inventory Click Detector 
	public static void EnchantInvClickHandler(Player p, InventoryClickEvent e) {

		if(e.getView().getTitle().contains("Enchant your held item?") && !e.getCurrentItem().getType().equals(Material.AIR)) {
	    if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
		if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Yes")) {
			
			p.closeInventory();
			Enchanting.EnchantMethod(p);
			} else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("No")) {
			p.closeInventory();
			}
		}
	    e.setCancelled(true);
		}
	} 	
}