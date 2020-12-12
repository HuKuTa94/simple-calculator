package com.hukuta94.simplecalculator.domain.physics.model;

import com.hukuta94.simplecalculator.domain.physics.calculator.CalculatorType;

import java.math.BigDecimal;

final public class PotentialBarrierByVoltAmpereInputDataDto extends InputDataDto
{
    public final BigDecimal TEMPERATURE;            // Температура (Т), [K]
    public final BigDecimal CONTACT_AREA;           // Площадь контактов (А, S), [см^2]
    public final BigDecimal RICHARDSON_CONSTANT;    // Постоянная Ричардсона (A*), [А/см^2 * K^2]
    public final BigDecimal ZERO_CURRENT;           // Нулевой ток (Is), [A]

    public PotentialBarrierByVoltAmpereInputDataDto(
            double zeroCurrent,
            double temperature,
            double contactArea,
            double richardsonConstant
    ) {
        calculatorType = CalculatorType.POTENTIAL_BARRIER_BY_VOLT_AMPERE;
        TEMPERATURE = new BigDecimal( temperature );
        ZERO_CURRENT = new BigDecimal( zeroCurrent );
        CONTACT_AREA = new BigDecimal( contactArea );
        RICHARDSON_CONSTANT = new BigDecimal( richardsonConstant );
    }
}
