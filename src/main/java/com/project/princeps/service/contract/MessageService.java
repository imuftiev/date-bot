package com.project.princeps.service.contract;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface MessageService {
    void sendMessage(long chatId, String text);
    void sendMessageWithKeyboard(long chatId, String text, InlineKeyboardMarkup markup);
}
