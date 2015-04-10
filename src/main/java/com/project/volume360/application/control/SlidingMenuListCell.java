package com.project.volume360.application.control;

import java.io.IOException;

import com.project.volume360.screen.annotation.FXMLLocation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

@FXMLLocation(location = "/fxml/SlidingMenuCell.fxml")
public class SlidingMenuListCell extends ListCell<String> {

	@FXML
	private Label itemText;

	@FXML
	private AnchorPane rootPane;

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
		return slidingMenuListCell;
	}

	@Override
	public void updateItem(String item, boolean empty) {
		super.updateItem(item, empty);
		if (item != null) {
			itemText.setText(item);
			setGraphic(rootPane);
		}
	}
}

// com.project.volume360.application.control.SlidingMenuListCell
