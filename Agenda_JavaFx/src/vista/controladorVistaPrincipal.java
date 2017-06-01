package vista;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Persona;

public class controladorVistaPrincipal {

	private Main mainPrincipal;
	private controladorVistaEdicion vistaEdicion;

	@FXML
	private TableView<Persona> listAgenda;

	@FXML
	private TableColumn<Persona, String> Nombre;

	@FXML
	private TableColumn<Persona, String> Apellido;

	@FXML
	private TableColumn<Persona, String> Telefono;

	@FXML
	private Button btnNuevo;
	@FXML
	private Button btnEditar;
	@FXML
	private Button btnBorrar;

	public void initialize() {

	}

	@FXML
	private void nuevaVentana() {
		this.mainPrincipal.mostrarVentanaEdicion();
	}

	@FXML
	private void borrarFila() {

		Persona selectedItem = listAgenda.getSelectionModel().getSelectedItem();
		listAgenda.getItems().remove(selectedItem);

	}

	public TableView<Persona> getListAgenda() {
		return listAgenda;
	}

	public void setListAgenda(TableView<Persona> listAgenda) {
		this.listAgenda = listAgenda;
	}

	public void setProgramaPrincipal(Main ProgramaPrincipal) {
		this.mainPrincipal = ProgramaPrincipal;
	}

	public void setVistaEdicion(controladorVistaEdicion vistaEdicion) {
		this.vistaEdicion = vistaEdicion;
	}

	public TableColumn<Persona, String> getNombre() {
		return Nombre;
	}

	public void setNombre(TableColumn<Persona, String> nombre) {
		Nombre = nombre;
	}

	public TableColumn<Persona, String> getApellido() {
		return Apellido;
	}

	public void setApellido(TableColumn<Persona, String> apellido) {
		Apellido = apellido;
	}

	public TableColumn<Persona, String> getTelefono() {
		return Telefono;
	}

	public void setTelefono(TableColumn<Persona, String> telefono) {
		Telefono = telefono;
	}

}