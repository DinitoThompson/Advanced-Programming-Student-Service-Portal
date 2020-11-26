package com.gui_demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client_Chat.Client_Chat;

public class Past_Responses extends JFrame implements ActionListener {

	private JPanel contentPane;
	protected static JTextField textField;
	private JTable table;
	private String login_id; 
	
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
	public Past_Responses(String login_id) {
		setLoginId(login_id); 
		setResizable(false);
		setTitle("Past_Responses");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Client_Chat.class.getResource("/res/utech.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 564);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Past_Responses.class.getResource("/res/FrameLiner.png")));
		lblNewLabel.setBounds(0, 0, 208, 200);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Past_Responses.class.getResource("/res/utech.jpg")));
		lblNewLabel_1.setBounds(645, 43, 217, 224);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane pane_1 = new JScrollPane();
		pane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane_1.setBounds(634, 336, 249, 100);
		contentPane.add(pane_1);
		
		JTextArea txtrNoResponseMade = new JTextArea("No Response made");
		txtrNoResponseMade.setEditable(false);
		txtrNoResponseMade.setBorder(new LineBorder(Color.BLACK));
		pane_1.setViewportView(txtrNoResponseMade);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(752, 482, 85, 21);
		btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		Student_Dashboard s = new Student_Dashboard(getLoginId());
        		s.setVisible(true);
        	}
        });
		contentPane.add(btnBack);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(new Color(25, 25, 112));
		btnSubmit.setBorder(null);
		btnSubmit.setBounds(577, 483, 85, 21);
		contentPane.add(btnSubmit);
		
		JRadioButton rdbtnUrgent = new JRadioButton("Schedule Live");
		rdbtnUrgent.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnUrgent.setBackground(Color.WHITE);
		rdbtnUrgent.setBounds(222, 483, 139, 21);
		contentPane.add(rdbtnUrgent);
		
		JRadioButton rdbtnUnresolved = new JRadioButton("Unresolved");
		rdbtnUnresolved.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnUnresolved.setBackground(Color.WHITE);
		rdbtnUnresolved.setBounds(375, 483, 139, 21);
		contentPane.add(rdbtnUnresolved);
		
		JLabel lblEnquiryId = new JLabel("Enquiry ID");
		lblEnquiryId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnquiryId.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblEnquiryId.setBounds(21, 410, 144, 26);
		contentPane.add(lblEnquiryId);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(0, 462, 208, 50);
		contentPane.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(218, 102, 404, 348);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Response", "Response Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			try {
				Past_Responses frame = new Past_Responses(getLoginId());
				frame.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	}
	
}
