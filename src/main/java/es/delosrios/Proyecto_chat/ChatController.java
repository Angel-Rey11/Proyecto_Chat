package es.delosrios.Proyecto_chat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;
import es.delosrios.Proyecto_chat.utils.DataService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ChatController implements Initializable{
	
	@FXML
	private AnchorPane ap;
	@FXML
	private Label user;
	@FXML
	private Label nombreS;
	@FXML
	private Label nUsuarios;
	
	RepoSala s = new RepoSala();
	
	@FXML
    private void switchToMenuPrincipal()  throws IOException {
		s.unmarshall("Salas.xml");
    	App.setRoot("MenuPrincipal");
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		s.unmarshall("Salas.xml");
		user.setText(DataService.user.getNickName());
		nombreS.setText(DataService.sala.getNombre());
		nUsuarios.setText(String.valueOf(DataService.sala.getAllUsers().size()));
		
	}
	
	@FXML
	public void outSala() throws IOException {
		DataService.sala.removeUser(DataService.user);
		s.searchSala(DataService.sala);
		
		App.setRoot("Salas");
	}
}
