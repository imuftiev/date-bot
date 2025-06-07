package com.project.princeps.service;

import com.project.princeps.service.executor.BotExecutorService;
import com.project.princeps.service.contract.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class MessageServiceImpl implements MessageService {

    private final BotExecutorService executor;

    public MessageServiceImpl(BotExecutorService executor) {
        this.executor = executor;
    }

    private SendMessage sendMessageFactory() {
        return new SendMessage();
    }

    @Override
    public void sendMessage(long chatId, String text) {
        SendMessage message = sendMessageFactory();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        try {
            executor.execute(message);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void sendMessageWithKeyboard(long chatId, String text, InlineKeyboardMarkup markup) {
        SendMessage message = sendMessageFactory();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        message.setReplyMarkup(markup);
        try {
            executor.execute(message);
        } catch (TelegramApiException e) {
            log.error(e.getMessage());
        }
    }

}
