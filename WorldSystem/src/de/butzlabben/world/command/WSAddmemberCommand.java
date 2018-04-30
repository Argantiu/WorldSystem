package de.butzlabben.world.command;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.butzlabben.world.WorldSystem;
import de.butzlabben.world.config.DependenceConfig;
import de.butzlabben.world.config.MessageConfig;
import de.butzlabben.world.config.WorldConfig2;

public class WSAddmemberCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (!(cs instanceof Player))
			return true;
		Player p = (Player) cs;
		if(args.length != 2) {
			p.sendMessage(MessageConfig.getWrongUsage().replaceAll("%usage", WorldSystem.getInstance().getCommand("ws addmember").getUsage()));
			return true;
			
		}
		DependenceConfig dc = new DependenceConfig(p);
		if (!dc.hasWorld()) {
			p.sendMessage(MessageConfig.getNoWorldOwn());
			return true;
		}
		@SuppressWarnings("deprecation")
		OfflinePlayer a = Bukkit.getOfflinePlayer(args[1]);
		if (a == null) {
			p.sendMessage(MessageConfig.getNotRegistered());
			return true;
		} else if (WorldConfig2.isMember(a, new DependenceConfig(p).getWorldname())) {
			p.sendMessage(MessageConfig.getAlreadyMember());
			return true;
		}
		WorldConfig2.addMember(p, a);
		p.sendMessage(MessageConfig.getMemberAdded().replaceAll("%player", a.getName()));
		return true;
	}
}
