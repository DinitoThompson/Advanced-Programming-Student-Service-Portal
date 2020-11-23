package com.gui_demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.border.MatteBorder;

import jdbc.connection.SQLProvider;

public class Cover extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPassword;
	//Submit_Enquiry sign = new Submit_Enquiry(txtUser.getText());
	String ID;
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * Create the frame.
	 */
	public Cover() throws IOException {
		setUndecorated(true);
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 645, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(255, 215, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setName("");
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(193, 218, 254, 51);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setName("");
		txtUser.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(txtUser.getText().equals("ID Number"))
				{
					txtUser.setText("");
				}
				else {
					txtUser.selectAll();
				}
			}@Override
			public void focusLost(FocusEvent arg0)
			{
				if(txtUser.getText().equals(""))
				{
					txtUser.setText("ID Number");					
				}
			}
		});
		//txtUser.setText("ID Number");
		txtUser.setBorder(new LineBorder(Color.BLACK, 1, true));
		txtUser.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		setID(txtUser.getText());
		txtUser.setBounds(10, 10, 192, 33);
		panel_1.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblUser = new JLabel("");
		lblUser.setBounds(210, 0, 40, 40);
		lblUser.setIcon(new ImageIcon(Cover.class.getResource("/res/icons8-user-male-26.png")));
		panel_1.add(lblUser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(193, 267, 254, 51);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(txtPassword.getText().equals("Password"))
				{
				    ((JPasswordField) txtPassword).setEchoChar('●');
					txtPassword.setText("");
				}
				else {
					txtPassword.selectAll();
				}
				
			}
			@Override
			public void focusLost(FocusEvent arg0)
			{
				if(txtPassword.getText().equals(""))
				{
					txtPassword.setText("Password");
					((JPasswordField) txtPassword).setEchoChar((char)0);
					
				}
			}
		});
		txtPassword.setText("Password");
		((JPasswordField) txtPassword).setEchoChar((char)0);
		txtPassword.setBorder(new LineBorder(Color.BLACK, 1, true));
		txtPassword.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		txtPassword.setBounds(10, 10, 192, 31);
		panel_2.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblPassword = new JLabel("");
		lblPassword.setAutoscrolls(true);
		lblPassword.setBounds(210, 0, 40, 40);
		lblPassword.setIcon(new ImageIcon(Cover.class.getResource("/res/icons8-lock-24.png")));
		panel_2.add(lblPassword);
		
		JRadioButton rdbtnStudent = new JRadioButton();
		rdbtnStudent.setText("Student");
		rdbtnStudent.setIcon(new ImageIcon(Cover.class.getResource("/res/icons8-student-male-30.png")));
		rdbtnStudent.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnStudent.setBackground(Color.WHITE);
		rdbtnStudent.setBounds(215, 311, 88, 30);
		contentPane.add(rdbtnStudent);
		
		JRadioButton rdbtnStaff = new JRadioButton("Staff");
		rdbtnStaff.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnStaff.setIcon(new ImageIcon(Cover.class.getResource("/res/icons8-people-26.png")));
		rdbtnStaff.setBackground(Color.WHITE);
		rdbtnStaff.setBounds(307, 311, 93, 30);
		contentPane.add(rdbtnStaff);
		
		JButton B = new JButton("You are a :");
		ButtonGroup G1 = new ButtonGroup();
		G1.add(rdbtnStudent);
		G1.add(rdbtnStaff);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setForeground(new Color(0, 0, 128));
		panel.setBounds(303, 354, 97, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setForeground(Color.GRAY);
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnLogin.setBorder(null);
		btnLogin.setBackground(new Color(25, 25, 112));
		btnLogin.setBounds(0, 10, 97, 25);
		btnLogin.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		//this bit check which radio button was selected then go to the respective table to check credentials
        		if(rdbtnStudent.isSelected())
        		{	
        			
        			//need to check credentials, if correct do the code below if not use JOptionPane.showmessage to display incorrect info message
        			try {
        				// Checks to see if Database Exist
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal","root","");
                        
        			}catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			if(txtUser.getText().isEmpty() || txtPassword.getText().isEmpty())
        			{
        				JOptionPane.showMessageDialog(btnLogin, "ID or Password Blank");
        			}
        			else
        			{
						try {
							// Connects to database  
							
							Class.forName("com.mysql.jdbc.Driver").newInstance();
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal","root","");
							PreparedStatement pas = conn.prepareStatement("select * from student where student_id = ? and student_password = ?");
							pas.setString(1, txtUser.getText());
						    pas.setString(2, txtPassword.getText());
						    ResultSet rs = pas.executeQuery();
						    
						    if(rs.next())
						    { 
							    Student_Dashboard s = new Student_Dashboard(txtUser.getText());
							    dispose();
			            	    s.setVisible(true);
						    }
						    else
						    {
						    	JOptionPane.showMessageDialog(btnLogin, "ID or Password Incorrect");
						        txtUser.setText("");
						        txtPassword.setText("");
						        txtUser.requestFocus();
						    }
						    
	   
						    
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InstantiationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        				
        			}	
        			
        		}
        		else if (rdbtnStaff.isSelected())
        				{
        			     //run view/selected query to display all enqueries in the table on the staff dashboard frame.
        			     // not sure how we implementing the live chat session yet
        			try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal","root","");
                        
        			}catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			if(txtUser.getText().isEmpty() || txtPassword.getText().isEmpty())
        			{
        				JOptionPane.showMessageDialog(btnLogin, "ID or Password Blank");
        			}
        			else
        			{
						try {
							
							Class.forName("com.mysql.jdbc.Driver").newInstance();
							Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal","root","");
							PreparedStatement pas = conn.prepareStatement("select * from staff where staff_id = ? and staff_password = ?");
						    pas.setString(1, txtUser.getText());
						    pas.setString(2, txtPassword.getText());
						    ResultSet rs = pas.executeQuery();
						    
						    if(rs.next())
						    {
						    	dispose();
						    	Staff_Dashborad s = new Staff_Dashborad();
			            		s.setVisible(true);
						    }
						    else
						    {
						    	JOptionPane.showMessageDialog(btnLogin, "ID or Password Incorrect");
						        txtUser.setText("");
						        txtPassword.setText("");
						        txtUser.requestFocus();
						    }
						    
	   
						    
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InstantiationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        				
        			}	
        		}
        		else {
					JOptionPane.showMessageDialog(lblPassword, "Select a user (Staff/Student)");
				}
        	}
        });
		panel.add(btnLogin);
		
		JLabel head = new JLabel("");
		head.setIcon(new ImageIcon(Cover.class.getResource("/res/utech.jpg")));
		head.setBounds(195, 10, 220, 207);
		contentPane.add(head);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Confirmation",JOptionPane.YES_NO_OPTION) ==0)
				{
			       Cover.this.dispose();
				}
			}
		});
		
		lblX.setHorizontalTextPosition(SwingConstants.CENTER);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setBounds(610, 0, 46, 21);
		contentPane.add(lblX);
		
		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIdNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdNumber.setBounds(111, 228, 83, 30);
		contentPane.add(lblIdNumber);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword_1.setBounds(111, 279, 83, 21);
		contentPane.add(lblPassword_1);
		
		JLabel lblNewLabel_1 = new JLabel("l");
		lblNewLabel_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(255, 215, 0)));
		lblNewLabel_1.setIcon(new ImageIcon(Cover.class.getResource("/res/FrameLiner.png")));
		lblNewLabel_1.setBounds(0, 0, 220, 208);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setBounds(544, 377, -107, -108);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(255, 215, 0)));
		lblNewLabel.setIcon(new ImageIcon(Cover.class.getResource("/res/Frame1.png")));
		lblNewLabel.setBounds(370, 146, 275, 299);
		contentPane.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(25, 25, 112));
		panel_3.setBounds(192, 354, 101, 38);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setBorder(null);
		btnSignUp.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSignUp.setForeground(Color.GRAY);
		btnSignUp.setBackground(new Color(25, 25, 112));
		btnSignUp.setBounds(0, 10, 101, 21);
		btnSignUp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		Sign_up s;
				try {
					s = new Sign_up();
					s.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
		panel_3.add(btnSignUp);
	}

	@Override
	public void actionPerformed(ActionEvent e) { 
			try {
				Cover frame = new Cover();
				frame.setVisible(true);
			} catch (Exception r) {
				r.printStackTrace();
			}
		}
}
