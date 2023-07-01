package pieces;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for pieces.
 */
public final class PiecesUtils {
	
	/**
	 * Get the list of all the valid diagonal moves for a piece.
	 * Takes into account the check state of the king.
	 *
	 * @param piece           The piece.
	 * @param kingPosition    The king position.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param board           The board.
	 *
	 * @return The list of valid diagonal moves.
	 */
	public static List<Point> getValidDiagonalMoves (final Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		moves.addAll(getDiagonalUpRightMoves(piece, kingPosition, adversaryPieces, board));
		moves.addAll(getDiagonalUpLeftMoves(piece, kingPosition, adversaryPieces, board));
		moves.addAll(getDiagonalDownRightMoves(piece, kingPosition, adversaryPieces, board));
		moves.addAll(getDiagonalDownLeftMoves(piece, kingPosition, adversaryPieces, board));
		
		return moves;
	}
	
	
	/**
	 * Get the list of all the valid cardinal moves for a piece.
	 * Takes into account the check state of the king.
	 *
	 * @param piece           The piece.
	 * @param kingPosition    The king position.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param board           The board.
	 *
	 * @return The list of valid cardinal moves.
	 */
	public static List<Point> getValidCardinalMoves (final Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		moves.addAll(getCardinalUpMoves(piece, kingPosition, adversaryPieces, board));
		moves.addAll(getCardinalDownMoves(piece, kingPosition, adversaryPieces, board));
		moves.addAll(getCardinalRightMoves(piece, kingPosition, adversaryPieces, board));
		moves.addAll(getCardinalLeftMoves(piece, kingPosition, adversaryPieces, board));
		
		return moves;
	}
	
	
	/**
	 * Get the list of all the up right diagonal moves for a piece.
	 * Takes into account the check state of the king.
	 *
	 * @param piece           The piece.
	 * @param kingPosition    The king position.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param board           The board.
	 *
	 * @return The list of up right diagonal moves.
	 */
	private static List<Point> getDiagonalUpRightMoves (final Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		while (++col <= 7 && --row > 0) {
			if (isPositionValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.VALID) {
				
				moves.add(new Point(col, row));
			} else if (isPositionValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.CAPTURE) {
				
				moves.add(new Point(col, row));
				break;
			} else if (isPositionValid(piece, col, row, kingPosition, adversaryPieces, board) == MoveType.INVALID) {
				
				break;
			}
		}
		
		return moves;
	}
	
	
	/**
	 * Get the type of move for a piece at a given position.
	 * Takes into account the check state of the king.
	 *
	 * @param piece           The piece.
	 * @param col             The column.
	 * @param row             The row.
	 * @param kingPosition    The king position.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param board           The board.
	 *
	 * @return The move type.
	 */
	private static MoveType isPositionValid (final Piece piece, final int col, final int row, final Point kingPosition, List<Piece> adversaryPieces, final Piece[][] board) {
		
		Piece[][] boardCopy;
		if (board[col][row] == null) {
			boardCopy = getBoardCopy(board);
			
			boardCopy[col][row] = piece;
			boardCopy[piece.getCol()][piece.getRow()] = null;
			
			if (adversaryPieces.contains(board[col][row])) {
				
				adversaryPieces = new ArrayList<>(adversaryPieces);
				
				adversaryPieces.remove(board[col][row]);
			}
			
			if (isKingSafe(kingPosition, adversaryPieces, boardCopy)) {
				return MoveType.VALID;
			}
		} else {
			if (board[col][row].getTeam() != piece.getTeam()) {
				boardCopy = getBoardCopy(board);
				
				boardCopy[col][row] = piece;
				boardCopy[piece.getCol()][piece.getRow()] = null;
				
				if (adversaryPieces.contains(board[col][row])) {
					
					adversaryPieces = new ArrayList<>(adversaryPieces);
					
					adversaryPieces.remove(board[col][row]);
				}
				
				if (isKingSafe(kingPosition, adversaryPieces, boardCopy)) {
					return MoveType.CAPTURE;
				} else {
					return MoveType.INVALID_CHECK;
				}
			}
		}
		
		return MoveType.INVALID;
	}
	
	
	/**
	 * Get the list of all the left right diagonal moves for a piece.
	 * Takes into account the check state of the king.
	 *
	 * @param piece           The piece.
	 * @param kingPosition    The king position.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param board           The board.
	 *
	 * @return The list of up left diagonal moves.
	 */
	private static List<Point> getDiagonalUpLeftMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		MoveType moveType;
		
