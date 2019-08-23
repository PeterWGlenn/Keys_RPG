package erestor_;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

public class Potion {

	public static void drinkPotion(Player p, PlayerItemConsumeEvent e) {
		ItemStack i = e.getItem();
		if(i.getType().equals(Material.POTION)) {
			PotionMeta pot = (PotionMeta) i.getItemMeta();
			e.setCancelled(true);
			
			for(PotionEffect pE : pot.getCustomEffects()) {
				p.addPotionEffect(pE);
			}
			p.setSaturation(p.getSaturation()+5);
			p.getInventory().removeItem(i);
			p.getInventory().addItem(Items.EmptyBottle);
		}
	}

	public static void fillBottle(Player p, Action a, Block b) {
		// If right click
		if(a.equals(Action.LEFT_CLICK_BLOCK) || a.equals(Action.LEFT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK) || a.equals(Action.RIGHT_CLICK_AIR)) {
			// If bottle
			if(p.getInventory().getItemInMainHand().getType().equals(Material.GLASS_BOTTLE)) {
				// If in water
				if(p.getLocation().getBlock().getType().equals(Material.WATER) || p.getLocation().getBlock().getType().equals(Material.WATER)) {
					p.getInventory().removeItem(Items.EmptyBottle);
					p.getInventory().addItem(Items.WaterBottle);
				}
			}
		}
	}

}
