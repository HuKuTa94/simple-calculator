package com.hukuta94.simplecalculator.domain.physics.model;

import com.hukuta94.simplecalculator.domain.physics.calculator.CalculatorType;

/**
 * Class for creating immutable DTO input data.
 * This class used by Calculator subclasses as base class of input data.
 * @Author Nikita Koshelev aka HuKuTa94
 * @version 1.0
 */

public abstract class InputDataDto
{
    CalculatorType calculatorType;

    public CalculatorType getCalculatorType() {
        return calculatorType;
    }
}
