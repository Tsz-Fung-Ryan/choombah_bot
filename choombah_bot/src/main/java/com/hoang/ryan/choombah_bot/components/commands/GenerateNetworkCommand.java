package com.hoang.ryan.choombah_bot.components.commands;

import org.springframework.stereotype.Service;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

@Service
public class GenerateNetworkCommand implements CommandExecutor {

	@Command(aliases = {"!generate"}, description = "generates an example network")
	public String onCommand(String [] args) {

		System.out.println("command was run");

		switch(args.length) {
		case 1:
			return args[0];
		case 2:
			return args[0] + " " + args[1];
		default:
			return "no args specified for network";
		}
	}
}
