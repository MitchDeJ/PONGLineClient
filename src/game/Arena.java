package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *	An Arena is an instance of an ongoing match
 */

public class Arena {
	 
	public List<Paddle> paddles = new ArrayList<Paddle>();
	public Ball ball = new Ball();
	private Game game;
	
	public Arena(Game game) {
		this.game = game;
		paddles.add(new Paddle(game));
		paddles.add(new Paddle(game));
		paddles.get(0).setPlayerControlled(true);
		paddles.get(1).setX(620);
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < paddles.size(); i++) { //render all paddles
			paddles.get(i).render(g);
		}
		ball.render(g);
	}

	public Paddle getPlayerPaddle() {
		for (int i = 0; i < paddles.size(); i++) {
			if (paddles.get(i).playerControlled()) {
				return paddles.get(i);
			}
		}
		return null;
	}
	
	public Paddle getPaddle(int i) {
		return paddles.get(i);
	}

	public void tick() {
		for(int i = 0; i < paddles.size(); i++) {
			paddles.get(i).tick();
		}
	}
}
