package com.hukuta94.simplecalculator.parser;

import com.hukuta94.simplecalculator.model.RomanNumeral;

public abstract class ArabicToRomanParser
{
    public static String parse( int number ) {
        // Use roman enum
        if( number <= 10 ) {
            return RomanNumeral.toRoman( number );
        }

        // Parse to roman
        int units = number % 10;
        int decades = ( number / 10 ) * 10; // (number/10) - remove all units to get decade count then multiply it to 10
        StringBuilder builder = new StringBuilder();
        builder.append( RomanNumeral.toRoman( decades ))
                .append( units > 0 ? RomanNumeral.toRoman( units ) : "" );

        return builder.toString();
    }
}
