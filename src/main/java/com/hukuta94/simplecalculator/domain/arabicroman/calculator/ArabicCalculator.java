package com.hukuta94.simplecalculator.domain.arabicroman.calculator;

import com.hukuta94.simplecalculator.domain.arabicroman.model.Data;

public class ArabicCalculator extends Calculator
{
    ArabicCalculator( Data data ) {
        super( data );
    }

    @Override
    public String calculate() {
        int result = getResult( data.getFirstNumber(), data.getSecondNumber(), data.getOperator() );
        return String.valueOf( result );
    }
}
