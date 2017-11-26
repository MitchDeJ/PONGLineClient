package game;

import java.awt.Canvas;

import client.Client;
import client.Configuration;
import game.graphics.GameWindow;

public class Game extends Canvas implements Runnable {

	private Client client;

	public Game(Client client) {
		this.client = client;
		init();
	}
	
	public void init() {
		Configuration config = client.getConfig();
		new GameWindow(config.windowWidth, config.windowHeight, config.windowName, this);
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void start() {
		
	}

}
