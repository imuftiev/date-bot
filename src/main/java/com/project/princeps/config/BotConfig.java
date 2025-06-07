package com.project.princeps.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@Configuration
@PropertySource("application.yml")
public class BotConfig {

    @Value("${bot.name}")
    public String botName;

    @Value("${bot.token}")
    public String botToken;

}
