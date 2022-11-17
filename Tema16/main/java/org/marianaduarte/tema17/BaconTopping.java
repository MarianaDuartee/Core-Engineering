package org.marianaduarte.tema17;

public class BaconTopping extends ToppingDecorator{
    private static final Double BACON_PRICE = 3.50;
    private int quantity;

    public BaconTopping(int quantity, Pizza pizza) {
        super(pizza);
        this.quantity = quantity;
    }

    @Override
    public Double getPrice() {
        return super.getPrice()+(BACON_PRICE * this.quantity);
    }
}
