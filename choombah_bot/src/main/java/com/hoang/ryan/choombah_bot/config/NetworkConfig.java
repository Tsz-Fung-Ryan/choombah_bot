package com.hoang.ryan.choombah_bot.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.hoang.ryan.choombah_bot.components.network.Network;

@Configuration
@PropertySources({
	@PropertySource("classpath:NetworkTables/NETArchitecture.resource")
})
public class NetworkConfig {

	@Value("#{${network.lobby.floors}}")
	Map<Integer, String> lobbyValues;
	
	@Bean
	public Network network() {
		return new Network();
	}
	
	@Bean
	public void loadTables() {
		network().initTables(lobbyValues);
		network().testLobby();
	}
}
