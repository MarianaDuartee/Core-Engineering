package org.marianaduarte.tema08;

import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Livros livro;
    private Usuario usuario;
    private LocalDate dataEmprestada;
    private LocalDate dataDevolvida;
    private long diasAtrasados;
    private long multaAtraso;

    public Emprestimo(Integer id,Livros livro, Usuario usuario, LocalDate dataEmprestada){
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestada = dataEmprestada;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livros getLivro() {
        return livro;
    }

    public void setLivro(Livros livro) {
        this.livro = livro;
    }

    public Usuario getUsuario(){
        return  usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataEmprestada() {
        return dataEmprestada;
    }

    public void setDataEmprestada(LocalDate dataEmprestada) {
        this.dataEmprestada = dataEmprestada;
    }

    public LocalDate getDataDevolvida() {
        return dataDevolvida;
    }

    public void setDataDevolvida(LocalDate dataDevolvida) {
        this.dataDevolvida = dataDevolvida;
    }

    public long getDiasAtrasados() {
        return diasAtrasados;
    }

    public void setDiasAtrasados(long diasAtrasados) {
        this.diasAtrasados = diasAtrasados;
    }

    public long getMultaAtraso() {
        return multaAtraso;
    }

    public void setMultaAtraso(long multaAtraso) {
        this.multaAtraso = multaAtraso;
    }

    public long calcularMulta(long diasAtrasados){
        long multa = 5;
        return diasAtrasados*multa;
    }

    public String toString(){
        return "\nIdEmprestimo:"+getId()+"\n--- LIVRO --- "+ getLivro().toString()+"\n--- USUARIO ---"+ getUsuario().toString()+"Data Emprestimo: "+ getDataEmprestada()+"\n---------------------";
    }
}
