package erestor_;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Sell {
	
	public static void sellMethod(ItemStack item, int amount, Player p, InventoryClickEvent e) {
		
		if(e.getInventory().getName().contains("Shop") && !e.getCurrentItem().getType().equals(Material.AIR)) {
		if(!(e.getCurrentItem().equals(null))) {
	    if(e.getCurrentItem().getItemMeta().getDisplayName() != null) {
		if(e.getCurrentItem().getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName()) && e.getCurrentItem().getItemMeta().getLore().equals(item.getItemMeta().getLore())) {
		int itemAmount = e.getCurrentItem().getAmount();
		
			// SellStack
			if(e.isShiftClick() && itemAmount > 1) {
			
			p.giveExpLevels(amount * itemAmount);
			
			for (int i = 0; i < itemAmount; i++) {
			p.getInventory().removeItem(item);
			}
			
			} else {
		    // Sell
			p.giveExpLevels(amount);
			
			if(e.getCurrentItem().getAmount() > 1) {
			p.getInventory().removeItem(item);
			} else {
			int slot = e.getSlot();
			p.getInventory().setItem(slot, new ItemStack(Material.AIR));
			}
			}
			
			p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 1); 
		}
		}
	    e.setCancelled(true);
		}
		} 	
	}
	
	public static void sell(Player p, InventoryClickEvent e) {
		if(e.isRightClick()) {
		// Ore
		Sell.sellMethod(Items.Coal, Val.coalVal, p, e);
		Sell.sellMethod(Items.Magma, Val.magmaVal, p, e);
		Sell.sellMethod(Items.Stick, Val.stickVal, p, e);
		Sell.sellMethod(Items.CobbleStone, Val.cobbleStoneVal, p, e);
		Sell.sellMethod(Items.IronOre, Val.ironOreVal, p, e);
		Sell.sellMethod(Items.GoldOre, Val.goldOreVal, p, e);
		Sell.sellMethod(Items.DiamondOre, Val.diamondOreVal, p, e);
		Sell.sellMethod(Items.MithrilOre, Val.mithrilOreVal, p, e);
		Sell.sellMethod(Items.AdamantiteOre, Val.adamantiteOreVal, p, e);
		Sell.sellMethod(Items.VoidOre, Val.voidOreVal, p, e);
		Sell.sellMethod(Items.Sapphire, Val.sapphireVal, p, e);
		Sell.sellMethod(Items.Ruby, Val.rubyVal, p, e);
		Sell.sellMethod(Items.Emerald, Val.emeraldVal, p, e);
		Sell.sellMethod(Items.PrismarineCrystals, Val.prismarineCrystalsVal, p, e);
		// Ingot
		Sell.sellMethod(Items.Wood, Val.woodVal, p, e);
		Sell.sellMethod(Items.Stone, Val.stoneVal, p, e);
		Sell.sellMethod(Items.IronIngot, Val.ironIngotVal, p, e);
		Sell.sellMethod(Items.GoldIngot, Val.goldIngotVal, p, e);
		Sell.sellMethod(Items.Diamond, Val.diamondVal, p, e);
		Sell.sellMethod(Items.MithrilIngot, Val.mithrilIngotVal, p, e);
		Sell.sellMethod(Items.AdamantiteIngot, Val.adamantiteIngotVal, p, e);
		Sell.sellMethod(Items.VoidGem, Val.voidGemVal, p, e);
		// Food
		Sell.sellMethod(Items.Steak, Val.steak, p, e);
		Sell.sellMethod(Items.Porkchop, Val.porkchop, p, e);
		Sell.sellMethod(Items.Chicken, Val.chicken, p, e);
		Sell.sellMethod(Items.Mutton, Val.mutton, p, e);
		Sell.sellMethod(Items.Bread, Val.bread, p, e);
		Sell.sellMethod(Items.Cookies, Val.cookies, p, e);
		Sell.sellMethod(Items.Pie, Val.pumpkinPie, p, e);
		Sell.sellMethod(Items.Fish, Val.fish, p, e);
		Sell.sellMethod(Items.Salmon, Val.salmon, p, e);
		Sell.sellMethod(Items.Clownfish, Val.clownfish, p, e);
		// Misc
		Sell.sellMethod(Items.StarterBook, 50, p, e);
		Sell.sellMethod(Items.torch, Val.torch, p, e);
		Sell.sellMethod(Items.MassiveDiamond, Val.superMassiveDiamond, p, e);
		Sell.sellMethod(Items.divingHelmet, Val.divingHelmet, p, e);
		// Potion
		Sell.sellMethod(Items.EmptyBottle, Val.emptyBottle, p, e);
		Sell.sellMethod(Items.WaterBottle, Val.waterBottle, p, e);
		Sell.sellMethod(Items.NightVisionPotion, Val.nightVisionPotion, p, e);
		Sell.sellMethod(Items.WaterBreathingPotion, Val.waterBreathingPotion, p, e);
		// Keys
		Sell.sellMethod(Items.IronKey, 20, p, e);
		Sell.sellMethod(Items.StrangeIronKey, 10, p, e);
		Sell.sellMethod(Items.RustedIronKey, 50, p, e);
		Sell.sellMethod(Items.GoldKey, 100, p, e);
		Sell.sellMethod(Items.StrangeGoldKey, 80, p, e);
		Sell.sellMethod(Items.CityKey, 100000, p, e);
		//Sell.sellMethod(Items.OldDiamondKey, 20000, p, e);
		Sell.sellMethod(Items.DiamondKey, 200000, p, e);
		// WoodItems
		Sell.sellMethod(Items.WoodSword, Val.wSword, p, e);
		Sell.sellMethod(Items.WoodKnife, Val.wKnife, p, e);
		Sell.sellMethod(Items.WoodBattleaxe, Val.wBattleaxe, p, e);
		Sell.sellMethod(Items.WoodPickaxe, Val.wPickaxe, p, e);
		Sell.sellMethod(Items.WoodShield, Val.wShield, p, e);
		Sell.sellMethod(Items.WoodHelmet, Val.wHelmet, p, e);
		Sell.sellMethod(Items.WoodChestplate, Val.wChestplate, p, e);
		Sell.sellMethod(Items.WoodLeggings, Val.wLeggings, p, e);
		Sell.sellMethod(Items.WoodBoots, Val.wBoots, p, e);
		// StoneItems
		Sell.sellMethod(Items.StoneSword, Val.sSword, p, e);
		Sell.sellMethod(Items.StoneKnife, Val.sKnife, p, e);
		Sell.sellMethod(Items.StoneBattleaxe, Val.sBattleaxe, p, e);
		Sell.sellMethod(Items.StonePickaxe, Val.sPickaxe, p, e);
		Sell.sellMethod(Items.StoneShield, Val.sShield, p, e);
		// IronItems
		Sell.sellMethod(Items.IronSword, Val.iSword, p, e);
		Sell.sellMethod(Items.IronKnife, Val.iKnife, p, e);
		Sell.sellMethod(Items.IronBattleaxe, Val.iBattleaxe, p, e);
		Sell.sellMethod(Items.IronPickaxe, Val.iPickaxe, p, e);
		Sell.sellMethod(Items.IronShield, Val.iShield, p, e);
		Sell.sellMethod(Items.IronHelmet, Val.iHelmet, p, e);
		Sell.sellMethod(Items.IronChestplate, Val.iChestplate, p, e);
		Sell.sellMethod(Items.IronLeggings, Val.iLeggings, p, e);
		Sell.sellMethod(Items.IronBoots, Val.iBoots, p, e);
		// GoldItems
		Sell.sellMethod(Items.GoldSword, Val.gSword, p, e);
		Sell.sellMethod(Items.GoldKnife, Val.gKnife, p, e);
		Sell.sellMethod(Items.GoldBattleaxe, Val.gBattleaxe, p, e);
		Sell.sellMethod(Items.GoldPickaxe, Val.gPickaxe, p, e);
		Sell.sellMethod(Items.GoldShield, Val.gShield, p, e);
		Sell.sellMethod(Items.GoldHelmet, Val.gHelmet, p, e);
		Sell.sellMethod(Items.GoldChestplate, Val.gChestplate, p, e);
		Sell.sellMethod(Items.GoldLeggings, Val.gLeggings, p, e);
		Sell.sellMethod(Items.GoldBoots, Val.gBoots, p, e);
		// DiamondItems
		Sell.sellMethod(Items.DiamondSword, Val.dSword, p, e);
		Sell.sellMethod(Items.DiamondKnife, Val.dKnife, p, e);
		Sell.sellMethod(Items.DiamondBattleaxe, Val.dBattleaxe, p, e);
		Sell.sellMethod(Items.DiamondPickaxe, Val.dPickaxe, p, e);
		Sell.sellMethod(Items.DiamondShield, Val.dShield, p, e);
		Sell.sellMethod(Items.DiamondHelmet, Val.dHelmet, p, e);
		Sell.sellMethod(Items.DiamondChestplate, Val.dChestplate, p, e);
		Sell.sellMethod(Items.DiamondLeggings, Val.dLeggings, p, e);
		Sell.sellMethod(Items.DiamondBoots, Val.dBoots, p, e);
		// MithrilItems
		Sell.sellMethod(Items.MithrilSword, Val.mSword, p, e);
		Sell.sellMethod(Items.MithrilKnife, Val.mKnife, p, e);
		Sell.sellMethod(Items.MithrilBattleaxe, Val.mBattleaxe, p, e);
		Sell.sellMethod(Items.MithrilPickaxe, Val.mPickaxe, p, e);
		Sell.sellMethod(Items.MithrilShield, Val.mShield, p, e);
		Sell.sellMethod(Items.MithrilHelmet, Val.mHelmet, p, e);
		Sell.sellMethod(Items.MithrilChestplate, Val.mChestplate, p, e);
		Sell.sellMethod(Items.MithrilLeggings, Val.mLeggings, p, e);
		Sell.sellMethod(Items.MithrilBoots, Val.mBoots, p, e);
		// AdamantiteItems
		Sell.sellMethod(Items.AdamantiteSword, Val.aSword, p, e);
		Sell.sellMethod(Items.AdamantiteKnife, Val.aKnife, p, e);
		Sell.sellMethod(Items.AdamantiteBattleaxe, Val.aBattleaxe, p, e);
		Sell.sellMethod(Items.AdamantitePickaxe, Val.aPickaxe, p, e);
		Sell.sellMethod(Items.AdamantiteShield, Val.aShield, p, e);
		Sell.sellMethod(Items.AdamantiteHelmet, Val.aHelmet, p, e);
		Sell.sellMethod(Items.AdamantiteChestplate, Val.aChestplate, p, e);
		Sell.sellMethod(Items.AdamantiteLeggings, Val.aLeggings, p, e);
		Sell.sellMethod(Items.AdamantiteBoots, Val.aBoots, p, e);
		// VoidItems
		Sell.sellMethod(Items.VoidSword, Val.vSword, p, e);
		Sell.sellMethod(Items.VoidKnife, Val.vKnife, p, e);
		Sell.sellMethod(Items.VoidBattleaxe, Val.vBattleaxe, p, e);
		Sell.sellMethod(Items.VoidPickaxe, Val.vPickaxe, p, e);
		Sell.sellMethod(Items.VoidShield, Val.vShield, p, e);
		Sell.sellMethod(Items.VoidHelmet, Val.vHelmet, p, e);
		Sell.sellMethod(Items.VoidChestplate, Val.vChestplate, p, e);
		Sell.sellMethod(Items.VoidLeggings, Val.vLeggings, p, e);
		Sell.sellMethod(Items.VoidBoots, Val.vBoots, p, e);
	}
	}
}