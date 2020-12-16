package com.gui_demo;

/*
Member Contribution
Shanice Facey 
Tyeree Tinker 
Dinito Thompson
*/

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
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import client_Chat.Client_Chat;
import jdbc.connection.SQLProvider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Student_Dashboard extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static JTextArea studentID;
	private JPanel contentPane;
	private JTextField enquiryID;
	private static final Logger logger = LogManager.getLogger(Student_Dashboard.class);
	private String login_id;

	PreparedStatement pst;
	Connection conn;
	Cover c;
	SQLProvider SQL;

	JTable table;

	/**
	 * Create the frame.
	 */

	public void setLoginId(String login_id) {
		this.login_id = login_id;
	}

	public String getLoginId() {
		return this.login_id;
	}

	public Student_Dashboard(String login_id) {

		setLoginId(login_id);
		setResizable(false);
		setTitle("STUDENT DASHBOARD");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Client_Chat.class.getResource("/res/utech.jpg")));
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

		/*
		 * JTextArea studentName = new JTextArea(); studentName.setEditable(false);
		 * studentName.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		 * studentName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		 * studentName.setBounds(709, 308, 196, 45);
		 */
		JTextField studentName = new JTextField();
		studentName.setEditable(false);
		studentName.setBorder(new LineBorder(new Color(0, 0, 0), 2, false));
		studentName.setHorizontalAlignment(SwingConstants.CENTER);
		studentName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		studentName.setEnabled(false);
		studentName.setBounds(709, 308, 196, 45);
		try {
			java.sql.Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
			SQLProvider sql = new SQLProvider(conn);
			studentName.setText(sql.SelectStudentName(getLoginId()));
		} catch (SQLException e) {
			e.getMessage();
		}
		contentPane.add(studentName);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblStudentId.setBounds(734, 359, 150, 31);
		contentPane.add(lblStudentId);

		JTextField studentID = new JTextField();
		studentID.setEditable(false);
		studentID.setBorder(new LineBorder(new Color(0, 0, 0), 2, false));
		studentID.setHorizontalAlignment(SwingConstants.CENTER);
		studentID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		studentID.setEnabled(false);
		studentID.setBounds(709, 400, 196, 45);
		studentID.setText(getLoginId());
		contentPane.add(studentID);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setBounds(759, 490, 122, 45);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton logoutBtn = new JButton("LOG OUT");
		logoutBtn.setForeground(Color.WHITE);
		logoutBtn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		logoutBtn.setBackground(new Color(25, 25, 112));
		logoutBtn.setBorder(null);
		logoutBtn.setBounds(0, 0, 122, 45);
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Front f;
				try {
					logger.info("Student ID:" + getLoginId() + "Logged Out");
					f = new Front();
					f.setVisible(true);
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});
		panel.add(logoutBtn);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(25, 25, 112));
		panel_1.setForeground(new Color(25, 25, 112));
		panel_1.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		panel_1.setBounds(10, 435, 167, 54);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton viewEnquiry = new JButton("View Enquiry");
		viewEnquiry.setBounds(0, 0, 167, 54);
		panel_1.add(viewEnquiry);
		viewEnquiry.setForeground(Color.WHITE);
		viewEnquiry.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewEnquiry.setBackground(new Color(25, 25, 112));
		viewEnquiry.setBorder(null);
		viewEnquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (enquiryID.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please select an Equiry to view", "View Enquiry",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						logger.info("Student ID: " + getLoginId() + " Opted To View Enquiry: " + enquiryID.getText());
						dispose();
						View_Enquiry v = new View_Enquiry(getLoginId(), enquiryID.getText());
						View_Enquiry.enquiryID.setText(enquiryID.getText()); 
						v.setVisible(true);
					}
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(25, 25, 112));
		panel_2.setBounds(10, 359, 167, 54);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton editEnquiry = new JButton("Edit Enquiry");
		editEnquiry.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		editEnquiry.setForeground(Color.WHITE);
		editEnquiry.setBackground(new Color(25, 25, 112));
		editEnquiry.setBorder(null);
		editEnquiry.setBounds(10, 0, 157, 54);
		editEnquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Edit s;
				try {
					if (enquiryID.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please select an Equiry to edit", "Edit Enquiry",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						logger.info("Student ID: " + getLoginId() + " Opted To Edit Enquiry: " + enquiryID.getText());
						s = new Edit(getLoginId(), enquiryID.getText());
						s.setVisible(true);
						dispose();
						Edit.enquiryID.setText(enquiryID.getText());
					}

				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});
		panel_2.add(editEnquiry);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(25, 25, 112));
		panel_2_1.setBounds(509, 490, 167, 54);
		contentPane.add(panel_2_1);

		JButton submitEnquiry = new JButton("Submit Enquiry");
		submitEnquiry.setBounds(0, 10, 167, 34);
		panel_2_1.add(submitEnquiry);
		submitEnquiry.setForeground(Color.WHITE);
		submitEnquiry.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		submitEnquiry.setBackground(new Color(25, 25, 112));
		submitEnquiry.setBorder(null);
		submitEnquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Submit_Enquiry s;
				try {
					logger.info("Student ID: " + getLoginId() + " Opted To Submit An Enquiry");
					s = new Submit_Enquiry(getLoginId());
					s.setVisible(true);
				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});

		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(25, 25, 112));
		panel_2_1_1.setBounds(10, 498, 167, 54);
		contentPane.add(panel_2_1_1);

		JButton cancelEnquiry = new JButton("Cancel Enquiry");
		cancelEnquiry.setBounds(10, 0, 167, 54);
		panel_2_1_1.add(cancelEnquiry);
		cancelEnquiry.setBorder(null);
		cancelEnquiry.setBackground(new Color(25, 25, 112));
		cancelEnquiry.setForeground(Color.WHITE);
		cancelEnquiry.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cancelEnquiry.addActionListener(new ActionListener() {
			// Change this to just change the state of the enquiry
			public void actionPerformed(ActionEvent e) {
				try {
					if (enquiryID.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please select an Equiry to cancel", "Cancel Enquiry",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						Connection conn;
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal",
								"root", "");
						SQLProvider sql = new SQLProvider(conn);

						boolean CancelEnquiry = sql.CancelStudentEnquiry(enquiryID.getText());

						if (CancelEnquiry) {
							logger.info("Student ID: " + getLoginId() + " Opted To Cancel An Enquiry: "
									+ enquiryID.getText());
							JOptionPane.showMessageDialog(null, "Enquiry Canceled !", "Status",
									JOptionPane.INFORMATION_MESSAGE);
							Student_Dashboard p = new Student_Dashboard(getLoginId());
							dispose();
							p.setVisible(true);
						}
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Enquiry Cancellation Failed...", "Status",
							JOptionPane.INFORMATION_MESSAGE);
					Student_Dashboard p = new Student_Dashboard(getLoginId());
					dispose();
					p.setVisible(true);
				}
			}
		});

		JButton viewResponses = new JButton("View Responses");
		viewResponses.setForeground(Color.WHITE);
		viewResponses.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		viewResponses.setBorder(null);
		viewResponses.setBackground(new Color(25, 25, 112));
		viewResponses.setBounds(225, 489, 167, 54);
		contentPane.add(viewResponses);
		viewResponses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (enquiryID.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please select an Equiry to view response", "View Response",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						logger.info("Student ID: " + getLoginId() + " Opted To View Responses: " + enquiryID.getText());
						dispose();
						Past_Responses s;
						s = new Past_Responses(getLoginId(), enquiryID.getText());
						Past_Responses.enquiryID.setText(enquiryID.getText());
						s.setVisible(true);
					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});

		enquiryID = new JTextField();
		enquiryID.setBorder(new LineBorder(Color.BLACK, 1, true));
		enquiryID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		enquiryID.setBounds(10, 296, 167, 39);
		contentPane.add(enquiryID);
		enquiryID.setEditable(false);
		enquiryID.setColumns(10);

		JLabel lblEnquiryId = new JLabel("Enquiry Id");
		lblEnquiryId.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnquiryId.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblEnquiryId.setBounds(20, 255, 157, 31);
		contentPane.add(lblEnquiryId);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(228, 119, 448, 355);
		contentPane.add(scrollPane);

		table = new JTable(); // this table should be an internal frame that has a table from the enquiry
								// classS
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Enquiry ID", "State", "Nature" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				enquiryID.setText(model.getValueAt(selectedRowIndex, 0).toString());
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);

		try {
			show_enquiry(studentID.getText());
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		JLabel lblAllEnquiries = new JLabel("All Enquiries");
		lblAllEnquiries.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllEnquiries.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblAllEnquiries.setBounds(365, 64, 175, 31);
		contentPane.add(lblAllEnquiries);

	}

	public void show_enquiry(String id) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root",
				"");
		SQLProvider sql = new SQLProvider(conn);
		ArrayList<Enquiry> List = sql.StudentEnquiryTable(getLoginId());
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[3];
		for (int i = 0; i < List.size(); i++) {
			row[0] = List.get(i).getE_id();
			row[1] = List.get(i).getE_state();
			row[2] = List.get(i).getE_nature();
			model.addRow(row);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Student_Dashboard frame = new Student_Dashboard(getLoginId());
			studentID.setText(getLoginId());
			frame.setVisible(true);
		} catch (Exception D) {
			D.printStackTrace();
		}
	}
}
