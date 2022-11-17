package org.marianaduarte.tema08;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GerenciadorUsuarios {
    private final ArrayList<Usuario> usuarios= new ArrayList<>();
    public boolean adicionarUsuario(Usuario usuario)  {
        if(usuario.getNome().isBlank() || usuario.getNome() == null || usuario.getId() < 0 || usuario.getId() == null || usuarios.contains(usuario) ){
            return false;
        }

        usuarios.add(usuario);
        return true;
    }

    public ArrayList<Usuario> listarUsuarios() {
        return usuarios;
    }

    public boolean excluirUsuario(Usuario usuario)  {
        for (Usuario u : usuarios) {
            if (u.equals(usuario)){
                usuarios.remove(usuario);
                return true;
            }
        }
        return false;
    }

    public String listaTopDezUsuarios(){
        ArrayList<Usuario> topDezUsuarios= new ArrayList<>(10);
        StringBuilder saida = new StringBuilder();
        for(Usuario usuario: usuarios){
            if(usuario.getQtdEmprestimos() != 0) {
                topDezUsuarios.add(usuario);
            }
        }
        topDezUsuarios.sort(Usuario::compareTo);

        for(int i=0;i<topDezUsuarios.size();i++){
            saida.append("Posição: ").append(i + 1).append(" | Nome: ").append(topDezUsuarios.get(i).getNome()).append(" | Quantidade de emprestimos: ").append(topDezUsuarios.get(i).getQtdEmprestimos()).append("\n");
        }

        return saida.toString();
    }

    public boolean adicionarUsuariosArquivo(String caminho){
        File diretorio = new File(caminho);
        File arquivo = new File(diretorio,"Usuarios.txt");
        try(
                FileWriter fileWriter = new FileWriter(arquivo,true);
                PrintWriter printWriter = new PrintWriter(fileWriter))
        {
            if(!arquivo.exists()){
                arquivo.createNewFile();
            }
            printWriter.println("Id;Nome");
            for (Usuario u : usuarios) {
                printWriter.println(u.getId() + ";" +u.getNome());
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}


