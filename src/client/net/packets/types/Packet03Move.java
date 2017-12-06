package client.net.packets.types;

public class Packet03Move extends Packet {

	private int y;

	public Packet03Move(int y) {
		super(03);
		this.y = y;
	}

	@Override
	public byte[] getData() {
		String[] data = {""+y};
		return packetData(data).getBytes();
	}

}
