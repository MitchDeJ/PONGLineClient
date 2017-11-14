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

public class RegisterWindow {

	private JFrame frmPongline;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;



	/**
	 * Create the application.
	 */
	public RegisterWindow() {
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
		
		textField = new JTextField();
		textField.setBounds(144, 58, 151, 30);
		frmPongline.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(24, 46, 108, 54);
		frmPongline.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 99, 151, 30);
		frmPongline.getContentPane().add(passwordField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(24, 111, 108, 14);
		frmPongline.getContentPane().add(lblPassword);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBounds(172, 194, 89, 23);
		frmPongline.getContentPane().add(btnNewButton_1);
		
		JLabel label = new JLabel("E-mail");
		label.setBounds(24, 16, 89, 31);
		frmPongline.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(144, 16, 151, 30);
		frmPongline.getContentPane().add(textField_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(144, 140, 151, 30);
		frmPongline.getContentPane().add(passwordField_1);
		
		JLabel label_1 = new JLabel("Confirm Password");
		label_1.setBounds(24, 148, 132, 14);
		frmPongline.getContentPane().add(label_1);
	}
}
