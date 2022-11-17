package org.marianaduarte.tema08;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class GerenciadorLivrosTeste {

    private GerenciadorLivros gerenciadorLivros;
    private Livros livroTeste;
    private ArrayList<Livros> listaLivrosTeste;

    @BeforeEach
    public void setUp(){
        gerenciadorLivros = new GerenciadorLivros();
        livroTeste = new Livros(1,"Tema08","Mariana");
    }

    @Test
    public void notAllowEmptyOrNullFieldsOfBooks(){
        livroTeste = new Livros(null,"","");
        assertFalse(gerenciadorLivros.adicionarLivro(livroTeste));
    }

    @Test
    public void shouldAddBooks(){
        assertTrue(gerenciadorLivros.adicionarLivro(livroTeste));
    }

    @Test
    public void shouldListBooks(){
        listaLivrosTeste = new ArrayList<>();
        listaLivrosTeste = gerenciadorLivros.listarLivros();
        gerenciadorLivros.adicionarLivro(livroTeste);
        assertEquals(1,listaLivrosTeste.size());
    }

    @Test
    public void shouldSearchBookByTitle(){
        listaLivrosTeste = new ArrayList<>();
        gerenciadorLivros.adicionarLivro(livroTeste);
        listaLivrosTeste = gerenciadorLivros.buscarLivroTitulo("Tema08");
        assertEquals(1,listaLivrosTeste.size());
    }

    @Test
    public void shouldSearchBookByAuthor(){
        listaLivrosTeste = new ArrayList<>();
        gerenciadorLivros.adicionarLivro(livroTeste);
        listaLivrosTeste = gerenciadorLivros.buscarLivroAutor("Mariana");
        assertEquals(1,listaLivrosTeste.size());
    }

    @Test
    public void shouldRemoveBook(){
        gerenciadorLivros.adicionarLivro(livroTeste);
        assertTrue(gerenciadorLivros.excluirLivro(livroTeste));

        listaLivrosTeste = new ArrayList<>();
        listaLivrosTeste = gerenciadorLivros.listarLivros();
        assertEquals(0,listaLivrosTeste.size());
    }

    @Test
    public void shouldAddBooksToFile(){
        gerenciadorLivros.adicionarLivro(livroTeste);
        assertTrue(gerenciadorLivros.adicionarLivrosArquivo("src/test/resources/"));

    }
}
