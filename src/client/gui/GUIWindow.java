package client.gui;

import javax.swing.JFrame;

public class GUIWindow {
	
	protected JFrame frame;
	
	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}

}
