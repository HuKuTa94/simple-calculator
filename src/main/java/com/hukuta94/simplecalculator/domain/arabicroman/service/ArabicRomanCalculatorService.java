package com.hukuta94.simplecalculator.domain.arabicroman.service;

import com.hukuta94.simplecalculator.domain.arabicroman.calculator.CalculatorFactory;
import com.hukuta94.simplecalculator.domain.arabicroman.model.Validator;
import com.hukuta94.simplecalculator.domain.arabicroman.model.InputData;

public class ArabicRomanCalculatorService
{
    private Validator validator;

    public ArabicRomanCalculatorService() {
        this.validator = new Validator();
    }

    public String calculate( String input ) {
        InputData inputData = validator.validateLineAndGetData( input );
        return CalculatorFactory.getCalculator( inputData, inputData.getType() ).calculate();
    }
}
