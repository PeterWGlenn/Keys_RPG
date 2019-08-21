package erestor_;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerAnimationType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.event.entity.EntityDeathEvent;

public class Events implements Listener {
	
	@EventHandler
	public void interactEvent(PlayerInteractEvent e){
	Action a = e.getAction();
    Player p = e.getPlayer();
    Block b = e.getClickedBlock();
    
    Abilities.useAbility(p, a);
    ProtDurability.protIllegalFuntionBlocks(e);
    Mining.torchManager(b, p, a);
    PlayerManager.inCombatPressurePlateProt(p,e);
    
    if(!a.equals(Action.PHYSICAL) && e.getHand().equals(EquipmentSlot.HAND)) {
    	Doors.rightClickDoor(p, b, a);
    	Chests.OpenChest(e, p, b, a);
    	PlayerManager.setBedSpawn(p, a, b, e);
    	Shops.spawnShops(p, a);
    	Groups.groups(p, b, a);
    	Potion.fillBottle(p,a,b);
    	Mining.mineMakerUtil(p, a);
    }
	}
	
	// SIMULATE LEFT CLICK BLOCK
	@EventHandler
	public void animationEvent(PlayerAnimationEvent e){
		
	Set<Material> hashSet = new HashSet<Material>();
	hashSet.add(Material.AIR);
	hashSet.add(Material.WATER);
		
	PlayerAnimationType a = e.getAnimationType();
    Player p = e.getPlayer();
    Block b = p.getTargetBlock(hashSet, 4);
    
    if(a.equals(PlayerAnimationType.ARM_SWING)) {
    	Mining.Mine(p, b, Action.LEFT_CLICK_BLOCK);
    }
	}
	
	@EventHandler
	public void onEntityInteract(EntityInteractEvent e) {
	Entity entity = e.getEntity();
		
	PlayerManager.onMobStepPressurePlate(entity, e);
	}
	
	@EventHandler
	public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
	Entity e = event.getRightClicked();
	  
	Shops.shopOpen(e, event);
	}
	
	@EventHandler
	public void EntityDamageByEntity(EntityDamageByEntityEvent event) {
	Entity e = event.getEntity();
	Entity a = event.getDamager();
	
	Shops.protShops(e, a, event);
	Groups.groupBonuses(a, e, event);
	MobAbilities.guardianAbilities(a, e, event);
	PlayerManager.onHitMana(a, e);
	Abilities.lifeStealMethod(a, e, event);
	ProtDurability.protDurability(a);
	ProtDurability.protDurability(e);
	
	// In Combat System
	if(e instanceof Player) {
		PlayerManager.inCombat((Player) e);
	}
	if(a instanceof Player) {
		PlayerManager.inCombat((Player) a);
	}
	}
	
	@EventHandler
	public void EntityDeathEvent(EntityDeathEvent event) {
	Entity killed = event.getEntity();

	Drops.dropsFunction(killed);
	}
	
	@EventHandler 
    public void InventoryClick(InventoryClickEvent e){
	if(e.getSlotType().equals(SlotType.OUTSIDE)) return;
		
    Player p = (Player) e.getWhoClicked(); 
    
    Crafting.furnaceInvHandler(p, e);
    Crafting.knowledgeBook(p, e);
    Sell.sell(p, e);
    Shops.buy(p, e);
    Enchanting.EnchantInvClickHandler(p, e);
    PlayerManager.goldBag(p, e);
    Groups.groupItemProt(p, e);
    PlayerManager.manaItemProt(p, e);
    PlayerManager.abilityItemProt(p, e);

	}
	
	@EventHandler 
    public void PlayerJoin(PlayerJoinEvent e){
    Player p = e.getPlayer();
    
    PlayerManager.onPlayerJoin(p);
	}
	
	@EventHandler 
    public void PlayerDeath(PlayerDeathEvent e){
    Player p = (Player) e.getEntity();
    
    //PlayerManager.playerKeepInv(p, e);
    KeepInventory.playerKeepInv(p, e);
	}
	
	@EventHandler 
    public void PlayerMove(PlayerMoveEvent e){
    Player p = e.getPlayer();
    
    PlayerManager.antiClimb(p, e);
	}
	
	@EventHandler 
    public void PlayerConsumeItem(PlayerItemConsumeEvent e){
    Player p = e.getPlayer();
    
    Potion.drinkPotion(p, e);
	}

	@EventHandler 
    public void itemPickupEvent(EntityPickupItemEvent e){
	
		if(e.getEntity() instanceof Player) {
			PlayerManager.goldConverter((Player) e.getEntity());
		}
	}

	@EventHandler
	public void chunkLoadEvent(ChunkLoadEvent event) {
		
	Mining.antiGhostTorch(event);
	}
}