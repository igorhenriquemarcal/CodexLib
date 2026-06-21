package entities;

import java.time.LocalDate;

public abstract class Usuario {
    private int matricula;
    private String nome;
    private String telefone;
    private LocalDate dataCadastro;

    public Usuario(int matricula, String nome, String telefone, LocalDate dataCadastro){
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
    }

    //getter and setter
    public abstract int getDiasEmprestimo();

    public abstract int getLimiteEmprestimosSimultaneos();

    public int getMatricula(){
        return matricula;
    }

    public String nome(){
        return nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    @Override
    public String toString(){
        return "Matricula: " + matricula + "| Nome: " + nome + "| Telefone: " + telefone;
    }
}
