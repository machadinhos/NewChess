package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DraggableSquare extends JFrame {
	
	private final int initialX;
	private final int initialY;
	private int squareX;
	private int squareY;
	private int mouseX;
	private int mouseY;
	private boolean isDragging;
	
	
	public static void main (String[] args) {
		
		SwingUtilities.invokeLater(DraggableSquare::new);
	}
	
	
	public DraggableSquare () {
		
		setTitle("Draggable Square");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(null); // Remove the frame icon
		
		squareX = 100;
		squareY = 100;
		initialX = squareX;
		initialY = squareY;
		isDragging = false;
		
		JPanel panel = new JPanel() {
			
			@Override
			protected void paintComponent (Graphics g) {
				
				super.paintComponent(g);
				
				// Draw the blue square
				g.setColor(Color.BLUE);
				g.fillRect(squareX, squareY, 50, 50);
				
				// Draw the mouse coordinates
				g.setColor(Color.BLACK);
				g.drawString("Mouse coordinates: (" + mouseX + ", " + mouseY + ")", 10, 20);
			}
		};
		
		panel.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed (MouseEvent e) {
				
				int x = e.getX();
				int y = e.getY();
				
				// Check if the mouse is within the square
				if (x >= squareX && x < squareX + 50 && y >= squareY && y < squareY + 50) {
					isDragging = true;
					mouseX = x;
					mouseY = y;
					
					setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
				}
			}
			
			
			@Override
			public void mouseReleased (MouseEvent e) {
				
				isDragging = false;
				//squareX = initialX; // isto buga mas vai ser necessário arredondar à casa mais proxima
				//squareY = initialY;
				
				// Check if the mouse is within the square and set the cursor accordingly
				if (mouseX >= squareX && mouseX < squareX + 50 && mouseY >= squareY && mouseY < squareY + 50) {
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				} else {
					setCursor(Cursor.getDefaultCursor());
				}
				
				panel.repaint();
			}
		});
		
		panel.addMouseMotionListener(new MouseAdapter() {
			
			@Override
			public void mouseDragged (MouseEvent e) {
				
				if (isDragging) {
					int newSquareX = squareX + e.getX() - mouseX;
					int newSquareY = squareY + e.getY() - mouseY;
					
					// Check if the new square position is within the screen boundaries
					if (newSquareX >= 0 && newSquareX <= panel.getWidth() - 50 && newSquareY >= 0 && newSquareY <= panel.getHeight() - 50) {
						squareX = newSquareX;
						squareY = newSquareY;
						mouseX = e.getX();
						mouseY = e.getY();
						panel.repaint();
					}
				} else {
					mouseX = e.getX();
					mouseY = e.getY();
					panel.repaint();
					
					// Check if the mouse is within the square and set the cursor accordingly
					if (mouseX >= squareX && mouseX < squareX + 50 && mouseY >= squareY && mouseY < squareY + 50) {
						setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					} else {
						setCursor(Cursor.getDefaultCursor());
					}
				}
			}
			
			
			@Override
			public void mouseMoved (MouseEvent e) {
				
				mouseX = e.getX();
				mouseY = e.getY();
				
				// Check if the mouse is within the square and set the cursor accordingly
				if (mouseX >= squareX && mouseX < squareX + 50 && mouseY >= squareY && mouseY < squareY + 50) {
					setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				} else {
					setCursor(Cursor.getDefaultCursor());
				}
				
				panel.repaint();
			}
		});
		
		panel.setPreferredSize(new Dimension(500, 500));
		setContentPane(panel);
		pack();
		setLocationRelativeTo(null); // Center the frame on the screen
		setVisible(true);
	}
	
}
