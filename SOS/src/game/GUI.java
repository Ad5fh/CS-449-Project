package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import game.board.Cell;
import game.board.GameState;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {
    
	public static int CELL_SIZE = 100; 									
	public static final int GRID_WIDTH = 2; 					
	public static final int GRID_WIDHT_HALF = GRID_WIDTH / 2;	
	public static final int CELL_PADDING = CELL_SIZE / 6;		
	public static final int SYMBOL_SIZE = CELL_SIZE - CELL_PADDING * 2;
	public static final int SYMBOL_STROKE_WIDTH = 8;
	
    public static JRadioButton blueO;							
    public static JRadioButton redO;		
    public static JRadioButton redS;							
    public static JRadioButton blueS;
	
	private board game;
    private GameBoardCanvas gameBoardCanvas; 					
    private JLabel gameStatusBar;								
    private JTextField boardSize;
    private Graphics graph; 									
    private ButtonGroup gameMode; 
    public GUI() {
    	this(new simple(3));
    }

    public GUI(board game) {

        this.game = game;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 637, 456);
        this.setLayout(null);
        this.setTitle("SOS Game");

        JLabel sosLabel = new JLabel("SOS");
        sosLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        sosLabel.setBounds(22, 19, 33, 13);
        this.add(sosLabel);

        JRadioButton simpleGame = new JRadioButton("Simple Game");
        simpleGame.setFont(new Font("Helvetica", Font.PLAIN, 16));
        simpleGame.setBounds(61, 15, 125, 21);
        simpleGame.setFocusable(false);
        simpleGame.setActionCommand("Simple Game");
        simpleGame.setSelected(true);
        this.add(simpleGame);

        JRadioButton generalGame = new JRadioButton("General Game");
        generalGame.setFont(new Font("Helvetica", Font.PLAIN, 16));
        generalGame.setBounds(188, 15, 136, 21);
        generalGame.setFocusable(false);
        generalGame.setActionCommand("General Game");
        generalGame.setSelected(false);
        this.add(generalGame);
        
        gameMode = new ButtonGroup();
        gameMode.add(simpleGame);
        gameMode.add(generalGame);
        
        JLabel bsLabel = new JLabel("Board Size");
        bsLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        bsLabel.setBounds(451, 19, 93, 13);
        this.add(bsLabel);
        
        boardSize = new JTextField();
        boardSize.setFont(new Font("Helvetica", Font.BOLD, 16));
        boardSize.setColumns(10);
        boardSize.setBackground(Color.WHITE);
        boardSize.setBounds(554, 12, 45, 26);
        boardSize.addActionListener(this);
        this.add(boardSize);

        JLabel bpLabel = new JLabel("Blue Player");
        bpLabel.setFont(new Font("Helvetica", Font.BOLD, 13));
        bpLabel.setBounds(20, 100, 150, 25);
        this.add(bpLabel);
		
		
	   
	    
        new ButtonGroup();
       
        
	    
        blueS = new JRadioButton("S");
        blueS.setFont(new Font("Helvetica", Font.PLAIN, 16));
        blueS.setBounds(35, 170, 50, 25);
        blueS.setFocusable(false);
        blueS.addActionListener(this);
        blueS.setSelected(true);
        this.add(blueS);

        blueO = new JRadioButton("O");
        blueO.setFont(new Font("Helvetica", Font.PLAIN, 16));
        blueO.setBounds(35, 190, 50, 25);
        blueO.setFocusable(false);
        blueO.addActionListener(this);
        this.add(blueO);
        
        ButtonGroup bluePlayer = new ButtonGroup();
        bluePlayer.add(blueS);
        bluePlayer.add(blueO);
        
        JLabel rpLabel = new JLabel("Red Player");
        rpLabel.setFont(new Font("Helvetica", Font.BOLD, 13));
        rpLabel.setBounds(520, 100, 150, 25);
        this.add(rpLabel);
	    
	    
        new ButtonGroup();
        
	     
        redS = new JRadioButton("S");
        redS.setFont(new Font("Helvetica", Font.PLAIN, 16));
        redS.setBounds(520, 170, 150, 25);
        redS.setFocusable(false);
        redS.addActionListener(this);
        redS.setSelected(true);
        this.add(redS);

        redO = new JRadioButton("O");
        redO.setFont(new Font("Helvetica", Font.PLAIN, 16));
        redO.setBounds(520, 190, 150, 25);
        redO.setFocusable(false);
        redO.addActionListener(this);
        this.add(redO);
        
        ButtonGroup redPlayer = new ButtonGroup();
        redPlayer.add(redS);
        redPlayer.add(redO);
        
        JLabel ctLabel = new JLabel("Current Turn:");
        ctLabel.setFont(new Font("Helvetica", Font.PLAIN, 16));
        ctLabel.setBounds(185, 381, 101, 13);
        this.add(ctLabel);
        
        JButton newGame = new JButton("New Game");
		newGame.setFont(new Font("Tahoma", Font.PLAIN, 16));
		newGame.setBounds(501, 366, 112, 26);
		newGame.setFocusable(false);
		newGame.addActionListener(this);
		this.add(newGame);
        

        setContentPane();
        this.setVisible(true);
    }

    private void setContentPane() {
        gameBoardCanvas = new GameBoardCanvas();
        gameBoardCanvas.setPreferredSize(new Dimension(CELL_SIZE * game.size, CELL_SIZE * game.size));
        gameBoardCanvas.setBounds(150, 70, 300, 300);

        gameStatusBar = new JLabel();
        gameStatusBar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        gameStatusBar.setBounds(285, 381, 150, 15);

        Container contentPane = getContentPane();
        contentPane.add(gameBoardCanvas);
        contentPane.add(gameStatusBar);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand().equals("New Game")) {
    		int size = Integer.parseInt(boardSize.getText());
            String mode = gameMode.getSelection().getActionCommand();
            if (validSize(size)) {
                if(mode.equals("General Game")) {
                    JOptionPane.showMessageDialog(null, "You choose to play a general game");
                    game = new general(size);
                }
                else if (mode.equals("Simple Game")) {
                    JOptionPane.showMessageDialog(null, "You choose to play a simple game");
                    game = new simple(size);                    	
                }                          
                CELL_SIZE = 300 / game.size;
                gameBoardCanvas.paintComponent(graph);
                gameBoardCanvas.revalidate();
                gameBoardCanvas.repaint();
            }
            else {
                JOptionPane.showMessageDialog(boardSize, "Sorry, your board size should be from 3-10", "Invalid game size", JOptionPane.ERROR_MESSAGE);
            }
    	}
    }

    public boolean validSize(int size) {
        return size >= 3 && size <= 10;
    }
    
    class GameBoardCanvas extends JPanel {

        GameBoardCanvas() {
            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int rowSelected = e.getY() / CELL_SIZE;
                    int colSelected = e.getX() / CELL_SIZE;
                    if (game.getGameState() == GameState.PLAYING) {
                    	game.makeMove(rowSelected, colSelected);
                    }
                    else {
                        game.initBoard();
                    }
                    repaint();
                }
             });
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.PINK);
            drawGridLines(g);
            drawBoard(g);
            graph = g; 
            printStatusBar();
            
        }

        private void drawGridLines(Graphics g) {
            g.setColor(Color.BLACK);
            for (int row = 1; row < game.size + 1; row++) {
            	g.fillRoundRect(0, CELL_SIZE * row - GRID_WIDHT_HALF, 
            			CELL_SIZE * game.size - 1, GRID_WIDTH, GRID_WIDTH, GRID_WIDTH);
            }
            for (int col = 1; col < game.size+ 1; col++) {
                g.fillRoundRect(CELL_SIZE * col - GRID_WIDHT_HALF, 0, GRID_WIDTH,
						CELL_SIZE * game.size - 1, GRID_WIDTH, GRID_WIDTH);
            }
        }
       
        private void drawBoard(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            for (int row = 0; row < game.size; row++) {
                for (int col = 0; col < game.size; col++) {
                    int x1 = col * CELL_SIZE + CELL_PADDING;
					int y2 = (row + 1) * CELL_SIZE - CELL_PADDING;
					if (game.getCell(row, col) == Cell.S) {
                        g2d.setColor(Color.black);
                        g2d.setFont(new Font("Comic Sans", Font.BOLD, 20));
                        g2d.drawString("S", x1, y2);   
                    } else if (game.getCell(row, col) == Cell.O) {
                        g2d.setColor(Color.black);
                        g2d.setFont(new Font("Comic Sans", Font.BOLD, 20));
                        g2d.drawString("O", x1, y2);
                    }
                }
            }
        }
        
        } 
        private void printStatusBar() {
            if (game.getGameState() == GameState.PLAYING) {
                gameStatusBar.setForeground(Color.BLACK);
                if (game.getTurn() == 'B') {
                    gameStatusBar.setText("Blue Player's Turn");
                } else {
                    gameStatusBar.setText("Red Player's Turn");
                }
            } 
        }
   
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI();
            }
        });
    }
}