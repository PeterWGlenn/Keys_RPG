package erestor_;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class Abilities {
	
	static ArrayList<Player> lifeSteal = new ArrayList<Player>();
	
	//Use Ability
	public static void useAbility(Player p, Action a) {
		if(p.getHealth() > 0) {
			if(!(p.getInventory().getItemInOffHand().getType().equals(Material.AIR))) {
			if(a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
			String heldItemName = p.getInventory().getItemInOffHand().getItemMeta().getDisplayName();
			if (PlayerManager.getMana(p) == 1000 && (heldItemName.contains("Sword") || heldItemName.contains("Knife") || heldItemName.contains("Battleaxe"))){
			PlayerManager.removeMana(p, 1000);
			
			int dmgMul = 0;
			
			if(heldItemName.contains("Wood")) {
			for (int i = 0; i < 4; i++) { dmgMul++; }
			}
			if(heldItemName.contains("Stone")) {
			for (int i = 0; i < 5; i++) { dmgMul++; }
			}
			if(heldItemName.contains("Iron")) {
			for (int i = 0; i < 6; i++) { dmgMul++; }
			}
			if(heldItemName.contains("Gold")) {
			for (int i = 0; i < 7; i++) { dmgMul++; }
			}
			if(heldItemName.contains("Diamond")) {
			for (int i = 0; i < 8; i++) { dmgMul++; }
			}
			if(heldItemName.contains("Mithril")) {
			for (int i = 0; i < 12; i++) { dmgMul++; }
			}
			if(heldItemName.contains("Adamantite")) {
			for (int i = 0; i < 16; i++) { dmgMul++; }
			}
			if(heldItemName.contains("Void")) {
			for (int i = 0; i < 25; i++) { dmgMul++; }
			}
			
			String itemName = p.getInventory().getItem(35).getItemMeta().getDisplayName();
			
			// Strength Boost Ability
			if(itemName.equals(Items.strengthBoostAbility.getItemMeta().getDisplayName())) {
			p.sendMessage(ChatColor.AQUA + "You used your " + ChatColor.RESET + "Strength Boost" + ChatColor.AQUA + " ablilty!");
			p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, (((dmgMul/2) + 2) * 20), 0));
			p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 10, 1);
			}
			// Explode Ability
			if(itemName.equals(Items.explodeAbility.getItemMeta().getDisplayName())) {
			Bukkit.getServer().getWorld("world").createExplosion(p.getLocation(), 0.0F, false);
			p.sendMessage(ChatColor.AQUA + "You used your " + ChatColor.RESET + "Explode" + ChatColor.AQUA + " ablilty!");
			for(Entity e : p.getNearbyEntities(8, 8, 8) ){
				if(!Groups.isSameGroup(p, e) && e instanceof Damageable && !(e instanceof Villager)) {
				Bukkit.getServer().getWorld("world").createExplosion(e.getLocation(), 0.0F, false);
				double distance = p.getLocation().distance(e.getLocation());
				((Damageable) e).damage(dmgMul/distance);	
				Vector mainVec = e.getLocation().toVector().subtract(p.getLocation().toVector());
		    	Vector trueVec = new Vector(mainVec.getX(), mainVec.getY() + 0.8, mainVec.getZ());
				e.setVelocity(trueVec.multiply(0.8));
				}
			}
			}
			// Earthquake Ability
			if(itemName.equals(Items.earthquakeAbility.getItemMeta().getDisplayName())) {
			p.sendMessage(ChatColor.AQUA + "You used your " + ChatColor.RESET + "Earthquake" + ChatColor.AQUA + " ablilty!");
			p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 10, 1);
			for(Entity e : p.getNearbyEntities(5, 5, 5) ){
				if(!Groups.isSameGroup(p, e) && e instanceof Damageable && !(e instanceof Villager)) {
				((Damageable) e).damage(dmgMul - 3);	
				Vector mainVec = e.getVelocity();
		    	Vector trueVec = new Vector(mainVec.getX(), mainVec.getY() + 1.2, mainVec.getZ());
				e.setVelocity(trueVec);
				}
			}
			}
			// Lightning Ability
			if(itemName.equals(Items.lightningAbility.getItemMeta().getDisplayName())) {
			p.sendMessage(ChatColor.AQUA + "You used your " + ChatColor.RESET + "Lightning Strike" + ChatColor.AQUA + " ablilty!");
			for(Entity e : p.getNearbyEntities(5, 5, 5) ){
				if(!Groups.isSameGroup(p, e) && e instanceof Damageable && !(e instanceof Villager)) {
				((Damageable) e).damage(dmgMul);	
				Bukkit.getWorld("world").strikeLightningEffect(e.getLocation());
				}
			}
			}
			// Mana Shield Ability
			if(itemName.equals(Items.manaShieldAbility.getItemMeta().getDisplayName())) {
			p.sendMessage(ChatColor.AQUA + "You used your " + ChatColor.RESET + "Mana Shield" + ChatColor.AQUA + " ablilty!");
			p.removePotionEffect(PotionEffectType.ABSORPTION);
			p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, (dmgMul * 20) * 2, 4));
			p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 10, 1);
       	    p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.IRON_BLOCK);
			}
			// Heal Ability
			if(itemName.equals(Items.healAbility.getItemMeta().getDisplayName())) {
			p.sendMessage(ChatColor.AQUA + "You used your " + ChatColor.RESET + "Heal" + ChatColor.AQUA + " ablilty!");
			double healAmount = dmgMul * 1.5;
			p.sendMessage(ChatColor.AQUA + "+" + ChatColor.BLUE + healAmount + ChatColor.AQUA + " Health");
			if(p.getHealth() + healAmount <= PlayerManager.getMaxHealth(p)) {
			p.setHealth(p.getHealth() + healAmount);
			} else {
			p.setHealth(PlayerManager.getMaxHealth(p));
			}
			}
			// Strengthen Armor Ability
			if(itemName.equals(Items.strengthenArmorAbility.getItemMeta().getDisplayName())) {
			p.sendMessage(ChatColor.AQUA + "You used your " + ChatColor.RESET + "Strengthen Armor" + ChatColor.AQUA + " ablilty!");
			p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (dmgMul * 20) * 4, 1));
			p.playSound(p.getLocation(), Sound.ENTITY_IRON_GOLEM_HURT, 10, 1);
			}
			// Life Steal Ability
			if(itemName.equals(Items.lifeStealAbility.getItemMeta().getDisplayName())) {
			p.sendMessage(ChatColor.AQUA + "You used your " + ChatColor.RESET + "Life Steal" + ChatColor.AQUA + " ablilty!");
			p.sendMessage(ChatColor.AQUA + "You can now life steal for " + ChatColor.BLUE + ((dmgMul/2) + 2) + ChatColor.AQUA + " seconds!");
            lifeSteal.add(p);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
	        public void run() {
	        lifeSteal.remove(p);
	        }
	        }, ((dmgMul/2) + 2) * 20);
			}
			// Energy Boost Ability
			if(itemName.equals(Items.energyBoostAbility.getItemMeta().getDisplayName())) {
			p.sendMessage(ChatColor.AQUA + "You used your " + ChatColor.RESET + "Energy Boost" + ChatColor.AQUA + " ablilty!");
			p.removePotionEffect(PotionEffectType.SPEED);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (dmgMul * 20) * 2, 3));
			p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 10, 1);
			}
			// Rejuvenate Ability
			if(itemName.equals(Items.rejuvenateAbility.getItemMeta().getDisplayName())) {
			p.sendMessage(ChatColor.AQUA + "You used your " + ChatColor.RESET + "Rejuvenate" + ChatColor.AQUA + " ablilty!");
			p.removePotionEffect(PotionEffectType.SPEED);
			p.removePotionEffect(PotionEffectType.JUMP);
			p.removePotionEffect(PotionEffectType.REGENERATION);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, (dmgMul * 20) * 2, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, (dmgMul * 20) * 2, 1));
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, (dmgMul * 20) * 2, 0));
			
			PlayerManager.addMana(p, 250);
			
			p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 10, 1);
			}
			// Rush Ability
			if(itemName.equals(Items.leapAbility.getItemMeta().getDisplayName())) {
			p.sendMessage(ChatColor.AQUA + "You used your " + ChatColor.RESET + "Leap" + ChatColor.AQUA + " ablilty!");

			p.setVelocity(p.getLocation().getDirection().multiply(1.5));
			
			PlayerManager.addMana(p, dmgMul * 30);
						
			p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 10, 1);
			}
		}
	}
	}
	}
	}
	
	// LifeSteal Method
	public static void lifeStealMethod(Entity a, Entity d, EntityDamageByEntityEvent e) {
		if(a instanceof Player && lifeSteal.contains(a)) {
			double damageDealt = e.getDamage();
			Player p = (Player) a;
			if(p.getHealth() + (damageDealt * 0.3) <= PlayerManager.getMaxHealth(p)) {
			p.setHealth(p.getHealth() + (damageDealt * 0.3));
			} else {
			p.setHealth(PlayerManager.getMaxHealth(p));
			}
			p.sendMessage(ChatColor.GREEN + "+" + (damageDealt * 0.3) + " Health");
		}
	}	
}