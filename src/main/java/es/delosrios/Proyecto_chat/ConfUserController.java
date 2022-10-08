package es.delosrios.Proyecto_chat;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.xml.sax.XMLReader;

import es.delosrios.Proyecto_chat.model.Dao.RepoUsuario;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;
import es.delosrios.Proyecto_chat.utils.DataService;
import es.delosrios.Proyecto_chat.utils.Dialog;
import es.delosrios.Proyecto_chat.utils.Loggers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ConfUserController implements Initializable{
	@FXML
	private Label user;
	@FXML
	private TextField newName;
	@FXML
	private TextField newNickName;
	@FXML
	private PasswordField newPassword;
	@FXML
	private PasswordField newConfirm;
	
	RepoUsuario ru = new RepoUsuario();
	Usuario u = DataService.user;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		XMLReader.class.getResourceAsStream("Salas.xml");
		XMLReader.class.getResourceAsStream("Usuarios.xml");
		ru.unmarshall("Usuarios.xml");
		user.setText(DataService.user.getNickName());
		newName.setText(DataService.user.getNombre());
		newNickName.setText(DataService.user.getNickName());
		newPassword.setText(DataService.user.getPassword());
		newConfirm.setText(DataService.user.getPassword());
		
	}
	
	@FXML
    private void switchToMenuPrincipal() throws IOException {
    	App.setRoot("MenuPrincipal");
    }
	
	@FXML
	private void modifyUser() throws IOException {
		ru.unmarshall("Usuarios.xml");
		String pass = newPassword.getText();
		String passN = newConfirm.getText();
		if (!pass.isEmpty() && !passN.isEmpty() && !newName.getText().isEmpty()) {
			if (pass.contentEquals(passN)) {
				ru.modifyUser(u, newName.getText(), newPassword.getText(), newNickName.getText());
				Usuario act = new Usuario (newName.getText(), newPassword.getText(), newNickName.getText());
				DataService.user = act;
				ru.marshall("Usuarios.xml");
				Dialog.showConfirm("OPERACIÓN EXITOSA", "CAMBIOS REALIZADOS CON ÉXITO", "LA CONTRASEÑA HA SIDO MODIFICADA CORRECTAMENTE");
				App.setRoot("MenuPrincipal");
			} else {
				Dialog.showError("ERROR", "CAMBIO DE CONTRASEÑA NO VÁLIDO", "LOS CAMPOS DEBEN COINCIDIR PARA APLICAR LOS CAMBIOS");
				Loggers.LogsSevere("NO SE PUDO CAMBIAR CONTRASEÑA. LOS CAMPOS NO COINCIDEN");
			}
		} else {
			Dialog.showError("ERROR", "FALLO AL INTRODUCIR DATOS", "TODOS LOS CAMPOS DEBEN SER COMPLETADOS");
			Loggers.LogsSevere("TODOS LOS CAMPOS DEBEN SER COMPLETADOS");
		}
	}
}
