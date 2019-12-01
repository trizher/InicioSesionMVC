package dad.javafx.iniciosesion;

import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import dad.javafx.utils.LectorCSV;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InicioSesionController {

	private InicioSesionView view = new InicioSesionView();
	private InicioSesionModel model = new InicioSesionModel();
	private LectorCSV lector = new LectorCSV();
	
	public InicioSesionController() {
		view.getAccederButton().setOnAction(e -> onAccederAction());
		view.getCancelarButton().setOnAction(e -> onCancelarAction());
		
		model.usuarioProperty().bindBidirectional(view.getUsuarioText().textProperty());
		model.passProperty().bindBidirectional(view.getPassField().textProperty());
		try {
			model.setMapaUsuarioPass(lector.leerCSV());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void onCancelarAction() {
		Platform.exit();
	}

	private void onAccederAction() {
		String usuario = model.getUsuario();
		String pass = DigestUtils.md5Hex(model.getPass()).toUpperCase();
		
		boolean loginOk = lector.buscarValoresCSV(model.getMapaUsuarioPass(), usuario, pass);
		
		if(loginOk) {
			mostrarAlert("informacion", "Acceso permitido", "Las credenciales son válidas");
			Platform.exit();
		} else {
			mostrarAlert("error", "Acceso denegado", "El usuario y/o la contraseña no son válidos");
			model.setUsuario("");
			model.setPass("");
		}
		
	}

	public InicioSesionView getView() {
		return view;
	}
	
	private void mostrarAlert(String tipo, String titulo, String contenido) {
		Alert alert = null;
		if (tipo == "error"){
			alert = new Alert(AlertType.ERROR);
		} else if(tipo == "informacion") {
			alert = new Alert(AlertType.INFORMATION);
		}
		alert.setHeaderText(titulo);
		alert.setContentText(contenido);
		alert.showAndWait();
	}

}
