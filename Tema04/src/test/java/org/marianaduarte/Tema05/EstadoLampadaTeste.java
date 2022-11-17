package org.marianaduarte.Tema05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstadoLampadaTeste {

    @Test
    public void testLampada1(){
        Lampada1 l1  = new Lampada1();
        EstadoLampada teste1 = new EstadoLampada(l1);

        teste1.switchState();
        assertTrue(teste1.Estado());

        teste1.switchState();
        assertFalse(teste1.Estado());

    }

    @Test
    public void testLampada2(){
        Lampada2 l2  = new Lampada2();
        EstadoLampada teste2 = new EstadoLampada(l2);

        teste2.switchState();
        assertTrue(teste2.Estado());

        teste2.switchState();
        assertFalse(teste2.Estado());

    }

}
