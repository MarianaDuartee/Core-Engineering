package org.marianaduarte.tema06;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contato> contatos = new ArrayList<Contato>();

    public boolean adicionarContato(Contato contato) {
        String nomeBusca = buscarNome(contato.getNome());
        if (nomeBusca != null) {
            return false;
        }

        contatos.add(contato);
        return true;
    }


    public boolean removerContato(Contato contato){
        String nomeBusca = buscarNome(contato.getNome());
           if (nomeBusca != null) {
             contatos.remove(contato);
             return true;
        }
        return false;
    }


    public ArrayList<Contato> listarContatos(){
        return contatos;
    }

    public String buscarNome(String nome){
        for (int i=0;i<contatos.size();i++) {
            if (contatos.get(i).getNome().equals(nome)) {
                return contatos.get(i).toString();
            }
        }
        return null;

    }

    public String buscarId(int id){
        for (int i=0;i<contatos.size();i++) {
            if (contatos.get(i).getId() == id){
                return contatos.get(i).toString();
            }
        }
        return null;
        }

}
