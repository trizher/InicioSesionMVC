package dad.javafx.iniciosesion;

import java.util.LinkedHashMap;
import java.util.Map;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InicioSesionModel {
	
	private StringProperty usuario = new SimpleStringProperty();
	private StringProperty pass = new SimpleStringProperty();
	private Map<String, String> mapaUsuarioPass = new LinkedHashMap<String, String>();
	
	public final StringProperty usuarioProperty() {
		return this.usuario;
	}
	

	public final String getUsuario() {
		return this.usuarioProperty().get();
	}
	

	public final void setUsuario(final String usuario) {
		this.usuarioProperty().set(usuario);
	}
	

	public final StringProperty passProperty() {
		return this.pass;
	}
	

	public final String getPass() {
		return this.passProperty().get();
	}
	

	public final void setPass(final String pass) {
		this.passProperty().set(pass);
	}


	public Map<String, String> getMapaUsuarioPass() {
		return mapaUsuarioPass;
	}


	public void setMapaUsuarioPass(Map<String, String> mapaUsuarioPass) {
		this.mapaUsuarioPass = mapaUsuarioPass;
	}


}
