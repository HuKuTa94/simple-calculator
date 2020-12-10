package com.hukuta94.simplecalculator.presenter;

import com.hukuta94.simplecalculator.domain.arabicroman.port.driven.PrintResultPort;

public class ConsolePrinter implements PrintResultPort
{
    private static final String welcomeMessage = "Welcome to Roman/Arabic calculator!\nEnter two numbers like below:\n5 + 3\tor\tV + III (with spaces!)\n" +
            "Available operators:\n\t+ addition\n\t- subtraction\n\t* multiplication\n\t/ division\n Available range of numbers:\n\tfrom 1\n\tfrom I";

    public void printWelcomeMessage() {
        print( welcomeMessage );
    }

    @Override
    public void print( String result ) {
        System.out.println( result );
    }
}
