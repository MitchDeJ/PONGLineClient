package client.net.packets.types;

public class Packet00Register extends Packet{

	private String username;
	private String password;
	private String email;
	private String confirm;

	public Packet00Register(String email, String username, String password, String confirm) {
		super(00);
		this.username = username;
		this.password = password;
		this.confirm = confirm;
		this.email = email;
	}

	@Override
	public byte[] getData() {
		String[] data = new String[] {email, username, password, confirm};
		return packetData(data).getBytes();
	}

}
