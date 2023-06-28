package pieces;

import java.awt.*;
import java.util.List;

public abstract class Piece {

	private Point position;


	public Point getPosition() {
		return position;
	}

	public void setPosition(final Point position) {
		this.position = position;
	}

	public int getX() {
		return (int) position.getX();
	}

	public int getY() {
		return (int) position.getY();
	}

	public abstract void move();
	public abstract List<Point> getValidMoves();
	public abstract boolean checkValidMove();

}
