package es.delosrios.Proyecto_chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    /**
     * Método para iniciar escena
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"), 720, 550);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método para cambiar de ventana
     * @param fxml Nombre de la ventana a cambiar
     * @throws IOException Lanza posibles errores que puedan aparecer
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Método que ejecuta el programa
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

}