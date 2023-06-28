package test;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ImageFrame {
	
	private final JFrame frame;
//	private final JLabel label;
	private final Image imageIcon;
	
	
	public ImageFrame () {
		
		frame = new JFrame("Image");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("board.png"))).getImage();
		
		ImageIcon imageIcon1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("bB.png")));
		
		JLabel label = new JLabel(imageIcon1);
		
//		JPanel panel = new JPanel();
		
		JPanel panel = new JPanel() {

			@Override
			protected void paintComponent (Graphics g) {
				super.paintComponent(g);

				g.drawImage(imageIcon, 0, 0, this);
			}

		};
		
		
		panel.setLayout(new GridLayout(0, 8));
		
		panel.add(label);

		panel.setPreferredSize(new Dimension(724, 724));
		
		frame.add(panel);
		
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	
	public static void main (String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run () {
				new ImageFrame();
			}
		});
	}
	
}
