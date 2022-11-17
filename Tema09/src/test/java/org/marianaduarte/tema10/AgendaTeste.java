package org.marianaduarte.tema10;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaTeste {
    private final Agenda agendaTeste = new Agenda();


    @Test
    @DisplayName("Não permite a inserção de Contatos com Campos Nulos ou Vazios")
    public void shouldNotAllowNullOrEmptyFieldsOfContact(){
        Contato contatoTeste1 = new Contato( null,"","","");
        assertFalse(agendaTeste.adicionarContato(contatoTeste1));
        Contato contatoTeste2 = new Contato(null, null,null,null);
        assertFalse(agendaTeste.adicionarContato(contatoTeste2));
    }

    @Test
    @DisplayName("Não permite a inserção de Contatos que ja existem no Banco")
    public void shouldNotAllowAddExistingContacts(){
        Contato contatoTeste = new Contato(1,"Mariana","37999317908","mariana@gmail.com");
        agendaTeste.adicionarContato(contatoTeste);
        assertFalse(agendaTeste.adicionarContato(contatoTeste));
        agendaTeste.removerContato(contatoTeste);
    }

    @Test
    @DisplayName("Não permite a inserção de Contatos com Campos Invalidos")
    public void shouldNotAllowInvalidFieldsOfContact(){
        Contato contatoTeste1 = new Contato(1, "a".repeat(51),"37999317908","mariana@gmail.com");
        assertFalse(agendaTeste.adicionarContato(contatoTeste1));

        Contato contatoTeste2 = new Contato( 1,"Mariana123","37999317908","mariana@gmail.com");
        assertFalse(agendaTeste.adicionarContato(contatoTeste2));

        Contato contatoTeste3 = new Contato( 1,"Mariana Duarte","999999999999","mariana@gmail.com");
        assertFalse(agendaTeste.adicionarContato(contatoTeste3));

        Contato contatoTeste4 = new Contato( 1,"Jose Antonio","37998212432","jose##gmail,com");
        assertFalse(agendaTeste.adicionarContato(contatoTeste4));

        Contato contatoTeste5 = new Contato( -1,"Jose Antonio","37998212432","jose@gmail,com");
        assertFalse(agendaTeste.adicionarContato(contatoTeste5));
    }

    @Test
    @DisplayName("Verifica se os Contatos estão sendo inseridos no Banco")
    public void shouldAddContact(){
        Contato contatoTeste = new Contato(1,"Mariana","37999317908","mariana@gmail.com");
        assertTrue(agendaTeste.adicionarContato(contatoTeste));
        agendaTeste.removerContato(contatoTeste);
    }

    @Test
    @DisplayName("Verifica se o Contato desejado está sendo removido do Banco")
    public void shouldRemoveContact(){
        Contato contatoTeste = new Contato(1,"Jose","37998242432","jose@gmail.com");
        agendaTeste.adicionarContato(contatoTeste);
        assertTrue(agendaTeste.removerContato(contatoTeste));
    }
    @Test
    @DisplayName("Verifica se está listando todos os contatos")
    public void listarContatosTeste(){
        ArrayList<Contato> contatos = agendaTeste.listarContatos();
        assertEquals(contatos.size(),agendaTeste.listarContatos().size());
    }

    @Test
    @DisplayName("Verifica se está sendo listado por ordem de Nome")
    public void shouldListAllContactsOrderByName(){
        Contato contatoTeste1 = new Contato(1,"Mariana","37999317908","mariana@gmail.com");
        agendaTeste.adicionarContato(contatoTeste1);

        Contato contatoTeste2 = new Contato(2,"Ana","37998021185","ana@gmail.com");
        agendaTeste.adicionarContato(contatoTeste2);

        assertEquals("Ana",agendaTeste.listarContatosOrdenadoPorNome().get(0).getNome());
        agendaTeste.removerContato(contatoTeste1);
        agendaTeste.removerContato(contatoTeste2);
    }

    @Test
    @DisplayName("Verifica se está buscando o Contato pelo nome")
    public void shouldSearchContactByName(){
        Contato contatoTeste = new Contato(1,"Mariana","37999317908","mariana@gmail.com");
        agendaTeste.adicionarContato(contatoTeste);
        String saida = agendaTeste.buscarContatoPorNome(contatoTeste.getNome()).get(0).toString();
        assertEquals(saida,contatoTeste.toString());
        agendaTeste.removerContato(contatoTeste);
   }

    @Test
    @DisplayName("Verifica se está buscando o Contato pelo id")
    public void shouldSearchContactById(){
        Contato contatoTeste = new Contato(1,"Mariana","37999317908","mariana@gmail.com");
        agendaTeste.adicionarContato(contatoTeste);
        String saida = agendaTeste.buscarContatoPorId(contatoTeste.getId()).get(0).toString();
        assertEquals(saida, contatoTeste.toString());
        agendaTeste.removerContato(contatoTeste);
    }
}