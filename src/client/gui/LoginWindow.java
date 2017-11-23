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

public class LoginWindow {

	private Client client;
	
	private JFrame frmPongline;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 * @param client 
	 */
	public LoginWindow(Client client) {
		initialize();
		frmPongline.setLocationRelativeTo(null);
		frmPongline.setResizable(false);
		frmPongline.setVisible(true);
		this.client = client;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPongline = new JFrame();
		frmPongline.getContentPane().setFont(new Font("Myanmar Text", Font.PLAIN, 11));
		frmPongline.setTitle("PONGLine Auth");
		frmPongline.setBounds(100, 100, 450, 300);
		frmPongline.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPongline.getContentPane().setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(142, 73, 151, 30);
		frmPongline.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(48, 43, 124, 91);
		frmPongline.getContentPane().add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 130, 151, 30);
		frmPongline.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(48, 138, 117, 14);
		frmPongline.getContentPane().add(lblPassword);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Packet packet = new Packet01Login(usernameField.getText(), passwordField.getText());
				packet.sendData(client.getConnection());
			}
		});
		loginButton.setBounds(107, 194, 89, 23);
		frmPongline.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPongline.setVisible(false);
				frmPongline.setEnabled(false);
				new RegisterWindow(client);
			}
		});
		registerButton.setBounds(227, 194, 89, 23);
		frmPongline.getContentPane().add(registerButton);
	}
}
