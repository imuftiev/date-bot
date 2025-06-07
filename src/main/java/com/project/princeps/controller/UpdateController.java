package com.project.princeps.controller;

import com.project.princeps.dto.PersonDTO;
import com.project.princeps.handler.contract.StartCommandHandler;
import com.project.princeps.mapper.PersonMapper;
import com.project.princeps.service.contract.BotStateService;
import com.project.princeps.service.contract.MessageService;
import com.project.princeps.service.contract.PersonService;
import com.project.princeps.util.BotState;
import com.project.princeps.util.BotTexts;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class UpdateController {

    private final StartCommandHandler startCommandHandler;
    private final MessageService messageService;
    private final BotStateService botStateService;
    private final PersonService personService;
    private final PersonMapper personMapper;

    public UpdateController(StartCommandHandler startCommandHandler,
                            MessageService messageService,
                            BotStateService botStateService,
                            PersonService personService,
                            PersonMapper personMapper) {

        this.startCommandHandler = startCommandHandler;
        this.messageService = messageService;
        this.botStateService = botStateService;
        this.personService = personService;
        this.personMapper = personMapper;
    }

    public void update(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String message = update.getMessage().getText();
            switch (message) {
                case "/start":
                    startCommandHandler.handle(update, chatId);
                    break;
                case "/settings":
                    break;
                default:
                    if (botStateService.getState().containsValue(BotState.WAITING_ANSWER)) {
                        personService.add(personMapper.toEntity(PersonDTO.builder().answer(message).build()));
                        botStateService.getState().remove(chatId);
                        messageService.sendMessage(chatId, "Записал каждое слово и уже бегу передавать Ильясу " + BotTexts.SMIRK_EMOJI);
                        break;
                    } else {
                        messageService.sendMessage(chatId, "Извини, я понимаю не все сообщения" + BotTexts.CRY_EMOJI);
                    }
                    break;
            }

        } else if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            switch (data) {
                case "FIRST_ANSWER":
                    messageService.sendMessage(chatId, "Отлично, с вами свяжется автор для уточнения деталей! " + BotTexts.INNOCENT_EMOJI);
                    personService.add(personMapper.toEntity(PersonDTO.builder().answer("FIRST_ANSWER").build()));
                    break;
                case "SECOND_ANSWER":
                    messageService.sendMessage(chatId, "Значит у него есть шанс! Может он увеличится после знакомства " + BotTexts.FACE_WITH_HAND_EMOJI);
                    personService.add(personMapper.toEntity(PersonDTO.builder().answer("SECOND_ANSWER").build()));
                    break;
                case "THIRD_ANSWER":
                    messageService.sendMessage(chatId, "Он обещает что эту встречу ты будешь вспоминать с улыбкой! " + BotTexts.KISSING_EMOJI);
                    personService.add(personMapper.toEntity(PersonDTO.builder().answer("THIRD_ANSWER").build()));
                    break;
                case "FOURTH_ANSWER":
                    messageService.sendMessage(chatId, "Это самая лучшая новость за сегодня " + BotTexts.HEART_EMOJI);
                    personService.add(personMapper.toEntity(PersonDTO.builder().answer("FOURTH_ANSWER").build()));
                    break;
                case "FIFTH_ANSWER":
                    botStateService.getState().put(chatId, BotState.WAITING_ANSWER);
                    messageService.sendMessage(chatId, "Хорошо, напиши свой ответ " + BotTexts.SMILE_EMOJI);
                    break;
            }
        }
    }

}
