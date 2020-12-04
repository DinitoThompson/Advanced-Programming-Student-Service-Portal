package com.staff_demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import jdbc.connection1.CreateDB;
import jdbc.connection1.SQLProvider;

public class Sign_up extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField email;
	private JTextField mob;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JPasswordField passwordField_1;
	Login s;

	String ID;
	String Fname;
	String Lname;
	String Email;
	String Phone;
	String password;

	Connection dbConn = null;
	PreparedStatement pat;
	// PreparedStatement pat1;

	public Sign_up() {
		setResizable(false);
		setTitle("Sign up");
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/res/utech.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 819, 776);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewUserRegister = new JLabel("Staff Sign Up ");
		lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewUserRegister.setBounds(254, 50, 325, 50);
		contentPane.add(lblNewUserRegister);

		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblID.setBounds(200, 104, 99, 43);
		contentPane.add(lblID);

		JLabel lblName = new JLabel("First name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblName.setBounds(128, 185, 99, 43);
		contentPane.add(lblName);

		JLabel lblNewLabel = new JLabel("Last name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setBounds(140, 265, 99, 29);
		contentPane.add(lblNewLabel);

		JLabel lblEmailAddress = new JLabel("Email\r\n address");
		lblEmailAddress.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblEmailAddress.setBounds(115, 330, 124, 36);
		contentPane.add(lblEmailAddress);

		id = new JTextField();
		id.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		id.setBounds(267, 104, 228, 50);
		contentPane.add(id);
		id.setColumns(10);

		firstname = new JTextField();
		firstname.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		firstname.setBounds(264, 177, 228, 50);
		contentPane.add(firstname);
		firstname.setColumns(10);

		lastname = new JTextField();
		lastname.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lastname.setBounds(261, 250, 228, 50);
		contentPane.add(lastname);
		lastname.setColumns(10);

		email = new JTextField();
		email.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		email.setBounds(261, 319, 228, 50);
		contentPane.add(email);
		email.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblPassword.setBounds(128, 481, 90, 24);
		contentPane.add(lblPassword);

		JLabel lblMobileNumber = new JLabel("Mobile number");
		lblMobileNumber.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblMobileNumber.setBounds(100, 406, 139, 26);
		contentPane.add(lblMobileNumber);

		mob = new JTextField();
		mob.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		mob.setBounds(264, 390, 228, 50);
		contentPane.add(mob);
		mob.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passwordField.setBounds(264, 464, 228, 50);
		contentPane.add(passwordField);

		/*
		 * JRadioButton rdbtnStudent = new JRadioButton(); rdbtnStudent.setIcon(new
		 * ImageIcon(Sign_up.class.getResource("/res/icons8-student-male-30.png")));
		 * rdbtnStudent.setText("Student");
		 * rdbtnStudent.setHorizontalAlignment(SwingConstants.CENTER);
		 * rdbtnStudent.setBackground(Color.WHITE); rdbtnStudent.setBounds(259, 617, 88,
		 * 30); contentPane.add(rdbtnStudent);
		 */

		JRadioButton rdbtnStaff = new JRadioButton("Staff");
		rdbtnStaff.setIcon(new ImageIcon(Sign_up.class.getResource("/res/icons8-people-26.png")));
		rdbtnStaff.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnStaff.setBackground(Color.WHITE);
		rdbtnStaff.setBounds(396, 617, 93, 30);
		contentPane.add(rdbtnStaff);

		ButtonGroup G1 = new ButtonGroup();
		// G1.add(rdbtnStudent);
		G1.add(rdbtnStaff);

		btnNewButton = new JButton("Sign up");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ID = id.getText();
				Fname = firstname.getText();
				Lname = lastname.getText();
				Email = email.getText();
				Phone = mob.getText();
				password = passwordField.getText();

				// check for any blank fields
				if (id.getText().length() == 0) {
					JOptionPane.showMessageDialog(lblName, "Missing ID");
				} else if (firstname.getText().length() == 0) {
					JOptionPane.showMessageDialog(lblName, "Missing First Name");
				} else if (lastname.getText().length() == 0) {
					JOptionPane.showMessageDialog(lastname, "Missing Last Name");
				} else if (email.getText().length() == 0) {
					JOptionPane.showMessageDialog(email, "Missing Email");
				} else if (mob.getText().length() == 0) {
					JOptionPane.showMessageDialog(mob, "Missing Phone Number");
				} else if (passwordField.getText().length() == 0) {
					JOptionPane.showMessageDialog(passwordField, "Enter Password");
				} else if (passwordField.getText().equals(passwordField_1.getText()) == false) {
					JOptionPane.showMessageDialog(passwordField_1, "Passwords Do Not Match");
				}
				if (rdbtnStaff.isSelected()) {
					dispose();
					try {
						// Connection dbConn = null;
						System.out.println(
								"connecting to Database ...." + "jdbc:mysql://localhost:3306/student_services_portal");
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
						if (conn != null) {
							System.out.println("Connected Successfully!!!");
							Sign_up sign = new Sign_up(ID, Fname, Lname, Email, Phone, password);
							SQLProvider sql = new SQLProvider(conn);

							boolean staff_created = sql.insertStaffUser(sign);
							boolean staff_contact_created = sql.insertStaffContact(sign);

							if (staff_created) {
								if (staff_contact_created) {
									JOptionPane.showMessageDialog(null, "Staff Record Created !!", "Staff Creation",
											JOptionPane.INFORMATION_MESSAGE);
									JOptionPane.showMessageDialog(passwordField_1,
											"Successful Sign Up, Please Login...");

									s = new Login();
									s.setVisible(true);
								}
							} else {
								JOptionPane.showMessageDialog(null, "ID Number Already Registered", "Sign Up Status", JOptionPane.INFORMATION_MESSAGE);
								s = new Login();
								s.setVisible(true);
							}
						}

					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Setting Up Database And Table",
								"DataBase Connection Status", JOptionPane.WARNING_MESSAGE);
						try {
							dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
							CreateDB db = new CreateDB(dbConn);
							System.out.println("sucessful create");
							// Call method to create database & table
							boolean dbIsCreated = db.createDataBaseAndTable();
							if (dbIsCreated == true) { // If database created successfully
								JOptionPane.showMessageDialog(null, "Connected to Database", "DB Connection Status",
										JOptionPane.INFORMATION_MESSAGE);
							}
							Sign_up sign = new Sign_up(ID, Fname, Lname, Email, Phone, password);
							SQLProvider sql = new SQLProvider(dbConn);

							boolean staff_created = sql.insertStaffUser(sign);
							boolean staff_contact_created = sql.insertStaffContact(sign);

							if (staff_created && staff_contact_created) {
								JOptionPane.showMessageDialog(null, "Staff Record Created !!", "Staff Creation",
										JOptionPane.INFORMATION_MESSAGE);
								JOptionPane.showMessageDialog(passwordField_1, "Successful Sign Up, Please Login...");

								s = new Login();
								s.setVisible(true);
							}

						} catch (SQLException e11) {
							System.out.println("HELP: " + e11.getMessage());
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "ID Number Already Registered", "Sign Up Status",
							JOptionPane.INFORMATION_MESSAGE);
					try {
						s = new Login();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					s.setVisible(true);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton.setBounds(402, 677, 90, 36);
		contentPane.add(btnNewButton);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(79, 550, 160, 24);
		contentPane.add(lblConfirmPassword);

		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
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
				Login d;
				try {
					d = new Login();
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
		btnBack.setBounds(34, 677, 90, 36);
		contentPane.add(btnBack);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Sign_up.class.getResource("/res/utech.jpg")));
		label_1.setBounds(539, 87, 221, 270);
		contentPane.add(label_1);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Sign_up.class.getResource("/res/Frame1.png")));
		lblNewLabel_1.setBounds(539, 500, 276, 238);
		contentPane.add(lblNewLabel_1);
	}

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		ID = id;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String mail) {
		Email = mail;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Sign_up(String id, String fname, String lname, String email, String phone, String pass)
			throws HeadlessException {
		super();
		ID = id;
		Fname = fname;
		Lname = lname;
		Email = email;
		Phone = phone;
		password = pass;
	}

	public Sign_up(int i, String string2, String string3) {
		// TODO Auto-generated constructor stub
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