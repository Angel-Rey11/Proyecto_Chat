package es.delosrios.Proyecto_chat;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class MenuPrincipalController {
	

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
}
