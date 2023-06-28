package pieces;

import java.awt.*;
import java.util.List;

public abstract class Piece {

	private final Point position;
	
	
	protected Piece (final int column, final int row) {
		this.position = new Point(column, row);
	}

	public Point getPosition () {
		return position;
	}
	
	public void setPosition(final int x, final int y) {
		this.position.setLocation(x, y);
	}

	public int getCol() {
		return (int) position.getX();
	}

	public int getRow() {
		return (int) position.getY();
	}

	public abstract void move();
	public abstract List<Point> getValidMoves();
	public abstract boolean checkValidMove();

}
