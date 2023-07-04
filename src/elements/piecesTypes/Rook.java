package elements.piecesTypes;

import elements.Piece;
import elements.PiecesUtils;
import elements.Team;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class Rook extends Piece {
	
	private boolean hasNotMoved = true;
	
	
	public Rook (final Team team, final int col, final int row) {
		
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
		
		return PiecesUtils.getValidCardinalMoves(this, kingPosition, adversaryPieces, board);
	}
	
	
	@Override
	public boolean isMoveValid (final int col, final int row, final Piece[][] board) {
		
		return PiecesUtils.isCardinalMoveValid(this, col, row, board);
	}


	@Override
	public Image getImage() {
		String equipa = this.getTeam().name().substring(0,1).toLowerCase();
		return new ImageIcon(Objects.requireNonNull(getClass().getResource(equipa + "R.png"))).getImage();
	}
}
