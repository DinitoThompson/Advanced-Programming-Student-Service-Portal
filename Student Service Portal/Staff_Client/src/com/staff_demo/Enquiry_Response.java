package com.staff_demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Staff_Chat.Client_Chat;
import chat_video.sever;
import jdbc.connection1.SQLProvider;

import javax.swing.ScrollPaneConstants;

public class Enquiry_Response extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_4;
	private static JTextArea textArea;
	private static JScrollPane pane;
	protected static JTextField textField_5;
	protected static JTextField textField;
	protected static JTextField textField_1;
	protected static JTextArea textArea_1;
	private String login_id;
	private String enquiry_id;

	public String getEnquiry_id() {
		return enquiry_id;
	}

	public void setEnquiry_id(String enquiry_id) {
		this.enquiry_id = enquiry_id;
	}

	public void setLoginId(String login_id) {
		this.login_id = login_id;
	}

	public String getLoginId() {
		return this.login_id;
	}

	/**
	 * Create the frame.
	 */
	public Enquiry_Response(String login_id, String enquiry_id) {
		setLoginId(login_id);
		setEnquiry_id(enquiry_id);

		setResizable(false);
		setTitle("Student Enquiries");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Client_Chat.class.getResource("/res/utech.jpg")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 585);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(("/res/FrameLiner.png")));
		label.setBounds(0, 0, 209, 200);
		contentPane.add(label);

		JLabel lblSubmittedEnquiries = new JLabel("Submitted Enquiries");
		lblSubmittedEnquiries.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmittedEnquiries.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblSubmittedEnquiries.setBounds(349, 10, 209, 45);
		contentPane.add(lblSubmittedEnquiries);

		JLabel lblComplaint = new JLabel("Complaint");
		lblComplaint.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplaint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblComplaint.setBounds(205, 132, 105, 26);
		contentPane.add(lblComplaint);

		JLabel lblNatureOfEnquiry = new JLabel("Nature of Enquiry");
		lblNatureOfEnquiry.setHorizontalAlignment(SwingConstants.CENTER);
		lblNatureOfEnquiry.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNatureOfEnquiry.setBounds(151, 210, 170, 26);
		contentPane.add(lblNatureOfEnquiry);

		JLabel lblFurtherDetails = new JLabel("Further Details");
		lblFurtherDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblFurtherDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFurtherDetails.setBounds(182, 292, 139, 26);
		contentPane.add(lblFurtherDetails);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(330, 132, 228, 50);
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(330, 202, 228, 50);
		contentPane.add(textField_4);

		pane = new JScrollPane();
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textArea.setBounds(330, 380, 228, 65);
		textArea.setEditable(false);
		textArea.setBorder(new LineBorder(Color.BLACK));

		pane.setBounds(331, 270, 228, 65);
		pane.getViewport().setBackground(Color.black);
		pane.setViewportView(textArea);
		getContentPane().add(pane);

		JLabel lblEnquiryId = new JLabel("Enquiry ID");
		lblEnquiryId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnquiryId.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblEnquiryId.setBounds(64, 452, 144, 26);
		contentPane.add(lblEnquiryId);

		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(27, 488, 228, 50);
		textField_5.setText(getEnquiry_id());
		contentPane.add(textField_5);

		JButton btnEdit = new JButton("Submit Response");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// This is a mystery .... we could run an update query to capture the staff
				// response then send an email to the student email provided??
				try {
					java.sql.Connection conn = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
					SQLProvider sql = new SQLProvider(conn);
					boolean ResponseCreated = sql.SubmitResponse(textField_5.getText(), textArea_1.getText());

					if (ResponseCreated) {
						JOptionPane.showMessageDialog(null, "Respone Submitted Successfully", "Response Status",
								JOptionPane.INFORMATION_MESSAGE);
						Staff_Dashborad g = new Staff_Dashborad(getLoginId());
						// Staff_Dashborad.textField_1.setText(textField.getText());
						dispose();
						g.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Respone Not Submitted", "Response Status",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (SQLException e1) {
					e1.getMessage();
				}
			}
		});
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEdit.setBackground(new Color(25, 25, 112));
		btnEdit.setBorder(null);
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setBounds(593, 508, 155, 21);
		contentPane.add(btnEdit);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(("/res/utech.jpg")));
		lblNewLabel.setBounds(632, 47, 230, 214);
		contentPane.add(lblNewLabel);

		JLabel lblName_1_1 = new JLabel("Response");
		lblName_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1.setBounds(229, 379, 92, 32);
		contentPane.add(lblName_1_1);

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(777, 508, 85, 21);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Staff_Dashborad g = new Staff_Dashborad(getLoginId());
				// Staff_Dashborad.textField_1.setText(textField.getText());
				dispose();
				g.setVisible(true);
			}
		});

		contentPane.add(btnBack);

		JScrollPane pane_1 = new JScrollPane();
		pane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane_1.setBounds(330, 369, 228, 65);
		contentPane.add(pane_1);

		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textArea_1.setBorder(new LineBorder(Color.BLACK));
		pane_1.setViewportView(textArea_1);

		/*
		 * JRadioButton rdbtnLiveChat = new JRadioButton("Video Chat");
		 * rdbtnLiveChat.setIcon(null); rdbtnLiveChat.setFont(new
		 * Font("Times New Roman", Font.PLAIN, 19));
		 * rdbtnLiveChat.setBackground(Color.WHITE); rdbtnLiveChat.setBounds(308, 486,
		 * 139, 21); rdbtnLiveChat.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * if(rdbtnLiveChat.isSelected()) { dispose(); sever c = new sever();
		 * c.setVisible(true); } }
		 * 
		 * }); contentPane.add(rdbtnLiveChat);
		 */

		JButton rdbtnNewRadioButton = new JButton("Live Chat");
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(445, 488, 113, 21);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sever s = new sever();
				Client_Chat c = new Client_Chat();
				c.setVisible(true);
				s.setVisible(true);
			}
		});
		contentPane.add(rdbtnNewRadioButton);

		JLabel lblStaffId = new JLabel("Staff ID");
		lblStaffId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStaffId.setBounds(689, 292, 105, 26);
		contentPane.add(lblStaffId);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(632, 324, 228, 50);
		contentPane.add(textField);

		JLabel lblStaffName = new JLabel("Staff Name");
		lblStaffName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStaffName.setBounds(689, 393, 105, 26);
		contentPane.add(lblStaffName);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(634, 429, 228, 50);
		try {
			java.sql.Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
			SQLProvider sql = new SQLProvider(conn);
			textField_1.setText(sql.SelectStaffName(getLoginId()));
		} catch (SQLException e) {
			e.getMessage();
		}

		contentPane.add(textField_1);
		repaint();

		try {
			show_Enquiry(getEnquiry_id());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void show_Enquiry(String enquiry_id) throws SQLException {
		try {
			java.sql.Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
			SQLProvider sql = new SQLProvider(conn);
			ResultSet res = sql.ViewStudentEnquiry(enquiry_id);
			textField_3.replaceSelection(res.getString("enquiry_complaint"));
			textField_4.replaceSelection(res.getString("enquiry_nature"));
			textArea.append(res.getString("enquiry_detail"));
			textField.replaceSelection(res.getString("staff_id"));
		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
