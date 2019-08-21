package erestor_;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Banner;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.inventory.meta.Damageable;

public class Items {

	///////////////////////////////////////////////// I T E M   C R E A T I O N /////////////////////////////////////////////////////////////
	// CreateItem
		public static ItemStack createItem(Material m, String name, String Lore, int sellPrice, int Amount) {
			ItemStack i = new ItemStack(m, Amount);
			ItemMeta iMeta = i.getItemMeta();
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Sell Price: " + ChatColor.GOLD + ChatColor.BOLD + sellPrice)); 
			i.setItemMeta(iMeta);
			return i;
		}
		
	// CreateBowItem
		public static ItemStack createBowItem(int power, int flame, int punch, String name, String Lore, int durability, int sellPrice) {
			ItemStack i = new ItemStack(Material.BOW, 1);
			ItemMeta iMeta = i.getItemMeta();
			((Damageable) iMeta).setDamage(durability);
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Sell Price: " + ChatColor.GOLD + ChatColor.BOLD + sellPrice)); 
			i.setItemMeta(iMeta);
			i.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, power);
			i.addUnsafeEnchantment(Enchantment.ARROW_FIRE, flame);
			i.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, punch);
			return i;
		}
		
	// CreateGoldBagItem
		public static ItemStack createGoldBagItem(String name) {
			ItemStack i = new ItemStack(Material.LIGHT_BLUE_DYE, 1);
			ItemMeta iMeta = i.getItemMeta();
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList(ChatColor.GRAY + "Bag of Coins [Right Click to Redeem!]")); 
			i.setItemMeta(iMeta);
			return i;
		}
		
	// CreatePotion
		public static ItemStack createPotion(PotionEffectType t, int duration, int amplifier, boolean ambient, boolean particles, Color color, String name, String Lore, int sellPrice, int Amount) {
			ItemStack i = new ItemStack(Material.POTION, Amount);
			PotionMeta iMeta = (PotionMeta) i.getItemMeta();
			
			if(t != null) {
				PotionEffect p = new PotionEffect(t,duration,amplifier,ambient,particles);
				iMeta.addCustomEffect(p, false);
			} 
			iMeta.setColor(color);
			
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Sell Price: " + ChatColor.GOLD + ChatColor.BOLD + sellPrice)); 
			i.setItemMeta(iMeta);
			return i;
		}
		
	// CreateShopPotion
		public static ItemStack createShopPotion(PotionEffectType t, int duration, int amplifier, boolean ambient, boolean particles, Color color, String name, String Lore, int buyPrice, int Amount) {
			ItemStack i = new ItemStack(Material.POTION, Amount);
			PotionMeta iMeta = (PotionMeta) i.getItemMeta();
			
			PotionEffect p = new PotionEffect(t,duration,amplifier,ambient,particles);
			iMeta.addCustomEffect(p, false);
			iMeta.setColor(color);
			
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Buy Price: " + ChatColor.GOLD + ChatColor.BOLD + buyPrice)); 
			i.setItemMeta(iMeta);
			return i;
		}
		
	// CreateGroupItem
		public static ItemStack createGroupItem(String name, ChatColor color, String bonus, String worksAgainst) {
			ItemStack i = new ItemStack(Material.PAPER, 1);
			ItemMeta iMeta = i.getItemMeta();
			iMeta.setDisplayName(ChatColor.GRAY + "Group: " + color + name); 
			iMeta.setLore(Arrays.asList(ChatColor.RESET + "" + ChatColor.GRAY + "Group Bonus: " + color + bonus, ChatColor.RESET + "" + ChatColor.GRAY + "Works Against: " + color + worksAgainst));
			i.setItemMeta(iMeta);
			return i;
		}
		
	// CreateManaItem
		public static ItemStack createManaItem(String amount) {
			ItemStack i = new ItemStack(Material.ORANGE_DYE, 1);
			ItemMeta iMeta = i.getItemMeta();
			iMeta.setDisplayName(amount); 
			iMeta.setLore(Arrays.asList(ChatColor.RESET + "" + ChatColor.DARK_PURPLE + "Mana", ChatColor.RESET + "" + ChatColor.GRAY + "Used to fuel magical abilities.", ChatColor.RESET + "" + ChatColor.GRAY + "Attack enemies to charge your Mana!"));
			i.setItemMeta(iMeta);
			return i;
		}
		
	// CreateAbilityItem
		public static ItemStack createAbilityItem(String name) {
			ItemStack i = new ItemStack(Material.BOOK, 1);
			ItemMeta iMeta = i.getItemMeta();
			iMeta.setDisplayName(ChatColor.GOLD + "Ability: " + ChatColor.RESET + name); 
			iMeta.setLore(Arrays.asList(ChatColor.GRAY + "Right click with a weapon", ChatColor.GRAY + "in your offhand to use!", ChatColor.GRAY + "The better the weapon, the", ChatColor.GRAY + "better your ability!"));
			i.setItemMeta(iMeta);
			return i;
		}
		
		// CreateAbilityTopicItem
		public static ItemStack createAbilityTopicItem(Material m, String name, String lore) {
			ItemStack i = new ItemStack(m, 1);
			ItemMeta iMeta = i.getItemMeta();
			iMeta.setDisplayName(ChatColor.RESET + name); 
			iMeta.setLore(Arrays.asList(ChatColor.RESET + lore));
			i.setItemMeta(iMeta);
			return i;
		}
		
	// CreateShopAbilityItem
		public static ItemStack createShopAbilityItem(String name, String Lore1, String Lore2, int buyPrice) {
			ItemStack i = new ItemStack(Material.BOOK, 1);
			ItemMeta iMeta = i.getItemMeta();
			iMeta.setDisplayName(ChatColor.GOLD + "Ability: " + ChatColor.RESET + name); 
			iMeta.setLore(Arrays.asList("" + ChatColor.GRAY + Lore1, "" + ChatColor.GRAY + Lore2, "" + ChatColor.RESET + ChatColor.GRAY + "Train Price: " + ChatColor.GOLD + ChatColor.BOLD + buyPrice)); 
			i.setItemMeta(iMeta);
			return i;
		}
		
	// CreateArenaItem
		public static ItemStack createArenaItem(String name, String difficulty, String reward, int fightPrice) {
			ItemStack i = new ItemStack(Material.PAPER, 1);
			ItemMeta iMeta = i.getItemMeta();
			iMeta.setDisplayName(ChatColor.RED + "Fight Chamption: " + ChatColor.DARK_RED + name); 
			iMeta.setLore(Arrays.asList("" + ChatColor.RESET + ChatColor.WHITE + "Difficulty: " + ChatColor.RED + difficulty, "" + ChatColor.RESET + ChatColor.WHITE + "Reward: " + ChatColor.GREEN + reward, "" + ChatColor.RESET + ChatColor.WHITE + "Fight Price: " + ChatColor.GOLD + ChatColor.BOLD + fightPrice)); 
			i.setItemMeta(iMeta);
			return i;
		}
		
	// CreateShopItem
		public static ItemStack createShopItem(Material m, String name, String Lore, int buyPrice, int Amount, int durability) {
			ItemStack i = new ItemStack(m, Amount);
			ItemMeta iMeta = i.getItemMeta();
			((Damageable) iMeta).setDamage(durability);
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Buy Price: " + ChatColor.GOLD + ChatColor.BOLD + buyPrice)); 
			i.setItemMeta(iMeta);
			return i;
		}
		
	// CreateShopGemItem
		public static ItemStack createShopGemItem(Material m, String name, String Lore, int AmountE, int AmountR, int AmountS, int durability) {
			ItemStack i = new ItemStack(m, 1);
			ItemMeta iMeta = i.getItemMeta();
			((Damageable) iMeta).setDamage(durability);
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Items Needed: ", 
					"" + ChatColor.GRAY + "Emeralds: " + ChatColor.GREEN + AmountE, 
					"" + ChatColor.GRAY + "Rubies: " + ChatColor.RED + AmountR, 
					"" + ChatColor.GRAY + "Sapphires: " + ChatColor.BLUE + AmountS)); 
			i.setItemMeta(iMeta);
			return i;
		}
		
	// CreateShopTradeItem
		public static ItemStack createShopTradeItem(Material m, String name, String Lore, int Amount, int durability, ItemStack buyItem) {
			ItemStack i = new ItemStack(m, 1);
			ItemMeta iMeta = i.getItemMeta();
			((Damageable) iMeta).setDamage(durability);
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Items Needed: ", 
					"" + ChatColor.GRAY + buyItem.getItemMeta().getDisplayName() + ": " + ChatColor.GREEN + Amount));
			i.setItemMeta(iMeta);
			return i;
		}
		
	// CreateShopWeapon
		public static ItemStack createShopWeapon(Material m, String name, String Lore, int buyPrice, int durability, double damage, double attackSpeed) {
			ItemStack i = new ItemStack(m, 1);
			ItemMeta iMeta = i.getItemMeta();
			((Damageable) iMeta).setDamage(durability);
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Buy Price: " + ChatColor.GOLD + ChatColor.BOLD + buyPrice));  
			i.setItemMeta(iMeta);
			ItemStack trueItem = Attributes.setAttribute(i, "generic.attackDamage", damage, "mainhand");
			return Attributes.setAttribute(trueItem, "generic.attackSpeed", attackSpeed, "mainhand");
		}
		
	// CreateShopArmor
		public static ItemStack createShopArmor(Material m, String name, String Lore, int buyPrice, int durability, double armorValue, double armorToughness, String slot) {
			ItemStack i = new ItemStack(m, 1);
			ItemMeta iMeta = i.getItemMeta();
			((Damageable) iMeta).setDamage(durability);
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Buy Price: " + ChatColor.GOLD + ChatColor.BOLD + buyPrice)); 
			i.setItemMeta(iMeta);
			ItemStack trueItem = Attributes.setAttribute(i, "generic.armor", armorValue, slot);
			return Attributes.setAttribute(trueItem, "generic.armorToughness", armorToughness, slot);
		}
		
	// CreateShopShield
		public static ItemStack createShopShield(DyeColor color, String name, String Lore, int buyPrice, int durability, double armorValue, double armorToughness, String slot) {
			ItemStack i = new ItemStack(Material.SHIELD, 1);
			
			ItemMeta meta = i.getItemMeta();
			((Damageable) meta).setDamage(durability);
            BlockStateMeta bmeta = (BlockStateMeta) meta;
            Banner banner = (Banner) bmeta.getBlockState();
            banner.setBaseColor(color);
            banner.addPattern(new Pattern(color, PatternType.SKULL));
            banner.update();
            bmeta.setBlockState(banner);
            i.setItemMeta(bmeta);
			
			ItemMeta iMeta = i.getItemMeta();
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Buy Price: " + ChatColor.GOLD + ChatColor.BOLD + buyPrice)); 
			i.setItemMeta(iMeta);

			ItemStack trueItem = Attributes.setAttribute(i, "generic.armor", armorValue, slot);
			return Attributes.setAttribute(trueItem, "generic.armorToughness", armorToughness, slot);
		}
		
		// CreateChoiceItem
		public static ItemStack createChoiceItem(String name, Material wool) {
			ItemStack i = new ItemStack(wool, 1);
			
			ItemMeta iMeta = i.getItemMeta();
			iMeta.setDisplayName("" + ChatColor.RESET + name); 
			i.setItemMeta(iMeta);
			return i;
		}
		
		// CreateBreakableWeapon
		public static ItemStack createShopBreakableWeapon(Material m, String name, String Lore, int buyPrice, int durability, double damage, double attackSpeed) {
			ItemStack i = new ItemStack(m, 1);
			ItemMeta iMeta = i.getItemMeta();
			((Damageable) iMeta).setDamage(durability);
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Buy Price: " + ChatColor.GOLD + ChatColor.BOLD + buyPrice)); 
			i.setItemMeta(iMeta);
			ItemStack trueItem = Attributes.setBreakableAttribute(i, "generic.attackDamage", damage, "mainhand");
			return Attributes.setBreakableAttribute(trueItem, "generic.attackSpeed", attackSpeed, "mainhand");
		}
		
	// CreateLeatherArmor
		public static ItemStack createShopLeatherArmor(Color color, Material m, String name, String Lore, int buyPrice, int durability, double armorValue, double armorToughness, String slot) {
			ItemStack i = new ItemStack(m, 1);
			LeatherArmorMeta iMeta = (LeatherArmorMeta) i.getItemMeta();
			((Damageable) iMeta).setDamage(durability);
			iMeta.setColor(color);
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Buy Price: " + ChatColor.GOLD + ChatColor.BOLD + buyPrice)); 
			i.setItemMeta(iMeta);
			ItemStack trueItem = Attributes.setAttribute(i, "generic.armor", armorValue, slot);
			return Attributes.setAttribute(trueItem, "generic.armorToughness", armorToughness, slot);
		}
		
	// CreateWeapon
		public static ItemStack createWeapon(Material m, String name, String Lore, int sellPrice, int durability, double damage, double attackSpeed) {
			ItemStack i = new ItemStack(m, 1);
			ItemMeta iMeta = i.getItemMeta();
			((Damageable) iMeta).setDamage(durability);
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Sell Price: " + ChatColor.GOLD + ChatColor.BOLD + sellPrice));  
			i.setItemMeta(iMeta);
			ItemStack trueItem = Attributes.setAttribute(i, "generic.attackDamage", damage, "mainhand");
			return Attributes.setAttribute(trueItem, "generic.attackSpeed", attackSpeed, "mainhand");
		}
		
	// CreateArmor
		public static ItemStack createArmor(Material m, String name, String Lore, int sellPrice, int durability, double armorValue, double armorToughness, String slot) {
			ItemStack i = new ItemStack(m, 1);
			ItemMeta iMeta = i.getItemMeta();
			((Damageable) iMeta).setDamage(durability);
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Sell Price: " + ChatColor.GOLD + ChatColor.BOLD + sellPrice)); 
			i.setItemMeta(iMeta);
			ItemStack trueItem = Attributes.setAttribute(i, "generic.armor", armorValue, slot);
			return Attributes.setAttribute(trueItem, "generic.armorToughness", armorToughness, slot);
		}
		
	// CreateShield
		public static ItemStack createShield(DyeColor color, String name, String Lore, int sellPrice, int durability, double armorValue, double armorToughness, String slot) {
			ItemStack i = new ItemStack(Material.SHIELD, 1);
			
			ItemMeta meta = i.getItemMeta();
			((Damageable) meta).setDamage(durability);
            BlockStateMeta bmeta = (BlockStateMeta) meta;
            Banner banner = (Banner) bmeta.getBlockState();
            banner.setBaseColor(color);
            banner.addPattern(new Pattern(color, PatternType.SKULL));
            banner.update();
            bmeta.setBlockState(banner);
            i.setItemMeta(bmeta);
			
			ItemMeta iMeta = i.getItemMeta();
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Sell Price: " + ChatColor.GOLD + ChatColor.BOLD + sellPrice)); 
			i.setItemMeta(iMeta);

			ItemStack trueItem = Attributes.setAttribute(i, "generic.armor", armorValue, slot);
			return Attributes.setAttribute(trueItem, "generic.armorToughness", armorToughness, slot);
		}
		
	// CreateBreakableWeapon
		public static ItemStack createBreakableWeapon(Material m, String name, String Lore, int sellPrice, int durability, double damage, double attackSpeed) {
			ItemStack i = new ItemStack(m, 1);
			ItemMeta iMeta = i.getItemMeta();
			((Damageable) iMeta).setDamage(durability);
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Sell Price: " + ChatColor.GOLD + ChatColor.BOLD + sellPrice));  
			i.setItemMeta(iMeta);
			ItemStack trueItem = Attributes.setBreakableAttribute(i, "generic.attackDamage", damage, "mainhand");
			return Attributes.setBreakableAttribute(trueItem, "generic.attackSpeed", attackSpeed, "mainhand");
		}
		
	// CreateLeatherArmor
		public static ItemStack createLeatherArmor(Color color, Material m, String name, String Lore, int sellPrice, int durability, double armorValue, double armorToughness, String slot) {
			ItemStack i = new ItemStack(m, 1);
			LeatherArmorMeta iMeta = (LeatherArmorMeta) i.getItemMeta();
			((Damageable) iMeta).setDamage(durability);
			iMeta.setColor(color);
			iMeta.setDisplayName("" + name); 
			iMeta.setLore(Arrays.asList("" + Lore, "" + ChatColor.RESET + ChatColor.GRAY + "Sell Price: " + ChatColor.GOLD + ChatColor.BOLD + sellPrice)); 
			i.setItemMeta(iMeta);
			ItemStack trueItem = Attributes.setAttribute(i, "generic.armor", armorValue, slot);
			return Attributes.setAttribute(trueItem, "generic.armorToughness", armorToughness, slot);
		}
		
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	// STARTER BOOK
		public static ItemStack createStarterBook() {
			ItemStack starterBook = Items.createItem(Material.WRITTEN_BOOK, "" + ChatColor.RESET + "Starter Book", "" + ChatColor.RESET + ChatColor.GRAY + "Contains general information about Keys", 50, 1);
			BookMeta bookMeta = (BookMeta) starterBook.getItemMeta();
			bookMeta.setTitle("Starter Book");
			bookMeta.setAuthor("Bob the Villager");
			bookMeta.addPage(""
					+ ChatColor.BLUE + ChatColor.BOLD + "Welcome to " + ChatColor.GOLD + "Keys 2.4" + ChatColor.BLUE + "!"
					+ ChatColor.DARK_RED + "\n\nHacking will result in a perm ban!"
					+ ChatColor.BLACK + "\n\nLearn how to play on the following pages."
					+ ChatColor.BLUE + ChatColor.BOLD + "\n\nEnjoy!"
					);
			bookMeta.addPage(""	
					+ ChatColor.BLUE + ChatColor.BOLD + "General Information"
					+ ChatColor.BLACK + "\n\nRight click on a bed to set your spawn!"
					+ ChatColor.BLACK + "\n\nUse /bed to teleport to your bed."
					+ ChatColor.BLACK + "\n\nWhen you die, you will keep your hotbar, armor and shield!"
					+ ChatColor.BLACK + "\n\nYou will also keep 75% of your coins!"
					);
			bookMeta.addPage(""
					+ ChatColor.BLUE + ChatColor.BOLD + "Shops"
					+ ChatColor.BLACK + "\n\nRight click on a villager to trade with him."
					+ ChatColor.BLACK + "\n\nLeft click an item in the shop to buy it."
					+ ChatColor.BLACK + "\n\nWhen in a shop, you can right click an item to sell it."
					);
			bookMeta.addPage(""
					+ ChatColor.BLACK + "\n\nYou can also shift right click an item to sell the whole stack!"
					);
			bookMeta.addPage(""
					+ ChatColor.BLUE + ChatColor.BOLD + "Mining and Smelting"
					+ ChatColor.BLACK + "\n\nLeft click a block to mine it."
					+ ChatColor.BLACK + "\n\nStronger pickaxes allow you to break stronger ores."
					+ ChatColor.BLACK + "\n\nUse /smelt to smelt the ores you mine, or right click on a furness."
					);
			bookMeta.addPage(""
					+ ChatColor.BLACK + "\n\nCareful, some ores are guarded by the undead!"
					+ ChatColor.BLACK + "\n\nRarer ore are guarded by formidable opponents."
					);
			bookMeta.addPage(""
					+ ChatColor.BLUE + ChatColor.BOLD + "Crafting"
					+ ChatColor.BLACK + "\n\nUse /craft to craft, or right click a crafting table."
					+ ChatColor.BLACK + "\n\nFill the crafting grid with sticks to craft wooden planks."
					+ ChatColor.BLACK + "\n\nYou must use smooth stone to craft tools and weapons."
					);
			bookMeta.addPage(""
					+ ChatColor.BLACK + "\n\nYou can smelt smooth stone using cobblestone and coal."
					);
			bookMeta.addPage(""
					+ ChatColor.BLUE + ChatColor.BOLD + "Abilities"
					+ ChatColor.BLACK + "\n\nYour mana bar is the purple bar above your hotbar. When it is full, you can use an ability if you have learned one."
					+ ChatColor.BLACK + "\n\nAn Ability Trainer can be found in every town who can teach you new abilties."
					);
			bookMeta.addPage(""
					+ ChatColor.BLACK + "\n\nRight click with a weapon in your offhand to activate your ability."
					+ ChatColor.BLACK + "\n\nThe stronger the weapon in your offhand, the more powerful your ability will be!"
					);
			bookMeta.addPage(""
					+ ChatColor.BLUE + ChatColor.BOLD + "Bosses"
					+ ChatColor.BLACK + "\n\nEach area contains at least one boss."
					+ ChatColor.BLACK + "\n\nDefeat the boss to earn a key which allows you to advance to the next area."
					+ ChatColor.BLACK + "\n\nRight click on a locked door with the correct key in your hand to open it."
					);
			starterBook.setItemMeta(bookMeta);
			return starterBook;
		}
		
		public static ItemStack StarterBook = createStarterBook();
	
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////// M I S C //////////////////////////////////////////////////////////////
	public static ItemStack BronzeCoin = Items.createItem(Material.GRAY_DYE, ChatColor.RESET + "Bronze Coin", ChatColor.GRAY + "Just a bronze coin.", 1, 1);
	public static ItemStack SilverCoin = Items.createItem(Material.PINK_DYE, ChatColor.RESET + "Silver Coin", ChatColor.GRAY + "Just a silver coin.", 100, 1);
	public static ItemStack GoldCoin = Items.createItem(Material.LIME_DYE, ChatColor.RESET + "Gold Coin", ChatColor.GRAY + "Just a gold coin.", 1000, 1);
	public static ItemStack PlatinumCoin = Items.createItem(Material.YELLOW_DYE, ChatColor.RESET + "Platinum Coin", ChatColor.GRAY + "Just a platinum coin.", 10000, 1);
    public static ItemStack air = Items.createItem(Material.IRON_BARS, "", "", 0, 1);
    
    // Abilities
    public static ItemStack abilityAttack = Items.createAbilityTopicItem(Material.IRON_SWORD, "" + ChatColor.RESET + ChatColor.RED + "Offensive Abilities", "Abilities focused around damage.");
    public static ItemStack abilityDefence = Items.createAbilityTopicItem(Material.IRON_CHESTPLATE, "" + ChatColor.RESET + ChatColor.BLUE + "Defence Abilities", "Abilities focused around defence.");
    public static ItemStack abilityAgility = Items.createAbilityTopicItem(Material.FEATHER, "" + ChatColor.RESET + ChatColor.GREEN + "Agility Abilities", "Abilities focused around agility.");
    public static ItemStack noAbility = Items.createAbilityItem("NONE");
    public static ItemStack strengthBoostAbility = Items.createAbilityItem("Strength Boost");
    public static ItemStack explodeAbility = Items.createAbilityItem("Explode");
    public static ItemStack earthquakeAbility = Items.createAbilityItem("Earthquake");
    public static ItemStack lightningAbility = Items.createAbilityItem("Lightning");
    public static ItemStack manaShieldAbility = Items.createAbilityItem("Mana Shield");
    public static ItemStack healAbility = Items.createAbilityItem("Heal");
    public static ItemStack strengthenArmorAbility = Items.createAbilityItem("Strengthen Armor");
    public static ItemStack lifeStealAbility = Items.createAbilityItem("Life Steal");
    public static ItemStack energyBoostAbility = Items.createAbilityItem("Energy Boost");
    public static ItemStack rejuvenateAbility = Items.createAbilityItem("Rejuvenate");
    public static ItemStack leapAbility = Items.createAbilityItem("Leap");
    
    // Misc Trade Items
    public static ItemStack MassiveDiamond = Items.createItem(Material.DIAMOND, ChatColor.RESET + "Super Massive Diamond", ChatColor.GRAY + "Harold's prized possession.", Val.superMassiveDiamond, 1);
    public static ItemStack divingHelmet = Items.createArmor(Material.CARVED_PUMPKIN, ChatColor.RESET + "Diving Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "Allows you to breathe underwater.", Val.divingHelmet, 0, 1, 0, "head");
    
    // Arena Items //
    public static ItemStack arenaWarrior = Items.createArenaItem("Eastcliff Warrior", "I", "1500", 100);
    public static ItemStack arenaKnight = Items.createArenaItem("Eastcliff Knight", "II", "5500", 1000);
    
    public static ItemStack undeadArcherBow = Items.createBowItem(25, 5, 2, ChatColor.RESET + "Undead Archer's Bow", ChatColor.GRAY + "Very powerful!", 5000, 0);
    ////////////////
    
    public static ItemStack torch = Items.createItem(Material.TORCH, ChatColor.RESET + "Torch", ChatColor.RESET + "" + ChatColor.GRAY + "Right click to place, gives off light.", Val.torch, 1);
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////// P O T I O N S //////////////////////////////////////////////////////////////
    public static ItemStack EmptyBottle = Items.createItem(Material.GLASS_BOTTLE, ChatColor.RESET + "Empty Bottle", ChatColor.GRAY + "Can be filled with water to brew potions.", Val.emptyBottle, 1);
    public static ItemStack WaterBottle = Items.createPotion(null, 30*20, 0, false, true, Color.BLUE, ChatColor.RESET + "Water Bottle", ChatColor.GRAY + "Restores 5 saturation.", Val.waterBottle, 1);
    public static ItemStack NightVisionPotion = Items.createPotion(PotionEffectType.NIGHT_VISION, 30*20, 0, false, true, Color.LIME, ChatColor.RESET + "Potion of Night Vision", ChatColor.GRAY + "See in the dark for 30 seconds.", Val.nightVisionPotion, 1);
    public static ItemStack WaterBreathingPotion = Items.createPotion(PotionEffectType.WATER_BREATHING, 30*20, 0, false, true, Color.BLUE, ChatColor.RESET + "Potion of Water Breathing", ChatColor.GRAY + "Breathe underwater for 30 seconds.", Val.waterBreathingPotion, 1);
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
	/////////////////////////////////////////////////////////////////// K E Y S ///////////////////////////////////////////////////////////////////////////////
    public static ItemStack StrangeIronKey = Items.createItem(Material.PUMPKIN_SEEDS, ChatColor.RESET + "Strange Iron Key", ChatColor.GRAY + "Strangely shaped.", 10, 1);
    public static ItemStack RustedIronKey = Items.createItem(Material.PUMPKIN_SEEDS, ChatColor.RESET + "Rusted Iron Key", ChatColor.GRAY + "Obviously very old.", 50, 1);
	public static ItemStack IronKey = Items.createItem(Material.PUMPKIN_SEEDS, ChatColor.RESET + "Iron Key", ChatColor.GRAY + "Can be used to unlock some doors.", 20, 1);
	public static ItemStack StrangeGoldKey = Items.createItem(Material.MELON_SEEDS, ChatColor.RESET + "Strange Gold Key", ChatColor.GRAY + "Strangely shaped.", 80, 1);
	public static ItemStack GoldKey = Items.createItem(Material.MELON_SEEDS, ChatColor.RESET + "Gold Key", ChatColor.GRAY + "Can be used to unlock some doors.", 100, 1);
	public static ItemStack CityKey = Items.createItem(Material.MELON_SEEDS, ChatColor.RESET + "City Key", ChatColor.GRAY + "Can be used to unlock the city gates!", 100000, 1);
	public static ItemStack OldDiamondKey = Items.createItem(Material.WHEAT_SEEDS, ChatColor.RESET + "Old Diamond Key", ChatColor.GRAY + "Can be used to unlock some doors.", 20000, 1);
	public static ItemStack DiamondKey = Items.createItem(Material.WHEAT_SEEDS, ChatColor.RESET + "Diamond Key", ChatColor.GRAY + "Can be used to unlock some doors.", 200000, 1);
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////// O R E S //////////////////////////////////////////////////////////////
	public static ItemStack Stick = Items.createItem(Material.STICK, ChatColor.RESET + "Wood Stick", ChatColor.GRAY + "Can be made into planks. Use /craft to craft!", Val.stickVal, 1);
	public static ItemStack CobbleStone = Items.createItem(Material.COBBLESTONE, ChatColor.RESET + "Cobblestone", ChatColor.GRAY + "Can be made into basic tools.", Val.cobbleStoneVal, 1);
	public static ItemStack Sapphire = Items.createItem(Material.LAPIS_LAZULI, ChatColor.RESET + "Sapphire", ChatColor.GRAY + "Strong and valuable.", Val.sapphireVal, 1);
	public static ItemStack Ruby = Items.createItem(Material.RED_DYE, ChatColor.RESET + "Ruby", ChatColor.GRAY + "Has a fiery glow to it.", Val.rubyVal, 1);
	public static ItemStack Emerald = Items.createItem(Material.EMERALD, ChatColor.RESET + "Emerald", ChatColor.GRAY + "Has a sharp shine to it.", Val.emeraldVal, 1);
	public static ItemStack PrismarineCrystals = Items.createItem(Material.PRISMARINE_CRYSTALS, ChatColor.RESET + "Prismarine Crystals", ChatColor.GRAY + "Guarded by strange creatures.", Val.prismarineCrystalsVal, 1);
	public static ItemStack Coal = Items.createItem(Material.COAL, ChatColor.RESET + "Coal", ChatColor.GRAY + "Can be used to smelt ingots! Use /smelt to smelt!", Val.coalVal, 1);
	public static ItemStack Magma = Items.createItem(Material.MAGMA_BLOCK, ChatColor.RESET + "Magma", ChatColor.GRAY + "Can be used to smelt ingots! Use /smelt to smelt!", Val.magmaVal, 1);
	public static ItemStack IronOre = Items.createItem(Material.IRON_ORE, ChatColor.RESET + "Iron Ore", ChatColor.GRAY + "Can be smelted to make iron ingots.", Val.ironOreVal, 1);
	public static ItemStack GoldOre = Items.createItem(Material.GOLD_ORE, ChatColor.RESET + "Gold Ore", ChatColor.GRAY + "Can be smelted to make gold ingots.", Val.goldOreVal, 1);
	public static ItemStack DiamondOre = Items.createItem(Material.DIAMOND_ORE, ChatColor.RESET + "Diamond Ore", ChatColor.GRAY + "Can be smelted to make diamonds.", Val.diamondOreVal, 1);
	public static ItemStack MithrilOre = Items.createItem(Material.MAGENTA_TERRACOTTA, ChatColor.RESET + "Mithril Ore", ChatColor.GRAY + "Can be smelted to make mithril ingots.", Val.mithrilOreVal, 1);
	public static ItemStack AdamantiteOre = Items.createItem(Material.LIGHT_BLUE_TERRACOTTA, ChatColor.RESET + "Adamantite Ore", ChatColor.GRAY + "Can be smelted to make adamantite ingots.", Val.adamantiteOreVal, 1);
	public static ItemStack VoidOre = Items.createItem(Material.YELLOW_TERRACOTTA, ChatColor.RESET + "Void Ore", ChatColor.GRAY + "Can be smelted to make void gems.", Val.voidOreVal, 1);
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////// I N G O T S //////////////////////////////////////////////////////////////
	public static ItemStack Wood = Items.createItem(Material.OAK_PLANKS, ChatColor.RESET + "Oak Wood Planks", ChatColor.GRAY + "Can be used to craft tools and armor.", Val.woodVal, 1);
	public static ItemStack Stone = Items.createItem(Material.STONE, ChatColor.RESET + "Stone", ChatColor.GRAY + "Can be used to craft tools.", Val.stoneVal, 1);
	public static ItemStack IronIngot = Items.createItem(Material.IRON_INGOT, ChatColor.RESET + "Iron Ingot", ChatColor.GRAY + "Can be used to craft tools and armor.", Val.ironIngotVal, 1);
	public static ItemStack GoldIngot = Items.createItem(Material.GOLD_INGOT, ChatColor.RESET + "Gold Ingot", ChatColor.GRAY + "Can be used to craft tools and armor.", Val.goldIngotVal, 1);
	public static ItemStack Diamond = Items.createItem(Material.DIAMOND, ChatColor.RESET + "Diamond", ChatColor.GRAY + "Can be used to craft tools and armor.", Val.diamondVal, 1);
	public static ItemStack MithrilIngot = Items.createItem(Material.CYAN_DYE, ChatColor.RESET + "Mithril Ingot", ChatColor.GRAY + "Can be used to craft tools and armor.", Val.mithrilIngotVal, 1);
	public static ItemStack AdamantiteIngot = Items.createItem(Material.PURPLE_DYE, ChatColor.RESET + "Adamantite Ingot", ChatColor.GRAY + "Can be used to craft tools and armor.", Val.adamantiteIngotVal, 1);
	public static ItemStack VoidGem = Items.createItem(Material.MAGENTA_DYE, ChatColor.RESET + "Void Gem", ChatColor.GRAY + "Can be used to craft tools and armor.", Val.voidGemVal, 1);
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////// F O O D  //////////////////////////////////////////////////////////////
	public static ItemStack Steak = Items.createItem(Material.COOKED_BEEF, ChatColor.RESET + "Steak", ChatColor.GRAY + "Restores 4 hunger bars.", Val.steak, 1);
	public static ItemStack Porkchop = Items.createItem(Material.COOKED_PORKCHOP, ChatColor.RESET + "Grilled Porkchop", ChatColor.GRAY + "Restores 3 hunger bars.", Val.porkchop, 1);
	public static ItemStack Chicken = Items.createItem(Material.COOKED_CHICKEN, ChatColor.RESET + "Cooked Chicken", ChatColor.GRAY + "Restores 3 hunger bars.", Val.chicken, 1);
	public static ItemStack Mutton = Items.createItem(Material.COOKED_MUTTON, ChatColor.RESET + "Cooked Mutton", ChatColor.GRAY + "Restores 3 hunger bars.", Val.mutton, 1);
	public static ItemStack Bread = Items.createItem(Material.BREAD, ChatColor.RESET + "Bread", ChatColor.GRAY + "Restores 2.5 hunger bars.", Val.bread, 1);
	public static ItemStack Pie = Items.createItem(Material.PUMPKIN_PIE, ChatColor.RESET + "Pumpkin Pie", ChatColor.GRAY + "Restores 4 hunger bars.", Val.pumpkinPie, 1);
	public static ItemStack Cookies = Items.createItem(Material.COOKIE, ChatColor.RESET + "Cookies", ChatColor.GRAY + "Restores 1 hunger bar.", Val.cookies, 1);
	public static ItemStack Fish = Items.createItem(Material.COOKED_COD, ChatColor.RESET + "Cooked Tuna", ChatColor.GRAY + "Restores 2.5 hunger bars.", Val.fish, 1);
	public static ItemStack Salmon = Items.createItem(Material.COOKED_SALMON, ChatColor.RESET + "Cooked Salmon", ChatColor.GRAY + "Restores 3 hunger bars.", Val.salmon, 1);
	public static ItemStack Clownfish = Items.createItem(Material.TROPICAL_FISH, ChatColor.RESET + "Clownfish", ChatColor.GRAY + "Restores 1 hunger bar.", Val.clownfish, 1); 
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
    ////////// Wood ////////////////
	public static ItemStack WoodSword = Items.createWeapon(Material.WOODEN_SWORD, ChatColor.RESET + "Wooden Sword", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden sword.", Val.wSword, 0, 4, -2.5);
	public static ItemStack WoodKnife = Items.createWeapon(Material.WOODEN_SHOVEL, ChatColor.RESET + "Wooden Knife", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden knife.", Val.wKnife, 0, 2, -1.25);
	public static ItemStack WoodBattleaxe = Items.createWeapon(Material.WOODEN_AXE, ChatColor.RESET + "Wooden Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden battleaxe.", Val.wBattleaxe, 0, 5.2, -3.25);
	public static ItemStack WoodPickaxe = Items.createWeapon(Material.WOODEN_PICKAXE, ChatColor.RESET + "Wooden Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden pickaxe.", Val.wPickaxe, 0, 2, -3.0);
	public static ItemStack WoodShield = Items.createShield(DyeColor.BROWN, ChatColor.RESET + "Wooden Shield", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden shield.", Val.wShield, 0, 1, 0, "offhand");
	public static ItemStack WoodHelmet = Items.createArmor(Material.CHAINMAIL_HELMET, ChatColor.RESET + "Wooden Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden helmet.", Val.wHelmet, 0, 1, 0, "head");
	public static ItemStack WoodChestplate = Items.createArmor(Material.CHAINMAIL_CHESTPLATE, ChatColor.RESET + "Wooden Chestplate", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden chestplate.", Val.wChestplate, 0, 3, 0, "chest");
	public static ItemStack WoodLeggings = Items.createArmor(Material.CHAINMAIL_LEGGINGS, ChatColor.RESET + "Wooden Leggings", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden leggings.", Val.wLeggings, 0, 2, 0, "legs");
	public static ItemStack WoodBoots = Items.createArmor(Material.CHAINMAIL_BOOTS, ChatColor.RESET + "Wooden Boots", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden boots.", Val.wBoots, 0, 1, 0, "feet");
    ////////// Stone /////////////// 
	public static ItemStack StoneSword = Items.createWeapon(Material.STONE_SWORD, ChatColor.RESET + "Stone Sword", "" + ChatColor.RESET + ChatColor.GRAY + "A plain stone sword.", Val.sSword, 0, 4.5, -2.4);
	public static ItemStack StoneKnife = Items.createWeapon(Material.STONE_SHOVEL, ChatColor.RESET + "Stone Knife", "" + ChatColor.RESET + ChatColor.GRAY + "A plain stone knife.", Val.sKnife, 0, 2.25, -1.2);
	public static ItemStack StoneBattleaxe = Items.createWeapon(Material.STONE_AXE, ChatColor.RESET + "Stone Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "A plain stone battleaxe.", Val.sBattleaxe, 0, 5.85, -3.12);
	public static ItemStack StonePickaxe = Items.createWeapon(Material.STONE_PICKAXE, ChatColor.RESET + "Stone Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "A plain stone pickaxe.", Val.sPickaxe, 0, 2.5, -2.9);
	public static ItemStack StoneShield = Items.createShield(DyeColor.GRAY, ChatColor.RESET + "Stone Shield", "" + ChatColor.RESET + ChatColor.GRAY + "A plain stone shield.", Val.sShield, 0, 2, 0, "offhand");
	////////// Iron ////////////////
	public static ItemStack IronSword = Items.createWeapon(Material.IRON_SWORD, ChatColor.RESET + "Iron Sword", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron sword.", Val.iSword, 0, 5, -2.3);
	public static ItemStack IronKnife = Items.createWeapon(Material.IRON_SHOVEL, ChatColor.RESET + "Iron Knife", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron knife.", Val.iKnife, 0, 2.5, -1.15);
	public static ItemStack IronBattleaxe = Items.createWeapon(Material.IRON_AXE, ChatColor.RESET + "Iron Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron battleaxe.", Val.iBattleaxe, 0, 6.5, -2.99);
	public static ItemStack IronPickaxe = Items.createWeapon(Material.IRON_PICKAXE, ChatColor.RESET + "Iron Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron pickaxe.", Val.iPickaxe, 0, 3, -2.8);
	public static ItemStack IronShield = Items.createShield(DyeColor.WHITE, ChatColor.RESET + "Iron Shield", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron shield.", Val.iShield, 0, 3, 0, "offhand");
	public static ItemStack IronHelmet = Items.createArmor(Material.IRON_HELMET, ChatColor.RESET + "Iron Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron helmet.", Val.iHelmet, 0, 2, 0, "head");
	public static ItemStack IronChestplate = Items.createArmor(Material.IRON_CHESTPLATE, ChatColor.RESET + "Iron Chestplate", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron chestplate.", Val.iChestplate, 0, 4, 0, "chest");
	public static ItemStack IronLeggings = Items.createArmor(Material.IRON_LEGGINGS, ChatColor.RESET + "Iron Leggings", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron leggings.", Val.iLeggings, 0, 3, 0, "legs");
	public static ItemStack IronBoots = Items.createArmor(Material.IRON_BOOTS, ChatColor.RESET + "Iron Boots", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron boots.", Val.iBoots, 0, 2, 0, "feet");
    ////////// Gold ////////////////
	public static ItemStack GoldSword = Items.createWeapon(Material.GOLDEN_SWORD, ChatColor.RESET + "Golden Sword", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gSword, 0, 6, -2.1);
	public static ItemStack GoldKnife = Items.createWeapon(Material.GOLDEN_SHOVEL, ChatColor.RESET + "Golden Knife", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gKnife, 0, 3, -1.05);
	public static ItemStack GoldBattleaxe = Items.createWeapon(Material.GOLDEN_AXE, ChatColor.RESET + "Golden Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gBattleaxe, 0, 7.8, -2.73);
	public static ItemStack GoldPickaxe = Items.createWeapon(Material.GOLDEN_PICKAXE, ChatColor.RESET + "Golden Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gPickaxe, 0, 3.5, -2.7);
	public static ItemStack GoldShield = Items.createShield(DyeColor.YELLOW, ChatColor.RESET + "Golden Shield", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gShield, 0, 4, 0, "offhand");
	public static ItemStack GoldHelmet = Items.createArmor(Material.GOLDEN_HELMET, ChatColor.RESET + "Golden Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gHelmet, 0, 3, 0, "head");
	public static ItemStack GoldChestplate = Items.createArmor(Material.GOLDEN_CHESTPLATE, ChatColor.RESET + "Golden Chestplate", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gChestplate, 0, 5, 0, "chest");
	public static ItemStack GoldLeggings = Items.createArmor(Material.GOLDEN_LEGGINGS, ChatColor.RESET + "Golden Leggings", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gLeggings, 0, 4, 0, "legs");
	public static ItemStack GoldBoots = Items.createArmor(Material.GOLDEN_BOOTS, ChatColor.RESET + "Golden Boots", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gBoots, 0, 3, 0, "feet");
    ////////// Diamond /////////////
	public static ItemStack DiamondSword = Items.createWeapon(Material.DIAMOND_SWORD, ChatColor.RESET + "Diamond Sword", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dSword, 0, 7, -1.9);
	public static ItemStack DiamondKnife = Items.createWeapon(Material.DIAMOND_SHOVEL, ChatColor.RESET + "Diamond Knife", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dKnife, 0, 3.5, -0.95);
	public static ItemStack DiamondBattleaxe = Items.createWeapon(Material.DIAMOND_AXE, ChatColor.RESET + "Diamond Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dBattleaxe, 0, 9.1, -2.47);
	public static ItemStack DiamondPickaxe = Items.createWeapon(Material.DIAMOND_PICKAXE, ChatColor.RESET + "Diamond Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dPickaxe, 0, 4, -2.6);
	public static ItemStack DiamondShield = Items.createShield(DyeColor.LIGHT_BLUE, ChatColor.RESET + "Diamond Shield", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dShield, 0, 5, 0, "offhand");
	public static ItemStack DiamondHelmet = Items.createArmor(Material.DIAMOND_HELMET, ChatColor.RESET + "Diamond Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dHelmet, 0, 4, 0, "head");
	public static ItemStack DiamondChestplate = Items.createArmor(Material.DIAMOND_CHESTPLATE, ChatColor.RESET + "Diamond Chestplate", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dChestplate, 0, 6, 0, "chest");
	public static ItemStack DiamondLeggings = Items.createArmor(Material.DIAMOND_LEGGINGS, ChatColor.RESET + "Diamond Leggings", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dLeggings, 0, 5, 0, "legs");
	public static ItemStack DiamondBoots = Items.createArmor(Material.DIAMOND_BOOTS, ChatColor.RESET + "Diamond Boots", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dBoots, 0, 4, 0, "feet");
    ////////// Mithril /////////////
	public static ItemStack MithrilSword = Items.createBreakableWeapon(Material.DIAMOND_SWORD, ChatColor.RESET + "Mithril Sword", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mSword, Val.mithrilDur, 9, -1.4);
	public static ItemStack MithrilKnife = Items.createBreakableWeapon(Material.DIAMOND_SHOVEL, ChatColor.RESET + "Mithril Knife", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mKnife, Val.mithrilDur, 4.5, -0.7);
	public static ItemStack MithrilBattleaxe = Items.createBreakableWeapon(Material.DIAMOND_AXE, ChatColor.RESET + "Mithril Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mBattleaxe, Val.mithrilDur, 11.7, -1.82);
	public static ItemStack MithrilPickaxe = Items.createBreakableWeapon(Material.DIAMOND_PICKAXE, ChatColor.RESET + "Mithril Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mPickaxe, Val.mithrilDur, 4.5, -2.5);
	public static ItemStack MithrilShield = Items.createShield(DyeColor.BLUE, ChatColor.RESET + "Mithril Shield", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mShield, 0, 6, 1, "offhand");
	public static ItemStack MithrilHelmet = Items.createLeatherArmor(Color.BLUE, Material.LEATHER_HELMET, ChatColor.RESET + "Mithril Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mHelmet, 0, 5, 1, "head");
	public static ItemStack MithrilChestplate = Items.createLeatherArmor(Color.BLUE, Material.LEATHER_CHESTPLATE, ChatColor.RESET + "Mithril Chestplate", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mChestplate, 0, 7, 2, "chest");
	public static ItemStack MithrilLeggings = Items.createLeatherArmor(Color.BLUE, Material.LEATHER_LEGGINGS, ChatColor.RESET + "Mithril Leggings", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mLeggings, 0, 6, 2, "legs");
	public static ItemStack MithrilBoots = Items.createLeatherArmor(Color.BLUE, Material.LEATHER_BOOTS, ChatColor.RESET + "Mithril Boots", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mBoots, 0, 5, 1, "feet");
    ////////// Adamantite //////////
	public static ItemStack AdamantiteSword = Items.createBreakableWeapon(Material.DIAMOND_SWORD, ChatColor.RESET + "Adamantite Sword", "" + ChatColor.RESET + ChatColor.GRAY + "The hardest material in existence.", Val.aSword, Val.adamDur, 12, -0.8);
	public static ItemStack AdamantiteKnife = Items.createBreakableWeapon(Material.DIAMOND_SHOVEL, ChatColor.RESET + "Adamantite Knife", "" + ChatColor.RESET + ChatColor.GRAY + "The hardest material in existence.", Val.aKnife, Val.adamDur, 6, -0.4);
	public static ItemStack AdamantiteBattleaxe = Items.createBreakableWeapon(Material.DIAMOND_AXE, ChatColor.RESET + "Adamantite Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "The hardest material in existence.", Val.aBattleaxe, Val.adamDur, 15.6, -1.04);
	public static ItemStack AdamantitePickaxe = Items.createBreakableWeapon(Material.DIAMOND_PICKAXE, ChatColor.RESET + "Adamantite Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "The hardest material in existence.", Val.aPickaxe, Val.adamDur, 5, -2.4);
	public static ItemStack AdamantiteShield = Items.createShield(DyeColor.RED, ChatColor.RESET + "Adamantite Shield", "" + ChatColor.RESET + ChatColor.GRAY + "The hardest material in existence.", Val.aShield, 0, 7, 1, "offhand");
	public static ItemStack AdamantiteHelmet = Items.createLeatherArmor(Color.RED, Material.LEATHER_HELMET, ChatColor.RESET + "Adamantite Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "The hardest material in existence.", Val.aHelmet, 0, 6, 2, "head");
	public static ItemStack AdamantiteChestplate = Items.createLeatherArmor(Color.RED, Material.LEATHER_CHESTPLATE, ChatColor.RESET + "Adamantite Chestplate", "" + ChatColor.RESET + ChatColor.GRAY + "The hardest material in existence.", Val.aChestplate, 0, 8, 3, "chest");
	public static ItemStack AdamantiteLeggings = Items.createLeatherArmor(Color.RED, Material.LEATHER_LEGGINGS, ChatColor.RESET + "Adamantite Leggings", "" + ChatColor.RESET + ChatColor.GRAY + "The hardest material in existence.", Val.aLeggings, 0, 7, 3, "legs");
	public static ItemStack AdamantiteBoots = Items.createLeatherArmor(Color.RED, Material.LEATHER_BOOTS, ChatColor.RESET + "Adamantite Boots", "" + ChatColor.RESET + ChatColor.GRAY + "The hardest material in existence.", Val.aBoots, 0, 6, 2, "feet");
    ////////// Void ///////////
	public static ItemStack VoidSword = Items.createBreakableWeapon(Material.DIAMOND_SWORD, ChatColor.RESET + "Void Sword", "" + ChatColor.RESET + ChatColor.GRAY + "Uses void energy to create an impossibly strong material.", Val.vSword, Val.voidDur, 20, 0.2);
	public static ItemStack VoidKnife = Items.createBreakableWeapon(Material.DIAMOND_SHOVEL, ChatColor.RESET + "Void Knife", "" + ChatColor.RESET + ChatColor.GRAY + "Uses void energy to create an impossibly strong material.", Val.vKnife, Val.voidDur, 10, 0.4);
	public static ItemStack VoidBattleaxe = Items.createBreakableWeapon(Material.DIAMOND_AXE, ChatColor.RESET + "Void Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Uses void energy to create an impossibly strong material.", Val.vBattleaxe, Val.voidDur, 26, 0.14);
	public static ItemStack VoidPickaxe = Items.createBreakableWeapon(Material.DIAMOND_PICKAXE, ChatColor.RESET + "Void Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Uses void energy to create an impossibly strong material.", Val.vPickaxe, Val.voidDur, 8, 0);
	public static ItemStack VoidShield = Items.createShield(DyeColor.PURPLE, ChatColor.RESET + "Void Shield", "" + ChatColor.RESET + ChatColor.GRAY + "Uses void energy to create an impossibly strong material.", Val.vShield, 0, 9, 1, "offhand");
	public static ItemStack VoidHelmet = Items.createLeatherArmor(Color.PURPLE, Material.LEATHER_HELMET, ChatColor.RESET + "Void Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "Uses void energy to create an impossibly strong material.", Val.vHelmet, 0, 8, 4, "head");
	public static ItemStack VoidChestplate = Items.createLeatherArmor(Color.PURPLE, Material.LEATHER_CHESTPLATE, ChatColor.RESET + "Void Chestplate", "" + ChatColor.RESET + ChatColor.GRAY + "Uses void energy to create an impossibly strong material.", Val.vChestplate, 0, 10, 5, "chest");
	public static ItemStack VoidLeggings = Items.createLeatherArmor(Color.PURPLE, Material.LEATHER_LEGGINGS, ChatColor.RESET + "Void Leggings", "" + ChatColor.RESET + ChatColor.GRAY + "Uses void energy to create an impossibly strong material.", Val.vLeggings, 0, 9, 5, "legs");
	public static ItemStack VoidBoots = Items.createLeatherArmor(Color.PURPLE, Material.LEATHER_BOOTS, ChatColor.RESET + "Void Boots", "" + ChatColor.RESET + ChatColor.GRAY + "Uses void energy to create an impossibly strong material.", Val.vBoots, 0, 8, 4, "feet");

	//////////////////////////////////////////////////// S H O P   I T E M S //////////////////////////////////////////////////////////////
	public static ItemStack sSteak = Items.createShopItem(Material.COOKED_BEEF, ChatColor.RESET + "Steak", ChatColor.GRAY + "Restores 4 hunger bars.", Val.steak * Val.foodSM, 1, 0);
	public static ItemStack sPorkchop = Items.createShopItem(Material.COOKED_PORKCHOP, ChatColor.RESET + "Grilled Porkchop", ChatColor.GRAY + "Restores 3 hunger bars.", Val.porkchop * Val.foodSM, 1, 0);
	public static ItemStack sChicken = Items.createShopItem(Material.COOKED_CHICKEN, ChatColor.RESET + "Cooked Chicken", ChatColor.GRAY + "Restores 3 hunger bars.", Val.chicken * Val.foodSM, 1, 0);
	public static ItemStack sMutton = Items.createShopItem(Material.COOKED_MUTTON, ChatColor.RESET + "Cooked Mutton", ChatColor.GRAY + "Restores 3 hunger bars.", Val.mutton * Val.foodSM, 1, 0);
	public static ItemStack sBread = Items.createShopItem(Material.BREAD, ChatColor.RESET + "Bread", ChatColor.GRAY + "Restores 2.5 hunger bars.", Val.bread * Val.foodSM, 1, 0);
	public static ItemStack sPie = Items.createShopItem(Material.PUMPKIN_PIE, ChatColor.RESET + "Pumpkin Pie", ChatColor.GRAY + "Restores 4 hunger bars.", Val.pumpkinPie * Val.foodSM, 1, 0);
	public static ItemStack sCookies = Items.createShopItem(Material.COOKIE, ChatColor.RESET + "Cookies", ChatColor.GRAY + "Restores 1 hunger bar.", Val.cookies * Val.foodSM, 1, 0);
	public static ItemStack sFish = Items.createShopItem(Material.COOKED_COD, ChatColor.RESET + "Cooked Tuna", ChatColor.GRAY + "Restores 2.5 hunger bars.", Val.fish * Val.foodSM, 1, 0);
	public static ItemStack sSalmon = Items.createShopItem(Material.COOKED_SALMON, ChatColor.RESET + "Cooked Salmon", ChatColor.GRAY + "Restores 3 hunger bars.", Val.salmon * Val.foodSM, 1, 0); 
	public static ItemStack sClownfish = Items.createShopItem(Material.TROPICAL_FISH, ChatColor.RESET + "Clownfish", ChatColor.GRAY + "Restores 1 hunger bar.", Val.clownfish * Val.foodSM, 1, 0); 
	
	public static ItemStack sEmptyBottle = Items.createShopItem(Material.GLASS_BOTTLE, ChatColor.RESET + "Empty Bottle", ChatColor.GRAY + "Can be filled with water to brew potions.", Val.emptyBottle*Val.potionSM, 1, 0);
    public static ItemStack sNightVisionPotion = Items.createShopPotion(PotionEffectType.NIGHT_VISION, 30*20, 0, false, true, Color.LIME, ChatColor.RESET + "Potion of Night Vision", ChatColor.GRAY + "See in the dark for 30 seconds.", Val.nightVisionPotion*Val.potionSM, 1);
    public static ItemStack sWaterBreathingPotion = Items.createShopPotion(PotionEffectType.WATER_BREATHING, 30*20, 0, false, true, Color.BLUE, ChatColor.RESET + "Potion of Water Breathing", ChatColor.GRAY + "Breathe underwater for 30 seconds.", Val.waterBreathingPotion*Val.potionSM, 1);
	
	public static ItemStack sRustedIronKey = Items.createShopGemItem(Material.PUMPKIN_SEEDS, ChatColor.RESET + "Rusted Iron Key", ChatColor.GRAY + "Obviously very old.", 50, 25, 25, 0);
	public static ItemStack sStrangeGoldKey = Items.createItem(Material.MELON_SEEDS, ChatColor.RESET + "Strange Gold Key", ChatColor.GRAY + "Strangely shaped.", 10250, 1);
	public static ItemStack sGoldKey = Items.createShopItem(Material.MELON_SEEDS, ChatColor.RESET + "Gold Key", ChatColor.GRAY + "Can be used to unlock some doors.", 20500, 1, 0);
	public static ItemStack sCityKey = Items.createShopTradeItem(Material.MELON_SEEDS, ChatColor.RESET + "City Key", ChatColor.GRAY + "Can be used to unlock the city gates!", 1, 0, Items.MassiveDiamond);
	public static ItemStack sOldDiamondKey = Items.createShopTradeItem(Material.WHEAT_SEEDS, ChatColor.RESET + "Old Diamond Key", ChatColor.GRAY + "Can be used to unlock some doors.", 100, 0, Items.PrismarineCrystals);
	
	public static ItemStack sMassiveDiamond = Items.createShopItem(Material.DIAMOND, ChatColor.RESET + "Super Massive Diamond", ChatColor.GRAY + "Harold's prized possession.", Val.superMassiveDiamond * Val.diamondSM, 1, 0);
	public static ItemStack sDivingHelmet = Items.createShopArmor(Material.CARVED_PUMPKIN, ChatColor.RESET + "Diving Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "Allows you to breathe underwater.", Val.divingHelmet*Val.woodSM, 0, 1, 0, "head");
	
	public static ItemStack sStrengthBoostAbility = Items.createShopAbilityItem("Strength Boost", "Allows you to boost your strength allowing", "you to deal +3 attack damage for a short time.", 100);
	public static ItemStack sExplodeAbility = Items.createShopAbilityItem("Explode", "Allows you to explode, dealing damage", "to all enimies in an 8 block radius.", 1000);
	public static ItemStack sEarthquakeAbility = Items.createShopAbilityItem("Create Earthquake", "Deals damage to all enimies in", " a 5 block radius and throws them into the air.", 10000);
	public static ItemStack sLightningAbility = Items.createShopAbilityItem("Lightning Strike", "Allows you to call down lightning, dealing lots of", "damage to all enimies in an 5 block radius.", 100000);
	public static ItemStack sManaShieldAbility = Items.createShopAbilityItem("Mana Shield", "Allows you to create a mana shield", "giving you some absorption hearts.", 100);
	public static ItemStack sHealAbility = Items.createShopAbilityItem("Heal", "Allows you to convert mana into", "health, healing you.", 1000);
	public static ItemStack sLifeStealAbility = Items.createShopAbilityItem("Life Steal", "Heals you for 30% of the damage you", "deal for a short time.", 10000);
	public static ItemStack sStrengthenArmorAbility = Items.createShopAbilityItem("Strengthen Armor", "Gives you 40% damage resistence for a ", "long period of time.", 100000);
	public static ItemStack sEnergyBoostAbility = Items.createShopAbilityItem("Energy Boost", "Allows you to get an Energy Boost", "making you much faster.", 100);
	public static ItemStack sRejuvenateAbility = Items.createShopAbilityItem("Rejuvenate", "Gives you regen, speed, jump ", "boost, and 250 mana.", 1000);
	public static ItemStack sLeapAbility = Items.createShopAbilityItem("Leap", "Gives you a boost in the direction", " you are facing, and restores some mana.", 10000);

	public static ItemStack sWoodSword = Items.createShopWeapon(Material.WOODEN_SWORD, ChatColor.RESET + "Wooden Sword", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden sword.", Val.wSword * Val.woodSM, 0, 4, -2.5);
	public static ItemStack sWoodKnife = Items.createShopWeapon(Material.WOODEN_SHOVEL, ChatColor.RESET + "Wooden Knife", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden knife.", Val.wKnife * Val.woodSM, 0, 2, -1.25);
	public static ItemStack sWoodBattleaxe = Items.createShopWeapon(Material.WOODEN_AXE, ChatColor.RESET + "Wooden Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden battleaxe.", Val.wBattleaxe * Val.woodSM, 0, 5.2, -3.25);
	public static ItemStack sWoodPickaxe = Items.createShopWeapon(Material.WOODEN_PICKAXE, ChatColor.RESET + "Wooden Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden pickaxe.", Val.wPickaxe * Val.woodSM, 0, 2, -3.0);
	public static ItemStack sWoodShield = Items.createShopShield(DyeColor.BROWN, ChatColor.RESET + "Wooden Shield", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden shield.", Val.wShield * Val.woodSM, 0, 1, 0, "offhand");
	public static ItemStack sWoodHelmet = Items.createShopArmor(Material.CHAINMAIL_HELMET, ChatColor.RESET + "Wooden Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden helmet.", Val.wHelmet * Val.woodSM, 0, 1, 0, "head");
	public static ItemStack sWoodChestplate = Items.createShopArmor(Material.CHAINMAIL_CHESTPLATE, ChatColor.RESET + "Wooden Chestplate", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden chestplate.", Val.wChestplate * Val.woodSM, 0, 3, 0, "chest");
	public static ItemStack sWoodLeggings = Items.createShopArmor(Material.CHAINMAIL_LEGGINGS, ChatColor.RESET + "Wooden Leggings", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden leggings.", Val.wLeggings * Val.woodSM, 0, 2, 0, "legs");
	public static ItemStack sWoodBoots = Items.createShopArmor(Material.CHAINMAIL_BOOTS, ChatColor.RESET + "Wooden Boots", "" + ChatColor.RESET + ChatColor.GRAY + "A plain wooden boots.", Val.wBoots * Val.woodSM, 0, 1, 0, "feet");
	
	public static ItemStack sIronSword = Items.createShopWeapon(Material.IRON_SWORD, ChatColor.RESET + "Iron Sword", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron sword.", Val.iSword * Val.ironSM, 0, 5, -2.3);
	public static ItemStack sIronKnife = Items.createShopWeapon(Material.IRON_SHOVEL, ChatColor.RESET + "Iron Knife", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron knife.", Val.iKnife * Val.ironSM, 0, 2.5, -1.15);
	public static ItemStack sIronBattleaxe = Items.createShopWeapon(Material.IRON_AXE, ChatColor.RESET + "Iron Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron battleaxe.", Val.iBattleaxe * Val.ironSM, 0, 6.5, -2.99);
	public static ItemStack sIronPickaxe = Items.createShopWeapon(Material.IRON_PICKAXE, ChatColor.RESET + "Iron Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron pickaxe.", Val.iPickaxe * Val.ironSM, 0, 3, -2.8);
	public static ItemStack sIronShield = Items.createShopShield(DyeColor.WHITE, ChatColor.RESET + "Iron Shield", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron shield.", Val.iShield * Val.ironSM, 0, 3, 0, "offhand");
	public static ItemStack sIronHelmet = Items.createShopArmor(Material.IRON_HELMET, ChatColor.RESET + "Iron Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron helmet.", Val.iHelmet * Val.ironSM, 0, 2, 0, "head");
	public static ItemStack sIronChestplate = Items.createShopArmor(Material.IRON_CHESTPLATE, ChatColor.RESET + "Iron Chestplate", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron chestplate.", Val.iChestplate * Val.ironSM, 0, 4, 0, "chest");
	public static ItemStack sIronLeggings = Items.createShopArmor(Material.IRON_LEGGINGS, ChatColor.RESET + "Iron Leggings", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron leggings.", Val.iLeggings * Val.ironSM, 0, 3, 0, "legs");
	public static ItemStack sIronBoots = Items.createShopArmor(Material.IRON_BOOTS, ChatColor.RESET + "Iron Boots", "" + ChatColor.RESET + ChatColor.GRAY + "A plain iron boots.", Val.iBoots * Val.ironSM, 0, 2, 0, "feet");
	
	public static ItemStack sGoldSword = Items.createShopWeapon(Material.GOLDEN_SWORD, ChatColor.RESET + "Golden Sword", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gSword * Val.goldSM, 0, 6, -2.1);
	public static ItemStack sGoldKnife = Items.createShopWeapon(Material.GOLDEN_SHOVEL, ChatColor.RESET + "Golden Knife", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gKnife * Val.goldSM, 0, 3, -1.05);
	public static ItemStack sGoldBattleaxe = Items.createShopWeapon(Material.GOLDEN_AXE, ChatColor.RESET + "Golden Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gBattleaxe * Val.goldSM, 0, 7.8, -2.73);
	public static ItemStack sGoldPickaxe = Items.createShopWeapon(Material.GOLDEN_PICKAXE, ChatColor.RESET + "Golden Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gPickaxe * Val.goldSM, 0, 3.5, -2.7);
	public static ItemStack sGoldShield = Items.createShopShield(DyeColor.YELLOW, ChatColor.RESET + "Golden Shield", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gShield * Val.goldSM, 0, 4, 0, "offhand");
	public static ItemStack sGoldHelmet = Items.createShopArmor(Material.GOLDEN_HELMET, ChatColor.RESET + "Golden Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gHelmet * Val.goldSM, 0, 3, 0, "head");
	public static ItemStack sGoldChestplate = Items.createShopArmor(Material.GOLDEN_CHESTPLATE, ChatColor.RESET + "Golden Chestplate", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gChestplate * Val.goldSM, 0, 5, 0, "chest");
	public static ItemStack sGoldLeggings = Items.createShopArmor(Material.GOLDEN_LEGGINGS, ChatColor.RESET + "Golden Leggings", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gLeggings * Val.goldSM, 0, 4, 0, "legs");
	public static ItemStack sGoldBoots = Items.createShopArmor(Material.GOLDEN_BOOTS, ChatColor.RESET + "Golden Boots", "" + ChatColor.RESET + ChatColor.GRAY + "Very shiny.", Val.gBoots * Val.goldSM, 0, 3, 0, "feet");
	
	public static ItemStack sDiamondSword = Items.createShopWeapon(Material.DIAMOND_SWORD, ChatColor.RESET + "Diamond Sword", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dSword * Val.diamondSM, 0, 7, -1.9);
	public static ItemStack sDiamondKnife = Items.createShopWeapon(Material.DIAMOND_SHOVEL, ChatColor.RESET + "Diamond Knife", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dKnife * Val.diamondSM, 0, 3.5, -0.95);
	public static ItemStack sDiamondBattleaxe = Items.createShopWeapon(Material.DIAMOND_AXE, ChatColor.RESET + "Diamond Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dBattleaxe * Val.diamondSM, 0, 9.1, -2.47);
	public static ItemStack sDiamondPickaxe = Items.createShopWeapon(Material.DIAMOND_PICKAXE, ChatColor.RESET + "Diamond Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dPickaxe * Val.diamondSM, 0, 4, -2.6);
	public static ItemStack sDiamondShield = Items.createShopShield(DyeColor.LIGHT_BLUE, ChatColor.RESET + "Diamond Shield", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dShield * Val.diamondSM, 0, 5, 0, "offhand");
	public static ItemStack sDiamondHelmet = Items.createShopArmor(Material.DIAMOND_HELMET, ChatColor.RESET + "Diamond Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dHelmet * Val.diamondSM, 0, 4, 0, "head");
	public static ItemStack sDiamondChestplate = Items.createShopArmor(Material.DIAMOND_CHESTPLATE, ChatColor.RESET + "Diamond Chestplate", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dChestplate * Val.diamondSM, 0, 6, 0, "chest");
	public static ItemStack sDiamondLeggings = Items.createShopArmor(Material.DIAMOND_LEGGINGS, ChatColor.RESET + "Diamond Leggings", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dLeggings * Val.diamondSM, 0, 5, 0, "legs");
	public static ItemStack sDiamondBoots = Items.createShopArmor(Material.DIAMOND_BOOTS, ChatColor.RESET + "Diamond Boots", "" + ChatColor.RESET + ChatColor.GRAY + "Ultra shiny.", Val.dBoots * Val.diamondSM, 0, 4, 0, "feet");
	
	public static ItemStack sMithrilSword = Items.createShopBreakableWeapon(Material.DIAMOND_SWORD, ChatColor.RESET + "Mithril Sword", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mSword * Val.mithrilSM, Val.mithrilDur, 9, -1.4);
	public static ItemStack sMithrilKnife = Items.createShopBreakableWeapon(Material.DIAMOND_SHOVEL, ChatColor.RESET + "Mithril Knife", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mKnife * Val.mithrilSM, Val.mithrilDur, 4.5, -0.7);
	public static ItemStack sMithrilBattleaxe = Items.createShopBreakableWeapon(Material.DIAMOND_AXE, ChatColor.RESET + "Mithril Battleaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mBattleaxe * Val.mithrilSM, Val.mithrilDur, 11.7, -1.82);
	public static ItemStack sMithrilPickaxe = Items.createShopBreakableWeapon(Material.DIAMOND_PICKAXE, ChatColor.RESET + "Mithril Pickaxe", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mPickaxe * Val.mithrilSM, Val.mithrilDur, 4.5, -2.5);
	public static ItemStack sMithrilShield = Items.createShopShield(DyeColor.BLUE, ChatColor.RESET + "Mithril Shield", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mShield * Val.mithrilSM, 0, 6, 1, "offhand");
	public static ItemStack sMithrilHelmet = Items.createShopLeatherArmor(Color.BLUE, Material.LEATHER_HELMET, ChatColor.RESET + "Mithril Helmet", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mHelmet * Val.mithrilSM, 0, 5, 1, "head");
	public static ItemStack sMithrilChestplate = Items.createShopLeatherArmor(Color.BLUE, Material.LEATHER_CHESTPLATE, ChatColor.RESET + "Mithril Chestplate", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mChestplate * Val.mithrilSM, 0, 7, 2, "chest");
	public static ItemStack sMithrilLeggings = Items.createShopLeatherArmor(Color.BLUE, Material.LEATHER_LEGGINGS, ChatColor.RESET + "Mithril Leggings", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mLeggings * Val.mithrilSM, 0, 6, 2, "legs");
	public static ItemStack sMithrilBoots = Items.createShopLeatherArmor(Color.BLUE, Material.LEATHER_BOOTS, ChatColor.RESET + "Mithril Boots", "" + ChatColor.RESET + ChatColor.GRAY + "Thought to be mythical.", Val.mBoots * Val.mithrilSM, 0, 5, 1, "feet");
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
}