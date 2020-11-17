package com.hukuta94.simplecalculator.input;

import com.hukuta94.simplecalculator.model.Data;
import java.util.Scanner;

public abstract class Input
{
    private static final Scanner scanner = new Scanner( System.in );

    public static Data getData() {
        return Validator.validateLineAndGetData( scanner.nextLine() );
    }
}
