package org.marianaduarte.tema06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AgendaTeste {

    Agenda agendaTeste = new Agenda();
    Contato contatoTeste = new Contato("Mariana Duarte","379999999",1);


    @Test
    public void adicionarContatoTeste(){
        assertTrue(agendaTeste.adicionarContato(contatoTeste));
        assertFalse(agendaTeste.adicionarContato(contatoTeste));
    }

    @Test
    public void removerContatoTeste(){
        agendaTeste.adicionarContato(contatoTeste);
        assertTrue(agendaTeste.removerContato(contatoTeste));
        assertFalse(agendaTeste.removerContato(contatoTeste));
    }

    @Test
    public void listarContatosTeste(){
        ArrayList<Contato> contatos = agendaTeste.listarContatos();
        assertEquals(contatos.size(),agendaTeste.listarContatos().size());
    }

    @Test
    public void buscarNomeTeste(){
        agendaTeste.adicionarContato(contatoTeste);
        String saida = contatoTeste.toString();
        assertEquals(saida, agendaTeste.buscarNome("Mariana Duarte"));
    }

    @Test
    public void buscarIdTeste(){
        agendaTeste.adicionarContato(contatoTeste);
        String saida = contatoTeste.toString();
        assertEquals(saida, agendaTeste.buscarId(1));
    }


}
