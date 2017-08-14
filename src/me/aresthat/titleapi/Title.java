package me.aresthat.titleapi;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.EnumTitleAction;
import net.minecraft.server.v1_8_R1.PacketPlayOutTitle;

public class Title {
	
	private PacketPlayOutTitle title;
	private PacketPlayOutTitle subtitle;
	
	public Title(String text) {
		PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"" + text + "\"}"), 20, 40, 20);
		this.title = title;
	}
	
	public void SubTitle(String text2) {
		PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"" + text2 + "\"}"), 20, 40, 20);
		this.subtitle = subtitle;
	}
	
	public void sendToPlayer(Player p) {
		 ((CraftPlayer)p).getHandle().playerConnection.sendPacket(title);
		 ((CraftPlayer)p).getHandle().playerConnection.sendPacket(subtitle);
	}
	
	public void sendToAll() {
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			 ((CraftPlayer)p).getHandle().playerConnection.sendPacket(title);
			 ((CraftPlayer)p).getHandle().playerConnection.sendPacket(subtitle);
		}
	}
}
