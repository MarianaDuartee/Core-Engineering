package org.marianaduarte.tema17;

public class CheeseTopping extends ToppingDecorator{

    private static final Double CHEESE_PRICE = 3D;
    private int quantity;

    public CheeseTopping(int quantity, Pizza pizza) {
        super(pizza);
        this.quantity = quantity;
    }

    @Override
    public Double getPrice() {
        return super.getPrice()+(CHEESE_PRICE * this.quantity);
    }
}
