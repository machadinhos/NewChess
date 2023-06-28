import pieces.Piece;
import pieces.PieceInitializer;

import java.awt.*;
import java.util.List;

public class Game {
	
	private static Piece[][] board;
	private static List<Piece> whitePieces;
	private static List<Piece> blackPieces;
	private static List<Piece> playingPieces;
	private static List<Piece> adversaryPieces;
	private static Point whiteKingPosition;
	private static Point blackKingPosition;
	private static Point playingKingPosition;
	private static Point adversaryKingPosition;
	
	
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
	
	public static void restartGame() {
		
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
	
	public static void changeTurn() {
		
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
}
