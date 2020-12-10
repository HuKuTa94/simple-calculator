package com.hukuta94.simplecalculator.domain.arabicroman.model;

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
        final NumberType type = NumberType.ARABIC;
        final int operand1Arabic = 1;
        final int operand2Arabic = 5;

        for ( String operator : OPERATORS )
        {
            String inputLine = operand1Arabic + operator + operand2Arabic;
            testDataObject( operand1Arabic, operand2Arabic, operator, type, inputLine );
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
        final NumberType type = NumberType.ROMAN;
        final int operand1Arabic = 1;
        final int operand2Arabic = 5;
        final String operand1Roman = "I";
        final String operand2Roman = "V";

        for ( String operator : OPERATORS )
        {
            String inputLine = operand1Roman + operator + operand2Roman;
            testDataObject( operand1Arabic, operand2Arabic, operator, type, inputLine );
        }
    }

    private void testDataObject( int operand1, int operand2, String operator, NumberType type, String inputLine )
    {
        InputData expectedInputData = new InputData( operand1, operand2, operator, type );
        InputData actualInputData = validator.validateLineAndGetData( inputLine );

        Assertions.assertEquals( expectedInputData.getFirstOperand(),  actualInputData.getFirstOperand() );
        Assertions.assertEquals( expectedInputData.getSecondOperand(), actualInputData.getSecondOperand() );
        Assertions.assertEquals( expectedInputData.getOperator(),      actualInputData.getOperator() );
        Assertions.assertEquals( expectedInputData.getType(),          actualInputData.getType() );
        Assertions.assertEquals( expectedInputData,                    actualInputData);
    }
}
