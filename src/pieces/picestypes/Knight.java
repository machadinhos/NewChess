package pieces.picestypes;

import pieces.Piece;

import java.awt.*;
import java.util.List;

public class Knight extends Piece {

	public Knight (final int col, final int row) {
		super(col, row);
	}

	@Override
	public void move() {

	}

	@Override
	public List<Point> getValidMoves() {
		return null;
	}

	@Override
	public boolean checkValidMove() {
		return false;
	}
}
