package elements.piecesTypes;

import elements.Piece;
import elements.PiecesUtils;
import elements.Team;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class Bishop extends Piece {
	
	
	public Bishop (final Team team, final int col, final int row) {
		
		super(team, col, row);
	}
	
	
	@Override
	public List<Point> getValidMoves (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board) {
		
		return PiecesUtils.getValidDiagonalMoves(this, kingPosition, adversaryPieces, board);
	}
	
	
	@Override
	public boolean isMoveValid (final int col, final int row, final Piece[][] board) {
		
		return PiecesUtils.isDiagonalMoveValid(this, col, row, board);
	}

	@Override
	public Image getImage() {
		String equipa = this.getTeam().name().substring(0,1).toLowerCase();
		return new ImageIcon(Objects.requireNonNull(getClass().getResource(equipa + "B.png"))).getImage();
	}
}
