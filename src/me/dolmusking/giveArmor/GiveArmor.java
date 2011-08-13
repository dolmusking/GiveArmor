package me.dolmusking.giveArmor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import org.bukkit.plugin.Plugin;

public class GiveArmor extends JavaPlugin {
	
	public static PermissionHandler permissionHandler;

	@Override
	public void onDisable() {
		
		System.out.println( "[GiveArmor] v0.2 disabled!" );
		
	}

	@Override
	public void onEnable() {
		
		setupPermissions();
		System.out.println( "[GiveArmor] v0.2 enabled!" );
		
	}
	
	private void setupPermissions() {
		if (permissionHandler != null) {
			return;
		}
		Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");

		if (permissionsPlugin == null) {
			System.out.println( "[GiveArmor] Permission system not detected, defaulting to OP" );
		    return;
		}

		permissionHandler = ((Permissions) permissionsPlugin).getHandler();
		System.out.println("[GiveArmor] Found and will use plugin "+((Permissions)permissionsPlugin).getDescription().getFullName());
	}

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		boolean succeed=false;
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			
			// Konsolenbefehl "/ga"
			if( cmd.getName().equalsIgnoreCase( "ga" ) ) {
				
				if (!GiveArmor.permissionHandler.has( player, "ga.armor.give" )) {
					player.sendMessage(ChatColor.RED + "You do not have the permissions to do that!");
			        return true;
			    }
				
				if(!(args.length == 0) && !(args.length == 1)) {
					player.sendMessage( ChatColor.RED + "[GiveArmor] usage: /ga [dia/gold/iron/leather/chain]" );
					return true;
				}
				
				if ( args.length == 0 ) {
					player.sendMessage( ChatColor.RED + "[GiveArmor] usage: /ga [dia/gold/iron/leather/chain]" );
					succeed = true;
				}
				if ( args.length == 1 ) {
					if (args[0].equalsIgnoreCase( "dia" ) || args[0].equalsIgnoreCase( "diamond" )) {
						player.getInventory().setHelmet(new ItemStack(310, 1));		
						player.getInventory().setChestplate(new ItemStack(311, 1));
						player.getInventory().setLeggings(new ItemStack(312, 1));
						player.getInventory().setBoots(new ItemStack(313, 1));
						player.sendMessage( ChatColor.BLUE + "[GiveArmor] " + ChatColor.GREEN + "Diamond" + ChatColor.BLUE + " Armor given!" );
						succeed = true;
					}
					
					if ( args[0].equalsIgnoreCase( "gold" ) ) {
						player.getInventory().setHelmet(new ItemStack(314, 1));		
						player.getInventory().setChestplate(new ItemStack(315, 1));
						player.getInventory().setLeggings(new ItemStack(316, 1));
						player.getInventory().setBoots(new ItemStack(317, 1));
						player.sendMessage (ChatColor.BLUE + "[GiveArmor] " + ChatColor.GREEN + "Gold" + ChatColor.BLUE + " Armor given!" );
						succeed = true;
					}
					
					if ( args[0].equalsIgnoreCase( "iron" ) ) {
						player.getInventory().setHelmet(new ItemStack(306, 1));		
						player.getInventory().setChestplate(new ItemStack(307, 1));
						player.getInventory().setLeggings(new ItemStack(308, 1));
						player.getInventory().setBoots(new ItemStack(309, 1));
						player.sendMessage( ChatColor.BLUE + "[GiveArmor] " + ChatColor.GREEN + "Iron" + ChatColor.BLUE + " Armor given!" );
						succeed = true;
					}
					
					if ( args[0].equalsIgnoreCase( "leather" ) ) {
						player.getInventory().setHelmet(new ItemStack(298, 1));		
						player.getInventory().setChestplate(new ItemStack(299, 1));
						player.getInventory().setLeggings(new ItemStack(300, 1));
						player.getInventory().setBoots(new ItemStack(301, 1));
						player.sendMessage( ChatColor.BLUE + "[GiveArmor] " + ChatColor.GREEN + "Leather" + ChatColor.BLUE + " Armor given!" );
						succeed = true;
					}
					
					if ( args[0].equalsIgnoreCase( "chain" ) ) {
						player.getInventory().setHelmet(new ItemStack(302, 1));		
						player.getInventory().setChestplate(new ItemStack(303, 1));
						player.getInventory().setLeggings(new ItemStack(304, 1));
						player.getInventory().setBoots(new ItemStack(305, 1));
						player.sendMessage( ChatColor.BLUE + "[GiveArmor] " + ChatColor.GREEN + "Chain" + ChatColor.BLUE + " Armor given!" );
						succeed = true;
					}
				}
			}
			
