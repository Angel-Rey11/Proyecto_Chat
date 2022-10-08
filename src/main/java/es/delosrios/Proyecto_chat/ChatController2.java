package es.delosrios.Proyecto_chat;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import org.xml.sax.XMLReader;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.Dao.RepoUsuario;
import es.delosrios.Proyecto_chat.model.DataObject.Message;
import es.delosrios.Proyecto_chat.utils.DataService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ChatController2 implements Initializable{
	
	@FXML
	private AnchorPane ap;
	@FXML
	private Label user;
	@FXML
	private Label nombreS;
	@FXML
	private Label nUsuarios;
	@FXML
	private TextField mensaje;
	@FXML
	private TableView<Message> chat;
	@FXML
	private TableColumn<Message, String> texto;
	@FXML
	private TableColumn<Message, String> nickname;
	@FXML
	private TableColumn<Message, String> hora;
	
	RepoSala s = new RepoSala();
	RepoUsuario r = new RepoUsuario();
	
	@FXML
	private void sendMessage() throws IOException {
		s.unmarshall("Salas.xml");
		Message m = new Message(DataService.user.getNickName(),LocalDate.now(),mensaje.getText());
		DataService.sala = s.searchSala(DataService.sala);
		s.initArrayMessages(s.searchSala(DataService.sala), m);
		s.marshall("Salas.xml");
		mensaje.clear();
		initialize(null,null);
		App.setRoot("Chat");
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
	
}
