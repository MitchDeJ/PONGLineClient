package game;

import client.Client;
import client.Configuration;
import game.graphics.GameWindow;
import game.graphics.Renderer;
import game.input.MouseHandler;

public class Game implements Runnable {

	private Client client;
	private GameWindow window;
	
	private boolean running = false;
	private Thread t;
	private Renderer renderer;
	private MouseHandler mouse;
	private Arena arena;
	private Configuration config;

	public Game(Client client) {
		this.client = client;
	}
	
	public void init() {
		config = client.getConfig();
		arena = new Arena(this);
		renderer = new Renderer(this);// RENDERER HAS TO BE INIT'ED BEFORE THE GAME WINDOW
		mouse = new MouseHandler(this);
		window = new GameWindow(config.windowWidth, config.windowHeight, config.windowName, renderer);
	}

	public void run() {
		init();
		renderer.requestFocus();

		/* Game loop */
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}

			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			renderer.render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frames = 0;
				updates = 0;
			}
		}
		/* end of game loop */
	}
	
	private void tick() {
		mouse.resetMouse();
		getArena().tick();
	}

	public synchronized void start() {
		if (running)
			return;
		
		running = true;
		t = new Thread(this);
		t.start();
	}
	
	public Client getClient() {
		return client;
	}

	public Arena getArena() {
		return arena;
	}

	public Configuration getConfig() {
		return config;
	}
	
	public GameWindow getWindow() {
		return window;
	}

}
