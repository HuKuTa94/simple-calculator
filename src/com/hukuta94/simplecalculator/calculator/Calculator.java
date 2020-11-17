package com.hukuta94.simplecalculator.calculator;

import com.hukuta94.simplecalculator.model.Data;

public abstract class Calculator
{
    Data data;

    Calculator( Data data ) {
        this.data = data;
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
