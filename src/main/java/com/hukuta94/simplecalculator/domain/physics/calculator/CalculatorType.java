package com.hukuta94.simplecalculator.domain.physics.calculator;

public enum CalculatorType
{
    CHARGE_CARRIER_CONCENTRATION( ChargeCarrierConcentrationCalculator.class ),
    CHARGE_CARRIER_MOBILITY( ChargeCarrierMobilityCalculator.class ),
    POTENTIAL_BARRIER_BY_VOLT_AMPERE( PotentialBarrierByVoltAmpereCalculator.class );

    private Class className;

    CalculatorType( Class className ) {
        this.className = className;
    }

    public Class getClazz() {
        return className;
    }
}
