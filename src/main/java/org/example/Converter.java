package org.example;

import java.util.*;

public class Converter {
    private static final Map<Character, Integer> romanToArabicMap = new HashMap<>();

    static {
        romanToArabicMap.put('I', 1);
        romanToArabicMap.put('V', 5);
        romanToArabicMap.put('X', 10);
        romanToArabicMap.put('L', 50);
        romanToArabicMap.put('C', 100);
        romanToArabicMap.put('D', 500);
        romanToArabicMap.put('M', 1000);
    }

    public static int convertRomantoArabic(String roman) {
        if (roman == null || !validateRoman(roman)) {
            throw new IllegalArgumentException("Invalid roman numeral");
        }

        int result = 0;
        int previousValue = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            int currentValue = romanToArabicMap.get(roman.charAt(i));

            if (currentValue < previousValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            // Перевірка на некоректний порядок римських чисел (наприклад, IXX або IIV)
            if (i < roman.length() - 1 && currentValue < romanToArabicMap.get(roman.charAt(i + 1))) {
                throw new IllegalArgumentException("Invalid roman numeral order");
            }

            previousValue = currentValue;
        }
        return result;
    }

    public static boolean validateRoman(String roman) {
        if (roman == null || roman.isEmpty()) {
            return false;
        }

        // Перевірка на валідні символи
        for (char c : roman.toCharArray()) {
            if (!romanToArabicMap.containsKey(c)) {
                return false;
            }
        }

        // Перевірка на правильну структуру римського числа (загальні обмеження)
        if (roman.matches(".*IIII|VV|XXXX|LL|CCCC|DD|MMMM.*")) {
            return false;
        }

        // Додаткова перевірка на некоректні порядки символів (такі як IC, IIX тощо)
        if (roman.matches(".*IL|IC|ID|IM|VX|VL|VC|VD|VM|XD|XM.*")) {
            return false;
        }

        return true;
    }

}
