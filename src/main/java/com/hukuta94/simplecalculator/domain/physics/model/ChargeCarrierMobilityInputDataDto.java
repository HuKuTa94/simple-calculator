package com.hukuta94.simplecalculator.domain.physics.model;

import com.hukuta94.simplecalculator.domain.physics.calculator.CalculatorType;

import java.math.BigDecimal;

final public class ChargeCarrierMobilityInputDataDto extends InputDataDto
{
    public final BigDecimal AMPERAGE;           // Нулевой ток (Is), [A]
    public final BigDecimal CONTACT_AREA;           // Площадь контактов (А, S), [см^2]
    public final BigDecimal PERMITTIVITY;           // Диэлектрическая проницаемость (E), [без размерности]
    public final BigDecimal COEFFICIENT_PZL;        // Коэффициент ПЗЛ - полное заполнение ловушек (0), [без размерности]
    public final BigDecimal MEMBRANE_THICKNESS;     // Толщина пленки (L), [см]
    public final BigDecimal TRANSITION_VOLTAGE_TO_SQUARE_SECTION;    // Напряжение перехода к квадратичному участку (U1), [A]


    public ChargeCarrierMobilityInputDataDto(
            double amperage,
            double coefficientPZL,
            double membraneThickness,
            double transitionVoltageToSquareSection,
            double contactArea,
            double permittivity
    ) {
        calculatorType = CalculatorType.CHARGE_CARRIER_MOBILITY;
        AMPERAGE = new BigDecimal( amperage );
        CONTACT_AREA = new BigDecimal( contactArea );
        PERMITTIVITY = new BigDecimal( permittivity );
        COEFFICIENT_PZL = new BigDecimal( coefficientPZL );
        MEMBRANE_THICKNESS = new BigDecimal( membraneThickness );
        TRANSITION_VOLTAGE_TO_SQUARE_SECTION = new BigDecimal( transitionVoltageToSquareSection );
    }
}
