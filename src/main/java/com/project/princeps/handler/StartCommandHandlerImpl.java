package com.project.princeps.handler;

import com.project.princeps.dto.InfoDTO;
import com.project.princeps.handler.contract.StartCommandHandler;
import com.project.princeps.mapper.InfoMapper;
import com.project.princeps.service.contract.InfoService;
import com.project.princeps.service.contract.MessageService;
import com.project.princeps.util.BotTexts;
import com.project.princeps.util.BotButtons;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommandHandlerImpl implements StartCommandHandler {

    private final MessageService messageService;
    private final InfoService infoService;
    private final BotButtons botButtons;
    private final InfoMapper infoMapper;

    public StartCommandHandlerImpl(MessageService messageService, InfoService infoService, BotButtons botButtons, InfoMapper infoMapper) {
        this.messageService = messageService;
        this.infoService = infoService;
        this.botButtons = botButtons;
        this.infoMapper = infoMapper;
    }

    @Override
    public void handle(Update update, long chatId) {
        infoService.add(infoMapper.toEntity(InfoDTO.builder().username(update.getMessage().getChat().getUserName()).build()));
        messageService.sendMessage(chatId, BotTexts.WELCOME_MESSAGE + ", " + update.getMessage().getChat().getFirstName() + " !");
        messageService.sendMessage(chatId, BotTexts.MID_MESSAGE);
        messageService.sendMessage(chatId, BotTexts.END_MESSAGE);
        messageService.sendMessageWithKeyboard(chatId, BotTexts.QUESTION_MESSAGE, botButtons.inlineMarkup());
    }
}
