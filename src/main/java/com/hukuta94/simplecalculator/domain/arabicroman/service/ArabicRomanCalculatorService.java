package com.hukuta94.simplecalculator.domain.arabicroman.service;

import com.hukuta94.simplecalculator.domain.arabicroman.calculator.CalculatorFactory;
import com.hukuta94.simplecalculator.domain.arabicroman.model.Validator;
import com.hukuta94.simplecalculator.domain.arabicroman.model.Data;

public class ArabicRomanCalculatorService
{
    private Validator validator;

    public ArabicRomanCalculatorService( Validator validator ) {
        this.validator = validator;
    }

    public String calculate( String input ) {
        Data data = validator.validateLineAndGetData( input );
        return CalculatorFactory.getCalculator( data, data.getType() ).calculate();
    }
}
