package game.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import client.Configuration;
import game.Game;

public class Renderer extends Canvas {
	
	private static final long serialVersionUID = 6228751610580176430L;
	private Game game;
	private BufferStrategy bufferStrat;
	private Graphics g;
	private Configuration config;
	
	public Renderer(Game game) {
		this.game = game;
		this.config = game.getConfig();
	}

	public void render() {
		bufferStrat = this.getBufferStrategy();
		if (bufferStrat == null) {
			this.createBufferStrategy(3);
			return;
		}

		g = bufferStrat.getDrawGraphics();

		/* RENDERING CODE */
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, config.windowWidth+100, config.windowHeight+100); //temporary +100 TODO
		g.setColor(Color.WHITE);
		game.getArena().render(g);
		/* END OF RENDERING CODE */
		
		g.dispose();
		bufferStrat.show();
	}

}
