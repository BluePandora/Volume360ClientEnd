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
	}

	@FXML
	private void handleSignIn(ActionEvent actionEvent) {

	}
}