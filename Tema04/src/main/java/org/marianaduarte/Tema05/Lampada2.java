package org.marianaduarte.Tema05;

public class Lampada2 extends Lampada1 implements Lampada{

    @Override
    public void On() {
        System.out.println("Lampada 2 LIGADA!");

    }
    @Override
    public void Off() {

        System.out.println("Lampada 2 DESLIGADA!");
    }

}
