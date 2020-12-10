package com.hukuta94.simplecalculator.domain.arabicroman.parser;

import com.hukuta94.simplecalculator.domain.arabicroman.model.RomanNumeral;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RomanToArabicParser {
    // римское число, которое надо распарсить
    private static StringBuilder line;

    // возвращает арабское представление полученного римского числа
    // или -1, если в результате парсинга было получено недопустимое значение
    public static int parse(String romanNumber) {
        line = new StringBuilder(romanNumber);
        int arabicNumber = 0;

        ArrayList<RomanNumeral> list = new ArrayList<>(Arrays.asList(RomanNumeral.values()));
        Collections.reverse(list);
        System.out.println(list);

        for (RomanNumeral item : list) {
            if (checkAndPrun(item.getRoman())) arabicNumber += item.getArabic();
        }

        return line.length() == 0 ? arabicNumber : -1;
    }


    // определяет является ли крайнее левое число в line, числом,
    // переданным в этот метод. если да, удаляет его из line
    private static boolean checkAndPrun(String number) {
        if (line.length() < number.length()) return false;
        // проверка
        int endIndex = number.length();
        String sub = line.substring(0, endIndex);
        boolean check = sub.equals(number);
        // удаление
        if (check) line.delete(0, endIndex);
        return check;
    }

}
