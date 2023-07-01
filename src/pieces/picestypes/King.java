package pieces.picestypes;

import pieces.Piece;
import pieces.PiecesUtils;
import pieces.Team;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	
	private boolean hasMoved;
	
	
	public King (final Team team, final int col, final int row) {
		
		super(team, col, row);
	}
	
	
	@Override
	public void move (int col, int row, Piece[][] board, List<Piece> adversaryPieces) {
		
		super.move(col, row, board, adversaryPieces);
		this.hasMoved = true;
	}
	
	
	@Override
	public List<Point> getValidMoves (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		List<Point> validMoves = new ArrayList<>();
		
		if (PiecesUtils.isDiagonalMoveValid(this, super.getCol() + 1, super.getRow() + 1, board)) {
			
			Piece[][] boardCopy = PiecesUtils.getBoardCopy(board);
			boardCopy[super.getCol() + 1][super.getRow() + 1] = this;
			boardCopy[super.getCol()][super.getRow()] = null;
			
			if (PiecesUtils.isKingSafe(new Point(super.getCol() + 1, super.getRow() + 1), adversaryPieces, boardCopy)) {
				
				validMoves.add(new Point(super.getCol() + 1, super.getRow() + 1));
			}
		}
		if (PiecesUtils.isCardinalMoveValid(this, super.getCol() + 1, super.getRow(), board)) {
			
			Piece[][] boardCopy = PiecesUtils.getBoardCopy(board);
			boardCopy[super.getCol() + 1][super.getRow()] = this;
			boardCopy[super.getCol()][super.getRow()] = null;
			
			if (PiecesUtils.isKingSafe(new Point(super.getCol() + 1, super.getRow()), adversaryPieces, boardCopy)) {
				
				validMoves.add(new Point(super.getCol() + 1, super.getRow()));
			}
		}
		if (PiecesUtils.isDiagonalMoveValid(this, super.getCol() + 1, super.getRow() - 1, board)) {
			
			Piece[][] boardCopy = PiecesUtils.getBoardCopy(board);
			boardCopy[super.getCol() + 1][super.getRow() - 1] = this;
			boardCopy[super.getCol()][super.getRow()] = null;
			
			if (PiecesUtils.isKingSafe(new Point(super.getCol() + 1, super.getRow() - 1), adversaryPieces, boardCopy)) {
				
				validMoves.add(new Point(super.getCol() + 1, super.getRow() - 1));
			}
		}
		if (PiecesUtils.isCardinalMoveValid(this, super.getCol(), super.getRow() - 1, board)) {
			
			Piece[][] boardCopy = PiecesUtils.getBoardCopy(board);
			boardCopy[super.getCol()][super.getRow() - 1] = this;
			boardCopy[super.getCol()][super.getRow()] = null;
			
			if (PiecesUtils.isKingSafe(new Point(super.getCol(), super.getRow() - 1), adversaryPieces, boardCopy)) {
				
				validMoves.add(new Point(super.getCol(), super.getRow() - 1));
			}
		}
		if (PiecesUtils.isDiagonalMoveValid(this, super.getCol() - 1, super.getRow() - 1, board)) {
			
			Piece[][] boardCopy = PiecesUtils.getBoardCopy(board);
			boardCopy[super.getCol() - 1][super.getRow() - 1] = this;
			boardCopy[super.getCol()][super.getRow()] = null;
			
			if (PiecesUtils.isKingSafe(new Point(super.getCol() - 1, super.getRow() - 1), adversaryPieces, boardCopy)) {
				
				validMoves.add(new Point(super.getCol() - 1, super.getRow() - 1));
			}
		}
		if (PiecesUtils.isCardinalMoveValid(this, super.getCol() - 1, super.getRow(), board)) {
			
			Piece[][] boardCopy = PiecesUtils.getBoardCopy(board);
			boardCopy[super.getCol() - 1][super.getRow()] = this;
			boardCopy[super.getCol()][super.getRow()] = null;
			
			if (PiecesUtils.isKingSafe(new Point(super.getCol() - 1, super.getRow()), adversaryPieces, boardCopy)) {
				
				validMoves.add(new Point(super.getCol() - 1, super.getRow()));
			}
		}
		if (PiecesUtils.isDiagonalMoveValid(this, super.getCol() - 1, super.getRow() + 1, board)) {
			
			Piece[][] boardCopy = PiecesUtils.getBoardCopy(board);
			boardCopy[super.getCol() - 1][super.getRow() + 1] = this;
			boardCopy[super.getCol()][super.getRow()] = null;
			
			if (PiecesUtils.isKingSafe(new Point(super.getCol() - 1, super.getRow() + 1), adversaryPieces, boardCopy)) {
				
				validMoves.add(new Point(super.getCol() - 1, super.getRow() + 1));
			}
		}
		if (PiecesUtils.isCardinalMoveValid(this, super.getCol(), super.getRow() + 1, board)) {
			
			Piece[][] boardCopy = PiecesUtils.getBoardCopy(board);
			boardCopy[super.getCol()][super.getRow() + 1] = this;
			boardCopy[super.getCol()][super.getRow()] = null;
			
			if (PiecesUtils.isKingSafe(new Point(super.getCol(), super.getRow() + 1), adversaryPieces, boardCopy)) {
				
				validMoves.add(new Point(super.getCol(), super.getRow() + 1));
			}
		}
		
		validMoves.addAll(getCastelingMoves(adversaryPieces, board));
		
		return validMoves;
	}
	
	
	@Override
	public boolean isMoveValid (final int col, final int row, final Piece[][] board) {
		
		return false;
	}
	
	
	private List<Point> getCastelingMoves (final List<Piece> adversaryPieces, final Piece[][] board) {
		
		List<Point> validMoves = new ArrayList<>();
		
		if (!PiecesUtils.isKingSafe(super.getPosition(), adversaryPieces, board)) {
			
			return validMoves;
		}
		
		if (!hasMoved) {
			
			if (PiecesUtils.isCardinalMoveValid(this, super.getCol() + 2, super.getRow(), board)) {
				
				Piece[][] boardCopy = PiecesUtils.getBoardCopy(board);
				boardCopy[super.getCol() + 2][super.getRow()] = this;
				boardCopy[super.getCol()][super.getRow()] = null;
				
				if (PiecesUtils.isKingSafe(new Point(super.getCol() + 2, super.getRow()), adversaryPieces, boardCopy)) {
					
					if (board[super.getCol() + 3][super.getRow()] instanceof Rook && !((Rook) board[super.getCol() + 3][super.getRow()]).hasMoved()) {
						
						validMoves.add(new Point(super.getCol() + 2, super.getRow()));
					}
				}
			}
			if (PiecesUtils.isCardinalMoveValid(this, super.getCol() - 2, super.getRow(), board)) {
				
				Piece[][] boardCopy = PiecesUtils.getBoardCopy(board);
				boardCopy[super.getCol() - 2][super.getRow()] = this;
				boardCopy[super.getCol()][super.getRow()] = null;
				
				if (PiecesUtils.isKingSafe(new Point(super.getCol() - 2, super.getRow()), adversaryPieces, boardCopy)) {
					
					if (board[super.getCol() - 4][super.getRow()] instanceof Rook && !((Rook) board[super.getCol() - 4][super.getRow()]).hasMoved()) {
						
						if (board[super.getCol() - 3][super.getRow()] == null) {
							
							validMoves.add(new Point(super.getCol() - 2, super.getRow()));
						}
						
					}
				}
			}
		}
		
		return validMoves;
	}
	
}
