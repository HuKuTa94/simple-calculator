package com.hukuta94.simplecalculator.domain.arabicroman.model;

import com.hukuta94.simplecalculator.domain.arabicroman.model.Data;
import com.hukuta94.simplecalculator.domain.arabicroman.model.NumberType;
import com.hukuta94.simplecalculator.domain.arabicroman.model.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Класс Validator должен быть не абстрактным
 */

public class ValidatorTest
{
    private static Validator validator;
    private static final String[] OPERATORS = { "+", "-", "*", "/" };

    @BeforeAll
    static void initTests() {
        validator = new Validator();
    }

    /**
     * Недопустим ввод числа 0
     */
    @Test
    @DisplayName( "Incorrect input (null number) - throws IllegalArgumentException" )
    void testIncorrectInputNullNumber() {
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "0+1" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "0+0" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "1+0" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "1-0" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "0-1" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "0-0" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "0*1" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "1*0" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "0*0" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "1/0" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "0/1" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "0/0" ));
    }

    /**
     * Недопустим ввод разнотипных чисел - римское и арабское число в одной строке
     */
    @Test
    @DisplayName( "Incorrect input (different number types) - throws IllegalArgumentException" )
    void testIncorrectInputDifferentNumberTypes() {
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "I+1" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "1+I" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "1-V" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "X*5" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "5*X" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "C/1" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "1/C" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "L+3" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "3+L" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "5-M" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "M-5" ));
    }

    /**
     * Неизвестный символ (операнд) между числами.
     * Допустим между числами только один из символов: + - * /
     */
    @Test
    @DisplayName( "Incorrect input (unknown char between numbers) - throws IllegalArgumentException" )
    void testIncorrectInputUnknownCharacterBetweenNumbers() {
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "1№1" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "IвI" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "V?V" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "5%5" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "X=X" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "C@C" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "5!3" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "L~XI" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "3J33" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "5(5" ));
        Assertions.assertThrows( IllegalArgumentException.class, ()-> validator.validateLineAndGetData( "M)M" ));
    }

    /**
     * Можно вводить числа и оператор с различным количеством пробелов между ними (или без)
     */
    @Test
    @DisplayName( "Correct input (any count of spaces between chars) - doesn't throw any exception" )
    void testCorrectInputManySpacesBetweenChars() {
        Assertions.assertDoesNotThrow( ()-> validator.validateLineAndGetData( "1+1" ));
        Assertions.assertDoesNotThrow( ()-> validator.validateLineAndGetData( "1 *1" ));
        Assertions.assertDoesNotThrow( ()-> validator.validateLineAndGetData( "1- 1" ));
        Assertions.assertDoesNotThrow( ()-> validator.validateLineAndGetData( "1 + 1" ));
        Assertions.assertDoesNotThrow( ()-> validator.validateLineAndGetData( " 1 / 1 " ));
        Assertions.assertDoesNotThrow( ()-> validator.validateLineAndGetData( "   1 +   1   " ));
        Assertions.assertDoesNotThrow( ()-> validator.validateLineAndGetData( "I/I" ));
        Assertions.assertDoesNotThrow( ()-> validator.validateLineAndGetData( "I +I" ));
        Assertions.assertDoesNotThrow( ()-> validator.validateLineAndGetData( "I- I" ));
        Assertions.assertDoesNotThrow( ()-> validator.validateLineAndGetData( "I * I" ));
        Assertions.assertDoesNotThrow( ()-> validator.validateLineAndGetData( " I + I " ));
        Assertions.assertDoesNotThrow( ()-> validator.validateLineAndGetData( "   I /   I   " ));
    }

    /**
     * Возврат объекта Data с правильно заполненными полями (арабский вариант))
     * Потребуется переопределить метод hashCode() и equals() у класса Data
     * Класс Data внутри всегда хранит арабские числа
     */
    @Test
    @DisplayName( "Data object with arabic numbers" )
    void testDataObjectWithArabicNumbers() {
        final int firstNumber = 1;
        final int secondNumber = 5;

        for ( String operator : OPERATORS )
        {
            String inputLine = firstNumber + operator + secondNumber;

            Data expectedData = new Data( firstNumber, secondNumber, operator, NumberType.ARABIC );
            Data actualData = validator.validateLineAndGetData( inputLine );

            Assertions.assertEquals( expectedData.getFirstNumber(),  actualData.getFirstNumber() );
            Assertions.assertEquals( expectedData.getSecondNumber(), actualData.getSecondNumber() );
            Assertions.assertEquals( expectedData.getOperator(), actualData.getOperator() );
            Assertions.assertEquals( expectedData.getType(), actualData.getType() );
            Assertions.assertEquals( expectedData, actualData );
        }
    }

    /**
     * Возврат объекта Data с правильно заполненными полями (римский вариант)
     * Потребуется переопределить метод hashCode() и equals() у класса Data
     * Класс Data внутри всегда хранит арабские числа
     */
    @Test
    @DisplayName( "Data object with roman numbers" )
    void testDataObjectWithRomanNumbers() {
        final int firstNumberArabic = 1;
        final int secondNumberArabic = 5;
        final String firstNumberRoman = "I";
        final String secondNumberRoman = "V";

        for ( String operator : OPERATORS )
        {
            String inputLine = firstNumberRoman + operator + secondNumberRoman;

            Data expectedData = new Data( firstNumberArabic, secondNumberArabic, operator, NumberType.ROMAN );
            Data actualData = validator.validateLineAndGetData( inputLine );

            Assertions.assertEquals( expectedData.getFirstNumber(),  actualData.getFirstNumber() );
            Assertions.assertEquals( expectedData.getSecondNumber(), actualData.getSecondNumber() );
            Assertions.assertEquals( expectedData.getOperator(), actualData.getOperator() );
            Assertions.assertEquals( expectedData.getType(), actualData.getType() );
            Assertions.assertEquals( expectedData, actualData );
        }
    }
}
