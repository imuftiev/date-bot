package com.project.princeps.service.executor;

import com.project.princeps.bot.TelegramBot;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.Serializable;

@Getter
@Setter
@Component
public class BotExecutorService {

    private TelegramBot telegramBot;

    public <T extends Serializable, Method extends BotApiMethod<T>> void execute(Method method) throws TelegramApiException {
        try {
            telegramBot.execute(method);
        } catch (Exception exception) {
            throw new TelegramApiException(exception.getMessage());
        }
    }
}
