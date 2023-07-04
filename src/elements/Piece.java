package elements;

import java.awt.*;
import java.util.List;

/**
 * Represents a piece.
 */
public abstract class Piece extends GameElement {
	
	private final Team team;

	
	protected Piece (final Team team, final int col, final int row) {
		super(col,row);
		this.team = team;

	}
	
	
	public Team getTeam () {
		
		return team;
	}
	
	
	/**
	 * Moves the piece to the specified position.
	 *
	 * @param col             The column to move to.
	 * @param row             The row to move to.
	 * @param board           The board.
	 * @param adversaryPieces The pieces of the adversary.
	 */
	public void move (final int col, final int row, final Piece[][] board, final List<Piece> adversaryPieces) {
		
		board[getCol()][getRow()] = null;
		adversaryPieces.remove(board[col][row]);
		board[col][row] = this;
		this.getPosition().setLocation(col, row);
		this.team.updateEnPassant();
	}
	
	
	public int getCol () {
		
		return (int) getPosition().getX();
	}
	
	
	public int getRow () {
		
		return (int) getPosition().getY();
	}
	
	
	/**
	 * Gets the list of valid moves for the piece.
	 *
	 * @param kingPosition    The position of the king.
	 * @param adversaryPieces The pieces of the adversary.
	 * @param board           The board.
	 *
	 * @return The list of valid moves for the piece.
	 */
	public abstract List<Point> getValidMoves (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board);
	
	
	/**
	 * Checks if the move is valid for the piece.
	 * Does not take into account the check state of the king.
	 *
	 * @param col   The column to move to.
	 * @param row   The row to move to.
	 * @param board The board.
	 *
	 * @return True if the move is valid, false otherwise.
	 */
	public abstract boolean isMoveValid (final int col, final int row, final Piece[][] board);



}
