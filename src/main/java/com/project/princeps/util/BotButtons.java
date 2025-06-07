package com.project.princeps.util;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class BotButtons {
    InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();

    public InlineKeyboardMarkup inlineMarkup() {

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        List<InlineKeyboardButton> firstRow = new ArrayList<>();

        InlineKeyboardButton firstButton = new InlineKeyboardButton("1");
        InlineKeyboardButton secondButton = new InlineKeyboardButton("2");
        InlineKeyboardButton thirdButton = new InlineKeyboardButton("3");
        InlineKeyboardButton fourthButton = new InlineKeyboardButton("4");
        InlineKeyboardButton fifthButton = new InlineKeyboardButton("5");

        firstButton.setCallbackData("FIRST_ANSWER");
        secondButton.setCallbackData("SECOND_ANSWER");
        thirdButton.setCallbackData("THIRD_ANSWER");
        fourthButton.setCallbackData("FOURTH_ANSWER");
        fifthButton.setCallbackData("FIFTH_ANSWER");
        firstRow.add(firstButton);
        firstRow.add(secondButton);
        firstRow.add(thirdButton);
        firstRow.add(fourthButton);
        firstRow.add(fifthButton);
        rows.add(firstRow);
        inlineMarkup.setKeyboard(rows);
        return inlineMarkup;
    }
}
