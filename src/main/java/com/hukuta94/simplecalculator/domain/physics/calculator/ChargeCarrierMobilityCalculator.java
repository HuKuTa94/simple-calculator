package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.model.ChargeCarrierMobilityInputDataDto;
import com.hukuta94.simplecalculator.domain.physics.model.InputDataDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Расчет подвижности носителей заряда
 * @Author Nikita Koshelev aka HuKuTa94
 * @version 1.02
 * Formula: ( (I/S) * L^3 ) / (PZL*E*Eo*U1^2)
 */

public class ChargeCarrierMobilityCalculator extends Calculator
{
    public ChargeCarrierMobilityCalculator( InputDataDto inputDataDto ) {
        super( inputDataDto );
    }

    @Override
    public String calculate()
    {
        ChargeCarrierMobilityInputDataDto input = (ChargeCarrierMobilityInputDataDto) inputDataDto;

        /** I/S */
        BigDecimal I_divide_S =
                new BigDecimal( input.AMPERAGE.toString() )
                    .divide( input.CONTACT_AREA, RoundingMode.CEILING );


        /** L^3 */
        BigDecimal L_pow3 =
                new BigDecimal( input.MEMBRANE_THICKNESS.toString() ).pow( 3 );


        /** PZL*E*Eo*U1^2 */
        BigDecimal PZL_E_E0_U1_pow2 =
                new BigDecimal( input.TRANSITION_VOLTAGE_TO_SQUARE_SECTION.toString() )
                    .pow( 2 )
                    .multiply( ELECTRIC_CONSTANT_E )
                    .multiply( input.COEFFICIENT_PZL )
                    .multiply( input.PERMITTIVITY );


        /** Result = ( (I/S) * L^3 ) / (PZL*E*Eo*U1^2) */
        BigDecimal result =
                new BigDecimal( I_divide_S.toString() )
                    .multiply( L_pow3 )
                    .divide( PZL_E_E0_U1_pow2, RoundingMode.CEILING );


        return result.toString();
    }
}
