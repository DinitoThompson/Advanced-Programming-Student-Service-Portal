package com.gui_demo;

/*
Member Contribution
Shanice Facey 
Tyeree Tinker 
Dinito Thompson
*/ 

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import client_Chat.Client_Chat;
import jdbc.connection.SQLProvider;

import javax.swing.JButton;
//import javax.swing.JRadioButton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Submit_Enquiry extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField enquiryComplaint;
	private JTextField enquiryNature;
	private JTextField studentName;
	private JTextField studentID;
	private String login_id;
	public static final Logger logger = LogManager.getLogger(Submit_Enquiry.class);

	PreparedStatement pst;
	Connection conn;
	Cover c;
	// SQLProvider SQL;

	public void setLoginId(String login_id) {
		this.login_id = login_id;
	}

	public String getLoginId() {
		return this.login_id;
	}

	/*
	 * Create the frame.
	 */
	public Submit_Enquiry(String login_id) {
		setLoginId(login_id);
		setResizable(false);
		setTitle("Submit Enquiry");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Client_Chat.class.getResource("/res/utech.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 593);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Submit_Enquiry.class.getResource("/res/FrameLiner.png")));
		label.setBounds(0, 0, 209, 200);
		contentPane.add(label);

		JLabel lblStudentServicesEnquiry = new JLabel("Student Services Enquiry Form");
		lblStudentServicesEnquiry.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentServicesEnquiry.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblStudentServicesEnquiry.setBounds(281, 10, 328, 45);
		contentPane.add(lblStudentServicesEnquiry);

		JLabel lblComplaint = new JLabel("Complaint");
		lblComplaint.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplaint.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblComplaint.setBounds(224, 266, 105, 26);
		contentPane.add(lblComplaint);

		JLabel lblNatureOfEnquiry = new JLabel("Nature of Enquiry");
		lblNatureOfEnquiry.setHorizontalAlignment(SwingConstants.CENTER);
		lblNatureOfEnquiry.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNatureOfEnquiry.setBounds(171, 326, 170, 26);
		contentPane.add(lblNatureOfEnquiry);

		JLabel lblFurtherDetails = new JLabel("Further Details");
		lblFurtherDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblFurtherDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFurtherDetails.setBounds(190, 387, 139, 26);
		contentPane.add(lblFurtherDetails);

		enquiryComplaint = new JTextField();
		enquiryComplaint.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		enquiryComplaint.setColumns(10);
		enquiryComplaint.setBounds(339, 250, 228, 50);
		contentPane.add(enquiryComplaint);

		enquiryNature = new JTextField();
		enquiryNature.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		enquiryNature.setColumns(10);
		enquiryNature.setBounds(339, 310, 228, 50);
		contentPane.add(enquiryNature);

		JScrollPane enquiryDetail = new JScrollPane();
		enquiryDetail.setBackground(Color.WHITE);
		enquiryDetail.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		enquiryDetail.setBounds(339, 387, 228, 65);
		contentPane.add(enquiryDetail);

		JTextArea textArea = new JTextArea("If Necessarry");
		textArea.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (textArea.getText().equals("If Necessary")) {
					textArea.setText("");
				} else {
					textArea.selectAll();
				}

			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if (textArea.getText().equals("")) {
					textArea.setText("If Necessary");
				}
			}
		});
		enquiryDetail.setViewportView(textArea);
		textArea.setBorder(new LineBorder(Color.BLACK));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Submit_Enquiry.class.getResource("/res/utech.jpg")));
		lblNewLabel.setBounds(617, 20, 230, 214);
		contentPane.add(lblNewLabel);

		JLabel lblName_1_1 = new JLabel("Student Name");
		lblName_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1.setBounds(655, 250, 155, 43);
		contentPane.add(lblName_1_1);

		studentName = new JTextField();
		studentName.setEditable(false);
		studentName.setBorder(new LineBorder(new Color(0, 0, 0), 2, false));
		studentName.setHorizontalAlignment(SwingConstants.CENTER);
		studentName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		studentName.setEnabled(false);
		studentName.setBounds(617, 310, 228, 50);
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
		lblName_1_1_1.setBounds(655, 359, 155, 43);
		contentPane.add(lblName_1_1_1);

		studentID = new JTextField();
		studentID.setEditable(false);
		studentID.setBorder(new LineBorder(new Color(0, 0, 0), 2, false));
		studentID.setHorizontalAlignment(SwingConstants.CENTER);
		studentID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		studentID.setColumns(10);
		studentID.setBounds(619, 404, 228, 50);
		studentID.setText(getLoginId());
		contentPane.add(studentID);

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(25, 25, 112));
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
		btnBack.setBounds(725, 511, 85, 21);
		contentPane.add(btnBack);

		/*
		 * JRadioButton rdbtnUrgent = new JRadioButton("Schedule Live");
		 * rdbtnUrgent.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		 * rdbtnUrgent.setBackground(Color.WHITE); rdbtnUrgent.setBounds(310, 509, 155,
		 * 21); rdbtnUrgent.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * if(rdbtnUrgent.isSelected()) { logger.info("Student ID: " + getLoginId() +
		 * " Opted To Schedule A Live Via Submit Enquiry."); Client_Chat c = new
		 * Client_Chat(); c.setVisible(true); } }
		 * 
		 * }); contentPane.add(rdbtnUrgent);
		 */

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnSubmit.setBorder(null);
		btnSubmit.setBackground(new Color(25, 25, 112));
		btnSubmit.setBounds(481, 508, 85, 21);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Connection conn;
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root",
							"");
					SQLProvider sql = new SQLProvider(conn);
					boolean SubmitedEnquiry = sql.SubmitEnquiry(getLoginId(), enquiryNature.getText(),
							enquiryComplaint.getText(), textArea.getText());

					if (SubmitedEnquiry) {
						logger.info("Student ID: " + getLoginId() + " Submited A Brand New Enquiry.");
						JOptionPane.showMessageDialog(null, "Enquiry Submitted !", "Status",
								JOptionPane.INFORMATION_MESSAGE);
						Student_Dashboard p = new Student_Dashboard(getLoginId());
						dispose();
						p.setVisible(true);
					}

				} catch (SQLException e1) {

					JOptionPane.showMessageDialog(null, "Enquiry NOT Submitted !", "Status",
							JOptionPane.INFORMATION_MESSAGE);
					Student_Dashboard p = new Student_Dashboard(getLoginId());
					dispose();
					p.setVisible(true);
				}

			}
		});
		contentPane.add(btnSubmit);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Submit_Enquiry frame = new Submit_Enquiry(getLoginId());
			frame.setVisible(true);
		} catch (Exception D) {
			D.printStackTrace();
		}

	}

}
