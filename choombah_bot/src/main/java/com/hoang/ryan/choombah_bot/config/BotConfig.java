package com.hoang.ryan.choombah_bot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hoang.ryan.choombah_bot.components.Floor;

@Configuration
public class BotConfig {
	
	@Bean
	public Floor floorService() {
		return new Floor();
	}
}
