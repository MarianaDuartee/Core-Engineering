package org.marianaduarte.tema17;

public abstract class ToppingDecorator implements Pizza {
    private Pizza pizza;

    public ToppingDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public Double getPrice(){
        return this.pizza.getPrice();
    }
}
