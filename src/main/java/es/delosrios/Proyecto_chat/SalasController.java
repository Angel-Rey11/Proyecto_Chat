package es.delosrios.Proyecto_chat;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import es.delosrios.Proyecto_chat.model.Dao.RepoSala;
import es.delosrios.Proyecto_chat.model.DataObject.Sala;
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
	
	
	RepoSala rp = new RepoSala();
	
	private List<Sala> misSalas = (List<Sala>) rp.unmarshall("Salas.xml");
	private final ObservableList<Sala> data = FXCollections.observableArrayList(misSalas);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rp.unmarshall("Salas.xml");
		this.configureTabla();
		table.setItems(FXCollections.observableArrayList(misSalas));
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
