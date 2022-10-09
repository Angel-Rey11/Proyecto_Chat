package es.delosrios.Proyecto_chat;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import org.xml.sax.XMLReader;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;
import es.delosrios.Proyecto_chat.utils.DataService;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SalasController implements Initializable{
	
	
	@FXML
	private TableView<Sala> table;
	@FXML
	private TableColumn<Sala, String> nombre;
	@FXML
	private TableColumn<Sala, String> desc;
	@FXML
	private TableColumn<Sala, Integer> nUsuarios;
	@FXML
	private TextField search;
	@FXML
	private Label user;
	
	
	RepoSala rp = new RepoSala();
	Sala s = new Sala();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Sala> misSalas = (List<Sala>) rp.unmarshall("Salas.xml");
		ObservableList<Sala> data = FXCollections.observableArrayList(misSalas);
		XMLReader.class.getResourceAsStream("Salas.xml");
		XMLReader.class.getResourceAsStream("Usuarios.xml");
		rp.unmarshall("Salas.xml");
		user.setText(DataService.user.getNickName());
		this.configureTabla();
		table.setItems(FXCollections.observableArrayList(data));
		FilteredList<Sala> filteredData = new FilteredList<>(data, e -> true);
		search.setOnKeyReleased(e -> {
			search.textProperty().addListener((observableValue, oldValue, newValue) -> {
				filteredData.setPredicate((Predicate<? super Sala>) sala-> {
					if(newValue == null || newValue.isEmpty()) {
						return true;
					}
					if (sala.getNombre().contains(newValue)) {
						return true;
					}
					return false;
				});
			});
			SortedList<Sala> sortedData = new SortedList<>(filteredData);
			sortedData.comparatorProperty().bind(table.comparatorProperty());
			table.setItems(sortedData);
		});
		
	}
	
	@FXML
	public void selectSala() throws IOException {
		Sala s = this.table.getSelectionModel().getSelectedItem();
		DataService.sala = s;
		if(!s.checkUser(DataService.user)) {
			rp.initArray(rp.searchSala(s),DataService.user);
			DataService.sala = rp.searchSala(s);
			rp.marshall("Salas.xml");
			App.setRoot("Chat");
		} else {
			DataService.sala = rp.searchSala(s);
			rp.marshall("Salas.xml");
			App.setRoot("Chat");
		}
		
	}
	
	private void configureTabla() {
		nombre.setCellValueFactory(sala -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(sala.getValue().getNombre());
			return ssp;
		});
		desc.setCellValueFactory(sala -> {
			SimpleStringProperty ssp = new SimpleStringProperty();
			ssp.setValue(sala.getValue().getDescr());
			return ssp;
		});
		nUsuarios.setCellValueFactory(sala -> {
			Integer nUsuarios = sala.getValue().getAllUsers().size();
			ObservableValue<Integer> ov = new SimpleIntegerProperty().asObject();
			((ObjectProperty<Integer>) ov).setValue(nUsuarios);
			return ov;
		});
	}
	
	@FXML
    private void switchToMenuPrincipal() throws IOException {
    	App.setRoot("MenuPrincipal");
    }
	
	@FXML
	private void switchToChat() throws IOException {
		App.setRoot("Chat");
	}

}