		while (--col > 0 && --row > 0) {
			
			moveType = isPositionValid(piece, col, row, kingPosition, adversaryPieces, board);
			
			if (moveType == MoveType.VALID) {
				moves.add(new Point(col, row));
			} else if (moveType == MoveType.CAPTURE) {
				moves.add(new Point(col, row));
				break;
			} else if (moveType == MoveType.INVALID) {
				break;
			}
		}
		
		return moves;
	}
	
	
	/**
	 * Get the list of all the down right diagonal moves for a piece.
	 * Takes into account the check state of the king.
	 *
	 * @param piece           The piece.
	 * @param kingPosition    The king position.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param board           The board.
	 *
	 * @return The list of down right diagonal moves.
	 */
	private static List<Point> getDiagonalDownRightMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		MoveType moveType;
		
		while (++col <= 7 && ++row <= 7) {
			
			moveType = isPositionValid(piece, col, row, kingPosition, adversaryPieces, board);
			
			if (moveType == MoveType.VALID) {
				moves.add(new Point(col, row));
			} else if (moveType == MoveType.CAPTURE) {
				moves.add(new Point(col, row));
				break;
			} else if (moveType == MoveType.INVALID) {
				break;
			}
		}
		
		return moves;
	}
	
	
	/**
	 * Get a copy of the board.
	 *
	 * @param board The board.
	 *
	 * @return The copy of the board.
	 */
	public static Piece[][] getBoardCopy (Piece[][] board) {
		
		final Piece[][] boardCopy = new Piece[8][8];
		
		for (int col = 0; col < 8; col++) {
			System.arraycopy(board[col], 0, boardCopy[col], 0, 8);
		}
		
		return boardCopy;
	}
	
	
	/**
	 * Check if the king is safe.
	 *
	 * @param kingPosition    The king position.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param board           The board.
	 *
	 * @return True if the king is safe, false otherwise.
	 */
	public static boolean isKingSafe (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		for (final Piece adversaryPiece : adversaryPieces) {
			if (adversaryPiece.isMoveValid((int) kingPosition.getX(), (int) kingPosition.getY(), board)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	/**
	 * Get the list of all the down left diagonal moves for a piece.
	 * Takes into account the check state of the king.
	 *
	 * @param piece           The piece.
	 * @param kingPosition    The king position.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param board           The board.
	 *
	 * @return The list of down left diagonal moves.
	 */
	private static List<Point> getDiagonalDownLeftMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		MoveType moveType;
		
		while (--col > 0 && ++row <= 7) {
			
			moveType = isPositionValid(piece, col, row, kingPosition, adversaryPieces, board);
			
			if (moveType == MoveType.VALID) {
				moves.add(new Point(col, row));
			} else if (moveType == MoveType.CAPTURE) {
				moves.add(new Point(col, row));
				break;
			} else if (moveType == MoveType.INVALID) {
				break;
			}
		}
		
		return moves;
	}
	
	
	/**
	 * Get the list of all the up cardinal moves for a piece.
	 * Takes into account the check state of the king.
	 *
	 * @param piece           The piece.
	 * @param kingPosition    The king position.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param boar            The board.
	 *
	 * @return The list of up cardinal moves.
	 */
	private static List<Point> getCardinalUpMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] boar) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		while (--row > 0) {
			if (isPositionValid(piece, col, row, kingPosition, adversaryPieces, boar) == MoveType.VALID) {
				moves.add(new Point(col, row));
			} else if (isPositionValid(piece, col, row, kingPosition, adversaryPieces, boar) == MoveType.CAPTURE) {
				moves.add(new Point(col, row));
				break;
			} else if (isPositionValid(piece, col, row, kingPosition, adversaryPieces, boar) == MoveType.INVALID) {
				break;
			}
		}
		
		return moves;
	}
	
	
	/**
	 * Get the list of all the down cardinal moves for a piece.
	 * Takes into account the check state of the king.
	 *
	 * @param piece           The piece.
	 * @param kingPosition    The king position.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param boar            The board.
	 *
	 * @return The list of down cardinal moves.
	 */
	private static List<Point> getCardinalDownMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] boar) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		MoveType moveType;
		
		while (++row <= 7) {
			
			moveType = isPositionValid(piece, col, row, kingPosition, adversaryPieces, boar);
			
			if (moveType == MoveType.VALID) {
				moves.add(new Point(col, row));
			} else if (moveType == MoveType.CAPTURE) {
				moves.add(new Point(col, row));
				break;
			} else if (moveType == MoveType.INVALID) {
				break;
			}
		}
		
		return moves;
	}
	
	
	/**
	 * Get the list of all the right cardinal moves for a piece.
	 * Takes into account the check state of the king.
	 *
	 * @param piece           The piece.
	 * @param kingPosition    The king position.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param boar            The board.
	 *
	 * @return The list of right cardinal moves.
	 */
	private static List<Point> getCardinalRightMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] boar) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		MoveType moveType;
		
		while (++col <= 7) {
			
			moveType = isPositionValid(piece, col, row, kingPosition, adversaryPieces, boar);
			
			if (moveType == MoveType.VALID) {
				moves.add(new Point(col, row));
			} else if (moveType == MoveType.CAPTURE) {
				moves.add(new Point(col, row));
				break;
			} else if (moveType == MoveType.INVALID) {
				break;
			}
		}
		
		return moves;
	}
	
	
	/**
	 * Get the list of all the left cardinal moves for a piece.
	 * Takes into account the check state of the king.
	 *
	 * @param piece           The piece.
	 * @param kingPosition    The king position.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param boar            The board.
	 *
	 * @return The list of left cardinal moves.
	 */
	private static List<Point> getCardinalLeftMoves (Piece piece, final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] boar) {
		
		final List<Point> moves = new ArrayList<>();
		
		int col = piece.getCol();
		int row = piece.getRow();
		
		MoveType moveType;
		
		while (--col > 0) {
			
			moveType = isPositionValid(piece, col, row, kingPosition, adversaryPieces, boar);
			
			if (moveType == MoveType.VALID) {
				moves.add(new Point(col, row));
			} else if (moveType == MoveType.CAPTURE) {
				moves.add(new Point(col, row));
				break;
			} else if (moveType == MoveType.INVALID) {
				break;
			}
		}
		
		return moves;
	}
	
	
	/**
	 * Check if a diagonal move is valid.
	 * Does not take into account the check state of the king.
	 *
	 * @param piece The piece.
	 * @param col   The column.
	 * @param row   The row.
	 * @param board The board.
	 *
	 * @return True if the diagonal move is valid, false otherwise.
	 */
	public static boolean isDiagonalMoveValid (final Piece piece, final int col, final int row, final Piece[][] board) {
		
		if (Math.abs(piece.getCol() - col) == Math.abs(piece.getRow() - row)) {
			
			final int colDirection = (col - piece.getCol()) / Math.abs(col - piece.getCol());
			final int rowDirection = (row - piece.getRow()) / Math.abs(row - piece.getRow());
			
			int colIterator = piece.getCol() + colDirection;
			int rowIterator = piece.getRow() + rowDirection;
			
			while (colIterator != col && rowIterator != row) {
				if (board[colIterator][rowIterator] != null) {
					return false;
				}
				
				colIterator += colDirection;
				rowIterator += rowDirection;
			}
			
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Check if a cardinal move is valid.
	 * Does not take into account the check state of the king.
	 *
	 * @param piece The piece.
	 * @param col   The column.
	 * @param row   The row.
	 * @param board The board.
	 *
	 * @return True if the cardinal move is valid, false otherwise.
	 */
	public static boolean isCardinalMoveValid (final Piece piece, final int col, final int row, final Piece[][] board) {
		
		if (piece.getCol() == col) {
			if (piece.getRow() > row) {
				for (int i = piece.getRow() - 1; i > row; i--) {
					if (board[col][i] != null) {
						return false;
					}
				}
			} else {
				for (int i = piece.getRow() + 1; i < row; i++) {
					if (board[col][i] != null) {
						return false;
					}
				}
			}
			
			return true;
		} else if (piece.getRow() == row) {
			if (piece.getCol() > col) {
				for (int i = piece.getCol() - 1; i > col; i--) {
					if (board[i][row] != null) {
						return false;
					}
				}
			} else {
				for (int i = piece.getCol() + 1; i < col; i++) {
					if (board[i][row] != null) {
						return false;
					}
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * The type of move.
	 */
	private enum MoveType {
		VALID, CAPTURE, INVALID, INVALID_CHECK
	}
	
}
