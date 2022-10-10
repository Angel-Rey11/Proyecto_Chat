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
import javafx.scene.control.Button;
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
	private Button signin;
	
	/**
	 * Método para superponer escena y hacer invisible la anterior
	 */
	@FXML
	private void showRegister() {
		registro.setVisible(true);
		inicio.setVisible(false);
	}
	
	/**
	 * Método para superponer escena y hacer invisible la anterior
	 */
	@FXML
	private void showInicio() {
		inicio.setVisible(true);
		registro.setVisible(false);
	}
	
	/**
	 * Método que permite controlar el acceso al programa de un usuario
	 * @throws IOException Lanza posibles errores que puedan aparecer
	 */
	@FXML
	private void signIn() throws IOException {
		String nickname = nicknameInicio.getText();
		String password = passwordInicio.getText();
		Usuario aux = ru.validateLogin(nickname, password);
		if (nickname.isEmpty() || password.isEmpty()) {
			Dialog.showError("ERROR", "FALLO AL INTRODUCIR DATOS", "TODOS LOS CAMPOS DEBEN SER COMPLETADOS");
			nicknameInicio.clear();
			passwordInicio.clear();
			Loggers.LogsSevere("TODOS LOS CAMPOS DEBEN SER COMPLETADOS");
		} else {
			if (aux == null) {
				Dialog.showError("ERROR", "USUARIO NO ENCONTRADO", "EL USUARIO INTRODUCIDO NO EXISTE");
				nicknameInicio.clear();
				passwordInicio.clear();
				Loggers.LogsSevere("EL USUARIO INTRODUCIDO NO ES VÁLIDO");
			} else {
				DataService.user=aux;
				inicio.setVisible(false);
				Dialog.showConfirm("OPERACIÓN EXITOSA", "ACCESO PERMITIDO", "BIENVENIDO");
				Loggers.LogsInfo("ACCESO PERMITIDO");
				App.setRoot("MenuPrincipal");
			}
		}
	}
	
	/**
	 * Método que permite controlar el registro de un usuario
	 */
	@FXML
	private void signUp() {
		if (!nombreUser.getText().isEmpty() && !passwordUser.getText().isEmpty() && !nicknameUser.getText().isEmpty()) {
			Usuario u = new Usuario(nombreUser.getText(),passwordUser.getText(),nicknameUser.getText());
			if (!ru.existUser(u)){
				ru.addUsuario(u);
				ru.marshall("Usuarios.xml");
				Dialog.showConfirm("OPERACIÓN EXITOSA", "USUARIO CREADO", "SE HA CREADO EL NUEVO USUARIO CORRECTAMENTE");
				Loggers.LogsInfo("USUARIO CREADO CORRECTAMENTE");
				nombreUser.clear();
				passwordUser.clear();
				nicknameUser.clear();
				registro.setVisible(false);
				inicio.setVisible(true);
			} else {
				Dialog.showError("ERROR", "USUARIO EXISTENTE", "NO SE PUEDE REGISTRAR. EL USUARIO YA EXISTE");
				nombreUser.clear();
				passwordUser.clear();
				nicknameUser.clear();
				Loggers.LogsSevere("EL USUARIO YA EXISTE");
			}
		} else {
			Dialog.showError("ERROR", "FALLO AL CREAR USUARIO", "TODOS LOS CAMPOS DEBEN SER COMPLETADOS");
			nombreUser.clear();
			passwordUser.clear();
			nicknameUser.clear();
			Loggers.LogsSevere("FALTAN CAMPOS POR RELLENAR");
		}
	}

	/**
     * Método con funcionalidades del programa
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		XMLReader.class.getResourceAsStream("Salas.xml");
		XMLReader.class.getResourceAsStream("Usuarios.xml");
		signin.setDefaultButton(true);
		ru.unmarshall("Usuarios.xml");
		rp.unmarshall("Salas.xml");
		
	}
}
