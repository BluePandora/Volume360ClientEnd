package com.project.volume360.screen.factory;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import com.project.volume360.screen.Screen;
import com.project.volume360.screen.annotation.FXMLLocation;

public class ScreenFactory {
	private FXMLLocation fxmlLocation;

	public Screen getScreen(Stage primaryStage, Class<?> object) {
		FXMLLoader fxmlLoader = getFxmlLoader(object);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getScreen(fxmlLoader, rootPane, primaryStage);
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

	private FXMLLoader getFxmlLoader(Class<?> object) {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLocation = object.getAnnotation(FXMLLocation.class);
		fxmlLoader.setLocation(getClass().getResource(fxmlLocation.location()));
		return fxmlLoader;
	}
}
