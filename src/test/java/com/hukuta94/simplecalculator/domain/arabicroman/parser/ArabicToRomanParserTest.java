package com.hukuta94.simplecalculator.domain.arabicroman.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArabicToRomanParserTest extends AbstractParserTest
{
    @Test
    @DisplayName( "Parser ArabicToRoman" )
    void testParse(){
        for ( int i = 1; i < 4000; i++ ) {
            String roman = arabicToRomanParser.parse( i );
            int arabic = romanToArabicParser.parse( roman );
            Assertions.assertEquals( i, arabic );
        }
    }
}
