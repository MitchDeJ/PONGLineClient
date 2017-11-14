package client;

import client.gui.LoginWindow;
import client.net.ServerConnection;
import client.net.packets.PacketParser;
import client.net.packets.PacketReceiver;


public class Client implements Runnable {
	
	Configuration config = new Configuration();
	
	/*networking*/
	private ServerConnection connection;
	private PacketReceiver packetReceiver;
	private PacketParser packetParser;

	private Thread thread;
	private boolean running = false;

	
	public Client() { }
	
	public static void main(String args[]) {
		new Client().start();
	}

	
	public void init() {
		log("Initializing...");
		 long start = System.currentTimeMillis() / 1000L;
		 connection = new ServerConnection(config.hostName, config.hostPort);
		 packetReceiver = new PacketReceiver(this);
		 packetReceiver.start();
		 packetParser = new PacketParser(this);
		 long finish = System.currentTimeMillis() / 1000L;
		 log("Initialized in "+(start-finish)+" miliseconds.");
	}

	public void run() {
		init();
		LoginWindow window = new LoginWindow();
				
		//packet = new Packet00Register("admin", "admin123", "admin@admin.com");
		//packet.sendData(getConnection());
		
		//packet = new Packet01Login("admin", "admin123");
		//packet.sendData(getConnection());
	}

	public synchronized void start() {
		if (running)
			return; // cancel if already running

		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void log(String message) {
		System.out.println("["+config.logPrefix+"] > "+message);
	}
	
	public Configuration getConfig() {
		return config;
	}
	
	public ServerConnection getConnection() {
		return connection;
	}
	
	public PacketParser getPacketParser() {
		return packetParser;
	}

}
