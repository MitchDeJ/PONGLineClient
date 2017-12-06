package game;

import java.awt.Graphics;

public class Ball {
	
	private int x = 300;
	private int y = 200;
	private int size = 10;

	
	public void render(Graphics g) {
		g.fillRect(x-(size/2), y-(size/2), size, size);
	}
}
