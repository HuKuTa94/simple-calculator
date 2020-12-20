package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.model.ChargeCarrierConcentrationInputDataDto;
import com.hukuta94.simplecalculator.domain.physics.model.InputDataDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Расчет концентрации носителей заряда
 * @Author Nikita Koshelev aka HuKuTa94
 * @version 1.02
 * Formula: (PZL*E*Eo*U1) / (q*L^2)
 */

public class ChargeCarrierConcentrationCalculator extends Calculator
{
    public ChargeCarrierConcentrationCalculator( InputDataDto inputDataDto ) {
        super( inputDataDto );
    }

    @Override
    public String calculate()
    {
        ChargeCarrierConcentrationInputDataDto input = (ChargeCarrierConcentrationInputDataDto) inputDataDto;

        /** PZL*E*Eo*U1 */
        BigDecimal PZL_E_Eo_U1 = new BigDecimal( input.COEFFICIENT_PZL.toString() )
                .multiply( input.PERMITTIVITY )
                .multiply( ELECTRIC_CONSTANT_E )
                .multiply( input.TRANSITION_VOLTAGE_TO_SQUARE_SECTION );


        /** q*L^2 */
        BigDecimal qL_pow2 = new BigDecimal( input.MEMBRANE_THICKNESS.toString() )
                .pow( 2 )
                .multiply( ELECTRON_CHARGE_q );


        /** result = (PZL*E*Eo*U1) / (q*L^2) */
        BigDecimal result = new BigDecimal( PZL_E_Eo_U1.toString() )
                .divide( qL_pow2, RoundingMode.FLOOR );


        return result.toString();
    }
}
