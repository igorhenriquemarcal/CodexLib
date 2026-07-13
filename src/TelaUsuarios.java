import entities.Aluno;
import entities.Biblioteca;
import entities.Professor;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.time.LocalDate;

public class TelaUsuarios extends VBox {

    private Biblioteca biblioteca;
    private ListView<String> listaView;

    public TelaUsuarios(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        setPadding(new Insets(10));
        setSpacing(10);

        TextField txtMatricula = new TextField();
        txtMatricula.setPromptText("Matricula");

        TextField txtNome = new TextField();
        txtNome.setPromptText("Nome");

        TextField txtTelefone = new TextField();
        txtTelefone.setPromptText("Telefone");

        TextField txtExtra = new TextField();
        txtExtra.setPromptText("Curso (Aluno) ou Departamento (Professor)");

        // escolha do tipo de usuario
        ToggleGroup grupo = new ToggleGroup();
        RadioButton rbAluno = new RadioButton("Aluno");
        RadioButton rbProfessor = new RadioButton("Professor");
        rbAluno.setToggleGroup(grupo);
        rbProfessor.setToggleGroup(grupo);
        rbAluno.setSelected(true);

        HBox tipoBox = new HBox(10, rbAluno, rbProfessor);

        Button btnCadastrar = new Button("Cadastrar Usuario");

        listaView = new ListView<>();

        btnCadastrar.setOnAction(e -> {
            int matricula = Integer.parseInt(txtMatricula.getText());
            String nome = txtNome.getText();
            String telefone = txtTelefone.getText();
            String extra = txtExtra.getText();

            if (rbAluno.isSelected()) {
                Aluno aluno = new Aluno(matricula, nome, telefone, LocalDate.now(), extra);
                biblioteca.cadastrarUsuario(aluno);
                listaView.getItems().add(aluno.toString());
            } else {
                Professor professor = new Professor(matricula, nome, telefone, LocalDate.now(), extra);
                biblioteca.cadastrarUsuario(professor);
                listaView.getItems().add(professor.toString());
            }

            txtMatricula.clear();
            txtNome.clear();
            txtTelefone.clear();
            txtExtra.clear();
        });

        getChildren().addAll(
                txtMatricula, txtNome, txtTelefone,
                txtExtra, tipoBox, btnCadastrar, listaView
        );
    }
}