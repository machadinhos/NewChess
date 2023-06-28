package pieces.picestypes;

import pieces.Piece;

import java.awt.*;
import java.util.List;

public class Pawn extends Piece {

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
