package es.delosrios.Proyecto_chat;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.xml.sax.XMLReader;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.Dao.RepoUsuario;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;
import es.delosrios.Proyecto_chat.utils.DataService;
import es.delosrios.Proyecto_chat.utils.Dialog;
import es.delosrios.Proyecto_chat.utils.Loggers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MenuPrincipalController implements Initializable {
	
	@FXML
	private DialogPane vis;
	@FXML
	private TextField nombre;
	@FXML
	private TextArea desc;
	@FXML
	private Label user;
	
	
	RepoSala rp = new RepoSala();
	RepoUsuario ru = new RepoUsuario();
	
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
    	if (!rp.existSala(sala)) {
	    	rp.addSala(sala);
	    	Dialog.showConfirm("OPERACIÓN EXITOSA", "SALA CREADA", "SE HA CREADO LA NUEVA CORRECTAMENTE");
	    	rp.marshall("Salas.xml");
	    	vis.setVisible(false);
	    	initialize(null,null);
    	} else {
    		Dialog.showError("ERROR", "SALA EXISTENTE", "NO SE PUEDE CREAR LA SALA. SALA EXISTENTE");
    		nombre.clear();
    		desc.clear();
    		Loggers.LogsSevere("LA SALA YA EXISTE");
    	}
    }
    
    @FXML
    private void logOut() throws IOException {
    	DataService.user = null;
    	App.setRoot("Login");
    }
    
    @FXML
    private void deleteUser() throws IOException {
    	List<Usuario> misUsuarios = ru.unmarshall("Usuarios.xml");
    	for(Usuario u: misUsuarios) {
    		if(u.getNickName().equals(DataService.user.getNickName())) {
    			ru.removeUsuario(u);
    			DataService.user = null;
    			ru.marshall("Usuarios.xml");
    			App.setRoot("Login");
    		}
    	}
    }
    
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		XMLReader.class.getResourceAsStream("Salas.xml");
		XMLReader.class.getResourceAsStream("Usuarios.xml");
		rp.unmarshall("Salas.xml");
		ru.unmarshall("Usuarios.xml");
		user.setText(DataService.user.getNickName());
	}
}
