package client.net.packets.types;

public class Packet01Login extends Packet {

	private String username;
	private String password;

	public Packet01Login(String username, String password) {
		super(01);
		this.username = username;
		this.password = password;
	}

	@Override
	public byte[] getData() {
		String[] data = {username, password};
		return packetData(data).getBytes();
	}

}
