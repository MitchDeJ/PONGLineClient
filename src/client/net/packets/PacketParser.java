package client.net.packets;

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
		//client.log(message);
		PacketTypes type = Packet.lookupPacket(message.substring(0, 2));
		int status;
		Packet packet;
		switch (type) {
		case LOGINSTATUS:
			status = Integer.parseInt(parseIndex(message, 0));
			if (status == 1) {
				client.log("Logged in!");
			} else if (status == 0) {
				client.log("Incorrect password.");
			} else if (status == -1) {
				client.log("User with that username doesn't exist.");
			}
			break;
		case REGISTERSTATUS:
			status = Integer.parseInt(parseIndex(message, 0));
			if (status == 1) {
				client.log("Registered!");
			} else if (status == 0) {
				client.log("Username not available.");
			} else if (status == 2) {
				client.log("Email already in use.");
			} else if (status == 3) {
				client.log("Invalid email.");
			} else if (status == 4) {
				client.log("Passwords don't match.");
			}
			break;
		case INVALID:
			client.log("Received an invalid packet!");
			break;
		default:
			client.log("Received an unhandled packet!");
			break;
		}

	}

	private String parseIndex(String message, int index) {

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
