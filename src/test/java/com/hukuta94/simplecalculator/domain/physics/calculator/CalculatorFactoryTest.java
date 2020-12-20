package com.hukuta94.simplecalculator.domain.physics.calculator;

import com.hukuta94.simplecalculator.domain.physics.calculator.CalculatorFactory;
import com.hukuta94.simplecalculator.domain.physics.calculator.ChargeCarrierConcentrationCalculator;
import com.hukuta94.simplecalculator.domain.physics.calculator.ChargeCarrierMobilityCalculator;
import com.hukuta94.simplecalculator.domain.physics.calculator.PotentialBarrierByVoltAmpereCalculator;
import com.hukuta94.simplecalculator.domain.physics.model.ChargeCarrierConcentrationInputDataDto;
import com.hukuta94.simplecalculator.domain.physics.model.ChargeCarrierMobilityInputDataDto;
import com.hukuta94.simplecalculator.domain.physics.model.PotentialBarrierByVoltAmpereInputDataDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorFactoryTest
{
    private static ChargeCarrierMobilityInputDataDto chargeCarrierMobilityInput;
    private static ChargeCarrierConcentrationInputDataDto chargeCarrierConcentrationInput;
    private static PotentialBarrierByVoltAmpereInputDataDto potentialBarrierByVoltAmpereInput;

    @BeforeAll
    static void testInit() {
        chargeCarrierMobilityInput = new ChargeCarrierMobilityInputDataDto(
                "1",
                "1",
                "1",
                "1",
                "1",
                "1"
        );

        chargeCarrierConcentrationInput = new ChargeCarrierConcentrationInputDataDto(
                "1",
                "1",
                "1",
                "1"
        );

        potentialBarrierByVoltAmpereInput = new PotentialBarrierByVoltAmpereInputDataDto(
                "1",
                "1",
                "1",
                "1"
        );
    }

    @Test
    @DisplayName( "Factory: Charge carrier mobility calculator" )
    void testChargeCarrierMobilityCalculator() {
        ChargeCarrierMobilityCalculator calculator =
                (ChargeCarrierMobilityCalculator) CalculatorFactory.getCalculator( chargeCarrierMobilityInput );
    }

    @Test
    @DisplayName( "Factory: Charge carrier concentration calculator" )
    void testChargeCarrierConcentrationCalculator() {
        ChargeCarrierConcentrationCalculator calculator =
                (ChargeCarrierConcentrationCalculator) CalculatorFactory.getCalculator( chargeCarrierConcentrationInput );
    }

    @Test
    @DisplayName( "Factory: Potential barrier by volt ampere calculator" )
    void testPotentialBarrierByVoltAmpereCalculator() {
        PotentialBarrierByVoltAmpereCalculator calculator =
                (PotentialBarrierByVoltAmpereCalculator) CalculatorFactory.getCalculator( potentialBarrierByVoltAmpereInput );
    }
}
