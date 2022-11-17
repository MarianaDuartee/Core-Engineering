package org.marianaduarte.tema17;

public class Main {
    public static void main(String[] args) {
        Pizza basePizza = new BasePizza();
        Pizza completedPizza = new BaconTopping(1,new CheeseTopping(2,basePizza));
        System.out.println("Saindo uma pizza de bacon com duplo queijo:\nR$"+completedPizza.getPrice());
    }
}