package game.graphics;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class GameWindow {
	
	private JFrame frame;
	
	public GameWindow(int w, int h, String title, Renderer renderer) {
		
		renderer.setPreferredSize(new Dimension(w, h));
		renderer.setMinimumSize(new Dimension(w, h));		
		renderer.setMaximumSize(new Dimension(w, h));	
		
		frame = new JFrame(title);
		frame.add(renderer);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// Transparent 16 x 16 pixel cursor image.
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

		// Create a new blank cursor.
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");

		// Set the blank cursor to the JFrame.
		frame.getContentPane().setCursor(blankCursor);
	}
	
	public JFrame getFrame() {
		return frame;
	}

}
