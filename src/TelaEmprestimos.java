import entities.Biblioteca;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class TelaEmprestimos extends VBox {

    private Biblioteca biblioteca;
    private ListView<String> listaView;

    public TelaEmprestimos(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        setPadding(new Insets(10));
        setSpacing(10);

        // seção de empréstimo
        Label lblEmprestimo = new Label("Realizar Emprestimo");
        lblEmprestimo.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        TextField txtMatricula = new TextField();
        txtMatricula.setPromptText("Matricula do Usuario");

        TextField txtCodigo = new TextField();
        txtCodigo.setPromptText("Codigo do Livro");

        Button btnEmprestar = new Button("Realizar Emprestimo");

        // seção de devolução
        Label lblDevolucao = new Label("Devolver Livro");
        lblDevolucao.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        TextField txtCodigoEmprestimo = new TextField();
        txtCodigoEmprestimo.setPromptText("Codigo do Emprestimo");

        Button btnDevolver = new Button("Devolver");

        // lista de empréstimos ativos
        Label lblLista = new Label("Emprestimos Ativos");
        lblLista.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

        listaView = new ListView<>();

        Button btnAtualizar = new Button("Atualizar Lista");

        // ação do botão emprestar
        btnEmprestar.setOnAction(e -> {
            int matricula = Integer.parseInt(txtMatricula.getText());
            int codigoLivro = Integer.parseInt(txtCodigo.getText());
            biblioteca.realizarEmprestimo(matricula, codigoLivro);
            txtMatricula.clear();
            txtCodigo.clear();
            atualizarLista();
        });

        // ação do botão devolver
        btnDevolver.setOnAction(e -> {
            int codigoEmprestimo = Integer.parseInt(txtCodigoEmprestimo.getText());
            biblioteca.devolverLivro(codigoEmprestimo);
            txtCodigoEmprestimo.clear();
            atualizarLista();
        });

        // ação do botão atualizar
        btnAtualizar.setOnAction(e -> atualizarLista());

        getChildren().addAll(
                lblEmprestimo,
                txtMatricula, txtCodigo, btnEmprestar,
                new Separator(),
                lblDevolucao,
                txtCodigoEmprestimo, btnDevolver,
                new Separator(),
                lblLista, btnAtualizar, listaView
        );
    }

    private void atualizarLista() {
        listaView.getItems().clear();
        biblioteca.getEmprestimosAtivos().forEach(e ->
                listaView.getItems().add(e.toString())
        );
    }
}