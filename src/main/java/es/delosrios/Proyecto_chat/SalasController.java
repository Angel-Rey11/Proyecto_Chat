package es.delosrios.Proyecto_chat;

import java.io.IOException;

import es.delosrios.Proyecto_chat.model.DataObject.Sala;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DialogPane;

public class SalasController {
	
	@FXML
	private ChoiceBox<Sala> cb;
	@FXML
	private DialogPane dialog;
	
	@FXML
    private void switchToMenuPrincipal() throws IOException {
    	App.setRoot("MenuPrincipal");
    }
	
	@FXML
	private void switchToChat() throws IOException {
		App.setRoot("Chat");
	}
	
	@FXML
	private void showDialog() throws IOException {
		dialog.setVisible(true);
	}
}
