package com.hoang.ryan.choombah_bot.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DiscordBuilder {

	
	private final String token;
	
	@Autowired
	public DiscordBuilder(@Value("${discord.token}") String token) {
		this.token=token;
		
		System.out.println(token);
	}
}
