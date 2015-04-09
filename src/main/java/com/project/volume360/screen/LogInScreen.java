package com.project.volume360.screen;

import com.project.volume360.screen.annotation.FXMLLocation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

@FXMLLocation(location = "/fxml/LogInScene.fxml")
public class LogInScreen extends Screen {

	@FXML
	private TextField userNameTextField;
	@FXML
	private TextField passwordTextField;
	@FXML
	private Button signInButton;

	public LogInScreen() {
		System.err.println(this);
	}

	@FXML
	private void handleSignIn(ActionEvent actionEvent) {
		System.out.println("ok");
		getApplicationListener().changeScene(1);

	}

	@FXML
	public void initialize() {
		// ProgressIndicator transition = new
		// ProgressIndicator(rectBasicTimeline);
		// transition.setCycleCount(Animation.INDEFINITE);
		// transition.setInterpolator(Interpolator.LINEAR);
		// transition.play();
	}

}