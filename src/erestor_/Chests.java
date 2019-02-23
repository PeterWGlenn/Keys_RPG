package erestor_;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Chests {
	
	// Create Chest Item
	public static void createChestItem(ItemStack item, int percent, int amountMin, int amountMax, Inventory inventory) {
		if(percent >= Main.getRandom(100, 1)) {
			int itemAmount = Main.getRandom(amountMax, amountMin);
			ItemStack i = item.clone();
			i.setAmount(itemAmount);
			int slot = Main.getRandom(26, 0);
			if(inventory.getItem(slot) == null) {
			inventory.setItem(slot, i);		
			}
		}
	}
	
	// Chest Inventory
	public static Inventory ChestInventory;
	public static void openChestInventory(Player p, String id){
		ChestInventory = Bukkit.createInventory(null, 27, ChatColor.DARK_GRAY + "Chest"); 
			
	/////////////////////////////////////////////////////////////////// C H E S T    I T E M S //////////////////////////////////////////////////////////////////////
    if(id == "pyramid") {
	    Chests.createChestItem(Items.createGoldBagItem(Material.INK_SAC, "" + Main.getRandom(10000, 500)), 75, 1, 1, ChestInventory);
    	Chests.createChestItem(Items.Emerald,              50, 1, 16, ChestInventory);
    	Chests.createChestItem(Items.Sapphire,             50, 1, 16, ChestInventory);
    	Chests.createChestItem(Items.Ruby,                 50, 1, 16, ChestInventory);
	    Chests.createChestItem(Items.AdamantiteOre,        5, 5, 40, ChestInventory);
	    Chests.createChestItem(Items.AdamantiteIngot,      1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.IronIngot,            30, 10, 64, ChestInventory);
	    Chests.createChestItem(Items.GoldOre,              30, 10, 48, ChestInventory);
	    Chests.createChestItem(Items.GoldIngot,            15, 1, 5, ChestInventory);
	    Chests.createChestItem(Items.DiamondOre,           30, 5, 24, ChestInventory);
	    Chests.createChestItem(Items.Diamond,              15, 1, 3, ChestInventory);
	    Chests.createChestItem(Items.GoldHelmet,           2, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.GoldHelmet,           2, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.GoldChestplate,       2, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.GoldLeggings,         2, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.GoldBoots,            2, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.GoldSword,            2, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.GoldKnife,            2, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.GoldBattleaxe,        2, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.GoldPickaxe,          2, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.DiamondHelmet,        1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.DiamondHelmet,        1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.DiamondChestplate,    1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.DiamondLeggings,      1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.DiamondBoots,         1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.DiamondSword,         1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.DiamondKnife,         1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.DiamondBattleaxe,     1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.DiamondPickaxe,       1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.MithrilHelmet,        1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.MithrilHelmet,        1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.MithrilChestplate,    1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.MithrilLeggings,      1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.MithrilBoots,         1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.MithrilSword,         1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.MithrilKnife,         1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.MithrilBattleaxe,     1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.MithrilPickaxe,       1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.StrangeGoldKey,       1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.GoldKey,              1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.OldDiamondKey,        1, 1, 1, ChestInventory);
	    
    } else if (id == "minesGeneral") {
    	Chests.createChestItem(Items.createGoldBagItem(Material.INK_SAC, "" + Main.getRandom(500, 1)), 75, 1, 1, ChestInventory);
    	Chests.createChestItem(Items.Coal,              30, 1, 32, ChestInventory);
 	    Chests.createChestItem(Items.IronOre,           30, 1, 16, ChestInventory);
 	    Chests.createChestItem(Items.IronIngot,         30, 1, 5, ChestInventory);
    	Chests.createChestItem(Items.Stick,             30, 1, 5, ChestInventory);
 	    Chests.createChestItem(Items.Wood,              30, 1, 5, ChestInventory);
	    Chests.createChestItem(Items.WoodHelmet,        10, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.WoodHelmet,        10, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.WoodChestplate,    10, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.WoodLeggings,      10, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.WoodBoots,         10, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.WoodSword,         10, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.WoodKnife,         10, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.WoodBattleaxe,     10, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.WoodShield,        10, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.WoodPickaxe,       10, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.StoneSword,        5, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.StoneKnife,        5, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.StoneBattleaxe,    5, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.StoneShield,       5, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.StonePickaxe,      5, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.IronHelmet,        1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.IronHelmet,        1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.IronChestplate,    1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.IronLeggings,      1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.IronBoots,         1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.IronSword,         1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.IronKnife,         1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.IronBattleaxe,     1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.IronShield,        1, 1, 1, ChestInventory);
	    Chests.createChestItem(Items.IronPickaxe,       1, 1, 1, ChestInventory);
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    } else {
		Chests.createChestItem(Items.createGoldBagItem(Material.INK_SAC, "" + Main.getRandom(100, 1)), 100, 1, 1, ChestInventory);	
		}

	p.openInventory(ChestInventory);				    
	}
	
	@SuppressWarnings("deprecation")
	public static void OpenChestMethod(PlayerInteractEvent e, Player p, Block b, Material blockType, int blockTypeData, int time, String id) {		
	    if(p.getGameMode().equals(GameMode.ADVENTURE)){   	 
		if (b.getType().equals(Material.TRAPPED_CHEST) && b.getRelative(BlockFace.DOWN).getType().equals(blockType) && b.getRelative(BlockFace.DOWN).getData() == blockTypeData) {				
	       		 
	       		Chests.openChestInventory(p, id);       		
	       		
	       		p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.CHEST);
	            b.setType(Material.AIR);
	            
	            // Chest Spawns
	            Spawns.chestSpawns(p, id, 100, 1, 2);	            
	            
	            e.setCancelled(true);
	            
	            Mining.unfinishedTasks++;
	            BlockListing listing = new BlockListing(Material.TRAPPED_CHEST,b);
	            MineLog.MineList.add(listing);
	       		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
	            public void run() {
	            	if(MineLog.MineList.contains(listing)){
	            	b.setType(Material.TRAPPED_CHEST);
	            	p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.CHEST);
	            	MineLog.MineList.remove(listing);
	            	Mining.unfinishedTasks--;
	            	}
	            }
	            }, time * 20);
	       	}	
	    }
	}
	
	// OpenChest
	public static void OpenChest(PlayerInteractEvent e, Player p, Block b, Action a) {
		if (a == Action.RIGHT_CLICK_BLOCK){
		
			// General Mines
			Chests.OpenChestMethod(e, p, b, Material.STONE, 0, 60 * 5, "minesGeneral");
			// Pyramid
			Chests.OpenChestMethod(e, p, b, Material.STONE, 1, 5, "pyramid");
			
		}
	}	
}