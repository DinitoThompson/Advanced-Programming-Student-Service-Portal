package com.gui_demo;

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
import java.sql.Connection;
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
import client_Chat.Client_Chat;
import jdbc.connection.SQLProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Edit extends JFrame implements ActionListener {

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
	private JTextField studentName;
	private JTextField studentID;
	private String login_id;
	private String enquiry_id;

	public static Logger logger = LogManager.getLogger(Edit.class);

	public String getEnquiry_id() {
		return enquiry_id;
	}

	public void setEnquiry_id(String enquiry_id) {
		this.enquiry_id = enquiry_id;
	}

	/**
	 * Create the frame.
	 */

	public void setLoginId(String login_id) {
		this.login_id = login_id;
	}

	public String getLoginId() {
		return this.login_id;
	}

	public Edit(String login_id, String enquiry_id) throws SQLException {
		setLoginId(login_id);
		setEnquiry_id(enquiry_id);
		setResizable(false);
		setTitle("Edit Enquiry");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Client_Chat.class.getResource("/res/utech.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 585);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(View_Enquiry.class.getResource("/res/FrameLiner.png")));
		label.setBounds(0, 0, 209, 200);
		contentPane.add(label);

		JLabel lblSubmittedEnquiries = new JLabel("Edit Enquiry");
		lblSubmittedEnquiries.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmittedEnquiries.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblSubmittedEnquiries.setBounds(349, 10, 209, 45);
		contentPane.add(lblSubmittedEnquiries);

		JLabel lblComplaint = new JLabel("Complaint");
		lblComplaint.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplaint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblComplaint.setBounds(220, 276, 105, 26);
		contentPane.add(lblComplaint);

		JLabel lblNatureOfEnquiry = new JLabel("Nature of Enquiry");
		lblNatureOfEnquiry.setHorizontalAlignment(SwingConstants.CENTER);
		lblNatureOfEnquiry.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNatureOfEnquiry.setBounds(159, 336, 170, 26);
		contentPane.add(lblNatureOfEnquiry);

		JLabel lblFurtherDetails = new JLabel("Further Details");
		lblFurtherDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblFurtherDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFurtherDetails.setBounds(190, 394, 139, 26);
		contentPane.add(lblFurtherDetails);

		enquiryComplaint = new JTextField();
		enquiryComplaint.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		enquiryComplaint.setColumns(10);
		enquiryComplaint.setBounds(330, 260, 228, 50);
		contentPane.add(enquiryComplaint);

		enquiryNature = new JTextField();
		enquiryNature.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		enquiryNature.setColumns(10);
		enquiryNature.setBounds(330, 320, 228, 50);
		contentPane.add(enquiryNature);

		pane = new JScrollPane();
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		enquiryDetail = new JTextArea();
		enquiryDetail.setBounds(330, 380, 228, 65);
		enquiryDetail.setBorder(new LineBorder(Color.BLACK));

		pane.setBounds(330, 380, 228, 65);
		pane.getViewport().setBackground(Color.black);
		pane.setViewportView(enquiryDetail);
		getContentPane().add(pane);

		JLabel lblEnquiryId = new JLabel("Enquiry ID");
		lblEnquiryId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnquiryId.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblEnquiryId.setBounds(64, 452, 144, 26);
		contentPane.add(lblEnquiryId);

		enquiryID = new JTextField();
		enquiryID.setEditable(false);
		enquiryID.setBorder(new LineBorder(new Color(0, 0, 0), 2, false));
		enquiryID.setHorizontalAlignment(SwingConstants.CENTER);
		enquiryID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		enquiryID.setEnabled(false);
		enquiryID.setBounds(27, 488, 228, 50);
		contentPane.add(enquiryID);

		/*
		 * JRadioButton rdbtnUrgent = new JRadioButton("Schedule Live");
		 * rdbtnUrgent.setIcon(new
		 * ImageIcon(View_Enquiry.class.getResource("/res/icons8-urgent-message-24.png")
		 * )); rdbtnUrgent.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		 * rdbtnUrgent.setBackground(Color.WHITE); rdbtnUrgent.setBounds(308, 511, 105,
		 * 21); rdbtnUrgent.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { if
		 * (rdbtnUrgent.isSelected()) { logger.info("Student ID: " + getLoginId() +
		 * " Scheduled/Started A Live Session"); Client_Chat c = new Client_Chat();
		 * c.setVisible(true); } }
		 * 
		 * }); contentPane.add(rdbtnUrgent);
		 */

		JButton btnEdit = new JButton("Confirm");
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnEdit.setBackground(new Color(25, 25, 112));
		btnEdit.setBorder(null);
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setBounds(447, 511, 85, 21);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student_Dashboard v;
				try {
					java.sql.Connection conn = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
					SQLProvider sql = new SQLProvider(conn);
					boolean UpdatedQuery = sql.UpdateEnquiry(getEnquiry_id(), enquiryComplaint.getText(),
							enquiryNature.getText(), enquiryDetail.getText());
					if (UpdatedQuery) {
						JOptionPane.showMessageDialog(null, "Enquiry Updated Success...", "Enquiry Status",
								JOptionPane.INFORMATION_MESSAGE);
						logger.info("Student ID: " + getLoginId() + " Added A New Enquiry");
					} else {
						JOptionPane.showMessageDialog(null, "Enquiry Updated Fail...", "Enquiry Status",
								JOptionPane.INFORMATION_MESSAGE);
					}
					v = new Student_Dashboard(getLoginId());
					dispose();
					v.setVisible(true);
				} catch (Exception e1) {
					e1.getMessage();
				}
			}
		});
		contentPane.add(btnEdit);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(View_Enquiry.class.getResource("/res/utech.jpg")));
		lblNewLabel.setBounds(632, 47, 230, 214);
		contentPane.add(lblNewLabel);

		JLabel lblName_1_1 = new JLabel("Student Name");
		lblName_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1.setBounds(677, 276, 155, 43);
		contentPane.add(lblName_1_1);

		studentName = new JTextField();
		studentName.setEditable(false);
		studentName.setBorder(new LineBorder(new Color(0, 0, 0), 2, false));
		studentName.setHorizontalAlignment(SwingConstants.CENTER);
		studentName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		studentName.setEnabled(false);
		studentName.setBounds(634, 320, 228, 50);
		try {
			java.sql.Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
			SQLProvider sql = new SQLProvider(conn);
			studentName.setText(sql.SelectStudentName(getLoginId()));
		} catch (SQLException e) {
			e.getMessage();
		}
		contentPane.add(studentName);

		JLabel lblName_1_1_1 = new JLabel("Student ID");
		lblName_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1_1.setBounds(677, 380, 155, 43);
		contentPane.add(lblName_1_1_1);

		studentID = new JTextField();
		studentID.setEditable(false);
		studentID.setBorder(new LineBorder(new Color(0, 0, 0), 2, false));
		studentID.setHorizontalAlignment(SwingConstants.CENTER);
		studentID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		studentID.setEnabled(false);
		studentID.setBounds(632, 417, 228, 50);
		studentID.setText(getLoginId());
		contentPane.add(studentID);

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(718, 511, 85, 21);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Student_Dashboard p;
				try {
					p = new Student_Dashboard(getLoginId());
					p.setVisible(true);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}

			}
		});
		contentPane.add(btnBack);
		show_Enquiry(getEnquiry_id());
		repaint();
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
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public void show_enquiry(String id) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root",
				"");
		SQLProvider sql = new SQLProvider(conn);
		ResultSet result = sql.EditEnquiry(id);
		try {
			enquiryComplaint.setText(result.getString(4));
			enquiryNature.setText(result.getString(3));
			enquiryDetail.setText(result.getString(5));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Wi Gi Up !");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Edit frame = new Edit(getLoginId(), getEnquiry_id());
			try {
				show_enquiry(enquiryID.getText());
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			frame.setVisible(true);
		} catch (Exception k) {
			k.printStackTrace();
		}

	}

}
