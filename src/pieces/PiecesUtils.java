package pieces;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public final class PiecesUtils {
	
	public static List<Point> getDiagonalUpRightMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		Piece[][] boardCopy;
		
		while (++col < 7 && --row > 0) {
			if (board[col][row] == null) {
				boardCopy = getCopyOfBoard(board);
				
				boardCopy[col][row] = piece;
				boardCopy[piece.getCol()][piece.getRow()] = null;
				
				if (isKingSafe(kingPosition, adversaryPieces, boardCopy)) {
					moves.add(new Point(col, row));
				}
			} else {
				if (board[col][row].getTeam() != piece.getTeam()) {
					boardCopy = getCopyOfBoard(board);
					
					boardCopy[col][row] = piece;
					boardCopy[piece.getCol()][piece.getRow()] = null;
					
					if (isKingSafe(kingPosition, adversaryPieces, boardCopy)) {
						moves.add(new Point(col, row));
					}
				}
				break;
			}
		}
		
		return moves;
	}
	
	
	public static Piece[][] getCopyOfBoard (Piece[][] board) {
		
		final Piece[][] boardCopy = new Piece[8][8];
		
		for (int col = 0; col < 8; col++) {
			System.arraycopy(board[col], 0, boardCopy[col], 0, 8);
		}
		
		return boardCopy;
	}
	
	
	public static boolean isKingSafe (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		for (final Piece adversaryPiece : adversaryPieces) {
			if (adversaryPiece.isMoveValid(kingPosition, board)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static List<Point> getDiagonalUpLeftMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		Piece[][] boardCopy;
		
		while (--col > 0 && --row > 0) {
			if (board[col][row] == null) {
				boardCopy = getCopyOfBoard(board);
				
				boardCopy[col][row] = piece;
				boardCopy[piece.getCol()][piece.getRow()] = null;
				
				if (isKingSafe(kingPosition, adversaryPieces, boardCopy)) {
					moves.add(new Point(col, row));
				}
			} else {
				if (board[col][row].getTeam() != piece.getTeam()) {
					boardCopy = getCopyOfBoard(board);
					
					boardCopy[col][row] = piece;
					boardCopy[piece.getCol()][piece.getRow()] = null;
					
					if (isKingSafe(kingPosition, adversaryPieces, boardCopy)) {
						moves.add(new Point(col, row));
					}
				}
				break;
			}
		}
		
		return moves;
	}
	
	
	public static List<Point> getDiagonalDownRightMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		Piece[][] boardCopy;
		
		while (++col < 7 && ++row < 7) {
			if (board[col][row] == null) {
				boardCopy = getCopyOfBoard(board);
				
				boardCopy[col][row] = piece;
				boardCopy[piece.getCol()][piece.getRow()] = null;
				
				if (isKingSafe(kingPosition, adversaryPieces, boardCopy)) {
					moves.add(new Point(col, row));
				}
			} else {
				if (board[col][row].getTeam() != piece.getTeam()) {
					boardCopy = getCopyOfBoard(board);
					
					boardCopy[col][row] = piece;
					boardCopy[piece.getCol()][piece.getRow()] = null;
					
					if (isKingSafe(kingPosition, adversaryPieces, boardCopy)) {
						moves.add(new Point(col, row));
					}
				}
				break;
			}
		}
		
		return moves;
	}
	
	
	public static List<Point> getDiagonalDownLeftMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		Piece[][] boardCopy;
		
		while (--col > 0 && ++row < 7) {
			if (board[col][row] == null) {
				boardCopy = getCopyOfBoard(board);
				
				boardCopy[col][row] = piece;
				boardCopy[piece.getCol()][piece.getRow()] = null;
				
				if (isKingSafe(kingPosition, adversaryPieces, boardCopy)) {
					moves.add(new Point(col, row));
				}
			} else {
				if (board[col][row].getTeam() != piece.getTeam()) {
					boardCopy = getCopyOfBoard(board);
					
					boardCopy[col][row] = piece;
					boardCopy[piece.getCol()][piece.getRow()] = null;
					
					if (isKingSafe(kingPosition, adversaryPieces, boardCopy)) {
						moves.add(new Point(col, row));
					}
				}
				break;
			}
		}
		
		return moves;
	}
	
}
