package com.gui_demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import client_Chat.Client_Chat;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Staff_Dashborad extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table_2;
	/**
	 * Create the frame.
	 */
	public Staff_Dashborad() {
		setResizable(false);
		setTitle("Staff Dashboard");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Client_Chat.class.getResource("/res/utech.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 837, 775);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Staff_Dashborad.class.getResource("/res/utech.jpg")));
		lblNewLabel.setBounds(583, 73, 230, 260);
		contentPane.add(lblNewLabel);
		
		JLabel lblName_1_1 = new JLabel("Staff Name");
		lblName_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1.setBounds(619, 330, 155, 43);
		contentPane.add(lblName_1_1);
		
		JLabel lblName_1_1_1 = new JLabel("Staff ID");
		lblName_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1_1.setBounds(619, 434, 155, 43);
		contentPane.add(lblName_1_1_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(583, 383, 228, 50);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(585, 487, 228, 50);
		contentPane.add(textField_1);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(25, 25, 112));
		btnLogOut.setBounds(661, 547, 92, 30);
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
		contentPane.add(btnLogOut);
		
		JLabel lblNewLabel_1 = new JLabel("All Enquiries");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1.setBounds(229, 10, 319, 30);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(222, 73, 326, 164);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setGridColor(Color.WHITE);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Resolved", "Nature", "Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				Short.class, Long.class, Long.class
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
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(224, 511, 329, 187);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Status", "Session ID", "Student ID", "Nature"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Long.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_2 = new JLabel("All Live Sessions");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2.setBounds(171, 451, 404, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblName_1_1_2 = new JLabel("Session ID");
		lblName_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1_2.setBounds(20, 540, 155, 43);
		contentPane.add(lblName_1_1_2);
		
		JLabel lblName_1_1_2_1 = new JLabel("Enquiry ID");
		lblName_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1_2_1.setBounds(20, 145, 155, 43);
		contentPane.add(lblName_1_1_2_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(10, 608, 165, 50);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(10, 187, 165, 50);
		contentPane.add(textField_3);
		
		JButton btnJoinSession = new JButton("Join Session");
		btnJoinSession.setForeground(Color.WHITE);
		btnJoinSession.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnJoinSession.setBorder(null);
		btnJoinSession.setBackground(new Color(25, 25, 112));
		btnJoinSession.setBounds(31, 668, 122, 30);
		btnJoinSession.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
					Client_Chat c = new Client_Chat();
					c.setVisible(true);
			    
			}
		});
		contentPane.add(btnJoinSession);
		
		JButton btnOpenEnquiry = new JButton("Open Enquiry");
		btnOpenEnquiry.setForeground(Color.WHITE);
		btnOpenEnquiry.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnOpenEnquiry.setBorder(null);
		btnOpenEnquiry.setBackground(new Color(25, 25, 112));
		btnOpenEnquiry.setBounds(20, 247, 122, 30);
		btnOpenEnquiry.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				//capture the enquiry ID selected and display the info on the Enquiry_Response() frame.
				Enquiry_Response v = new Enquiry_Response();
				v.setVisible(true);
			}
		});
		contentPane.add(btnOpenEnquiry);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(222, 268, 331, 174);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Unresolved", "Nature", "Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				Short.class, Long.class, Long.class
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
		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		scrollPane_2.setViewportView(table_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Staff_Dashborad frame = new Staff_Dashborad();
			frame.setVisible(true);
		} catch (Exception p) {
			p.printStackTrace();
		}
		
	}
}
