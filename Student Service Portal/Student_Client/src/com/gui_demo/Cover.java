package com.gui_demo;

/*
Member Contribution
Shanice Facey 
Tyeree Tinker 
Dinito Thompson
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cover extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField studentIDNumber;
	private JTextField studentPassword;
	private String studentID;
	private static final Logger logger = LogManager.getLogger(Cover.class);

	public String getUserID() {
		return studentID;
	}

	public void setUserID(String studentID) {
		this.studentID = studentID;
	}

	/**
	 * Create the frame.
	 */
	public Cover() throws IOException {
		setUndecorated(true);
		setTitle("LOGIN");
		setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getResource("/res/utech.jpg"))));
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

		studentIDNumber = new JTextField();
		studentIDNumber.setName("");
		studentIDNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (studentIDNumber.getText().equals("ID Number")) {
					studentIDNumber.setText("");
				} else {
					studentIDNumber.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (studentIDNumber.getText().equals("")) {
					studentIDNumber.setText("ID Number");
				}
			}
		});
		// studentIDNumber.setText("ID Number");
		studentIDNumber.setBorder(new LineBorder(Color.BLACK, 1, true));
		studentIDNumber.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		setUserID(studentIDNumber.getText());
		studentIDNumber.setBounds(10, 10, 192, 33);
		panel_1.add(studentIDNumber);
		studentIDNumber.setColumns(10);

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

		studentPassword = new JPasswordField();
		studentPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (studentPassword.getText().equals("Password")) {
					((JPasswordField) studentPassword).setEchoChar('*');
					studentPassword.setText("");
				} else {
					studentPassword.selectAll();
				}

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (studentPassword.getText().equals("")) {
					studentPassword.setText("Password");
					((JPasswordField) studentPassword).setEchoChar((char) 0);

				}
			}
		});
		studentPassword.setText("Password");
		((JPasswordField) studentPassword).setEchoChar((char) 0);
		studentPassword.setBorder(new LineBorder(Color.BLACK, 1, true));
		studentPassword.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		studentPassword.setBounds(10, 10, 192, 31);
		panel_2.add(studentPassword);
		studentPassword.setColumns(10);

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
		rdbtnStudent.setBounds(250, 311, 88, 30);
		contentPane.add(rdbtnStudent);

		/*
		 * JRadioButton rdbtnStaff = new JRadioButton("Staff");
		 * rdbtnStaff.setHorizontalAlignment(SwingConstants.CENTER);
		 * rdbtnStaff.setIcon(new
		 * ImageIcon(Cover.class.getResource("/res/icons8-people-26.png")));
		 * rdbtnStaff.setBackground(Color.WHITE); rdbtnStaff.setBounds(307, 311, 93,
		 * 30); contentPane.add(rdbtnStaff);
		 */

		new JButton();
		ButtonGroup G1 = new ButtonGroup();
		G1.add(rdbtnStudent);
		// G1.add(rdbtnStaff);

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

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				// need to check credentials, if correct do the code below if not use
				if (studentIDNumber.getText().isEmpty() || studentPassword.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnLogin, "ID or Password Blank");
				} else {
					try {
						// Connects to database

						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
						PreparedStatement pas = conn.prepareStatement(
								"select * from student where student_id = ? and student_password = ?");
						pas.setString(1, studentIDNumber.getText());
						pas.setString(2, studentPassword.getText());
						ResultSet rs = pas.executeQuery();

						if (rs.next()) {
							logger.info("Student Sign In: " + studentIDNumber.getText());
							Student_Dashboard s = new Student_Dashboard(studentIDNumber.getText());
							dispose();
							s.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(btnLogin, "ID or Password Incorrect");
							studentIDNumber.setText("");
							studentPassword.setText("");
							studentIDNumber.requestFocus();
						}

					} catch (SQLException e1) {
						// JOptionPane.showmessage to display incorrect info message
						try {
							// Checks to see if Database Exist
							Class.forName("com.mysql.jdbc.Driver").newInstance();
							DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root",
									"");

						} catch (ClassNotFoundException e11) {

							e11.printStackTrace();
						} catch (SQLException e11) {

							JOptionPane.showMessageDialog(null, "Your Not Currently Signed Up...", "Login Status",
									JOptionPane.INFORMATION_MESSAGE);
							Sign_up sign_up = new Sign_up();
							sign_up.setVisible(true);
							dispose();
						} catch (InstantiationException e11) {

							e1.printStackTrace();
						} catch (IllegalAccessException e11) {

							e1.printStackTrace();
						}

					} catch (ClassNotFoundException e1) {

						e1.printStackTrace();
					} catch (InstantiationException e1) {

						e1.printStackTrace();
					} catch (IllegalAccessException e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		panel.add(btnLogin);

		JLabel head = new JLabel("");
		head.setIcon(new ImageIcon(Cover.class.getResource("/res/utech.jpg")));
		head.setBounds(195, 10, 220, 207);
		contentPane.add(head);

		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation",
						JOptionPane.YES_NO_OPTION) == 0) {
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

		JLabel lblNewLabel_1 = new JLabel("");
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

		JButton signUpBtn = new JButton("SIGN UP");
		signUpBtn.setBorder(null);
		signUpBtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		signUpBtn.setForeground(Color.GRAY);
		signUpBtn.setBackground(new Color(25, 25, 112));
		signUpBtn.setBounds(0, 10, 101, 21);
		signUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Sign_up s;
				try {
					s = new Sign_up();
					s.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		panel_3.add(signUpBtn);
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
