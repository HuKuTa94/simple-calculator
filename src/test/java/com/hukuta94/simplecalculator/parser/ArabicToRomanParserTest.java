package com.hukuta94.simplecalculator.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArabicToRomanParserTest {
    @Test
    @DisplayName("Parser ArabicToRoman")
    public void testParse(){
        for (int i=1; i<4000; i++) {
            String roman = ArabicToRomanParser.parse(i);
            int arabic = RomanToArabicParser.parse(roman);
            Assertions.assertEquals(i, arabic);
        }
    }
}
