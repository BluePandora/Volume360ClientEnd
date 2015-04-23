package com.project.volume360.screen;

import com.project.volume360.application.item.NewProject;
import com.project.volume360.screen.annotation.FXMLLocation;

@FXMLLocation(location = "/fxml/NewProject.fxml")
public class NewProjectWindow extends Screen {

	private AddNewProjectListener addNewProjectListener;

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
}
