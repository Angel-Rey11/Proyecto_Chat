package es.delosrios.Proyecto_chat;

import java.io.IOException;

import javafx.fxml.FXML;

public class SalasController {
	
	@FXML
    private void switchToMenuPrincipal() throws IOException {
    	App.setRoot("MenuPrincipal");
    }
}
