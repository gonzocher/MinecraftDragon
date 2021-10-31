//This is code for Jack.  Dragon will drop 5 scales (can't be done?) Make a recipe for diamond elytra (can fly and have protection of armor)  Replace Main.java

package com.mathmaniarobotics.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.org.apache.http.util.EntityUtils;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class Main extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		System.out.println("Dragon is Enabled -main");
		Bukkit.getPluginManager().registerEvents(this, this);
		//Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), 101, 72, -12), EntityType.ARMOR_STAND); 
		//Bukkit.getWorld("world").dropItemNaturally(new Location(Bukkit.getWorld("world"), 101, 71, -12), new ItemStack(Material.FEATHER,1));
	}
	
	@Override
	public void onDisable() {
		System.out.println("Dragon is Disabled");
		//set glowing to false for example 
	}
	
	 @EventHandler
	 public void onMove(PlayerMoveEvent e) { 
		 Player player = e.getPlayer();
		 player.setGlowing(false); 
	 }
	 
	 @EventHandler // if chicken..spawn dragon scale on top of armor stand.  then make it hide so it looks floating
	 public void onKillChicken(EntityDeathEvent e) {
		 if (e != null) {
			 Location trophyRoomLocation = new Location(Bukkit.getWorld("world"), 102, 73, -12);
			 Entity dead = e.getEntity();
			 if (dead.equals(EntityType.CHICKEN)) {
				Location deadLocation = dead.getLocation();
				Entity killer = e.getEntity().getKiller();
				killer.sendMessage("You now have 1 kill! Your reward is 5 golden apples!");
				Bukkit.getWorld("world").dropItemNaturally(deadLocation, new ItemStack(Material.GOLDEN_APPLE,5));
				
				ArmorStand armorStand = (ArmorStand)
				Bukkit.getWorld("world").spawnEntity(trophyRoomLocation, EntityType.ARMOR_STAND);
				armorStand.setVisible(true);
			 }
			 
		 }
		}
	 
//	 @EventHandler
//	 public void onDropItem(ItemDropEvent event) {
//		 Location loc = event.getItem().getLocation();
//			 if (event.getItem().getType().equals(Material.FEATHER)) {
//			 event.getItem().getDrops().clear();
//			 loc.getWorld().dropItem(loc, new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
//		}
//	}
	 
//	@EventHandler
//	public void onSneak(PlayerToggleSneakEvent e) {
//		if (e.isSneaking()) {
//			Player p = e.getPlayer();
//			if (p.getInventory().isEmpty()) {
//				p.sendMessage("You will rise, " + p.getName());
//			    p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 60, 1));
//			    p.setGlowing(true);
//	        }
//		}	
//	}
	
	
}