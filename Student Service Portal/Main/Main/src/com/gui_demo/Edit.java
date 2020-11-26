package com.gui_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import jdbc.connection.SQLProvider;

public class Edit extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private JTextField textField_3;
	private JTextField textField_4;
	private static JTextArea textArea;
	private static JScrollPane pane;
	protected static JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private String login_id; 
	private String enquiry_id;
	
	public String getEnquiry_id() {
		return enquiry_id;
	}
	public void setEnquiry_id(String enquiry_id) {
		this.enquiry_id = enquiry_id;
	}
	/**
	 * Create the frame.
	 */
	
	public void setLoginId (String login_id)
	{
		this.login_id = login_id; 
	}
	public String getLoginId ()
	{
		return this.login_id; 
	}
	
	public Edit(String login_id, String enquiry_id) throws SQLException 
	{
		setLoginId(login_id); 
		setEnquiry_id(enquiry_id);  
		
	setTitle("Edit Enquiry");
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
	
	textField_3 = new JTextField();
	textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	textField_3.setColumns(10);
	textField_3.setBounds(330, 260, 228, 50);
	contentPane.add(textField_3);
	
	textField_4 = new JTextField();
	textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
	textField_4.setColumns(10);
	textField_4.setBounds(330, 320, 228, 50);
	contentPane.add(textField_4);
	
	pane = new JScrollPane();
	pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	textArea = new JTextArea("If Necessarry");
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
	textArea.setBounds(330, 380, 228, 65);
	textArea.setBorder(new LineBorder(Color.BLACK));
	
	pane.setBounds(330,380,228,65);
	pane.getViewport().setBackground(Color.black);
	pane.setViewportView(textArea);
	getContentPane().add(pane);
	
	JLabel lblEnquiryId = new JLabel("Enquiry ID");
	lblEnquiryId.setHorizontalAlignment(SwingConstants.CENTER);
	lblEnquiryId.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	lblEnquiryId.setBounds(64, 452, 144, 26);
	contentPane.add(lblEnquiryId);
	
	textField_5 = new JTextField();
	textField_5.setFont(new Font("Tahoma", Font.PLAIN, 32));
	textField_5.setEditable(false);
	textField_5.setColumns(10);
	textField_5.setBounds(27, 488, 228, 50);
	contentPane.add(textField_5);
	
	JRadioButton rdbtnUrgent = new JRadioButton("Schedule Live");
	rdbtnUrgent.setIcon(new ImageIcon(View_Enquiry.class.getResource("/res/icons8-urgent-message-24.png")));
	rdbtnUrgent.setFont(new Font("Times New Roman", Font.PLAIN, 19));
	rdbtnUrgent.setBackground(Color.WHITE);
	rdbtnUrgent.setBounds(308, 511, 105, 21);
	contentPane.add(rdbtnUrgent);
	
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
				System.out.println("Out Here");
				java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal","root","");
				SQLProvider sql = new SQLProvider(conn); 
				boolean UpdatedQuery = sql.UpdateEnquiry(getEnquiry_id(), textField_3.getText(), textField_4.getText(), textArea.getText());
				if (UpdatedQuery)
				{
					JOptionPane.showMessageDialog(null, "Enquiry Updated Sucess...", "Enquiry Status", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Enquiry Updated Fail...", "Enquiry Status", JOptionPane.INFORMATION_MESSAGE);
				}
				v = new Student_Dashboard (getLoginId());
				System.out.println("Pheee"); 
				dispose(); 
				v.setVisible(true);
			}
			catch (Exception e1)
			{
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
	
	textField_6 = new JTextField();
	textField_6.setEditable(false);
	textField_6.setFont(new Font("Tahoma", Font.PLAIN, 32));
	textField_6.setColumns(10);
	textField_6.setBounds(634, 320, 228, 50);
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
	lblName_1_1_1.setBounds(677, 380, 155, 43);
	contentPane.add(lblName_1_1_1);
	
	textField_7 = new JTextField();
	textField_7.setEditable(false);
	textField_7.setFont(new Font("Tahoma", Font.PLAIN, 32));
	textField_7.setColumns(10);
	textField_7.setBounds(632, 417, 228, 50);
	System.out.println(""+getLoginId());
	// This keeps adding the ID number twice
	textField_7.setText(getLoginId());
	contentPane.add(textField_7);
	
	JButton btnBack = new JButton("Back");
	btnBack.setForeground(Color.WHITE);
	btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	btnBack.setBorder(null);
	btnBack.setBackground(new Color(25, 25, 112));
	btnBack.setBounds(718, 511, 85, 21);
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			Student_Dashboard  p;
			try {
				p = new Student_Dashboard (getLoginId());
				p.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	});
	contentPane.add(btnBack);
	show_Enquiry(getEnquiry_id()); 
	repaint();
 }
	
	public void show_Enquiry(String enquiry_id) throws SQLException
	{
		try {
		java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal","root","");
		SQLProvider sql = new SQLProvider(conn);
		ResultSet res = sql.ViewStudentEnquiry(enquiry_id);
	    textField_3.replaceSelection(res.getString("enquiry_complaint"));
	    textField_4.replaceSelection(res.getString("enquiry_nature"));
	    textArea.append(res.getString("enquiry_detail"));
		} 
		catch (SQLException e)
		{
			e.getMessage();
		}
	}

	public void show_enquiry(String id) throws SQLException
	{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal","root","");
		SQLProvider sql = new SQLProvider(conn);
		ResultSet result = sql.EditEnquiry(id);
		try {
				textField_3.setText(result.getString(4));
				textField_4.setText(result.getString(3));
				textArea.setText(result.getString(5));
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Wi Gi Up !"); 
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Edit frame = new Edit(getLoginId(), getEnquiry_id());
			try {
				show_enquiry(textField_5.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.setVisible(true);
		} catch (Exception k) {
			k.printStackTrace();
		}
		
	}

}
