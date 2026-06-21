package entities;

import java.time.LocalDate;
public class Professor extends Usuario{
    private String departamento;

    public Professor(int matricula, String nome, String telefone, LocalDate dataCadastro, String departamento){
        super(matricula, nome, telefone, dataCadastro);
        this.departamento = departamento;
    }

    @Override
    public int getDiasEmprestimo(){
    return 30;
    }

    @Override
    public int getLimiteEmprestimosSimultaneos(){
        return 10;
    }

    public String getDepartamento(){
        return departamento;
    }

    @Override
    public String toString() {
        return super.toString() + "Departamento: " + departamento + "| Tipo: Professor";
    }
}
