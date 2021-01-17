package com.hoang.ryan.choombah_bot.components;

import javax.annotation.PostConstruct;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hoang.ryan.choombah_bot.components.commands.AboutCommand;
import com.hoang.ryan.choombah_bot.components.commands.GenerateNetworkCommand;

import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;

@Component
public class DiscordBuilder {

	
	DiscordApi api;
	
	final String token;
	
	//@Autowired
	//CommandHandler cmdHandler;
	
	@Autowired
	public DiscordBuilder(@Value("${discord.token}") String token) {
		this.token = token;
	}
	
	@PostConstruct
	public void StartBot() {
		api = new DiscordApiBuilder()
				.setToken(token)
				.login()
				.join();
		
		System.out.println("Invite Link: " + api.createBotInvite());
		
		CommandHandler cmdHandler = new JavacordHandler(api);
		addCommands(cmdHandler);
		
	}
	
	private void addCommands(CommandHandler cmdHandler) {
		cmdHandler.registerCommand(new GenerateNetworkCommand());
		cmdHandler.registerCommand(new AboutCommand());
	}

	private void disposeBot(DiscordApi api) {
		api.disconnect();
	}
}
