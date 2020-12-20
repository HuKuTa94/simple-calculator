package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.model.InputDataDto;
import com.hukuta94.simplecalculator.domain.physics.model.PotentialBarrierByVoltAmpereInputDataDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Расчет энергетического барьера по вольтамперной характеристике
 * @Author Nikita Koshelev aka HuKuTa94
 * @version 1.02
 * Formula: (kT / q) * ln( (AA*T^2) / Is );
 */

public class PotentialBarrierByVoltAmpereCalculator extends Calculator
{
    public PotentialBarrierByVoltAmpereCalculator( InputDataDto inputDataDto ) {
        super( inputDataDto );
    }

    @Override
    public String calculate()
    {
        PotentialBarrierByVoltAmpereInputDataDto input = (PotentialBarrierByVoltAmpereInputDataDto) inputDataDto;

        /** kT / q */
        BigDecimal kT_divide_q =
                new BigDecimal( BOLTZMANN_CONSTANT_k.toString() )
                    .multiply( input.TEMPERATURE )
                    .divide( ELECTRON_CHARGE_q, RoundingMode.CEILING );


        /** (AA*T^2) / Is */
        BigDecimal AA_T_pow2_divide_Is =
                new BigDecimal( input.TEMPERATURE.toString() )
                    .pow( 2 )
                    .multiply( input.CONTACT_AREA )
                    .multiply( input.RICHARDSON_CONSTANT )
                    .divide( input.ZERO_CURRENT , RoundingMode.CEILING );


        /**  Ln( (AA*T^2) / Is ) */
        BigDecimal Ln = BigDecimal.valueOf(
                Math.log( AA_T_pow2_divide_Is.doubleValue() ));


        /** Result = (kT / q) * ln( (AA*T^2) / Is ) */
        BigDecimal result =
                new BigDecimal( kT_divide_q.toString() )
                    .multiply( Ln );


        return result.toString();
    }
}
