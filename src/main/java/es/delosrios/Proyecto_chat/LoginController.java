package es.delosrios.Proyecto_chat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.xml.sax.XMLReader;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.Dao.RepoUsuario;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;
import es.delosrios.Proyecto_chat.utils.DataService;
import es.delosrios.Proyecto_chat.utils.Dialog;
import es.delosrios.Proyecto_chat.utils.Loggers;
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
		if (nickname.isEmpty() || password.isEmpty()) {
			Dialog.showError("ERROR", "FALLO AL INTRODUCIR DATOS", "TODOS LOS CAMPOS DEBEN SER COMPLETADOS");
			Loggers.LogsSevere("TODOS LOS CAMPOS DEBEN SER COMPLETADOS");
		} else {
			if (aux == null) {
				Dialog.showError("ERROR", "USUARIO NO ENCONTRADO", "EL USUARIO INTRODUCIDO NO EXISTE");
				Loggers.LogsSevere("EL USUARIO INTRODUCIDO NO ES VÁLIDO");
			} else {
				DataService.user=aux;
				inicio.setVisible(false);
				Dialog.showConfirm("OPERACIÓN EXITOSA", "ACCESO PERMITIDO", "BIENVENIDO");
				App.setRoot("MenuPrincipal");
			}
		}
	}
	
	@FXML
	private void signUp() {
		if (!nombreUser.getText().isEmpty() && !passwordUser.getText().isEmpty() && !nicknameUser.getText().isEmpty()) {
			Usuario u = new Usuario(nombreUser.getText(),passwordUser.getText(),nicknameUser.getText());
			ru.addUsuario(u);
			ru.marshall("Usuarios.xml");
			Dialog.showConfirm("OPERACIÓN EXITOSA", "USUARIO CREADO", "SE HA CREADO EL NUEVO USUARIO CORRECTAMENTE");
			registro.setVisible(false);
			inicio.setVisible(true);
		} else {
			Dialog.showError("ERROR", "FALLO AL CREAR USUARIO", "TODOS LOS CAMPOS DEBEN SER COMPLETADOS");
			Loggers.LogsSevere("FALTAN CAMPOS POR RELLENAR");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		XMLReader.class.getResourceAsStream("Salas.xml");
		XMLReader.class.getResourceAsStream("Usuarios.xml");
		ru.unmarshall("Usuarios.xml");
		rp.unmarshall("Salas.xml");
		
	}
}
