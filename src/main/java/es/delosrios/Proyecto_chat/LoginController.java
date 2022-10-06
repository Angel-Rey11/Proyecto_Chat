package es.delosrios.Proyecto_chat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.Dao.RepoUsuario;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;
import es.delosrios.Proyecto_chat.utils.DataService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable{
	
	RepoUsuario ru = new RepoUsuario();
	RepoSala rp = new RepoSala();
	
	@FXML
	protected AnchorPane inicio;
	@FXML
	private AnchorPane registro;
	@FXML
	private TextField nombreUser;
	@FXML
	private TextField nicknameUser;
	@FXML
	private PasswordField passwordUser;
	@FXML
	private TextField nicknameInicio;
	@FXML
	private PasswordField passwordInicio;
	
	
	@FXML
	private void showRegister() {
		registro.setVisible(true);
		inicio.setVisible(false);
	}
	
	@FXML
	private void showInicio() {
		inicio.setVisible(true);
		registro.setVisible(false);
	}
	
	@FXML
	private void signIn() throws IOException {
		String nickname = nicknameInicio.getText();
		String password = passwordInicio.getText();
		Usuario aux = ru.validateLogin(nickname, password);
		if (aux == null) {
			System.out.println("No");
		} else {
			DataService.user=aux;
			inicio.setVisible(false);
			App.setRoot("MenuPrincipal");
		}
		
	}
	
	@FXML
	private void signUp() {
		Usuario u = new Usuario(nombreUser.getText(),passwordUser.getText(),nicknameUser.getText());
		ru.addUsuario(u);
		ru.marshall("Usuarios.xml");
		registro.setVisible(false);
		inicio.setVisible(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rp.unmarshall("Salas.xml");
		ru.unmarshall("Usuarios.xml");
		
	}
}
