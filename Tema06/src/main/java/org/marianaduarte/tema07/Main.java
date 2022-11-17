package org.marianaduarte.tema07;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Conversor conversor = new Conversor();

        System.out.println("Digite um numero em Romano de I a XX:");
        String numRomano = scan.nextLine();
        Integer num = conversor.convertRomanToInteger(numRomano);
        if (num != null) {
            System.out.println("Inteiro equivalente:" + num);
        } else {
            System.out.println("Número inválido ou fora do intervalo de I-XX");
        }

        try {
            System.out.println("Digite um numero Inteiro de 1 a 20:");
            Integer numInt = scan.nextInt();
            String numRom = conversor.convertIntegerToRoman(numInt);
            if (numRom!= null){
                System.out.println("Romano equivalente:" + numRom);
            }
            else{
                System.out.println("Número fora do intervalo de 1-20");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalido!");
            e.printStackTrace();
        }
    }
}