package de.butzlabben.inventory;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.butzlabben.world.wrapper.WorldPlayer;

public interface DependListener {
	
	ItemStack getItemStack(Player p, WorldPlayer wp);

}
