package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.model.InputDataArray;
import com.hukuta94.simplecalculator.domain.physics.model.InputIndex;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Расчет концентрации носителей заряда
 * @Author Nikita Koshelev aka HuKuTa94
 * @version 1.0
 * Formula: (PZL*E*Eo*U1) / (q*L^2)
 */
public class ChargeCarrierConcentrationCalculator extends Calculator
{
    ChargeCarrierConcentrationCalculator(){
        super();
    }

    ChargeCarrierConcentrationCalculator( InputDataArray input ) {
        super( input );
    }

    @Override
    public double calculate()
    {
        /** PZL*E*Eo*U1 */
        BigDecimal PZL_E_Eo_U1 = new BigDecimal( input.get( InputIndex.COEFFICIENT_PZL ).doubleValue() )
                .multiply( input.get( InputIndex.PERMITTIVITY ))
                .multiply( ELECTRIC_CONSTANT_E )
                .multiply( input.get( InputIndex.TRANSITION_VOLTAGE_TO_SQUARE_SECTION ));


        /** q*L^2 */
        BigDecimal qL_pow2 = new BigDecimal( input.get( InputIndex.MEMBRANE_THICKNESS ).doubleValue() )
                .pow( 2 )
                .multiply( ELECTRON_CHARGE_q );


        /** result = (PZL*E*Eo*U1) / (q*L^2) */
        BigDecimal result = new BigDecimal( PZL_E_Eo_U1.doubleValue() )
                .divide( qL_pow2, RoundingMode.CEILING );


        return result.doubleValue();
    }
}
