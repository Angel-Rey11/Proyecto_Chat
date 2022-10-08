package es.delosrios.Proyecto_chat;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import org.xml.sax.XMLReader;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.DataObject.Message;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;
import es.delosrios.Proyecto_chat.model.DataObject.Usuario;
import es.delosrios.Proyecto_chat.utils.DataService;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
	@FXML
	private TableView<Message> chat;
	@FXML
	private TableColumn<Message, String> texto;
	@FXML
	private TableColumn<Message, String> nickname;
	@FXML
	private TableColumn<Message, String> hora;
	@FXML
	private TextField mensaje;
	
	RepoSala s = new RepoSala();
	
	@FXML
    private void switchToMenuPrincipal()  throws IOException {
		s.unmarshall("Salas.xml");
    	App.setRoot("MenuPrincipal");
    }
	
	private void configureTabla() {
		texto.setCellValueFactory(mensaje -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(mensaje.getValue().getText());
			return ssp;
		});
		nickname.setCellValueFactory(mensaje -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(mensaje.getValue().getNickname());
			return ssp;
		});
		hora.setCellValueFactory(mensaje -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
			String hora = mensaje.getValue().getTime().format(formatter);
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(hora);
			return ssp;
		});
	}
	
	@FXML
	private void sendMessage() throws IOException {
		Message m = new Message(DataService.user.getNickName(),LocalDate.now(),mensaje.getText());
		DataService.sala = s.searchSala(DataService.sala);
		s.initArrayMessages(s.searchSala(DataService.sala), m);
		s.marshall("Salas.xml");
		mensaje.clear();
		initialize(null,null);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		s.unmarshall("Salas.xml");
		XMLReader.class.getResourceAsStream("Salas.xml");
		XMLReader.class.getResourceAsStream("Usuarios.xml");
		List<Message> misMensajes = DataService.sala.getAllMessagges();
		ObservableList<Message> ob = FXCollections.observableArrayList(misMensajes);
		this.configureTabla();
		chat.setItems(FXCollections.observableArrayList(ob));
		user.setText(DataService.user.getNickName());
		nombreS.setText(DataService.sala.getNombre());
		nUsuarios.setText(String.valueOf(DataService.sala.getAllUsers().size()));
	}
	
	@FXML
	public void outSala() throws IOException {
		DataService.sala.removeUser(DataService.user);
		s.searchSala(DataService.sala);
	}
}
