package pieces.picestypes;

import pieces.Piece;
import pieces.Team;

import java.awt.*;
import java.util.ArrayList;
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
		
		List<Point> validMoves = new ArrayList<>();
		
		if (super.getTeam() == Team.WHITE) {
			
			if (super.getRow() - 1 >= 0 && board[super.getCol()][super.getRow() - 1] == null) {
				
				validMoves.add(new Point(super.getCol(), super.getRow() - 1));
			}
			
			if (super.getRow() - 2 >= 0 && board[super.getCol()][super.getRow() - 2] == null && board[super.getCol()][super.getRow() - 1] == null && this.hasNotMoved()) {
				
				validMoves.add(new Point(super.getCol(), super.getRow() - 2));
			}
			
			if (super.getRow() - 1 >= 0 && super.getCol() - 1 >= 0 && board[super.getCol() - 1][super.getRow() - 1] != null && board[super.getCol() - 1][super.getRow() - 1].getTeam() != super.getTeam()) {
				
				validMoves.add(new Point(super.getCol() - 1, super.getRow() - 1));
			}
			
			if (super.getRow() - 1 >= 0 && super.getCol() + 1 <= 7 && board[super.getCol() + 1][super.getRow() - 1] != null && board[super.getCol() + 1][super.getRow() - 1].getTeam() != super.getTeam()) {
				
				validMoves.add(new Point(super.getCol() + 1, super.getRow() - 1));
			}
		} else {
			
			if (super.getRow() + 1 <= 7 && board[super.getCol()][super.getRow() + 1] == null) {
				
				validMoves.add(new Point(super.getCol(), super.getRow() + 1));
			}
			
			if (super.getRow() + 2 <= 7 && board[super.getCol()][super.getRow() + 2] == null && board[super.getCol()][super.getRow() + 1] == null && this.hasNotMoved()) {
				
				validMoves.add(new Point(super.getCol(), super.getRow() + 2));
			}
			
			if (super.getRow() + 1 <= 7 && super.getCol() - 1 >= 0 && board[super.getCol() - 1][super.getRow() + 1] != null && board[super.getCol() - 1][super.getRow() + 1].getTeam() != super.getTeam()) {
				
				validMoves.add(new Point(super.getCol() - 1, super.getRow() + 1));
			}
		}
		
		if (super.getTeam().isInEnPassantPlay()) {
			validMoves.add(super.getTeam().getEnPassantPoint());
		}
		
		return validMoves;
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
