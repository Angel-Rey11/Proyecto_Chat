package es.delosrios.Proyecto_chat;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.xml.sax.XMLReader;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.Dao.RepoUsuario;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;
import es.delosrios.Proyecto_chat.utils.DataService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MenuPrincipalController implements Initializable {
	
	@FXML
	private DialogPane vis;
	@FXML
	private TextField nombre;
	@FXML
	private TextArea desc;
	@FXML
	private Label salas;
	@FXML
	private Label user;
	
	
	RepoSala rp = new RepoSala();
	RepoUsuario ru = new RepoUsuario();
	
	
	@FXML
	protected void nSalas() {
		List<Sala> misSalas = new ArrayList<>();
		misSalas = rp.unmarshall("Salas.xml");
		Integer nSalas = misSalas.size();
		if(nSalas == 0) {
			salas.setText(String.valueOf(0));
		} else {
			salas.setText(String.valueOf(nSalas));
		}
	}
	
    @FXML
    private void switchToSalas()  throws IOException {
    	App.setRoot("Salas");
    	
    }
    
    @FXML
    private void showSala() throws IOException {
    	vis.setVisible(true);
    }
    
    @FXML
    private void switchToConf() throws IOException {
    	App.setRoot("ConfUser");
    }
    
    @FXML
    private void addSala() {
    	rp.unmarshall("Salas.xml");
    	Sala sala = new Sala(nombre.getText(),desc.getText());
    	rp.addSala(sala);
    	rp.marshall("Salas.xml");
    	vis.setVisible(false);
    	nSalas();
    	initialize(null,null);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		XMLReader.class.getResourceAsStream("Salas.xml");
		XMLReader.class.getResourceAsStream("Usuarios.xml");
		rp.unmarshall("Salas.xml");
		ru.unmarshall("Usuarios.xml");
		nSalas();
		user.setText(DataService.user.getNickName());
	}
}
