package com.hukuta94.simplecalculator.calculator;

import com.hukuta94.simplecalculator.model.Data;
import com.hukuta94.simplecalculator.model.NumberType;

public abstract class CalculatorFactory
{
    public static Calculator getCalculator( Data data, NumberType type ) {
        return switch( type ) {
            case ARABIC -> new ArabicCalculator( data );
            case ROMAN -> new RomanCalculator( data );
        };
    }
}
