package pieces;

import java.awt.*;
import java.util.List;

public class PiecesUtils {
	
	public static boolean isKingSafe (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		for (final Piece adversaryPiece : adversaryPieces) {
			if (adversaryPiece.checkValidMove(kingPosition, board)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static List<Point> getDiagonalUpRightMoves () {
		
		throw new UnsupportedOperationException();
	}
	
}
