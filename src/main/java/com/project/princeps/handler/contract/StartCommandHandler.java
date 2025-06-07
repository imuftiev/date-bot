package com.project.princeps.handler.contract;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface StartCommandHandler {
    void handle(Update update, long chatId);
}
