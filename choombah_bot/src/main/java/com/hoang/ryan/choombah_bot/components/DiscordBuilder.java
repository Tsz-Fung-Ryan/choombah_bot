package com.hoang.ryan.choombah_bot.components;

import javax.annotation.PostConstruct;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.hoang.ryan.choombah_bot.components.commands.TestCommand;

import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;

@Component
public class DiscordBuilder {

	
	DiscordApi api;
	
	final String token;
	
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
		
		System.out.println("Bot is running");
		
		System.out.println("Invite Link: " + api.createBotInvite());
		
		CommandHandler cmdHandler = new JavacordHandler(api);
		cmdHandler.registerCommand(new TestCommand());
	}
	
	private void disposeBot(DiscordApi api) {
		api.disconnect();
	}
}
