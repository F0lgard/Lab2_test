package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void whenRomanIsNullThenThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertRomantoArabic(null);
        });
        assertEquals("Invalid roman numeral", exception.getMessage());
    }

    @Test
    void whenRomanIsEmptyThenThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertRomantoArabic("");
        });
        assertEquals("Invalid roman numeral", exception.getMessage());
    }

    @Test
    void whenRomanIsInvalidThenThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertRomantoArabic("XXXX");
        });
        assertEquals("Invalid roman numeral", exception.getMessage());
    }

    @Test
    void whenRomanIsCorrectFormatShouldReturnNumber() {
        assertEquals(10, Converter.convertRomantoArabic("X"));
    }

    @Test
    void whenRomanHasIncorrectLowercaseLettersThenThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertRomantoArabic("xvi");
        });
        assertEquals("Invalid roman numeral", exception.getMessage());
    }

    @Test
    void whenRomanHasNonRomanCharactersThenThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertRomantoArabic("VIX#");
        });
        assertEquals("Invalid roman numeral", exception.getMessage());
    }

    @Test
    void whenRomanHasSpacesThenThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertRomantoArabic("VI IX");
        });
        assertEquals("Invalid roman numeral", exception.getMessage());
    }

    @Test
    void whenRomanHasInvalidOrderThenThrowsIllegalArgumentException() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertRomantoArabic("IXX");
        });
        Assertions.assertEquals("Invalid roman numeral order", exception.getMessage());
    }

    @Test
    void whenRomanIsTooLargeThenThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertRomantoArabic("MMMM");
        });
        assertEquals("Invalid roman numeral", exception.getMessage());
    }

    @Test
    void whenRomanIsTooSmallThenThrowsIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Converter.convertRomantoArabic("IIIIIIIIIIIIIIIIIIII");
        });
        assertEquals("Invalid roman numeral", exception.getMessage());
    }
}
