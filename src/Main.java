import entities.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("\n=== BIBLIOTECA ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Usuario");
            System.out.println("3. Realizar Emprestimo");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Listar Livros");
            System.out.println("6. Listar Usuarios");
            System.out.println("7. Listar Emprestimos Ativos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarLivro(scanner, biblioteca);
                case 2 -> cadastrarUsuario(scanner, biblioteca);
                case 3 -> realizarEmprestimo(scanner, biblioteca);
                case 4 -> devolverLivro(scanner, biblioteca);
                case 5 -> biblioteca.listarLivros();
                case 6 -> biblioteca.listarUsuarios();
                case 7 -> biblioteca.listarEmprestimos();
                case 0 -> { System.out.println("Saindo..."); return; }
                default -> System.out.println("Opcao invalida.");
            }
        }
    }

    static void cadastrarLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Codigo: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        System.out.print("Editora: ");
        String editora = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Exemplares: ");
        int exemplares = scanner.nextInt();
        scanner.nextLine();

        Livro livro = new Livro(codigo, titulo, autor, editora, ano, exemplares);
        biblioteca.cadastrarLivro(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    static void cadastrarUsuario(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("Tipo: 1. Aluno  2. Professor");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Matricula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Curso: ");
            String curso = scanner.nextLine();
            Aluno aluno = new Aluno(matricula, nome, telefone, java.time.LocalDate.now(), curso);
            biblioteca.cadastrarUsuario(aluno);
        } else {
            System.out.print("Departamento: ");
            String departamento = scanner.nextLine();
            Professor professor = new Professor(matricula, nome, telefone, java.time.LocalDate.now(), departamento);
            biblioteca.cadastrarUsuario(professor);
        }
        System.out.println("Usuario cadastrado com sucesso!");
    }

    static void realizarEmprestimo(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Matricula do usuario: ");
        int matricula = scanner.nextInt();

        System.out.print("Codigo do livro: ");
        int codigoLivro = scanner.nextInt();
        scanner.nextLine();

        biblioteca.realizarEmprestimo(matricula, codigoLivro);
    }

    static void devolverLivro(Scanner scanner, Biblioteca biblioteca) {
        System.out.print("Codigo do emprestimo: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        biblioteca.devolverLivro(codigo);
    }
}