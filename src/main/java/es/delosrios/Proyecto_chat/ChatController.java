package es.delosrios.Proyecto_chat;

import java.io.IOException;

import es.delosrios.Proyecto_chat.model.DataObject.Sala;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;

public class ChatController {
	
	
	@FXML
	private ChoiceBox<Sala> cb;
	@FXML
	private DialogPane dialog;
	@FXML
	private AnchorPane ap;
	
	@FXML
    private void switchToMenuPrincipal()  throws IOException {
    	App.setRoot("MenuPrincipal");
    }
	
	@FXML
	private void showTable() throws IOException {
		ap.setVisible(true);
		dialog.setVisible(false);
	}
}
