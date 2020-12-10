package com.hukuta94.simplecalculator.domain.arabicroman.parser;

import com.hukuta94.simplecalculator.domain.arabicroman.model.RomanNumeral;

public class ArabicToRomanParser
{
    public String parse( int number )
    {
        String THOUSANDS = RomanNumeral.toRoman(( number/1000 ) * 1000 );
        String HUNDREDS  = RomanNumeral.toRoman((( number/100 ) % 10 ) * 100 );
        String TENS  = RomanNumeral.toRoman((( number/10 ) % 10 ) * 10 );
        String UNITS = RomanNumeral.toRoman( number % 10 );

        return THOUSANDS + HUNDREDS + TENS + UNITS;
    }
}
