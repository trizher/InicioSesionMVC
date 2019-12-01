package dad.javafx.iniciosesion;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class InicioSesionView extends VBox {

	private Label usuarioLabel, passLabel;
	private TextField usuarioText;
	private PasswordField passField;
	private Button accederButton, cancelarButton;

	public InicioSesionView() {
		super();

		usuarioLabel = new Label("Usuario:");
		passLabel = new Label("Contraseña:");
		usuarioText = new TextField();
		passField = new PasswordField();
		accederButton = new Button("Acceder");
		cancelarButton = new Button("Cancelar");

		GridPane datosGrid = new GridPane();
		datosGrid.setPadding(new Insets(20, 10, 20, 10));
		
		datosGrid.setVgap(5);
		datosGrid.setHgap(5);
		datosGrid.addRow(0, usuarioLabel, usuarioText); 
		datosGrid.addRow(1, passLabel, passField);
	   
	    ColumnConstraints [] cols = {
				new ColumnConstraints(),
				new ColumnConstraints(),
		};
	    datosGrid.getColumnConstraints().setAll(cols);
	    
		cols[0].setHgrow(Priority.ALWAYS);
		cols[1].setHgrow(Priority.ALWAYS);
		

		HBox botoneraBox = new HBox();
		botoneraBox.getChildren().addAll(accederButton, cancelarButton);
		botoneraBox.setSpacing(10);
		botoneraBox.setAlignment(Pos.CENTER);
	
		getChildren().addAll(datosGrid, botoneraBox);
	}

	public Label getUsuarioLabel() {
		return usuarioLabel;
	}

	public void setUsuarioLabel(Label usuarioLabel) {
		this.usuarioLabel = usuarioLabel;
	}

	public Label getPassLabel() {
		return passLabel;
	}

	public void setPassLabel(Label passLabel) {
		this.passLabel = passLabel;
	}

	public TextField getUsuarioText() {
		return usuarioText;
	}

	public void setUsuarioText(TextField usuarioText) {
		this.usuarioText = usuarioText;
	}

	public PasswordField getPassField() {
		return passField;
	}

	public void setPassField(PasswordField passField) {
		this.passField = passField;
	}

	public Button getAccederButton() {
		return accederButton;
	}

	public void setAccederButton(Button accederButton) {
		this.accederButton = accederButton;
	}

	public Button getCancelarButton() {
		return cancelarButton;
	}

	public void setCancelarButton(Button cancelarButton) {
		this.cancelarButton = cancelarButton;
	}
	
	
}
