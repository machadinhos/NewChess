package pieces.picestypes;

import pieces.Piece;
import pieces.PiecesUtils;
import pieces.Team;

import java.awt.*;
import java.util.List;

public class Rook extends Piece {
	
	private boolean hasMoved;
	
	
	public Rook (final Team team, final int col, final int row) {
		
		super(team, col, row);
	}
	
	
	public boolean hasMoved () {
		
		return hasMoved;
	}
	
	
	@Override
	public void move (int col, int row, Piece[][] board, List<Piece> adversaryPieces) {
		
		super.move(col, row, board, adversaryPieces);
		this.hasMoved = true;
	}
	
	
	@Override
	public List<Point> getValidMoves (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		return PiecesUtils.getValidCardinalMoves(this, kingPosition, adversaryPieces, board);
	}
	
	
	@Override
	public boolean isMoveValid (final int col, final int row, final Piece[][] board) {
		
		return PiecesUtils.isCardinalMoveValid(this, col, row, board);
	}
	
}
