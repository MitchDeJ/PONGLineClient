package client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import client.Client;
import client.net.packets.types.Packet;
import client.net.packets.types.Packet01Login;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class LoginWindow extends GUIWindow {

	private Client client;
	
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 * @param client 
	 */
	public LoginWindow(Client client) {
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
		frame.getContentPane().setFont(new Font("Myanmar Text", Font.PLAIN, 11));
		frame.setTitle("PONGLine Auth");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(142, 73, 151, 30);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(48, 43, 124, 91);
		frame.getContentPane().add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 130, 151, 30);
		frame.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(48, 138, 117, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Packet packet = new Packet01Login(usernameField.getText(), passwordField.getText());
				packet.sendData(client.getConnection());
			}
		});
		loginButton.setBounds(107, 194, 89, 23);
		frame.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				frame.setEnabled(false);
				client.window = new RegisterWindow(client);
			}
		});
		registerButton.setBounds(227, 194, 89, 23);
		frame.getContentPane().add(registerButton);
	}
}
