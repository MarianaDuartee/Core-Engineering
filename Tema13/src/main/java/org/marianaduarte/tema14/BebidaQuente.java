package org.marianaduarte.tema14;

public abstract class BebidaQuente {
    boolean condimentos = true;
    abstract String esquentarAgua();
    abstract String misturar();
    abstract String addCondimentos();
    abstract String getPreco();

    public final String colocarEmCopo(){
        return "Colocando no copo ...";
    }
    public boolean temCondimentos(){
        return condimentos;
    }
    //Template method
    public final String preparo(){
        String saida = esquentarAgua() + "\n" + misturar() + "\n"+ colocarEmCopo()+"\n";
        if(temCondimentos()){
            saida += addCondimentos()+"\n";
        }
        saida += getPreco();
        return saida;
    }
}
