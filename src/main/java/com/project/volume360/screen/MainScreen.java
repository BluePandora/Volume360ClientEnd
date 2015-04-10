package com.project.volume360.screen;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.SwingUtilities;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
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

import com.project.volume360.screen.annotation.FXMLLocation;

@FXMLLocation(location = "/fxml/MainScene.fxml")
public class MainScreen extends Screen {

	@FXML
	private ImageView imageView;
	@FXML
	private ImageView searchImage;

	@FXML
	private ImageView menuButton;

	@FXML
	private TextField searchField;

	@FXML
	private ListView<String> slidingMenu;

	@FXML
	private Pane actionBar;

	private boolean open = false;
	TranslateTransition transition = new TranslateTransition(new Duration(500));

	ObservableList<String> data = FXCollections.observableArrayList(
			"chocolate", "salmon", "gold", "coral", "darkorchid",
			"darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue",
			"blueviolet", "brown");

	public MainScreen() {
	}

	@FXML
	public void initialize() {
		final Circle clip = new Circle();
		clip.setRadius(imageView.getLayoutBounds().getWidth() / 2);
		clip.setTranslateX(imageView.getLayoutBounds().getWidth() / 2);
		clip.setTranslateY(imageView.getLayoutBounds().getWidth() / 2);
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				imageView
						.setImage(new Image(
								"https://fbcdn-sphotos-e-a.akamaihd.net/hphotos-ak-xpf1/v/t1.0-9/10891870_865266643525240_802936034075979196_n.jpg?oh=5ad890fbacc9b79a9d525db06f151456&oe=55B3652A&__gda__=1437970923_76a9ee79a373de16c834cee39ff1c8cc"));

			}
		});
		slidingMenu.setItems(data);
		slidingMenu
				.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
					@Override
					public ListCell<String> call(ListView<String> list) {
						return new ColorRectCell();
					}
				});
		InputStream inputStream = getClass().getResourceAsStream(
				"/raw/slidingmenuitems.json");
		byte[] b = new byte[1024];
		try {
			inputStream.read(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String string= new String(b);
		System.out.println(string);
		imageView.setClip(clip);
		searchField.focusedProperty().addListener(
				(observer, oldValue, newValue) -> searchFieldObserver(observer,
						oldValue, newValue));
	}

	private Object searchFieldObserver(
			ObservableValue<? extends Boolean> observer, Boolean oldValue,
			Boolean newValue) {
		if (newValue) {
			File file = new File(System.getProperty("user.dir")
					+ "/src/main/resources/images/ic_search_black_18dp.png");
			Image image = new Image(file.toURI().toString());
			searchImage.setImage(image);
			actionBar.setStyle("-fx-background-color: #BCBCBC;");

		} else {
			File file = new File(System.getProperty("user.dir")
					+ "/src/main/resources/images/ic_search_white_18dp.png");
			Image image = new Image(file.toURI().toString());
			searchImage.setImage(image);
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
	public void onMenuPressed(MouseEvent mouseEvent) {
		System.out.println(getPrimaryStage().getWidth() + " "
				+ getPrimaryStage().getHeight());
		menuButton.requestFocus();
		transition.setNode(slidingMenu);
		if (!open) {
			transition.setFromX(0);
			transition.setToX(270);
			transition.setInterpolator(Interpolator.EASE_BOTH);
			transition.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					open = true;
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
					open = false;
				}
			});
		}
	}

	static class ColorRectCell extends ListCell<String> {
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			Rectangle rect = new Rectangle(100, 20);
			Text text = new Text(item);
			StackPane stackPane = new StackPane(rect, text);
			if (item != null) {
				rect.setFill(Color.web(item));
				setGraphic(stackPane);
			}
		}
	}
}
