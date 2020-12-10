package com.hukuta94.simplecalculator.domain.arabicroman.model;

import com.hukuta94.simplecalculator.domain.arabicroman.parser.RomanToArabicParser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validator
{
    private static final String REGEX_ROMAN_INPUT = "\\s*([IVXLCDM]+)\\s*([\\+\\-\\*/])\\s*([IVXLCDM]+)\\s*";
    private static final String REGEX_ARABIC_INPUT = "\\s*(\\d+)\\s*([\\+\\-\\*/])\\s*(\\d+)\\s*";

    // проверяет корректность введенных в программу данных и возвращает их в виде объекта Data
    static InputData validateLineAndGetData(String line )
    {
        // создаем Matcher для поиска в line операции и операндов
        Matcher roman = Pattern.compile( REGEX_ROMAN_INPUT ).matcher( line.toUpperCase() );
        Matcher arabic = Pattern.compile( REGEX_ARABIC_INPUT ).matcher( line );

        boolean isArabic = arabic.find();       // арабские ли числа были введены
        Matcher m = isArabic ? arabic : roman;  // матчер, который будем использовать для поиска в line

        // проверяем, что он что-то нашел
        if ( !m.reset().find() ) {
            throw new IllegalArgumentException( "Должно быть введено два арабских или римских числа и знак операции" );
        }

        // получаем операнды, их тип (араб./рим.) и тип операции (сложение, вычитание ...), введенные пользователем
        String operand1 = m.group(1);
        String operation = m.group(2);
        String operand2 = m.group(3);
        NumberType type = isArabic ? NumberType.ARABIC : NumberType.ROMAN;

        // формируем объект Data
        int firstNumber = isArabic ? Integer.parseInt( operand1 ) : RomanToArabicParser.parse( operand1 );
        int secondNumber = isArabic ? Integer.parseInt( operand2 ) : RomanToArabicParser.parse( operand2 );

        // проверка на допустимость таких операндов
        if ( firstNumber <= 0 || secondNumber <= 0 ) {
            throw new IllegalArgumentException( "Псевдоримские или отрицательные числа" );
        }

        return new InputData( firstNumber, secondNumber, operation , type );
    }

}



