package com.project.volume360.application;

import java.io.IOException;

import com.project.volume360.application.item.Admin;

public interface ApplicationListener {

	public static final int LOG_IN_SCENE = 0;
	public static final int MAIN_SCENE = 1;

	public void changeScene(int tag) throws IOException;

	public void savePersonDataToFile(Admin admin);

	public Admin loadPersonDataFromFile();

}
