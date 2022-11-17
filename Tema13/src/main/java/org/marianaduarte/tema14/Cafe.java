package org.marianaduarte.tema14;

public class Cafe extends BebidaQuente{
    @Override
    String esquentarAgua() {
        return "Esquentando agua para o café";
    }

    @Override
    String misturar() {
        return "Colocando o pó de café para misturar na agua quante";
    }

    @Override
    String addCondimentos() {
        return "Adicionando açucar / adoçante";
    }

    @Override
    String getPreco() {
        return "Seu café deu R$2,50";
    }
}
