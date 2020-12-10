package com.hukuta94.simplecalculator.domain.arabicroman.calculator;

import com.hukuta94.simplecalculator.domain.arabicroman.model.InputData;
import com.hukuta94.simplecalculator.domain.arabicroman.parser.ArabicToRomanParser;

class RomanCalculator extends Calculator
{
    private ArabicToRomanParser arabicToRomanParser;

    RomanCalculator( InputData inputData ) {
        super( inputData );
        arabicToRomanParser = new ArabicToRomanParser();
    }

    @Override
    public String calculate() {
        int result = getResult( inputData.getFirstOperand(), inputData.getSecondOperand(), inputData.getOperator() );
        return arabicToRomanParser.parse( result );
    }
}
