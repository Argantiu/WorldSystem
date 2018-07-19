package de.butzlabben.world.wrapper;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.WorldCreator;
import org.bukkit.block.Block;

import com.boydti.fawe.bukkit.wrapper.AsyncWorld;
import com.boydti.fawe.util.TaskManager;

/**
 * @author Butzlabben
 * @since 08.06.2018
 */
public class AsyncCreatorAdapter implements CreatorAdapter {

	// Create worlds async to close #16
	@Override
	public void create(WorldCreator creator, SystemWorld sw, Runnable r) {
		TaskManager.IMP.async(new Runnable() {
			@Override
			public void run() {
				AsyncWorld world;
				if (Bukkit.getWorld(creator.name()) == null)
					world = AsyncWorld.create(creator);
				else
					world = AsyncWorld.wrap(Bukkit.getWorld(creator.name()));

				Block block = world.getBlockAt(0, 0, 0);
				block.setType(Material.BEDROCK);
				
				// When you are done
				world.commit();
				Bukkit.getWorlds().add(world);
				if (sw != null)
					sw.setCreating(false);
				
				// Send the play the message
				r.run();
			}
		});
		return;
	}

}
