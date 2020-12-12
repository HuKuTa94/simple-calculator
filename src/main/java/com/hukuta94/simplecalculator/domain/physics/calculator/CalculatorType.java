package com.hukuta94.simplecalculator.domain.physics.calculator;

/**
 * This enum used with Reflection API in CalculatorFactory class
 * @Author Nikita Koshelev aka HuKuTa94
 * @Version 1.0
 */

public enum CalculatorType
{
    POTENTIAL_BARRIER_BY_VOLT_AMPERE( PotentialBarrierByVoltAmpereCalculator.class ),
    CHARGE_CARRIER_CONCENTRATION( ChargeCarrierConcentrationCalculator.class ),
    CHARGE_CARRIER_MOBILITY( ChargeCarrierMobilityCalculator.class );

    private Class clazz;

    CalculatorType( Class clazz) {
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }
}
