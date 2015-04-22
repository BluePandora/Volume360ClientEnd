package com.project.volume360.application.item;

import java.util.List;

public class SlideMenu {

	private List<SlidingMenuItem> slidingMenuItems;

	/**
	 * @param slidingMenuItems
	 */
	public SlideMenu(List<SlidingMenuItem> slidingMenuItems) {
		this.slidingMenuItems = slidingMenuItems;
	}

	/**
	 * @return the slidingMenuItems
	 */
	public List<SlidingMenuItem> getSlidingMenuItems() {
		return slidingMenuItems;
	}

	/**
	 * @param slidingMenuItems
	 *            the slidingMenuItems to set
	 */
	public void setSlidingMenuItems(List<SlidingMenuItem> slidingMenuItems) {
		this.slidingMenuItems = slidingMenuItems;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SlideMenu [slidingMenuItems=" + slidingMenuItems + "]";
	}

}
