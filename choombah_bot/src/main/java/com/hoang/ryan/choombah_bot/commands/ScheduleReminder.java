package com.hoang.ryan.choombah_bot.commands;

import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageBuilder;

import de.btobastian.sdcf4j.CommandExecutor;

public class ScheduleReminder implements CommandExecutor {
	
	public void reminder(TextChannel channel) {
		new MessageBuilder().append("everyone session starts in a hour").send(channel);
	}
}
