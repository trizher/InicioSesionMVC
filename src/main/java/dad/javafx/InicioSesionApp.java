package dad.javafx;

import dad.javafx.iniciosesion.InicioSesionController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InicioSesionApp extends Application {
	
	private InicioSesionController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {

		controller = new InicioSesionController();
		Scene scene = new Scene(controller.getView(), 300, 125);
		primaryStage.setTitle("Inicio Sesión MVC");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}

}
