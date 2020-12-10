package com.hukuta94.simplecalculator.domain.arabicroman.calculator;

import com.hukuta94.simplecalculator.domain.arabicroman.model.Data;
import com.hukuta94.simplecalculator.domain.arabicroman.parser.ArabicToRomanParser;

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
