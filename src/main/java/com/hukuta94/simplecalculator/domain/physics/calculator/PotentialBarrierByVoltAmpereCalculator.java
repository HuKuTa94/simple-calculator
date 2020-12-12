package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.model.InputDataDto;
import com.hukuta94.simplecalculator.domain.physics.model.PotentialBarrierByVoltAmpereInputDataDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Расчет энергетического барьера по вольтамперной характеристике
 * @Author Nikita Koshelev aka HuKuTa94
 * @version 1.01
 * Formula: (kT / q) * ln( (AA*T^2) / Is );
 */

public class PotentialBarrierByVoltAmpereCalculator extends Calculator
{
    private PotentialBarrierByVoltAmpereInputDataDto input;

    public PotentialBarrierByVoltAmpereCalculator() {
        super();
    }
    
    public PotentialBarrierByVoltAmpereCalculator( InputDataDto input ) {
        super();
        this.input = (PotentialBarrierByVoltAmpereInputDataDto) input;
    }

    @Override
    public double calculate()
    {
        /** kT / q */
        BigDecimal kT_divide_q =
                new BigDecimal( BOLTZMANN_CONSTANT_k.doubleValue() )
                    .multiply( input.TEMPERATURE )
                    .divide( ELECTRON_CHARGE_q, RoundingMode.UNNECESSARY );


        /** (AA*T^2) / Is */
        BigDecimal AA_T_pow2_divide_Is =
                new BigDecimal( input.TEMPERATURE.doubleValue() )
                    .pow( 2 )
                    .multiply( input.CONTACT_AREA )
                    .multiply( input.RICHARDSON_CONSTANT )
                    .divide( input.ZERO_CURRENT , RoundingMode.CEILING );


        /**  Ln( (AA*T^2) / Is ) */
        BigDecimal Ln =
                new BigDecimal(
                    Math.log( AA_T_pow2_divide_Is.doubleValue() )
                );


        /** Result = (kT / q) * ln( (AA*T^2) / Is ) */
        BigDecimal result =
                new BigDecimal(
                        kT_divide_q.doubleValue()
                )
                .multiply( Ln );


        return result.doubleValue();
    }
}
