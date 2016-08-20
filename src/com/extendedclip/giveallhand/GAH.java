package com.extendedclip.giveallhand;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class GAH extends JavaPlugin implements CommandExecutor {

	@Override
	public void onEnable() {
		getCommand("gah").setExecutor(this);
		loadConfig();
	}
	
	private void loadConfig() {
		FileConfiguration c = getConfig();
		c.options().header("GAH v " + getDescription().getVersion()
				+ "\nCreated by extended_clip");
		c.addDefault("message", "&c%Player% &7has Given Everyone: &c%items name%");
		saveConfig();
		reloadConfig();
	}
	
	public void sms(CommandSender p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
	
	@Override
	public boolean onCommand(CommandSender s, Command c, String label, String[] args) {
		
		if (!(s instanceof Player)) {
			sms(s, "&cYou must be a player to use this command!");
			return true;
		}
		
		Player p = (Player) s;
		
		if (!p.hasPermission("gah.give")) {
			sms(s, "&cYou don't have permission to do that!");
			return true;
		}
		
		@SuppressWarnings("deprecation")
		ItemStack i = p.getInventory().getItemInHand();
		
		if (i == null) {
			sms(s, "&cYou don't have an item in your hand to give!");
			return true;
		}
		
		if (args.length > 0) {
			//finish this cuz im lazy
		}
		
		return true;
	}
}
