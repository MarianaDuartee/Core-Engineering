package org.marianaduarte.tema14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BebidaQuenteTeste {

    private BebidaQuente bebidaQuente;

    @Test
    public void shouldPrepareCompleteCoffee(){
        bebidaQuente = new Cafe();
        assertEquals("Esquentando agua para o café\nColocando o pó de café para misturar na agua quante\nColocando no copo ...\nAdicionando açucar / adoçante\nSeu café deu R$2,50",bebidaQuente.preparo());
    }

    @Test
    public void shouldPrepareCoffeeWithoutCondiments(){
        bebidaQuente = new Cafe();
        bebidaQuente.condimentos = false;
        assertEquals("Esquentando agua para o café\nColocando o pó de café para misturar na agua quante\nColocando no copo ...\nSeu café deu R$2,50",bebidaQuente.preparo());
    }

    @Test
    public void shouldPrepareCompleteTea(){
        bebidaQuente = new Cha();
        assertEquals("Esquentando agua para o chá\nMergulhando o saquinho de chá na agua quente\nColocando no copo ...\nAdicionando gotas de limão\nSeu chá deu R$2,00",bebidaQuente.preparo());
    }

    @Test
    public void shouldPrepareTeaWithoutCondiments(){
        bebidaQuente = new Cha();
        bebidaQuente.condimentos = false;
        assertEquals("Esquentando agua para o chá\nMergulhando o saquinho de chá na agua quente\nColocando no copo ...\nSeu chá deu R$2,00",bebidaQuente.preparo());
    }
}
