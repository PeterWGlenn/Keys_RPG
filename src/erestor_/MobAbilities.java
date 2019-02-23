package erestor_;

import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class MobAbilities {
	
	//Guardian Abilities
	public static void guardianAbilities(Entity a, Entity d, EntityDamageByEntityEvent e) {
		if(a instanceof Guardian && d instanceof Player) {
			Vector vector = a.getLocation().toVector().subtract(d.getLocation().toVector());
			d.setVelocity(vector.multiply(0.3));
			((Damageable) d).damage(Main.getRandom(2000, 1) / 1000);
			((LivingEntity) d).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 1));
			((LivingEntity) d).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 30, 2));
		}
	}	
}