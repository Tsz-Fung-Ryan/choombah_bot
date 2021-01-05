package com.hoang.ryan.choombah_bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hoang.ryan.choombah_bot.components.*;

@SpringBootApplication
public class ChoombahBotApplication 
{
	@Autowired
	DiscordBuilder bot;
	
    public static void main( String[] args )
    {
    	
    	SpringApplication.run(ChoombahBotApplication.class, args);
    }
}
