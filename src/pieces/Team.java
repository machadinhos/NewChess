package pieces;

import java.awt.*;

public enum Team {
	
	WHITE, BLACK;
	
	private boolean isEnPassantPossible = true;
	
	private boolean inEnPassantPlay = false;
	
	private Point enPassantPoint;
	
	
	public static void reset () {
		
		Team.WHITE.isEnPassantPossible = true;
		Team.WHITE.inEnPassantPlay = false;
		Team.WHITE.enPassantPoint = null;
		
		Team.BLACK.isEnPassantPossible = true;
		Team.BLACK.inEnPassantPlay = false;
		Team.BLACK.enPassantPoint = null;
	}
	
	
	public boolean isEnPassantPossible () {
		
		if (this == Team.WHITE) {
			
			return Team.BLACK.isEnPassantPossible;
		} else {
			
			return Team.WHITE.isEnPassantPossible;
		}
	}
	
	
	public boolean isInEnPassantPlay () {
		
		return inEnPassantPlay;
	}
	
	
	public void setInEnPassantPlay (Point enPassantPoint) {
		
		if (this == Team.WHITE) {
			
			Team.BLACK.inEnPassantPlay = true;
			Team.BLACK.enPassantPoint = enPassantPoint;
		} else {
			
			Team.WHITE.inEnPassantPlay = true;
			Team.WHITE.enPassantPoint = enPassantPoint;
		}
	}
	
	
	public Point getEnPassantPoint () {
		
		return enPassantPoint;
	}
	
	
	public void updateEnPassant () {
		
		if (inEnPassantPlay) {
			
			this.isEnPassantPossible = false;
			this.inEnPassantPlay = false;
			this.enPassantPoint = null;
		}
	}
}
