package pieces.picestypes;

import pieces.Piece;
import pieces.Team;

import java.awt.*;
import java.util.List;

public class Bishop extends Piece {


	public Bishop (final Team team, final int col, final int row) {
		super(team, col, row);
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
	public boolean checkValidMove(Point target, Piece[][] board) {
		throw new UnsupportedOperationException();
	}
}
