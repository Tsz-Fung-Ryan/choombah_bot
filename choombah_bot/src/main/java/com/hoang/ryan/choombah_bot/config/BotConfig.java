package com.hoang.ryan.choombah_bot.config;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.channel.TextChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.Scheduled;

import com.hoang.ryan.choombah_bot.commands.AboutCommand;
import com.hoang.ryan.choombah_bot.commands.GenerateNetworkCommand;
import com.hoang.ryan.choombah_bot.commands.ScheduleReminder;

import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JavacordHandler;

@Configuration
@Import({NetworkConfig.class})
public class BotConfig {

	@Value("${discord.token}")
	String token;

	@Value("${channel.reminder.id}")
	String channelReminderId;
	
	boolean flip=true;

	@Bean
	DiscordApi discordApi() {
		return new DiscordApiBuilder().setToken(token).login().join();
	}

	@Bean
	ScheduleReminder scheduleReminder() {
		return new ScheduleReminder();
	}

	@Bean
	CommandHandler cmdHandler() {
		CommandHandler cmdHandler = new JavacordHandler(discordApi());
		addCommands(cmdHandler);
		return cmdHandler;
	}
	
	@Scheduled(cron = "${reminder.cron}")
	public void scheduledReminder(String channelReminderId) {
		if(flip) {
			TextChannel channel = discordApi().getTextChannelById(channelReminderId).orElseThrow();
			scheduleReminder().reminder(channel);
		}
		flip=!flip;
	}

	private void addCommands(CommandHandler cmdHandler) {
		cmdHandler.registerCommand(new GenerateNetworkCommand());
		cmdHandler.registerCommand(new AboutCommand());
	}
}