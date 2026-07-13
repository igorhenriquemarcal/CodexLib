import entities.Biblioteca;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        Biblioteca biblioteca = new Biblioteca();

        TabPane tabPane = new TabPane();

        Tab tabLivros = new Tab("Livros", new TelaLivros(biblioteca));
        Tab tabUsuarios = new Tab("Usuarios", new TelaUsuarios(biblioteca));
        Tab tabEmprestimos = new Tab("Emprestimos", new TelaEmprestimos(biblioteca));

        tabLivros.setClosable(false);
        tabUsuarios.setClosable(false);
        tabEmprestimos.setClosable(false);

        tabPane.getTabs().addAll(tabLivros, tabUsuarios, tabEmprestimos);

        Scene scene = new Scene(tabPane, 800, 600);
        stage.setTitle("Sistema de Biblioteca");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}