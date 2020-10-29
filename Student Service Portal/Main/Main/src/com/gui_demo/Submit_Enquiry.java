package com.gui_demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Submit_Enquiry extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	/**
	 * Create the frame.
	 */
	public Submit_Enquiry() {
		setTitle("Submit Enquiry");
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
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1.setBounds(262, 65, 80, 43);
		contentPane.add(lblName_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(262, 138, 80, 26);
		contentPane.add(lblEmail);
		
		JLabel lblMobileNumber = new JLabel("Mobile number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobileNumber.setBounds(203, 206, 139, 26);
		contentPane.add(lblMobileNumber);
		
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
		
		JLabel lblEnquiryId = new JLabel("Enquiry ID");
		lblEnquiryId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnquiryId.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblEnquiryId.setBounds(101, 452, 144, 26);
		contentPane.add(lblEnquiryId);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setColumns(10);
		textField.setBounds(339, 65, 228, 50);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_1.setColumns(10);
		textField_1.setBounds(339, 130, 228, 50);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_2.setColumns(10);
		textField_2.setBounds(339, 190, 228, 50);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_3.setColumns(10);
		textField_3.setBounds(339, 250, 228, 50);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_4.setColumns(10);
		textField_4.setBounds(339, 310, 228, 50);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_5.setColumns(10);
		textField_5.setBounds(58, 488, 228, 50);
		contentPane.add(textField_5);
		
		JScrollPane pane = new JScrollPane();
		pane.setBackground(Color.WHITE);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setBounds(339, 387, 228, 65);
		contentPane.add(pane);
		
		JTextArea textArea = new JTextArea("If Necessarry");
		textArea.addFocusListener(new FocusAdapter()
		{
			@Override
			public void focusGained(FocusEvent arg0)
			{
				if(textArea.getText().equals("If Necessary"))
				{
				    
					textArea.setText("");
				}
				else {
					textArea.selectAll();
				}
				
			}
			@Override
			public void focusLost(FocusEvent arg0)
			{
				if(textArea.getText().equals(""))
				{
					textArea.setText("If Necessary");	
				}
			}
		});
		pane.setViewportView(textArea);
		textArea.setBorder(new LineBorder(Color.BLACK));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Submit_Enquiry.class.getResource("/res/utech.jpg")));
		lblNewLabel.setBounds(619, 39, 230, 214);
		contentPane.add(lblNewLabel);
		
		JLabel lblName_1_1 = new JLabel("Student Name");
		lblName_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1.setBounds(655, 291, 155, 43);
		contentPane.add(lblName_1_1);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_6.setColumns(10);
		textField_6.setBounds(619, 322, 228, 50);
		contentPane.add(textField_6);
		
		JLabel lblName_1_1_1 = new JLabel("Student ID");
		lblName_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1_1.setBounds(655, 382, 155, 43);
		contentPane.add(lblName_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_7.setColumns(10);
		textField_7.setBounds(621, 412, 228, 50);
		contentPane.add(textField_7);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Past_Enquiries p;
				try {
					p = new Past_Enquiries();
					p.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBack.setBounds(725, 511, 85, 21);
		contentPane.add(btnBack);
		
		JRadioButton rdbtnUrgent = new JRadioButton("Urgent");
		rdbtnUrgent.setIcon(new ImageIcon(Submit_Enquiry.class.getResource("/res/icons8-urgent-message-24.png")));
		rdbtnUrgent.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnUrgent.setBackground(Color.WHITE);
		rdbtnUrgent.setBounds(320, 509, 105, 21);
		contentPane.add(rdbtnUrgent);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnSubmit.setBorder(null);
		btnSubmit.setBackground(new Color(25, 25, 112));
		btnSubmit.setBounds(481, 508, 85, 21);
		btnSubmit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
		     {
					// check for any blank fields
				// if everything is ok then add to enquiry table in database
				//let user know their enquiry was submitted successfully
				//clear fields
            }
		});
		contentPane.add(btnSubmit);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			 Submit_Enquiry frame = new Submit_Enquiry();
			 frame.setVisible(true);
		} catch (Exception D) {
			D.printStackTrace();
		}
		
	}

	
}
