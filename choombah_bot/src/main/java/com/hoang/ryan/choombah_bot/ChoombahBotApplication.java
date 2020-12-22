package com.hoang.ryan.choombah_bot;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hoang.ryan.choombah_bot.components.Network;

@SpringBootApplication
public class ChoombahBotApplication 
{
    public static void main( String[] args )
    {
    	Network network = new Network("basic", 18, 4);
    }
}
