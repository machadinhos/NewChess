package pieces.picestypes;

import pieces.Piece;
import pieces.Team;

import java.awt.*;
import java.util.List;

public class Pawn extends Piece {
	
	public Pawn (final Team team, final int col, final int row) {
		
		super(team, col, row);
	}
	
	
	@Override
	public List<Point> getValidMoves () {
		
		return null;
	}
	
	
	@Override
	public boolean isMoveValid (final Point target, final Piece[][] board) {
		
		return false;
	}
	
}
