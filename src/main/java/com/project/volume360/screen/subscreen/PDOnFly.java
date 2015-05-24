package com.project.volume360.screen.subscreen;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.project.volume360.screen.Screen;
import com.project.volume360.screen.annotation.FXMLLocation;
import com.project.volume360.screen.factory.ScreenFactory;

@FXMLLocation(location = "/fxml/PDOnFly.fxml")
public class PDOnFly extends Screen {

	private StackPane pdOnFlyHolder;

	@FXML
	private MenuItem closeMenuItem;
	@FXML
	private MenuButton pdOnflyMenu;

	public PDOnFly() {
	}

	public static PDOnFly getPDOnFly(Stage primaryStage) {
		ScreenFactory screenFactory = new ScreenFactory();
		PDOnFly pdOnFly = (PDOnFly) screenFactory.getScreen(primaryStage,
				PDOnFly.class);
		return pdOnFly;
	}

	public void setHolder(StackPane pdOnFlyHolder) {
		this.pdOnFlyHolder = pdOnFlyHolder;

	}

	private Object pdOnFlyMenuObserver(
			ObservableValue<? extends Boolean> observer, Boolean oldValue,
			Boolean newValue) {
		return null;
	}

	@FXML
	private void initialize() {
		pdOnflyMenu.focusedProperty().addListener(
				(observer, oldValue, newValue) -> pdOnFlyMenuObserver(observer,
						oldValue, newValue));

	}

	@FXML
	private void onMenuItemClicked(ActionEvent actionEvent) {
		MenuItem clickedMenuItem = (MenuItem) actionEvent.getSource();
		switch (clickedMenuItem.getId()) {
		case "closeMenuItem":
			pdOnFlyHolder.getChildren().remove(0);
			pdOnFlyHolder.setVisible(false);
			pdOnFlyHolder.getParent().setVisible(false);
			System.out.println("clicked");
			break;

		default:
			break;
		}
	}

	public StackPane getHolder() {
		return this.pdOnFlyHolder;

	}

}
