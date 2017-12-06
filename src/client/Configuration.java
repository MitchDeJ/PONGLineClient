package client;

public class Configuration {
	
	/*logger prefix*/
	public String logPrefix = "CLIENT";

	/*host config*/
	public String hostName = "localhost";
	public int hostPort = 1337;

	public int windowWidth = 640;
	public int windowHeight = 480;
	public String windowName = "PONGLine";
	
	//the amount of ticks to wait before we send a movement update
	public int moveTicks = 0; 
	
}
