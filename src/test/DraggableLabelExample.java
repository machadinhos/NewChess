package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DraggableLabelExample {
	
	public static void main (String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run () {
				
				createAndShowGUI();
			}
		});
	}
	
	
	private static void createAndShowGUI () {
		
		JFrame frame = new JFrame("Draggable Label Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create a panel to hold the label
		JPanel panel = new JPanel();
		panel.setLayout(null); // Use null layout to manually position the label
		
		// Create a label
		JLabel label = new JLabel("Drag me!");
		label.setBounds(50, 50, 100, 50); // Set the initial position and size of the label
		
		// Add mouse listeners to the label
		label.addMouseListener(new MouseAdapter() {
			
			public void mousePressed (MouseEvent e) {
				// Get the initial position of the label
				label.getParent().setComponentZOrder(label, 0); // Bring the label to the front
				label.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
				label.setLocation(label.getX() + e.getX(), label.getY() + e.getY());
			}
			
			
			public void mouseReleased (MouseEvent e) {
				
				label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			}
		});
		
		label.addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseDragged (MouseEvent e) {
				// Calculate the new position of the label based on the mouse movement
				int x = label.getX() + e.getX();
				int y = label.getY() + e.getY();
				label.setLocation(x, y);
			}
			
			
			@Override
			public void mouseMoved (MouseEvent e) {
				
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				System.out.println("label");
			}
		});
		
		// Add the label to the panel
		panel.add(label);
		
		JLabel label1 = new JLabel("Drag me!");
		label1.setBounds(100, 100, 100, 50); // Set the initial position and size of the label
		
		// Add mouse listeners to the label
		label1.addMouseListener(new MouseAdapter() {
			
			public void mousePressed (MouseEvent e) {
				// Get the initial position of the label
				label1.getParent().setComponentZOrder(label, 0); // Bring the label to the front
				label1.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
				label1.setLocation(label.getX() + e.getX(), label.getY() + e.getY());
			}
			
			
			public void mouseReleased (MouseEvent e) {
				
				label1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				System.out.println("label1");
			}
		});
		
		label1.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged (MouseEvent e) {
				// Calculate the new position of the label based on the mouse movement
				int x = label1.getX() + e.getX();
				int y = label1.getY() + e.getY();
				label1.setLocation(x, y);
			}
			
			
			@Override
			public void mouseMoved (MouseEvent e) {
				
				label1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				System.out.println("label1");
			}
			
		});
		
		panel.add(label1);
		
		frame.getContentPane().add(panel);
		frame.setSize(400, 300);
		frame.setVisible(true);
	}
	
}
