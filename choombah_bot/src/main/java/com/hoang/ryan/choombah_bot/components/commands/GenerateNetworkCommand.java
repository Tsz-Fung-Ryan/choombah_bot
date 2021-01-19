package com.hoang.ryan.choombah_bot.components.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoang.ryan.choombah_bot.components.Network;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

@Service
public class GenerateNetworkCommand implements CommandExecutor {

	@Autowired
	Network network;
	
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
