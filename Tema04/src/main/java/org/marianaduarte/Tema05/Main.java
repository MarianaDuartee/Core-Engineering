package org.marianaduarte.Tema05;

public class Main {
    public static void main(String[] args){
        Lampada1 l1 = new Lampada1();
        EstadoLampada s1 = new EstadoLampada(l1);
        System.out.println("Lampada 1:");
        s1.switchState();
        s1.switchState();


        Lampada2 l2 = new Lampada2();
        EstadoLampada s2 = new EstadoLampada(l2);
        System.out.println("\nLampada 2:");
        s2.switchState();
        s2.switchState();
    }

}