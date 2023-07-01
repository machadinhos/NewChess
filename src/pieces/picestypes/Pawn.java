package pieces.picestypes;

import pieces.Piece;
import pieces.Team;

import java.awt.*;
import java.util.List;

public class Pawn extends Piece {
	
	private boolean hasNotMoved = true;
	
	
	public Pawn (final Team team, final int col, final int row) {
		
		super(team, col, row);
	}
	
	
	public boolean hasNotMoved () {
		
		return hasNotMoved;
	}
	
	
	@Override
	public void move (int col, int row, Piece[][] board, List<Piece> adversaryPieces) {
		
		super.move(col, row, board, adversaryPieces);
		this.hasNotMoved = false;
	}
	
	
	@Override
	public List<Point> getValidMoves (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		return null;
	}
	
	
	@Override
	public boolean isMoveValid (final int col, final int row, final Piece[][] board) {
		
		boolean valid = false;
		
		if (super.getTeam() == Team.WHITE) {
			
			if (super.getCol() == col && super.getRow() - 2 == row) {
				
				valid = true;
			} else if (super.getCol() == col && super.getRow() - 1 == row) {
				
				valid = true;
			} else if (Math.abs(super.getCol() - col) == 1 && super.getRow() - 1 == row) {
				
				valid = true;
			}
		} else {
			
			if (super.getCol() == col && super.getRow() + 2 == row) {
				
				valid = true;
			} else if (super.getCol() == col && super.getRow() + 1 == row) {
				
				valid = true;
			} else if (Math.abs(super.getCol() - col) == 1 && super.getRow() + 1 == row) {
				
				valid = true;
			}
		}
		
		if (valid) {
			
			return board[col][row] == null || board[col][row].getTeam() != super.getTeam();
		}
		
		return false;
	}
}
