package com.hoang.ryan.choombah_bot.components;

import javax.annotation.PostConstruct;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
		api = new DiscordApiBuilder().setToken(token).login().join();
		
		System.out.println("Bot is running");
		
		System.out.println("Invite Link: " + api.createBotInvite());
	}
}
