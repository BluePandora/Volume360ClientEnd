package com.project.volume360.application.item;

public class SlidingMenuItem {

	private String icon;
	private String title;
	private String textColor;
	private boolean divider;

	/**
	 * @param icon
	 * @param title
	 * @param divider
	 */
	public SlidingMenuItem(String icon, String title, String textColor,
			boolean divider) {
		this.icon = icon;
		this.title = title;
		this.divider = divider;
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

	/**
	 * @return the divider
	 */
	public boolean hasDivider() {
		return divider;
	}

	/**
	 * @param divider
	 *            the divider to set
	 */
	public void setDivider(boolean divider) {
		this.divider = divider;
	}

	/**
	 * @return the textColor
	 */
	public String getTextColor() {
		return textColor;
	}

	/**
	 * @param textColor
	 *            the textColor to set
	 */
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SlidingMenuItem [icon=" + icon + ", title=" + title
				+ ", textColor=" + textColor + ", divider=" + divider + "]";
	}

}
