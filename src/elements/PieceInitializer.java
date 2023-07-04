package elements;

import elements.piecesTypes.*;

import java.util.ArrayList;
import java.util.List;

public class PieceInitializer {
	
	public static List<Piece> whiteTeamInitializer (final GameElement[][] board) {
		
		List<Piece> whitePieces = new ArrayList<>();
		
		for (int col = 0; col < 8; col++) {
			whitePieces.add(new Pawn(Team.WHITE, col, 6));
		}

		whitePieces.add(new Rook(Team.WHITE, 0, 7));
		whitePieces.add(new Rook(Team.WHITE, 7, 7));

		whitePieces.add(new Knight(Team.WHITE, 1, 7));
		whitePieces.add(new Knight(Team.WHITE, 6, 7));

		whitePieces.add(new Bishop(Team.WHITE, 2, 7));
		whitePieces.add(new Bishop(Team.WHITE, 5, 7));

		whitePieces.add(new Queen(Team.WHITE, 3, 7));

		whitePieces.add(new King(Team.WHITE, 4, 7));

		whitePieces.forEach(p-> board[p.getCol()][p.getRow()] = p);

		return whitePieces;
	}
	
	
	public static List<Piece> blackTeamInitializer (final GameElement[][] board) {
		
		List<Piece> blackPieces = new ArrayList<>();
		
		for (int col = 0; col < 8; col++) {

			blackPieces.add(new Pawn(Team.BLACK, col, 1));
		}

		blackPieces.add(new Rook(Team.BLACK, 0, 0));
		blackPieces.add( new Rook(Team.BLACK, 7, 0));
		
		blackPieces.add(new Knight(Team.BLACK, 1, 0));
		blackPieces.add(new Knight(Team.BLACK, 6, 0));
		
		blackPieces.add(new Bishop(Team.BLACK, 2, 0));
		blackPieces.add(new Bishop(Team.BLACK, 5, 0));
		
		blackPieces.add(new Queen(Team.BLACK, 3, 0));
		
		blackPieces.add(new King(Team.BLACK, 4, 0));

		blackPieces.forEach(p-> board[p.getCol()][p.getRow()] = p);

		return blackPieces;
	}
	
}
