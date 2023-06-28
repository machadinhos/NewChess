package pieces.picestypes;

import pieces.Piece;

import java.awt.*;
import java.util.List;

public class Bishop extends Piece {


	protected Bishop(final int col, final int row) {
		super(col, row);
	}

	@Override
	public void move() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Point> getValidMoves() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean checkValidMove() {
		throw new UnsupportedOperationException();
	}
}
