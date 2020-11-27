package com.hukuta94.simplecalculator;

import com.hukuta94.simplecalculator.parser.ArabicToRomanParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest
{
    @DisplayName( "Parse arabic number to roman number" )
    @Test
    void testParseRomanNumber() {
        int number = 1985;
        String expected = "MCMLXXXV"; // 1985
        Assertions.assertEquals( expected, ArabicToRomanParser.parse( number ));
    }
}
