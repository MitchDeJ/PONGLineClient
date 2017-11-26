package client;

import client.gui.GUIWindow;
import client.gui.LoginWindow;
import client.net.ServerConnection;
import client.net.packets.PacketParser;
import client.net.packets.PacketReceiver;
import client.net.packets.types.Packet;
import client.net.packets.types.Packet02Quit;


public class Client implements Runnable {
	
	Configuration config = new Configuration();
	
	/*networking*/
	private ServerConnection connection;
	private PacketReceiver packetReceiver;
	private PacketParser packetParser;

	private Thread thread;
	private boolean running = false;
	
	private ClientState state = ClientState.AUTH;
	public GUIWindow window;
	
	public static void main(String args[]) {
		new Client().start();
	}

	
	public void init() {
		 connection = new ServerConnection(config.hostName, config.hostPort);
		 packetReceiver = new PacketReceiver(this);
		 packetReceiver.start();
		 packetParser = new PacketParser(this);
		 addShutdownHook();
		 log("Initialized.");
	}
	
	public void addShutdownHook() {
		 Runtime.getRuntime().addShutdownHook(new Thread() {
		      public void run() {
		        if (state == ClientState.INGAME || state == ClientState.LOGGEDIN)
		        {
		        	Packet packet = new Packet02Quit();
		        	packet.sendData(connection);
		        }
		      }
		    });
	}

	public void run() {
		init();
		window = new LoginWindow(this);
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
	
	public ClientState getState() {
		return state;
	}
	
	public void setState(ClientState state) {
		this.state = state;
	}

}
