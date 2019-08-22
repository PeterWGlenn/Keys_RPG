package erestor_;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Groups {
	
	static ScoreboardManager manager = Bukkit.getScoreboardManager();
	static final Scoreboard board = manager.getMainScoreboard();
    static final Team guardiansOfAncra = board.getTeam("Guardians");
    static final Team leagueOfHunters = board.getTeam("Hunters");
    static final Team minersFoundry = board.getTeam("Miners");
    static final Team mageSociety = board.getTeam("Mages");
    static final Team eastcliffGladiators = board.getTeam("Gladiators");
    
    public static void regTeamOps() {
    	
    	// Guardians
    	guardiansOfAncra.setPrefix(ChatColor.DARK_BLUE + "");
    	guardiansOfAncra.setSuffix(ChatColor.RESET + "");
    	guardiansOfAncra.setCanSeeFriendlyInvisibles(true);
    	// Hunters
    	leagueOfHunters.setPrefix(ChatColor.DARK_RED + "");
    	leagueOfHunters.setSuffix(ChatColor.RESET + "");
    	leagueOfHunters.setCanSeeFriendlyInvisibles(true);
    	// Miners
    	minersFoundry.setPrefix(ChatColor.DARK_GRAY + "");
    	minersFoundry.setSuffix(ChatColor.RESET + "");
    	minersFoundry.setCanSeeFriendlyInvisibles(true);
    	// Mages
    	mageSociety.setPrefix(ChatColor.DARK_PURPLE + "");
    	mageSociety.setSuffix(ChatColor.RESET + "");
    	mageSociety.setCanSeeFriendlyInvisibles(true);
    	// Mages
    	eastcliffGladiators.setPrefix(ChatColor.YELLOW + "");
    	eastcliffGladiators.setSuffix(ChatColor.RESET + "");
    	eastcliffGladiators.setCanSeeFriendlyInvisibles(true);
    }
    
    
	public static void removePlayerFromTeams(Player p) {
    	 guardiansOfAncra.removePlayer(p);
		 leagueOfHunters.removePlayer(p);
		 minersFoundry.removePlayer(p);
		 mageSociety.removePlayer(p);
		 eastcliffGladiators.removePlayer(p);
    }
    
	public static void groups(Player p, Block b, Action a) {
		if (a == Action.RIGHT_CLICK_BLOCK) {
	        if (b.getType() == Material.OAK_WALL_SIGN) {
	          Sign s = (Sign) b.getState();
	          if (s.getLine(0).equalsIgnoreCase("[Group]")) {
	        	  // Guardians
	        	  if (s.getLine(1).equalsIgnoreCase("Guardians of") && s.getLine(2).equalsIgnoreCase("Ancra")) {
	        		  p.sendMessage(ChatColor.GRAY + "You have joined the " + ChatColor.DARK_BLUE + "Guardians of Ancra" + ChatColor.GRAY + "!");
	        		  p.getInventory().setItem(17, Items.createGroupItem("Guardians of Ancra", ChatColor.DARK_BLUE, "+15% Resistence", "Players"));
	        		  removePlayerFromTeams(p);
	        		  guardiansOfAncra.addPlayer(p);
	        		  p.setMaxHealth(40);
	        	  }
	        	  // Hunters
	        	  if (s.getLine(1).equalsIgnoreCase("League of") && s.getLine(2).equalsIgnoreCase("Hunters")) {
	        		  p.sendMessage(ChatColor.GRAY + "You have joined the " + ChatColor.DARK_RED + "League of Hunters" + ChatColor.GRAY + "!");
	        		  p.getInventory().setItem(17, Items.createGroupItem("League of Hunters", ChatColor.DARK_RED, "+15% Damage", "Players"));
	        		  removePlayerFromTeams(p);
	        		  leagueOfHunters.addPlayer(p);
	        		  p.setMaxHealth(40);
	        	  }
	        	  // Miners
	        	  if (s.getLine(1).equalsIgnoreCase("Miner's") && s.getLine(2).equalsIgnoreCase("Foundry")) {
	        		  p.sendMessage(ChatColor.GRAY + "You have joined the " + ChatColor.DARK_GRAY + "Miner's Foundry" + ChatColor.GRAY + "!");
	        		  p.getInventory().setItem(17, Items.createGroupItem("Miner's Foundry", ChatColor.DARK_GRAY, "+10% Health", "Everything"));
	        		  removePlayerFromTeams(p);
	        	      minersFoundry.addPlayer(p);
	        		  p.setMaxHealth(44);
	        	  }
	        	  // Mages
	        	  if (s.getLine(1).equalsIgnoreCase("Mage") && s.getLine(2).equalsIgnoreCase("Society")) {
	        		  p.sendMessage(ChatColor.GRAY + "You have joined the " + ChatColor.DARK_PURPLE + "Mage Society" + ChatColor.GRAY + "!");
	        		  p.getInventory().setItem(17, Items.createGroupItem("Mage Society", ChatColor.DARK_PURPLE, "-40% Health, +50% Mana Gain", "Everything"));
	        		  removePlayerFromTeams(p);
	        		  mageSociety.addPlayer(p);
	        		  p.setMaxHealth(24);
	        	  }
	        	  // Gladiators
	        	  if (s.getLine(1).equalsIgnoreCase("Eastcliff") && s.getLine(2).equalsIgnoreCase("Gladiators")) {
	        		  p.sendMessage(ChatColor.GRAY + "You have joined the " + ChatColor.YELLOW + "Eastcliff Gladiators" + ChatColor.GRAY + "!");
	        		  p.getInventory().setItem(17, Items.createGroupItem("Eastcliff Gladiators", ChatColor.YELLOW, "+7.5% Damage, +7.5% Resistence", "Players"));
	        		  removePlayerFromTeams(p);
	        		  eastcliffGladiators.addPlayer(p);
	        		  p.setMaxHealth(40);
	        	  } 
	          }
	       }
		}
	 }
	
	public static void groupItemProt(Player p, InventoryClickEvent e) {
		if(e.getCurrentItem() != null && !(e.getCurrentItem().getType().equals(Material.AIR))) {
		    if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
			if(e.getSlot() == 17 && p.getInventory().containsAtLeast(e.getCurrentItem(), 1)) {
				p.closeInventory();
				p.sendMessage(ChatColor.RED + "Your Group Slot cannot be changed!");
				e.setCancelled(true);
			}
		    }
		}
	}
	
	public static boolean isSameGroup(Entity a, Entity d) {
		if(a instanceof Player && d instanceof Player) {
		if((((HumanEntity) a).getInventory().getItem(17).getItemMeta().getDisplayName().equals(((HumanEntity) d).getInventory().getItem(17).getItemMeta().getDisplayName()) 
			&& !((HumanEntity) d).getInventory().getItem(17).getItemMeta().getDisplayName().contains("NONE"))
			|| (PlayerManager.jailed.contains(a.getName()) && PlayerManager.jailed.contains(d.getName()))
			|| (PlayerManager.contained.contains(a.getName()) && PlayerManager.contained.contains(d.getName()))) {
			return true;
		} else {
			return false;
		}
		} else {
			return false;
		}
	}
	
	public static void groupBonuses(Entity a, Entity d, EntityDamageByEntityEvent e) {
		if(a instanceof Player && d instanceof Player) {
			
			// antiFriendlyFire
			if(Groups.isSameGroup((Player) a, (Player )d)) {
				a.sendMessage(ChatColor.RED + "You cannot hurt players in your group!");
				e.setCancelled(true);
			} else {
			
			// Hunters
			if(((HumanEntity) a).getInventory().getItem(17).getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Group: " + ChatColor.DARK_RED + "League of Hunters")){
				double damage = e.getDamage();
				double trueDamage = damage * 0.15;
				((Damageable) d).damage(trueDamage);
			}
			// Guardians
			if(((HumanEntity) d).getInventory().getItem(17).getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Group: " + ChatColor.DARK_BLUE + "Guardians of Ancra")){
				double damage = e.getDamage();
				double healAmount = damage * 0.15;
				if((((Damageable) d).getHealth() + healAmount) < ((Damageable) d).getMaxHealth()) {
				((Damageable) d).setHealth(((Damageable) d).getHealth() + healAmount);
				} else { 
					((Damageable) d).setHealth(((Damageable) d).getMaxHealth());
				}
			}
			// Mages
			if(((HumanEntity) d).getInventory().getItem(17).getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Group: " + ChatColor.DARK_PURPLE + "Mage Society")){
			    PlayerManager.addMana((Player) d, 17);	
			}
			// Gladiators Def
			if(((HumanEntity) d).getInventory().getItem(17).getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Group: " + ChatColor.YELLOW + "Eastcliff Gladiators")){
				double damage = e.getDamage();
				double healAmount = damage * 0.075;
					if((((Damageable) d).getHealth() + healAmount) < ((Damageable) d).getMaxHealth()) {
					((Damageable) d).setHealth(((Damageable) d).getHealth() + healAmount);
				} else { 
					((Damageable) d).setHealth(((Damageable) d).getMaxHealth());
				}
			}
			// Gladiators Attack
			if(((HumanEntity) a).getInventory().getItem(17).getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Group: " + ChatColor.YELLOW + "Eastcliff Gladiators")){
				double damage = e.getDamage();
				double trueDamage = damage * 0.075;
				((Damageable) d).damage(trueDamage);
			}
		}
		}
	}
}