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

    //getter e setter

    public int getCodigo() {
        return codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataPrevDevolucao() {
        return dataPrevDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;

    }

    public void setDevolvido(boolean devolvido){
        this.devolvido = devolvido;
    }

    @Override
    public String toString(){
        return "Codigo: " + codigo +
                " | Usuario: " + usuario.getNome() +
                " | Livro: " + livro.getTitulo() +
                " | Devolucao prevista: " + dataPrevDevolucao +
                " | Devolvido: " + devolvido;
    }
}
