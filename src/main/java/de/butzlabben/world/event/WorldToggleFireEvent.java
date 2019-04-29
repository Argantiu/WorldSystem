package de.butzlabben.world.event;

import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;

import de.butzlabben.world.wrapper.SystemWorld;

/**
 * @author Butzlabben
 * @since 09.05.2018
 */
public class WorldToggleFireEvent extends WorldEvent {
	
	private final SystemWorld world;
	private final CommandSender executor;
	private boolean value;
	
	public WorldToggleFireEvent(CommandSender executor, SystemWorld world, boolean value) {
		this.executor = executor;
		this.world = world;
		this.value = value;
	}
	
	/**
	 * @return if fire now gets enabled or disabled
	 */
	public boolean getValue() {
		return value;
	}
	
	/**
	 * @param val if fire should be enabled or disabled
	 */
	public void setValue(boolean val) {
		value = val;
	}
	
	/**
	 * @return world get world 
	 */
	public SystemWorld getWorld() {
		return world;
	}
	
	/**
	 * @return get executor who toggles fire
	 */
	public CommandSender getExecutor() {
		return executor;
	}
	
	
	
	public final static HandlerList handlers = new HandlerList();
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	@Override
	public final HandlerList getHandlers() {
		return handlers;
	}
}
