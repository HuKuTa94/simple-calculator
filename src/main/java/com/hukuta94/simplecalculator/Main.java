package com.hukuta94.simplecalculator;

import com.hukuta94.simplecalculator.domain.arabicroman.port.driving.UserInputPort;
import com.hukuta94.simplecalculator.domain.arabicroman.service.ArabicRomanCalculatorService;
import com.hukuta94.simplecalculator.presenter.ConsolePrinter;
import com.hukuta94.simplecalculator.presenter.UserInputHandler;

import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.printWelcomeMessage();
        UserInputPort arabicRomanAdapter = new UserInputHandler( new ArabicRomanCalculatorService() );
        Scanner scanner = new Scanner( System.in );

        while( true ) {
            consolePrinter.print( "Enter two numbers:" );
            String result = arabicRomanAdapter.getResult( scanner.nextLine() );
            consolePrinter.print( result );
        }
    }
}
