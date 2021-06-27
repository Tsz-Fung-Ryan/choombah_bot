package com.hoang.ryan.choombah_bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hoang.ryan.choombah_bot.components.*;
import com.hoang.ryan.choombah_bot.config.BotConfig;

@SpringBootApplication
public class ChoombahBotApplication {
    public static void main(String[] args){
    	SpringApplication.run(BotConfig.class, args);
    }
}