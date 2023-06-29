package pieces.picestypes;

import pieces.Piece;
import pieces.Team;

import java.awt.*;
import java.util.List;

public class Knight extends Piece {
	
	public Knight (final Team team, final int col, final int row) {
		
		super(team, col, row);
	}
	
	
	@Override
	public List<Point> getValidMoves () {
		
		return null;
	}
	
	
	@Override
	public boolean checkValidMove (Point target, Piece[][] board) {
		
		return false;
	}
	
}
