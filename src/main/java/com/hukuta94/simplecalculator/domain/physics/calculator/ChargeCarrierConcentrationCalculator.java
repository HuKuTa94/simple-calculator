package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.model.ChargeCarrierConcentrationInputDataDto;
import com.hukuta94.simplecalculator.domain.physics.model.InputDataDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Расчет концентрации носителей заряда
 * @Author Nikita Koshelev aka HuKuTa94
 * @version 1.01
 * Formula: (PZL*E*Eo*U1) / (q*L^2)
 */

public class ChargeCarrierConcentrationCalculator extends Calculator
{
    private ChargeCarrierConcentrationInputDataDto input;

    public ChargeCarrierConcentrationCalculator(){
        super();
    }

    public ChargeCarrierConcentrationCalculator( InputDataDto input ) {
        super();
        this.input = (ChargeCarrierConcentrationInputDataDto) input;
    }

    @Override
    public double calculate()
    {
        /** PZL*E*Eo*U1 */
        BigDecimal PZL_E_Eo_U1 = new BigDecimal( input.COEFFICIENT_PZL.doubleValue() )
                .multiply( input.PERMITTIVITY )
                .multiply( ELECTRIC_CONSTANT_E )
                .multiply( input.TRANSITION_VOLTAGE_TO_SQUARE_SECTION );


        /** q*L^2 */
        BigDecimal qL_pow2 = new BigDecimal( input.MEMBRANE_THICKNESS.doubleValue() )
                .pow( 2 )
                .multiply( ELECTRON_CHARGE_q );


        /** result = (PZL*E*Eo*U1) / (q*L^2) */
        BigDecimal result = new BigDecimal( PZL_E_Eo_U1.doubleValue() )
                .divide( qL_pow2, RoundingMode.CEILING );


        return result.doubleValue();
    }
}
