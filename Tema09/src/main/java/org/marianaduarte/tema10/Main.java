package org.marianaduarte.tema10;

public class Main {
    public static void main(String[] args) {

        Agenda agenda = new Agenda();

        Contato c1 = new Contato(1,"Mariana","37999317908","mariana@gmail.com");
        Contato c2 = new Contato(2,"Pedro","38992523296","pedro@gmail.com");
        Contato c3 = new Contato(3,"Caio","37999473775","caio@gmail.com");

        System.out.println("----Adicionar Contatos----");
        agenda.adicionarContato(c1);
        agenda.adicionarContato(c2);
        agenda.adicionarContato(c3);

        System.out.println("----Listar Contatos Existentes----");
        System.out.println(agenda.listarContatos());

        System.out.println("----Remover Contatos----");
        agenda.removerContato(c2);

        System.out.println("----Listar Contatos Ordenados por Nome----");
        System.out.println(agenda.listarContatosOrdenadoPorNome());

        System.out.println("----Buscar Contatos Por Nome----");
        System.out.println(agenda.buscarContatoPorNome("Mariana"));


        System.out.println("----Buscar Contatos Por Id----");
        System.out.println(agenda.buscarContatoPorId(3));
    }
}