package pieces.picestypes;

import pieces.Piece;
import pieces.PiecesUtils;
import pieces.Team;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
	
	private boolean hasNotMoved = true;
	
	
	public Pawn (final Team team, final int col, final int row) {
		
		super(team, col, row);
	}
	
	
	@Override
	public void move (int col, int row, Piece[][] board, List<Piece> adversaryPieces) {
		
		super.move(col, row, board, adversaryPieces);
		this.hasNotMoved = false;
	}
	
	
	@Override
	public List<Point> getValidMoves (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		List<Point> validMoves = new ArrayList<>();
		
		int col;
		int row;
		
		if (super.getTeam() == Team.WHITE) {
			
			col = super.getCol();
			row = super.getRow() - 1;
			
			if (checkMove(col, row, kingPosition, adversaryPieces, board)) {
				
				validMoves.add(new Point(col, row));
				
				if (hasNotMoved && checkMove(col, row - 1, kingPosition, adversaryPieces, board)) {
					
					validMoves.add(new Point(col, row - 1));
				}
			}
			
			col = super.getCol() - 1;
			
			if (checkMove(col, row, kingPosition, adversaryPieces, board)) {
				
				validMoves.add(new Point(col, row));
			}
			
			col = super.getCol() + 1;
			
			if (checkMove(col, row, kingPosition, adversaryPieces, board)) {
				
				validMoves.add(new Point(col, row));
			}
		} else {
			
			col = super.getCol();
			row = super.getRow() + 1;
			
			if (checkMove(col, row, kingPosition, adversaryPieces, board)) {
				
				validMoves.add(new Point(col, row));
				
				if (hasNotMoved && checkMove(col, row + 1, kingPosition, adversaryPieces, board)) {
					
					validMoves.add(new Point(col, row - 1));
				}
			}
			
			col = super.getCol() - 1;
			
			if (checkMove(col, row, kingPosition, adversaryPieces, board)) {
				
				validMoves.add(new Point(col, row));
			}
			
			col = super.getCol() + 1;
			
			if (checkMove(col, row, kingPosition, adversaryPieces, board)) {
				
				validMoves.add(new Point(col, row));
			}
		}
		
		if (super.getTeam().isInEnPassantPlay()) {
			
			validMoves.add(super.getTeam().getEnPassantPoint());
		}
		
		return validMoves;
	}
	
	
	private boolean checkMove (final int col, final int row, final Point kingPosition, List<Piece> adversaryPieces, final Piece[][] board) {
		
		
		if (row >= 0 && row <= 7 && col >= 0 && col <= 7) {
			
			if (col == super.getCol() && board[row][col] != null) {
				
				return false;
			} else if (board[row][col] == null || board[row][col].getTeam() == super.getTeam()) {
				
				return false;
			}
			
			Piece[][] boardCopy = PiecesUtils.getBoardCopy(board);
			
			boardCopy[super.getRow()][super.getCol()] = null;
			boardCopy[row][col] = this;
			
			if (adversaryPieces.contains(boardCopy[row][col])) {
				
				adversaryPieces = new ArrayList<>(adversaryPieces);
				
				adversaryPieces.remove(boardCopy[row][col]);
			}
			
			return PiecesUtils.isKingSafe(kingPosition, adversaryPieces, boardCopy);
		}
		
		return false;
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
	
	
	public boolean hasNotMoved () {
		
		return hasNotMoved;
	}
	
}
