package com.hukuta94.simplecalculator.domain.physics.model;

import com.hukuta94.simplecalculator.domain.physics.calculator.CalculatorType;

import java.math.BigDecimal;

final public class ChargeCarrierConcentrationInputDataDto extends InputDataDto
{
    public final BigDecimal PERMITTIVITY;           // Диэлектрическая проницаемость (E), [без размерности]
    public final BigDecimal COEFFICIENT_PZL;        // Коэффициент ПЗЛ - полное заполнение ловушек (0), [без размерности]
    public final BigDecimal MEMBRANE_THICKNESS;     // Толщина пленки (L), [см]
    public final BigDecimal TRANSITION_VOLTAGE_TO_SQUARE_SECTION;    // Напряжение перехода к квадратичному участку (U1), [A]

    public ChargeCarrierConcentrationInputDataDto(
            double permittivity,
            double coefficientPZL,
            double membraneThickness,
            double transitionVoltageToSquareSection
    ) {
        calculatorType = CalculatorType.CHARGE_CARRIER_CONCENTRATION;
        PERMITTIVITY = new BigDecimal( permittivity );
        COEFFICIENT_PZL = new BigDecimal( coefficientPZL );
        MEMBRANE_THICKNESS = new BigDecimal( membraneThickness );
        TRANSITION_VOLTAGE_TO_SQUARE_SECTION = new BigDecimal( transitionVoltageToSquareSection );
    }
}
