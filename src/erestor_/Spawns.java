package erestor_;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Player;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Zombie;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Spawns {
	
	public static void spawnZombieMethod(int x, int y, int z, String name, int health, ItemStack sword, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots, PotionEffectType potOne, int ampOne, PotionEffectType potTwo, int ampTwo, boolean isBaby, boolean isVillager) {
 		
 	Block b = Bukkit.getServer().getWorld("world").getBlockAt(x, y, z);
 		
	Zombie zombie;
	if(isVillager) {
		zombie = b.getLocation().getWorld().spawn(b.getLocation(), ZombieVillager.class);
	} else {
		zombie = (Zombie) b.getLocation().getWorld().spawn(b.getLocation(), Zombie.class);
	}
	zombie.setCustomName(name);
	zombie.setCustomNameVisible(true);
	setMaxHealth(zombie,health);
	zombie.setHealth(health);
	zombie.getEquipment().setItemInMainHand(sword);
	zombie.getEquipment().setHelmet(helmet);
	zombie.getEquipment().setChestplate(chestplate);
	zombie.getEquipment().setLeggings(leggings);
	zombie.getEquipment().setBoots(boots);
	zombie.setBaby(isBaby);
	zombie.addPotionEffect(new PotionEffect(potOne, 999999, ampOne));
	zombie.addPotionEffect(new PotionEffect(potTwo, 999999, ampTwo));
}
 	
	public static void spawnZombieFromLocMethod(Location l, String name, int health, ItemStack sword, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots, PotionEffectType potOne, int ampOne, PotionEffectType potTwo, int ampTwo, boolean isBaby, boolean isVillager) {
	 		
	Zombie zombie;
	if(isVillager) {
		zombie = l.getWorld().spawn(l, ZombieVillager.class);
	} else {
		zombie = (Zombie) l.getWorld().spawn(l, Zombie.class);
	}
	zombie.setCustomName(name);
	zombie.setCustomNameVisible(true);
	setMaxHealth(zombie,health);
	zombie.setHealth(health);
	zombie.getEquipment().setItemInMainHand(sword);
	zombie.getEquipment().setHelmet(helmet);
	zombie.getEquipment().setChestplate(chestplate);
	zombie.getEquipment().setLeggings(leggings);
	zombie.getEquipment().setBoots(boots);
	zombie.setBaby(isBaby);
	zombie.addPotionEffect(new PotionEffect(potOne, 999999, ampOne));
	zombie.addPotionEffect(new PotionEffect(potTwo, 999999, ampTwo));
}
	
	public static void spawnSpiderFromLocMethod(Location l, String name, int health, PotionEffectType potOne, int ampOne, PotionEffectType potTwo, int ampTwo) {
	 		
    CaveSpider spider = (CaveSpider) l.getWorld().spawn(l, CaveSpider.class);
    spider.setCustomName(name);
    spider.setCustomNameVisible(false);
    setMaxHealth(spider,health);
    spider.setHealth(health);
    spider.addPotionEffect(new PotionEffect(potOne, 999999, ampOne));
    spider.addPotionEffect(new PotionEffect(potTwo, 999999, ampTwo));
}
	
	public static void spawnGiantSpiderFromLocMethod(Location l, String name, int health, PotionEffectType potOne, int ampOne, PotionEffectType potTwo, int ampTwo) {
 		
	Spider spider = (Spider) l.getWorld().spawn(l, Spider.class);
	spider.setCustomName(name);
	spider.setCustomNameVisible(false);
	setMaxHealth(spider,health);
	spider.setHealth(health);
	spider.addPotionEffect(new PotionEffect(potOne, 999999, ampOne));
	spider.addPotionEffect(new PotionEffect(potTwo, 999999, ampTwo));
}
	
	public static void spawnSpiderFromBlockMethod(int x, int y, int z, String name, int health, PotionEffectType potOne, int ampOne, PotionEffectType potTwo, int ampTwo, PotionEffectType potThree, int ampThree) {
 		
	Block b = Bukkit.getServer().getWorld("world").getBlockAt(x, y, z);
		
	CaveSpider spider = (CaveSpider) b.getLocation().getWorld().spawn(b.getLocation(), CaveSpider.class);
	spider.setCustomName(name);
	spider.setCustomNameVisible(false);
	setMaxHealth(spider,health);
	spider.setHealth(health);
	spider.addPotionEffect(new PotionEffect(potOne, 999999, ampOne));
	spider.addPotionEffect(new PotionEffect(potTwo, 999999, ampTwo));
	spider.addPotionEffect(new PotionEffect(potThree, 999999, ampThree));
}
		
	public static void spawnGiantSpiderFromBlockMethod(int x, int y, int z, String name, int health, PotionEffectType potOne, int ampOne, PotionEffectType potTwo, int ampTwo, PotionEffectType potThree, int ampThree) {
	 		
	Block b = Bukkit.getServer().getWorld("world").getBlockAt(x, y, z);
		
	Spider spider = (Spider) b.getLocation().getWorld().spawn(b.getLocation(), Spider.class);
	spider.setCustomName(name);
	spider.setCustomNameVisible(false);
	setMaxHealth(spider,health);
	spider.setHealth(health);
	spider.addPotionEffect(new PotionEffect(potOne, 999999, ampOne));
	spider.addPotionEffect(new PotionEffect(potTwo, 999999, ampTwo));
	spider.addPotionEffect(new PotionEffect(potThree, 999999, ampThree));
}
	
	// Guardians
	public static void spawnGuardianFromLocMethod(Location l, String name, int absorption, int regen, int resist) {
 		
	    Guardian guardian = (Guardian) l.getWorld().spawn(l, Guardian.class);
	    guardian.setCustomName(name);
	    guardian.setCustomNameVisible(true);
	    setMaxHealth(guardian,20);
	    guardian.setHealth(20);
	    guardian.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 99999, absorption));
	    guardian.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999, regen));
	    guardian.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, resist));
	}
	public static void spawnElderGuardianFromLocMethod(Location l, String name, int absorption, int regen, int resist) {
 		
	    ElderGuardian guardian = (ElderGuardian) l.getWorld().spawn(l, ElderGuardian.class);
	    guardian.setCustomName(name);
	    guardian.setCustomNameVisible(true);
	    setMaxHealth(guardian,20);
	    guardian.setHealth(20);
	    guardian.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 99999, absorption));
	    guardian.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999, regen));
	    guardian.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, resist));
	}
	
	// Silverfish
	public static void spawnSilverfishFromLocMethod(Location l, String name, int health, int regen, int resist, int strength, int speed) {
 		
	    Silverfish silverfish = (Silverfish) l.getWorld().spawn(l, Silverfish.class);
	    silverfish.setCustomName(name);
	    silverfish.setCustomNameVisible(true);
	    setMaxHealth(silverfish,health);
	    silverfish.setHealth(health);
	    silverfish.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999, regen));
	    silverfish.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, resist));
	    silverfish.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, strength));
	    silverfish.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, speed));
	}
 	
	public static void spawnSkeletonFromLocMethod(Location l, String name, int health, ItemStack sword, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots, int regen, int resist, int strength, int speed) {
	 		
	Skeleton skeleton = (Skeleton) l.getWorld().spawn(l, Skeleton.class);
	skeleton.setCustomName(name);
	skeleton.setCustomNameVisible(true);
	setMaxHealth(skeleton,health);
	skeleton.setHealth(health);
	skeleton.getEquipment().setItemInMainHand(sword);
	skeleton.getEquipment().setHelmet(helmet);
	skeleton.getEquipment().setChestplate(chestplate);
	skeleton.getEquipment().setLeggings(leggings);
	skeleton.getEquipment().setBoots(boots);
	skeleton.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999, regen));
	skeleton.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 99999, resist));
	skeleton.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 99999, strength));
	skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, speed));
}
 	
 	///////////////////////////////////////////// MINING SPAWNS ///////////////////////////////////////////////
 	public static void mineSpawns(Player p, int id, int percent, int minAmount, int maxAmount) {
    Random i = new Random();
 	int trueI = i.nextInt(100 - 1 + 1) + 1;
 	if(trueI <= percent) {
 		
 	int radius = 20;
	   Random rand = new Random();
	   boolean found = false;
	   int timesTried = 0;
	   while (!found) {
	   Location landBlock = p.getLocation().clone().add(rand.nextInt(radius * 2) - radius, 0, rand.nextInt(radius * 2) - radius);
	   Location airBlock1 = new Location(Bukkit.getServer().getWorld("world"), landBlock.getX(), landBlock.getY() + 1, landBlock.getZ());
	   Location airBlock2 = new Location(Bukkit.getServer().getWorld("world"), landBlock.getX(), landBlock.getY() + 2, landBlock.getZ()); 
	   
	   Location playerLoc = p.getLocation();
	   
	   Material lBType = landBlock.getBlock().getType();
	   Material aB1Type = airBlock1.getBlock().getType();
	   Material aB2Type = airBlock2.getBlock().getType();
	   
	   timesTried++;
	   
	   if(timesTried >= 3000) {
	   found = true;
	   }
	   
	   if((lBType != Material.AIR && lBType != Material.LAVA && lBType != Material.CACTUS && aB1Type == Material.AIR && aB2Type == Material.AIR) && (landBlock.getY() - playerLoc.getY()) < 5) {
       found = true;
	    
	   Random a = new Random();
	   int trueA = a.nextInt(maxAmount - minAmount + 1) + minAmount;
	   
	   for (int n = 0; n < trueA; n++) {
       
       // Mining Spawns
       if(id == 1) {
    	   Spawns.spawnZombieFromLocMethod(airBlock1.add(+0.5, +0, +0.5), ChatColor.GREEN + "Undead Villager", 10, Items.WoodKnife, Items.WoodHelmet, Items.air, Items.air, Items.air, PotionEffectType.SPEED, 1, PotionEffectType.NIGHT_VISION, 0, false, true);
       }
       if(id == 2) {
    	   Spawns.spawnZombieFromLocMethod(airBlock1.add(+0.5, +0, +0.5), ChatColor.GREEN + "Undead Guard", 20, Items.StoneSword, Items.IronHelmet, Items.IronChestplate, Items.WoodLeggings, Items.WoodBoots, PotionEffectType.SPEED, 1, PotionEffectType.REGENERATION, 1, false, true);
       }
       if(id == 3) {
    	   Spawns.spawnZombieFromLocMethod(airBlock1.add(+0.5, +0, +0.5), ChatColor.GREEN + "Undead Warrior", 30, Items.DiamondBattleaxe, Items.IronHelmet, Items.GoldChestplate, Items.IronLeggings, Items.IronBoots, PotionEffectType.SPEED, 1, PotionEffectType.REGENERATION, 1, false, true);
       }
       if(id == 4) {
    	   Spawns.spawnZombieFromLocMethod(airBlock1.add(+0.5, +0, +0.5), ChatColor.GREEN + "Undead Knight", 50, Items.MithrilSword, Items.DiamondHelmet, Items.MithrilChestplate, Items.DiamondLeggings, Items.MithrilBoots, PotionEffectType.SPEED, 0, PotionEffectType.INCREASE_DAMAGE, 0, false, true);
    	   Spawns.spawnZombieFromLocMethod(airBlock1.add(+0.5, +0, +0.5), ChatColor.GREEN + "Strong Undead Warrior", 35, Items.DiamondSword, Items.IronHelmet, Items.DiamondChestplate, Items.IronLeggings, Items.IronBoots, PotionEffectType.SPEED, 1, PotionEffectType.REGENERATION, 0, false, true);
    	   Spawns.spawnZombieFromLocMethod(airBlock1.add(+0.5, +0, +0.5), ChatColor.GREEN + "Strong Undead Warrior", 35, Items.DiamondSword, Items.IronHelmet, Items.DiamondChestplate, Items.IronLeggings, Items.IronBoots, PotionEffectType.SPEED, 1, PotionEffectType.REGENERATION, 0, false, true);
       }
       if(id == 5) {
    	   Spawns.spawnZombieFromLocMethod(airBlock1.add(+0.5, +0, +0.5), ChatColor.GREEN + "Undead Elite", 120, Items.MithrilKnife, Items.MithrilHelmet, Items.MithrilChestplate, Items.MithrilLeggings, Items.MithrilBoots, PotionEffectType.SPEED, 2, PotionEffectType.INCREASE_DAMAGE, 1, true, true);    	
       }
       
       // Boss Spawns
       if(id == 1001) {
    	   Spawns.spawnGiantSpiderFromBlockMethod(158, 58, 206, ChatColor.RED + "Queen Spider", 30, PotionEffectType.SPEED, 2, PotionEffectType.INCREASE_DAMAGE, 1, PotionEffectType.REGENERATION, 2);
    	   Spawns.spawnSpiderFromBlockMethod(158, 58, 206, ChatColor.GREEN + "Spider Minion", 10, PotionEffectType.SPEED, 1, PotionEffectType.INCREASE_DAMAGE, 0, PotionEffectType.REGENERATION, 1);
    	   Spawns.spawnSpiderFromBlockMethod(158, 58, 206, ChatColor.GREEN + "Spider Minion", 10, PotionEffectType.SPEED, 1, PotionEffectType.INCREASE_DAMAGE, 0, PotionEffectType.REGENERATION, 1);
    	   Spawns.spawnSpiderFromBlockMethod(158, 58, 206, ChatColor.GREEN + "Spider Minion", 10, PotionEffectType.SPEED, 1, PotionEffectType.INCREASE_DAMAGE, 0, PotionEffectType.REGENERATION, 1);
    	   Spawns.spawnSpiderFromBlockMethod(158, 58, 206, ChatColor.GREEN + "Spider Minion", 10, PotionEffectType.SPEED, 1, PotionEffectType.INCREASE_DAMAGE, 0, PotionEffectType.REGENERATION, 1);
    	   Spawns.spawnSpiderFromBlockMethod(158, 58, 206, ChatColor.GREEN + "Spider Minion", 10, PotionEffectType.SPEED, 1, PotionEffectType.INCREASE_DAMAGE, 0, PotionEffectType.REGENERATION, 1);
    	   Spawns.spawnSpiderFromBlockMethod(158, 58, 206, ChatColor.GREEN + "Spider Minion", 10, PotionEffectType.SPEED, 1, PotionEffectType.INCREASE_DAMAGE, 0, PotionEffectType.REGENERATION, 1);
    	   Spawns.spawnSpiderFromBlockMethod(158, 58, 206, ChatColor.GREEN + "Strong Spider Minion", 20, PotionEffectType.SPEED, 2, PotionEffectType.INCREASE_DAMAGE, 0, PotionEffectType.REGENERATION, 2);
    	   Spawns.spawnSpiderFromBlockMethod(158, 58, 206, ChatColor.GREEN + "Strong Spider Minion", 20, PotionEffectType.SPEED, 2, PotionEffectType.INCREASE_DAMAGE, 0, PotionEffectType.REGENERATION, 2);
    	   Spawns.spawnSpiderFromBlockMethod(158, 58, 206, ChatColor.GREEN + "Strong Spider Minion", 20, PotionEffectType.SPEED, 2, PotionEffectType.INCREASE_DAMAGE, 0, PotionEffectType.REGENERATION, 2);
       }
	   }
	   }
	   }
	   }
 	}
 	////////////////////////////////////////////////// F O R E S T    S P A W N S ////////////////////////////////////////////////////////////////
 	public static void forestSpawns(Player p, int id, int percent) {
 	    Random i = new Random();
 	 	int trueI = i.nextInt(100 - 1 + 1) + 1;
 	 	if(trueI <= percent) {
 	 		
 	 		int radius = 10;
 		   boolean found = false;
 		   int timesTried = 0;
 		   
 		   while (!found) {
 			  Random rand = new Random();
 		   Location landBlock = p.getLocation().clone().add(rand.nextInt(radius * 2) - radius, -1, rand.nextInt(radius * 2) - radius);
 		   Location airBlock1 = new Location(Bukkit.getServer().getWorld("world"), landBlock.getX(), landBlock.getY() + 1, landBlock.getZ());
 		   
 		   Material lBType = landBlock.getBlock().getType();
 		   Material aB1Type = airBlock1.getBlock().getType();
 		   
 		  		 
 		   timesTried++;
 		   
 		   if(timesTried >= 3000) {
 		   found = true;
 		   }
 		   
 		   if(lBType != Material.AIR && aB1Type == Material.AIR && (landBlock.getY() - p.getLocation().getY() < 5)) {
 	       found = true;
 	       
 	       // Desert Spawns
 	       if(id == 1) {
 	    	  if(!airBlock1.getBlock().getBiome().equals(Biome.DESERT)) {
 	    	  Spawns.spawnSpiderFromLocMethod(airBlock1.add(+0.5, +0, +0.5), ChatColor.GREEN + "Forest Spider", 15, PotionEffectType.SPEED, 1, PotionEffectType.INCREASE_DAMAGE, 0);
 	    	  } else {
 	    	  Random randS = new Random();
 	     	  int truerandS = randS.nextInt(100 - 1 + 1) + 1;
 	     	  if(truerandS <= 17) {
 	          Spawns.spawnSkeletonFromLocMethod(airBlock1, ChatColor.GREEN + "Undead Archer", 40, Items.undeadArcherBow, Items.IronHelmet, Items.IronChestplate, Items.MithrilLeggings, Items.MithrilBoots, 1, 0, 0, 3);   	 
 	          Spawns.spawnSilverfishFromLocMethod(airBlock1, ChatColor.GREEN + "Undead Scorpion", 20, 0, 1, 2, 3);
 	    	  }
 	    	  }
 	       }
 		   }
 		   }
 		   }		   
 	 	}
 	//////////////////////////////////////////////////W A T E R    S P A W N S ////////////////////////////////////////////////////////////////
 	public static void waterSpawns(Player p, int id, int percent, int minAmount, int maxAmount) {
 		Random i = new Random();
 		int trueI = i.nextInt(100 - 1 + 1) + 1;
 		if(trueI <= percent) {

 			int radius = 10;
 			Random rand = new Random();
 			boolean found = false;
 			int timesTried = 0;

 			while (!found) {
 				Location waterBlock = p.getLocation().clone().add(rand.nextInt(radius * 2) - radius, 0, rand.nextInt(radius * 2) - radius);

 				Material wBType = waterBlock.getBlock().getType();

 				timesTried++;

 				if(timesTried >= 3000) {
 					found = true;
 				}

 				if(wBType == Material.WATER) {
 					found = true;

 				Random a = new Random();
 				int trueA = a.nextInt(maxAmount - minAmount + 1) + minAmount;
 				    
 				for (int n = 0; n < trueA; n++) {
 			       // Mining Spawns
 			       if(id == 1) {
 			    	   Spawns.spawnGuardianFromLocMethod(waterBlock, ChatColor.BLUE + "Minor Guardian", 0, 0, 0);
 			       }
 			       if(id == 2) {
 			    	   Spawns.spawnGuardianFromLocMethod(waterBlock, ChatColor.BLUE + "Guardian", 1, 1, 0);
 			    	   Spawns.spawnGuardianFromLocMethod(waterBlock, ChatColor.BLUE + "Guardian", 1, 1, 0);
 			       }
 			       if(id == 3) {
 			    	   Spawns.spawnGuardianFromLocMethod(waterBlock, ChatColor.BLUE + "Greater Guardian", 3, 1, 1);
 			    	   Spawns.spawnGuardianFromLocMethod(waterBlock, ChatColor.BLUE + "Greater Guardian", 3, 1, 1);
 			       }
 			       if(id == 4) {
 			    	   Spawns.spawnGuardianFromLocMethod(waterBlock, ChatColor.BLUE + "Strong Guardian", 5, 1, 1);
 			    	   Spawns.spawnGuardianFromLocMethod(waterBlock, ChatColor.BLUE + "Strong Guardian", 5, 1, 1);
 			    	   Spawns.spawnGuardianFromLocMethod(waterBlock, ChatColor.BLUE + "Strong Guardian", 5, 1, 1);
 			       }
 			       if(id == 5) {
 			    	   Spawns.spawnGuardianFromLocMethod(waterBlock, ChatColor.BLUE + "Guardian Elite", 15, 0, 2);
 			    	   Spawns.spawnGuardianFromLocMethod(waterBlock, ChatColor.BLUE + "Guardian Elite", 15, 0, 2);
 			       }
 					// Lake spawns
 					if(id == 101) {
 						Spawns.spawnGuardianFromLocMethod(waterBlock, ChatColor.BLUE + "Lake Guardian", 0, 0, 0);
 					}
 			        // Boss Spawns
 			        if(id == 102) {
 			    	   Location l = Bukkit.getServer().getWorld("world").getBlockAt(153, 38, -238).getLocation();
 			    	   Spawns.spawnElderGuardianFromLocMethod(l, ChatColor.RED + "Lake Elder Guardian", 40, 2, 2); //200
 			    	   Spawns.spawnGuardianFromLocMethod(l, ChatColor.BLUE + "Strong Lake Guardian", 20, 1, 1); //70
 			    	   Spawns.spawnGuardianFromLocMethod(l, ChatColor.BLUE + "Strong Lake Guardian", 20, 1, 1);
 			    	   Spawns.spawnGuardianFromLocMethod(l, ChatColor.BLUE + "Strong Lake Guardian", 20, 1, 1);
 			    	   Spawns.spawnGuardianFromLocMethod(l, ChatColor.BLUE + "Strong Lake Guardian", 20, 1, 1);
 			    	   Spawns.waterSpawns(p, 101, 100, 8, 10);
 			        }
 				  }
 				}
 			}
 		}		   
 	}
 	
 	///////////////////////////////////////////////////////////////// C H E S T   S P A W N S ////////////////////////////////////////////////////////////////////////
	public static void chestSpawns(Player p, String id, int percent, int minAmount, int maxAmount) {
		
		if(id != "minesGeneral") {
		
 		Random i = new Random();
 		
 		int trueI = i.nextInt(100 - 1 + 1) + 1;       
 		if(trueI <= percent) {
 			
 		Random a = new Random();  
 		int trueA = a.nextInt(maxAmount - minAmount + 1) + minAmount;
 	    for (int n = 0; n < trueA; n++) {
 	    	
 			int radius = 15;
 			boolean found = false;
 			int timesTried = 0;

 			while (!found) {
 				Random rand = new Random();
 				Location baseBlock = p.getLocation().clone().add(rand.nextInt(radius * 2) - radius, -1, rand.nextInt(radius * 2) - radius);
 				Location topBlock = baseBlock.getBlock().getRelative(BlockFace.UP).getLocation();

 				Material bBType = baseBlock.getBlock().getType();
 				Material tBType = topBlock.getBlock().getType();

 				timesTried++;

 				if(timesTried >= 5000) {
 					found = true;
 				}

 				if(bBType == Material.GRANITE && tBType == Material.AIR) {
 					found = true;

 					// Spawns
 					if(id == "pyramid") {
 						Spawns.spawnSkeletonFromLocMethod(topBlock, ChatColor.GREEN + "Pyramid Archer", 70, Items.undeadArcherBow, Items.GoldHelmet, Items.GoldChestplate, Items.AdamantiteLeggings, Items.AdamantiteBoots, 1, 1, 0, 3);   	 
 						Spawns.spawnSilverfishFromLocMethod(topBlock, ChatColor.GREEN + "Pyramid Scorpion", 40, 0, 1, 2, 3);
 					}
 				}
 				}
 			}
 		}		  
		}
 	}
 	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	// util
	public static void setMaxHealth(Damageable e, double h) {
		((Attributable) e).getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(h);
	}
}
































