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
	public List<Point> getValidMoves () {
		
		throw new UnsupportedOperationException();
	}
	
	
	@Override
	public boolean isMoveValid (final Point target, final Piece[][] board) {
		
		throw new UnsupportedOperationException();
	}
	
}
