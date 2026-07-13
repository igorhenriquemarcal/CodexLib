import entities.Biblioteca;
import entities.Livro;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class TelaLivros extends VBox {

    private Biblioteca biblioteca;
    private ListView<String> listaView;

    public TelaLivros(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        setPadding(new Insets(10));
        setSpacing(10);

        // campos de entrada
        TextField txtCodigo = new TextField();
        txtCodigo.setPromptText("Codigo");

        TextField txtTitulo = new TextField();
        txtTitulo.setPromptText("Titulo");

        TextField txtAutor = new TextField();
        txtAutor.setPromptText("Autor");

        TextField txtEditora = new TextField();
        txtEditora.setPromptText("Editora");

        TextField txtAno = new TextField();
        txtAno.setPromptText("Ano");

        TextField txtExemplares = new TextField();
        txtExemplares.setPromptText("Exemplares");

        Button btnCadastrar = new Button("Cadastrar Livro");

        // lista que mostra os livros cadastrados
        listaView = new ListView<>();

        btnCadastrar.setOnAction(e -> {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            String editora = txtEditora.getText();
            int ano = Integer.parseInt(txtAno.getText());
            int exemplares = Integer.parseInt(txtExemplares.getText());

            Livro livro = new Livro(codigo, titulo, autor, editora, ano, exemplares);
            biblioteca.cadastrarLivro(livro);

            listaView.getItems().add(livro.toString());

            // limpa os campos depois de cadastrar
            txtCodigo.clear();
            txtTitulo.clear();
            txtAutor.clear();
            txtEditora.clear();
            txtAno.clear();
            txtExemplares.clear();
        });

        getChildren().addAll(
                txtCodigo, txtTitulo, txtAutor,
                txtEditora, txtAno, txtExemplares,
                btnCadastrar, listaView
        );
    }
}