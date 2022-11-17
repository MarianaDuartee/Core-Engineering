package org.marianaduarte.tema07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConversorTeste {
    private Conversor conversor;

    @BeforeEach
    public void setUp(){
        conversor = new Conversor();
    }
    @Test
    public void shouldNotAllowNullNumberRoman(){
        assertEquals(null,conversor.convertRomanToInteger(null));
    }
    @Test
    public void shouldNoteAllowNumbersInNumberRoman(){
        assertEquals(null,conversor.convertRomanToInteger(null));
    }
    @Test
    public void shouldConvertRomanToInteger(){
        assertEquals(1, conversor.convertRomanToInteger("I") );
        assertEquals(6, conversor.convertRomanToInteger("VI") );
        assertEquals(10, conversor.convertRomanToInteger("X") );
        assertEquals(16, conversor.convertRomanToInteger("XVI") );
        assertEquals(20, conversor.convertRomanToInteger("XX") );
    }
    @Test
    public void shouldNotAllowNumbersOutOfRange(){
        assertEquals(null,conversor.convertIntegerToRoman(0));
        assertEquals(null,conversor.convertIntegerToRoman(50));
    }
    @Test
    public void shouldConvertIntegerToRoman(){
        assertEquals("I", conversor.convertIntegerToRoman(1) );
        assertEquals("VI", conversor.convertIntegerToRoman(6) );
        assertEquals("X", conversor.convertIntegerToRoman(10));
        assertEquals("XVI", conversor.convertIntegerToRoman(16) );
        assertEquals("XX", conversor.convertIntegerToRoman(20) );
    }
}
