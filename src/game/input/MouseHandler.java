package game.input;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

import game.Game;

public class MouseHandler {
	
	private Game game;
	private Robot robot;
	
	public MouseHandler(Game game) {
		this.game = game;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void resetMouse() {
		game.getArena().getPlayerPaddle().move(getMouseDiff());
		centerMouse();
	}

	private int getMouseDiff() {
		 return (MouseInfo.getPointerInfo().getLocation().y -
		game.getWindow().getFrame().getY()+game.getConfig().windowHeight/2);
	}

	private void centerMouse() {
		robot.mouseMove(game.getWindow().getFrame().getX()+game.getConfig().windowWidth/2,
				game.getWindow().getFrame().getY()+game.getConfig().windowHeight/2);
	}
}
