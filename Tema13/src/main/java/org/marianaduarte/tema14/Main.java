package org.marianaduarte.tema14;

public class Main {
    public static void main(String[] args) {
        BebidaQuente bebida = new Cafe();
        bebida.condimentos = false;
        System.out.println(bebida.preparo());

        System.out.println("----------------");
        bebida = new Cha();
        System.out.println(bebida.preparo());
        }
}