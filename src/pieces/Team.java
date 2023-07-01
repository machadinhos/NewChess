package pieces;

public enum Team {
	
	WHITE, BLACK;
	
	private boolean isEnPassantPossible = true;
	
	private boolean inEnPassantPlay = false;
	
	
	public void setInEnPassantPlay () {
		
		if (this == Team.WHITE) {
			
			Team.BLACK.inEnPassantPlay = true;
		} else {
			
			Team.WHITE.inEnPassantPlay = true;
		}
	}
	
	
	public void updateEnPassant () {
		
		if (inEnPassantPlay) {
			
			this.isEnPassantPossible = false;
		}
	}
}
