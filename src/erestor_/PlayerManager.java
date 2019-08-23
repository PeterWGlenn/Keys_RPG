package erestor_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerManager {
	
	// hasClimbedList
	static ArrayList<String> hasClimbed = new ArrayList<String>();
	// Jailed
	static ArrayList<String> jailed = new ArrayList<String>();
	// Contained
	static ArrayList<String> contained = new ArrayList<String>();
	// bedTpQueue
	static ArrayList<String> bedTpQueue = new ArrayList<String>();
	// bedTpCooldown
	static ArrayList<String> bedTpCooldown = new ArrayList<String>();
	// inCombat
	static ArrayList<String> inCombat = new ArrayList<String>();
	
	// Starter Info
	public static void starterInfo(Player p) {
		
		p.sendMessage("" + ChatColor.AQUA + ChatColor.BOLD + "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
		p.sendMessage("" + ChatColor.BLUE + ChatColor.BOLD + "Welcome to " + ChatColor.GOLD + "Keys 2.2" + ChatColor.BLUE + "!");
		p.sendMessage(ChatColor.DARK_PURPLE + "Use /craft to craft, and /smelt to smelt!");
		p.sendMessage(ChatColor.DARK_PURPLE + "Right click on a bed to set your spawn!");
		p.sendMessage(ChatColor.DARK_PURPLE + "Use /bed to teleport to your bed!");
		p.sendMessage(ChatColor.DARK_PURPLE + "When you die, you will keep your hotbar, armor and shield!");
		p.sendMessage(ChatColor.DARK_PURPLE + "You will also keep 75% of your coins!");
		p.sendMessage(ChatColor.DARK_PURPLE + "When in a shop, you can right click an item to sell it!");
		p.sendMessage(ChatColor.DARK_PURPLE + "You can also shift right click an item to sell the whole stack!");
		p.sendMessage(ChatColor.DARK_RED + "Hacking will result in a perm ban!");
		p.sendMessage(ChatColor.DARK_PURPLE + "You can reach the server owner at " + ChatColor.AQUA + "contactErestor@gmail.com" + ChatColor.DARK_PURPLE + "!");
		p.sendMessage("" + ChatColor.BLUE + ChatColor.BOLD + "Enjoy!");
		p.sendMessage("" + ChatColor.AQUA + ChatColor.BOLD + "+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");	
		
		p.getInventory().addItem(Items.StarterBook);
	}
	
	// Player Join
	public static void onPlayerJoin(Player p) {		
		
		if(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() == 20.0) {
			Spawns.setMaxHealth(p, 40);
			p.setHealth(40);
			p.setSaturation(20);
			p.setFoodLevel(20);
			
			Location spawn = new Location(Bukkit.getServer().getWorld("world"), -48, 75, 340);
			Location bedSpawn = new Location(Bukkit.getServer().getWorld("world"), -36, 81, 299);
			p.setGameMode(GameMode.ADVENTURE);
			
			p.setBedSpawnLocation(bedSpawn);
			p.teleport(spawn);
			
			
			p.getInventory().setItem(17, Items.createGroupItem("NONE", ChatColor.WHITE, "NONE", "NONE"));
			p.getInventory().setItem(26, Items.createManaItem("0"));
			p.getInventory().setItem(35, Items.noAbility);
			
			for (int i = 0; i < 10; i++) {
			p.getInventory().addItem(Items.Steak);
			}
			
			starterInfo(p);
		}
	}
	
	//////////////////////////////////////////////////////////// P L A Y E R  R E S E T /////////////////////////////////////////////////////////////
	public static void resetPlayer(Player p) {
		
		PlayerInventory inv = p.getInventory();
		
		inv.setHelmet(new ItemStack(Material.AIR));
		inv.setChestplate(new ItemStack(Material.AIR));
		inv.setLeggings(new ItemStack(Material.AIR));
		inv.setBoots(new ItemStack(Material.AIR));
		inv.setItemInOffHand(new ItemStack(Material.AIR));
		inv.setItemInMainHand(new ItemStack(Material.AIR));
		inv.clear();
		p.setLevel(0);
		
		Location spawn = new Location(Bukkit.getServer().getWorld("world"), -48, 75, 340);
		Location bedSpawn = new Location(Bukkit.getServer().getWorld("world"), -36, 81, 299);
		p.setGameMode(GameMode.ADVENTURE);
		
		p.setBedSpawnLocation(bedSpawn);
		p.teleport(spawn);
		
		p.getEnderChest().clear();
		
			PlayerManager.setMaxHealth(p, 40);
			p.setHealth(40);
			p.setSaturation(20);
			p.setFoodLevel(20);
			
			Groups.guardiansOfAncra.removeEntry(p.getName());
			Groups.leagueOfHunters.removeEntry(p.getName());
			Groups.minersFoundry.removeEntry(p.getName());
			Groups.mageSociety.removeEntry(p.getName());
			Groups.eastcliffGladiators.removeEntry(p.getName());
			
			inv.setItem(17, Items.createGroupItem("NONE", ChatColor.WHITE, "NONE", "NONE"));
			inv.setItem(26, Items.createManaItem("0"));
			inv.setItem(35, Items.noAbility);
			
			for (int i = 0; i < 10; i++) {
			inv.addItem(Items.Steak);
			}
			
			starterInfo(p);
	}
	///////////////////////////////////////////////////////////// C O I N S //////////////////////////////////////////////////////////////////////////
	
	// Gold Converter
	public static void goldConverter(Player p) {
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
        public void run() {
		
		//BronzeCounter
		int Bronze = 0;
		int Silver = 0;
		int Gold = 0;
		int Platinum = 0;
		
		if(p.getHealth() > 0) {
		
		ListIterator<ItemStack> it = p.getInventory().iterator();
		while(it.hasNext()) {
		ItemStack current = it.next();
		if(current != null && current.getItemMeta().hasDisplayName() && current.getItemMeta().getDisplayName().contains("Bronze")) { Bronze += current.getAmount(); }
		if(current != null && current.getItemMeta().hasDisplayName() &&  current.getItemMeta().getDisplayName().contains("Silver")) { Silver += current.getAmount(); }
		if(current != null && current.getItemMeta().hasDisplayName() &&  current.getItemMeta().getDisplayName().contains("Gold Coin")) { Gold += current.getAmount(); }
		if(current != null && current.getItemMeta().hasDisplayName() &&  current.getItemMeta().getDisplayName().contains("Platinum")) { Platinum += current.getAmount(); }		
		}
		
		if(p.getInventory().containsAtLeast(Items.BronzeCoin, 1)) {
			p.giveExpLevels(Bronze);
			for (int i = 0; i < Bronze; i++) { p.getInventory().removeItem(Items.BronzeCoin); }
		}
		if(p.getInventory().containsAtLeast(Items.SilverCoin, 1)) {
			p.giveExpLevels(Silver * 100);
			for (int i = 0; i < Silver; i++) { p.getInventory().removeItem(Items.SilverCoin); }
		}
		if(p.getInventory().containsAtLeast(Items.GoldCoin, 1)) {
			p.giveExpLevels(Gold * 1000);
			for (int i = 0; i < Gold; i++) { p.getInventory().removeItem(Items.GoldCoin); }
		}
		if(p.getInventory().containsAtLeast(Items.PlatinumCoin, 1)) {
			p.giveExpLevels(Platinum * 10000);
			for (int i = 0; i < Platinum; i++) { p.getInventory().removeItem(Items.PlatinumCoin); }
		}
		}
		
        }
        }, 1);
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Gold Bag Manager
	public static void goldBag(Player p, InventoryClickEvent e) {
	
	if(e.getCurrentItem() != null && !(e.getCurrentItem().getType().equals(Material.AIR)) && e.isRightClick()) {
	    if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
		if(e.getCurrentItem().getItemMeta().getLore().equals(Arrays.asList(ChatColor.GRAY + "Bag of Coins [Right Click to Redeem!]"))) {
			e.setCancelled(true);
			
			int amount = Integer.parseInt(e.getCurrentItem().getItemMeta().getDisplayName());
			p.giveExpLevels(amount);
			
			if(p.getInventory().containsAtLeast(e.getCurrentItem(), 1)) { p.getInventory().removeItem(e.getCurrentItem()); }
			if(e.getInventory().containsAtLeast(e.getCurrentItem(), 1)) { e.getInventory().removeItem(e.getCurrentItem()); }	
		}
	    }
	}
	}
	
	// Player KeepInv
	public static void playerKeepInv(Player p, PlayerDeathEvent e) {

		//if(!Arena.inArenaBattle.contains(p)) {
		if(p.getBedSpawnLocation() != null) {
			p.teleport(p.getBedSpawnLocation());
		} else {
			p.teleport(Bukkit.getServer().getWorld("world").getBlockAt(-43, 75, 348).getLocation());		
		}
		
		// HOTBAR
		for (int i = 0; i < 9; i++) {
		if (!(p.getInventory().getItem(i) == null)){
		e.getDrops().remove(p.getInventory().getItem(i));
		ItemStack item = p.getInventory().getItem(i);
		final int itemStack = i;
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
		public void run() {
		p.getInventory().setItem(itemStack, item);
		}
		}, 1);      
		}
		}
		// ARMOR
		if (!(p.getInventory().getArmorContents() == null)){
	    e.getDrops().remove(p.getInventory().getHelmet());
	    e.getDrops().remove(p.getInventory().getChestplate());
	    e.getDrops().remove(p.getInventory().getLeggings());
	    e.getDrops().remove(p.getInventory().getBoots());
	    ItemStack[] a = p.getInventory().getArmorContents();
	    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
	    public void run() {
	    p.getInventory().setArmorContents(a);	       
	    }
	    }, 1);
		}
		// SHIELD
		if (!(p.getInventory().getItemInOffHand() == null)){
		e.getDrops().remove(p.getInventory().getItemInOffHand());
		ItemStack item = p.getInventory().getItemInOffHand();
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
		public void run() {
		p.getInventory().setItemInOffHand(item);
		}
		}, 1);	
		}
		
		// GROUP
		e.getDrops().remove(p.getInventory().getItem(17));
		ItemStack item = p.getInventory().getItem(17);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
		public void run() {
		p.getInventory().setItem(17, item);
		}
		}, 1);	
		
		// MANA
		e.getDrops().remove(p.getInventory().getItem(26));
		ItemStack itemMana = p.getInventory().getItem(26);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
		public void run() {
		p.getInventory().setItem(26, itemMana);
		}
		}, 1);	
		
		// ABILITY
		e.getDrops().remove(p.getInventory().getItem(35));
		ItemStack itemAbility = p.getInventory().getItem(35);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
		public void run() {
		p.getInventory().setItem(35, itemAbility);
		}
		}, 1);	
		
		// LEVELS
		if(!(p.getLevel() == 0)) {
		int playerLevel = p.getLevel();
		int keptLevels = (int) (playerLevel * 0.9);
		int lostLevels = (int) (playerLevel * 0.1);
		
		ItemStack BagOfLostCoins = Items.createGoldBagItem("" + lostLevels);
		ItemStack BagOfKeptCoins = Items.createGoldBagItem("" + keptLevels);
		p.getWorld().dropItem(p.getLocation(), BagOfLostCoins);

		
		if(p.getInventory().firstEmpty() == -1) {
			p.sendMessage(ChatColor.RED + "Your inventory was full, so you dropped your " + ChatColor.AQUA + keptLevels +  ChatColor.RED + " coins at your spawn!");
		if(p.getBedSpawnLocation() != null) {
			p.getWorld().dropItem(p.getBedSpawnLocation(), BagOfKeptCoins);
			} else {
		    p.getWorld().dropItem(Bukkit.getServer().getWorld("world").getBlockAt(-43, 75, 348).getLocation(), BagOfKeptCoins);
			}
		} else {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
			public void run() {
			p.sendMessage(ChatColor.RED + "-" + lostLevels + ChatColor.RED + " coins" + ChatColor.AQUA + " (" + keptLevels + " coins kept)");
			p.getInventory().setItem(p.getInventory().firstEmpty(), BagOfKeptCoins);
			}
			}, 10);
		}
	}
	//} else {
	//	Arena.arenaPlayerDeath(p, e);
	//}
	}
	
	// Contain
	public static void contain(Player p) {
		p.teleport(Bukkit.getServer().getWorld("world").getBlockAt(-63, 17, 357).getLocation());
		Bukkit.getServer().broadcastMessage("" + ChatColor.DARK_RED + ChatColor.BOLD + "[Jailer] " + ChatColor.RESET + ChatColor.AQUA + p.getName() + ChatColor.GREEN + " has been contained!");
		p.setGameMode(GameMode.ADVENTURE);
		contained.add(p.getName());
	}
	// Release
	public static void release(Player p) {
		p.teleport(Bukkit.getServer().getWorld("world").getBlockAt(-43, 75, 348).getLocation());
		
		Bukkit.getServer().broadcastMessage("" + ChatColor.DARK_RED + ChatColor.BOLD + "[Jailer] " + ChatColor.RESET + ChatColor.AQUA + p.getName() + ChatColor.GREEN + " has been released!");
	    contained.remove(p.getName());
	}
	// Release
	public static void releaseAll() {
		
		for (int i = 0; i < PlayerManager.contained.size(); i++) {
		Player p = Bukkit.getServer().getPlayer(contained.get(i));
		p.teleport(Bukkit.getServer().getWorld("world").getBlockAt(-43, 75, 348).getLocation());
			
		Bukkit.getServer().broadcastMessage("" + ChatColor.DARK_RED + ChatColor.BOLD + "[Jailer] " + ChatColor.RESET + ChatColor.AQUA + p.getName() + ChatColor.GREEN + " has been released!");
		contained.remove(p.getName());
		}
	}
	// Jail
	public static void jail(Player p) {
		p.teleport(Bukkit.getServer().getWorld("world").getBlockAt(-63, 16, 339).getLocation());
		Bukkit.getServer().broadcastMessage("" + ChatColor.DARK_RED + ChatColor.BOLD + "[Jailer] " + ChatColor.RESET + ChatColor.AQUA + p.getName() + ChatColor.GREEN + " has been jailed!");
	    p.setGameMode(GameMode.ADVENTURE);
		jailed.add(p.getName());
	}
	// Unjail
	public static void unjail(Player p) {
		
		if(p.getBedSpawnLocation() == null) { p.teleport(Bukkit.getServer().getWorld("world").getBlockAt(-43, 75, 348).getLocation());
		} else { p.teleport(p.getBedSpawnLocation()); }
		
		Bukkit.getServer().broadcastMessage("" + ChatColor.DARK_RED + ChatColor.BOLD + "[Jailer] " + ChatColor.RESET + ChatColor.AQUA + p.getName() + ChatColor.GREEN + " has been unjailed!");
	    jailed.remove(p.getName());
	}
	// Jailed Players Protect
	public static void jailedPlayersProtect(Player p) {
		if(PlayerManager.jailed.contains(p.getName()) || PlayerManager.contained.contains(p.getName())) {
		p.removePotionEffect(PotionEffectType.REGENERATION);
		p.removePotionEffect(PotionEffectType.SATURATION);
		p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 3*20, 3));
		p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 3*20, 3));
		}
	}
	
	// antiClimb
	public static void antiClimb(Player p, PlayerMoveEvent e) {
		Block b = p.getLocation().getBlock();
		Location l = new Location(Bukkit.getServer().getWorld("world"), b.getX(), b.getY() - 5, b.getZ());
		if((l.getY() >= 120) && (l.getBlock().getType().equals(Material.COBBLESTONE) || l.getBlock().getType().equals(Material.STONE) || 
				l.getBlock().getType().equals(Material.OAK_LEAVES) || l.getBlock().getType().equals(Material.BIRCH_LEAVES) || l.getBlock().getType().equals(Material.SPRUCE_LEAVES) || 
				l.getBlock().getType().equals(Material.ACACIA_LEAVES) || l.getBlock().getType().equals(Material.DARK_OAK_LEAVES) || l.getBlock().getType().equals(Material.JUNGLE_LEAVES)) 
				&& (p.getGameMode().equals(GameMode.ADVENTURE))) {
			
		if(!hasClimbed.contains(p.getName())) {
			if(p.getBedSpawnLocation() != null) {
				p.teleport(p.getBedSpawnLocation());
			} else {
				p.teleport(Bukkit.getServer().getWorld("world").getBlockAt(-43, 75, 348).getLocation());
			}
			p.sendMessage(ChatColor.RED + "You were teleported to your spawnpoint because you climbed above the height limit!");	
			p.sendMessage(ChatColor.RED + "This is against the rules, and if you do this again, you will be jailed!");
			hasClimbed.add(p.getName());
		} else {
			p.sendMessage(ChatColor.RED + "You have been jailed for climbing too high!");
			PlayerManager.jail(p);
		}
		}
		// Anti Fly
		if(l.getY() >= 150 && p.getGameMode().equals(GameMode.ADVENTURE)) {         
			p.sendMessage(ChatColor.RED + "You have been jailed for flying!");
			PlayerManager.jail(p);
		}
		
		// Bed Tp Queue
		if(bedTpQueue.contains(p.getName())) {
		PlayerManager.bedTpQueue.remove(p.getName());
		p.sendMessage(ChatColor.RED + "You cannot move while trying to teleport!");
		}
	}
	
	// bedTP
	static int secTillTp = 30;
	public static void bedTP(Player p) {
		
		if(!PlayerManager.bedTpCooldown.contains(p.getName())) {
		Mining.unfinishedTasks++;
		PlayerManager.bedTpQueue.add(p.getName());
		p.sendMessage(ChatColor.GREEN + "Teleporting in " + ChatColor.AQUA + secTillTp + ChatColor.GREEN + " seconds, don't move!");
		PlayerManager.bedTpCooldown.add(p.getName());
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
		public void run() {
		Mining.unfinishedTasks--;	
		PlayerManager.bedTpCooldown.remove(p.getName());
		
		if(PlayerManager.bedTpQueue.contains(p.getName())) {
		if(p.getBedSpawnLocation() == null) { p.teleport(Bukkit.getServer().getWorld("world").getBlockAt(-43, 75, 348).getLocation());
		} else { p.teleport(p.getBedSpawnLocation()); }
		p.sendMessage(ChatColor.GREEN + "You have been teleported back to your bed!");
		PlayerManager.bedTpQueue.remove(p.getName());
		}
		}
		}, secTillTp * 20);
		} else {
		p.sendMessage(ChatColor.RED + "You cannot teleport for another 30 seconds!");
		}
	}
	
	public static void setBedSpawn(Player p, Action a, Block b, PlayerInteractEvent e) {
		if (a == Action.RIGHT_CLICK_BLOCK){
			if (b.getType().equals(Material.RED_BED) || b.getType().equals(Material.BLUE_BED) || b.getType().equals(Material.GREEN_BED) || b.getType().equals(Material.WHITE_BED) || b.getType().equals(Material.BLACK_BED)) {
				p.setBedSpawnLocation(b.getLocation());
				p.sendMessage(ChatColor.GREEN + "Your spawn point has been set!");
				e.setCancelled(true);
			}
		}
		
	}
	
	// Ability Item Prot
	public static void abilityItemProt(Player p, InventoryClickEvent e) {
		if(e.getCurrentItem() != null && !(e.getCurrentItem().getType().equals(Material.AIR))) {
		    if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
			if(e.getSlot() == 35 && p.getInventory().containsAtLeast(e.getCurrentItem(), 1)) {
				p.closeInventory();
				p.sendMessage(ChatColor.RED + "Your Ability Slot cannot be changed!");
				e.setCancelled(true);
			}
		    }
		}
	}
	
	// Mana Item Prot
	public static void manaItemProt(Player p, InventoryClickEvent e) {
		if(e.getCurrentItem() != null && !(e.getCurrentItem().getType().equals(Material.AIR))) {
		    if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
			if(e.getSlot() == 26 && p.getInventory().containsAtLeast(e.getCurrentItem(), 1)) {
				p.closeInventory();
				p.sendMessage(ChatColor.RED + "Your Mana Slot cannot be changed!");
				e.setCancelled(true);
			}
		    }
		}
	}
	
	// Mana Get Method
	public static int getMana(Player p) {
		String stringMana = p.getInventory().getItem(26).getItemMeta().getDisplayName();
		int mana = Integer.parseInt(stringMana);
		return mana;
	}
	
	// Mana Add Method
	public static void addMana(Player p, int amount) {
		int newMana = PlayerManager.getMana(p) + amount;
		if(newMana <= 1000) {
		p.getInventory().setItem(26, Items.createManaItem("" + newMana));
		} else {
		p.getInventory().setItem(26, Items.createManaItem("1000"));
		}
	}
	
	// Mana Remove Method
	public static void removeMana(Player p, int amount) {
		int newMana = PlayerManager.getMana(p) - amount;
		if(newMana >= 0) {
		p.getInventory().setItem(26, Items.createManaItem("" + newMana));	
		} else {
		p.getInventory().setItem(26, Items.createManaItem("0"));	
		}
	}
	static double manaInt = 0;
	// Mana Tracker
	public static void manaTracker(Player p) {
		if(p.getGameMode().equals(GameMode.ADVENTURE)) {
		if(PlayerManager.getMana(p) == 0) { PacketUtils.sendActionBar(p, ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"); } 
		if(PlayerManager.getMana(p) <= 33 && PlayerManager.getMana(p) > 0) {    PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"); } 
		if(PlayerManager.getMana(p) <= 66 && PlayerManager.getMana(p) > 33) {   PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>"); } 
		if(PlayerManager.getMana(p) <= 100 && PlayerManager.getMana(p) > 66) {  PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>"); } 
		if(PlayerManager.getMana(p) <= 133 && PlayerManager.getMana(p) > 100) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 166 && PlayerManager.getMana(p) > 133) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 200 && PlayerManager.getMana(p) > 166) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 233 && PlayerManager.getMana(p) > 200) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 266 && PlayerManager.getMana(p) > 233) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 300 && PlayerManager.getMana(p) > 266) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 333 && PlayerManager.getMana(p) > 300) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 366 && PlayerManager.getMana(p) > 333) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 400 && PlayerManager.getMana(p) > 366) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 433 && PlayerManager.getMana(p) > 400) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 466 && PlayerManager.getMana(p) > 433) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 500 && PlayerManager.getMana(p) > 466) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 533 && PlayerManager.getMana(p) > 500) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 566 && PlayerManager.getMana(p) > 533) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 600 && PlayerManager.getMana(p) > 566) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 633 && PlayerManager.getMana(p) > 600) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 666 && PlayerManager.getMana(p) > 633) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 700 && PlayerManager.getMana(p) > 666) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 733 && PlayerManager.getMana(p) > 700) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 766 && PlayerManager.getMana(p) > 733) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>>"); }
		if(PlayerManager.getMana(p) <= 800 && PlayerManager.getMana(p) > 766) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>>"); }
		if(PlayerManager.getMana(p) <= 833 && PlayerManager.getMana(p) > 800) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>>"); }
		if(PlayerManager.getMana(p) <= 866 && PlayerManager.getMana(p) > 833) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>>"); }
		if(PlayerManager.getMana(p) <= 900 && PlayerManager.getMana(p) > 866) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>>"); }
		if(PlayerManager.getMana(p) <= 933 && PlayerManager.getMana(p) > 900) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>>"); }
		if(PlayerManager.getMana(p) <= 966 && PlayerManager.getMana(p) > 933) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">>"); }
		if(PlayerManager.getMana(p) < 1000 && PlayerManager.getMana(p) > 966) { PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + ChatColor.WHITE + ">"); }
		if(PlayerManager.getMana(p) == 1000) { 
			manaInt++;
			double i = manaInt / 2;
			if(i == (int) i) {
			PacketUtils.sendActionBar(p, ChatColor.DARK_PURPLE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"); 
			} else {
			PacketUtils.sendActionBar(p, ChatColor.LIGHT_PURPLE + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			}
		}
		} else {
		PacketUtils.sendActionBar(p, "" + ChatColor.GREEN + Mining.unfinishedTasks + " (UT)" + " " + ChatColor.AQUA + Mining.ghostTorches.size() + " (GT)"+ " " + ChatColor.BLUE + Mining.unkilledGhostTorches.size() + " (UGT)");
		}
	}
	
	// OnHit Mana
	public static void onHitMana(Entity a, Entity d) {

		if(a instanceof Player) {
		if(d instanceof Player) {
		if(!Groups.isSameGroup((Player) a, (Player) d)) {
		PlayerManager.addMana((Player) a, 33);
		}
		} else {
		if(!(d instanceof Villager)) {
		PlayerManager.addMana((Player) a, 33);
		
		if(((HumanEntity) a).getInventory().getItem(17).getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Group: " + ChatColor.DARK_PURPLE + "Mage Society")){
		PlayerManager.addMana((Player) a, 17);
		}
		}
		}
		}
	}
	
	// Mana Gain
	public static void manaDegrade(Player p) {
		if(p.getHealth() > 0) {
		PlayerManager.addMana(p, 66);
		
		if(p.getInventory().getItem(17).getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Group: " + ChatColor.DARK_PURPLE + "Mage Society")){
	    PlayerManager.addMana(p, 33);
		}
		}
	}
	
	// Diving Helmet
	public static void divingHelmet(Player p) {
		if(p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getType().equals(Material.CARVED_PUMPKIN)) {
			if(p.getRemainingAir() < 100)
				p.setRemainingAir(90);
		}
	}
	
	// TORCH MANAGER ///////////////////////////////////
	public static void torchUpdate(Player p) {
		Block b = p.getLocation().getBlock();
		if(b.getType().equals(Material.AIR) && (p.getInventory().getItemInOffHand().getType().equals(Material.TORCH)|| p.getInventory().getItemInMainHand().getType().equals(Material.TORCH))){
			b.setType(Material.TORCH);
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
	        public void run() {
	            b.setType(Material.AIR);
	        }
	        }, 10);
		}
	}
	////////////////////////////////////////////////////	        
		
	static int secTillEndCombat = 7;
	
	// In Combat
	public static void inCombat(Player p) {
		
		Mining.unfinishedTasks++;
		PlayerManager.inCombat.add(p.getName());
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
			public void run() {
			Mining.unfinishedTasks--;	
			PlayerManager.inCombat.remove(p.getName());
			}
		}, secTillEndCombat * 20);
		
	}
	
	// PressurePlates CombatProt
	public static void inCombatPressurePlateProt(Player p, PlayerInteractEvent event) {
		if(event.getAction().equals(Action.PHYSICAL) && PlayerManager.inCombat.contains(p.getName())) {
			if(event.getClickedBlock().getType().equals(Material.STONE_PRESSURE_PLATE)) {
				event.setCancelled(true);
			}
		}
	}
	
	
	// PressurePlates ForPlayersOnly
	public static void onMobStepPressurePlate(Entity e, EntityInteractEvent event) {
		if(!(e instanceof Player)) {
			if(event.getBlock().getType().equals(Material.STONE_PRESSURE_PLATE)) {
				event.setCancelled(true);
			}
		} 
	}
	
	// Get player max health
	public static double getMaxHealth(Player p) {
		return p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
	}
	
	// Set player max health
	public static void setMaxHealth(Player p, double health) {
		AttributeInstance healthAttribute = p.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		healthAttribute.setBaseValue(health);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}