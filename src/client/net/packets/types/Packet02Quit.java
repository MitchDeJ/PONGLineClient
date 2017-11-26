package client.net.packets.types;

public class Packet02Quit extends Packet {


	public Packet02Quit() {
		super(02);
	}

	@Override
	public byte[] getData() {
		String[] data = {""};
		return packetData(data).getBytes();
	}

}
