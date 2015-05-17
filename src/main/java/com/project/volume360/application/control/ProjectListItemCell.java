package com.project.volume360.application.control;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import com.project.volume360.application.item.ProjectListItem;
import com.project.volume360.screen.annotation.FXMLLocation;

@FXMLLocation(location = "/fxml/ProjectListItemCell.fxml")
public class ProjectListItemCell extends ListCell<ProjectListItem> {

	@FXML
	private AnchorPane rootPane;

	@FXML
	private ImageView creatorAvatar;

	public ProjectListItemCell() {

	}

	public static ProjectListItemCell getProjectListCell() {
		FXMLLoader fxmlLoader = new FXMLLoader();
		FXMLLocation fxmlLocation = ProjectListItemCell.class
				.getAnnotation(FXMLLocation.class);
		fxmlLoader.setLocation(ProjectListItemCell.class
				.getResource(fxmlLocation.location()));
		try {
			fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ProjectListItemCell projectListItemCell = (ProjectListItemCell) fxmlLoader
				.getController();
		return projectListItemCell;
	}

	@Override
	protected void updateItem(ProjectListItem item, boolean empty) {
		// TODO Auto-generated method stub
		if (item != null) {
			setGraphic(rootPane);
			createAvatar();
		}
		super.updateItem(item, empty);
	}

	private void createAvatar() {
		final Circle clip = new Circle();
		clip.setRadius(creatorAvatar.getLayoutBounds().getWidth() / 2);
		clip.setTranslateX(creatorAvatar.getLayoutBounds().getWidth() / 2);
		clip.setTranslateY(creatorAvatar.getLayoutBounds().getWidth() / 2);
		creatorAvatar.setClip(clip);
	}
}
