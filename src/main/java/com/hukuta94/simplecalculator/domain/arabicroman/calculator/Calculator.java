package com.hukuta94.simplecalculator.domain.arabicroman.calculator;

import com.hukuta94.simplecalculator.domain.arabicroman.model.InputData;

public abstract class Calculator
{
    private InputData inputData;

    Calculator( InputData inputData ) {
        this.inputData = inputData;
    }

    public abstract String calculate();

    int getResult() {
        int firstOperand = inputData.getFirstOperand();
        int secondOperand = inputData.getSecondOperand();
        String operator = inputData.getOperator();

        return switch( operator ) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            case "/" -> firstOperand / secondOperand;
            default -> throw new IllegalStateException( "Unexpected value: " + operator );
        };
    }
}
