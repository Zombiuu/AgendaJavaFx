package application;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modelo.Persona;
import vista.controladorVistaEdicion;
import vista.controladorVistaEdicion2;
import vista.controladorVistaPrincipal;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

	private static Stage stagePrincipal;
	private AnchorPane rootPane;
	private controladorVistaPrincipal controller;
	private controladorVistaEdicion controller2;
	private controladorVistaEdicion2 controller3;
	private int index;

	@Override
	public void start(Stage stagePrincipal) throws Exception {
		Main.stagePrincipal = stagePrincipal;
		mostrarVentanaPrincipal();

	}

	/*
	 * En un proyecto JavaFX el main llama al launch que a su vez llama a start
	 */
	public static void main(String[] args) {
		launch(args);

	}

	/*
	 * cargamos la ventana principal
	 */
	public void mostrarVentanaPrincipal() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/vistaPrincipal.fxml"));
			rootPane = (AnchorPane) loader.load();
			Scene scene = new Scene(rootPane);
			stagePrincipal.setTitle("Ventana Principal");
			stagePrincipal.setScene(scene);

			/*
			 * Añadidos las llamadas del main al Controlador y del controlador
			 * al main
			 ***/
			controller = loader.getController();
			controller.setProgramaPrincipal(this);
			controller.setVistaEdicion(controller2);
			controller.setVistaEdicion2(controller3);
			stagePrincipal.show();
		} catch (IOException e) {
			// tratar la excepción.
		}
	}

	/*
	 * Este método es llamado cuando se presiona el botón de la ventana
	 * principal Lo llama el controlador de la vista principal
	 */
	public void mostrarVentanaEdicion() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/vistaEdicion.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
			/* Creamos la segunda ventana como otro stage */
			Stage ventana = new Stage();
			ventana.setTitle("Venta Dos");
			/* Le decimos a la ventana quién es la ventana original */
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaDos);
			ventana.setScene(scene);

			controller2 = loader.getController();
			controller2.setStagePrincipal(ventana);
			controller2.setVistaPrincipal(controller);
			controller2.setPrincipalStage(this);
			ventana.show();

		} catch (Exception e) {
			// tratar la excepción
		}
	}

	public void mostrarVentanaEdicion2() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../vista/vistaEdicion2.fxml"));
			AnchorPane ventanaDos = (AnchorPane) loader.load();
			/* Creamos la segunda ventana como otro stage */
			Stage ventana = new Stage();
			ventana.setTitle("Venta Dos");
			/* Le decimos a la ventana quién es la ventana original */
			ventana.initOwner(stagePrincipal);
			Scene scene = new Scene(ventanaDos);
			ventana.setScene(scene);

			controller3 = loader.getController();
			controller3.setStagePrincipal(ventana);
			controller3.setVistaPrincipal(controller);
			controller3.setPrincipalStage(this);
			ventana.show();

		} catch (Exception e) {
			// tratar la excepción
		}
	}

	public void borrarFila() {
		Persona selectedItem = controller.getListAgenda().getSelectionModel().getSelectedItem();
		controller.getListAgenda().getItems().remove(selectedItem);

	}

	public void nuevaPersona() {
		controller.getData().add(new Persona(controller2.getTxtNombre().getText(),
				controller2.getTxtApellido().getText(), controller2.getTxtTelefono().getText()));
		controller.getListAgenda().setItems(controller.getData());
		controller.getNombre().setCellValueFactory(new PropertyValueFactory<Persona, String>("Nombre"));
		controller.getApellido().setCellValueFactory(new PropertyValueFactory<Persona, String>("Apellido"));
		controller.getTelefono().setCellValueFactory(new PropertyValueFactory<Persona, String>("Telefono"));

	}

	public void mostrarPersona() {
		Persona persona = controller.getListAgenda().getSelectionModel().getSelectedItem();
		if (persona != null) {
			controller3.getTxtNombre().setText(persona.getNombre());
			controller3.getTxtApellido().setText(persona.getApellido());
			controller3.getTxtTelefono().setText(persona.getTelefono());
		}

	}

	public void editarPersona() {
		index = controller.getListAgenda().getSelectionModel().getSelectedIndex();
		Persona persona = controller.getListAgenda().getSelectionModel().getSelectedItem();
		persona.setNombre(controller3.getTxtNombre().getText());
		persona.setApellido(controller3.getTxtApellido().getText());
		persona.setTelefono(controller3.getTxtTelefono().getText());
		controller.getData().set(index, persona);
	}
}
