package es.delosrios.Proyecto_chat;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DialogPane;
import javafx.scene.image.ImageView;

public class MenuPrincipalController {
    
    @FXML
    private void switchToSalas()  throws IOException {
    	App.setRoot("Salas");
    }
    
}
