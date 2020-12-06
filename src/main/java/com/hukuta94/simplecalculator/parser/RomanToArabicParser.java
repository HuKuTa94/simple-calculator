package com.hukuta94.simplecalculator.parser;

public class RomanToArabicParser {
    // римское число, которое надо распарсить
    public static StringBuilder line;

    // возвращает арабское представление полученного римского числа
    // или -1, если в результате парсинга было получено недопустимое значение
    public static int parse(String romanNumber) {
        line = new StringBuilder(romanNumber);
        int arabicNumber = 0;

        // парсинг тысяч, сотен, десятков и единиц
        int thousand = auxiliaryParse(1000, 'M', 'K', 'K');
        int hundreds = auxiliaryParse(100, 'C', 'D', 'M');
        int tens = auxiliaryParse(10, 'X', 'L', 'C');
        int units = auxiliaryParse(1, 'I', 'V', 'X');

        // проверка на некоректность полученных результатов
        if (thousand > 3000) return -1;
        if (thousand == tens && hundreds == tens && units == tens && tens == -1) return -1;

        // собираем промежуточные данные в итоговое значение
        if (thousand != -1) arabicNumber += thousand;
        if (hundreds != -1) arabicNumber += hundreds;
        if (tens != -1) arabicNumber += tens;
        if (units != -1) arabicNumber += units;

        return arabicNumber;
    }

    // вспомогательный метод
    // позволяет распарсить следующий один класс римского числа (тысячи, затем сотни и т.д.)
    // возвращает представление этого класса в виде арабского числа и удаляет
    // этот класс из StringBuilder line
    public static int auxiliaryParse(int exp, char one, char five, char ten) {
        if (line.length() == 0) return -1;
        String fore = new String("" + one + five);
        String nine = new String("" + one + ten);
        int addNumber = 0;

        while (true) {
            // проверка на 4 и 9 (единиц, десятков или сотней)
            if (line.length() > 1) {
                if (line.substring(0,2).equals(fore)) {
                    addNumber += 4 * exp;
                    line.delete(0,2);
                    break;
                }
                if (line.substring(0,2).equals(nine)) {
                    addNumber += 9 * exp;
                    line.delete(0,2);
                    break;
                }
            }
            // проверка на 5, 6, 7, 8
            if (line.charAt(0) == five) {
                addNumber += 5 * exp;
                line.deleteCharAt(0);
                if (line.length() == 0) break;
                for (int i = 0; i < 4; i++) {
                    if (line.charAt(0) == one) {
                        if (i == 3) return -1;
                        addNumber += 1 * exp;
                        line.deleteCharAt(0);
                        if (line.length() == 0) break;
                    } else break;
                }
            } else { // проверка на 1, 2, 3
                for (int i = 0; i < 4; i++) {
                    if (line.length() == 0) break;
                    if (line.charAt(0) == one) {
                        if (i == 3) return -1;
                        addNumber += 1 * exp;
                        line.deleteCharAt(0);
                        if (line.length() == 0) break;
                    } else break;
                }
            }
            break;
        }
        return addNumber;
    }

}
