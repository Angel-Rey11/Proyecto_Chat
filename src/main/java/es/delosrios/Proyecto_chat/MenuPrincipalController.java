package es.delosrios.Proyecto_chat;

import java.io.IOException;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;
import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MenuPrincipalController {
	
	@FXML
	private DialogPane vis;
	@FXML
	private TextField nombre;
	@FXML
	private TextArea desc;
	
	RepoSala rp = new RepoSala();
	
    
    @FXML
    private void switchToSalas()  throws IOException {
    	App.setRoot("Salas");
    }
    
    @FXML
    private void showSala() throws IOException {
    	vis.setVisible(true);
    }
    
    @FXML
    private void addSala() {
    	Sala sala = new Sala(nombre.getText(),desc.getText());
    	rp.addSala(sala);
    	rp.marshall(rp, "Salas.xml");
    	vis.setVisible(false);
    }
    
}
