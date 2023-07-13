import elements.GameElement;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;


public class ChessBoard implements PropertyChangeListener {

	private final JFrame frame;
	private final JPanel backgroundPanel;
	private final JPanel piecesPanel;
	private final JLayeredPane layers;
	private GameElement[][] board;

	//private final Image background; //preciso se usarmos a imagem do board em vez de desenhar

	private static final int RECTSIZE = 70; //em pixeis
	public ChessBoard() {
		this.frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(RECTSIZE*10, RECTSIZE*10));
		frame.setLayout(new FlowLayout());
		frame.setTitle("Chess Board");
		frame.setVisible(true);


		this.layers = new JLayeredPane();
		layers.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.setContentPane(layers);


		this.backgroundPanel = new JPanel();
		backgroundPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		backgroundPanel.setLayout(new GridLayout(8, 8));
		backgroundPanel.setVisible(true);
		backgroundPanel.setOpaque(false);
		drawBoard();
		layers.add(backgroundPanel, 1);

		this.piecesPanel = new JPanel();
		//piecesPanel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		piecesPanel.setLayout(new FlowLayout());
		piecesPanel.setVisible(true);
		piecesPanel.setOpaque(false);


		Game game = new Game();
		game.addObserver(this);
		board = game.getBoard();
		updateBoard();
		layers.add(piecesPanel, 2);



	}


	private void drawBoard() {
		boolean isBlack = true;

		for (int i = 0; i < 8; i++) {
			isBlack = !isBlack;
			for (int j = 0; j < 8; j++) {
				JPanel square = new JPanel();
				square.setOpaque(true);

				if (isBlack) {
					square.setBackground(Color.BLACK);
				} else {
					square.setBackground(Color.WHITE);
				}

				square.setBounds((i) * RECTSIZE, (j) * RECTSIZE, RECTSIZE, RECTSIZE);

				backgroundPanel.add(square);

				isBlack = !isBlack;
			}

		}
	}




	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		board = (GameElement[][]) evt.getNewValue();
		updateBoard();
	}

	private void updateBoard() {
		for (int i=0;i< board.length;i++) {
			for (int j=0;j<board[0].length;j++) {
				if (board[i][j]!=null) {
					int finalI = i;
					int finalJ = j;

					JPanel panel = new JPanel() {

						@Override
						protected void paintComponent (Graphics g) {

							super.paintComponent(g);

							g.drawImage(board[finalI][finalJ].getImage(), finalI*RECTSIZE, finalJ* RECTSIZE, null);
						}

					};

					piecesPanel.add(panel);

				}
			}
		}
	}


	//cada vez que há clique, colocar circulos no board, atualizar o tabuleiro

	//cada vez que larga o clique, apagar os circulos do board, atualizar o tabuleiro

	//mas nao acho bem esta classe mexer no [][] board e tb nao acho que a Game deva verificar cliques....

	//talvez se conseguirmos um listener intrinseco a cada peça e aparecer nesta classe já o retorno da lista de circulos

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new ChessBoard());
	}

}
