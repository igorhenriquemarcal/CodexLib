package entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    //metodos de cadastro
    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void realizarEmprestimo(int matricula, int codigoLivro) {

        //Busca do usuario
        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.getMatricula() == matricula) {
                usuario = u;
                break;
            }
        }

        //Busca do livro
        Livro livro = null;
        for (Livro l : livros){
            if (l.getCodigo() == codigoLivro){
                livro = l;
                break;
            }
        }

        //Validação de achou os dois
        if (usuario == null){
            System.out.println("Usuario nao encontrado");
            return;
        }
        if (livro == null){
            System.out.println("Livro nao encontrado");
            return;
        }

        //Verificação de exemplares
        if(livro.getExemplares() <= 0){
            System.out.println("Nenhum exemplar disponivel");
            return;
        }

        //Calcula o prazo
        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucao = dataEmprestimo.plusDays(usuario.getDiasEmprestimo());

        //Registro do emprestimo
        int codigo = emprestimos.size() + 1;
        Emprestimo emprestimo = new Emprestimo(codigo, usuario, livro, dataEmprestimo, dataDevolucao);
        emprestimos.add(emprestimo);

        System.out.println("Emprestimo realizado com sucesso!");
        System.out.println(emprestimo);
    }

    public void devolverLivro(int codigoEmprestimo){
        Emprestimo emprestimo = null;
        for (Emprestimo e : emprestimos) {
            if (e.getCodigo() == codigoEmprestimo) {
                emprestimo = e;
                break;
            }
        }

            if (emprestimo == null){
                System.out.println("Emprestimo nao encontrado");
                return;
            }

            if (emprestimo.isDevolvido()){
                System.out.println("Emprestimo ja foi devolvido");
                return;
            }

            emprestimo.setDevolvido(true);
            System.out.println("Livro devolvido com sucesso");
        }

        //Lista todos o livros
    public void listarLivros() {
        for (Livro l : livros) {
            System.out.println(l);
        }
    }
    public void listarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }
    public void listarEmprestimos(){
        for (Emprestimo e : emprestimos){
            if (!e.isDevolvido()){
                System.out.println(e);
            }
        }
    }
    public List<Emprestimo> getEmprestimosAtivos() {
        List<Emprestimo> ativos = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (!e.isDevolvido()) {
                ativos.add(e);
            }
        }
        return ativos;
    }
}
