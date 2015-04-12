package com.project.volume360.application.item;

public class SlidingMenuItem {

	private String icon;
	private String title;

	/**
	 * @param icon
	 * @param title
	 */
	public SlidingMenuItem(String icon, String title) {
		this.icon = icon;
		this.title = title;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SlidingMenuItem [icon=" + icon + ", title=" + title + "]";
	}

}
