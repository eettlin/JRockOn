package gamesrc;

import java.awt.Image;
import java.awt.Point;

import jgame.Context;
import jgame.GObject;
import jgame.listener.FrameListener;

public class BulletThree extends Bullet {
	private Point startPosition = null;
	private Point currentPosition = null;
	
	public BulletThree(Image image, Point p) {
		super(image);
		startPosition = p;
		currentPosition = p;
		this.addListener(new FrameListener() {
			public void invoke(GObject target, Context context) {
				if (getDistanceFromStart() > 200) {
					target.removeSelf(); // ++++++++++++++++++++++++ Causing
											// Crash
				}
			}
		});
	}
	public void setStartPosition(Point p) {
		startPosition = p;
	}

	public Point getStartPosition1() {
		return startPosition;
	}

	public Point getCurrentPosition() {
		currentPosition.setLocation((int) this.getX(), (int) this.getY());
		return currentPosition;
	}

	public double getDistanceFromStart() {
		double dx = startPosition.getX() - getCurrentPosition().getX();
		double dy = startPosition.getY() - getCurrentPosition().getY();

		double d = Math.sqrt(dx * dx + dy * dy);
		System.out.println("d = " + d);
		return d;
	}

	public Point getStartPosition() {
		return startPosition;
	}

}
