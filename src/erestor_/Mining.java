package erestor_;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import erestor_.Main;

@SuppressWarnings("deprecation")
public class Mining {
	
	static int unfinishedTasks = 0;
	static int remainingGhostTorches = 0;
	
	// SpawnItemInAirBlock
	public static Block getNearbyAirBlock(Block b) {
		
		Block up = b.getRelative(BlockFace.UP);
		Block north = b.getRelative(BlockFace.NORTH);
		Block south = b.getRelative(BlockFace.SOUTH);
		Block east = b.getRelative(BlockFace.EAST);
		Block west = b.getRelative(BlockFace.WEST);
		Block down = b.getRelative(BlockFace.DOWN);
		
		if(up.getType().equals(Material.AIR) || up.getType().equals(Material.WATER)){ 
			return up;
		} else if(north.getType().equals(Material.AIR) || north.getType().equals(Material.WATER) || north.getType().equals(Material.LEGACY_STATIONARY_WATER)) {
			return north;
		} else if(south.getType().equals(Material.AIR) || south.getType().equals(Material.WATER) || south.getType().equals(Material.LEGACY_STATIONARY_WATER)) {
			return south;
		} else if(east.getType().equals(Material.AIR) || east.getType().equals(Material.WATER) || east.getType().equals(Material.LEGACY_STATIONARY_WATER)) {
			return east;
		} else if(west.getType().equals(Material.AIR) || west.getType().equals(Material.WATER) || west.getType().equals(Material.LEGACY_STATIONARY_WATER)) {
			return west;
		} else if(down.getType().equals(Material.AIR) || down.getType().equals(Material.WATER) || down.getType().equals(Material.LEGACY_STATIONARY_WATER)) {
			return down;
		} else {
			return up;
		}
		
	}
	
