package com.hoang.ryan.choombah_bot.components;

import java.util.Optional;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.Channel;
import org.javacord.api.entity.channel.TextChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hoang.ryan.choombah_bot.commands.AboutCommand;
import com.hoang.ryan.choombah_bot.commands.GenerateNetworkCommand;
import com.hoang.ryan.choombah_bot.commands.ScheduleReminder;

import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;

@Component
public class DiscordBuilder {

	@Autowired
	Network network;
	
	DiscordApi discordApi;
	
	final String token;
	
	public DiscordBuilder(String token) {
		this.token = token;
	}
	
	public void startBot() {
		discordApi = new DiscordApiBuilder().setToken(token).login().join();
		System.out.println("Invite Link: " + discordApi.createBotInvite());
		CommandHandler cmdHandler = new JavacordHandler(discordApi);
		addCommands(cmdHandler);
	}
	
	private void addCommands(CommandHandler cmdHandler) {
		cmdHandler.registerCommand(new GenerateNetworkCommand(network));
		cmdHandler.registerCommand(new AboutCommand());
	}

	private void disposeBot(DiscordApi api) {
		api.disconnect();
	}
}
