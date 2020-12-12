package com.hukuta94.simplecalculator.domain.physics.model;

import com.hukuta94.simplecalculator.domain.physics.calculator.CalculatorType;

import java.math.BigDecimal;

/**
 * Class for creating DTO input data.
 * This class used by Calculator subclasses
 * @Author Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

public class InputDataArray
{
    private CalculatorType calculatorType;
    private BigDecimal[] input;

    public InputDataArray(
            CalculatorType calculatorType,
            double TEMPERATURE,
            double CONTACT_AREA,
            double RICHARDSON_CONSTANT,
            double ZERO_CURRENT,
            double COEFFICIENT_PZL,
            double PERMITTIVITY,
            double MEMBRANE_THICKNESS,
            double AMPERAGE,
            double TRANSITION_VOLTAGE_TO_SQUARE_SECTION
    ) {
        this.calculatorType = calculatorType;
        input = new BigDecimal[ 9 ];
        input[ InputIndex.AMPERAGE ] = new BigDecimal( AMPERAGE );
        input[ InputIndex.TEMPERATURE ] = new BigDecimal( TEMPERATURE );
        input[ InputIndex.CONTACT_AREA ] = new BigDecimal( CONTACT_AREA );
        input[ InputIndex.ZERO_CURRENT ] = new BigDecimal( ZERO_CURRENT );
        input[ InputIndex.PERMITTIVITY ] = new BigDecimal( PERMITTIVITY );
        input[ InputIndex.COEFFICIENT_PZL ] = new BigDecimal( COEFFICIENT_PZL );
        input[ InputIndex.MEMBRANE_THICKNESS ] = new BigDecimal( MEMBRANE_THICKNESS );
        input[ InputIndex.RICHARDSON_CONSTANT ] = new BigDecimal( RICHARDSON_CONSTANT) ;
        input[ InputIndex.TRANSITION_VOLTAGE_TO_SQUARE_SECTION ] = new BigDecimal( TRANSITION_VOLTAGE_TO_SQUARE_SECTION );
    }

    public BigDecimal get( int index )
    {
        // Return last element
        if( index >= input.length ) {
            return input[ input.length - 1 ];
        }

        // Return the first element
        if( index < 0 ) {
            return input[ 0 ];
        }

        return input[ index ];
    }

    public CalculatorType getCalculatorType() {
        return calculatorType;
    }

    public void setCalculatorType( CalculatorType calculatorType ) {
        this.calculatorType = calculatorType;
    }
}
