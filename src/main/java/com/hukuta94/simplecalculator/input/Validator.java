package com.hukuta94.simplecalculator.input;

import com.hukuta94.simplecalculator.model.Data;
import com.hukuta94.simplecalculator.model.NumberType;
import com.hukuta94.simplecalculator.parser.RomanToArabicParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator {

    // проверяет корректность введенных в программу данных и возвращает их в виде объекта Data
    static Data validateLineAndGetData(String line) {
        // создаем Matcher для поиска в line операции и операндов
        Matcher roman = Pattern.compile("\\s*([IVXLCDM]+)\\s*([\\+\\-\\*/])\\s*([IVXLCDM]+)\\s*").matcher(line.toUpperCase());
        Matcher arabic = Pattern.compile("\\s*(\\d+)\\s*([\\+\\-\\*/])\\s*(\\d+)\\s*").matcher(line);
        boolean isArabic = arabic.find();               // арабские ли числа были введены
        Matcher m = isArabic ? arabic : roman;          // матчер, который будем использовать для поиска в line
        if (!m.reset().find()) {                        // проверяем, что он что-то нашел
            throw new IllegalArgumentException("Должно быть введено два арабских или римских числа и знак операции");
        }

        // получаем операнды, их тип (араб./рим.) и тип операции (сложение, вычитание ...), введенные пользователем
        String operand1 = m.group(1);
        String operation = m.group(2);
        String operand2 = m.group(3);
        NumberType type = isArabic ? NumberType.ARABIC : NumberType.ROMAN;

        // формируем объект Data
        int firstNumber = isArabic ? Integer.parseInt(operand1) : RomanToArabicParser.parse(operand1);
        int secondNumber = isArabic ? Integer.parseInt(operand2) : RomanToArabicParser.parse(operand2);

        // проверка на допустимость таких операндов
        if (firstNumber <= 0 || secondNumber <= 0) {
            throw new IllegalArgumentException("Псевдоримские или отрицательные числа");
        }

        return new Data(firstNumber, secondNumber, operation , type);
    }

}



