package erestor_;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Loop {
	
	public static void loop() {
	Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(JavaPlugin.getPlugin(Main.class), new Runnable() {
        public void run() {
        	// Players
        	for(Player p : Bukkit.getOnlinePlayers()) {
        		if(p.getHealth() > 0) {
        		PlayerManager.manaTracker(p);
        		PlayerManager.manaDegrade(p);
        		PlayerManager.jailedPlayersProtect(p);
        		ProtDurability.protDurability(p);
        		PlayerManager.divingHelmet(p);
        		}
        	}
        	// Arena Reset
        	//Arena.arenaReset();
        	// Torches 
        	Mining.forceGhostTorchBreak();
        }
	}, 1, 40 /*This one*/);
	}
}