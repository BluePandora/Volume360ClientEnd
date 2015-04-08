package com.project.volume360;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class ProgressIndicator extends Transition {

	private Arc arc;

	// Sizes (with defaults in DP)
	private int circleRadius = 28;
	private int barWidth = 4;
	private int rimWidth = 4;

	private final int barLength = 16;
	private final int barMaxLength = 270;

	private boolean fillRadius = false;

	private double timeStartGrowing = 0;
	private double barSpinCycleTime = 460;
	private float barExtraLength = 0;
	private boolean barGrowingFromFront = true;

	private long pausedTimeWithoutGrowing = 0;
	private final long pauseGrowingTime = 200;

	// Animation
	// The amount of degrees per second
	private float spinSpeed = 0;
	// private float spinSpeed = 120.0f;
	// The last time the spinner was animated
	private long lastTimeAnimated = 0;

	private boolean linearProgress;

	private float mProgress = 0.0f;
	private float mTargetProgress = 0.0f;
	private boolean isSpinning = true;

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
			pausedTimeWithoutGrowing +=  deltaTimeInMilliSeconds;
		}
	}

	@Override
	protected void interpolate(double frac) {
		long deltaTime = (System.currentTimeMillis() - lastTimeAnimated);
		updateBarLength(deltaTime);
		mProgress += 5;
		if (mProgress > 360) {
			mProgress -= 360f;
		}
		lastTimeAnimated = System.currentTimeMillis();

		float from = mProgress - 90;
		float length = barLength + barExtraLength;
		System.out.println(mProgress);

		arc.lengthProperty().set(length);
		arc.startAngleProperty().set(from);
		// arc.rotateProperty().set(rotate);
	}
}
