package com.project.volume360.screen;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import com.project.volume360.application.item.NewProject;
import com.project.volume360.screen.annotation.FXMLLocation;

@FXMLLocation(location = "/fxml/NewProject.fxml")
public class NewProjectWindow extends Screen {

	private AddNewProjectListener addNewProjectListener;

	@FXML
	private Label workOrderLabel;

	public NewProjectWindow() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the addNewProjectListener
	 */
	public AddNewProjectListener getAddNewProjectListener() {
		return addNewProjectListener;
	}

	/**
	 * @param addNewProjectListener
	 *            the addNewProjectListener to set
	 */
	public void setAddNewProjectListener(
			AddNewProjectListener addNewProjectListener) {
		this.addNewProjectListener = addNewProjectListener;
	}

	public interface AddNewProjectListener {
		public void addNewProject(NewProject newProject);
	}

	@FXML
	private void fileChooser() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Work Order");
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"image files (*.jpg,*.jpeg,*.png)", "*.jpg", "*.jpeg", "*.png");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(new Stage());
		if (file != null) {
			workOrderLabel.setText(file.getName());
		}

	}
}
