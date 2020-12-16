package com.gui_demo;

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

import client_Chat.Client_Chat;
import jdbc.connection.CreateDB;
import jdbc.connection.SQLProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sign_up extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField studentID;
	private JTextField studentFirstName;
	private JTextField studentLastName;
	private JTextField studentEmail;
	private JTextField studentMobile;
	private JPasswordField studentPassword;
	private JButton btnNewButton;
	private JPasswordField studentConfirmPassword;

	private static final Logger logger = LogManager.getLogger(Sign_up.class);

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Client_Chat.class.getResource("/res/utech.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 819, 776);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewUserRegister = new JLabel("Student Sign Up");
		lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewUserRegister.setBounds(254, 40, 325, 50);
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

		studentID = new JTextField();
		studentID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		studentID.setBounds(267, 104, 228, 50);
		contentPane.add(studentID);
		studentID.setColumns(10);

		studentFirstName = new JTextField();
		studentFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		studentFirstName.setBounds(264, 177, 228, 50);
		contentPane.add(studentFirstName);
		studentFirstName.setColumns(10);

		studentLastName = new JTextField();
		studentLastName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		studentLastName.setBounds(261, 250, 228, 50);
		contentPane.add(studentLastName);
		studentLastName.setColumns(10);

		studentEmail = new JTextField();
		studentEmail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		studentEmail.setBounds(261, 319, 228, 50);
		contentPane.add(studentEmail);
		studentEmail.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblPassword.setBounds(128, 481, 90, 24);
		contentPane.add(lblPassword);

		JLabel lblMobileNumber = new JLabel("Mobile number");
		lblMobileNumber.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblMobileNumber.setBounds(100, 406, 139, 26);
		contentPane.add(lblMobileNumber);

		studentMobile = new JTextField();
		studentMobile.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		studentMobile.setBounds(264, 390, 228, 50);
		contentPane.add(studentMobile);
		studentMobile.setColumns(10);

		studentPassword = new JPasswordField();
		studentPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		studentPassword.setBounds(264, 464, 228, 50);
		contentPane.add(studentPassword);

		JRadioButton studentConfirm = new JRadioButton();
		studentConfirm.setIcon(new ImageIcon(Sign_up.class.getResource("/res/icons8-student-male-30.png")));
		studentConfirm.setText("Confirm");
		studentConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		studentConfirm.setBackground(Color.WHITE);
		studentConfirm.setBounds(330, 617, 88, 30);
		contentPane.add(studentConfirm);

		/*
		 * JRadioButton rdbtnStaff = new JRadioButton("Staff"); rdbtnStaff.setIcon(new
		 * ImageIcon(Sign_up.class.getResource("/res/icons8-people-26.png")));
		 * rdbtnStaff.setHorizontalAlignment(SwingConstants.CENTER);
		 * rdbtnStaff.setBackground(Color.WHITE); rdbtnStaff.setBounds(396, 617, 93,
		 * 30); contentPane.add(rdbtnStaff);
		 */

		@SuppressWarnings("unused")
		JButton B = new JButton();
		ButtonGroup G1 = new ButtonGroup();
		G1.add(studentConfirm);
		// G1.add(rdbtnStaff);

		btnNewButton = new JButton("Sign up");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ID = studentID.getText();
				Fname = studentFirstName.getText();
				Lname = studentLastName.getText();
				Email = studentEmail.getText();
				Phone = studentMobile.getText();
				password = studentPassword.getText();

				// check for any blank fields
				if (studentID.getText().length() == 0) {
					JOptionPane.showMessageDialog(lblName, "Missing ID");
				} else if (studentFirstName.getText().length() == 0) {
					JOptionPane.showMessageDialog(lblName, "Missing First Name");
				} else if (studentLastName.getText().length() == 0) {
					JOptionPane.showMessageDialog(studentLastName, "Missing Last Name");
				} else if (studentEmail.getText().length() == 0) {
					JOptionPane.showMessageDialog(studentEmail, "Missing Email");
				} else if (studentMobile.getText().length() == 0) {
					JOptionPane.showMessageDialog(studentMobile, "Missing Phone Number");
				} else if (studentPassword.getText().length() == 0) {
					JOptionPane.showMessageDialog(studentPassword, "Enter Password");
				} else if (studentPassword.getText().equals(studentConfirmPassword.getText()) == false) {
					JOptionPane.showMessageDialog(studentConfirmPassword, "Passwords Do Not Match");
				} else if (!studentConfirm.isSelected()) {
					JOptionPane.showMessageDialog(null, "Please Confirm...", "Sign Up Status",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (studentConfirm.isSelected()) {
					dispose();
					Cover s;
					try {
						// Connection dbConn = null;
						System.out.println(
								"Connecting to Database ...." + "jdbc:mysql://localhost:3306/student_services_portal");
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
						// connect to database
						if (conn != null) {
							System.out.println("Connected Successfully!!!");
							Sign_up sign = new Sign_up(ID, Fname, Lname, Email, Phone, password);
							SQLProvider sql = new SQLProvider(conn);
							boolean student_created = sql.insertStudentUser(sign);

							if (student_created) {
								boolean student_contact_created = sql.insertStudentContact(sign);
								if (student_contact_created) {
									JOptionPane.showMessageDialog(null, "Student Record Created !!", "Student Creation",
											JOptionPane.INFORMATION_MESSAGE);
									JOptionPane.showMessageDialog(studentConfirmPassword,
											"Successful Sign Up, Please Login...");
									logger.info("New Student Sign Up : Student ID : " + getID());
									s = new Cover();
									s.setVisible(true);
								}
							} else {
								JOptionPane.showMessageDialog(null, "ID Number Already Registered", "Sign Up Status",
										JOptionPane.INFORMATION_MESSAGE);
								s = new Cover();
								s.setVisible(true);
							}

						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Setting up Database and table",
								"Database Connection Status", JOptionPane.WARNING_MESSAGE);
						try {
							dbConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
							CreateDB db = new CreateDB(dbConn);

							// Call method to create database & table
							boolean dbIsCreated = db.createDataBaseAndTable();
							if (dbIsCreated == true) { // If database created successfully
								JOptionPane.showMessageDialog(null, "Connected to Database", "DB Connection Status",
										JOptionPane.INFORMATION_MESSAGE);
							}
							Sign_up sign = new Sign_up(ID, Fname, Lname, Email, Phone, password);
							SQLProvider sql = new SQLProvider(dbConn);

							boolean student_created = sql.insertStudentUser(sign);
							boolean student_contact_created = sql.insertStudentContact(sign);

							if (student_created && student_contact_created) {
								JOptionPane.showMessageDialog(null, "Student Record Created !!", "Student Creation",
										JOptionPane.INFORMATION_MESSAGE);
								JOptionPane.showMessageDialog(studentConfirmPassword,
										"Successful Sign Up, Please Login...");
								logger.info("New Student Sign Up : Student ID : " + getID());
								s = new Cover();
								s.setVisible(true);
							}

						} catch (SQLException e11) {
							JOptionPane.showMessageDialog(null, "ID Number Already Registered", "Registration Status",
									JOptionPane.ERROR_MESSAGE);
							Sign_up sign_up = new Sign_up();
							dispose();
							sign_up.setVisible(true);
						} catch (RuntimeException o) {
							System.out.println("Database doesn't exist");
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
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton.setBounds(402, 677, 90, 36);
		contentPane.add(btnNewButton);

		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblConfirmPassword.setBounds(79, 550, 160, 24);
		contentPane.add(lblConfirmPassword);

		studentConfirmPassword = new JPasswordField();
		studentConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		studentConfirmPassword.setBounds(264, 533, 228, 50);
		contentPane.add(studentConfirmPassword);

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

	public void setID(String studentID) {
		ID = studentID;
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

	public Sign_up(String studentID, String fname, String lname, String studentEmail, String phone, String pass)
			throws HeadlessException {
		super();
		ID = studentID;
		Fname = fname;
		Lname = lname;
		Email = studentEmail;
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