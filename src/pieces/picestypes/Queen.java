package pieces.picestypes;

import pieces.Piece;
import pieces.PiecesUtils;
import pieces.Team;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
	
	public Queen (final Team team, final int col, final int row) {
		
		super(team, col, row);
	}
	
	
	@Override
	public List<Point> getValidMoves (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		List<Point> validMoves = new ArrayList<>();
		
		validMoves.addAll(PiecesUtils.getValidDiagonalMoves(this, kingPosition, adversaryPieces, board));
		validMoves.addAll(PiecesUtils.getValidCardinalMoves(this, kingPosition, adversaryPieces, board));
		
		return validMoves;
	}
	
	
	@Override
	public boolean isMoveValid (final int col, final int row, final Piece[][] board) {
		
		return PiecesUtils.isDiagonalMoveValid(this, col, row, board) || PiecesUtils.isCardinalMoveValid(this, col, row, board);
	}
	
}