	public static void MineOre(Block b, Player p, Material firstOre, Material secondOre, ItemStack drop, int amount, int time, int spawnId, int spawnChancePercent, int spawnMinAmount, int spawnMaxAmount) {		
	    if(p.getGameMode().equals(GameMode.ADVENTURE)){   	 
		if (b.getType().equals(firstOre)) {				
	       		 
	       		for (int i = 0; i < amount; i++) {
	       		getNearbyAirBlock(b).getLocation().getWorld().dropItem(getNearbyAirBlock(b).getLocation().add(+0.5, +0, +0.5), drop).setVelocity(new Vector(0, 0, 0));
	       		}
	       		
	       		p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, firstOre);
	            b.setType(secondOre);      
	            
	            // Water Spawns
        	    if(p.getLocation().getBlock().getType().equals(Material.WATER) || p.getLocation().getBlock().getType().equals(Material.LEGACY_STATIONARY_WATER)) {
        			Spawns.waterSpawns(p, spawnId, spawnChancePercent, spawnMinAmount, spawnMaxAmount);
        		} else {
	            // Mine Spawns
	                Spawns.mineSpawns(p, spawnId, spawnChancePercent, spawnMinAmount, spawnMaxAmount); 
        		}
	            
	            unfinishedTasks++;
	            BlockListing listing = new BlockListing(firstOre,b);
	            MineLog.MineList.add(listing);
	       		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
	            public void run() {
	            	if(MineLog.MineList.contains(listing)){
	            	b.setType(firstOre);
	            	p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, firstOre);
	            	MineLog.MineList.remove(listing);
	            	unfinishedTasks--;
	            	}
	            }
	            }, time * 20);
	       }	
	    }
	}
	
	public static void MineGem(Block b, Player p, Material firstOre, Material secondOre, ItemStack drop, int amount, int time, int spawnId, int spawnChancePercent) {		
		if(p.getGameMode().equals(GameMode.ADVENTURE)){      	 
		if (b.getType().equals(firstOre)) {						       		
	       		 
	       		for (int i = 0; i < amount; i++) {
		       	getNearbyAirBlock(b).getLocation().getWorld().dropItem(getNearbyAirBlock(b).getLocation().add(+0.5, +0, +0.5), drop).setVelocity(new Vector(0, 0, 0));
	       		}
	       		
	       		p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, firstOre);
	            b.setType(secondOre);
	            
	            // Spawns
	            Spawns.forestSpawns(p, spawnId, spawnChancePercent);
	            Spawns.forestSpawns(p, spawnId, spawnChancePercent);
	            
	            unfinishedTasks++;
	            BlockListing listing = new BlockListing(firstOre,b);
	            MineLog.MineList.add(listing);
	       		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
	            public void run() {
	            	if(MineLog.MineList.contains(listing)){
	            		b.setType(firstOre);
	            		p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, firstOre);
	            		MineLog.MineList.remove(listing);
	            		unfinishedTasks--;
	            	}
	            }
	            }, time * 20);
	       	}	 
		}
	}

	public static void Mine(Player p, Block b, Action a) {
	if (a == Action.LEFT_CLICK_BLOCK){
		Material m = p.getInventory().getItemInMainHand().getType();
		Material o = p.getInventory().getItemInMainHand().getType(); // Change to offhand to enable offhand
		
		// Oak Wood
		Mining.MineOre(b, p, Material.OAK_WOOD, Material.STRIPPED_OAK_WOOD, Items.Stick, 2, 15, 0, 100, 1, 5);

		// Jungle Wood
		Mining.MineOre(b, p, Material.JUNGLE_WOOD, Material.STRIPPED_OAK_WOOD, Items.Stick, 2, 15, 0, 100, 1, 5);
		
		// Stone
		if (m.equals(Material.WOODEN_PICKAXE) || o.equals(Material.WOODEN_PICKAXE) || m.equals(Material.STONE_PICKAXE) || o.equals(Material.STONE_PICKAXE) || m.equals(Material.IRON_PICKAXE) || o.equals(Material.IRON_PICKAXE) || m.equals(Material.GOLDEN_PICKAXE) || o.equals(Material.GOLDEN_PICKAXE) || m.equals(Material.DIAMOND_PICKAXE) || o.equals(Material.DIAMOND_PICKAXE)){
		Mining.MineOre(b, p, Material.COBBLESTONE, Material.STONE, Items.CobbleStone, 3, 1 * 60, 0, 100, 1, 5);
       	}
		// Mossy Stone
		if (m.equals(Material.WOODEN_PICKAXE) || o.equals(Material.WOODEN_PICKAXE) || m.equals(Material.STONE_PICKAXE) || o.equals(Material.STONE_PICKAXE) || m.equals(Material.IRON_PICKAXE) || o.equals(Material.IRON_PICKAXE) || m.equals(Material.GOLDEN_PICKAXE) || o.equals(Material.GOLDEN_PICKAXE) || m.equals(Material.DIAMOND_PICKAXE) || o.equals(Material.DIAMOND_PICKAXE)){
		Mining.MineOre(b, p, Material.MOSSY_COBBLESTONE, Material.STONE, Items.CobbleStone, 3, 1 * 60, 0, 100, 1, 5);
		}
		// Coal
		if (m.equals(Material.WOODEN_PICKAXE) || o.equals(Material.WOODEN_PICKAXE) || m.equals(Material.STONE_PICKAXE) || o.equals(Material.STONE_PICKAXE) || m.equals(Material.IRON_PICKAXE) || o.equals(Material.IRON_PICKAXE) || m.equals(Material.GOLDEN_PICKAXE) || o.equals(Material.GOLDEN_PICKAXE) || m.equals(Material.DIAMOND_PICKAXE) || o.equals(Material.DIAMOND_PICKAXE)){
		Mining.MineOre(b, p, Material.COAL_ORE, Material.STONE, Items.Coal, 4, 1 * 60, 0, 100, 1, 5);
       	}
		// Iron
		if (m.equals(Material.STONE_PICKAXE) || o.equals(Material.STONE_PICKAXE) || m.equals(Material.IRON_PICKAXE) || o.equals(Material.IRON_PICKAXE) || m.equals(Material.GOLDEN_PICKAXE) || o.equals(Material.GOLDEN_PICKAXE) || m.equals(Material.DIAMOND_PICKAXE) || o.equals(Material.DIAMOND_PICKAXE)){
		Mining.MineOre(b, p, Material.IRON_ORE, Material.STONE, Items.IronOre, 2, 2 * 60, 1, 10, 1, 2);
		}
		// Gold
		if (m.equals(Material.IRON_PICKAXE) || o.equals(Material.IRON_PICKAXE) || m.equals(Material.GOLDEN_PICKAXE) || o.equals(Material.GOLDEN_PICKAXE) || m.equals(Material.DIAMOND_PICKAXE) || o.equals(Material.DIAMOND_PICKAXE)){
		Mining.MineOre(b, p, Material.GOLD_ORE, Material.STONE, Items.GoldOre, 2, 3 * 60, 2, 15, 1, 2);
		}
		// Sapphire
		if ( m.equals(Material.IRON_PICKAXE) || o.equals(Material.IRON_PICKAXE) || m.equals(Material.GOLDEN_PICKAXE) || o.equals(Material.GOLDEN_PICKAXE) || m.equals(Material.DIAMOND_PICKAXE) || o.equals(Material.DIAMOND_PICKAXE)){
		Mining.MineGem(b, p, Material.TERRACOTTA, Material.STONE, Items.Sapphire, 1, 40, 1, 50);
		}
		// Ruby
		if ( m.equals(Material.IRON_PICKAXE) || o.equals(Material.IRON_PICKAXE) || m.equals(Material.GOLDEN_PICKAXE) || o.equals(Material.GOLDEN_PICKAXE) || m.equals(Material.DIAMOND_PICKAXE) || o.equals(Material.DIAMOND_PICKAXE)){
		Mining.MineGem(b, p, Material.ORANGE_TERRACOTTA, Material.STONE, Items.Ruby, 1, 40, 1, 50);
		}
		// Emerald
		if ( m.equals(Material.IRON_PICKAXE) || o.equals(Material.IRON_PICKAXE) || m.equals(Material.GOLDEN_PICKAXE) || o.equals(Material.GOLDEN_PICKAXE) || m.equals(Material.DIAMOND_PICKAXE) || o.equals(Material.DIAMOND_PICKAXE)){
		Mining.MineGem(b, p, Material.EMERALD_ORE, Material.STONE, Items.Emerald, 1, 20, 1, 25);
		}
		// Prismarine
		if (checkForPickMainHand(p, 1) || checkForPickOffHand(p, 1)){
		Mining.MineOre(b, p, Material.PRISMARINE, Material.DIRT, Items.PrismarineCrystals, 1, 6 * 60, 101, 10, 2, 5);
		}
		// Diamond
		if (m.equals(Material.GOLDEN_PICKAXE) || o.equals(Material.GOLDEN_PICKAXE) || m.equals(Material.DIAMOND_PICKAXE) || o.equals(Material.DIAMOND_PICKAXE)){
		Mining.MineOre(b, p, Material.DIAMOND_ORE, Material.STONE, Items.DiamondOre, 2, 4 * 60, 3, 10, 1, 3);
		}
		// Mithril
		if (m.equals(Material.DIAMOND_PICKAXE) || o.equals(Material.DIAMOND_PICKAXE)){
		Mining.MineOre(b, p, Material.MAGENTA_TERRACOTTA, Material.STONE, Items.MithrilOre, 1, 5 * 60, 4, 10, 1, 1);
		}
		// Magma
		if (m.equals(Material.DIAMOND_PICKAXE) || o.equals(Material.DIAMOND_PICKAXE)){
		Mining.MineOre(b, p, Material.MAGMA_BLOCK, Material.STONE, Items.Magma, 1, 2 * 60, 4, 10, 1, 1);
		}
		// Adamantite
		if (checkForPickMainHand(p, 1) || checkForPickOffHand(p, 1)){
		Mining.MineOre(b, p, Material.LIGHT_BLUE_TERRACOTTA, Material.STONE, Items.AdamantiteOre, 1, 7 * 60, 5, 10, 2, 4);
		}
		// Void
		if (checkForPickMainHand(p, 2) || checkForPickOffHand(p, 2)){
		Mining.MineOre(b, p, Material.YELLOW_TERRACOTTA, Material.STONE, Items.VoidOre, 1, 10 * 60, 0, 100, 1, 5);
		}
		
		// Spider Boss
		if(b.getLocation().getY() == 58) {
		Mining.MineOre(b, p, Material.BLACK_TERRACOTTA, Material.BARRIER, Items.Stick, 0, 5 * 60, 1001, 100, 1, 1);	
		}
		
		// Lake Boss
		if(b.getLocation().getY() == 36) { 
		if(checkForPickMainHand(p, 2) || checkForPickOffHand(p, 2)) {
		Mining.MineOre(b, p, Material.GOLD_BLOCK, Material.DARK_PRISMARINE, Items.GoldIngot, 50, 5 * 60, 102, 100, 1, 1);	
		} else {
		p.sendMessage(ChatColor.RED + "You need a stronger pickaxe to mine that!");
		}
		}
	}
	}
	
	// TestforPick
	// Mainhand Check
	public static boolean checkForPickMainHand(Player p, int lvl) {
		
		if(p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().getType() != Material.AIR && p.getInventory().getItemInMainHand().hasItemMeta()) {
		String mN = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
		Material m = p.getInventory().getItemInMainHand().getType();
		
		if(lvl == 1) {
		if ((mN.contains("Mithril Pickaxe") || mN.contains("Adamantite Pickaxe") || mN.contains("Void Pickaxe")) && m.equals(Material.DIAMOND_PICKAXE)){
			return true;
		} else { return false; }
		
		} else if(lvl == 2) {
		if ((mN.contains("Adamantite Pickaxe") || mN.contains("Void Pickaxe")) && m.equals(Material.DIAMOND_PICKAXE)){
			return true;
		} else { return false; }
		
		} else if(lvl == 3) {
		if ((mN.contains("Void Pickaxe")) && m.equals(Material.DIAMOND_PICKAXE)){
			return true;
		} else { return false; }
		
		} else {
		         return false;
		}
		} else {
			return false;
		}
	}
			
    // Offhand Check
    public static boolean checkForPickOffHand(Player p, int lvl) {
		
		if(p.getInventory().getItemInOffHand().getType() != null && p.getInventory().getItemInOffHand().getType() != Material.AIR && p.getInventory().getItemInOffHand().hasItemMeta()) {
		String mN = p.getInventory().getItemInOffHand().getItemMeta().getDisplayName();
		Material m = p.getInventory().getItemInOffHand().getType();
		
		if(lvl == 1) {
		if ((mN.contains("Mithril Pickaxe") || mN.contains("Adamantite Pickaxe") || mN.contains("Void Pickaxe")) && m.equals(Material.DIAMOND_PICKAXE)){
			return true;
		} else { return false; }
		
		} else if(lvl == 2) {
		if ((mN.contains("Adamantite Pickaxe") || mN.contains("Void Pickaxe")) && m.equals(Material.DIAMOND_PICKAXE)){
			return true;
		} else { return false; }
		
		} else if(lvl == 3) {
		if ((mN.contains("Void Pickaxe")) && m.equals(Material.DIAMOND_PICKAXE)){
			return true;
		} else { return false; }
		
		} else {
		         return false;
		}
		} else {
			return false;
		}
	}
	
	
	
	// MineMaker Util
	public static void mineMakerUtil(Player p, Action a) {
		if(!a.equals(Action.PHYSICAL)) {
			if(p.getInventory().getItemInMainHand().getType().equals(Material.SPONGE) && p.getGameMode().equals(GameMode.SPECTATOR)) {
				Bukkit.getServer().getWorld("world").createExplosion(p.getLocation(), 3.0F, false);
			} else if(p.getInventory().getItemInMainHand().getType().equals(Material.SPONGE) && p.getGameMode().equals(GameMode.CREATIVE)) {
				Bukkit.getServer().getWorld("world").createExplosion(p.getLocation(), 6.0F, false);
			}
		}
	}

	static ArrayList<Block> ghostTorches = new ArrayList<Block>();
	static ArrayList<Block> unkilledGhostTorches = new ArrayList<Block>();
	
	// Torches
	public static void torchManager(Block b, Player p, Action a){
		if(p.getGameMode().equals(GameMode.ADVENTURE)) {
		
		// Qualifiers
		if((p.getInventory().getItemInMainHand().getType().equals(Material.TORCH) || p.getInventory().getItemInOffHand().getType().equals(Material.TORCH)) && a == Action.RIGHT_CLICK_BLOCK) {
			if(p.getInventory().contains(Material.TORCH, 1)) {
			Location topBlockLoc = new Location(Bukkit.getServer().getWorld("world"), b.getLocation().getX(), b.getLocation().getY() + 1, b.getLocation().getZ());
			if(!b.getType().equals(Material.AIR) && topBlockLoc.getBlock().getType().equals(Material.AIR)) {
			
			topBlockLoc.getBlock().setType(Material.TORCH);
			p.getInventory().removeItem(Items.torch);		
			
			unfinishedTasks++;
			BlockListing listing = new BlockListing(Material.AIR,topBlockLoc.getBlock());
            MineLog.MineList.add(listing);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
	        public void run() {

	        	if(MineLog.MineList.contains(listing)){
	        	topBlockLoc.getBlock().breakNaturally();		     
	        	p.getWorld().playSound(topBlockLoc, Sound.BLOCK_FIRE_EXTINGUISH, 10, 10);	   
	        	MineLog.MineList.remove(listing);
	        	unfinishedTasks--;
	        	}
            
	            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
		        public void run() {
		        if(topBlockLoc.getBlock().getLightLevel() == 14) {
		        ghostTorches.add(topBlockLoc.getBlock());
                remainingGhostTorches++;
                
                // Spawn Chunk Failsafe
                if(topBlockLoc.getBlock().getChunk().isLoaded()) {
                	if(topBlockLoc.getBlock().getLightLevel() == 14) {
        		    unkilledGhostTorches.add(topBlockLoc.getBlock());
        		    ghostTorches.remove(topBlockLoc.getBlock());
                    remainingGhostTorches--;	
                	}
                }           
                
		        }
		        }
	            }, 1 * 20);
		                          
	        }
	        }, 180 * 20);
		}
		} else {
		p.sendMessage(ChatColor.RED + "Your inventory does not contain torches!");
		}
		}
		}
		
	}
	
	//Ghost Torch Destroyer
	public static void antiGhostTorch(ChunkLoadEvent e) {
	Chunk c = e.getChunk();
	
	for(Block b : ghostTorches) {
	if(b.getChunk().getX() == c.getX() && b.getChunk().getZ() == c.getZ()) {
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
	public void run() {
	b.setType(Material.TORCH);
	
	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
	   public void run() {
	   b.breakNaturally();	  
	   remainingGhostTorches--;
	   ghostTorches.remove(b);
	   
	   // Failsafe
	   Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
		   public void run() {
		   if(b.getLightLevel() == 14) {
           unkilledGhostTorches.add(b);
		   }
		   }
	   }, 5);
	   }
	   
	}, 1);
	}
    }, 1);
	}
	}
	}

	//Force Ghost Torch Break
	public static void forceGhostTorchBreak() {
	if(unkilledGhostTorches.size() > 0) {
	for(Block b : unkilledGhostTorches) {

	b.setType(Material.TORCH);
	
	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
		   public void run() {
		   b.breakNaturally();
		   
		   // Failsafe
		   Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
			   public void run() {
				   if(b.getLightLevel() != 14) {
                   unkilledGhostTorches.remove(b);
				   }
			   }
		   }, 1);
		   
		   }
		   }, 1);	
	}
	}
	}
}