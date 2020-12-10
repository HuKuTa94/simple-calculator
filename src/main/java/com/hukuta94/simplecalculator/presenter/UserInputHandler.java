package com.hukuta94.simplecalculator.presenter;

import com.hukuta94.simplecalculator.domain.arabicroman.port.driving.UserInputPort;
import com.hukuta94.simplecalculator.domain.arabicroman.service.ArabicRomanCalculatorService;

public class UserInputHandler implements UserInputPort
{
    private ArabicRomanCalculatorService service;

    public UserInputHandler( ArabicRomanCalculatorService service ) {
        this.service = service;
    }

    @Override
    public String getResult( String inputLine ) {
        return service.calculate( inputLine );
    }
}
