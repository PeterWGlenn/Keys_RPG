package erestor_;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Shops {
	
	public static void protShops(Entity e, Entity a, EntityDamageByEntityEvent event) {
		if(e instanceof NPC) {
			event.setCancelled(true);
			if(a instanceof Player) {
				a.sendMessage(ChatColor.RED + "You cannot hurt the villagers!");
			}
		}
	}
	
	public static void buyMethod(ItemStack item, ItemStack itemS, int amount, Player p, InventoryClickEvent e) {

		if(e.getView().getTitle().contains("Shop") && e.getCurrentItem() != null) {
		if(!e.getCurrentItem().getType().equals(Material.AIR)) {
	    if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(itemS.getItemMeta().getDisplayName()) && e.getCurrentItem().getItemMeta().getLore().equals(itemS.getItemMeta().getLore())) {
			if(p.getLevel() >= amount) {
			p.giveExpLevels(-amount);
			p.getInventory().addItem(item);
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP , 10, 1); 
			} 
		}
		}
	    e.setCancelled(true);
		}
		} 	
	}
	
	public static void buyWithGemsMethod(ItemStack item, ItemStack itemS, int amountE, int amountR, int amountS, Player p, InventoryClickEvent e) {

		if(e.getView().getTitle().contains("Shop") && e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)) {
	    if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(itemS.getItemMeta().getDisplayName()) && e.getCurrentItem().getItemMeta().getLore().equals(itemS.getItemMeta().getLore())) {
			
			Inventory inv = p.getInventory();

			if(inv.containsAtLeast(Items.Sapphire, amountS) && inv.containsAtLeast(Items.Ruby, amountR) && inv.containsAtLeast(Items.Emerald, amountE)) {
			
			for (int i = 0; i < amountS; i++) { inv.removeItem(Items.Sapphire);  }
			for (int i = 0; i < amountR; i++) { inv.removeItem(Items.Ruby);  }
			for (int i = 0; i < amountE; i++) { inv.removeItem(Items.Emerald);  }
				
			p.getInventory().addItem(item);
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP , 10, 1); 
			} 
		}
		}
	    e.setCancelled(true);
		} 	
	}
	
	public static void npcTradeMethod(ItemStack item, ItemStack itemS, ItemStack buyItem, int buyItemAmount, Player p, InventoryClickEvent e) {

		if(e.getView().getTitle().contains("Shop") && e.getCurrentItem() != null && !e.getCurrentItem().getType().equals(Material.AIR)) {
	    if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(itemS.getItemMeta().getDisplayName()) && e.getCurrentItem().getItemMeta().getLore().equals(itemS.getItemMeta().getLore())) {
			
			Inventory inv = p.getInventory();

			if(inv.containsAtLeast(buyItem, buyItemAmount)) {
			
			for (int i = 0; i < buyItemAmount; i++) { inv.removeItem(buyItem);  }
				
			p.getInventory().addItem(item);
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP , 10, 1); 
			} 
		}
		}
	    e.setCancelled(true);
		} 	
	}
	
	public static void trainMethod(ItemStack item, ItemStack itemS, int amount, Player p, InventoryClickEvent e) {

		if(e.getView().getTitle().contains("Train") && e.getCurrentItem() != null && e.getCurrentItem().getItemMeta().getDisplayName() != null) {
	    if(!e.getCurrentItem().getType().equals(Material.AIR)) {
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(itemS.getItemMeta().getDisplayName()) && e.getCurrentItem().getItemMeta().getLore().equals(itemS.getItemMeta().getLore())) {
			if(p.getLevel() >= amount) {
			p.giveExpLevels(-amount);
			p.getInventory().setItem(35, item);
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP , 10, 1); 
			} 
		}
		}
	    e.setCancelled(true);
		} 	
	}
	
	public static void buy(Player p, InventoryClickEvent e) {
		// Arena
		//Arena.arenaBattleStart(p, e);
		// Train Abilities
		Shops.trainMethod(Items.strengthBoostAbility, Items.sStrengthBoostAbility, 100, p, e);
		Shops.trainMethod(Items.explodeAbility, Items.sExplodeAbility, 1000, p, e);
		Shops.trainMethod(Items.earthquakeAbility, Items.sEarthquakeAbility, 10000, p, e);
		Shops.trainMethod(Items.lightningAbility, Items.sLightningAbility, 100000, p, e);
		Shops.trainMethod(Items.manaShieldAbility, Items.sManaShieldAbility, 100, p, e);
		Shops.trainMethod(Items.healAbility, Items.sHealAbility, 1000, p, e);
		Shops.trainMethod(Items.lifeStealAbility, Items.sLifeStealAbility, 10000, p, e);
		Shops.trainMethod(Items.strengthenArmorAbility, Items.sStrengthenArmorAbility, 100000, p, e);
		Shops.trainMethod(Items.energyBoostAbility, Items.sEnergyBoostAbility, 100, p, e);
		Shops.trainMethod(Items.rejuvenateAbility, Items.sRejuvenateAbility, 1000, p, e);
		Shops.trainMethod(Items.leapAbility, Items.sLeapAbility, 10000, p, e);
		// Food
		Shops.buyMethod(Items.Steak, Items.sSteak, Val.steak * Val.foodSM, p, e);
		Shops.buyMethod(Items.Porkchop, Items.sPorkchop, Val.porkchop * Val.foodSM, p, e);
		Shops.buyMethod(Items.Chicken, Items.sChicken, Val.chicken * Val.foodSM, p, e);
		Shops.buyMethod(Items.Mutton, Items.sMutton, Val.mutton * Val.foodSM, p, e);
		Shops.buyMethod(Items.Bread, Items.sBread, Val.bread * Val.foodSM, p, e);
		Shops.buyMethod(Items.Cookies, Items.sCookies, Val.cookies * Val.foodSM, p, e);
		Shops.buyMethod(Items.Pie, Items.sPie, Val.pumpkinPie * Val.foodSM, p, e);
		Shops.buyMethod(Items.Fish, Items.sFish, Val.fish * Val.foodSM, p, e);
		Shops.buyMethod(Items.Salmon, Items.sSalmon, Val.salmon * Val.foodSM, p, e);
		Shops.buyMethod(Items.Clownfish, Items.sClownfish, Val.clownfish * Val.foodSM, p, e);
		// Potion
		Shops.buyMethod(Items.EmptyBottle, Items.sEmptyBottle, Val.emptyBottle * Val.potionSM, p, e);
		Shops.buyMethod(Items.NightVisionPotion, Items.sNightVisionPotion, Val.nightVisionPotion * Val.potionSM, p, e);
		Shops.buyMethod(Items.WaterBreathingPotion, Items.sWaterBreathingPotion, Val.waterBreathingPotion * Val.potionSM, p, e);
		// Keys
		Shops.buyWithGemsMethod(Items.RustedIronKey, Items.sRustedIronKey, 50, 25, 25, p, e);
		Shops.buyMethod(Items.StrangeGoldKey, Items.sStrangeGoldKey, 10250, p, e);
		Shops.buyMethod(Items.GoldKey, Items.sGoldKey, 20500, p, e);
		// Trade 
		Shops.buyMethod(Items.MassiveDiamond, Items.sMassiveDiamond, Val.superMassiveDiamond*Val.diamondSM, p, e);
		Shops.buyMethod(Items.divingHelmet, Items.sDivingHelmet, Val.divingHelmet*Val.woodSM, p, e);
		Shops.npcTradeMethod(Items.CityKey, Items.sCityKey, Items.MassiveDiamond, 1, p, e);
		Shops.npcTradeMethod(Items.OldDiamondKey, Items.sOldDiamondKey, Items.PrismarineCrystals, 100, p, e);
		// Wood
		Shops.buyMethod(Items.WoodHelmet, Items.sWoodHelmet, Val.wHelmet * Val.woodSM, p, e);
		Shops.buyMethod(Items.WoodChestplate, Items.sWoodChestplate, Val.wChestplate * Val.woodSM, p, e);
		Shops.buyMethod(Items.WoodLeggings, Items.sWoodLeggings, Val.wLeggings * Val.woodSM, p, e);
		Shops.buyMethod(Items.WoodBoots, Items.sWoodBoots, Val.wBoots * Val.woodSM, p, e);
		Shops.buyMethod(Items.WoodShield, Items.sWoodShield, Val.wShield * Val.woodSM, p, e);
		Shops.buyMethod(Items.WoodSword, Items.sWoodSword, Val.wSword * Val.woodSM, p, e);
		Shops.buyMethod(Items.WoodKnife, Items.sWoodKnife, Val.wKnife * Val.woodSM, p, e);
		Shops.buyMethod(Items.WoodBattleaxe, Items.sWoodBattleaxe, Val.wBattleaxe * Val.woodSM, p, e);
		Shops.buyMethod(Items.WoodPickaxe, Items.sWoodPickaxe, Val.wPickaxe * Val.woodSM, p, e);
		// Iron
		Shops.buyMethod(Items.IronHelmet, Items.sIronHelmet, Val.iHelmet * Val.ironSM, p, e);
		Shops.buyMethod(Items.IronChestplate, Items.sIronChestplate, Val.iChestplate * Val.ironSM, p, e);
		Shops.buyMethod(Items.IronLeggings, Items.sIronLeggings, Val.iLeggings * Val.ironSM, p, e);
		Shops.buyMethod(Items.IronBoots, Items.sIronBoots, Val.iBoots * Val.ironSM, p, e);
		Shops.buyMethod(Items.IronShield, Items.sIronShield, Val.iShield * Val.ironSM, p, e);
		Shops.buyMethod(Items.IronSword, Items.sIronSword, Val.iSword * Val.ironSM, p, e);
		Shops.buyMethod(Items.IronKnife, Items.sIronKnife, Val.iKnife * Val.ironSM, p, e);
		Shops.buyMethod(Items.IronBattleaxe, Items.sIronBattleaxe, Val.iBattleaxe * Val.ironSM, p, e);
		Shops.buyMethod(Items.IronPickaxe, Items.sIronPickaxe, Val.iPickaxe * Val.ironSM, p, e);
		// Gold
		Shops.buyMethod(Items.GoldHelmet, Items.sGoldHelmet, Val.gHelmet * Val.goldSM, p, e);
		Shops.buyMethod(Items.GoldChestplate, Items.sGoldChestplate, Val.gChestplate * Val.goldSM, p, e);
		Shops.buyMethod(Items.GoldLeggings, Items.sGoldLeggings, Val.gLeggings * Val.goldSM, p, e);
		Shops.buyMethod(Items.GoldBoots, Items.sGoldBoots, Val.gBoots * Val.goldSM, p, e);
		Shops.buyMethod(Items.GoldShield, Items.sGoldShield, Val.gShield * Val.goldSM, p, e);
		Shops.buyMethod(Items.GoldSword, Items.sGoldSword, Val.gSword * Val.goldSM, p, e);
		Shops.buyMethod(Items.GoldKnife, Items.sGoldKnife, Val.gKnife * Val.goldSM, p, e);
		Shops.buyMethod(Items.GoldBattleaxe, Items.sGoldBattleaxe, Val.gBattleaxe * Val.goldSM, p, e);
		Shops.buyMethod(Items.GoldPickaxe, Items.sGoldPickaxe, Val.gPickaxe * Val.goldSM, p, e);
		// Diamond
		Shops.buyMethod(Items.DiamondHelmet, Items.sDiamondHelmet, Val.dHelmet * Val.diamondSM, p, e);
		Shops.buyMethod(Items.DiamondChestplate, Items.sDiamondChestplate, Val.dChestplate * Val.diamondSM, p, e);
		Shops.buyMethod(Items.DiamondLeggings, Items.sDiamondLeggings, Val.dLeggings * Val.diamondSM, p, e);
		Shops.buyMethod(Items.DiamondBoots, Items.sDiamondBoots, Val.dBoots * Val.diamondSM, p, e);
		Shops.buyMethod(Items.DiamondShield, Items.sDiamondShield, Val.dShield * Val.diamondSM, p, e);
		Shops.buyMethod(Items.DiamondSword, Items.sDiamondSword, Val.dSword * Val.diamondSM, p, e); 
		Shops.buyMethod(Items.DiamondKnife, Items.sDiamondKnife, Val.dKnife * Val.diamondSM, p, e);
		Shops.buyMethod(Items.DiamondBattleaxe, Items.sDiamondBattleaxe, Val.dBattleaxe * Val.diamondSM, p, e);
		Shops.buyMethod(Items.DiamondPickaxe, Items.sDiamondPickaxe, Val.dPickaxe * Val.diamondSM, p, e); 
		// Mithril
		Shops.buyMethod(Items.MithrilHelmet, Items.sMithrilHelmet, Val.mHelmet * Val.mithrilSM, p, e);
		Shops.buyMethod(Items.MithrilChestplate, Items.sMithrilChestplate, Val.mChestplate * Val.mithrilSM, p, e);
		Shops.buyMethod(Items.MithrilLeggings, Items.sMithrilLeggings, Val.mLeggings * Val.mithrilSM, p, e);
		Shops.buyMethod(Items.MithrilBoots, Items.sMithrilBoots, Val.mBoots * Val.mithrilSM, p, e);
		Shops.buyMethod(Items.MithrilShield, Items.sMithrilShield, Val.mShield * Val.mithrilSM, p, e);
		Shops.buyMethod(Items.MithrilSword, Items.sMithrilSword, Val.mSword * Val.mithrilSM, p, e); 
		Shops.buyMethod(Items.MithrilKnife, Items.sMithrilKnife, Val.mKnife * Val.mithrilSM, p, e);
		Shops.buyMethod(Items.MithrilBattleaxe, Items.sMithrilBattleaxe, Val.mBattleaxe * Val.mithrilSM, p, e);
		Shops.buyMethod(Items.MithrilPickaxe, Items.sMithrilPickaxe, Val.mPickaxe * Val.mithrilSM, p, e); 
	}
	
	@SuppressWarnings("deprecation")
	public static void spawnShopsMethod(String name, int x, int y, int z) {
		
		Block b = Bukkit.getServer().getWorld("world").getBlockAt(x, y, z);
			
		Villager v = (Villager) b.getLocation().getWorld().spawn(b.getLocation(), Villager.class);
		v.setCustomName(ChatColor.BLUE + "" + name);
		v.setCustomNameVisible(true);
		v.setMaxHealth(999);
		v.setHealth(999);
		v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
		    	99999, 2));
		v.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,
		 		99999, 10));

		}	
	
	public static void spawnShops(Player p, Action a) {
		if (a == Action.LEFT_CLICK_AIR && p.getInventory().getItemInMainHand().getType().equals(Material.BEDROCK)){
	
		int killedAmount = 0;
		for(Entity NPC : Bukkit.getServer().getWorld("world").getEntities()) {
			if(NPC instanceof NPC) {
			NPC.teleport(p);
			((NPC) NPC).damage(999999);	
			killedAmount++;
			}
		}
			
		p.sendMessage("Removed " + ChatColor.YELLOW + killedAmount + ChatColor.WHITE + " entities!");
		p.sendMessage("" + ChatColor.BOLD + ChatColor.BLUE + "NPCs Reloaded!");
			
		Shops.spawnShopsMethod("Jack the Butcher", -11, 75, 344);
		Shops.spawnShopsMethod("Matthew the Blacksmith", -64, 76, 297);
		Shops.spawnShopsMethod("Ability Trainer", -70, 76, 293);
		Shops.spawnShopsMethod("Wise Old Man", 214, 76, 366);
		Shops.spawnShopsMethod("Berry the Blacksmith", 60, 75, 122);
		Shops.spawnShopsMethod("Blake the Baker", 30, 76, 178);
		Shops.spawnShopsMethod("Ability Trainer", 22, 76, 146);
		Shops.spawnShopsMethod("Ability Trainer", 230, 78, 108);
		
		// Large Town
		Shops.spawnShopsMethod("Aaron the Blacksmith", 278, 80, -48);
		Shops.spawnShopsMethod("Ability Trainer", 336, 79, -66);
		Shops.spawnShopsMethod("Ronald the Baker", 327, 76, 10);
		Shops.spawnShopsMethod("Harold the Innkeeper", 326, 75, -29);
		Shops.spawnShopsMethod("Harry the Cook", 324, 80, -29);
		Shops.spawnShopsMethod("Joseph the Butcher", 176, 75, -66);
		Shops.spawnShopsMethod("John the Gatekeeper", 312, 80, 51);
		//Shops.spawnShopsMethod("Arena Master", 170, 75, -33);
		
		// Lake Town
		Shops.spawnShopsMethod("Finn the Fisherman", 74, 75, -220);
		}
	}
	
	public static void shopOpen(Entity e, PlayerInteractEntityEvent event) {
		if (!(e instanceof NPC))
		      return;

		  if (e.getCustomName().equals(ChatColor.BLUE + "Jack the Butcher")) {
			  openShopJack(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "Matthew the Blacksmith")) {
			  openShopMatthew(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "Ability Trainer")) {
			  openShopTrainer(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "Wise Old Man")) {
			  openShopOldMan(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "Berry the Blacksmith")) {
			  openShopBerry(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "Blake the Baker")) {
			  openShopBlake(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "Aaron the Blacksmith")) {
			  openShopAaron(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "Ronald the Baker")) {
			  openShopRonald(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "Harry the Cook")) {
			  openShopHarry(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "Joseph the Butcher")) {
			  openShopJoseph(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "Harold the Innkeeper")) {
			  openShopHarold(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "John the Gatekeeper")) {
			  openShopJohn(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "Arena Master")) {
			  //Arena.openArenaInv(event.getPlayer());
			  event.setCancelled(true);
		  }
		  if (e.getCustomName().equals(ChatColor.BLUE + "Finn the Fisherman")) {
			  openShopFinn(event.getPlayer());
			  event.setCancelled(true);
		  }
	}
	
	//////////////////////////////////////////////////////// I N V E N T O R Y S //////////////////////////////////////////////////////////
	// Jack's Inv
	 public static Inventory JackShop;
	    public static void openShopJack(Player p){
		    JackShop = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Jack's Shop"); 
		    
	        JackShop.setItem(0, Items.sSteak);	
	        JackShop.setItem(1, Items.sPorkchop);	
	        JackShop.setItem(2, Items.sChicken);	
	        JackShop.setItem(3, Items.sMutton);	

		    p.openInventory(JackShop);
		    
		}
	// Jack's Inv
	  public static Inventory MatthewShop;
	  public static void openShopMatthew(Player p){
		    MatthewShop = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Matthew's Shop"); 
		    
		    MatthewShop.setItem(0, Items.sWoodHelmet);	
		    MatthewShop.setItem(1, Items.sWoodChestplate);	
		    MatthewShop.setItem(2, Items.sWoodLeggings);	
		    MatthewShop.setItem(3, Items.sWoodBoots);	
		    MatthewShop.setItem(4, Items.sWoodShield);
		    MatthewShop.setItem(5, Items.sWoodSword);
		    MatthewShop.setItem(6, Items.sWoodKnife);
		    MatthewShop.setItem(7, Items.sWoodBattleaxe);
		    MatthewShop.setItem(8, Items.sWoodPickaxe);
			    
		    MatthewShop.setItem(9, Items.sIronHelmet);	
		    MatthewShop.setItem(10, Items.sIronChestplate);	
		    MatthewShop.setItem(11, Items.sIronLeggings);	
		    MatthewShop.setItem(12, Items.sIronBoots);	
		    MatthewShop.setItem(13, Items.sIronShield);
		    MatthewShop.setItem(14, Items.sIronSword);
		    MatthewShop.setItem(15, Items.sIronKnife);
		    MatthewShop.setItem(16, Items.sIronBattleaxe);
		    MatthewShop.setItem(17, Items.sIronPickaxe);
		    
		    MatthewShop.setItem(18, Items.sGoldHelmet);	
		    MatthewShop.setItem(19, Items.sGoldChestplate);	
		    MatthewShop.setItem(20, Items.sGoldLeggings);	
		    MatthewShop.setItem(21, Items.sGoldBoots);	
		    MatthewShop.setItem(22, Items.sGoldShield);
		    MatthewShop.setItem(23, Items.sGoldSword);
		    MatthewShop.setItem(24, Items.sGoldKnife);
		    MatthewShop.setItem(25, Items.sGoldBattleaxe);
		    MatthewShop.setItem(26, Items.sGoldPickaxe);

		    p.openInventory(MatthewShop);
			    
		}
	  
	  // Trainer's Inv
	  public static Inventory TrainerShop;
	  public static void openShopTrainer(Player p){
		  TrainerShop = Bukkit.createInventory(null, 54, ChatColor.DARK_GRAY + "Ability Trainer"); 
			    
		  TrainerShop.setItem(2, Items.abilityAttack);
		  TrainerShop.setItem(11, Items.sStrengthBoostAbility);
		  TrainerShop.setItem(20, Items.sExplodeAbility);	
		  TrainerShop.setItem(29, Items.sEarthquakeAbility);
		  TrainerShop.setItem(38, Items.sLightningAbility);
		  
		  TrainerShop.setItem(4, Items.abilityDefence);
		  TrainerShop.setItem(13, Items.sManaShieldAbility);
		  TrainerShop.setItem(22, Items.sHealAbility);
		  TrainerShop.setItem(31, Items.sLifeStealAbility);
		  TrainerShop.setItem(40, Items.sStrengthenArmorAbility);
		  
		  TrainerShop.setItem(6, Items.abilityAgility);
		  TrainerShop.setItem(15, Items.sEnergyBoostAbility);
		  TrainerShop.setItem(24, Items.sRejuvenateAbility);
		  TrainerShop.setItem(33, Items.sLeapAbility);

		  p.openInventory(TrainerShop);
			    
		}
	  // Wise Old Man's Inv
	  public static Inventory WiseOldMansShop;
		  public static void openShopOldMan(Player p){
		  WiseOldMansShop = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Wise Old Man's Shop"); 
			    
		  WiseOldMansShop.setItem(0, Items.sRustedIronKey);	 
		  WiseOldMansShop.setItem(1, Items.sSteak);	

	      p.openInventory(WiseOldMansShop);
			    
	  }
			// Berry's Inv
	  public static Inventory BerryShop;
		  public static void openShopBerry(Player p){
		  BerryShop = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Berry's Shop"); 
				    
		  BerryShop.setItem(0, Items.sIronHelmet);	
		  BerryShop.setItem(1, Items.sIronChestplate);	
		  BerryShop.setItem(2, Items.sIronLeggings);	
		  BerryShop.setItem(3, Items.sIronBoots);	
		  BerryShop.setItem(4, Items.sIronShield);
		  BerryShop.setItem(5, Items.sIronSword);
		  BerryShop.setItem(6, Items.sIronKnife);
		  BerryShop.setItem(7, Items.sIronBattleaxe);
		  BerryShop.setItem(8, Items.sIronPickaxe);
		    
		  BerryShop.setItem(9, Items.sGoldHelmet);	
		  BerryShop.setItem(10, Items.sGoldChestplate);	
		  BerryShop.setItem(11, Items.sGoldLeggings);	
		  BerryShop.setItem(12, Items.sGoldBoots);	
		  BerryShop.setItem(13, Items.sGoldShield);
		  BerryShop.setItem(14, Items.sGoldSword);
		  BerryShop.setItem(15, Items.sGoldKnife);
		  BerryShop.setItem(16, Items.sGoldBattleaxe);
		  BerryShop.setItem(17, Items.sGoldPickaxe);
		  
		  BerryShop.setItem(18, Items.sDiamondHelmet);	
		  BerryShop.setItem(19, Items.sDiamondChestplate);	
		  BerryShop.setItem(20, Items.sDiamondLeggings);	
		  BerryShop.setItem(21, Items.sDiamondBoots);	
		  BerryShop.setItem(22, Items.sDiamondShield);
		  BerryShop.setItem(23, Items.sDiamondSword);
		  BerryShop.setItem(24, Items.sDiamondKnife);
		  BerryShop.setItem(25, Items.sDiamondBattleaxe);
		  BerryShop.setItem(26, Items.sDiamondPickaxe);

		  p.openInventory(BerryShop);
				    
		}
		// Blake Inv
		public static Inventory BlakeShop;
		  public static void openShopBlake(Player p){
			BlakeShop = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Blake's Shop"); 
					    
			BlakeShop.setItem(0, Items.sBread);	
			BlakeShop.setItem(1, Items.sCookies);
			BlakeShop.setItem(2, Items.sPie);

		p.openInventory(BlakeShop);
					    
		}
		    
		   ///////////////////////////////////////// L A R G E   T O W N ///////////////////////////////////////////
		// Blake Inv
		public static Inventory RonaldShop;
	    	public static void openShopRonald(Player p){
	    	RonaldShop = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Ronald's Shop"); 
				    
			RonaldShop.setItem(0, Items.sBread);	
			RonaldShop.setItem(1, Items.sCookies);
			RonaldShop.setItem(2, Items.sPie);

			p.openInventory(RonaldShop);
				    
	    }	    
	    
	    // Joseph's Inv
	    public static Inventory JosephShop;
			public static void openShopJoseph(Player p){
				JosephShop = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Joseph's Shop"); 
			    
				JosephShop.setItem(0, Items.sSteak);	
				JosephShop.setItem(1, Items.sPorkchop);	
				JosephShop.setItem(2, Items.sChicken);	
				JosephShop.setItem(3, Items.sMutton);	

	    	p.openInventory(JosephShop);
			    
	    }
		
		// Harry's Inv
	    public static Inventory HarryShop;
			public static void openShopHarry(Player p){
				HarryShop = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Harry's Shop"); 
				    
				HarryShop.setItem(0, Items.sPorkchop);		
				HarryShop.setItem(1, Items.sMutton);
				HarryShop.setItem(2, Items.sPie);

		    p.openInventory(HarryShop);
				    
		}
			
		// Harold's Inv
		public static Inventory HaroldShop;
		    public static void openShopHarold(Player p){
		    	HaroldShop = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Harold's Shop"); 
					    
		    	HaroldShop.setItem(0, Items.sMassiveDiamond);	
		    	HaroldShop.setItem(1, Items.sCookies);

			p.openInventory(HaroldShop);
					    
		}
		    
		// John's Inv
		public static Inventory JohnShop;
			public static void openShopJohn(Player p){
				JohnShop = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "John's Shop"); 
					
				JohnShop.setItem(0, Items.sStrangeGoldKey);
				JohnShop.setItem(1, Items.sGoldKey);	
				JohnShop.setItem(2, Items.sCityKey);

			p.openInventory(JohnShop);
					    
		}
	    
		// Aaron's Inv
	  public static Inventory AaronShop;
	  public static void openShopAaron(Player p){
	  AaronShop = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Aaron's Shop"); 			   
	    
	  AaronShop.setItem(0, Items.sGoldHelmet);	
	  AaronShop.setItem(1, Items.sGoldChestplate);	
	  AaronShop.setItem(2, Items.sGoldLeggings);	
	  AaronShop.setItem(3, Items.sGoldBoots);	
	  AaronShop.setItem(4, Items.sGoldShield);
	  AaronShop.setItem(5, Items.sGoldSword);
	  AaronShop.setItem(6, Items.sGoldKnife);
	  AaronShop.setItem(7, Items.sGoldBattleaxe);
	  AaronShop.setItem(8, Items.sGoldPickaxe);
	  
	  AaronShop.setItem(9, Items.sDiamondHelmet);	
	  AaronShop.setItem(10, Items.sDiamondChestplate);	
	  AaronShop.setItem(11, Items.sDiamondLeggings);	
	  AaronShop.setItem(12, Items.sDiamondBoots);	
	  AaronShop.setItem(13, Items.sDiamondShield);
	  AaronShop.setItem(14, Items.sDiamondSword);
	  AaronShop.setItem(15, Items.sDiamondKnife);
	  AaronShop.setItem(16, Items.sDiamondBattleaxe);
	  AaronShop.setItem(17, Items.sDiamondPickaxe);
	  
	  AaronShop.setItem(18, Items.sMithrilHelmet);	
	  AaronShop.setItem(19, Items.sMithrilChestplate);	
	  AaronShop.setItem(20, Items.sMithrilLeggings);	
	  AaronShop.setItem(21, Items.sMithrilBoots);	
	  AaronShop.setItem(22, Items.sMithrilShield);
	  AaronShop.setItem(23, Items.sMithrilSword);
	  AaronShop.setItem(24, Items.sMithrilKnife);
	  AaronShop.setItem(25, Items.sMithrilBattleaxe);
	  AaronShop.setItem(26, Items.sMithrilPickaxe);

	  p.openInventory(AaronShop);
			    
 }
		    
    ///////////////////////////////////////////////////////////// L A K E    T O W N /////////////////////////////////////////////////////////////////
		    
	// Finn's Inv
	public static Inventory FinnShop;
		public static void openShopFinn(Player p){
			FinnShop = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Finn's Shop"); 
					
			FinnShop.setItem(0, Items.sClownfish);
			FinnShop.setItem(1, Items.sFish);
			FinnShop.setItem(2, Items.sSalmon);	
			FinnShop.setItem(3, Items.sEmptyBottle);	
			FinnShop.setItem(4, Items.sNightVisionPotion);
			FinnShop.setItem(5, Items.sWaterBreathingPotion);
			FinnShop.setItem(6, Items.sDivingHelmet);
			FinnShop.setItem(7, Items.sOldDiamondKey);

		p.openInventory(FinnShop);
					    
	}   
}