package com.project.volume360.application.control;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.project.volume360.application.item.SlidingMenuItem;
import com.project.volume360.screen.annotation.FXMLLocation;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

@FXMLLocation(location = "/fxml/SlidingMenuCell.fxml")
public class SlidingMenuListCell extends ListCell<SlidingMenuItem> {

	@FXML
	private Label itemText;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private ImageView slidingListIcon;

	@FXML
	private Pane dividerPane;

	public SlidingMenuListCell() {
	}

	public static SlidingMenuListCell getSlidingMenuListCell() {
		FXMLLoader fxmlLoader = new FXMLLoader();
		FXMLLocation fxmlLocation = SlidingMenuListCell.class
				.getAnnotation(FXMLLocation.class);
		fxmlLoader.setLocation(SlidingMenuListCell.class
				.getResource(fxmlLocation.location()));
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SlidingMenuListCell slidingMenuListCell = (SlidingMenuListCell) fxmlLoader
				.getController();
		// slidingMenuListCell.setPrefHeight(75);
		return slidingMenuListCell;
	}

	@FXML
	private void initialize() {
		focusedProperty().addListener(
				(observer, oldValue, newValue) -> searchFieldObserver(observer,
						oldValue, newValue));
	}

	private void searchFieldObserver(
			ObservableValue<? extends Boolean> observer, Boolean oldValue,
			Boolean newValue) {
		if (!newValue) {
			itemText.setStyle("-fx-text-fill: #123456;");
		} else {
			if (getItem().getTextColor() != null)
				itemText.setStyle("-fx-text-fill: " + getItem().getTextColor()
						+ ";");
		}
	}

	@Override
	public void updateItem(SlidingMenuItem item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null) {
			setBorder(null);
			setText(null);
			setPrefHeight(0);
			setGraphic(null);
		} else {
			setPrefHeight(rootPane.getPrefHeight());
			System.out.println(getHeight());
			itemText.setText(item.getTitle());
			setGraphic(rootPane);
			if (item.getIcon() != null) {
				InputStream inputStream = SlidingMenuItem.class
						.getResourceAsStream("/images/" + item.getIcon());
				Image image = new Image(inputStream);
				slidingListIcon.setImage(image);
			}
			if (item.hasDivider()) {
				dividerPane.setVisible(true);
			} else {
				dividerPane.setVisible(false);
			}
		}
	}
}