package me.johnnywoof.bungeecord;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class AOCommand extends Command{
	
	private AlwaysOnline ao;
	
	public AOCommand(AlwaysOnline ao) {
        super("alwaysonline", "alwaysonline.usage", "ao");
        
        this.ao = ao;
        
    }
 
	public void execute(CommandSender sender, String[] args) {
    
		if(args.length <= 0){
			
			this.displayHelp(sender);
			
		}else{
			
			if(args[0].equalsIgnoreCase("toggle")){
				
				AlwaysOnline.mojangonline = !AlwaysOnline.mojangonline;
				
				sender.sendMessage(TextComponent.fromLegacyText(ChatColor.GOLD + "Mojang offline mode is now " + ((!AlwaysOnline.mojangonline ? ChatColor.GREEN + "enabled" : ChatColor.RED + "disabled")) + ChatColor.GOLD + "!"));
				
			}else if(args[0].equalsIgnoreCase("disable")){
				
				ao.disabled = true;
				
				sender.sendMessage(TextComponent.fromLegacyText(ChatColor.GOLD + "AlwaysOnline has been disabled! AlwaysOnline will no longer check to see if the session server is offline."));
				
			}else if(args[0].equalsIgnoreCase("enable")){
				
				ao.disabled = false;
				
				sender.sendMessage(TextComponent.fromLegacyText(ChatColor.GOLD + "AlwaysOnline has been enabled! AlwaysOnline will now check to see if the session server is offline."));
				
			}else if(args[0].equalsIgnoreCase("reload")){
				
				ao.reload();
				
				sender.sendMessage(TextComponent.fromLegacyText(ChatColor.GOLD + "Configuration file has been reloaded!"));
				
			}else{
				
				this.displayHelp(sender);
				
			}
			
		}
    	
    }
	
	private void displayHelp(CommandSender sender){
		
		sender.sendMessage(TextComponent.fromLegacyText(ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "----------" + ChatColor.GOLD + "[" + ChatColor.DARK_GREEN + "AlwaysOnline " + ChatColor.GRAY + ao.getDescription().getVersion() + "" + ChatColor.GOLD + "]" + ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "----------"));
		
		sender.sendMessage(TextComponent.fromLegacyText(ChatColor.GOLD + "/alwaysonline toggle - " + ChatColor.DARK_GREEN + "Toggles between mojang online mode"));
		sender.sendMessage(TextComponent.fromLegacyText(ChatColor.GOLD + "/alwaysonline enable - " + ChatColor.DARK_GREEN + "Enables the plugin"));
		sender.sendMessage(TextComponent.fromLegacyText(ChatColor.GOLD + "/alwaysonline disable - " + ChatColor.DARK_GREEN + "Disables the plugin"));
		sender.sendMessage(TextComponent.fromLegacyText(ChatColor.GOLD + "/alwaysonline reload - " + ChatColor.DARK_GREEN + "Reloads the configuration file"));
		
		sender.sendMessage(TextComponent.fromLegacyText(ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "------------------------------"));
		
	}
	
}
