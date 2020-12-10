package com.hukuta94.simplecalculator.domain.arabicroman.parser;

import org.junit.jupiter.api.BeforeAll;

class AbstractParserTest
{
    static ArabicToRomanParser arabicToRomanParser;
    static RomanToArabicParser romanToArabicParser;

    @BeforeAll
    static void testInit() {
        arabicToRomanParser = new ArabicToRomanParser();
        romanToArabicParser = new RomanToArabicParser();
    }
}
