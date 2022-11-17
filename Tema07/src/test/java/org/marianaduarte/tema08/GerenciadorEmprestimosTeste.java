package org.marianaduarte.tema08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorEmprestimosTeste {
    private GerenciadorEmprestimos gerenciadorEmprestimos;
    private ArrayList<Emprestimo> listaEmprestimosTeste;
    private Livros livroTeste1;
    private Livros livroTeste2;
    private Livros livroTeste3;
    private Livros livroTeste4;
    private Livros livroTeste5;
    private Livros livroTeste6;
    private Usuario usuarioTeste1;
    private Usuario usuarioTeste2;

    private String data;

    @BeforeEach
    public void setUp(){
        gerenciadorEmprestimos = new GerenciadorEmprestimos();
        data = "01-05-2022";
        livroTeste1 = new Livros(1,"Tema08","Mariana");
        livroTeste2 = new Livros(2,"Biblioteca","Mariana");
        livroTeste3 = new Livros(3,"Origem","Dan Brown");
        livroTeste4 = new Livros(4,"O simbolo perdido","Dan Brown");
        livroTeste5 = new Livros(5,"O codigo da Vinci","Dan Brown");
        livroTeste6 = new Livros(6,"Anjos e demonios", "Dan Brown");
        usuarioTeste1 = new Usuario(1,"Mariana Duarte");
        usuarioTeste2 = new Usuario(2,"Pedro Queiroz");

    }

    @Test
    public void shouldNotAllowEmptyOrNullFieldsOfLoan(){
        livroTeste1 = new Livros(null,"","");
        usuarioTeste1 = new Usuario(null,"");
        assertFalse(gerenciadorEmprestimos.realizarEmprestimo(null,livroTeste1,usuarioTeste1,data));
    }

    @Test
    public void shouldNotAllowRealizeLoanWithMoreThanFiveBooks(){
        gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data);
        gerenciadorEmprestimos.realizarEmprestimo(2,livroTeste2,usuarioTeste1,data);
        gerenciadorEmprestimos.realizarEmprestimo(3,livroTeste3,usuarioTeste1,data);
        gerenciadorEmprestimos.realizarEmprestimo(4,livroTeste4,usuarioTeste1,data);
        gerenciadorEmprestimos.realizarEmprestimo(5,livroTeste5,usuarioTeste1,data);
        assertFalse(gerenciadorEmprestimos.realizarEmprestimo(6,livroTeste6,usuarioTeste1,data));
    }

    @Test
    public void shouldNotAllowRealizeLoanIfBookIsUnavailable(){
        gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data);
        assertFalse(gerenciadorEmprestimos.realizarEmprestimo(2,livroTeste1,usuarioTeste2,data));
    }

    @Test
    public void shouldRealizeLoan(){
        assertTrue(gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data));
        assertTrue(gerenciadorEmprestimos.realizarEmprestimo(2,livroTeste2,usuarioTeste2,data));
    }

    @Test
    public void shouldReturnBookWithFine(){
        data = "28-04-2022";
        gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data);
        assertTrue(gerenciadorEmprestimos.devolverLivro(livroTeste1,usuarioTeste1));
    }

    @Test
    public void shouldReturnBookWithoutFine(){
        data = "03-05-2022";
        gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data);
        assertTrue(gerenciadorEmprestimos.devolverLivro(livroTeste1,usuarioTeste1));
    }

    @Test
    public void shouldNotReturnBookWithNonExistentBook(){
        assertFalse(gerenciadorEmprestimos.devolverLivro(livroTeste1,usuarioTeste1));
    }

    @Test
    public void shouldRenewDateOfLoanWithFine(){
        data = "28-04-2022";
        gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data);
        assertTrue(gerenciadorEmprestimos.renovarLivro(livroTeste1,usuarioTeste1));
    }

    @Test
    public void shouldNotRenewDateOfLoanWithNonExistentBook(){
        assertFalse(gerenciadorEmprestimos.renovarLivro(livroTeste1,usuarioTeste1));
    }

    @Test
    public void shouldRenewDateOfLoanWithoutFine(){
        data = "03-05-2022";
        gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data);
        assertTrue(gerenciadorEmprestimos.renovarLivro(livroTeste1,usuarioTeste1));
    }

    @Test
    public void shouldListAllLoans(){
        gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data);
        gerenciadorEmprestimos.realizarEmprestimo(2,livroTeste2,usuarioTeste2,data);
        listaEmprestimosTeste = gerenciadorEmprestimos.listarHistoricoEmprestimos();
        assertEquals(2, listaEmprestimosTeste.size());
    }

    @Test
    public void shouldListCurrentlyLoans(){
        gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data);
        gerenciadorEmprestimos.realizarEmprestimo(2,livroTeste2,usuarioTeste2,data);
        gerenciadorEmprestimos.devolverLivro(livroTeste1,usuarioTeste1);

        listaEmprestimosTeste = gerenciadorEmprestimos.listarEmprestimos();
        assertEquals(1, listaEmprestimosTeste.size());
    }

    @Test
    public void shouldListLateLoans(){
        data = "05-04-2022";
        gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data);
        gerenciadorEmprestimos.devolverLivro(livroTeste1,usuarioTeste1);
        ArrayList<String> saida = gerenciadorEmprestimos.listaEmprestimosAtrasados();
        assertEquals(1,saida.size());
    }

    @Test
    public void shouldAddAllLoansToFile(){
        gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data);
        gerenciadorEmprestimos.realizarEmprestimo(2,livroTeste2,usuarioTeste2,data);
        assertTrue(gerenciadorEmprestimos.adicionarHistoricoEmprestimosArquivo("src/test/resources/"));
    }

    @Test
    public void shouldAddCurrentlyLoansToFile(){
        gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data);
        gerenciadorEmprestimos.devolverLivro(livroTeste1,usuarioTeste1);
        gerenciadorEmprestimos.realizarEmprestimo(2,livroTeste2,usuarioTeste2,data);
        listaEmprestimosTeste = gerenciadorEmprestimos.listarEmprestimos();
        assertTrue(gerenciadorEmprestimos.adicionarEmprestimosArquivo("src/test/resources/"));
    }

    @Test
    public void shouldAddLateLoansToFile(){
        data = "28-04-2022";
        gerenciadorEmprestimos.realizarEmprestimo(1,livroTeste1,usuarioTeste1,data);
        gerenciadorEmprestimos.devolverLivro(livroTeste1,usuarioTeste1);
        gerenciadorEmprestimos.realizarEmprestimo(2,livroTeste2,usuarioTeste2,data);
        gerenciadorEmprestimos.devolverLivro(livroTeste2,usuarioTeste2);
        assertTrue(gerenciadorEmprestimos.adicionarEmprestimosAtrasadosArquivo("src/test/resources/"));
    }
}
