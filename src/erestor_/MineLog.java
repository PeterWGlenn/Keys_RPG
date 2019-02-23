package erestor_;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class MineLog {

	public static ArrayList<BlockListing> MineList = new ArrayList<BlockListing>();
	
	public static void forceEndTasks() {
		int count = 0;
		for(BlockListing l : MineList) {
			
			l.getBlock().setType(l.getMaterial());
			Mining.unfinishedTasks--;
			count++;
		}
		MineList.clear();
		Bukkit.getServer().broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + count + ChatColor.BLUE + " Tasks Ended");
	}
	
}

class BlockListing {
	
	private Material material;
	private Block block;
	
	public BlockListing(Material material, Block block) {
		this.material = material;
		this.block = block;
	}
	
	public Block getBlock() {
		return block;
	}
	public Material getMaterial() {
		return material;
	}
}