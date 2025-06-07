package com.project.princeps.bot;

import com.project.princeps.controller.UpdateController;
import com.project.princeps.service.executor.BotExecutorService;
import com.project.princeps.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelegramBot extends TelegramLongPollingBot {

    private final UpdateController updateController;
    private final BotConfig config;

    @Autowired
    public TelegramBot(BotExecutorService executor, UpdateController updateController, BotConfig config) {
        this.updateController = updateController;
        this.config = config;

        executor.setTelegramBot(this);

        List<BotCommand> botCommandList = new ArrayList<>();
        botCommandList.add(new BotCommand("/start", "нажми на эту команду чтобы запустить бота :)"));

        try {
            execute(new SetMyCommands(botCommandList, new BotCommandScopeDefault(), null));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return config.botName;
    }

    @Override
    public String getBotToken() {
        return config.botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        updateController.update(update);
    }

}
