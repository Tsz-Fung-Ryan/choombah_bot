package com.hoang.ryan.choombah_bot.config;

import javax.annotation.PostConstruct;

import org.javacord.api.DiscordApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hoang.ryan.choombah_bot.components.DiscordBuilder;
import com.hoang.ryan.choombah_bot.components.Network;

@Configuration
public class BotConfig {
	
	@Value("${discord.token}")
	String token;
	
	@Bean
	public Network network() {
		return new Network();
	}
	
	@Bean 
	DiscordBuilder discordBuilder() {
		return new DiscordBuilder(token);
	}
	
	@PostConstruct
	public void startBot() {
		discordBuilder().startBot();
	}
}