package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.model.InputDataArray;
import com.hukuta94.simplecalculator.domain.physics.model.InputIndex;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Расчет подвижности носителей заряда
 * @Author Nikita Koshelev aka HuKuTa94
 * @version 1.0
 * Formula: ( (I/S) * L^3 ) / (PZL*E*Eo*U1^2)
 */
public class ChargeCarrierMobilityCalculator extends Calculator
{
    ChargeCarrierMobilityCalculator() {
        super();
    }

    ChargeCarrierMobilityCalculator( InputDataArray input ) {
        super( input );
}

    @Override
    public double calculate()
    {
        /** I/S */
        BigDecimal I_divide_S =
                new BigDecimal(
                    input.get( InputIndex.AMPERAGE ).doubleValue()
                )
                .divide( input.get( InputIndex.CONTACT_AREA ), RoundingMode.CEILING );


        /** L^3 */
        BigDecimal L_pow3 =
                new BigDecimal(
                    input.get( InputIndex.MEMBRANE_THICKNESS ).doubleValue()
                )
                .pow( 3 );


        /** PZL*E*Eo*U1^2 */
        BigDecimal PZL_E_E0_U1_pow2 =
                new BigDecimal(
                    input.get( InputIndex.TRANSITION_VOLTAGE_TO_SQUARE_SECTION ).doubleValue()
                )
                .pow( 2 )
                .multiply( ELECTRIC_CONSTANT_E )
                .multiply( input.get( InputIndex.COEFFICIENT_PZL ))
                .multiply( input.get( InputIndex.PERMITTIVITY ));


        /** Result = ( (I/S) * L^3 ) / (PZL*E*Eo*U1^2) */
        BigDecimal result =
                new BigDecimal(
                    I_divide_S.doubleValue()
                )
                .multiply( L_pow3 )
                .divide( PZL_E_E0_U1_pow2, RoundingMode.CEILING );


        return result.doubleValue();
    }
}
