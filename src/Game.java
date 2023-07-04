import elements.GameElement;
import elements.Piece;
import elements.PieceInitializer;

import java.awt.*;
import java.util.List;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Game {
	
	private static GameElement[][] board;
	private static List<Piece> whitePieces;
	private static List<Piece> blackPieces;
	private static List<Piece> playingPieces;
	private static List<Piece> adversaryPieces;
	private static Point whiteKingPosition;
	private static Point blackKingPosition;
	private static Point playingKingPosition;
	private static Point adversaryKingPosition;
	// contain a support object instead of extending the support class
	PropertyChangeSupport pcs = new  PropertyChangeSupport(this);

	public void addObserver(PropertyChangeListener l) {
		pcs.addPropertyChangeListener("theProperty", l);
	}

	/*public void setProperty(String val) {
		L old = playingPieces;
		property = val;
		pcs.firePropertyChange("theProperty", old, val);
	}*/

	public String toString() { return "The subject object"; };


	/**
	 * Constructs a new {@code PropertyChangeEvent}.
	 *
	 * @throws IllegalArgumentException if {@code source} is {@code null}
	 */
	public Game() {

		board = new Piece[8][8];

		whitePieces = PieceInitializer.whiteTeamInitializer(board);
		blackPieces = PieceInitializer.blackTeamInitializer(board);

		whiteKingPosition = board[4][7].getPosition();
		blackKingPosition = board[4][0].getPosition();

		playingPieces = whitePieces;
		adversaryPieces = blackPieces;

		playingKingPosition = whiteKingPosition;
		adversaryKingPosition = blackKingPosition;

	}


	public static void restartGame () {

		board = new Piece[8][8];

		whitePieces = PieceInitializer.whiteTeamInitializer(board);
		blackPieces = PieceInitializer.blackTeamInitializer(board);

		whiteKingPosition = board[4][7].getPosition();
		blackKingPosition = board[4][0].getPosition();

		playingPieces = whitePieces;
		adversaryPieces = blackPieces;

		playingKingPosition = whiteKingPosition;
		adversaryKingPosition = blackKingPosition;
	}
	
	
	public static void changeTurn () {
		
		if (playingPieces == whitePieces) {
			playingPieces = blackPieces;
			adversaryPieces = whitePieces;
			
			playingKingPosition = blackKingPosition;
			adversaryKingPosition = whiteKingPosition;
		} else {
			playingPieces = whitePieces;
			adversaryPieces = blackPieces;
			
			playingKingPosition = whiteKingPosition;
			adversaryKingPosition = blackKingPosition;
		}
	}

	public GameElement[][] getBoard() {
		return board;
	}

	//clear Circles
}
