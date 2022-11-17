package org.marianaduarte.tema10;

import java.util.ArrayList;

public class Agenda {
    private final AgendaDB agendaDB = new AgendaDB();

    public boolean adicionarContato(Contato contato){
        if(contato.getNome() == null || contato.getNome().isBlank() || contato.getTelefone() == null || contato.getTelefone().isBlank() || contato.getEmail() == null || contato.getEmail().isBlank()){
            return false;
        }
        if((!contato.getEmail().matches("^(.+)@(.+)$")) || (!contato.getNome().matches("[a-zA-Z]+")) || (contato.getNome().length() > 50) || (contato.getTelefone().length() > 12) ){
            return false;
        }
        if(contato.getId() < 0){
            return false;
        }
        if((!agendaDB.buscarContatoPorNome(contato.getNome()).isEmpty())){
            return false;
        }
        agendaDB.adicionarContato(contato);
        return true;
    }


    public ArrayList<Contato> buscarContatoPorNome(String nome){
        return agendaDB.buscarContatoPorNome(nome);
    }
    public ArrayList<Contato> buscarContatoPorId(Integer id){
        return agendaDB.buscarContatoPorId(id);
    }

    public boolean removerContato( Contato contato){
        if((!agendaDB.buscarContatoPorNome(contato.getNome()).isEmpty())){
            agendaDB.removerContato(contato);
            return true;
        }
        return false;
    }

    public ArrayList<Contato> listarContatos(){
        return agendaDB.listarContatos();
    }
    public ArrayList<Contato> listarContatosOrdenadoPorNome(){
        return agendaDB.listarContatosOrdenadoPorNome();
    }
}
