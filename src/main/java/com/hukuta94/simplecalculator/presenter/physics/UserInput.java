package com.hukuta94.simplecalculator.presenter.physics;

import com.hukuta94.simplecalculator.domain.physics.model.InputDataArray;
import com.hukuta94.simplecalculator.domain.physics.port.driving.UserInputPort;
import com.hukuta94.simplecalculator.domain.physics.service.PhysicsCalculatorService;

public class UserInput implements UserInputPort
{
    private PhysicsCalculatorService service;

    public UserInput( PhysicsCalculatorService service ) {
        this.service = service;
    }

    @Override
    public double getResult(InputDataArray input ) {
        return service.calculate( input );
    }
}
