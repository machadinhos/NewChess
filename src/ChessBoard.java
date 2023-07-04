import elements.GameElement;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;


public class ChessBoard extends Canvas implements PropertyChangeListener {

	private final Container pieceLayer;
	private GameElement[][] board;
	private final JFrame backgroundFrame;

	//private final Image background; //preciso se usarmos a imagem do board em vez de desenhar

	private final int RECTSIZE = 50; //em pixeis
	public ChessBoard() {

		JLayeredPane layers = new JLayeredPane();
		backgroundFrame = new JFrame("ChessBoard");
		backgroundFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		layers.add(backgroundFrame);

		pieceLayer = new Container();
		layers.add(pieceLayer);

		//background = new ImageIcon(Objects.requireNonNull(getClass().getResource("board.png"))).getImage();
		Game game = new Game();
		game.addObserver(this);
		board = game.getBoard();

		drawBoard();
		updateBoard();
	}


	private void drawBoard() {
		boolean isBlack = true;

		for (int i = 0; i < 64; i++) {
			JPanel square = new JPanel(new BorderLayout());

			if (isBlack) {
				square.setBackground(Color.BLACK);
			} else {
				square.setBackground(Color.WHITE);
			}

			backgroundFrame.add(square);
			isBlack = !isBlack;
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

					JPanel panel = new JPanel() {

						@Override
						protected void paintComponent (Graphics g) {

							super.paintComponent(g);

							g.drawImage(board[i][j].getImage(),i* RECTSIZE,j* RECTSIZE,this);
						}

					};

					pieceLayer.add(panel);

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
