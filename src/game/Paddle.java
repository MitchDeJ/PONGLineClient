package game;

import java.awt.Graphics;

import client.net.packets.types.Packet;
import client.net.packets.types.Packet03Move;

public class Paddle {

	private Game game;
	
	private int x = 20;
	private int y = 100;
	private int lastY = y;
	private int width = 8;
	private int height = 60;
	private int moveUpdate = 0;
	
	private Packet packet;
	
	private boolean player;
	
	public Paddle(Game game) {
		this.game = game;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return y;
	}
	
	public int getY() {
		return y;
	}
	
	public void render(Graphics g) {
		g.fillRect(x, y, width, height);
	}
	
	public void tick() {
		if (player) {
			if (moveUpdate == game.getConfig().moveTicks) {
				if (lastY != y) {
					packet = new Packet03Move(y);
					game.getClient().getConnection().sendData(packet.getData());
					moveUpdate = 0;
				}
			} else {
			moveUpdate++;
			}
		}
		
		lastY = y;
	}
	
	public void setPlayerControlled(boolean b) {
		this.player = b;
	}

	public boolean playerControlled() {
		return player;
	}

	public void move(int diff) { //TODO change 480 naar window height
		diff = diff-480;
		if (this.y + diff < 0) {
			this.y = 0;
		return;	
		}
		if (this.y + diff > 480) {
			this.y = 480;
		return;	
		}
		this.y += diff;
	}
}
