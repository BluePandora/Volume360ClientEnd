package com.project.volume360;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getResource("/fxml/MainScene.fxml"));
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setTitle("Volume360");
		primaryStage.setWidth(1280);
		primaryStage.setHeight(720);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback  in case the application can not be
	 * launched through deployment artifacts.
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
