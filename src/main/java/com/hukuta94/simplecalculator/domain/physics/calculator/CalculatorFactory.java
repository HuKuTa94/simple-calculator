package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.model.InputDataArray;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class CalculatorFactory
{
    protected CalculatorFactory() throws NoSuchMethodException {
    }

    public static Calculator getCalculator( InputDataArray inputData ) throws IllegalAccessException, InstantiationException {
        Class clazz = inputData.getCalculatorType().getClazz();
        Calculator calculator = (Calculator) clazz.newInstance();
        calculator.setInputData( inputData );
        return calculator;


//        Constructor constructor = clazz.getConstructor( InputDataArray.class );
//        return (Calculator) clazz.cast( constructor.newInstance( inputData ));
//        return switch( inputData.getCalculatorType() ) {
//            case CHARGE_CARRIER_MOBILITY  -> new ChargeCarrierMobilityCalculator( inputData );
//            case CHARGE_CARRIER_CONCENTRATION -> new ChargeCarrierConcentrationCalculator( inputData );
//            case POTENTIAL_BARRIER_BY_VOLT_AMPERE  -> new PotentialBarrierByVoltAmpereCalculator( inputData );
//        };
    }
}
