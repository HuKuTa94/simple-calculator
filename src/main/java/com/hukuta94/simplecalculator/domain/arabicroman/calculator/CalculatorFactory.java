package com.hukuta94.simplecalculator.domain.arabicroman.calculator;

import com.hukuta94.simplecalculator.domain.arabicroman.model.InputData;
import com.hukuta94.simplecalculator.domain.arabicroman.model.NumberType;

public abstract class CalculatorFactory
{
    public static Calculator getCalculator(InputData inputData, NumberType type ) {
        return switch( type ) {
            case ARABIC -> new ArabicCalculator(inputData);
            case ROMAN -> new RomanCalculator(inputData);
        };
    }
}
