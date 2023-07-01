package pieces;

import java.awt.*;
import java.util.List;

public abstract class Piece {
	
	private final Team team;
	private final Point position;
	
	
	protected Piece (final Team team, final int col, final int row) {
		
		this.team = team;
		this.position = new Point(col, row);
	}
	
	
	public Team getTeam () {
		
		return team;
	}
	
	
	public Point getPosition () {
		
		return position;
	}
	
	
	public void move (final int col, final int row, final Piece[][] board, final List<Piece> adversaryPieces) {
		
		board[getCol()][getRow()] = null;
		adversaryPieces.remove(board[col][row]);
		board[col][row] = this;
		this.position.setLocation(col, row);
	}
	
	
	public int getCol () {
		
		return (int) position.getX();
	}
	
	
	public int getRow () {
		
		return (int) position.getY();
	}
	
	
	public abstract List<Point> getValidMoves (final Point kingPosition, final List<Piece> adversaryPieces, final Piece[][] board);
	
	
	public abstract boolean isMoveValid (final int col, final int row, final Piece[][] board);
	
}
