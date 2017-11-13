package client.net.packets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import client.Client;

public class PacketReceiver extends Thread {
	
	private DatagramSocket socket;
	private Client client;

	public PacketReceiver(Client client) {
		this.client = client;
		this.socket = client.getConnection().getSocket();
	}
	
	public void receive() {
       	byte[] data = new byte[1024];
    	DatagramPacket packet = new DatagramPacket(data, data.length);
    	try {
    		socket.receive(packet);
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	
    	 client.getPacketParser().parsePacket(packet.getData(), packet.getAddress(), packet.getPort());
	}

	public void run() {
		while (true) {
			receive();
		}
	}

}
