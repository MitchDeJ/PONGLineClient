package client.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.Client;
import client.net.packets.types.Packet;
import client.net.packets.types.Packet00Register;

public class RegisterWindow extends GUIWindow {
	
	private Client client;

	private JTextField emailField;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JPasswordField confirmField;



	/**
	 * Create the application.
	 * @param client 
	 */
	public RegisterWindow(Client client) {
		initialize();
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.client = client;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("PONGLine Auth");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		emailField = new JTextField();
		emailField.setBounds(142, 58, 151, 30);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setBounds(48, 46, 108, 54);
		frame.getContentPane().add(emailLabel);	
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 99, 151, 30);
		frame.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(48, 107, 108, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Packet packet = new Packet00Register(emailField.getText(), usernameField.getText(), passwordField.getText(), confirmField.getText());
				packet.sendData(client.getConnection());
			}
		});
		registerButton.setBounds(167, 194, 89, 23);
		frame.getContentPane().add(registerButton);
		
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(142, 16, 151, 30);
		frame.getContentPane().add(usernameField);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(48, 16, 89, 31);
		frame.getContentPane().add(lblNewLabel);
		
		confirmField = new JPasswordField();
		confirmField.setBounds(142, 140, 151, 30);
		frame.getContentPane().add(confirmField);
		
		JLabel lblConfirmPass = new JLabel("Confirm Pass");
		lblConfirmPass.setBounds(48, 148, 132, 14);
		frame.getContentPane().add(lblConfirmPass);
		
		JButton backButton = new JButton("<<");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.setEnabled(false);
				client.window = new LoginWindow(client);
			}
		});
		backButton.setBounds(48, 194, 49, 23);
		frame.getContentPane().add(backButton);
	}
}
