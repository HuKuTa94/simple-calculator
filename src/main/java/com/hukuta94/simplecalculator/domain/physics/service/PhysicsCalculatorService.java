package com.hukuta94.simplecalculator.domain.physics.service;

import com.hukuta94.simplecalculator.domain.physics.calculator.CalculatorFactory;
import com.hukuta94.simplecalculator.domain.physics.model.InputDataArray;

import java.lang.reflect.InvocationTargetException;

public class PhysicsCalculatorService
{
    public double calculate( InputDataArray input ) {
        try {
            return CalculatorFactory.getCalculator( input ).calculate();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}
