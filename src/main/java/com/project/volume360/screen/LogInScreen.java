package com.project.volume360.screen;

import com.project.volume360.ProgressIndicator;
import com.project.volume360.screen.annotation.FXMLLocation;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Arc;

@FXMLLocation(location = "/fxml/LogInScene.fxml")
public class LogInScreen extends Screen {

	@FXML
	private TextField userNameTextField;
	@FXML
	private TextField passwordTextField;
	@FXML
	private Button signInButton;

	@FXML
	private Arc rectBasicTimeline;

	public LogInScreen() {
		System.err.println(this);
	}

	@FXML
	private void handleSignIn(ActionEvent actionEvent) {
		System.out.println("ok");

	}

	@FXML
	public void initialize() {
		ProgressIndicator transition = new ProgressIndicator(rectBasicTimeline);
		transition.setCycleCount(Animation.INDEFINITE);
		transition.setInterpolator(Interpolator.LINEAR);
		transition.play();
	}

}