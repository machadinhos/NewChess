package pieces;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public final class PiecesUtils {
	
	public static List<Point> getValidDiagonalMoves (final Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		moves.addAll(getDiagonalUpRightMoves(piece, kingPosition, adversaryPieces, board));
		moves.addAll(getDiagonalUpLeftMoves(piece, kingPosition, adversaryPieces, board));
		moves.addAll(getDiagonalDownRightMoves(piece, kingPosition, adversaryPieces, board));
		moves.addAll(getDiagonalDownLeftMoves(piece, kingPosition, adversaryPieces, board));
		
		return moves;
	}
	
	
	private static List<Point> getDiagonalUpRightMoves (final Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		Piece[][] boardCopy;
		
		while (++col <= 7 && --row > 0) {
			if (isMoveValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.VALID) {
				moves.add(new Point(col, row));
			} else if (isMoveValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.CAPTURE) {
				moves.add(new Point(col, row));
				break;
			} else if (isMoveValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.INVALID) {
				break;
			}
		}
		
		return moves;
	}
	
	
	private static List<Point> getDiagonalUpLeftMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		Piece[][] boardCopy;
		
		while (--col > 0 && --row > 0) {
			if (isMoveValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.VALID) {
				moves.add(new Point(col, row));
			} else if (isMoveValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.CAPTURE) {
				moves.add(new Point(col, row));
				break;
			} else if (isMoveValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.INVALID) {
				break;
			}
		}
		
		return moves;
	}
	
	
	private static List<Point> getDiagonalDownRightMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		Piece[][] boardCopy;
		
		while (++col <= 7 && ++row <= 7) {
			
			if (isMoveValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.VALID) {
				moves.add(new Point(col, row));
			} else if (isMoveValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.CAPTURE) {
				moves.add(new Point(col, row));
				break;
			} else if (isMoveValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.INVALID) {
				break;
			}
		}
		
		return moves;
	}
	
	
	private static List<Point> getDiagonalDownLeftMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		Piece[][] boardCopy;
		
		while (--col > 0 && ++row <= 7) {
			
			if (isMoveValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.VALID) {
				moves.add(new Point(col, row));
			} else if (isMoveValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.CAPTURE) {
				moves.add(new Point(col, row));
				break;
			} else if (isMoveValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.INVALID) {
				break;
			}
		}
		
		return moves;
	}
	
	
	public static Piece[][] getBoardCopy (Piece[][] board) {
		
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
	
	
	private static MoveType isMoveValid (final Piece piece, final int col, final int row, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		Piece[][] boardCopy;
		if (board[col][row] == null) {
			boardCopy = getBoardCopy(board);
			
			boardCopy[col][row] = piece;
			boardCopy[piece.getCol()][piece.getRow()] = null;
			
			if (isKingSafe(kingPosition, adversaryPieces, boardCopy)) {
				return MoveType.VALID;
			}
		} else {
			if (board[col][row].getTeam() != piece.getTeam()) {
				boardCopy = getBoardCopy(board);
				
				boardCopy[col][row] = piece;
				boardCopy[piece.getCol()][piece.getRow()] = null;
				
				if (isKingSafe(kingPosition, adversaryPieces, boardCopy)) {
					return MoveType.CAPTURE;
				} else {
					return MoveType.INVALID_CHECK;
				}
			}
		}
		
		return MoveType.INVALID;
	}
	
	
	private enum MoveType {
		VALID, CAPTURE, INVALID, INVALID_CHECK
	}
	
}
