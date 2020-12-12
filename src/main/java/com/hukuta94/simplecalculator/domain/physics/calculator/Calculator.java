package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.model.InputDataArray;

import java.math.BigDecimal;

/**
 * Base calculator class used with Reflection API.
 * All subclasses must have empty and all-args public constructors.
 * @Author Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

public abstract class Calculator
{
    // Constants
    static final BigDecimal BOLTZMANN_CONSTANT_k = new BigDecimal( Math.pow( 1.38 * 10, -23 ));
    static final BigDecimal ELECTRIC_CONSTANT_E = new BigDecimal( Math.pow( 8.85 * 10, -12 ));
    static final BigDecimal ELECTRON_CHARGE_q = new BigDecimal( Math.pow( 1.60 * 10, -19 ));

    InputDataArray input;

    Calculator(){}

    Calculator( InputDataArray input ) {
        this.input = input;
    }

    public abstract double calculate();
}
