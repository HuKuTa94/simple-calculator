package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.model.InputDataArray;
import com.hukuta94.simplecalculator.domain.physics.model.InputIndex;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Расчет энергетического барьера по вольтамперной характеристике
 * @Author Nikita Koshelev aka HuKuTa94
 * @version 1.0
 * Formula: (kT / q) * ln( (AA*T^2) / Is );
 */

public class PotentialBarrierByVoltAmpereCalculator extends Calculator
{
    public PotentialBarrierByVoltAmpereCalculator() {
        super();
    }
    
    public PotentialBarrierByVoltAmpereCalculator( InputDataArray input ) {
        super( input );
    }

    @Override
    public double calculate()
    {
        /** kT / q */
        BigDecimal kT_divide_q =
                new BigDecimal(
                        BOLTZMANN_CONSTANT_k.doubleValue()
                )
                .multiply( input.get( InputIndex.TEMPERATURE ))
                .divide( ELECTRON_CHARGE_q, RoundingMode.UNNECESSARY );


        /** (AA*T^2) / Is */
        BigDecimal AA_T_pow2_divide_Is =
                new BigDecimal(
                        input.get( InputIndex.TEMPERATURE).doubleValue()
                )
                .pow( 2 )
                .multiply( input.get( InputIndex.CONTACT_AREA ))
                .multiply( input.get( InputIndex.RICHARDSON_CONSTANT ))
                .divide( input.get( InputIndex.ZERO_CURRENT ), RoundingMode.CEILING );


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
