package com.hoang.ryan.choombah_bot.commands;

import com.hoang.ryan.choombah_bot.components.network.Network;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class GenerateNetworkCommand implements CommandExecutor {

	Network network;
	
	public GenerateNetworkCommand() {
	}

	@Command(aliases = {"!generate"}, description = "generates an example network", usage = "!generate [3-18] [0-15]")
	public String generateCommand(String [] args) {
		switch(args.length) {
		case 0:
			network = new Network();
			return network.traverse();
		case 1:
			network = new Network();
			network.setTotalFloors(Integer.parseInt(args[0]));
			network.generateNetwork();
			return network.traverse();
		case 2:
			return args[0] + " " + args[1];
		default:
			return "no args specified for network";
		}
	}
	
	@Command(aliases = {"!traverse"}, description = "retraverses previously created network")
	public String traverseCommand() {
		return network.traverse();
	}
}
