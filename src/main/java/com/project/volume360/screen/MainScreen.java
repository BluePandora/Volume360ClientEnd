package com.project.volume360.screen;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;

import com.project.volume360.application.control.SlidingMenuListCell;
import com.project.volume360.screen.annotation.FXMLLocation;

@FXMLLocation(location = "/fxml/MainScene.fxml")
public class MainScreen extends Screen {

	@FXML
	private ImageView imageView;
	@FXML
	private ImageView searchImage;

	@FXML
	private Button menuButton;

	@FXML
	private TextField searchField;

	@FXML
	private ListView<String> slidingMenu;

	@FXML
	private Pane actionBar;

	@FXML
	private Pane slidingMenuPane;
	private boolean slideMenuOpened = false;
	private boolean searchPaneOpened = false;
	TranslateTransition transition = new TranslateTransition(new Duration(500));

	ObservableList<String> data = FXCollections
			.observableArrayList("chocolate", "salmon", "chocolate", "salmon",
					"chocolate", "salmon");

	public MainScreen() {
	}

	@FXML
	public void initialize() {

		final Circle clip = new Circle();
		clip.setRadius(imageView.getLayoutBounds().getWidth() / 2);
		clip.setTranslateX(imageView.getLayoutBounds().getWidth() / 2);
		clip.setTranslateY(imageView.getLayoutBounds().getWidth() / 2);
		slidingMenu.setItems(data);
		slidingMenu.getSelectionModel().selectFirst();
		slidingMenu
				.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
					@Override
					public ListCell<String> call(ListView<String> list) {
						return SlidingMenuListCell.getSlidingMenuListCell();
					}
				});
		slidingMenu.setPrefHeight(66.8 * data.size());
		InputStream inputStream = getClass().getResourceAsStream(
				"/raw/slidingmenuitems.json");
		byte[] b = new byte[1024];
		try {
			inputStream.read(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String string = new String(b);
		System.out.println(string);
		imageView.setClip(clip);
		searchField.focusedProperty().addListener(
				(observer, oldValue, newValue) -> searchFieldObserver(observer,
						oldValue, newValue));
	}

	private Object searchFieldObserver(
			ObservableValue<? extends Boolean> observer, Boolean oldValue,
			Boolean newValue) {
		searchPaneOpened = newValue;
		if (newValue) {
			File file = new File(System.getProperty("user.dir")
					+ "/src/main/resources/images/ic_search_black_18dp.png");
			Image image = new Image(file.toURI().toString());
			searchImage.setImage(image);
			actionBar.setStyle("-fx-background-color: #BCBCBC;");
			menuButton.getStyleClass().add("menu-button-second");
			menuButton.getStyleClass().remove(1);
			if (slideMenuOpened)
				slidingMenuTransition();
		} else {
			File file = new File(System.getProperty("user.dir")
					+ "/src/main/resources/images/ic_search_white_18dp.png");
			Image image = new Image(file.toURI().toString());
			searchImage.setImage(image);
			menuButton.getStyleClass().add("menu-button");
			menuButton.getStyleClass().remove(1);
			actionBar.setStyle("-fx-background-color: #F26D21;");
		}
		return null;
	}

	@FXML
	public void onHover(MouseEvent mouseEvent) {
		System.out.println("ok");
	}

	@FXML
	public void onClick(ActionEvent actionEvent) {
		System.out.println("ok");
	}

	@FXML
	public void onClickImage(MouseEvent mouseEvent) {
		System.out.println("ok");
	}

	@FXML
	public void onMenuPressed(ActionEvent actionEvent) {
		System.out.println(getPrimaryStage().getWidth() + " "
				+ getPrimaryStage().getHeight());
		System.out.println(searchPaneOpened);
		if (!searchPaneOpened)
			slidingMenuTransition();
	}

	private void slidingMenuTransition() {
		transition.setNode(slidingMenuPane);
		if (!slideMenuOpened) {
			transition.setFromX(0);
			transition.setToX(270);
			transition.setInterpolator(Interpolator.EASE_BOTH);
			transition.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					slideMenuOpened = true;
					if (searchPaneOpened) {
						slidingMenuTransition();
					}

				}
			});
			transition.play();
		} else {
			transition.setFromX(270);
			transition.setToX(0);
			transition.setInterpolator(Interpolator.EASE_BOTH);
			transition.play();
			transition.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					slideMenuOpened = false;
				}
			});
		}
	}
}
