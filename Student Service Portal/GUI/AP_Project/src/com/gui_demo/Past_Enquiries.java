package com.gui_demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Past_Enquiries extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	/**
	 * Create the frame.
	 */
	public Past_Enquiries() {
		setTitle("All Enquries");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 572);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Past_Enquiries.class.getResource("/res/FrameLiner.png")));
		label.setBounds(0, 0, 209, 200);
		contentPane.add(label);
		
		JLabel lblAllEnquries = new JLabel("All Enquries");
		lblAllEnquries.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllEnquries.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblAllEnquries.setBounds(261, 10, 209, 45);
		contentPane.add(lblAllEnquries);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Past_Enquiries.class.getResource("/res/utech.jpg")));
		lblNewLabel.setBounds(617, 29, 230, 214);
		contentPane.add(lblNewLabel);
		
		JLabel lblName_1_1 = new JLabel("Student Name");
		lblName_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1.setBounds(664, 253, 155, 43);
		contentPane.add(lblName_1_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setColumns(10);
		textField.setBounds(617, 289, 228, 50);
		contentPane.add(textField);
		
		JLabel lblName_1_1_1 = new JLabel("Student ID");
		lblName_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1_1.setBounds(664, 343, 155, 43);
		contentPane.add(lblName_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_1.setColumns(10);
		textField_1.setBounds(619, 389, 228, 50);
		contentPane.add(textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(201, 100, 397, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Enquiry ID", "Complaint", "Nature"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Long.class, Long.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JLabel lblEnquiryId = new JLabel("Enquiry ID");
		lblEnquiryId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnquiryId.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblEnquiryId.setBounds(41, 450, 144, 26);
		contentPane.add(lblEnquiryId);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_2.setColumns(10);
		textField_2.setBounds(20, 475, 228, 50);
		contentPane.add(textField_2);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnEdit.setBorder(null);
		btnEdit.setBackground(new Color(25, 25, 112));
		btnEdit.setBounds(267, 498, 85, 21);
		btnEdit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		Edit s = new Edit();
        		s.setVisible(true);
        	}
        });
		contentPane.add(btnEdit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnCancel.setBorder(null);
		btnCancel.setBackground(new Color(25, 25, 112));
		btnCancel.setBounds(395, 495, 85, 21);
		btnCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// capture enquiry ID and run delete query ???
			}
		});
		contentPane.add(btnCancel);
		
		JButton btnView = new JButton("View");
		btnView.setForeground(Color.WHITE);
		btnView.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnView.setBorder(null);
		btnView.setBackground(new Color(25, 25, 112));
		btnView.setBounds(522, 495, 85, 21);
		btnView.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		//capture enquiry ID selected and run select query to display the data in the view_enquiry formS
        		View_Enquiry v = new View_Enquiry();
        		v.setVisible(true);
        	}
        });
		contentPane.add(btnView);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(25, 25, 112));
		btnBack.setBounds(699, 495, 85, 21);
		btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		Student_Dashboard s = new Student_Dashboard();
        		s.setVisible(true);
        	}
        });
		contentPane.add(btnBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Past_Enquiries frame = new Past_Enquiries();
			frame.setVisible(true);
		} catch (Exception v) {
			v.printStackTrace();
		}
		
	}
}
