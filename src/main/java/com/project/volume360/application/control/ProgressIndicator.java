package com.project.volume360.application.control;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class ProgressIndicator extends Transition {

	private Arc arc;

	private final int barLength = 15;
	private final int barMaxLength = 270;

	private double timeStartGrowing = 0;
	private double barSpinCycleTime = 460;
	private float barExtraLength = 0;
	private boolean barGrowingFromFront = true;

	private long pausedTimeWithoutGrowing = 0;
	private final long pauseGrowingTime = 200;

	// Animation
	// The amount of degrees per second
	private float spinSpeed = 120.f;
	// private float spinSpeed = 120.0f;
	// The last time the spinner was animated
	private long lastTimeAnimated = 0;

	private float mProgress = 0.0f;

	public ProgressIndicator(Arc arc) {
		this.arc = arc;
		setCycleDuration(Duration.INDEFINITE);
		setInterpolator(Interpolator.LINEAR);
	}

	private void updateBarLength(long deltaTimeInMilliSeconds) {
		if (pausedTimeWithoutGrowing >= pauseGrowingTime) {
			timeStartGrowing += deltaTimeInMilliSeconds;

			if (timeStartGrowing > barSpinCycleTime) {
				// We completed a size change cycle
				// (growing or shrinking)
				timeStartGrowing -= barSpinCycleTime;
				// if(barGrowingFromFront) {
				pausedTimeWithoutGrowing = 0;
				// }
				barGrowingFromFront = !barGrowingFromFront;
			}

			float distance = (float) Math.cos((timeStartGrowing
					/ barSpinCycleTime + 1)
					* Math.PI) / 2 + 0.5f;
			float destLength = (barMaxLength - barLength);

			if (barGrowingFromFront) {
				barExtraLength = distance * destLength;
			} else {
				float newLength = destLength * (1 - distance);
				mProgress += (barExtraLength - newLength);
				barExtraLength = newLength;
			}
		} else {
			pausedTimeWithoutGrowing += deltaTimeInMilliSeconds / 2;
		}
	}

	@Override
	protected void interpolate(double frac) {
		long deltaTime = (System.currentTimeMillis() - lastTimeAnimated);
		updateBarLength(deltaTime);
		// long deltaUpdateTime = (long) (deltaTime * spinSpeed);
		mProgress += 5.5;
		if (mProgress > 360) {
			mProgress -= 360f;
		}
		lastTimeAnimated = System.currentTimeMillis();

		float from = mProgress;
		float length = barLength + barExtraLength;
		// System.out.println(mProgress);
		arc.lengthProperty().set(length);
		arc.startAngleProperty().set(from);
		// arc.rotateProperty().set(rotate);
	}
}
