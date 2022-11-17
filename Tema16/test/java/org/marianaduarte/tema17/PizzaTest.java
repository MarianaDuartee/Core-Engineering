package org.marianaduarte.tema17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaTest {

    private Pizza basePizza;

    @BeforeEach
    public void setUp(){
        basePizza = new BasePizza();
    }

    @Test
    public void shouldMakeAPizzaBase(){
        assertEquals(20D, basePizza.getPrice());
    }

    @Test
    public void shouldMakeACheesePizza(){
        Pizza cheessePizza = new CheeseTopping(1,basePizza);
        assertEquals(23D, cheessePizza.getPrice());
    }

    @Test
    public void shouldMakeABaconPizza(){
        Pizza baconPizza = new BaconTopping(1,basePizza);
        assertEquals(23.50, baconPizza.getPrice());
    }

    @Test
    public void shouldMakeABaconPizzaWithDoubleCheese(){
        Pizza completedPizza = new BaconTopping(1,new CheeseTopping(2,basePizza));
        assertEquals(29.50, completedPizza.getPrice());
    }
}
