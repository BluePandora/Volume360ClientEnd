package com.project.volume360.application;

import com.project.volume360.application.item.Admin;
import com.project.volume360.screen.LogInScreen;
import com.project.volume360.screen.annotation.FXMLLocation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application implements ApplicationListener {

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
		FXMLLocation fxmlLocation = LogInScreen.class
				.getAnnotation(FXMLLocation.class);
		System.out.println(fxmlLocation.location());
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

	@Override
	public void changeScene(int tag) {
		switch (tag) {
		case LOG_IN_SCENE:
			break;
		case MAIN_SCENE:
			break;
		default:
			break;
		}
	}

	@Override
	public void savePersonDataToFile(Admin admin) {
		// TODO Auto-generated method stub

	}

	@Override
	public Admin loadPersonDataFromFile() {
		// TODO Auto-generated method stub
		return null;
	}

}
