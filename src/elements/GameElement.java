package elements;

import java.awt.*;

public abstract class GameElement {

	private final Point position;

	public GameElement(final int col, final int row) {
		this.position = new Point(col, row);
	}


	public Point getPosition () {
		return position;
	}

	public abstract Image getImage();
}
