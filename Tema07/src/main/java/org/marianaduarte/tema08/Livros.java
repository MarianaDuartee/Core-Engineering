package org.marianaduarte.tema08;

public class Livros {
    private String titulo;
    private String autor;
    private Integer id;
    private boolean emprestado;

    public Livros(Integer id,String titulo, String autor){
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public String toString(){
        return "\nIdLivro: "+getId()+"\nTituloLivro: "+getTitulo()+"\nAutorLivro: "+getAutor();
    }
}
