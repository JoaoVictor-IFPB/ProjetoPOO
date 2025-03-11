package Application;

import Controller.GerenciadorCardapio;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    GerenciadorCardapio gerenciadorCardapio = new GerenciadorCardapio();

    public static void main(String[] args) { launch(args); }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/TelaLogin.fxml"));

        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.setOnCloseRequest(event -> {
            gerenciadorCardapio.limparCardapio();
        });
        primaryStage.show();
    }
}
