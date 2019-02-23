package erestor_;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Crafting {
	
    ////////////////////////////////////////////////////////////////////B O O K /////////////////////////////////////////////////////////////////////////////
	public static void knowledgeBook(Player p, InventoryClickEvent e) {
		if(e.getCurrentItem() != null && e.getCurrentItem().getType().equals(Material.KNOWLEDGE_BOOK)) {
			p.openWorkbench(null, true);
		}
	}
	
    ////////////////////////////////////////////////////////////////////F U R N A C E /////////////////////////////////////////////////////////////////////////////
	public static Inventory furnaceInv;
    public static void openFurnaceGUI(Player player){
    	furnaceInv = Bukkit.createInventory(null, 9, ChatColor.DARK_GRAY + "Click An Ore To Smelt It!"); 
    	
    	ItemStack Stone = Items.createItem(Material.COBBLESTONE, "" + ChatColor.GRAY + ChatColor.BOLD + "Cobblestone", "", 0, 1, (short) 0);
    	ItemMeta StoneM = Stone.getItemMeta();
    	StoneM.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Click to smelt!", ChatColor.GOLD + "Cost: ", ChatColor.GRAY + "8 Cobblestone", ChatColor.GRAY + "8 Coal", ChatColor.GOLD + "Produces:", ChatColor.GRAY + "Stone [x1]"));
    	Stone.setItemMeta(StoneM);
        furnaceInv.setItem(0, (ItemStack) (Stone));
    	
        ItemStack IronOre = Items.createItem(Material.IRON_ORE, "" + ChatColor.GRAY + ChatColor.BOLD + "Iron Ore", "", 0, 1, (short) 0);
        ItemMeta IronOreM = IronOre.getItemMeta();
        IronOreM.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Click to smelt!", ChatColor.GOLD + "Cost: ", ChatColor.GRAY + "8 Iron Ore", ChatColor.GRAY + "16 Coal", ChatColor.GOLD + "Produces:", ChatColor.GRAY + "Iron Ingot [x1]"));
        IronOre.setItemMeta(IronOreM);
        furnaceInv.setItem(1, (ItemStack) (IronOre));
	     
        ItemStack GoldOre = Items.createItem(Material.GOLD_ORE, "" + ChatColor.GOLD + ChatColor.BOLD + "Gold Ore", "", 0, 1, (short) 0);
        ItemMeta GoldOreM = GoldOre.getItemMeta();
        GoldOreM.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Click to smelt!", ChatColor.GOLD + "Cost: ", ChatColor.GRAY + "12 Gold Ore", ChatColor.GRAY + "24 Coal", ChatColor.GOLD + "Produces:", ChatColor.GOLD + "Gold Ingot [x1]"));
        GoldOre.setItemMeta(GoldOreM);
        furnaceInv.setItem(2, (ItemStack) (GoldOre));
	     
        ItemStack DiamondOre = Items.createItem(Material.DIAMOND_ORE, "" + ChatColor.AQUA + ChatColor.BOLD + "Diamond Ore", "", 0, 1, (short) 0);
        ItemMeta DiamondOreM = DiamondOre.getItemMeta();
        DiamondOreM.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Click to smelt!", ChatColor.GOLD + "Cost: ", ChatColor.GRAY + "32 Diamond Ore", ChatColor.GRAY + "40 Coal", ChatColor.GOLD + "Produces:", ChatColor.AQUA + "Diamond [x1]"));
        DiamondOre.setItemMeta(DiamondOreM);
        furnaceInv.setItem(3, (ItemStack) (DiamondOre));
	     
        ItemStack MithrilOre = Items.createItem(Material.TERRACOTTA, "" + ChatColor.DARK_AQUA + ChatColor.BOLD + "Mithril Ore", "", 0, 1, (short) 2);
        ItemMeta MithrilOreM = MithrilOre.getItemMeta();
        MithrilOreM.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Click to smelt!", ChatColor.GOLD + "Cost: ", ChatColor.GRAY + "64 Mithril Ore", ChatColor.GRAY + "64 Coal", ChatColor.GOLD + "Produces:", ChatColor.DARK_AQUA + "Mithril Ingot [x1]"));
        MithrilOre.setItemMeta(MithrilOreM);
        furnaceInv.setItem(4, (ItemStack) (MithrilOre));
	     
        ItemStack AdamantiteOre = Items.createItem(Material.TERRACOTTA, "" + ChatColor.DARK_RED + ChatColor.BOLD + "Adamantite Ore", "", 0, 1, (short) 3);
        ItemMeta AdamantiteOreM = AdamantiteOre.getItemMeta();
        AdamantiteOreM.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Click to smelt!", ChatColor.GOLD + "Cost: ", ChatColor.GRAY + "128 Adamantite Ore", ChatColor.GRAY + "24 Magma", ChatColor.GOLD + "Produces:", ChatColor.DARK_RED + "Adamantite Ingot [x1]"));
        AdamantiteOre.setItemMeta(AdamantiteOreM);
        furnaceInv.setItem(5, (ItemStack) (AdamantiteOre));
            
        ItemStack VoidOre = Items.createItem(Material.TERRACOTTA, "" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "Void Ore", "", 0, 1, (short) 4);
        ItemMeta VoidOreM = VoidOre.getItemMeta();
        VoidOreM.setLore(Arrays.asList(ChatColor.DARK_PURPLE + "Click to smelt!", ChatColor.GOLD + "Cost: ", ChatColor.GRAY + "512 Void Ore", ChatColor.GRAY + "48 Magma", ChatColor.GOLD + "Produces:", ChatColor.DARK_PURPLE + "Void Gem [x1]"));
        VoidOre.setItemMeta(VoidOreM);
        furnaceInv.setItem(6, (ItemStack) (VoidOre));
	   
	
	    player.openInventory(furnaceInv);
	}
    
    @SuppressWarnings("deprecation")
	public static void furnaceInvHandMethod(Player p, InventoryClickEvent e, Material firstMat, byte firstMatData, Material secondMat, ItemStack firstItem, ItemStack secondItem, ItemStack result, int itemCostOne, int itemCostTwo) {
    	if(e.getCurrentItem().getType() == firstMat && e.getCurrentItem().getDurability() == firstMatData){
            if(p.getInventory().contains(firstMat, itemCostOne) && p.getInventory().contains(secondMat, itemCostTwo)) {
       	          
            if(p.getInventory().firstEmpty() == -1) {
            p.sendMessage(ChatColor.RED + "Your inventory is full so your item was dropped on the ground!");
            p.getWorld().dropItem(p.getLocation(), result);
            } else {
            p.getInventory().addItem(result);
            }
            
            for (int i = 0; i < itemCostOne; i++) { p.getInventory().removeItem(firstItem); }
            for (int i = 0; i < itemCostTwo; i++) { p.getInventory().removeItem(secondItem); }
            
            p.playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 10, 1);     
     	    }
     	    else {
     	    p.sendMessage(ChatColor.RED + "You need more materials to do that!");
     	    }
            }
    }
    
    public static void furnaceInvHandler(Player p, InventoryClickEvent e) {
    	if(e.getInventory().getTitle().contains("Click An Ore To Smelt It!")){
            e.setCancelled(true); 

            if(e.getCurrentItem() == null){
                return;
            }
            //Stone
            Crafting.furnaceInvHandMethod(p, e, Material.COBBLESTONE, (byte) 0, Material.COAL, Items.CobbleStone, Items.Coal, Items.Stone, 8, 8);
            //Iron
            Crafting.furnaceInvHandMethod(p, e, Material.IRON_ORE, (byte) 0, Material.COAL, Items.IronOre, Items.Coal, Items.IronIngot, 8, 16);
            //Gold
            Crafting.furnaceInvHandMethod(p, e, Material.GOLD_ORE, (byte) 0, Material.COAL, Items.GoldOre, Items.Coal, Items.GoldIngot, 12, 24);
            //Diamond
            Crafting.furnaceInvHandMethod(p, e, Material.DIAMOND_ORE, (byte) 0, Material.COAL, Items.DiamondOre, Items.Coal, Items.Diamond, 32, 40);
            //Mithril
            Crafting.furnaceInvHandMethod(p, e, Material.TERRACOTTA, (byte) 2, Material.COAL, Items.MithrilOre, Items.Coal, Items.MithrilIngot, 64, 64);
            //Adamantite
            Crafting.furnaceInvHandMethod(p, e, Material.TERRACOTTA, (byte) 3, Material.MAGMA_BLOCK, Items.AdamantiteOre, Items.Magma, Items.AdamantiteIngot, 128, 24);
            //Void
            Crafting.furnaceInvHandMethod(p, e, Material.TERRACOTTA, (byte) 4, Material.MAGMA_BLOCK, Items.VoidOre, Items.Magma, Items.VoidGem, 512, 48);
    	}		
            
    }
	
	//////////////////////////////////////////////////////////////////// R E M O V E   I T E M S /////////////////////////////////////////////////////////////////////////////

	public static void removeRecipes() {
		Bukkit.getServer().clearRecipes();
	}
	
	@SuppressWarnings("deprecation")
	public static void addRecipes(Main main) {	
	/////////////////////////////////////////////////////////////////// M A T E R I A L S ////////////////////////////////////////////////////////////////////////////////////////
	// Wooden Planks
			NamespacedKey woodKey = new NamespacedKey(main,"Wood");
			ShapedRecipe WoodPlanksR = new ShapedRecipe(woodKey,Items.Wood).shape("111","111","111").setIngredient('1', Material.STICK);
	 	    Bukkit.getServer().addRecipe(WoodPlanksR);	
	 	    
	//////////////////////////////////////////////////////////////////////// M I S C /////////////////////////////////////////////////////////////////////////////////////////////
	// Torches
	 	   NamespacedKey torchKey = new NamespacedKey(main,"Torch");
	 	   ShapelessRecipe TorchR = new ShapelessRecipe(torchKey,Items.torch).addIngredient(1, Material.STICK).addIngredient(1, Material.COAL);
	 	   Bukkit.getServer().addRecipe(TorchR);
	
    /////////////////////////////////////////////////////////////////// W O O D ////////////////////////////////////////////////////////////////////////////////////////
	    // Wood Sword
	 	NamespacedKey woodSwordKey = new NamespacedKey(main,"WoodSword");
		ShapedRecipe WoodSwordR = new ShapedRecipe(woodSwordKey,Items.WoodSword).shape(" 2 "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.OAK_WOOD);
	 	Bukkit.getServer().addRecipe(WoodSwordR);
	    // Wood Knife
	 	NamespacedKey woodKnifeKey = new NamespacedKey(main,"WoodKnife");
		ShapedRecipe WoodKnifeR = new ShapedRecipe(woodKnifeKey,Items.WoodKnife).shape("   "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.OAK_WOOD);
	 	Bukkit.getServer().addRecipe(WoodKnifeR);
	    // Wood Battleaxe
	 	NamespacedKey woodBattleaxeKey = new NamespacedKey(main,"WoodBattleaxe");
		ShapedRecipe WoodBattleaxeR = new ShapedRecipe(woodBattleaxeKey,Items.WoodBattleaxe).shape("222","212"," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.OAK_WOOD);
	 	Bukkit.getServer().addRecipe(WoodBattleaxeR);
	    // Wood Pickaxe
	 	NamespacedKey woodPickaxeKey = new NamespacedKey(main,"WoodPickaxe");
		ShapedRecipe WoodPickaxeR = new ShapedRecipe(woodPickaxeKey,Items.WoodPickaxe).shape("222"," 1 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.OAK_WOOD);
	    Bukkit.getServer().addRecipe(WoodPickaxeR);
	    // Wood Shield
	    NamespacedKey woodShieldKey = new NamespacedKey(main,"WoodShield");
		ShapedRecipe WoodShieldR = new ShapedRecipe(woodShieldKey,Items.WoodShield).shape(" 11"," 11"," 11").setIngredient('1', Material.OAK_WOOD);
	    Bukkit.getServer().addRecipe(WoodShieldR);
	    // Wood Helmet
	    NamespacedKey woodHelmetKey = new NamespacedKey(main,"WoodHelmet");
		ShapedRecipe WoodHelmetR = new ShapedRecipe(woodHelmetKey,Items.WoodHelmet).shape("111","1 1","   ").setIngredient('1', Material.OAK_WOOD);
	    Bukkit.getServer().addRecipe(WoodHelmetR);
	    // Wood Chestplate
	    NamespacedKey woodChestplateKey = new NamespacedKey(main,"WoodChestplate");
		ShapedRecipe WoodChestplateR = new ShapedRecipe(woodChestplateKey,Items.WoodChestplate).shape("1 1","111","111").setIngredient('1', Material.OAK_WOOD);
	    Bukkit.getServer().addRecipe(WoodChestplateR);
	    // Wood Leggings
	    NamespacedKey woodLeggingsKey = new NamespacedKey(main,"WoodLeggings");
		ShapedRecipe WoodLeggingsR = new ShapedRecipe(woodLeggingsKey,Items.WoodLeggings).shape("111","1 1","1 1").setIngredient('1', Material.OAK_WOOD);
	    Bukkit.getServer().addRecipe(WoodLeggingsR);
	    // Wood Boots
	    NamespacedKey woodBootsKey = new NamespacedKey(main,"WoodBoots");
		ShapedRecipe WoodBootsR = new ShapedRecipe(woodBootsKey,Items.WoodBoots).shape("   ","1 1","1 1").setIngredient('1', Material.OAK_WOOD);
	    Bukkit.getServer().addRecipe(WoodBootsR);
	/////////////////////////////////////////////////////////////////// S T O N E ////////////////////////////////////////////////////////////////////////////////////////
	    // Stone Sword
	 	NamespacedKey stoneSwordKey = new NamespacedKey(main,"StoneSword");
		ShapedRecipe StoneSwordR = new ShapedRecipe(stoneSwordKey,Items.StoneSword).shape(" 2 "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.STONE);
	 	Bukkit.getServer().addRecipe(StoneSwordR);
	    // Stone Knife
	 	NamespacedKey stoneKnifeKey = new NamespacedKey(main,"StoneKnife");
		ShapedRecipe StoneKnifeR = new ShapedRecipe(stoneKnifeKey,Items.StoneKnife).shape("   "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.STONE);
	 	Bukkit.getServer().addRecipe(StoneKnifeR);
	    // Stone Battleaxe
	 	NamespacedKey stoneBattleaxeKey = new NamespacedKey(main,"StoneBattleaxe");
		ShapedRecipe StoneBattleaxeR = new ShapedRecipe(stoneBattleaxeKey,Items.StoneBattleaxe).shape("222","212"," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.STONE);
	 	Bukkit.getServer().addRecipe(StoneBattleaxeR);
	    // Stone Pickaxe
	 	NamespacedKey stonePickaxeKey = new NamespacedKey(main,"StonePickaxe");
		ShapedRecipe StonePickaxeR = new ShapedRecipe(stonePickaxeKey,Items.StonePickaxe).shape("222"," 1 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.STONE);
	    Bukkit.getServer().addRecipe(StonePickaxeR);
	    // Stone Shield
	    NamespacedKey stoneShieldKey = new NamespacedKey(main,"StoneShield");
		ShapedRecipe StoneShieldR = new ShapedRecipe(stoneShieldKey,Items.StoneShield).shape(" 11"," 11"," 11").setIngredient('1', Material.STONE);
	    Bukkit.getServer().addRecipe(StoneShieldR);
	/////////////////////////////////////////////////////////////////// I R O N ////////////////////////////////////////////////////////////////////////////////////////
	    // Iron Sword
	 	NamespacedKey ironSwordKey = new NamespacedKey(main,"IronSword");
		ShapedRecipe IronSwordR = new ShapedRecipe(ironSwordKey,Items.IronSword).shape(" 2 "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.IRON_INGOT);
	 	Bukkit.getServer().addRecipe(IronSwordR);
	    // Iron Knife
	 	NamespacedKey ironKnifeKey = new NamespacedKey(main,"IronKnife");
		ShapedRecipe IronKnifeR = new ShapedRecipe(ironKnifeKey,Items.IronKnife).shape("   "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.IRON_INGOT);
	 	Bukkit.getServer().addRecipe(IronKnifeR);
	    // Iron Battleaxe
	 	NamespacedKey ironBattleaxeKey = new NamespacedKey(main,"IronBattleaxe");
		ShapedRecipe IronBattleaxeR = new ShapedRecipe(ironBattleaxeKey,Items.IronBattleaxe).shape("222","212"," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.IRON_INGOT);
	 	Bukkit.getServer().addRecipe(IronBattleaxeR);
	    // Iron Pickaxe
	 	NamespacedKey ironPickaxeKey = new NamespacedKey(main,"IronPickaxe");
		ShapedRecipe IronPickaxeR = new ShapedRecipe(ironPickaxeKey,Items.IronPickaxe).shape("222"," 1 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.IRON_INGOT);
	    Bukkit.getServer().addRecipe(IronPickaxeR);
	    // Iron Shield
	    NamespacedKey ironShieldKey = new NamespacedKey(main,"IronShield");
		ShapedRecipe IronShieldR = new ShapedRecipe(ironShieldKey,Items.IronShield).shape(" 11"," 11"," 11").setIngredient('1', Material.IRON_INGOT);
	    Bukkit.getServer().addRecipe(IronShieldR);
	    // Iron Helmet
	    NamespacedKey ironHelmetKey = new NamespacedKey(main,"IronHelmet");
		ShapedRecipe IronHelmetR = new ShapedRecipe(ironHelmetKey,Items.IronHelmet).shape("111","1 1","   ").setIngredient('1', Material.IRON_INGOT);
	    Bukkit.getServer().addRecipe(IronHelmetR);
	    // Iron Chestplate
	    NamespacedKey ironChestplateKey = new NamespacedKey(main,"IronChestplate");
		ShapedRecipe IronChestplateR = new ShapedRecipe(ironChestplateKey,Items.IronChestplate).shape("1 1","111","111").setIngredient('1', Material.IRON_INGOT);
	    Bukkit.getServer().addRecipe(IronChestplateR);
	    // Iron Leggings
	    NamespacedKey ironLeggingsKey = new NamespacedKey(main,"IronLeggings");
		ShapedRecipe IronLeggingsR = new ShapedRecipe(ironLeggingsKey,Items.IronLeggings).shape("111","1 1","1 1").setIngredient('1', Material.IRON_INGOT);
	    Bukkit.getServer().addRecipe(IronLeggingsR);
	    // Iron Boots
	    NamespacedKey ironBootsKey = new NamespacedKey(main,"IronBoots");
		ShapedRecipe IronBootsR = new ShapedRecipe(ironBootsKey,Items.IronBoots).shape("   ","1 1","1 1").setIngredient('1', Material.IRON_INGOT);
	    Bukkit.getServer().addRecipe(IronBootsR);
/////////////////////////////////////////////////////////////////// G O L D ////////////////////////////////////////////////////////////////////////////////////////
	    // Gold Sword
	 	NamespacedKey goldSwordKey = new NamespacedKey(main,"GoldSword");
		ShapedRecipe GoldSwordR = new ShapedRecipe(goldSwordKey,Items.GoldSword).shape(" 2 "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.GOLD_INGOT);
	 	Bukkit.getServer().addRecipe(GoldSwordR);
	    // Gold Knife
	 	NamespacedKey goldKnifeKey = new NamespacedKey(main,"GoldKnife");
		ShapedRecipe GoldKnifeR = new ShapedRecipe(goldKnifeKey,Items.GoldKnife).shape("   "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.GOLD_INGOT);
	 	Bukkit.getServer().addRecipe(GoldKnifeR);
	    // Gold Battleaxe
	 	NamespacedKey goldBattleaxeKey = new NamespacedKey(main,"GoldBattleaxe");
		ShapedRecipe GoldBattleaxeR = new ShapedRecipe(goldBattleaxeKey,Items.GoldBattleaxe).shape("222","212"," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.GOLD_INGOT);
	 	Bukkit.getServer().addRecipe(GoldBattleaxeR);
	    // Gold Pickaxe
	 	NamespacedKey goldPickaxeKey = new NamespacedKey(main,"GoldPickaxe");
		ShapedRecipe GoldPickaxeR = new ShapedRecipe(goldPickaxeKey,Items.GoldPickaxe).shape("222"," 1 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.GOLD_INGOT);
	    Bukkit.getServer().addRecipe(GoldPickaxeR);
	    // Gold Shield
	    NamespacedKey goldShieldKey = new NamespacedKey(main,"GoldShield");
		ShapedRecipe GoldShieldR = new ShapedRecipe(goldShieldKey,Items.GoldShield).shape(" 11"," 11"," 11").setIngredient('1', Material.GOLD_INGOT);
	    Bukkit.getServer().addRecipe(GoldShieldR);
	    // Gold Helmet
	    NamespacedKey goldHelmetKey = new NamespacedKey(main,"GoldHelmet");
		ShapedRecipe GoldHelmetR = new ShapedRecipe(goldHelmetKey,Items.GoldHelmet).shape("111","1 1","   ").setIngredient('1', Material.GOLD_INGOT);
	    Bukkit.getServer().addRecipe(GoldHelmetR);
	    // Gold Chestplate
	    NamespacedKey goldChestplateKey = new NamespacedKey(main,"GoldChestplate");
		ShapedRecipe GoldChestplateR = new ShapedRecipe(goldChestplateKey,Items.GoldChestplate).shape("1 1","111","111").setIngredient('1', Material.GOLD_INGOT);
	    Bukkit.getServer().addRecipe(GoldChestplateR);
	    // Gold Leggings
	    NamespacedKey goldLeggingsKey = new NamespacedKey(main,"GoldLeggings");
		ShapedRecipe GoldLeggingsR = new ShapedRecipe(goldLeggingsKey,Items.GoldLeggings).shape("111","1 1","1 1").setIngredient('1', Material.GOLD_INGOT);
	    Bukkit.getServer().addRecipe(GoldLeggingsR);
	    // Gold Boots
	    NamespacedKey goldBootsKey = new NamespacedKey(main,"GoldBoots");
		ShapedRecipe GoldBootsR = new ShapedRecipe(goldBootsKey,Items.GoldBoots).shape("   ","1 1","1 1").setIngredient('1', Material.GOLD_INGOT);
	    Bukkit.getServer().addRecipe(GoldBootsR);
/////////////////////////////////////////////////////////////////// D I A M O N D ////////////////////////////////////////////////////////////////////////////////////////
	    // Diamond Sword
	 	NamespacedKey diamondSwordKey = new NamespacedKey(main,"DiamondSword");
		ShapedRecipe DiamondSwordR = new ShapedRecipe(diamondSwordKey,Items.DiamondSword).shape(" 2 "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.DIAMOND);
	 	Bukkit.getServer().addRecipe(DiamondSwordR);
	    // Diamond Knife
	 	NamespacedKey diamondKnifeKey = new NamespacedKey(main,"DiamondKnife");
		ShapedRecipe DiamondKnifeR = new ShapedRecipe(diamondKnifeKey,Items.DiamondKnife).shape("   "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.DIAMOND);
	 	Bukkit.getServer().addRecipe(DiamondKnifeR);
	    // Diamond Battleaxe
	 	NamespacedKey diamondBattleaxeKey = new NamespacedKey(main,"DiamondBattleaxe");
		ShapedRecipe DiamondBattleaxeR = new ShapedRecipe(diamondBattleaxeKey,Items.DiamondBattleaxe).shape("222","212"," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.DIAMOND);
	 	Bukkit.getServer().addRecipe(DiamondBattleaxeR);
	    // Diamond Pickaxe
	 	NamespacedKey diamondPickaxeKey = new NamespacedKey(main,"DiamondPickaxe");
		ShapedRecipe DiamondPickaxeR = new ShapedRecipe(diamondPickaxeKey,Items.DiamondPickaxe).shape("222"," 1 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.DIAMOND);
	    Bukkit.getServer().addRecipe(DiamondPickaxeR);
	    // Diamond Shield
	    NamespacedKey diamondShieldKey = new NamespacedKey(main,"DiamondShield");
		ShapedRecipe DiamondShieldR = new ShapedRecipe(diamondShieldKey,Items.DiamondShield).shape(" 11"," 11"," 11").setIngredient('1', Material.DIAMOND);
	    Bukkit.getServer().addRecipe(DiamondShieldR);
	    // Diamond Helmet
	    NamespacedKey diamondHelmetKey = new NamespacedKey(main,"DiamondHelmet");
		ShapedRecipe DiamondHelmetR = new ShapedRecipe(diamondHelmetKey,Items.DiamondHelmet).shape("111","1 1","   ").setIngredient('1', Material.DIAMOND);
	    Bukkit.getServer().addRecipe(DiamondHelmetR);
	    // Diamond Chestplate
	    NamespacedKey diamondChestplateKey = new NamespacedKey(main,"DiamondChestplate");
		ShapedRecipe DiamondChestplateR = new ShapedRecipe(diamondChestplateKey,Items.DiamondChestplate).shape("1 1","111","111").setIngredient('1', Material.DIAMOND);
	    Bukkit.getServer().addRecipe(DiamondChestplateR);
	    // Diamond Leggings
	    NamespacedKey diamondLeggingsKey = new NamespacedKey(main,"DiamondLeggings");
		ShapedRecipe DiamondLeggingsR = new ShapedRecipe(diamondLeggingsKey,Items.DiamondLeggings).shape("111","1 1","1 1").setIngredient('1', Material.DIAMOND);
	    Bukkit.getServer().addRecipe(DiamondLeggingsR);
	    // Diamond Boots
	    NamespacedKey diamondBootsKey = new NamespacedKey(main,"DiamondBoots");
		ShapedRecipe DiamondBootsR = new ShapedRecipe(diamondBootsKey,Items.DiamondBoots).shape("   ","1 1","1 1").setIngredient('1', Material.DIAMOND);
	    Bukkit.getServer().addRecipe(DiamondBootsR);
	    /////////////////////////////////////////////////////////////////// M I T H R I L ////////////////////////////////////////////////////////////////////////////////////////
	    // Mithril Sword
	 	NamespacedKey mithrilSwordKey = new NamespacedKey(main,"MithrilSword");
		ShapedRecipe MithrilSwordR = new ShapedRecipe(mithrilSwordKey,Items.MithrilSword).shape(" 2 "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.INK_SAC, (short) 4);
	 	Bukkit.getServer().addRecipe(MithrilSwordR);
	    // Mithril Knife
	 	NamespacedKey mithrilKnifeKey = new NamespacedKey(main,"MithrilKnife");
		ShapedRecipe MithrilKnifeR = new ShapedRecipe(mithrilKnifeKey,Items.MithrilKnife).shape("   "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.INK_SAC, (short) 4);
	 	Bukkit.getServer().addRecipe(MithrilKnifeR);
	    // Mithril Battleaxe
	 	NamespacedKey mithrilBattleaxeKey = new NamespacedKey(main,"MithrilBattleaxe");
		ShapedRecipe MithrilBattleaxeR = new ShapedRecipe(mithrilBattleaxeKey,Items.MithrilBattleaxe).shape("222","212"," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.INK_SAC, (short) 4);
	 	Bukkit.getServer().addRecipe(MithrilBattleaxeR);
	    // Mithril Pickaxe
	 	NamespacedKey mithrilPickaxeKey = new NamespacedKey(main,"MithrilPickaxe");
		ShapedRecipe MithrilPickaxeR = new ShapedRecipe(mithrilPickaxeKey,Items.MithrilPickaxe).shape("222"," 1 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.INK_SAC, (short) 4);
	    Bukkit.getServer().addRecipe(MithrilPickaxeR);
	    // Mithril Shield
	    NamespacedKey mithrilShieldKey = new NamespacedKey(main,"MithrilShield");
		ShapedRecipe MithrilShieldR = new ShapedRecipe(mithrilShieldKey,Items.MithrilShield).shape(" 11"," 11"," 11").setIngredient('1', Material.INK_SAC, (short) 4);
	    Bukkit.getServer().addRecipe(MithrilShieldR);
	    // Mithril Helmet
	    NamespacedKey mithrilHelmetKey = new NamespacedKey(main,"MithrilHelmet");
		ShapedRecipe MithrilHelmetR = new ShapedRecipe(mithrilHelmetKey,Items.MithrilHelmet).shape("111","1 1","   ").setIngredient('1', Material.INK_SAC, (short) 4);
	    Bukkit.getServer().addRecipe(MithrilHelmetR);
	    // Mithril Chestplate
	    NamespacedKey mithrilChestplateKey = new NamespacedKey(main,"MithrilChestplate");
		ShapedRecipe MithrilChestplateR = new ShapedRecipe(mithrilChestplateKey,Items.MithrilChestplate).shape("1 1","111","111").setIngredient('1', Material.INK_SAC, (short) 4);
	    Bukkit.getServer().addRecipe(MithrilChestplateR);
	    // Mithril Leggings
	    NamespacedKey mithrilLeggingsKey = new NamespacedKey(main,"MithrilLeggings");
		ShapedRecipe MithrilLeggingsR = new ShapedRecipe(mithrilLeggingsKey,Items.MithrilLeggings).shape("111","1 1","1 1").setIngredient('1', Material.INK_SAC, (short) 4);
	    Bukkit.getServer().addRecipe(MithrilLeggingsR);
	    // Mithril Boots
	    NamespacedKey mithrilBootsKey = new NamespacedKey(main,"MithrilBoots");
		ShapedRecipe MithrilBootsR = new ShapedRecipe(mithrilBootsKey,Items.MithrilBoots).shape("   ","1 1","1 1").setIngredient('1', Material.INK_SAC, (short) 4);
	    Bukkit.getServer().addRecipe(MithrilBootsR);
	    /////////////////////////////////////////////////////////////////// A D A M A N T I T E ////////////////////////////////////////////////////////////////////////////////////////
	    // Adamantite Sword
	 	NamespacedKey adamantiteSwordKey = new NamespacedKey(main,"AdamantiteSword");
		ShapedRecipe AdamantiteSwordR = new ShapedRecipe(adamantiteSwordKey,Items.AdamantiteSword).shape(" 2 "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.INK_SAC, (short) 5);
	 	Bukkit.getServer().addRecipe(AdamantiteSwordR);
	    // Adamantite Knife
	 	NamespacedKey adamantiteKnifeKey = new NamespacedKey(main,"AdamantiteKnife");
		ShapedRecipe AdamantiteKnifeR = new ShapedRecipe(adamantiteKnifeKey,Items.AdamantiteKnife).shape("   "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.INK_SAC, (short) 5);
	 	Bukkit.getServer().addRecipe(AdamantiteKnifeR);
	    // Adamantite Battleaxe
	 	NamespacedKey adamantiteBattleaxeKey = new NamespacedKey(main,"AdamantiteBattleaxe");
		ShapedRecipe AdamantiteBattleaxeR = new ShapedRecipe(adamantiteBattleaxeKey,Items.AdamantiteBattleaxe).shape("222","212"," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.INK_SAC, (short) 5);
	 	Bukkit.getServer().addRecipe(AdamantiteBattleaxeR);
	    // Adamantite Pickaxe
	 	NamespacedKey adamantitePickaxeKey = new NamespacedKey(main,"AdamantitePickaxe");
		ShapedRecipe AdamantitePickaxeR = new ShapedRecipe(adamantitePickaxeKey,Items.AdamantitePickaxe).shape("222"," 1 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.INK_SAC, (short) 5);
	    Bukkit.getServer().addRecipe(AdamantitePickaxeR);
	    // Adamantite Shield
	    NamespacedKey adamantiteShieldKey = new NamespacedKey(main,"AdamantiteShield");
		ShapedRecipe AdamantiteShieldR = new ShapedRecipe(adamantiteShieldKey,Items.AdamantiteShield).shape(" 11"," 11"," 11").setIngredient('1', Material.INK_SAC, (short) 5);
	    Bukkit.getServer().addRecipe(AdamantiteShieldR);
	    // Adamantite Helmet
	    NamespacedKey adamantiteHelmetKey = new NamespacedKey(main,"AdamantiteHelmet");
		ShapedRecipe AdamantiteHelmetR = new ShapedRecipe(adamantiteHelmetKey,Items.AdamantiteHelmet).shape("111","1 1","   ").setIngredient('1', Material.INK_SAC, (short) 5);
	    Bukkit.getServer().addRecipe(AdamantiteHelmetR);
	    // Adamantite Chestplate
	    NamespacedKey adamantiteChestplateKey = new NamespacedKey(main,"AdamantiteChestplate");
		ShapedRecipe AdamantiteChestplateR = new ShapedRecipe(adamantiteChestplateKey,Items.AdamantiteChestplate).shape("1 1","111","111").setIngredient('1', Material.INK_SAC, (short) 5);
	    Bukkit.getServer().addRecipe(AdamantiteChestplateR);
	    // Adamantite Leggings
	    NamespacedKey adamantiteLeggingsKey = new NamespacedKey(main,"AdamantiteLeggings");
		ShapedRecipe AdamantiteLeggingsR = new ShapedRecipe(adamantiteLeggingsKey,Items.AdamantiteLeggings).shape("111","1 1","1 1").setIngredient('1', Material.INK_SAC, (short) 5);
	    Bukkit.getServer().addRecipe(AdamantiteLeggingsR);
	    // Adamantite Boots
	    NamespacedKey adamantiteBootsKey = new NamespacedKey(main,"AdamantiteBoots");
		ShapedRecipe AdamantiteBootsR = new ShapedRecipe(adamantiteBootsKey,Items.AdamantiteBoots).shape("   ","1 1","1 1").setIngredient('1', Material.INK_SAC, (short) 5);
	    Bukkit.getServer().addRecipe(AdamantiteBootsR);
	    /////////////////////////////////////////////////////////////////// E N C H A N T E D ////////////////////////////////////////////////////////////////////////////////////////
	    // Void Sword
	 	NamespacedKey enchantedSwordKey = new NamespacedKey(main,"VoidSword");
		ShapedRecipe VoidSwordR = new ShapedRecipe(enchantedSwordKey,Items.VoidSword).shape(" 2 "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.INK_SAC, (short) 13);
	 	Bukkit.getServer().addRecipe(VoidSwordR);
	    // Void Knife
	 	NamespacedKey enchantedKnifeKey = new NamespacedKey(main,"VoidKnife");
		ShapedRecipe VoidKnifeR = new ShapedRecipe(enchantedKnifeKey,Items.VoidKnife).shape("   "," 2 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.INK_SAC, (short) 13);
	 	Bukkit.getServer().addRecipe(VoidKnifeR);
	    // Void Battleaxe
	 	NamespacedKey enchantedBattleaxeKey = new NamespacedKey(main,"VoidBattleaxe");
		ShapedRecipe VoidBattleaxeR = new ShapedRecipe(enchantedBattleaxeKey,Items.VoidBattleaxe).shape("222","212"," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.INK_SAC, (short) 13);
	 	Bukkit.getServer().addRecipe(VoidBattleaxeR);
	    // Void Pickaxe
	 	NamespacedKey enchantedPickaxeKey = new NamespacedKey(main,"VoidPickaxe");
		ShapedRecipe VoidPickaxeR = new ShapedRecipe(enchantedPickaxeKey,Items.VoidPickaxe).shape("222"," 1 "," 1 ").setIngredient('1', Material.STICK).setIngredient('2', Material.INK_SAC, (short) 13);
	    Bukkit.getServer().addRecipe(VoidPickaxeR);
	    // Void Shield
	    NamespacedKey enchantedShieldKey = new NamespacedKey(main,"VoidShield");
		ShapedRecipe VoidShieldR = new ShapedRecipe(enchantedShieldKey,Items.VoidShield).shape(" 11"," 11"," 11").setIngredient('1', Material.INK_SAC, (short) 13);
	    Bukkit.getServer().addRecipe(VoidShieldR);
	    // Void Helmet
	    NamespacedKey enchantedHelmetKey = new NamespacedKey(main,"VoidHelmet");
		ShapedRecipe VoidHelmetR = new ShapedRecipe(enchantedHelmetKey,Items.VoidHelmet).shape("111","1 1","   ").setIngredient('1', Material.INK_SAC, (short) 13);
	    Bukkit.getServer().addRecipe(VoidHelmetR);
	    // Void Chestplate
	    NamespacedKey enchantedChestplateKey = new NamespacedKey(main,"VoidChestplate");
		ShapedRecipe VoidChestplateR = new ShapedRecipe(enchantedChestplateKey,Items.VoidChestplate).shape("1 1","111","111").setIngredient('1', Material.INK_SAC, (short) 13);
	    Bukkit.getServer().addRecipe(VoidChestplateR);
	    // Void Leggings
	    NamespacedKey enchantedLeggingsKey = new NamespacedKey(main,"VoidLeggings");
		ShapedRecipe VoidLeggingsR = new ShapedRecipe(enchantedLeggingsKey,Items.VoidLeggings).shape("111","1 1","1 1").setIngredient('1', Material.INK_SAC, (short) 13);
	    Bukkit.getServer().addRecipe(VoidLeggingsR);
	    // Void Boots
	    NamespacedKey enchantedBootsKey = new NamespacedKey(main,"VoidBoots");
		ShapedRecipe VoidBootsR = new ShapedRecipe(enchantedBootsKey,Items.VoidBoots).shape("   ","1 1","1 1").setIngredient('1', Material.INK_SAC, (short) 13);
	    Bukkit.getServer().addRecipe(VoidBootsR);
	    
	}
}