package es.delosrios.Proyecto_chat;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import org.xml.sax.XMLReader;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.Dao.RepoUsuario;
import es.delosrios.Proyecto_chat.model.DataObject.Message;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;
import es.delosrios.Proyecto_chat.utils.DataService;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
	private TableView<Message> chat;
	@FXML
	private TableColumn<Message, String> texto;
	@FXML
	private TableColumn<Message, String> nickname;
	@FXML
	private TableColumn<Message, String> hora;
	@FXML
	private TextField mensaje;
	@FXML
	private Label nUsuarios;
	@FXML
	private Button send;
	
	RepoSala srp = new RepoSala();
	RepoUsuario r = new RepoUsuario();
	
	private ObservableList<Message> ob;
	private List<Message> misMensajes;

	/**
	 * Método para cambiar de escena
	 * @throws IOException Lanza posibles errores que puedan aparecer
	 */
	@FXML
    private void switchToMenuPrincipal()  throws IOException {
		srp.unmarshall("Salas.xml");
    	App.setRoot("MenuPrincipal");
    }
	
	/**
	 * Método para setear valores en las celdas de la tabla
	 */
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
	
	/**
	 * Método para enviar mensaje
	 * @throws IOException Lanza posibles errores que puedan aparecer
	 */
	@FXML
	private void sendMessage() throws IOException {
		srp.unmarshall("Salas.xml");
		Message m = new Message(DataService.user.getNickName(),LocalDate.now(),mensaje.getText());
		DataService.sala = srp.searchSala(DataService.sala);
		srp.initArrayMessages(srp.searchSala(DataService.sala), m);
		srp.marshall("Salas.xml");
		mensaje.clear();
	}
	
	/**
     * Método con funcionalidades del programa
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		send.setDefaultButton(true);
		srp.unmarshall("Salas.xml");
		XMLReader.class.getResourceAsStream("Salas.xml");
		XMLReader.class.getResourceAsStream("Usuarios.xml");
		nUsuarios.setText(String.valueOf(DataService.sala.getAllUsers().size()));
		misMensajes = DataService.sala.getAllMessagges();
		ob = FXCollections.observableArrayList(misMensajes);
		chat.setItems(ob);
		this.configureTabla();
		user.setText(DataService.user.getNickName());
		nombreS.setText(DataService.sala.getNombre());
		Platform.runLater(()->{
			Timer timer = new Timer(true);
	           timer.scheduleAtFixedRate(new TimerTask() {
	               @Override
	               public void run() {
	            	   List<Sala> misSalas = srp.unmarshall("Salas.xml");
	            	   Sala s1 = null;
	            	   for (Sala s : misSalas) {
	            		   if (s.getNombre().equals(DataService.sala.getNombre())) {
	            			   s1 = s;
	            			   
	            		   }
	            	   }
	            	   ob.removeAll(ob);
	            	   misMensajes = s1.getAllMessagges();
	           		   ob.addAll(misMensajes);
	               }
	           },500,500);
		});
	}
	
	/**
	 * Método para sacar al usuario de la sala
	 * @throws IOException Lanza posibles errores que puedan aparecer
	 */
	@FXML
	public void outSala() throws IOException {
		List<Sala> misSalas = srp.unmarshall("Salas.xml");
		Sala s1 = null;
		for (Sala s : misSalas) {
 		   if (s.getNombre().equals(DataService.sala.getNombre())) {
 			   	s1 = s;
 			   	s.removeArray(s1, DataService.user);
 			   	srp.marshall("Salas.xml");
 				App.setRoot("MenuPrincipal");
 		   }
 	   }
	}
}
