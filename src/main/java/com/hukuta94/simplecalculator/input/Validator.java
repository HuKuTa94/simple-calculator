package com.hukuta94.simplecalculator.input;

import com.hukuta94.simplecalculator.model.Data;
import com.hukuta94.simplecalculator.model.NumberType;
import com.hukuta94.simplecalculator.model.RomanNumeral;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    // проверяет корректность введенных данных и возвращает их в виде объекта Data
    static Data validateLineAndGetData(String line) {
        // проверка: ни один из аргументов не должен быть нулем
        if (line.matches("(^0.*)||(.*\\D0.*)")) throw new IllegalArgumentException("Ex 1");

        // получение аргументов и операнда из line
        Matcher roman = Pattern.compile("\\s*([IVXLCDM]+)\\s*([\\+\\-\\*/])\\s*([IVXLCDM]+)\\s*").matcher(line.toUpperCase());
        Matcher arabic = Pattern.compile("\\s*(\\d+)\\s*([\\+\\-\\*/])\\s*(\\d+)\\s*").matcher(line);
        if (!roman.find() && !arabic.find()) throw new IllegalArgumentException("Ex 1");
        NumberType type = roman.reset().find() ? NumberType.ROMAN : NumberType.ARABIC;
        Matcher matcher = type == NumberType.ARABIC ? arabic : roman;  // в этом объекте хранятся аргументы

        return new Data(matcher.group(1), matcher.group(3), matcher.group(2), type);
    }
}
