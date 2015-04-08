package com.project.volume360.screen.factory;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import com.project.volume360.screen.LogInScreen;
import com.project.volume360.screen.Screen;
import com.project.volume360.screen.annotation.FXMLLocation;

public class ScreenFactory {
	private FXMLLocation fxmlLocation;

	public LogInScreen getLogInScreen(Stage primaryStage) {
		FXMLLoader fxmlLoader = getFxmlLoader(LogInScreen.class);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LogInScreen logInScreen = (LogInScreen) getScreen(fxmlLoader, rootPane,
				primaryStage);
		return logInScreen;
	}

	private Screen getScreen(FXMLLoader fxmlLoader, AnchorPane rootPane,
			Stage primaryStage) {
		Screen screen = fxmlLoader.getController();
		Scene scene = new Scene(rootPane);
		screen.setRootPane(rootPane);
		screen.setPrimaryStage(primaryStage);
		screen.setScene(scene);
		return screen;
	}

	private FXMLLoader getFxmlLoader(Class<?> class1) {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLocation = class1.getAnnotation(FXMLLocation.class);
		System.out.println(fxmlLocation.location());
		fxmlLoader.setLocation(getClass().getResource(fxmlLocation.location()));
		return fxmlLoader;
	}
}
