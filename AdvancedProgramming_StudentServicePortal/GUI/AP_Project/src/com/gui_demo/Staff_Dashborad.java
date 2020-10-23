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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Staff_Dashborad extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_Dashborad frame = new Staff_Dashborad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Staff_Dashborad() {
		setTitle("Staff Dashboard");
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
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setColumns(10);
		textField.setBounds(583, 383, 228, 50);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_1.setColumns(10);
		textField_1.setBounds(585, 487, 228, 50);
		contentPane.add(textField_1);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(25, 25, 112));
		btnLogOut.setBounds(661, 547, 92, 30);
		contentPane.add(btnLogOut);
		
		JLabel lblNewLabel_1 = new JLabel("All Enquiries");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1.setBounds(155, 10, 319, 30);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 73, 407, 214);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setGridColor(Color.WHITE);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Unresolved", "Resolved", "Nature", "Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Boolean.class, Long.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(120, 370, 414, 187);
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
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_2 = new JLabel("All Live Sessions");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2.setBounds(120, 310, 404, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblName_1_1_2 = new JLabel("Session ID");
		lblName_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1_2.setBounds(10, 567, 155, 43);
		contentPane.add(lblName_1_1_2);
		
		JLabel lblName_1_1_2_1 = new JLabel("Enquiry ID");
		lblName_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1_2_1.setBounds(200, 567, 155, 43);
		contentPane.add(lblName_1_1_2_1);
		
		JLabel lblName_1_1_2_2 = new JLabel("Enquiry Type");
		lblName_1_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1_1_2_2.setBounds(393, 567, 155, 43);
		contentPane.add(lblName_1_1_2_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_2.setColumns(10);
		textField_2.setBounds(10, 610, 165, 50);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_3.setColumns(10);
		textField_3.setBounds(194, 610, 165, 50);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField_4.setColumns(10);
		textField_4.setBounds(393, 610, 165, 50);
		contentPane.add(textField_4);
		
		JButton btnJoinSession = new JButton("Join Session");
		btnJoinSession.setForeground(Color.WHITE);
		btnJoinSession.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnJoinSession.setBorder(null);
		btnJoinSession.setBackground(new Color(25, 25, 112));
		btnJoinSession.setBounds(31, 668, 122, 30);
		contentPane.add(btnJoinSession);
		
		JButton btnOpenEnquiry = new JButton("Open Enquiry");
		btnOpenEnquiry.setForeground(Color.WHITE);
		btnOpenEnquiry.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnOpenEnquiry.setBorder(null);
		btnOpenEnquiry.setBackground(new Color(25, 25, 112));
		btnOpenEnquiry.setBounds(216, 670, 122, 30);
		contentPane.add(btnOpenEnquiry);
		
		JButton btnFilterEnquiry = new JButton("Filter Enquiry");
		btnFilterEnquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFilterEnquiry.setForeground(Color.WHITE);
		btnFilterEnquiry.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnFilterEnquiry.setBorder(null);
		btnFilterEnquiry.setBackground(new Color(25, 25, 112));
		btnFilterEnquiry.setBounds(417, 670, 122, 30);
		contentPane.add(btnFilterEnquiry);
	}

}
