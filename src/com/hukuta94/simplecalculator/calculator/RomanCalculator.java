package com.hukuta94.simplecalculator.calculator;

import com.hukuta94.simplecalculator.model.Data;
import com.hukuta94.simplecalculator.parser.ArabicToRomanParser;

class RomanCalculator extends Calculator
{
    RomanCalculator(Data data) {
        super( data );
    }

    @Override
    public String calculate() {
        int result = getResult( data.getFirstNumber(), data.getSecondNumber(), data.getOperator() );
        return ArabicToRomanParser.parse( result );
    }
}
