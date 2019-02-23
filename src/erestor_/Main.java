package erestor_;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
    public void onEnable() {
	this.getServer().broadcastMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Plugin Enabled");
	
	
	// REGISTERING CLASSES
	Bukkit.getPluginManager().registerEvents(new Events(), this);
	
	// RECIPES 
	Crafting.removeRecipes();
	Crafting.addRecipes(this);
	
	// LOOP
	Loop.loop();

	// GROUP TEAMS
	Groups.regTeamOps();
	}
	
	// Get Random Method
	public static int getRandom(int max, int min) {
		Random i = new Random();
	 	int trueI = i.nextInt(max - min + 1) + min;
	 	return trueI;
	}
	
	// COMMANDS
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    	Player player = (Player) sender;
	        if (cmd.getName().equalsIgnoreCase("s") && sender instanceof Player || cmd.getName().equalsIgnoreCase("smelt") && sender instanceof Player || cmd.getName().equalsIgnoreCase("furnace") && sender instanceof Player) {
	            player.sendMessage(ChatColor.GRAY + "You have opened the" + ChatColor.DARK_GREEN + " Furnace" + ChatColor.GRAY + "!");
	            Crafting.openFurnaceGUI(player);
	            return true;
	          
	        }
	        
	        if (cmd.getName().equalsIgnoreCase("craft") && sender instanceof Player || cmd.getName().equalsIgnoreCase("c") && sender instanceof Player || cmd.getName().equalsIgnoreCase("crafting") && sender instanceof Player) {
	            player.sendMessage(ChatColor.GRAY + "You have opened the" + ChatColor.DARK_GREEN + " Crafting Table" + ChatColor.GRAY + "!");
	            player.openWorkbench(null, true);

	            return true;
	          
	        }
	        if (cmd.getName().equalsIgnoreCase("bed") && sender instanceof Player || cmd.getName().equalsIgnoreCase("b") && sender instanceof Player || cmd.getName().equalsIgnoreCase("bedtp") && sender instanceof Player) {
	        	if(!PlayerManager.jailed.contains(sender.getName()) && !PlayerManager.contained.contains(sender.getName())) {
	        	
	        	PlayerManager.bedTP(player);
	        	
	        	} else {
		        player.sendMessage(ChatColor.RED + "You cannot do this while jailed or contained!");
		        }
	            return true;
	          
	        }
	        if (cmd.getName().equalsIgnoreCase("reset") && sender instanceof Player) {
	        	if(!PlayerManager.jailed.contains(sender.getName()) && !PlayerManager.contained.contains(sender.getName())) {
	            player.sendMessage(ChatColor.RED + "You have been reset!");
	            PlayerManager.resetPlayer(player);
	        	} else {
	        	player.sendMessage(ChatColor.RED + "You cannot reset while jailed or contained!");
	        	}
	            return true;
	          
	        }
	        if (cmd.getName().equalsIgnoreCase("resetPlayer") && sender instanceof Player) {
            	if(((HumanEntity) sender).getGameMode().equals(GameMode.CREATIVE) && player.getName().contains("Erestor_")) {
	        	
            	if(args[0] != null) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
	            if(target != null) {
	            player.sendMessage(ChatColor.RED + "You have been reset!");
		        PlayerManager.resetPlayer(player);
	            } else {
	            sender.sendMessage(ChatColor.RED + "That is not a player!");
	            }
                
            	} else {
            	sender.sendMessage(ChatColor.RED + "Wrong usage.");	
            	}
            	
            	} else {
            	sender.sendMessage(ChatColor.RED + "You cannot use this command!");
            	}
            	
	            return true;
	          
	        }
	        if (cmd.getName().equalsIgnoreCase("getTaskState") && sender instanceof Player) {
	            player.sendMessage(ChatColor.RED + "This server has " + ChatColor.AQUA + Mining.unfinishedTasks + ChatColor.RED + " unfinished tasks left to complete!");
	            player.sendMessage(ChatColor.RED + "There are also " + ChatColor.AQUA + Mining.remainingGhostTorches + ChatColor.RED + " ghost torches and " + ChatColor.BLUE + Mining.unkilledGhostTorches.size() + ChatColor.RED + " unkilled ghost torches still active!");
	            //player.sendMessage(ChatColor.RED + "There are " + ChatColor.GREEN + Arena.inArenaBattle.size() + ChatColor.RED + " arena players left! (+" + Arena.arenaGhostPlayer.size() + " arena ghost players)");
	            
	            return true;
	          
	        }
            if (cmd.getName().equalsIgnoreCase("getJailedPlayers") && sender instanceof Player) {
	        	
	        	for (int i = 0; i < PlayerManager.jailed.size(); i++) {
	        	player.sendMessage(ChatColor.RED + PlayerManager.jailed.get(i) + " (jailed)");	
	        	}    
	            
	            return true;
	          
	        }
            if (cmd.getName().equalsIgnoreCase("contain") && sender instanceof Player) {
            	if(((HumanEntity) sender).getGameMode().equals(GameMode.CREATIVE)) {
	        	
            	if(args[0] != null) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
	            if(target != null) {
	            PlayerManager.contain(target);
	            } else {
	            sender.sendMessage(ChatColor.RED + "That is not a player!");
	            }
                
            	} else {
            	sender.sendMessage(ChatColor.RED + "Wrong usage.");	
            	}
            	
            	} else {
            	sender.sendMessage(ChatColor.RED + "You cannot use this command!");
            	}
            	
	            return true;
	          
	        }
            if (cmd.getName().equalsIgnoreCase("release") && sender instanceof Player) {
            	if(((HumanEntity) sender).getGameMode().equals(GameMode.CREATIVE)) {
	        	
            	if(args[0] != null) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
	            if(target != null) {
	            PlayerManager.release(target);
	            } else {
	            sender.sendMessage(ChatColor.RED + "That is not a player!");
	            }
                
            	} else {
            	sender.sendMessage(ChatColor.RED + "Wrong usage.");	
            	}
            	
            	} else {
            	sender.sendMessage(ChatColor.RED + "You cannot use this command!");
            	}
            	
	            return true;
	          
	        }
            if (cmd.getName().equalsIgnoreCase("releaseAll") && sender instanceof Player) {
            	if(((HumanEntity) sender).getGameMode().equals(GameMode.CREATIVE)) {
	        	
            	PlayerManager.releaseAll();
            	
            	} else {
            	sender.sendMessage(ChatColor.RED + "You cannot use this command!");
            	}
            	
	            return true;
	          
	        }
            if (cmd.getName().equalsIgnoreCase("jail") && sender instanceof Player) {
            	if(((HumanEntity) sender).getGameMode().equals(GameMode.CREATIVE)) {
	        	
            	if(args[0] != null) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
	            if(target != null) {
	            PlayerManager.jail(target);
	            sender.sendMessage(ChatColor.GREEN + "Jailed " + ChatColor.RED + target + ChatColor.GREEN + "!");
	            } else {
	            sender.sendMessage(ChatColor.RED + "That is not a player!");
	            }
                
            	} else {
            	sender.sendMessage(ChatColor.RED + "Wrong usage.");	
            	}
            	
            	} else {
            	sender.sendMessage(ChatColor.RED + "You cannot use this command!");
            	}
            	
	            return true;
	          
	        }
            if (cmd.getName().equalsIgnoreCase("unjail") && sender instanceof Player) {
            	if(((HumanEntity) sender).getGameMode().equals(GameMode.CREATIVE)) {
	        	
            	if(args[0] != null) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
	            if(target != null) {
	            PlayerManager.unjail(target);
	            sender.sendMessage(ChatColor.GREEN + "unjailed " + ChatColor.RED + target + ChatColor.GREEN + "!");
	            } else {
	            sender.sendMessage(ChatColor.RED + "That is not a player!");
	            }
                
            	} else {
            	sender.sendMessage(ChatColor.RED + "Wrong usage.");	
            	}
            	
            	} else {
            	sender.sendMessage(ChatColor.RED + "You cannot use this command!");
            	}
            	
	            return true;
	          
	        }
	        if (cmd.getName().equalsIgnoreCase("getGTLoc") && sender instanceof Player) {
	        	
	        	for (int i = 0; i < Mining.ghostTorches.size(); i++) {
	        	player.sendMessage(Mining.ghostTorches.get(i).getX() + ", " + Mining.ghostTorches.get(i).getY() + ", " + Mining.ghostTorches.get(i).getZ() + " (GT)");	
	        	}
	        	
	        	for (int i = 0; i < Mining.unkilledGhostTorches.size(); i++) {
		        player.sendMessage(Mining.unkilledGhostTorches.get(i).getX() + ", " + Mining.unkilledGhostTorches.get(i).getY() + ", " + Mining.unkilledGhostTorches.get(i).getZ() + " (UGT)");	
		        }	      
	            
	            return true;
	          
	        }
	        if (cmd.getName().equalsIgnoreCase("forceRemoveGhostTorches") && sender instanceof Player) {
	        	if(player.getName().contains("Erestor_") && player.getGameMode().equals(GameMode.CREATIVE)) {
	            player.sendMessage(ChatColor.RED + "Success");
	            Mining.forceGhostTorchBreak();
	        	}
	            
	            return true;
	          
	        }
	        if (cmd.getName().equalsIgnoreCase("forceEndTasks") && sender instanceof Player) {
	        	if(player.getName().contains("Erestor_") && player.getGameMode().equals(GameMode.CREATIVE)) {
	            player.sendMessage(ChatColor.RED + "Success");
	            MineLog.forceEndTasks();
	        	}
	            
	            return true;
	          
	        }
	           
	           
	        return false;
	    }
	
	@Override
	public void onDisable() {
		
		// END TASKS
		MineLog.forceEndTasks();
		
	this.getServer().broadcastMessage(ChatColor.BLUE + "" + ChatColor.BOLD + "Plugin Disabled");
	}
}