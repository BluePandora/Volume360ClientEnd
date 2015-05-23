package com.project.volume360.screen.transition;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

public class MainScreenTransitions {

	TranslateTransition slideMenuTransition = new TranslateTransition(
			new Duration(500));

	private boolean slideMenuOpened = false;
	private boolean searchPaneOpened = false;
	private Node transitionNode;

	public MainScreenTransitions(Node transitionNode) {
		this.transitionNode = transitionNode;
		slideMenuTransition.setNode(transitionNode);
	}

	public void slidingMenuTransition() {
		if (!slideMenuOpened) {
			slideMenuTransition.setFromX(0);
			slideMenuTransition.setToX(270);
			slideMenuTransition.setInterpolator(Interpolator.EASE_BOTH);
			slideMenuTransition.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					slideMenuOpened = true;
					if (searchPaneOpened) {
						slidingMenuTransition();
					}

				}
			});
			slideMenuTransition.play();
		} else {
			slideMenuTransition.setFromX(270);
			slideMenuTransition.setToX(0);
			slideMenuTransition.setInterpolator(Interpolator.EASE_BOTH);
			slideMenuTransition.play();
			slideMenuTransition.setOnFinished(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					slideMenuOpened = false;
				}
			});
		}
	}

	/**
	 * @return the slideMenuOpened
	 */
	public boolean isSlideMenuOpened() {
		return slideMenuOpened;
	}

	/**
	 * @param slideMenuOpened
	 *            the slideMenuOpened to set
	 */
	public void setSlideMenuOpened(boolean slideMenuOpened) {
		this.slideMenuOpened = slideMenuOpened;
	}

	/**
	 * @return the searchPaneOpened
	 */
	public boolean isSearchPaneOpened() {
		return searchPaneOpened;
	}

	/**
	 * @param searchPaneOpened
	 *            the searchPaneOpened to set
	 */
	public void setSearchPaneOpened(boolean searchPaneOpened) {
		this.searchPaneOpened = searchPaneOpened;
	}

}
