package org.mcsg.survivalgames.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.mcsg.survivalgames.Game;
import org.mcsg.survivalgames.GameManager;
import org.mcsg.survivalgames.MessageManager;
import org.mcsg.survivalgames.SettingsManager;

public class Arenas implements SubCommand {

	public boolean onCommand(Player player, String[] args) {
		if (!player.hasPermission(permission()) && !player.isOp()) {
			MessageManager.getInstance().sendFMessage(MessageManager.PrefixType.ERROR, "error.nopermission", player);
			return true;
		}

		String arenas = ChatColor.DARK_GRAY + "Arenas: " + ChatColor.GRAY;
		for (Game g : GameManager.getInstance().getGames()) {
			arenas += g.getName() + "(" + g.getID() + ")" + ", ";
		}
		if (arenas.endsWith(", ")) {
			arenas = arenas.substring(0, arenas.length() - 2);
		}
		player.sendMessage(arenas);
		return true;
	}

	@Override
	public String help(Player p) {
		return "/sg arenas - "
				+ SettingsManager.getInstance().getMessageConfig().getString("messages.help.arenas", "List all existing arenas.");
	}

	@Override
	public String permission() {
		return "sg.player.arenas";
	}
}
