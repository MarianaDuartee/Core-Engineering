package org.marianaduarte.tema08;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

public class GerenciadorEmprestimos {
    private final ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private final ArrayList<Emprestimo> historicoEmprestimos = new ArrayList<>();
    private final ArrayList<Emprestimo> emprestimosAtrasados = new ArrayList<>();
    private static final int MAX_LIVROS = 5;
    private static final int PRAZO_ENTREGA = 7;

    public boolean realizarEmprestimo(Integer id,Livros livro, Usuario usuario, String dataEmprestimo) {
        if(id == null ){
            return false;
        }

        if(usuario == null || usuario.getNome().isBlank() || usuario.getId() == null || usuario.getNumLivros() >= MAX_LIVROS){
            return false;
        }
        if(livro == null || livro.getTitulo().isBlank() || livro.getAutor().isBlank() || usuario.getId() == null || (livro.isEmprestado())){
            return false;
        }

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate data = LocalDate.parse(dataEmprestimo,formato);
        emprestimos.add(new Emprestimo(id,livro,usuario,data));
        historicoEmprestimos.add(new Emprestimo(id,livro,usuario,data));
        usuario.setNumLivros(usuario.getNumLivros()+1);
        usuario.setQtdEmprestimos(usuario.getQtdEmprestimos()+1);
        livro.setEmprestado(true);

        return true;
    }

    public boolean devolverLivro(Livros livro, Usuario usuario) {
        for(Emprestimo emp : emprestimos) {
            if (Objects.equals(emp.getLivro().getId(), livro.getId())) {
                if (Objects.equals(emp.getUsuario().getId(), usuario.getId())) {
                    emp.setDataDevolvida(LocalDate.now());
                    long dias = (emp.getDataEmprestada().until(emp.getDataDevolvida(), ChronoUnit.DAYS));
                    if (dias > PRAZO_ENTREGA) {
                        long diasAtrasados = dias - PRAZO_ENTREGA;
                        long multa = emp.calcularMulta(diasAtrasados);
                        emp.setDiasAtrasados(diasAtrasados);
                        emp.setMultaAtraso(multa);
                        System.out.println("\nPara o usuario " + usuario.getNome() + " devolver o livro " + livro.getTitulo() + " é necessário pagar a multa de R$" + emp.getMultaAtraso() + " pelo atraso.");
                        emprestimosAtrasados.add(emp);
                        emprestimos.remove(emp);
                        livro.setEmprestado(false);
                        usuario.setNumLivros(usuario.getNumLivros() - 1);
                        System.out.println("Livro Devolvido após o pagamento da multa de R$"+emp.getMultaAtraso());
                        return true;
                    } else {
                        System.out.println("Livro devolvido sem atraso!");
                        emprestimos.remove(emp);
                        livro.setEmprestado(false);
                        usuario.setNumLivros(usuario.getNumLivros() - 1);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean renovarLivro(Livros livro, Usuario usuario) {
        for(Emprestimo emp : emprestimos) {
            if (Objects.equals(emp.getLivro().getId(), livro.getId())) {
                if (Objects.equals(emp.getUsuario().getId(), usuario.getId())) {
                    emp.setDataDevolvida(LocalDate.now());
                    long dias = (emp.getDataEmprestada().until(emp.getDataDevolvida(), ChronoUnit.DAYS));
                    if (dias > PRAZO_ENTREGA) {
                        long diasAtrasados = dias - PRAZO_ENTREGA;
                        long multa = emp.calcularMulta(diasAtrasados);
                        emp.setDiasAtrasados(diasAtrasados);
                        emp.setMultaAtraso(multa);
                        System.out.println("\nPara o usuario " + usuario.getNome() + " renovar o livro " + livro.getTitulo() + " é necessário pagar a multa de R$" + emp.getMultaAtraso() + " pelo atraso!");
                        emprestimosAtrasados.add(emp);
                        emp.setDataEmprestada(LocalDate.now());
                        System.out.println("Livro com prazo renovado após o pagamento da multa de R$"+emp.getMultaAtraso());
                        return true;
                    }
                    else {
                        System.out.println("\nLivro com prazo renovado e sem multa!");
                        emp.setDataEmprestada(LocalDate.now());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public ArrayList<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public ArrayList<Emprestimo> listarHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    public ArrayList<String> listaEmprestimosAtrasados(){
        ArrayList<String> empAtrasados = new ArrayList<>();
        String atrasados;
        for (Emprestimo emp : emprestimosAtrasados) {
            atrasados = "IdEmprestimo:"+emp.getId()+"| NomeUsuario: "+emp.getUsuario().getNome()+"| Dias em atraso: "+emp.getDiasAtrasados()+"| Valor da multa:R$"+emp.getMultaAtraso()+"\n";
            empAtrasados.add(atrasados);
        }
        return empAtrasados;
    }

    public boolean adicionarEmprestimosArquivo(String caminho){
        File diretorio = new File(caminho);
        File arquivo = new File(diretorio,"Emprestimos.txt");
        try(
                FileWriter fileWriter = new FileWriter(arquivo,true);
                PrintWriter printWriter = new PrintWriter(fileWriter)) {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            printWriter.println("IdEmprestimo;IdLivro;TituloLivro;IdUsuario;NomeUsuario;DataEmprestada");
            for (Emprestimo emprestimo : emprestimos) {
                printWriter.println(emprestimo.getId() + ";" + emprestimo.getLivro().getId() + ";" + emprestimo.getLivro().getTitulo() + ";" + emprestimo.getUsuario().getId() + ";" + emprestimo.getUsuario().getNome() + ";" + emprestimo.getDataEmprestada());
            }
        }
        catch (IOException e) {
        System.out.println(e.getMessage());
        return false;
    }
        return true;
    }

    public boolean adicionarHistoricoEmprestimosArquivo(String caminho){
        File diretorio = new File(caminho);
        File arquivo = new File(diretorio,"HistoricoEmprestimos.txt");
        try(FileWriter fileWriter = new FileWriter(arquivo,true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            printWriter.println("IdEmprestimo;IdLivro;TituloLivro;IdUsuario;NomeUsuario;DataEmprestada");
            for (Emprestimo emprestimo : historicoEmprestimos) {
                printWriter.println(emprestimo.getId()+";"+ emprestimo.getLivro().getId() + ";" + emprestimo.getLivro().getTitulo() + ";" + emprestimo.getUsuario().getId() + ";" + emprestimo.getUsuario().getNome() + ";" + emprestimo.getDataEmprestada());
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean adicionarEmprestimosAtrasadosArquivo(String caminho){
        File diretorio = new File(caminho);
        File arquivo = new File(diretorio,"EmprestimosAtrasados.txt");
        try(FileWriter fileWriter = new FileWriter(arquivo,true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            printWriter.println("IdEmprestimo;IdLivro;TituloLivro;IdUsuario;NomeUsuario;DataEmprestada;DataDevolvida;DiasAtrasados;Multa");
            for (Emprestimo emprestimo : emprestimosAtrasados) {
                long diasAtrasados = (emprestimo.getDataEmprestada().until(emprestimo.getDataDevolvida(), ChronoUnit.DAYS));
                long multa = emprestimo.calcularMulta(diasAtrasados);
                printWriter.println(emprestimo.getId()+";"+emprestimo.getLivro().getId() + ";" + emprestimo.getLivro().getTitulo() + ";" + emprestimo.getUsuario().getId() + ";" + emprestimo.getUsuario().getNome() + ";" + emprestimo.getDataEmprestada()+";"+emprestimo.getDataDevolvida()+";"+diasAtrasados+";R$"+multa);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}

