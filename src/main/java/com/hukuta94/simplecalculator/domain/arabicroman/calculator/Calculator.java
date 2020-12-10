package com.hukuta94.simplecalculator.domain.arabicroman.calculator;

import com.hukuta94.simplecalculator.domain.arabicroman.model.InputData;

public abstract class Calculator
{
    InputData inputData;

    Calculator( InputData inputData) {
        this.inputData = inputData;
    }

    public abstract String calculate();

    static int getResult(int firstNumber, int secondNumber, String operator) {
        return switch( operator ) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> firstNumber / secondNumber;
            default -> throw new IllegalStateException( "Unexpected value: " + operator );
        };
    }
}
