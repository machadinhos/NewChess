package pieces.picestypes;

import pieces.Piece;
import pieces.PiecesUtils;
import pieces.Team;

import java.awt.*;
import java.util.List;

public class Bishop extends Piece {
	
	
	public Bishop (final Team team, final int col, final int row) {
		
		super(team, col, row);
	}
	
	
	@Override
	public List<Point> getValidMoves (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		return PiecesUtils.getValidDiagonalMoves(this, kingPosition, adversaryPieces, board);
	}
	
	
	@Override
	public boolean isMoveValid (final Point target, final Piece[][] board) {
		
		throw new UnsupportedOperationException();
	}
	
}
