package com.project.volume360;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource(
				"/fxml/LogInScene.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("JavaFX and Maven");
		stage.setWidth(1280);
		stage.setHeight(720);
		stage.setScene(scene);

		stage.show();
	}

	/**
	 * The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback in case the application can not be
	 * launched through deployment artifacts.
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
