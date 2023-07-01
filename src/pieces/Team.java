package pieces;

public enum Team {
	
	WHITE, BLACK;
	
	private boolean isEnPassantPossible = true;
	
	
	public boolean isEnPassantPossible () {
		
		return isEnPassantPossible;
	}
	
	
	public void doEnPassant () {
		
		this.isEnPassantPossible = false;
	}
}
