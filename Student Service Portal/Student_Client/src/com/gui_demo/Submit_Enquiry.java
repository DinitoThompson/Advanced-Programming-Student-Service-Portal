package com.gui_demo;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import client_Chat.Client_Chat;
import jdbc.connection.SQLProvider;

import javax.swing.JButton;
import javax.swing.JRadioButton;

public class Submit_Enquiry extends JFrame implements ActionListener {

	private JPanel contentPane;

	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private String login_id; 
	
	PreparedStatement pst;
	Connection conn;
	Cover c;
	//SQLProvider SQL;
	
	public void setLoginId (String login_id)
	{
		this.login_id = login_id; 
	}
	public String getLoginId ()
	{
		return this.login_id; 
	}
	/**
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
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(339, 250, 228, 50);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(339, 310, 228, 50);
		contentPane.add(textField_4);
		
		
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
		lblNewLabel.setBounds(617, 20, 230, 214);
		contentPane.add(lblNewLabel);
		
		JLabel lblName_1_1 = new JLabel("Student Name");
		lblName_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1.setBounds(655, 250, 155, 43);
		contentPane.add(lblName_1_1);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(617, 310, 228, 50);
		try {
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal","root","");
			SQLProvider sql = new SQLProvider(conn);
			textField_6.setText(sql.SelectStudentName(getLoginId()));
		}
		catch (SQLException e)
		{
			e.getMessage(); 
		}
		contentPane.add(textField_6);
		
		JLabel lblName_1_1_1 = new JLabel("Student ID");
		lblName_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1_1.setBounds(655, 359, 155, 43);
		contentPane.add(lblName_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_7.setColumns(10);
		textField_7.setBounds(619, 404, 228, 50);
		textField_7.setText(getLoginId());
		contentPane.add(textField_7);
	
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBack.setBounds(725, 511, 85, 21);
		contentPane.add(btnBack);
		
		JRadioButton rdbtnUrgent = new JRadioButton("Schedule Live");
		rdbtnUrgent.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnUrgent.setBackground(Color.WHITE);
		rdbtnUrgent.setBounds(310, 509, 155, 21);
		rdbtnUrgent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnUrgent.isSelected())
				{
					Client_Chat c = new Client_Chat();
					c.setVisible(true);
			    }
			}
			
		});
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
				
				try {
					Connection conn;
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal","root","");
					SQLProvider sql = new SQLProvider(conn);
					boolean SubmitedEnquiry = sql.SubmitEnquiry(getLoginId(), textField_4.getText(), textField_3.getText(), textArea.getText());
					
					if (SubmitedEnquiry)
					{
						JOptionPane.showMessageDialog(null, "Enquiry Submitted !", "Status", JOptionPane.INFORMATION_MESSAGE);
						Student_Dashboard p = new Student_Dashboard(getLoginId());
						dispose(); 
						p.setVisible(true);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Enquiry NOT Submitted !", "Status", JOptionPane.INFORMATION_MESSAGE);
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
