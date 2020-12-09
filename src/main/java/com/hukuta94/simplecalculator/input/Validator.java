package com.hukuta94.simplecalculator.input;

import com.hukuta94.simplecalculator.model.Data;
import com.hukuta94.simplecalculator.model.NumberType;
import com.hukuta94.simplecalculator.model.RomanNumeral;
import com.hukuta94.simplecalculator.parser.RomanToArabicParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    // проверяет корректность введенных в программу данных и возвращает их в виде объекта Data
    static Data validateLineAndGetData(String line) {
        Matcher roman = Pattern.compile("\\s*([IVXLCDM]+)\\s*([\\+\\-\\*/])\\s*([IVXLCDM]+)\\s*").matcher(line.toUpperCase());
        Matcher arabic = Pattern.compile("\\s*(\\d+)\\s*([\\+\\-\\*/])\\s*(\\d+)\\s*").matcher(line);
        boolean isArabic = arabic.find();       // арабские ли числа были введены
        if (!isArabic && !roman.find()) throw new IllegalArgumentException("Должно быть введено два арабских или римских числа и знак операции");
        int firstNumber = isArabic ? Integer.parseInt(arabic.group(1)) : RomanToArabicParser.parse(roman.group(1));
        int secondNumber = isArabic ? Integer.parseInt(arabic.group(3)) : RomanToArabicParser.parse(roman.group(3));
        NumberType type = isArabic ? NumberType.ARABIC : NumberType.ROMAN;
        String operator = isArabic ? arabic.group(2) : roman.group(2);
        if (firstNumber <= 0 || secondNumber <= 0)  throw new IllegalArgumentException("Псевдоримские или отрицательные числа");

        return new Data(firstNumber, secondNumber, operator , type);
    }

}
