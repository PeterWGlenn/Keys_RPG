package erestor_;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

@SuppressWarnings("deprecation")
public class ProtDurability {
	
	//protDurability
	public static void protDurability(Entity a){
		//Weapon
		if(a instanceof Player) {
		ItemStack item = ((Player) a).getInventory().getItemInMainHand();
		
		if(!item.getType().equals(Material.AIR) && item.getItemMeta().hasDisplayName()) {
		String itemName = item.getItemMeta().getDisplayName();
		if(itemName.contains("Mithril") && (itemName.contains("Pickaxe") || itemName.contains("Sword") || itemName.contains("Knife") || itemName.contains("Battleaxe"))) {item.setDurability((short) Val.mithrilDur);}
		if(itemName.contains("Adamantite") && (itemName.contains("Pickaxe") || itemName.contains("Sword") || itemName.contains("Knife") || itemName.contains("Battleaxe"))) {item.setDurability((short) Val.adamDur);}
		if(itemName.contains("Void") && (itemName.contains("Pickaxe") || itemName.contains("Sword") || itemName.contains("Knife") || itemName.contains("Battleaxe"))) {item.setDurability((short) Val.voidDur);}
		}
		}	
	}
	
	//protIllegalFuntionBlocks
	public static void protIllegalFuntionBlocks(PlayerInteractEvent event) {
	
		// Right Clicks
		if(event.getPlayer().getGameMode().equals(GameMode.ADVENTURE) && event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
		Material m = event.getClickedBlock().getType();
		if(m.equals(Material.BREWING_STAND) || m.equals(Material.ANVIL) || m.equals(Material.CHEST) || m.equals(Material.OAK_DOOR) ||
				m.equals(Material.OAK_FENCE_GATE) || m.equals(Material.ACACIA_FENCE_GATE) || m.equals(Material.BIRCH_FENCE_GATE) || m.equals(Material.SPRUCE_FENCE_GATE) || 
				m.equals(Material.DARK_OAK_FENCE_GATE) || m.equals(Material.JUNGLE_FENCE_GATE) 
				|| m.equals(Material.LEVER) || m.equals(Material.BEACON) || m.equals(Material.ITEM_FRAME)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "This cannot be interacted with.");
		}
		if(m.equals(Material.CRAFTING_TABLE)) {
			event.setCancelled(true);
			event.getPlayer().openWorkbench(null, true);
		}
		if(m.equals(Material.FURNACE)) {
			event.setCancelled(true);
			Crafting.openFurnaceGUI(event.getPlayer());
		}
		if(m.equals(Material.ENCHANTING_TABLE)) {
		    Enchanting.openEnInv(event.getPlayer());
			event.setCancelled(true);
		}
		}
	
		// Left Clicks
		if(event.getPlayer().getGameMode().equals(GameMode.ADVENTURE) && event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
		Material m = event.getClickedBlock().getType();
		if(m.equals(Material.PAINTING) || m.equals(Material.ITEM_FRAME)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "You cannot break that!");
		}
	}
	}
}