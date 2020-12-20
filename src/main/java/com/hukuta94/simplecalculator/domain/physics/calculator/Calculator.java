package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.model.InputDataDto;

import java.math.BigDecimal;

/**
 * Base calculator class used with Reflection API.
 * All subclasses must have empty and all-args public constructors.
 * @Author Nikita Koshelev aka HuKuTa94
 * @version 1.02
 */

public abstract class Calculator
{
    // Constants
    static final BigDecimal BOLTZMANN_CONSTANT_k = BigDecimal.valueOf( Math.pow( 1.38 * 10, -23 ));
    static final BigDecimal ELECTRIC_CONSTANT_E  = BigDecimal.valueOf( Math.pow( 8.85 * 10, -12 ));
    static final BigDecimal ELECTRON_CHARGE_q    = BigDecimal.valueOf( Math.pow( 1.60 * 10, -19 ));

    // Input data for calculations in subclasses
    protected InputDataDto inputDataDto;


    Calculator( InputDataDto input ) {
        this.inputDataDto = input;
    }


    public abstract String calculate();

    public void setInputDataDto(InputDataDto inputDataDto) {
        this.inputDataDto = inputDataDto;
    }
}
