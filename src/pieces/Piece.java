package pieces;

import java.awt.*;
import java.util.List;

public abstract class Piece {

	private final Point position;
	
	
	public Piece (final int x, final int y) {
		
		this.position = new Point(x, y);
	}
	
	
	public Point getPosition () {
		return position;
	}
	
	public void setPosition(final int x, final int y) {
		this.position.setLocation(x, y);
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
