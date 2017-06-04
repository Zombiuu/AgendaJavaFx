package vista;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Persona;

public class controladorVistaPrincipal {

	private Main mainPrincipal;
	private controladorVistaEdicion vistaEdicion;
	private controladorVistaEdicion2 vistaEdicion2;
	

	public void setStagePrincipal(Stage ventana) {
		vistaEdicion2.setStagePrincipal(ventana);
	}

	public void closeWindow() {
		vistaEdicion2.closeWindow();
	}

	public boolean equals(Object obj) {
		return vistaEdicion2.equals(obj);
	}

	public int hashCode() {
		return vistaEdicion2.hashCode();
	}

	public void nuevaPersona() {
		vistaEdicion2.nuevaPersona();
	}

	public Main getPrincipalStage() {
		return vistaEdicion2.getPrincipalStage();
	}

	public void editarPersona() {
		vistaEdicion2.editarPersona();
	}



	@FXML
	private TableView<Persona> listAgenda;

	@FXML
	private TableColumn<Persona, String> Nombre;

	@FXML
	private TableColumn<Persona, String> Apellido;

	@FXML
	private TableColumn<Persona, String> Telefono;
	@FXML
	private ObservableList<Persona> data;
	@FXML
	private Button btnNuevo;
	@FXML
	private Button btnEditar;
	@FXML
	private Button btnBorrar;

	public void initialize() {
		data = FXCollections.observableArrayList();
		
	}

	@FXML
	private void nuevaVentana() {
		
		this.mainPrincipal.mostrarVentanaEdicion();
	}
	
	@FXML
	private void nuevaVentanaEditar() {
		this.mainPrincipal.mostrarVentanaEdicion2();
		this.mainPrincipal.mostrarPersona();
	}
	@FXML
	private void borrarFila() {
		
		
		mainPrincipal.borrarFila();
		
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
	

	public void setVistaEdicion2(controladorVistaEdicion2 vistaEdicion2) {
		this.vistaEdicion2 = vistaEdicion2;
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
	
	public ObservableList<Persona> getData() {
		return data;
	}

	public void setData(ObservableList<Persona> data) {
		this.data = data;
	}
	public void setPrincipalStage(Main principalStage) {
		vistaEdicion2.setPrincipalStage(principalStage);
	}

	public void setVistaPrincipal(controladorVistaPrincipal vistaPrincipal) {
		vistaEdicion2.setVistaPrincipal(vistaPrincipal);
	}

	public TextField getTxtNombre() {
		return vistaEdicion2.getTxtNombre();
	}

	public void setTxtNombre(TextField txtNombre) {
		vistaEdicion2.setTxtNombre(txtNombre);
	}

	public TextField getTxtApellido() {
		return vistaEdicion2.getTxtApellido();
	}

	public void setTxtApellido(TextField txtApellido) {
		vistaEdicion2.setTxtApellido(txtApellido);
	}

	public TextField getTxtTelefono() {
		return vistaEdicion2.getTxtTelefono();
	}

	public void setTxtTelefono(TextField txtTelefono) {
		vistaEdicion2.setTxtTelefono(txtTelefono);
	}

	public String toString() {
		return vistaEdicion2.toString();
	}

}
