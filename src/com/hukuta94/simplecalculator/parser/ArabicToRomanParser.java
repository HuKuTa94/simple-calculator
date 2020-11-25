package com.hukuta94.simplecalculator.parser;

public abstract class ArabicToRomanParser
{
    private static final String[] THOUSANDS = { "", "M", "MM", "MMM" };
    private static final String[] HUNDREDS = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    private static final String[] TENS = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    private static final String[] UNITS = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

    public static String parse( int number )
    {
        StringBuilder roman = new StringBuilder();

        roman.append( THOUSANDS[ (number/1000) % 10 ])
             .append( HUNDREDS[ (number/100) % 10 ])
             .append( TENS[ (number/10) % 10 ])
             .append( UNITS[ number% 10 ]);

        return roman.toString();
    }
}
