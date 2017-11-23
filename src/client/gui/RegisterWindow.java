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

public class RegisterWindow {
	
	private Client client;

	private JFrame frmPongline;
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
		frmPongline.setTitle("PONGLine Auth");
		frmPongline.setBounds(100, 100, 450, 300);
		frmPongline.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPongline.getContentPane().setLayout(null);
		
		emailField = new JTextField();
		emailField.setBounds(142, 58, 151, 30);
		frmPongline.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setBounds(48, 46, 108, 54);
		frmPongline.getContentPane().add(emailLabel);	
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 99, 151, 30);
		frmPongline.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(48, 107, 108, 14);
		frmPongline.getContentPane().add(lblPassword);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Packet packet = new Packet00Register(emailField.getText(), usernameField.getText(), passwordField.getText(), confirmField.getText());
				packet.sendData(client.getConnection());
			}
		});
		registerButton.setBounds(167, 194, 89, 23);
		frmPongline.getContentPane().add(registerButton);
		
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		usernameField.setBounds(142, 16, 151, 30);
		frmPongline.getContentPane().add(usernameField);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(48, 16, 89, 31);
		frmPongline.getContentPane().add(lblNewLabel);
		
		confirmField = new JPasswordField();
		confirmField.setBounds(142, 140, 151, 30);
		frmPongline.getContentPane().add(confirmField);
		
		JLabel lblConfirmPass = new JLabel("Confirm Pass");
		lblConfirmPass.setBounds(48, 148, 132, 14);
		frmPongline.getContentPane().add(lblConfirmPass);
		
		JButton backButton = new JButton("<<");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPongline.setVisible(false);
				frmPongline.setEnabled(false);
				new LoginWindow(client);
			}
		});
		backButton.setBounds(48, 194, 49, 23);
		frmPongline.getContentPane().add(backButton);
	}
}