			// Konsolenbefehl "/gato"
			if(cmd.getName().equalsIgnoreCase( "gato" )) {
				
				if (!GiveArmor.permissionHandler.has( player, "ga.armor.giveto" )) {
					player.sendMessage( ChatColor.RED + "You do not have the permissions to do that!" );
			        return true;
			    }
				
				if(!( args.length == 1 ) && !( args.length == 2) ) {
					player.sendMessage( ChatColor.RED + "[GiveArmor] usage: /gato [dia/gold/iron/leather/chain] <Player>" );
					return true;
				}
				
				if ( args.length == 1 ) {
					player.sendMessage( ChatColor.RED + "[GiveArmor] usage: /gato [dia/gold/iron/leather/chain] <Player>" );
					succeed = true;
				}
				
				if ( args.length == 2 ) {
					Player target = Bukkit.getServer().getPlayer( args[1] );
					if ( !(target == null) ) {
						
						if (args[0].equalsIgnoreCase( "dia" ) || args[0].equalsIgnoreCase( "diamond" )) {
							target.getInventory().setHelmet(new ItemStack(310, 1));		
							target.getInventory().setChestplate(new ItemStack(311, 1));
							target.getInventory().setLeggings(new ItemStack(312, 1));
							target.getInventory().setBoots(new ItemStack(313, 1));
							player.sendMessage( ChatColor.BLUE + "[GiveArmor] " + ChatColor.GREEN + "Diamond" + ChatColor.BLUE + " Armor given to " + ChatColor.GREEN + args[1] + ChatColor.BLUE + "!" );
							target.sendMessage( ChatColor.BLUE + "[GiveArmor] Got " + ChatColor.GREEN + "Diamond" + ChatColor.BLUE + " Armor!" );
							succeed = true;
						}
						
						if ( args[0].equalsIgnoreCase( "gold" ) ) {
							target.getInventory().setHelmet(new ItemStack(314, 1));		
							target.getInventory().setChestplate(new ItemStack(315, 1));
							target.getInventory().setLeggings(new ItemStack(316, 1));
							player.sendMessage( ChatColor.BLUE + "[GiveArmor] " + ChatColor.GREEN + "Gold" + ChatColor.BLUE + " Armor given to " + ChatColor.GREEN + args[1] + ChatColor.BLUE + "!" );
							target.sendMessage( ChatColor.BLUE + "[GiveArmor] Got " + ChatColor.GREEN + "Gold" + ChatColor.BLUE + " Armor!" );
							succeed = true;
						}
						
						if ( args[0].equalsIgnoreCase( "iron" ) ) {
							target.getInventory().setHelmet(new ItemStack(306, 1));		
							target.getInventory().setChestplate(new ItemStack(307, 1));
							target.getInventory().setLeggings(new ItemStack(308, 1));
							target.getInventory().setBoots(new ItemStack(309, 1));
							player.sendMessage( ChatColor.BLUE + "[GiveArmor] " + ChatColor.GREEN + "Iron" + ChatColor.BLUE + " Armor given to " + ChatColor.GREEN + args[1] + ChatColor.BLUE + "!" );
							target.sendMessage( ChatColor.BLUE + "[GiveArmor] Got " + ChatColor.GREEN + "Iron" + ChatColor.BLUE + " Armor!" );
							succeed = true;
						}
						
						if ( args[0].equalsIgnoreCase( "leather" ) ) {
							target.getInventory().setHelmet(new ItemStack(298, 1));		
							target.getInventory().setChestplate(new ItemStack(299, 1));
							target.getInventory().setLeggings(new ItemStack(300, 1));
							target.getInventory().setBoots(new ItemStack(301, 1));
							player.sendMessage( ChatColor.BLUE + "[GiveArmor] " + ChatColor.GREEN + "Leather" + ChatColor.BLUE + " Armor given to " + ChatColor.GREEN + args[1] + ChatColor.BLUE + "!" );
							target.sendMessage( ChatColor.BLUE + "[GiveArmor] Got " + ChatColor.GREEN + "Leather" + ChatColor.BLUE + " Armor!" );
							succeed = true;
						}
						
						if ( args[0].equalsIgnoreCase( "chain" ) ) {
							target.getInventory().setHelmet(new ItemStack(302, 1));		
							target.getInventory().setChestplate(new ItemStack(303, 1));
							target.getInventory().setLeggings(new ItemStack(304, 1));
							target.getInventory().setBoots(new ItemStack(305, 1));
							player.sendMessage( ChatColor.BLUE + "[GiveArmor] " + ChatColor.GREEN + "Chain" + ChatColor.BLUE + " Armor given to " + ChatColor.GREEN + args[1] + ChatColor.BLUE + "!" );
							target.sendMessage( ChatColor.BLUE + "[GiveArmor] Got " + ChatColor.GREEN + "Chain" + ChatColor.BLUE + " Armor!" );
							succeed = true;
						}
						
					} else {
						player.sendMessage( ChatColor.RED + "[GiveArmor] You need to enter a Playername!");
						succeed = true;
					}
				}
				
			}
			
			// Konsolenbefehl "..."
			
		}
		
		return succeed;
	}
}
