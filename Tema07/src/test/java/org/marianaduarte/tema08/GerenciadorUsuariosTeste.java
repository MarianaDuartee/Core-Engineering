package org.marianaduarte.tema08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorUsuariosTeste {
    private GerenciadorUsuarios gerenciadorUsuarios;
    private Usuario usuarioTeste;
    private ArrayList<Usuario> listaUsuariosTeste;

    @BeforeEach
    public void setUp(){
        gerenciadorUsuarios = new GerenciadorUsuarios();
        usuarioTeste = new Usuario(1,"Mariana");
    }

    @Test
    public void notAllowEmptyorNullFieldsOfUsers(){
        usuarioTeste = new Usuario(null,"");
        assertFalse(gerenciadorUsuarios.adicionarUsuario(usuarioTeste));
    }

    @Test
    public void shouldAddUser(){
        assertTrue(gerenciadorUsuarios.adicionarUsuario(usuarioTeste));
    }

    @Test
    public void shouldListUsers(){
        listaUsuariosTeste= new ArrayList<>();
        listaUsuariosTeste = gerenciadorUsuarios.listarUsuarios();
        gerenciadorUsuarios.adicionarUsuario(usuarioTeste);
        assertEquals(1,listaUsuariosTeste.size());
    }

    @Test
    public void shouldRemoveUser(){
        gerenciadorUsuarios.adicionarUsuario(usuarioTeste);
        assertTrue(gerenciadorUsuarios.excluirUsuario(usuarioTeste));

        listaUsuariosTeste = new ArrayList<>();
        listaUsuariosTeste = gerenciadorUsuarios.listarUsuarios();
        assertEquals(0,listaUsuariosTeste.size());
    }

    @Test
    public void shouldListTopTenUsers(){
        gerenciadorUsuarios.adicionarUsuario(usuarioTeste);
        usuarioTeste.setQtdEmprestimos(usuarioTeste.getQtdEmprestimos()+1);
        String saida = gerenciadorUsuarios.listaTopDezUsuarios();

        String saidaEsperada = "Posição: 1 | Nome: Mariana | Quantidade de emprestimos: 1\n";
        assertEquals(saidaEsperada,saida);
    }

    @Test
    public void shouldAddBooksToFile(){
        gerenciadorUsuarios.adicionarUsuario(usuarioTeste);
        assertTrue(gerenciadorUsuarios.adicionarUsuariosArquivo("src/test/resources/"));

    }
}

