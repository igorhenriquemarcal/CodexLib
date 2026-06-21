package entities;

public class Livro {
    private int codigo;
    private String titulo;
    private String autor;
    private String editora;
    private int ano;
    private int exemplares;
    private int emprestimosRealizados;

    public Livro (int codigo, String titulo, String autor, String editora, int ano, int exemplares) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano = ano;
        this.exemplares = exemplares;
        this.emprestimosRealizados = 0;
    }

    //getter e setter

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getAno() {
        return ano;
    }

    public int getExemplares() {
        return exemplares;
    }

    public int getEmprestimosRealizados() {
        return emprestimosRealizados;
    }

    @Override
    public String toString(){
        return "Codigo: " + codigo + "| Tirulo: " + titulo
               +"| Autor: " + autor + "| Editora: " + editora + "| Ano: " + ano
                + "| Exemplares: " + exemplares;
    }
}
