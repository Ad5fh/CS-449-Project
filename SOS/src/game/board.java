package game;


public class board {
    
    public int size;
    public enum Cell {EMPTY, S, O}
    public enum GameState {PLAYING}
    public static GameState currentGameState;
   
    protected Cell[][] grid;
    protected char turn;
    protected int totalMoves, bluePoints, redPoints;
    
    public board(int size) {
    	this.size = size;
        initBoard();
    }
    public void initBoard() {
        grid = new Cell[size][size];

        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                grid[row][col] = Cell.EMPTY;
            }
        }      
        currentGameState = GameState.PLAYING;
        turn = 'B';
        totalMoves = 0;
        bluePoints = 0;
        redPoints = 0;
    }
    public Cell getCell(int row, int column) {
        if (row >= 0 && row < size && column >= 0 && column < size) {
            return grid[row][column];
        } else {
            return null;
        }
    }
    public void setCell(int row, int column, Cell cell) {
        if (row >= 0 && row < size && column >= 0 && column < size) {
            grid[row][column] = cell;
        }
    }   
    public char getTurn() {
        return turn;
    }	  
    public void setTurn(char t) {
		t = turn;
	}
    public GameState getGameState() {
        return currentGameState;
    }   
    public boolean makeMove(int row, int column) {
        Cell cell = getCell(row, column);
        if(cell != Cell.EMPTY){
            return false;
        }
        totalMoves += 1;
        int prevBPoints = 0;
        int prevRPoints = 0;
        if (turn == 'B') {
            if (GUI.blueS.isSelected()) {
                setCell(row, column, Cell.S);
            } else if (GUI.blueO.isSelected()){
                setCell(row, column, Cell.O);
            }
            prevBPoints = bluePoints;
            
            if (prevBPoints == bluePoints) {
        		switchTurn();
        	}
        	else if (prevBPoints < bluePoints) {
        		doNotSwitchTurn();
            	prevBPoints += bluePoints;
        	}
        } 
        else if (turn == 'R'){
            if (GUI.redS.isSelected()) {
                setCell(row, column, Cell.S);
            } else if (GUI.redO.isSelected()) {
                setCell(row, column, Cell.O);
            }
            prevRPoints = redPoints;
            
            if (prevRPoints < redPoints) {
        		doNotSwitchTurn();
        	}
        	else if (prevRPoints == redPoints) {
        		switchTurn();
            	prevRPoints += redPoints;
        	}
        }       
        return true;
    } 	
    public void doNotSwitchTurn() {
    	if (turn =='B')
    		turn ='B';	
    	else if (turn =='R')
    		turn ='R';
    }    
    public void switchTurn() {
    	if (turn == 'B') 
    		turn ='R';
    	else if(turn =='R')
    		turn ='B';
    }     
}