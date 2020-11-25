package com.hukuta94.simplecalculator.input;

import com.hukuta94.simplecalculator.model.Data;
import com.hukuta94.simplecalculator.model.NumberType;
import com.hukuta94.simplecalculator.model.RomanNumeral;

abstract class Validator
{
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;
    private static final String ROMAN_NUMBERS = "IVXLCM";
    private static final String REGEX_SPLIT = "\\s";
    private static final int FIRST_NUMBER_INDEX = 0;
    private static final int SECOND_NUMBER_INDEX = 2;
    private static final int OPERATOR_INDEX = 1;

    static Data validateLineAndGetData(String line) {
        String[] strNumbers = line.toUpperCase().split( REGEX_SPLIT );

        if( strNumbers.length != 3 ) {
            throw new IllegalArgumentException( "Expected two numbers and one operator ('+', '-', '*', '/')" );
        }

        // Numbers are not same type
        NumberType type1 = getNumberType( strNumbers[ FIRST_NUMBER_INDEX ] );
        NumberType type2 = getNumberType( strNumbers[ SECOND_NUMBER_INDEX ] );
        if (type1 != type2) {
            throw new IllegalArgumentException( "Numbers are not same type: " + strNumbers[ FIRST_NUMBER_INDEX ] + ", " + strNumbers[ SECOND_NUMBER_INDEX ]);
        }

        int[] intNumbers = new int[ 3 ];
        for( int i = 0; i < strNumbers.length; i++ )
        {
            // Parse number
            if ( i != OPERATOR_INDEX )
            {
                intNumbers[i] = parseNumberToInt( strNumbers[i] );

                if( intNumbers[i] < MIN_NUMBER || intNumbers[i] > MAX_NUMBER ) {
                    throw new IllegalArgumentException( "number " + intNumbers[i] + " is out of range");
                }
            }
            // Validate operator
            else
            {
                if( !validateOperator( strNumbers[ OPERATOR_INDEX ] )) {
                    throw new IllegalArgumentException( "Unknown arithmetic operator " + strNumbers[ OPERATOR_INDEX ]);
                }
            }
        }

        return new Data(
                intNumbers[ FIRST_NUMBER_INDEX ],
                intNumbers[ SECOND_NUMBER_INDEX ],
                strNumbers[ OPERATOR_INDEX ],
                getNumberType( strNumbers[ FIRST_NUMBER_INDEX ])
        );
    }

    private static int parseNumberToInt( String stringNumber ) {
        int result = 0;

        // This number is Arabic
        try {
            result = Integer.parseInt( stringNumber );
        }
        // This number is Roman
        catch( NumberFormatException e ) {
            result = RomanNumeral.toArabic( stringNumber );
        }
        return result;
    }

    private static boolean validateOperator( String operator ) {
        return  operator.equals( "+" ) || operator.equals( "-" ) ||
                operator.equals( "*" ) || operator.equals( "/" );
    }

    private static NumberType getNumberType( String number ) {
        if ( Character.isDigit( number.charAt( 0 )) ) {
            return NumberType.ARABIC;
        }
        else if ( ROMAN_NUMBERS.contains( number.substring( 0, 1 )) ) {
            return NumberType.ROMAN;
        }
        throw new IllegalArgumentException( number + " is not a number" );
    }
}
