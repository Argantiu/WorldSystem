package de.butzlabben.event;

import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;

import de.butzlabben.world.wrapper.SystemWorld;

public class WorldDeleteEvent extends WorldEvent {
	
	private final SystemWorld world;
	private final CommandSender executor;
	
	public WorldDeleteEvent(CommandSender executor, SystemWorld world) {
		this.executor = executor;
		this.world = world;
	}
	
	public SystemWorld getWorld() {
		return world;
	}
	
	public CommandSender getExecutor() {
		return executor;
	}
	
	
	
	public final static HandlerList handlers = new HandlerList();
	
	public final static HandlerList getHandlerList() {
		return handlers;
	}
	
	@Override
	public final HandlerList getHandlers() {
		return handlers;
	}

}
