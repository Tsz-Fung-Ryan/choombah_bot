package com.hoang.ryan.choombah_bot.components.commands;

import org.springframework.stereotype.Service;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;


@Service
public class TestCommand implements CommandExecutor{

	@Command(aliases = {"!ping"}, description = "Pong!")
	public String onCommand() {
		return "Bot works woo";
	}
	
}
