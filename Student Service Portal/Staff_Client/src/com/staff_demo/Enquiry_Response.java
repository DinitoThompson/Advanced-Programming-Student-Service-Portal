package com.staff_demo;

/*
Member Contribution
Shanice Facey 
Tyeree Tinker 
Dinito Thompson
*/

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
//import chat_video.sever;
import jdbc.connection1.SQLProvider;

import javax.swing.ScrollPaneConstants;

public class Enquiry_Response extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField enquiryComplaint;
	private JTextField enquiryNature;
	private static JTextArea enquiryDetail;
	private static JScrollPane pane;
	protected static JTextField enquiryID;
	protected static JTextField staffID;
	protected static JTextField staffName;
	protected static JTextArea enquiryResponse;
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

		enquiryComplaint = new JTextField();
		enquiryComplaint.setEditable(false);
		enquiryComplaint.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		enquiryComplaint.setHorizontalAlignment(SwingConstants.CENTER);
		enquiryComplaint.setColumns(10);
		enquiryComplaint.setBounds(330, 132, 228, 50);
		contentPane.add(enquiryComplaint);

		enquiryNature = new JTextField();
		enquiryNature.setEditable(false);
		enquiryNature.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		enquiryNature.setHorizontalAlignment(SwingConstants.CENTER);
		enquiryNature.setColumns(10);
		enquiryNature.setBounds(330, 202, 228, 50);
		contentPane.add(enquiryNature);

		pane = new JScrollPane();
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		enquiryDetail = new JTextArea();
		enquiryDetail.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		enquiryDetail.setBounds(330, 380, 228, 65);
		enquiryDetail.setEditable(false);
		enquiryDetail.setBorder(new LineBorder(Color.BLACK));

		pane.setBounds(331, 270, 228, 65);
		pane.getViewport().setBackground(Color.black);
		pane.setViewportView(enquiryDetail);
		getContentPane().add(pane);

		JLabel lblEnquiryId = new JLabel("Enquiry ID");
		lblEnquiryId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnquiryId.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblEnquiryId.setBounds(64, 452, 144, 26);
		contentPane.add(lblEnquiryId);

		enquiryID = new JTextField();
		enquiryID.setHorizontalAlignment(SwingConstants.CENTER);
		enquiryID.setEditable(false);
		enquiryID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		enquiryID.setColumns(10);
		enquiryID.setBounds(27, 488, 228, 50);
		enquiryID.setText(getEnquiry_id());
		contentPane.add(enquiryID);

		JButton btnEdit = new JButton("Submit Response");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// This is a mystery .... we could run an update query to capture the staff
				// response then send an email to the student email provided??
				try {
					java.sql.Connection conn = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
					SQLProvider sql = new SQLProvider(conn);
					boolean ResponseCreated = sql.SubmitResponse(enquiryID.getText(), enquiryResponse.getText());

					if (ResponseCreated) {
						JOptionPane.showMessageDialog(null, "Respone Submitted Successfully", "Response Status",
								JOptionPane.INFORMATION_MESSAGE);
						Staff_Dashborad g = new Staff_Dashborad(getLoginId());
						// Staff_Dashborad.staffName.setText(staffID.getText());
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
				// Staff_Dashborad.staffName.setText(staffID.getText());
				dispose();
				g.setVisible(true);
			}
		});

		contentPane.add(btnBack);

		JScrollPane pane_1 = new JScrollPane();
		pane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane_1.setBounds(330, 369, 228, 65);
		contentPane.add(pane_1);

		enquiryResponse = new JTextArea();
		enquiryResponse.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		enquiryResponse.setBorder(new LineBorder(Color.BLACK));
		pane_1.setViewportView(enquiryResponse);

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
				// sever s = new sever();
				Client_Chat c = new Client_Chat();
				c.setVisible(true);
				// s.setVisible(true);
			}
		});
		contentPane.add(rdbtnNewRadioButton);

		JLabel lblStaffId = new JLabel("Staff ID");
		lblStaffId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStaffId.setBounds(689, 292, 105, 26);
		contentPane.add(lblStaffId);

		staffID = new JTextField();
		staffID.setHorizontalAlignment(SwingConstants.CENTER);
		staffID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		staffID.setEditable(false);
		staffID.setColumns(10);
		staffID.setBounds(632, 324, 228, 50);
		contentPane.add(staffID);

		JLabel lblStaffName = new JLabel("Staff Name");
		lblStaffName.setHorizontalAlignment(SwingConstants.CENTER);
		lblStaffName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStaffName.setBounds(689, 393, 105, 26);
		contentPane.add(lblStaffName);

		staffName = new JTextField();
		staffName.setHorizontalAlignment(SwingConstants.CENTER);
		staffName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		staffName.setEditable(false);
		staffName.setColumns(10);
		staffName.setBounds(634, 429, 228, 50);
		try {
			java.sql.Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
			SQLProvider sql = new SQLProvider(conn);
			staffName.setText(sql.SelectStaffName(getLoginId()));
		} catch (SQLException e) {
			e.getMessage();
		}

		contentPane.add(staffName);
		repaint();

		try {
			show_Enquiry(getEnquiry_id());
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	}

	public void show_Enquiry(String enquiry_id) throws SQLException {
		try {
			java.sql.Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
			SQLProvider sql = new SQLProvider(conn);
			ResultSet res = sql.ViewStudentEnquiry(enquiry_id);
			enquiryComplaint.replaceSelection(res.getString("enquiry_complaint"));
			enquiryNature.replaceSelection(res.getString("enquiry_nature"));
			enquiryDetail.append(res.getString("enquiry_detail"));
			staffID.replaceSelection(res.getString("staff_id"));
		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
