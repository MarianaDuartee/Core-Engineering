package org.marianaduarte.tema14;

public class Cha extends BebidaQuente{
    @Override
    String esquentarAgua() {
        return "Esquentando agua para o chá";
    }

    @Override
    String misturar() {
        return "Mergulhando o saquinho de chá na agua quente";
    }

    @Override
    String addCondimentos() {
        return "Adicionando gotas de limão";
    }

    @Override
    String getPreco() {
        return "Seu chá deu R$2,00";
    }
}
