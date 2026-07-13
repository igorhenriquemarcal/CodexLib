package entities;

import java.time.LocalDate;

public class Aluno extends Usuario{
    private String curso;

    public Aluno(int matricula, String nome, String telefone, LocalDate dataCadastro, String curso){
        super(matricula, nome, telefone, dataCadastro);
        this.curso = curso;
    }

    @Override
    public int getDiasEmprestimo() {
        return 7;
    }

    @Override
    public int getLimiteEmprestimosSimultaneos(){
        return 10;
    }

    public String getCurso(){
        return curso;
    }

    @Override
    public String toString(){
        return super.toString() + "| Curso: " + curso + "| Tipo: Aluno";
    }

}
