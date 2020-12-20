package com.hukuta94.simplecalculator.application;

import com.hukuta94.simplecalculator.domain.physics.model.ChargeCarrierConcentrationInputDataDto;
import com.hukuta94.simplecalculator.domain.physics.model.ChargeCarrierMobilityInputDataDto;
import com.hukuta94.simplecalculator.domain.physics.model.InputDataDto;
import com.hukuta94.simplecalculator.domain.physics.model.PotentialBarrierByVoltAmpereInputDataDto;
import com.hukuta94.simplecalculator.domain.physics.port.driving.UserInputPort;
import com.hukuta94.simplecalculator.domain.physics.service.PhysicsCalculatorService;
import com.hukuta94.simplecalculator.presenter.physics.UserInput;

public class ConsolePhysicsAppLauncher
{
    public static void main( String[] args )
    {
        UserInputPort userInput = new UserInput(new PhysicsCalculatorService());


        InputDataDto chargeCarrierConcentrationInput = new ChargeCarrierConcentrationInputDataDto(
                "0.00234",
                "0.21",
                "2.220001",
                "0.32"
        );
        System.out.println( "Концентрация носителей заряда: " + userInput.getResult( chargeCarrierConcentrationInput ));


        InputDataDto chargeCarrierMobilityInput = new ChargeCarrierMobilityInputDataDto(
                "2.9",
                "0.21",
                "2.220001",
                "0.32",
                "0.02",
                "0.00234"
        );
        System.out.println( "Подвижность носителей заряда: " + userInput.getResult( chargeCarrierMobilityInput ));


        InputDataDto potentialBarrierByVoltAmpereInput = new PotentialBarrierByVoltAmpereInputDataDto(
                "1.2",
                "100.0",
                "0.02",
                "1.000021"
        );

        System.out.println( "Потенциальный барьер по вольт-амперной характеристике: " +
                userInput.getResult( potentialBarrierByVoltAmpereInput ));
    }
}
