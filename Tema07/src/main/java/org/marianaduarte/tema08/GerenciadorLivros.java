package org.marianaduarte.tema08;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

public class GerenciadorLivros {

    private final ArrayList<Livros> livros = new ArrayList<>();


    public boolean adicionarLivro(Livros livro)  {
        ArrayList<Livros> buscarLivros = buscarLivroTitulo(livro.getTitulo());

        if( livro.getId() == null || livro.getId() < 0 ||livro.getTitulo().isBlank() || livro.getAutor().isBlank() ||  (!buscarLivros.isEmpty())){
            return false;
        }

        livros.add(livro);
        return true;
    }

    public ArrayList<Livros> listarLivros() {
        return livros;
    }

    public ArrayList<Livros> buscarLivroTitulo(String titulo)  {
        ArrayList<Livros> resultadoBuscaTitulo = new ArrayList<>();
        for (Livros buscaLivros : livros ) {
            if ((buscaLivros.getTitulo().toLowerCase()).contains(titulo.toLowerCase())){
                resultadoBuscaTitulo.add(buscaLivros);
            }
        }
        return resultadoBuscaTitulo;
    }

    public ArrayList<Livros> buscarLivroAutor(String autor) {
        ArrayList<Livros> resultadoBuscaAutor = new ArrayList<>();
        for (Livros buscaLivros : livros ) {
            if ((buscaLivros.getAutor().toLowerCase()).contains(autor.toLowerCase())){
                resultadoBuscaAutor.add(buscaLivros);
            }
        }
        return resultadoBuscaAutor;
    }

    public boolean excluirLivro(Livros livro)  {
        for(Livros busca:livros){
            if(Objects.equals(livro.getId(), busca.getId()) && (!busca.isEmprestado())){
                livros.remove(livro);
                return true;
                }
            }
        return false;
    }
    public boolean adicionarLivrosArquivo(String caminho){
        File diretorio = new File(caminho);
        File arquivo = new File(diretorio,"Livros.txt");
        try(
            FileWriter fileWriter = new FileWriter(arquivo,true);
            PrintWriter printWriter = new PrintWriter(fileWriter))
        {
            if(!arquivo.exists()){
                arquivo.createNewFile();
            }
            printWriter.println("Id;Titulo;Autor");
            for(Livros l : livros) {
                printWriter.println(l.getId() + ";" + l.getTitulo() + ";" + l.getAutor());
                }
            }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
        }
    }


