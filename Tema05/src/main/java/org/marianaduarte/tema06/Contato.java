package org.marianaduarte.tema06;

public class Contato {
    private String nome;
    private String numTelefone;
    public int id;

    public Contato(String nome, String numTelefone, int id){
        this.nome = nome;
        this.numTelefone = numTelefone;
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setNumTelefone(String telefone){
        this.numTelefone = numTelefone;
    }
    public String getNumTelefone(){
        return numTelefone;
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public String toString(){
        return this.id+"-"+this.nome+":"+this.numTelefone+"\n";
    }

}


