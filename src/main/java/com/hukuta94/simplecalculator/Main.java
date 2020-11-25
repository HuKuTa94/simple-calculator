package com.hukuta94.simplecalculator;

import com.hukuta94.simplecalculator.calculator.CalculatorFactory;
import com.hukuta94.simplecalculator.input.Input;
import com.hukuta94.simplecalculator.model.Data;

public class Main
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Roman/Arabic calculator!\nEnter two numbers like below:\n5 + 3\tor\tV + III (with spaces!)" );
        System.out.println( "Available operators:\n\t+ addition\n\t- subtraction" +
                "\n\t* multiplication\n\t/ division");
        System.out.println( "Available range of numbers:\n\t1 - 10\n\tI - X");

        while( true ) {
            System.out.println( "Enter two numbers:" );
            Data data = Input.getData();
            String result = CalculatorFactory.getCalculator( data, data.getType() ).calculate();
            System.out.println( result );
        }
    }
}
