package com.gui_demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import jdbc.connection.SQLProvider;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.awt.event.ActionEvent;

public class Student_Dashboard extends JFrame implements ActionListener {


	private JPanel contentPane;
	private String id;
	PreparedStatement pst;
	Connection conn;
	Cover c;
	private JTextField textField;
	private JTable table;
	SQLProvider sql;

	/**
	 * Create the frame.
	 */
	public Student_Dashboard() {
		setTitle("DASHBOARD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 599);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Student_Dashboard.class.getResource("/res/utech.jpg")));
		lblNewLabel.setBounds(684, 20, 221, 225);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Student_Dashboard.class.getResource("/res/FrameLiner.png")));
		label.setBounds(0, -16, 214, 233);
		contentPane.add(label);
		
		JLabel lblStudent = new JLabel("Student Name");
		lblStudent.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setBounds(722, 255, 159, 31);
		contentPane.add(lblStudent);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textArea.setBounds(709, 308, 196, 45);
		contentPane.add(textArea);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblStudentId.setBounds(734, 359, 150, 31);
		contentPane.add(lblStudentId);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		textArea_1.setBounds(709, 400, 196, 45);
		//textArea_1.setText(c.getId());
		id = textArea_1.getText();
		contentPane.add(textArea_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(759, 490, 122, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnLogOut.setBackground(new Color(25, 25, 112));
		btnLogOut.setBorder(null);
		btnLogOut.setBounds(0, 0, 122, 45);
		btnLogOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		Front f;
				try {
					f = new Front();
					f.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
		panel.add(btnLogOut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(25, 25, 112));
		panel_1.setForeground(new Color(25, 25, 112));
		panel_1.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		panel_1.setBounds(10, 435, 167, 54);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("View Enquiry");
		btnNewButton.setBounds(0, 0, 167, 54);
		panel_1.add(btnNewButton);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Past_Enquiries p;
				p = new Past_Enquiries();
				p.setVisible(true);
				
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(25, 25, 112));
		panel_2.setBounds(10, 359, 167, 54);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnEditEnquiry = new JButton("Edit Enquiry");
		btnEditEnquiry.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEditEnquiry.setForeground(Color.WHITE);
		btnEditEnquiry.setBackground(new Color(25, 25, 112));
		btnEditEnquiry.setBorder(null);
		btnEditEnquiry.setBounds(10, 0, 157, 54);
		panel_2.add(btnEditEnquiry);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(25, 25, 112));
		panel_2_1.setBounds(509, 490, 167, 54);
		contentPane.add(panel_2_1);
		
		JButton btnNewButton_2 = new JButton("Submit Enquiry");
		btnNewButton_2.setBounds(0, 10, 167, 34);
		panel_2_1.add(btnNewButton_2);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnNewButton_2.setBackground(new Color(25, 25, 112));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Submit_Enquiry s;
				try {
					s = new Submit_Enquiry();
					s.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(25, 25, 112));
		panel_2_1_1.setBounds(10, 498, 167, 54);
		contentPane.add(panel_2_1_1);
		
		JButton btnNewButton_1 = new JButton("Cancel Enquiry");
		btnNewButton_1.setBounds(10, 0, 167, 54);
		panel_2_1_1.add(btnNewButton_1);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(25, 25, 112));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton btnViewResonses = new JButton("View resonses");
		btnViewResonses.setForeground(Color.WHITE);
		btnViewResonses.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnViewResonses.setBorder(null);
		btnViewResonses.setBackground(new Color(25, 25, 112));
		btnViewResonses.setBounds(209, 498, 167, 54);
		contentPane.add(btnViewResonses);
		btnViewResonses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Past_Responses s;
				try {
					s = new Past_Responses();
					s.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.BLACK, 1, true));
		textField.setBounds(10, 296, 167, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnquiryId = new JLabel("Enquiry Id");
		lblEnquiryId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnquiryId.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblEnquiryId.setBounds(20, 255, 157, 31);
		contentPane.add(lblEnquiryId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(228, 119, 448, 355);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Enquiry ID", "State", "Nature"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		
		
		JLabel lblAllEnquiries = new JLabel("All Enquiries");
		lblAllEnquiries.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllEnquiries.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblAllEnquiries.setBounds(365, 64, 175, 31);
		contentPane.add(lblAllEnquiries);
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// run database query to delete enquiry selected
			}	
		});
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Student_Dashboard frame = new Student_Dashboard();
			frame.setVisible(true);
			JTable table = getTable();
			
			ArrayList<Submit_Enquiry> List = sql.StudentEnquiryTable(id);
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			Object[] row = new Object[3];
			for (int i = 0; i<List.size(); i++)
			{
				row[0] = List.get(i).getE_id();
				row[1] = List.get(i).getE_state();
				row[2] = List.get(i).getE_nature();
				model.addRow(row);
			}
		} catch (Exception D) {
			D.printStackTrace();
		}	
	}
}
