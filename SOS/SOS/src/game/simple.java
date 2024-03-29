

package game;



public class simple extends board {
	
	public simple(int size) {
		super(size);
	}
	
	public void checkForWin() {
		int pointsToWin = 1; 
		int maxPossibleMoves = size * size;
		
		if(bluePoints >= pointsToWin)
			currentGameState = GameState.B_WON;
		else if (redPoints >= pointsToWin)
			currentGameState = GameState.R_WON;
		else if (totalMoves < maxPossibleMoves)
			currentGameState = GameState.PLAYING;
		else currentGameState = GameState.DRAW;
	}
}