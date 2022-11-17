package org.marianaduarte.tema08;

public class Usuario {
    private Integer id;
    private String nome;
    private int numLivros = 0;
    private int qtdEmprestimos = 0;

    public Usuario(Integer id ,String nome){
        this.id = id;
        this.nome = nome;
    }

    public Integer getId(){

        return id;
    }
    public void setId(Integer id){

        this.id = id;
    }
    public String getNome(){

        return nome;
    }
    public void setNome(String nome){

        this.nome = nome;
    }

    public int getNumLivros() {
        return numLivros;
    }

    public void setNumLivros(int numLivros) {
        this.numLivros = numLivros;
    }

    public int getQtdEmprestimos() {
        return qtdEmprestimos;
    }

    public void setQtdEmprestimos(int qtdEmprestimos) {
        this.qtdEmprestimos = qtdEmprestimos;
    }

    public String toString(){
        return "\nIdUsuario: "+getId()+"\nNomeUsuario: "+getNome()+"\n";
    }

    public int compareTo(Usuario outroUsuario) {
        if (this.getQtdEmprestimos() > outroUsuario.getQtdEmprestimos()) {
            return -1;
        } if (this.getQtdEmprestimos() < outroUsuario.getQtdEmprestimos()) {
            return 1;
        }
        return 0;
    }
}
