package erestor_;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Arena {
	
	static Block mobSpawnArena = Bukkit.getServer().getWorld("world").getBlockAt(157, 75, -11);
	
	public static void spawnArenaMob() {
		int n = Main.getRandom(4, 1);
		
		Collection<Entity> Entities = Bukkit.getServer().getWorld("world").getNearbyEntities(mobSpawnArena.getLocation(), 30, 5, 30);
		
		for(Entity e : Entities) {
			if(e instanceof Damageable && e instanceof PigZombie) {
				if(((PigZombie) e).getCustomName() != null && (
						((PigZombie) e).getCustomName().equals(ChatColor.RED + "Untrained Eastcliff Warrior") 
						|| ((PigZombie) e).getCustomName().equals(ChatColor.RED + "Lesser Eastcliff Warrior") 
						|| ((PigZombie) e).getCustomName().equals(ChatColor.RED + "Greater Eastcliff Warrior") 
						|| ((PigZombie) e).getCustomName().equals(ChatColor.RED + "Eastcliff Champion"))) {
					((Damageable) e).remove();
				}
			}
		}
		
		// Untrained Warrior
		if(n == 1) {
		spawnArenaMob(
				mobSpawnArena.getLocation(),
				"Untrained Eastcliff Warrior",
				50, 
				Items.DiamondSword, 
				Items.DiamondShield,
				Items.DiamondHelmet, 
				Items.DiamondChestplate, 
				Items.IronLeggings, 
				Items.IronBoots, 
				PotionEffectType.INCREASE_DAMAGE, 
				1, 
				PotionEffectType.SPEED, 
				1, 
				false);
		}
		// Lesser Warrior
		if(n == 2) {
		spawnArenaMob(
				mobSpawnArena.getLocation(),
				"Lesser Eastcliff Warrior",
				80, 
				Items.DiamondKnife, 
				Items.DiamondKnife, 
				Items.DiamondHelmet, 
				Items.DiamondChestplate, 
				Items.DiamondLeggings, 
				Items.DiamondBoots, 
				PotionEffectType.INCREASE_DAMAGE, 
				1, 
				PotionEffectType.SPEED, 
				2, 
				false);
		}
		// Greater Warrior
		if(n == 3) {
		spawnArenaMob(
				mobSpawnArena.getLocation(),
				"Greater Eastcliff Warrior",
				120, 
				Items.MithrilSword, 
				Items.MithrilShield,
				Items.MithrilHelmet, 
				Items.MithrilChestplate, 
				Items.IronLeggings, 
				Items.MithrilBoots, 
				PotionEffectType.INCREASE_DAMAGE, 
				1, 
				PotionEffectType.SPEED, 
				2, 
				false);
		}
		// Champion
		if(n == 4) {
		spawnArenaMob(
				mobSpawnArena.getLocation(),
				"Eastcliff Champion",
				200, 
				Items.AdamantiteBattleaxe, 
				Items.AdamantiteBattleaxe,
				Items.AdamantiteHelmet, 
				Items.AdamantiteChestplate, 
				Items.IronLeggings, 
				Items.AdamantiteBoots, 
				PotionEffectType.INCREASE_DAMAGE, 
				2, 
				PotionEffectType.SPEED, 
				3, 
				false);
		}
	}
	
	public static void spawnArenaMob(Location l, String name, int health, ItemStack sword, ItemStack offhand, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots, PotionEffectType potOne, int ampOne, PotionEffectType potTwo, int ampTwo, boolean isBaby) {
 		
	    PigZombie pigman = (PigZombie) l.getWorld().spawn(l, PigZombie.class);
	    pigman.setCustomName(ChatColor.RED + name);
	    pigman.setCustomNameVisible(true);
	    Spawns.setMaxHealth(pigman, health);
		pigman.setHealth(health);
		pigman.getEquipment().setItemInMainHand(sword);
		pigman.getEquipment().setItemInOffHand(offhand);
		pigman.getEquipment().setHelmet(helmet);
		pigman.getEquipment().setChestplate(chestplate);
		pigman.getEquipment().setLeggings(leggings);
		pigman.getEquipment().setBoots(boots);
		pigman.setBaby(isBaby);
		pigman.addPotionEffect(new PotionEffect(potOne, 999999, ampOne));
		pigman.addPotionEffect(new PotionEffect(potTwo, 999999, ampTwo));
		pigman.setAngry(true);
	}
	
	/*
	static int playerCoins = 0;
	static Inventory arenaPlayerInv;
	static ArrayList<Player> inArenaBattle = new ArrayList<Player>();
	static ArrayList<OfflinePlayer> arenaGhostPlayer = new ArrayList<OfflinePlayer>();
	static ArrayList<Entity> arenaMobs = new ArrayList<Entity>();
	static Block insideArena = Bukkit.getServer().getWorld("world").getBlockAt(171, 75, -25);
	static Block outsideArena = Bukkit.getServer().getWorld("world").getBlockAt(171, 75, -35);
	static Block mobSpawnArena = Bukkit.getServer().getWorld("world").getBlockAt(157, 75, -11);
	
	// Arena GUI
	public static Inventory ArenaInv;
		public static void openArenaInv(Player p){
			ArenaInv = Bukkit.createInventory(null, 9, ChatColor.DARK_GRAY + "Arena Master"); 
					    
			ArenaInv.setItem(0, Items.arenaWarrior);	
			ArenaInv.setItem(1, Items.arenaKnight);

		p.openInventory(ArenaInv);
				    
	}
	
	public static void arenaMethod(ItemStack item, int amount, Player p, InventoryClickEvent e, int id) {

		if(e.getInventory().getName().contains("Arena Master") && !e.getCurrentItem().getType().equals(Material.AIR)) {
		if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName()) && e.getCurrentItem().getItemMeta().getLore().equals(item.getItemMeta().getLore())) {
		if(inArenaBattle.size() == 0) {
			if(p.getLevel() >= amount) {
			p.giveExpLevels(-amount);
			p.playSound(p.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL , 10, 1); 
			
			inArenaBattle.add(p);
			p.teleport(insideArena.getLocation());	
			
			if(id==1){
			spawnArenaMob(
					mobSpawnArena.getLocation(),
					"Eastcliff Warrior",
					100, 
					Items.IronBattleaxe, 
					Items.IronHelmet, 
					Items.WoodChestplate, 
					Items.WoodLeggings, 
					Items.WoodBoots, 
					PotionEffectType.INCREASE_DAMAGE, 
					2, 
					PotionEffectType.SPEED, 
					2, 
					false);
			}
			if(id==2){
			spawnArenaMob(
					mobSpawnArena.getLocation(),
					"Eastcliff Knight",
					200, 
					Items.IronSword, 
					Items.IronHelmet, 
					Items.IronChestplate, 
					Items.IronLeggings, 
					Items.IronBoots, 
					PotionEffectType.INCREASE_DAMAGE, 
					0, 
					PotionEffectType.SPEED, 
					0, 
					false);
			}
			} 
		    } else {
		    p.closeInventory();
		    p.sendMessage(ChatColor.RED + "Someone is already using the arena!");
		    }
			}
		}
		e.setCancelled(true);
		} 	
		}
	
	public static void arenaBattleStart(Player p, InventoryClickEvent e) {
		Arena.arenaMethod(Items.arenaWarrior, 100, p, e, 1);
		Arena.arenaMethod(Items.arenaKnight, 1000, p, e, 2);
	}
	
	public static void arenaMobDeath(Entity e){
		for(Player p : inArenaBattle) {
		if(e.getCustomName() != null) {
		if(e.getNearbyEntities(8, 20, 8).contains(p)) {
			if(e.getCustomName().contains("Eastcliff Warrior")) {
			p.sendMessage("" + e.getCustomName() + " has been defeated!");
			p.sendMessage(ChatColor.GREEN + "Teleporting in 10 seconds...");
			Mining.unfinishedTasks++;
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
		        public void run() {
		        p.teleport(outsideArena.getLocation());
		        p.sendMessage(ChatColor.GOLD + "+1500 Coins!");
		        p.giveExpLevels(1500);
		        p.setHealth(p.getMaxHealth());
		        inArenaBattle.remove(p);
		        Mining.unfinishedTasks--;
		        }
	            }, 10 * 20);
			}
			if(e.getCustomName().contains("Eastcliff Knight")) {
				p.sendMessage("" + e.getCustomName() + " has been defeated!");
				p.sendMessage(ChatColor.GREEN + "Teleporting in 10 seconds...");
				Mining.unfinishedTasks++;
				
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
			        public void run() {
			        p.teleport(outsideArena.getLocation());
			        p.sendMessage(ChatColor.GOLD + "+5500 Coins!");
			        p.giveExpLevels(5500);
			        p.setHealth(p.getMaxHealth());
			        inArenaBattle.remove(p);
			        Mining.unfinishedTasks--;
			        }
		            }, 10 * 20);	
			}
		}
		}
		}
	}
	
	public static void spawnArenaMob(Location l, String name, int health, ItemStack sword, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots, PotionEffectType potOne, int ampOne, PotionEffectType potTwo, int ampTwo, boolean isBaby) {
	 		
    PigZombie pigman = (PigZombie) l.getWorld().spawn(l, PigZombie.class);
    pigman.setCustomName(ChatColor.RED + name);
    pigman.setCustomNameVisible(true);
    pigman.setMaxHealth(health);
	pigman.setHealth(health);
	pigman.getEquipment().setItemInMainHand(sword);
	pigman.getEquipment().setHelmet(helmet);
	pigman.getEquipment().setChestplate(chestplate);
	pigman.getEquipment().setLeggings(leggings);
	pigman.getEquipment().setBoots(boots);
	pigman.setBaby(isBaby);
	pigman.addPotionEffect(new PotionEffect(potOne, 999999, ampOne));
	pigman.addPotionEffect(new PotionEffect(potTwo, 999999, ampTwo));
	pigman.setAngry(true);
	arenaMobs.add(pigman);
	}
	
	public static void forceMobDespawn() {
		if(arenaMobs.size() > 0) {
		for(Entity mob : arenaMobs) {
			((Damageable) mob).damage(1000);
			arenaMobs.remove(mob);
		}
		}
	}
	
	// Arena Player Death
	public static void arenaPlayerDeath(Player p, PlayerDeathEvent e) {
		if(inArenaBattle.contains(p)) {
			p.sendMessage(ChatColor.RED + "You have been defeated!");
			forceMobDespawn();
			e.getDrops().clear();
			
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
		    public void run() {
			p.getInventory().setContents(arenaPlayerInv.getContents());
			p.setLevel(playerCoins);
			p.teleport(outsideArena.getLocation());
			inArenaBattle.remove(p);
		    }
			}, 5);
		}
	}
	
	// Arena Reset 
	public static void arenaReset() {
	
		if(inArenaBattle.size() > 0) {
		OfflinePlayer p = Bukkit.getOfflinePlayer(inArenaBattle.get(1).getUniqueId());
		if(!p.isOnline()) {
			arenaGhostPlayer.add(p);
			inArenaBattle.remove(p.getPlayer());
			forceMobDespawn();
		}
		} 
		
		if(arenaGhostPlayer.size() > 0) {
		for(OfflinePlayer p : arenaGhostPlayer) {
		if (p.getPlayer().isOnline()) {
			p.getPlayer().teleport(outsideArena.getLocation());
			arenaGhostPlayer.remove(p.getPlayer());
		}
		}
	}
	}
	*/
}
