package com.hukuta94.simplecalculator.model;

public enum RomanNumeral
{
    I( "I", 1 ),
    II( "II", 2 ),
    III( "III", 3 ),
    IV( "IV", 4 ),
    V( "V", 5 ),
    VI( "VI", 6 ),
    VII( "VII", 7 ),
    VIII( "VIII", 8 ),
    IX( "IX", 9 ),
    X( "X", 10 ),
    XX( "XX", 20 ),
    XXX( "XXX", 30 ),
    XL( "XL", 40 ),
    L( "L", 50 ),
    LX( "LX", 60 ),
    LXX( "LXX", 70 ),
    LXXX( "LXXX", 80 ),
    XC( "XC", 90 ),
    C( "C", 100 );

    private String roman;
    private int arabic;

    RomanNumeral( String roman, int arabic ) {
        this.roman = roman;
        this.arabic = arabic;
    }

    public String getRoman() {
        return roman;
    }

    public int getArabic() {
        return arabic;
    }

    public static int toArabic( String roman ) {
        for( RomanNumeral i: values() ) {
            if ( i.getRoman().equals( roman )) {
                return i.getArabic();
            }
        }
        throw new IllegalArgumentException( "number " + roman + " is out of range" );
    }

    public static String toRoman( int arabic ) {
        for( RomanNumeral i: values() ) {
            if ( i.getArabic() == arabic ) {
                return i.getRoman();
            }
        }
        throw new IllegalArgumentException( "number " + arabic + " is out of range" );
    }
}
