package org.marianaduarte.tema08;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        GerenciadorLivros livros = new GerenciadorLivros();
        GerenciadorUsuarios usuarios = new GerenciadorUsuarios();
        GerenciadorEmprestimos emprestimos = new GerenciadorEmprestimos();
        Livros l1 = new Livros(1,"A garota do Lago", "Charlie Donlea");
        Livros l2 = new Livros(2,"O código da Vinci", "Dan Brown");
        Livros l3 = new Livros(3,"O poder da vida", "Zibia Gasparetto");
        Livros l4 = new Livros(4,"O símbolo perdido", "Dan Brown");
        Livros l5 = new Livros(5,"Rainha Vermelha", "Victoria Aveyard");
        Livros l6 = new Livros(6,"A chama de Ember", "Colleen Houck");
        Livros l7 = new Livros(7,"Cidade dos ossos", "Cassandra Clare");
        Livros l8 = new Livros(8,"O meu pé de laranja lima", "José Mauro de Vasconcelos");
        Livros l9 = new Livros(9,"O menino do pijama listrado", "John Boyne");
        Livros l10 = new Livros(10,"Inferno", "Dan Brown");

        Usuario u1 = new Usuario(1,"Mariana");
        Usuario u2 = new Usuario(2,"Pedro");
        Usuario u3 = new Usuario(3,"Adriana");
        Usuario u4 = new Usuario(4,"Gustavo");
        Usuario u5 = new Usuario(5,"Ana Beatriz");
        Usuario u6 = new Usuario(6,"Lucas");
        Usuario u7 = new Usuario(7,"Alexandre");
        Usuario u8 = new Usuario(8,"Dulce");
        Usuario u9 = new Usuario(9,"Ana Clara");
        Usuario u10 = new Usuario(10,"Caio");
        try {
            int op = 0;
            while (op != 16) {
                System.out.println("\n---- BIBLIOTECA VIRTUAL -----\n");
                System.out.println("""
                        Digite a opção desejada:

                        --- Sessão Livros ---
                        1-Cadastrar Livro
                        2-Listar Livros Cadastrados
                        3-Excluir Livro
                        4-Buscar por título
                        5-Buscar por autor

                        --- Sessão Usuários ---
                        6-Cadastrar Usuário
                        7-Listar Usuários Cadastrados
                        8-Excluir Usuário

                        --- Sessão Emprestimos ---
                        9-Realizar Emprestimo
                        10-Devolver Livro
                        11-Renovar Livro

                        --- Sessão Relatórios ---
                        12-Historico de Emprestimos
                        13-Livros Emprestados Atualmente
                        14-Top 10 Usuários que mais Locam
                        15-Emprestimos atrasados
                        16-Sair
                        """);
                op = scan.nextInt();
                switch (op) {
                    case 1:
                        livros.adicionarLivro(l1);
                        livros.adicionarLivro(l2);
                        livros.adicionarLivro(l3);
                        livros.adicionarLivro(l4);
                        livros.adicionarLivro(l5);
                        livros.adicionarLivro(l6);
                        livros.adicionarLivro(l7);
                        livros.adicionarLivro(l8);
                        livros.adicionarLivro(l9);
                        livros.adicionarLivro(l10);
                        System.out.println("\n10 livros foram adicionados ao sistema");
                        break;
                    case 2:
                        System.out.println("\nListando livros cadastrados");
                        System.out.println(livros.listarLivros());
                        break;
                    case 3:
                        System.out.println("\nExcluindo o livro 3");
                        livros.excluirLivro(l3);
                        break;
                    case 4:
                        System.out.println("\nProcurando livros que possuem o autor: Dan Brown");
                        System.out.println(livros.buscarLivroAutor("Dan Brown"));
                        break;
                    case 5:
                        System.out.println("\nProcurando livros que possuem em seu titulo a palavra : garota");
                        System.out.println(livros.buscarLivroTitulo("garota"));
                        break;
                    case 6:
                        usuarios.adicionarUsuario(u1);
                        usuarios.adicionarUsuario(u2);
                        usuarios.adicionarUsuario(u3);
                        usuarios.adicionarUsuario(u4);
                        usuarios.adicionarUsuario(u5);
                        usuarios.adicionarUsuario(u6);
                        usuarios.adicionarUsuario(u7);
                        usuarios.adicionarUsuario(u8);
                        usuarios.adicionarUsuario(u9);
                        usuarios.adicionarUsuario(u10);
                        System.out.println("\nForam adicionados 10 usuarios ao sistema");
                        break;
                    case 7:
                        System.out.println("\nListando usuarios cadastrados");
                        System.out.println(usuarios.listarUsuarios());
                        break;
                    case 8:
                        System.out.println("\nExcluindo o usuario 3");
                        usuarios.excluirUsuario(u3);
                        break;
                    case 9:
                        emprestimos.realizarEmprestimo(1,l1, u1, "07-04-2022");
                        emprestimos.realizarEmprestimo(2,l4, u1, "21-04-2022");
                        emprestimos.realizarEmprestimo(3,l6, u1, "01-05-2022");
                        emprestimos.realizarEmprestimo(4,l8, u1, "05-05-2022");
                        emprestimos.realizarEmprestimo(5,l2, u2, "08-04-2022");
                        emprestimos.realizarEmprestimo(6,l5, u2, "30-04-2022");
                        emprestimos.realizarEmprestimo(7,l7, u2, "05-05-2022");
                        emprestimos.realizarEmprestimo(8,l9, u4, "18-04-2022");
                        emprestimos.realizarEmprestimo(9,l10, u4, "30-04-2022");
                        System.out.println("\nForam cadastrados 9 emprestimos");
                        break;
                    case 10:
                        System.out.println("\nDevolvendo 4 livros com Atraso\n");
                        emprestimos.devolverLivro(l1, u1);
                        emprestimos.devolverLivro(l4, u1);
                        emprestimos.devolverLivro(l2, u2);
                        emprestimos.devolverLivro(l9, u3);
                        System.out.println("\nDevolvendo 1 livro sem Atraso\n");
                        emprestimos.devolverLivro(l6, u1);
                        break;
                    case 11:
                        System.out.println("\nRenovando Livro\n");
                        emprestimos.renovarLivro(l5,u2);
                        break;
                    case 12:
                        System.out.println("\nHistorico de Emprestimos");
                        System.out.println(emprestimos.listarHistoricoEmprestimos());
                        break;
                    case 13:
                        System.out.println("\nLivros Emprestados Atualmente");
                        System.out.println(emprestimos.listarEmprestimos());
                        break;
                    case 14:
                        System.out.println("\nTOP 10 Usuarios que mais Locam");
                        System.out.println(usuarios.listaTopDezUsuarios());
                        break;
                    case 15:
                        System.out.println("\nRelatório dos Emprestimos Atrasadados");
                        ArrayList<String> saida = emprestimos.listaEmprestimosAtrasados();
                        if (saida.size() == 0) {
                            System.out.println("Não encontrei nenhum emprestimo em atraso.");
                        } else {
                            System.out.println(saida);
                        }
                        break;
                    case 16:
                        System.out.println("Volte sempre :)");
                        break;
                    default:
                        System.out.println("Número invalido.Digite um numero de 1 a 16");
                        break;
                }
            }
            System.out.println("\n---- Salvando os livros no Arquivo ----");
            boolean arquivoLivros = livros.adicionarLivrosArquivo("src/main/resources/");
            if (arquivoLivros) {
                System.out.println("Livros adicionados ao Arquivo");
            } else {
                System.out.println("Erro!");
            }
            System.out.println("\n---- Salvando os Usuarios no Arquivo ----");
            boolean arquivoUsuarios = usuarios.adicionarUsuariosArquivo("src/main/resources/");
            if (arquivoUsuarios) {
                System.out.println("Usuarios adicionados ao Arquivo");
            } else {
                System.out.println("Erro!");
            }
            System.out.println("\n---- Salvando Historico de Emprestimos no Arquivo ----");
            boolean arquivoEmprestimos = emprestimos.adicionarHistoricoEmprestimosArquivo("src/main/resources/");
            if (arquivoEmprestimos) {
                System.out.println("Emprestimos adicionados ao Arquivo");
            } else {
                System.out.println("Erro!");
            }
            System.out.println("\n---- Salvando Emprestimos Atuais no Arquivo ----");
            boolean arquivoEmprestimosAtuais = emprestimos.adicionarEmprestimosArquivo("src/main/resources/");
            if (arquivoEmprestimosAtuais) {
                System.out.println("Emprestimos adicionados ao Arquivo");
            } else {
                System.out.println("Erro!");
            }
            System.out.println("\n---- Salvando os Emprestimos Atrasados no Arquivo ----");
            boolean arquivoEmprestimosAtrasados = emprestimos.adicionarEmprestimosAtrasadosArquivo("src/main/resources/");
            if (arquivoEmprestimosAtrasados) {
                System.out.println("Emprestimos adicionados ao Arquivo");
            } else {
                System.out.println("Erro!");
            }
        } catch (Exception e) {
            System.out.println("Número invalido!");
        }

    }
}