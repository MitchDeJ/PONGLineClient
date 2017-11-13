package client.net.packets;

import java.awt.Color;
import java.net.InetAddress;
import java.util.ArrayList;

import client.Client;
import client.net.packets.types.Packet;
import client.net.packets.types.Packet.PacketTypes;

public class PacketParser {

	private Client client;

	public PacketParser(Client client) {
		this.client = client;
	}

	public void parsePacket(byte[] data, InetAddress address, int port) {

		String message = new String(data).trim();
		PacketTypes type = Packet.lookupPacket(message.substring(0, 2));
		switch (type) {
		case INVALID:
			client.log("Received an invalid packet!");
			break;
		default:
			client.log("Received an unhandled packet!");
			break;
		}

	}

	private String parseMessageIndex(String message, int index) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		char divider = ';';
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) == divider) {
				list.add(i);
			}
		}
		int[] div = new int[list.size()];

		for (int i = 0; i < div.length; i++) {
			div[i] = list.get(i).intValue();
		}

		return message.substring(div[index] + 1, div[index + 1]);
	}

}
