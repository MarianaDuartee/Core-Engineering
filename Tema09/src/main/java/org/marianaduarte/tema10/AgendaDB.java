package org.marianaduarte.tema10;

import java.sql.*;
import java.util.ArrayList;
public class AgendaDB {

    public void adicionarContato(Contato contato) {

        try (Connection connection = ConexaoMySQL.conectar();
             Statement statement = connection.createStatement())
        {
            String insertSql = String.format("INSERT INTO agenda(id,nome,telefone,email) VALUES"
                    + "(%d,'%s','%s','%s')", contato.getId(),contato.getNome(), contato.getTelefone(), contato.getEmail());
            statement.execute(insertSql);
            System.out.println("Contato inserido!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<Contato> buscarContatoPorNome(String nome){
        Contato contato;
        ArrayList<Contato> contatos = new ArrayList<>();
        try (Connection connection = ConexaoMySQL.conectar();
             Statement statement = connection.createStatement())
        {
            String query = String.format("SELECT * FROM agenda WHERE nome='%s'",nome);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                contato = new Contato(resultSet.getInt("id"),resultSet.getString("nome"),resultSet.getString("telefone"),resultSet.getString("email"));
                contatos.add(contato);
            }
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Contato> buscarContatoPorId( Integer id){
        Contato contato;
        ArrayList<Contato> contatos = new ArrayList<>();
        try (Connection connection = ConexaoMySQL.conectar();
             Statement statement = connection.createStatement())
        {
            String query = String.format("SELECT * FROM agenda WHERE id=%d",id);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                contato = new Contato(resultSet.getInt("id"),resultSet.getString("nome"),resultSet.getString("telefone"),resultSet.getString("email"));
                contatos.add(contato);
            }
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removerContato(Contato contato){
        try (Connection connection = ConexaoMySQL.conectar();
             Statement statement = connection.createStatement())
        {
            String deleteSql= String.format("DELETE FROM agenda WHERE id=%d", contato.getId());
            statement.execute(deleteSql);
            System.out.println("Contato deletado!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Contato> listarContatos(){
        Contato contato;
        ArrayList<Contato> todosContatos = new ArrayList<>();

        try (Connection connection = ConexaoMySQL.conectar();
             Statement statement = connection.createStatement())
        {
            String query = String.format("SELECT * FROM agenda");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                contato = new Contato(resultSet.getInt("id"),resultSet.getString("nome"),resultSet.getString("telefone"),resultSet.getString("email"));
                todosContatos.add(contato);

            }
            return todosContatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Contato> listarContatosOrdenadoPorNome(){
        Contato contato;
        ArrayList<Contato> todosContatos = new ArrayList<>();

        try (Connection connection = ConexaoMySQL.conectar();
             Statement statement = connection.createStatement())
        {
            String query = String.format("SELECT * FROM agenda ORDER BY nome ASC");
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                contato = new Contato(resultSet.getInt("id"),resultSet.getString("nome"),resultSet.getString("telefone"),resultSet.getString("email"));
                todosContatos.add(contato);

            }
            return todosContatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
