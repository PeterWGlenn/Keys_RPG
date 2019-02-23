package erestor_;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class KeepInventory {
	
	// Player KeepInv
		public static void playerKeepInv(Player p, PlayerDeathEvent e) {

			if(p.getBedSpawnLocation() != null) {
				p.teleport(p.getBedSpawnLocation());
			} else {
				p.teleport(Bukkit.getServer().getWorld("world").getBlockAt(-43, 75, 348).getLocation());		
			}
			
			// Removing Items
			Location l = p.getLocation();
			
			KeepInventory.removeItem(9, p, l);
			KeepInventory.removeItem(10, p, l);
			KeepInventory.removeItem(11, p, l);
			KeepInventory.removeItem(12, p, l);
			KeepInventory.removeItem(13, p, l);
			KeepInventory.removeItem(14, p, l);
			KeepInventory.removeItem(15, p, l);
			KeepInventory.removeItem(16, p, l);
			
			KeepInventory.removeItem(18, p, l);
			KeepInventory.removeItem(19, p, l);
			KeepInventory.removeItem(20, p, l);
			KeepInventory.removeItem(21, p, l);
			KeepInventory.removeItem(22, p, l);
			KeepInventory.removeItem(23, p, l);
			KeepInventory.removeItem(24, p, l);
			KeepInventory.removeItem(25, p, l);
			
			KeepInventory.removeItem(27, p, l);
			KeepInventory.removeItem(28, p, l);
			KeepInventory.removeItem(29, p, l);
			KeepInventory.removeItem(30, p, l);
			KeepInventory.removeItem(31, p, l);
			KeepInventory.removeItem(32, p, l);
			KeepInventory.removeItem(33, p, l);
			KeepInventory.removeItem(34, p, l);
			
			
			// LEVELS
			if(!(p.getLevel() == 0)) {
			int playerLevel = p.getLevel();
			int lostLevels = (int) (playerLevel * 0.25);
			
			ItemStack BagOfLostCoins = Items.createGoldBagItem(Material.INK_SAC, "" + lostLevels);
			p.getWorld().dropItem(p.getLocation(), BagOfLostCoins);
			
			p.sendMessage(ChatColor.RED + "-" + lostLevels + ChatColor.RED + " coins");
			p.giveExpLevels(-lostLevels);
			}		
    }
		
	// KeepInv Method RemoveItem
	public static void removeItem(int slot, Player p, Location l) {
		if(!(p.getInventory().getItem(slot) == null)) {
			Bukkit.getServer().getWorld("world").dropItem(l, p.getInventory().getItem(slot));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
			public void run() {
			p.getInventory().setItem(slot, null);
			}
			}, 1);
		}
	}
}