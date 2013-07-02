package org.mcsg.survivalgames.commands;

import org.bukkit.entity.Player;
import org.mcsg.survivalgames.MessageManager;

public class Sponsor implements SubCommand {

	MessageManager msgmgr = MessageManager.getInstance();

	@Override
	public boolean onCommand(Player player, String[] args) {
		return true;
	}

	@Override
	public String help(Player p) {
		return "/sg sponsor <player> <itemid> <amount> - Sponsor a player!";
	}

	@Override
	public String permission() {
		return "sg.player.sponsor";
	}
}