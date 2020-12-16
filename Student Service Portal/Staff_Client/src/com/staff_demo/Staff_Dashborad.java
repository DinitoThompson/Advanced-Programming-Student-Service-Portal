package com.staff_demo;

/*
Member Contribution
Shanice Facey 
Tyeree Tinker 
Dinito Thompson
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Staff_Chat.Client_Chat;
import jdbc.connection1.SQLProvider;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Staff_Dashborad extends JFrame implements ActionListener {

	private static final Logger logger = LogManager.getLogger(Staff_Dashborad.class);

	private JPanel contentPane;
	private JTextField staffName;
	protected static JTextField staffID;
	private JTable resolvedTable;
	private JTable unresolvedTable;
	private JTextField sessionID;
	private JTextField enquiryID;
	private JTable table_2;
	private String login_id;

	/**
	 * Create the frame.
	 */

	public void setLoginId(String login_id) {
		this.login_id = login_id;
	}

	public String getLoginId() {
		return this.login_id;
	}

	public Staff_Dashborad(String login_id) {

		setLoginId(login_id);

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

		staffName = new JTextField();
		staffName.setEnabled(false);
		staffName.setHorizontalAlignment(SwingConstants.CENTER);
		staffName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		staffName.setColumns(10);
		staffName.setBounds(583, 383, 228, 50);
		try {
			java.sql.Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
			SQLProvider sql = new SQLProvider(conn);
			staffName.setText(sql.SelectStaffName(getLoginId()));
		} catch (SQLException e) {
			e.getMessage();
		}
		contentPane.add(staffName);

		staffID = new JTextField();
		staffID.setEnabled(false);
		staffID.setHorizontalAlignment(SwingConstants.CENTER);
		staffID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		staffID.setColumns(10);
		staffID.setBounds(585, 485, 228, 50);
		staffID.setText(getLoginId());
		contentPane.add(staffID);

		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(25, 25, 112));
		btnLogOut.setBounds(661, 547, 92, 30);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Head f;
				try {
					f = new Head();
					f.setVisible(true);
				} catch (IOException e1) {
					
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

		resolvedTable = new JTable();
		resolvedTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		resolvedTable.setGridColor(Color.WHITE);
		resolvedTable.setBackground(Color.WHITE);
		resolvedTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Resolved", "Nature", "Date" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Short.class, Long.class, Long.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		resolvedTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) resolvedTable.getModel();
				int selectedRowIndex = resolvedTable.getSelectedRow();
				enquiryID.setText(model.getValueAt(selectedRowIndex, 0).toString());
			}
		});

		resolvedTable.getColumnModel().getColumn(0).setResizable(false);
		resolvedTable.getColumnModel().getColumn(1).setResizable(false);
		resolvedTable.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(resolvedTable);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(224, 511, 329, 187);
		contentPane.add(scrollPane_1);

		try {
			show_resolved_enquiry();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}

		unresolvedTable = new JTable();
		unresolvedTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Status", "Session ID", "Student ID", "Nature" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, Integer.class, Integer.class, Long.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(unresolvedTable);

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

		sessionID = new JTextField();
		sessionID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		sessionID.setColumns(10);
		sessionID.setBounds(10, 608, 165, 50);
		contentPane.add(sessionID);

		enquiryID = new JTextField();
		enquiryID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		enquiryID.setColumns(10);
		enquiryID.setBounds(10, 187, 165, 50);
		enquiryID.setEditable(false);
		contentPane.add(enquiryID);

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
		btnOpenEnquiry.setBounds(20, 247, 122, 30);
		btnOpenEnquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Staff ID:" + getLoginId() + "Opted To Open Enquiry: " + enquiryID.getText());
				if (enquiryID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please select an enquiry", "Enquiry Selection",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// capture the enquiry ID selected and display the info on the
					// Enquiry_Response() frame.
					Enquiry_Response v = new Enquiry_Response(getLoginId(), enquiryID.getText());
					// Enquiry_Response.textField_5.setText(enquiryID.getText());
					Enquiry_Response.staffName.setText(getLoginId());
					try {
						java.sql.Connection conn = DriverManager
								.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
						SQLProvider sql = new SQLProvider(conn);
						Enquiry_Response.staffID.setText(sql.SelectStaffName(getLoginId()));
						dispose();
					} catch (SQLException e1) {
						e1.getMessage();
					}
					v.setVisible(true);

				}

			}
		});
		contentPane.add(btnOpenEnquiry);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(222, 268, 331, 174);
		contentPane.add(scrollPane_2);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Unresolved", "Nature", "Date" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Short.class, Long.class, Long.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_2.getModel();
				int selectedRowIndex = table_2.getSelectedRow();
				enquiryID.setText(model.getValueAt(selectedRowIndex, 0).toString());
			}
		});

		table_2.getColumnModel().getColumn(0).setResizable(false);
		table_2.getColumnModel().getColumn(1).setResizable(false);
		table_2.getColumnModel().getColumn(2).setResizable(false);
		scrollPane_2.setViewportView(table_2);
		try {
			show_unresolved_enquiry();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Staff_Dashborad frame = new Staff_Dashborad(getLoginId());
			frame.setVisible(true);
		} catch (Exception p) {
			p.printStackTrace();
		}

	}

	public void show_resolved_enquiry() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root",
				"");
		SQLProvider sql = new SQLProvider(conn);
		ArrayList<com.gui_demo.Enquiry> List = sql.ResolvedEnquiry();
		DefaultTableModel model = (DefaultTableModel) resolvedTable.getModel();
		Object[] row = new Object[3];
		for (int i = 0; i < List.size(); i++) {
			row[0] = List.get(i).getE_id();
			row[1] = List.get(i).getE_state();
			row[2] = List.get(i).getE_nature();
			model.addRow(row);
		}
	}

	public void show_unresolved_enquiry() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root",
				"");
		SQLProvider sql = new SQLProvider(conn);
		ArrayList<com.gui_demo.Enquiry> List = sql.UnresolvedEnquiry();
		DefaultTableModel model = (DefaultTableModel) table_2.getModel();
		Object[] row = new Object[3];
		for (int i = 0; i < List.size(); i++) {
			row[0] = List.get(i).getE_id();
			row[1] = List.get(i).getE_state();
			row[2] = List.get(i).getE_nature();
			model.addRow(row);
		}
	}
}
