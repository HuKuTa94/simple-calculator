package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.model.InputDataDto;

import java.lang.reflect.Constructor;

/**
 * The class uses Reflection API to detect required calculator subclass
 * @Author Nikita Koshelev aka HuKuTa94
 * @Version 1.01
 */

public abstract class CalculatorFactory
{
    protected CalculatorFactory() {
    }

    public static Calculator getCalculator( InputDataDto inputData )
    {
        try {
            // Get required calculator class from enum's value
            Class clazz = inputData.getCalculatorType().getClazz();

            // Get constructor of calculator's class with parameter
            Constructor<Calculator> constructor = clazz.getConstructor( InputDataDto.class );

            // Create new instance and pass inputData
            return (Calculator) clazz.cast( constructor.newInstance( inputData ));
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }
}
