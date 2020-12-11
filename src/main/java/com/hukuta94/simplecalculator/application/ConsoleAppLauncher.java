package com.hukuta94.simplecalculator.application;

import com.hukuta94.simplecalculator.domain.arabicroman.port.driven.PrintResultPort;
import com.hukuta94.simplecalculator.domain.arabicroman.port.driving.UserInputPort;
import com.hukuta94.simplecalculator.domain.arabicroman.service.ArabicRomanCalculatorService;
import com.hukuta94.simplecalculator.presenter.ConsolePrinter;
import com.hukuta94.simplecalculator.presenter.UserInputHandler;

import java.util.Scanner;

public class ConsoleAppLauncher
{
    private static final String WELCOME_MESSAGE =
            "Welcome to Roman/Arabic calculator!\n" +
            "Enter two numbers like below:\n5 + 3\tor\tV + III\n" +
            "Available operators:\n\t+ addition\n\t- subtraction\n\t* multiplication\n\t/ division\n" +
            "Available range of numbers:\n\tArabic: from 1\n\tRoman: from I";

    private static PrintResultPort printer;
    private static UserInputPort userInput;
    private static Scanner scanner;

    public static void main( String[] args )
    {
        ConsoleAppInit();
        printer.print( WELCOME_MESSAGE );

        while( true ) {
            printer.print( "Enter two numbers:" );
            String result = userInput.getResult( scanner.nextLine() );
            printer.print( result );
        }
    }

    private static void ConsoleAppInit() {
        printer = new ConsolePrinter();
        scanner = new Scanner( System.in );
        userInput = new UserInputHandler( new ArabicRomanCalculatorService() );
    }
}
