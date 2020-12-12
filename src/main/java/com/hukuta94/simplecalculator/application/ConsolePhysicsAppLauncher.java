package com.hukuta94.simplecalculator.application;

import com.hukuta94.simplecalculator.domain.physics.calculator.CalculatorType;
import com.hukuta94.simplecalculator.domain.physics.model.InputDataArray;
import com.hukuta94.simplecalculator.domain.physics.port.driving.UserInputPort;
import com.hukuta94.simplecalculator.domain.physics.service.PhysicsCalculatorService;
import com.hukuta94.simplecalculator.presenter.physics.UserInput;

public class ConsolePhysicsAppLauncher
{
    private static UserInputPort userInput;

    public static void main( String[] args )
    {
        userInput = new UserInput( new PhysicsCalculatorService() );

        InputDataArray inputChargeCarrierConcentration = new InputDataArray(
            CalculatorType.CHARGE_CARRIER_CONCENTRATION,
            100.0,
            0.02,
            1.000021,
            1.2,
            0.21,
            0.00234,
            2.220001,
            2.9,
            0.32
        );

        System.out.println( "Концентрация носителей заряда: " + userInput.getResult( inputChargeCarrierConcentration ));

        inputChargeCarrierConcentration.setCalculatorType( CalculatorType.CHARGE_CARRIER_MOBILITY );
        System.out.println( "Подвижность носителей заряда: "  + userInput.getResult( inputChargeCarrierConcentration ));

        inputChargeCarrierConcentration.setCalculatorType( CalculatorType.POTENTIAL_BARRIER_BY_VOLT_AMPERE );
        System.out.println( "Потенциальный барьер по вольт-амперной характеристике: "  + userInput.getResult( inputChargeCarrierConcentration ));
    }
}
