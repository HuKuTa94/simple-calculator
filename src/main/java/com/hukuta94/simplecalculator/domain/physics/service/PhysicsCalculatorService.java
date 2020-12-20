package com.hukuta94.simplecalculator.domain.physics.service;

import com.hukuta94.simplecalculator.domain.physics.calculator.CalculatorFactory;
import com.hukuta94.simplecalculator.domain.physics.model.InputDataDto;

public class PhysicsCalculatorService
{
    public String calculate( InputDataDto input ) {
        return CalculatorFactory.getCalculator( input ).calculate();
    }
}
