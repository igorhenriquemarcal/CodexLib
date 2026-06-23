package entities;
import java.time.LocalDate;

public class Emprestimo {
    private int codigo;
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevDevolucao;
    private boolean devolvido;

    public Emprestimo( int codigo, Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataPreDevolucao){
        this.codigo = codigo;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevDevolucao = dataPreDevolucao;
        this.devolvido = false;

    }
}
