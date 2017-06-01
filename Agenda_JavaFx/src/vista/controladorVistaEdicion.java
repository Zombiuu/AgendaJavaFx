package vista;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Persona;

public class controladorVistaEdicion {
	
	
	private Main principalStage;
	private controladorVistaPrincipal vistaPrincipal;
	private Stage ventana;
	@FXML
	private Button btnAceptar;
	@FXML
	private Button btnCancelar;

	@FXML
	private TextField txtNombre;
	
	@FXML
	private TextField txtApellido;
	@FXML
	private TextField txtTelefono;
	
	private String nombre,apellido,telefono;
	
	private ObservableList<Persona> data;
	
	public void setStagePrincipal(Stage ventana) {
		// TODO Auto-generated method stub
		this.ventana = ventana;
	}
	
	public void closeWindow(){
		this.ventana.close();
	}
	
	public void nuevaPersona(){
				if(data == null)
				data = FXCollections.observableArrayList();
				
				data.add(new Persona(txtNombre.getText(),txtApellido.getText(),txtTelefono.getText()));
				vistaPrincipal.getListAgenda().setItems(data);
				vistaPrincipal.getNombre().setCellValueFactory(new PropertyValueFactory<Persona,String>("Nombre"));
				vistaPrincipal.getApellido().setCellValueFactory(new PropertyValueFactory<Persona,String>("Apellido"));
				vistaPrincipal.getTelefono().setCellValueFactory(new PropertyValueFactory<Persona,String>("Telefono"));
			
			
		
		
		
	//	vistaPrincipal.setData(data);
			//Persona persona = new  Persona
			
		
	}

	public void setVistaPrincipal(controladorVistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}

	
	
}
