package com.hukuta94.simplecalculator.domain.physics.service;

import com.hukuta94.simplecalculator.domain.physics.calculator.CalculatorFactory;
import com.hukuta94.simplecalculator.domain.physics.model.InputDataArray;

public class PhysicsCalculatorService
{
    public double calculate( InputDataArray input ) {
        return CalculatorFactory.getCalculator( input ).calculate();
    }
}
