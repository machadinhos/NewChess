package pieces;

import pieces.picestypes.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PieceInitializer {
	
	public static List<Piece> whiteTeamInitializer(final Piece[][] board) {
		
		List<Piece> whitePieces = new ArrayList<>();
		
		for (int col = 0; col <  8; col++) {
			board[col][6] = new Pawn(Team.WHITE, col, 6);
			whitePieces.add(board[col][6]);
		}
		
		board[0][7] = new Rook(Team.WHITE, 0, 7);
		whitePieces.add(board[0][7]);
		board[7][7] = new Rook(Team.WHITE, 7, 7);
		whitePieces.add(board[7][7]);
		
		board[1][7] = new Knight(Team.WHITE, 1, 7);
		whitePieces.add(board[1][7]);
		board[6][7] = new Knight(Team.WHITE, 6, 7);
		whitePieces.add(board[6][7]);
		
		board[2][7] = new Bishop(Team.WHITE, 2, 7);
		whitePieces.add(board[2][7]);
		board[5][7] = new Bishop(Team.WHITE, 5, 7);
		whitePieces.add(board[5][7]);
		
		board[3][7] = new Queen(Team.WHITE, 3, 7);
		whitePieces.add(board[3][7]);
		
		board[4][7] = new King(Team.WHITE, 4, 7);
		whitePieces.add(board[4][7]);
		
		return whitePieces;
	}
	
	public static List<Piece> blackTeamInitializer(final Piece[][] board) {
		
		List<Piece> blackPieces = new ArrayList<>();
		
		for (int col = 0; col <  8; col++) {
			board[col][1] = new Pawn(Team.BLACK, col, 1);
			blackPieces.add(board[col][1]);
		}
		
		board[0][0] = new Rook(Team.BLACK, 0, 0);
		blackPieces.add(board[0][0]);
		board[7][0] = new Rook(Team.BLACK, 7, 0);
		blackPieces.add(board[7][0]);
		
		board[1][0] = new Knight(Team.BLACK, 1, 0);
		blackPieces.add(board[1][0]);
		board[6][0] = new Knight(Team.BLACK, 6, 0);
		blackPieces.add(board[6][0]);
		
		board[2][0] = new Bishop(Team.BLACK, 2, 0);
		blackPieces.add(board[2][0]);
		board[5][0] = new Bishop(Team.BLACK, 5, 0);
		blackPieces.add(board[5][0]);
		
		board[3][0] = new Queen(Team.BLACK, 3, 0);
		blackPieces.add(board[3][0]);
		
		board[4][0] = new King(Team.BLACK, 4, 0);
		blackPieces.add(board[4][0]);
		
		return blackPieces;
	}
	
}
