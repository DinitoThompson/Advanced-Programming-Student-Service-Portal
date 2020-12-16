package com.staff_demo;

/*
Member Contribution
Shanice Facey 
Tyeree Tinker 
Dinito Thompson
*/

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
	private JTextField staffID;
	private JTextField staffFirstName;
	private JTextField staffLastName;
	private JTextField staffEmail;
	private JTextField staffMobile;
	private JPasswordField staffPassword;
	private JButton signUpBtn;
	private JPasswordField staffConfirmPassword;
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

		staffID = new JTextField();
		staffID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		staffID.setBounds(267, 104, 228, 50);
		contentPane.add(staffID);
		staffID.setColumns(10);

		staffFirstName = new JTextField();
		staffFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		staffFirstName.setBounds(264, 177, 228, 50);
		contentPane.add(staffFirstName);
		staffFirstName.setColumns(10);

		staffLastName = new JTextField();
		staffLastName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		staffLastName.setBounds(261, 250, 228, 50);
		contentPane.add(staffLastName);
		staffLastName.setColumns(10);

		staffEmail = new JTextField();
		staffEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		staffEmail.setBounds(261, 319, 228, 50);
		contentPane.add(staffEmail);
		staffEmail.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblPassword.setBounds(128, 481, 90, 24);
		contentPane.add(lblPassword);

		JLabel lblMobileNumber = new JLabel("Mobile number");
		lblMobileNumber.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblMobileNumber.setBounds(100, 406, 139, 26);
		contentPane.add(lblMobileNumber);

		staffMobile = new JTextField();
		staffMobile.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		staffMobile.setBounds(264, 390, 228, 50);
		contentPane.add(staffMobile);
		staffMobile.setColumns(10);

		staffPassword = new JPasswordField();
		staffPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		staffPassword.setBounds(264, 464, 228, 50);
		contentPane.add(staffPassword);

		/*
		 * JRadioButton rdbtnStudent = new JRadioButton(); rdbtnStudent.setIcon(new
		 * ImageIcon(Sign_up.class.getResource("/res/icons8-student-male-30.png")));
		 * rdbtnStudent.setText("Student");
		 * rdbtnStudent.setHorizontalAlignment(SwingConstants.CENTER);
		 * rdbtnStudent.setBackground(Color.WHITE); rdbtnStudent.setBounds(259, 617, 88,
		 * 30); contentPane.add(rdbtnStudent);
		 */

		JRadioButton rdbtnStaff = new JRadioButton("Confirm - Staff");
		rdbtnStaff.setIcon(new ImageIcon(Sign_up.class.getResource("/res/icons8-people-26.png")));
		rdbtnStaff.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnStaff.setBackground(Color.WHITE);
		rdbtnStaff.setBounds(396, 617, 93, 30);
		contentPane.add(rdbtnStaff);

		ButtonGroup G1 = new ButtonGroup();
		// G1.add(rdbtnStudent);
		G1.add(rdbtnStaff);

		signUpBtn = new JButton("Sign up");
		signUpBtn.setForeground(Color.WHITE);
		signUpBtn.setBackground(new Color(25, 25, 112));
		signUpBtn.setBorder(null);
		signUpBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ID = staffID.getText();
				Fname = staffFirstName.getText();
				Lname = staffLastName.getText();
				Email = staffEmail.getText();
				Phone = staffMobile.getText();
				password = staffPassword.getText();

				// check for any blank fields
				if (staffID.getText().length() == 0) {
					JOptionPane.showMessageDialog(lblName, "Missing ID");
				} else if (staffFirstName.getText().length() == 0) {
					JOptionPane.showMessageDialog(lblName, "Missing First Name");
				} else if (staffLastName.getText().length() == 0) {
					JOptionPane.showMessageDialog(staffLastName, "Missing Last Name");
				} else if (staffEmail.getText().length() == 0) {
					JOptionPane.showMessageDialog(staffEmail, "Missing Email");
				} else if (staffMobile.getText().length() == 0) {
					JOptionPane.showMessageDialog(staffMobile, "Missing Phone Number");
				} else if (staffPassword.getText().length() == 0) {
					JOptionPane.showMessageDialog(staffPassword, "Enter Password");
				} else if (staffPassword.getText().equals(staffConfirmPassword.getText()) == false) {
					JOptionPane.showMessageDialog(staffConfirmPassword, "Passwords Do Not Match");
				} else if (!rdbtnStaff.isSelected()) {
					JOptionPane.showMessageDialog(null, "Please Confirm...", "Sign Up Status",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (rdbtnStaff.isSelected()) {
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
									JOptionPane.showMessageDialog(staffConfirmPassword,
											"Successful Sign Up, Please Login...");

									s = new Login();
									s.setVisible(true);
								}
							} else {
								JOptionPane.showMessageDialog(null, "ID Number Already Registered", "Sign Up Status",
										JOptionPane.INFORMATION_MESSAGE);
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
								JOptionPane.showMessageDialog(staffConfirmPassword,
										"Successful Sign Up, Please Login...");

								s = new Login();
								s.setVisible(true);
							}

						} catch (SQLException e11) {
							System.out.println("HELP: " + e11.getMessage());
						} catch (IOException e2) {

							e2.printStackTrace();
						}
					} catch (InstantiationException e1) {

						e1.printStackTrace();
					} catch (IllegalAccessException e1) {

						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {

						e1.printStackTrace();
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		signUpBtn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		signUpBtn.setBounds(402, 677, 90, 36);
		contentPane.add(signUpBtn);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(79, 550, 160, 24);
		contentPane.add(lblConfirmPassword);

		staffConfirmPassword = new JPasswordField();
		staffConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		staffConfirmPassword.setBounds(264, 533, 228, 50);
		contentPane.add(staffConfirmPassword);

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

	public void setID(String staffID) {
		ID = staffID;
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

	public Sign_up(String staffID, String fname, String lname, String staffEmail, String phone, String pass)
			throws HeadlessException {
		super();
		ID = staffID;
		Fname = fname;
		Lname = lname;
		Email = staffEmail;
		Phone = phone;
		password = pass;
	}

	public Sign_up(int i, String string2, String string3) {

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