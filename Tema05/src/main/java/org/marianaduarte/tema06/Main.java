package org.marianaduarte.tema06;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Agenda agenda = new Agenda();
        Contato c1 = new Contato("Mariana","37999317908",1);
        Contato c2 = new Contato("Pedro","38992523296",2);
        Contato c3 = new Contato("Caio","37999473775",3);


        System.out.println("----Adicionar Contatos----");
        boolean retornoAdicionar1 = agenda.adicionarContato(c1);
        if (retornoAdicionar1){
            System.out.println("Contato adicionado\n");
        }
        else{
            System.out.println("Esse contato ja existe na agenda\n");
        }

        boolean retornoAdicionar2 = agenda.adicionarContato(c2);
        if (retornoAdicionar2){
            System.out.println("Contato adicionado\n");
        }
        else{
            System.out.println("Esse contato ja existe na agenda\n");
        }

        boolean retornoAdicionar3 = agenda.adicionarContato(c3);
        if (retornoAdicionar3){
            System.out.println("Contato adicionado\n");
        }
        else{
            System.out.println("Esse contato ja existe na agenda\n");
        }


        System.out.println("----Remover Contatos----");
        boolean retornoRemover = agenda.removerContato(c3);
        if (retornoRemover){
            System.out.println("Contato removido\n");
        }
        else{
            System.out.println("Esse contato não existe na agenda\n");
        }

        System.out.println("----Listar Contatos----");
        System.out.println(agenda.listarContatos());

        System.out.println("----Buscar Contatos Por Nome----");
        System.out.println(agenda.buscarNome("Mariana"));


        System.out.println("----Buscar Contatos Por Id----");
        System.out.println(agenda.buscarId(2));


        }
}

