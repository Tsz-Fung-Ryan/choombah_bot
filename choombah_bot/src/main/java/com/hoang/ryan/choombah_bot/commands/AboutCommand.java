package com.hoang.ryan.choombah_bot.commands;

import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;

public class AboutCommand implements CommandExecutor{

	@Command(aliases = {"!about"}, description = "details on the bot")
	public String onAboutCommand() {
		return "Created by ElsOphion to help with his Cyberpunk Red Campaign";
	}
}
