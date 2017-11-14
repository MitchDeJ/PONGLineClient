package client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWindow {

	private JFrame frmPongline;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
		frmPongline.setVisible(true);
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
		
		usernameField = new JTextField();
		usernameField.setBounds(144, 73, 151, 30);
		frmPongline.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(76, 43, 124, 91);
		frmPongline.getContentPane().add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 130, 151, 30);
		frmPongline.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(76, 138, 117, 14);
		frmPongline.getContentPane().add(lblPassword);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		loginButton.setBounds(111, 190, 89, 23);
		frmPongline.getContentPane().add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPongline.setVisible(false);
				RegisterWindow window = new RegisterWindow();
			}
		});
		registerButton.setBounds(231, 190, 89, 23);
		frmPongline.getContentPane().add(registerButton);
	}
}
