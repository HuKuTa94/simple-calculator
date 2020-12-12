package com.hukuta94.simplecalculator.domain.physics.model;

public abstract class InputIndex
{
    // Input data array indexes
    public static final byte TEMPERATURE = 0;           // Температура (Т), [K]
    public static final byte CONTACT_AREA = 1;          // Площадь контактов (А, S), [см^2]
    public static final byte RICHARDSON_CONSTANT = 2;   // Постоянная Ричардсона (A*), [А/см^2 * K^2]
    public static final byte ZERO_CURRENT = 3;          // Нулевой ток (Is), [A]
    public static final byte COEFFICIENT_PZL = 4;       // Коэффициент ПЗЛ - полное заполнение ловушек (0), [без размерности]
    public static final byte PERMITTIVITY = 5;          // Диэлектрическая проницаемость (E), [без размерности]
    public static final byte MEMBRANE_THICKNESS = 6;    // Толщина пленки (L), [см]
    public static final byte AMPERAGE = 7;              // Сила тока (I), [A]
    public static final byte TRANSITION_VOLTAGE_TO_SQUARE_SECTION = 8; // Напряжение перехода к квадратичному участку (U1), [A]
}
