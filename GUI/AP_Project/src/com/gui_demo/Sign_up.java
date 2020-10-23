package com.gui_demo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class Sign_up extends JFrame implements ActionListener {

	/**
	 * 
	 */
	    private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    private JTextField firstname;
	    private JTextField lastname;
	    private JTextField email;
	    private JTextField mob;
	    private JPasswordField passwordField;
	    private JButton btnNewButton;
	    private JPasswordField passwordField_1;
	    
	    public Sign_up()
	    {
	    	setTitle("Sign up");
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(450, 190, 819, 776);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBackground(Color.WHITE);
	        contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewUserRegister = new JLabel("Sign up Details");
	        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
	        lblNewUserRegister.setBounds(261, 70, 325, 50);
	        contentPane.add(lblNewUserRegister);

	        JLabel lblName = new JLabel("First name");
	        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblName.setBounds(128, 185, 99, 43);
	        contentPane.add(lblName);

	        JLabel lblNewLabel = new JLabel("Last name");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblNewLabel.setBounds(140, 265, 99, 29);
	        contentPane.add(lblNewLabel);

	        JLabel lblEmailAddress = new JLabel("Email\r\n address");
	        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblEmailAddress.setBounds(115, 330, 124, 36);
	        contentPane.add(lblEmailAddress);

	        firstname = new JTextField();
	        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        firstname.setBounds(264, 177, 228, 50);
	        contentPane.add(firstname);
	        firstname.setColumns(10);

	        lastname = new JTextField();
	        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        lastname.setBounds(261, 250, 228, 50);
	        contentPane.add(lastname);
	        lastname.setColumns(10);

	        email = new JTextField();

	        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        email.setBounds(261, 319, 228, 50);
	        contentPane.add(email);
	        email.setColumns(10);

	        JLabel lblPassword = new JLabel("Password");
	        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblPassword.setBounds(128, 481, 90, 24);
	        contentPane.add(lblPassword);

	        JLabel lblMobileNumber = new JLabel("Mobile number");
	        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblMobileNumber.setBounds(100, 406, 139, 26);
	        contentPane.add(lblMobileNumber);

	        mob = new JTextField();
	        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        mob.setBounds(264, 390, 228, 50);
	        contentPane.add(mob);
	        mob.setColumns(10);

	        passwordField = new JPasswordField();
	        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        passwordField.setBounds(264, 464, 228, 50);
	        contentPane.add(passwordField);

	        btnNewButton = new JButton("Sign up");
	        btnNewButton.setForeground(Color.WHITE);
	        btnNewButton.setBackground(new Color(25, 25, 112));
	        btnNewButton.setBorder(null);
	        btnNewButton.addActionListener(new ActionListener() 
	        {
	        	public void actionPerformed(ActionEvent e) 
	             { 
	                dispose();
	                Cover s;
					try {
						s = new Cover();
						s.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}    
	            }
	      });
	        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	        btnNewButton.setBounds(402, 677, 90, 36);
	        contentPane.add(btnNewButton);
	        
	        JLabel lblConfirmPassword = new JLabel("Confirm Password");
	        lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        lblConfirmPassword.setBounds(79, 550, 160, 24);
	        contentPane.add(lblConfirmPassword);
	        
	        passwordField_1 = new JPasswordField();
	        passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
	        passwordField_1.setBounds(264, 533, 228, 50);
	        contentPane.add(passwordField_1);
	        
	        JLabel label = new JLabel("");
	        label.setIcon(new ImageIcon(Sign_up.class.getResource("/res/FrameLiner.png")));
	        label.setBounds(0, 0, 209, 200);
	        contentPane.add(label);
	        
	        JButton btnBack = new JButton("Back");
	        btnBack.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		Cover d;
					try {
						d = new Cover();
						d.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        		
	        	}
	        });
	        btnBack.setBackground(new Color(25, 25, 112));
	        btnBack.setForeground(Color.WHITE);
	        btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	        btnBack.setBorder(null);
	        btnBack.setBounds(257, 677, 90, 36);
	        contentPane.add(btnBack);
	        
	        JRadioButton rdbtnStudent = new JRadioButton();
	        rdbtnStudent.setIcon(new ImageIcon(Sign_up.class.getResource("/res/icons8-student-male-30.png")));
	        rdbtnStudent.setText("Student");
	        rdbtnStudent.setHorizontalAlignment(SwingConstants.CENTER);
	        rdbtnStudent.setBackground(Color.WHITE);
	        rdbtnStudent.setBounds(259, 617, 88, 30);
	        contentPane.add(rdbtnStudent);
	        
	        JRadioButton rdbtnStaff = new JRadioButton("Staff");
	        rdbtnStaff.setIcon(new ImageIcon(Sign_up.class.getResource("/res/icons8-people-26.png")));
	        rdbtnStaff.setHorizontalAlignment(SwingConstants.CENTER);
	        rdbtnStaff.setBackground(Color.WHITE);
	        rdbtnStaff.setBounds(396, 617, 93, 30);
	        contentPane.add(rdbtnStaff);
	        
	        JLabel label_1 = new JLabel("");
	        label_1.setIcon(new ImageIcon(Sign_up.class.getResource("/res/utech.jpg")));
	        label_1.setBounds(539, 87, 221, 270);
	        contentPane.add(label_1);
	        
	        JLabel lblNewLabel_1 = new JLabel("New label");
	        lblNewLabel_1.setIcon(new ImageIcon(Sign_up.class.getResource("/res/Frame1.png")));
	        lblNewLabel_1.setBounds(539, 500, 276, 238);
	        contentPane.add(lblNewLabel_1);
     }
@Override
public void actionPerformed(ActionEvent e) {
	try {
		Sign_up frame = new Sign_up();
		frame.setVisible(true);
	} catch (Exception c) {
		c.printStackTrace();
	}
  }
}
