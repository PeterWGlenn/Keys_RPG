package erestor_;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

public class Doors {
	
	public static void doorMeta(ItemStack Key, int x, int y, int z, int xT, int yT, int zT, int id, Player p, Block b, Action a) {
		if (a == Action.RIGHT_CLICK_BLOCK){
			if (b.getType().equals(Material.IRON_DOOR)) {
		    if (b.getLocation().equals(Bukkit.getServer().getWorld("world").getBlockAt(x, y, z).getLocation()) || b.getLocation().equals(Bukkit.getServer().getWorld("world").getBlockAt(x, (y + 1), z).getLocation())) {
    		
		    if (p.getInventory().getItemInMainHand().getType() != Material.AIR && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName() != null && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(Key.getItemMeta().getDisplayName())) {
    	    p.sendMessage(ChatColor.GREEN + "You opened a locked door!");
    	    
    		Bukkit.getServer().getWorld("world").getBlockAt(xT, yT, zT).setType(Material.REDSTONE_TORCH);
    		
    		p.getInventory().removeItem(Key);
    		
    		///////////////////////////// BOSS SPAWNS //////////////////////////////////////////
    		if(id == 1) { Spawns.spawnZombieMethod(-205, 49, 381, ChatColor.RED + "Governor", 80, Items.GoldSword, Items.GoldHelmet, Items.IronChestplate, Items.IronLeggings, Items.IronBoots, PotionEffectType.SPEED, 2, PotionEffectType.INCREASE_DAMAGE, 0, false, true); }
    		if(id == 3) { Spawns.spawnZombieMethod(320, 91, 69, ChatColor.RED + "Captain of the Guard", 100, Items.DiamondSword, Items.DiamondHelmet, Items.DiamondChestplate, Items.GoldLeggings, Items.DiamondBoots, PotionEffectType.SPEED, 2, PotionEffectType.INCREASE_DAMAGE, 0, false, true); 
    		              Spawns.spawnZombieMethod(320, 91, 71, ChatColor.GREEN + "Undead Wall Guard", 40, Items.GoldSword, Items.DiamondHelmet, Items.IronChestplate, Items.IronLeggings, Items.IronBoots, PotionEffectType.SPEED, 1, PotionEffectType.REGENERATION, 0, false, true);
    		              Spawns.spawnZombieMethod(320, 91, 67, ChatColor.GREEN + "Undead Wall Guard", 40, Items.GoldSword, Items.DiamondHelmet, Items.IronChestplate, Items.IronLeggings, Items.IronBoots, PotionEffectType.SPEED, 1, PotionEffectType.REGENERATION, 0, false, true);}
    		if(id == 9) { Arena.spawnArenaMob(); }
    		////////////////////////////////////////////////////////////////////////////////////
    		
    		Mining.unfinishedTasks++;
    		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
            public void run() {
            Bukkit.getServer().getWorld("world").getBlockAt(xT, yT, zT).setType(Material.AIR);     
            Mining.unfinishedTasks--;
            }
            }, 5 * 20);
    	    } else {
    	    	p.sendMessage(ChatColor.RED + "This door is locked! You need an " + ChatColor.GRAY + Key.getItemMeta().getDisplayName() + ChatColor.RED + " to enter!");
    	    }
		}
		}
		}
	}
	
	public static void rightClickDoor(Player p, Block b, Action a) {   
			// GLOOMWOOD
            Doors.doorMeta(Items.IronKey, 135, 75, 371, 134, 75, 371, 0, p, b, a); 
            // First Gold Mine
            Doors.doorMeta(Items.IronKey, -52, 56, 338, -51, 56, 338, 0, p, b, a); 
	        // MINES BOSS
            Doors.doorMeta(Items.StrangeIronKey, -205, 51, 390, -205, 51, 391, 1, p, b, a);
            // MINEING TOWN
            Doors.doorMeta(Items.RustedIronKey,  114, 75, 141,  115, 75, 141, 2, p, b, a);
            // Start - Mining Town
            Doors.doorMeta(Items.RustedIronKey, -131, 44, 257, -130, 44, 257, 2, p, b, a);
            // WALL BOSS
            Doors.doorMeta(Items.StrangeGoldKey, 292, 91, 69, 291, 91, 69, 3, p, b, a);
            // WALL 
            Doors.doorMeta(Items.GoldKey, 323, 75, 69, 323, 75, 70, 4, p, b, a);
            // WALL - Eastcliff 
            Doors.doorMeta(Items.GoldKey, 287, 91, 67, 287, 91, 68, 4, p, b, a);
            // ARENA - Eastcliff 
            Doors.doorMeta(Items.StrangeGoldKey, 174, 75, -25, 175, 75, -25, 9, p, b, a);
            // ARENA WALL - Eastcliff
            Doors.doorMeta(Items.GoldKey, 121, 84, -37, 121, 84, -38, 4, p, b, a);
            // Mithril Mine One
            Doors.doorMeta(Items.GoldKey, -59, 25, 174, -58, 25, 174, 5, p, b, a);
            // Eastcliff - Mithril Mine One
            Doors.doorMeta(Items.GoldKey, -103, 29, 127, -104, 29, 127, 5, p, b, a);
            // CITY GATE
            Doors.doorMeta(Items.CityKey, 224, 75, -119, 224, 75, -118, 6, p, b, a);
            // Adamantite Mine One
            Doors.doorMeta(Items.OldDiamondKey, 148, 29, -227, 147, 29, -227, 7, p, b, a);
            // Lake - Desert Gate
            Doors.doorMeta(Items.DiamondKey, 29, 75, -379, 30, 75, -379, 8, p, b, a);
	}
}