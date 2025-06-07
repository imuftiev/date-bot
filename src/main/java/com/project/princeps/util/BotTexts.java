package com.project.princeps.util;

import com.vdurmont.emoji.EmojiParser;
import org.springframework.stereotype.Component;

@Component
public class BotTexts {
    public final static String START_EMOJI = EmojiParser.parseToUnicode(":upside_down:");
    public final static String COFFEE_EMOJI = EmojiParser.parseToUnicode(":coffee:");
    public final static String EYES_EMOJI = EmojiParser.parseToUnicode(":eyes:");
    public final static String NO_GOOD_EMOJI = EmojiParser.parseToUnicode(":no_good:");
    public final static String BOW_EMOJI = EmojiParser.parseToUnicode(":bow:");
    public final static String WINK_EMOJI = EmojiParser.parseToUnicode(":wink:");
    public final static String PRINCESS_EMOJI = EmojiParser.parseToUnicode(":princess:");
    public final static String INNOCENT_EMOJI = EmojiParser.parseToUnicode(":innocent:");
    public final static String CRY_EMOJI = EmojiParser.parseToUnicode(":cry:");
    public final static String KISSING_EMOJI = EmojiParser.parseToUnicode(":kissing:");
    public final static String ZANY_EMOJI = EmojiParser.parseToUnicode(":zany_face:");
    public final static String HEART_EMOJI = EmojiParser.parseToUnicode(":heart_eyes:");
    public final static String SMILE_EMOJI = EmojiParser.parseToUnicode(":smile:");
    public final static String SMIRK_EMOJI = EmojiParser.parseToUnicode(":smirk:");
    public final static String FACE_WITH_HAND_EMOJI = EmojiParser.parseToUnicode(":face_with_hand_over_mouth:");
    public final static String INFORMATION_DESK_PERSON_EMOJI = EmojiParser.parseToUnicode(":information_desk_person:");
    public final static String WELCOME_MESSAGE = "Привет ";
    public final static String MID_MESSAGE = " Ильяс рассказал мне, какие у тебя милые глаза, он бы очень хотел видеть их напротив себя. " + "Ему пришла идея оригинально пригласить тебя на кофе " + COFFEE_EMOJI;
    public final static String END_MESSAGE = " Поэтому появился я " + ZANY_EMOJI;
    public final static String QUESTION_MESSAGE = "Что мне передать ? " + EYES_EMOJI + " Ты можешь выбрать: \n" + "1️⃣ " +
            "«Не пью кофе, может лучше чай ?» " + NO_GOOD_EMOJI + "\n" + "2️⃣ «Я подумаю... но кофе звучит заманчиво!» " +
            BOW_EMOJI + "\n" + "3️⃣ «Только если это будет Айс Латте \"Солёная Карамель\"!» " + INFORMATION_DESK_PERSON_EMOJI +
            "\n" + "4\uFE0F⃣ «Я не против!» " + PRINCESS_EMOJI + "\n" + "5\uFE0F⃣ Если хочешь написать свой ответ " + WINK_EMOJI +
            "\n" + "Выбирай, а я передам ответ Ильясу!\n";
};
