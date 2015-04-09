package com.project.volume360.application;

import com.project.volume360.application.item.Admin;
import com.project.volume360.screen.LogInScreen;
import com.project.volume360.screen.MainScreen;
import com.project.volume360.screen.factory.ScreenFactory;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application implements ApplicationListener {

	ScreenFactory screenFactory;
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		screenFactory = new ScreenFactory();
		primaryStage.setTitle("Volume360");
		primaryStage.setWidth(1286);
		primaryStage.setHeight(745);
		primaryStage.setResizable(false);
		this.primaryStage = primaryStage;
		changeScene(LOG_IN_SCENE);
		primaryStage.show();
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
			LogInScreen logInScreen = (LogInScreen) screenFactory.getScreen(
					primaryStage, LogInScreen.class);
			logInScreen.setApplicationListener(this);
			primaryStage.setScene(logInScreen.getScene());
			break;
		case MAIN_SCENE:
			MainScreen mainScreen = (MainScreen) screenFactory.getScreen(
					primaryStage, MainScreen.class);
			mainScreen.setApplicationListener(this);
			primaryStage.setScene(mainScreen.getScene());
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
