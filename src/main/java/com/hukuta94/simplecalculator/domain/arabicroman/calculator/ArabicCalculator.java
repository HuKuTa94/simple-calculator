package com.hukuta94.simplecalculator.domain.arabicroman.calculator;

import com.hukuta94.simplecalculator.domain.arabicroman.model.InputData;

public class ArabicCalculator extends Calculator
{
    ArabicCalculator( InputData inputData) {
        super(inputData);
    }

    @Override
    public String calculate() {
        int result = getResult( inputData.getFirstOperand(), inputData.getSecondOperand(), inputData.getOperator() );
        return String.valueOf( result );
    }
}
