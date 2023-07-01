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
	public List<Point> getValidMoves (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		return null;
	}
	
	
	@Override
	public boolean isMoveValid (final int col, final int row, final Piece[][] board) {
		
		boolean valid = false;
		
		if (Math.abs(super.getCol() - col) == 2 && Math.abs(super.getRow() - row) == 1) {
			
			valid = true;
		} else if (Math.abs(super.getCol() - col) == 1 && Math.abs(super.getRow() - row) == 2) {
			
			valid = true;
		}
		
		if (valid) {
			
			return board[row][col] == null || board[row][col].getTeam() != super.getTeam();
		}
		
		return false;
	}
	
}
