package com.hukuta94.simplecalculator.domain.physics.port.driving;

import com.hukuta94.simplecalculator.domain.physics.model.InputDataDto;

public interface UserInputPort
{
    double getResult( InputDataDto input );
}
