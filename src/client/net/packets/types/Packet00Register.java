package client.net.packets.types;

public class Packet00Register extends Packet{

	private String username;
	private String password;
	private String email;

	public Packet00Register(String username, String password, String email) {
		super(00);
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@Override
	public byte[] getData() {
		String[] data = new String[] {username, password, email};
		return packetData(data).getBytes();
	}

}
