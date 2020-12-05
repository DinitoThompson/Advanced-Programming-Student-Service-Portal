package com.gui_demo;

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
	protected static JTextArea TextArea_1;
	private JPanel contentPane;
	private JTextField textField;
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
		 * JTextArea textArea = new JTextArea(); textArea.setEditable(false);
		 * textArea.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		 * textArea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		 * textArea.setBounds(709, 308, 196, 45);
		 */
		JTextField textArea = new JTextField();
		textArea.setEditable(false);
		textArea.setBorder(new LineBorder(new Color(0, 0, 0), 2, false));
		textArea.setHorizontalAlignment(SwingConstants.CENTER);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textArea.setEnabled(false);
		textArea.setBounds(709, 308, 196, 45);
		try {
			java.sql.Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root", "");
			SQLProvider sql = new SQLProvider(conn);
			textArea.setText(sql.SelectStudentName(getLoginId()));
		} catch (SQLException e) {
			e.getMessage();
		}
		contentPane.add(textArea);

		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblStudentId.setBounds(734, 359, 150, 31);
		contentPane.add(lblStudentId);

		JTextField textArea_1 = new JTextField();
		textArea_1.setEditable(false);
		textArea_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, false));
		textArea_1.setHorizontalAlignment(SwingConstants.CENTER);
		textArea_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textArea_1.setEnabled(false);
		textArea_1.setBounds(709, 400, 196, 45);
		textArea_1.setText(getLoginId());
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
					logger.info("Student ID:" + getLoginId() + "Logged Out");
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
				try {
					if (textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please select an Equiry to view", "View Enquiry",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						logger.info("Student ID: " + getLoginId() + " Opted To View Enquiry: " + textField.getText());
						dispose();
						View_Enquiry v = new View_Enquiry(getLoginId(), textField.getText());
						View_Enquiry.textField_5.setText(textField.getText()); // get the enquiry selected and passes it
																				// to the enquiry Id fiels in
																				// view_enquiry frame
						v.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		btnEditEnquiry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Edit s;
				try {
					if (textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please select an Equiry to edit", "Edit Enquiry",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						logger.info("Student ID: " + getLoginId() + " Opted To Edit Enquiry: " + textField.getText());
						s = new Edit(getLoginId(), textField.getText());
						s.setVisible(true);
						dispose();
						Edit.textField_5.setText(textField.getText());
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
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
					logger.info("Student ID: " + getLoginId() + " Opted To Submit An Enquiry");
					s = new Submit_Enquiry(getLoginId());
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
		btnNewButton_1.addActionListener(new ActionListener() {
			// Change this to just change the state of the enquiry
			public void actionPerformed(ActionEvent e) {
				try {
					if (textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please select an Equiry to cancel", "Cancel Enquiry",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						Connection conn;
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal",
								"root", "");
						SQLProvider sql = new SQLProvider(conn);

						boolean CancelEnquiry = sql.CancelStudentEnquiry(textField.getText());

						if (CancelEnquiry) {
							logger.info("Student ID: " + getLoginId() + " Opted To Cancel An Enquiry: "
									+ textField.getText());
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

		JButton btnViewResonses = new JButton("View Responses");
		btnViewResonses.setForeground(Color.WHITE);
		btnViewResonses.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnViewResonses.setBorder(null);
		btnViewResonses.setBackground(new Color(25, 25, 112));
		btnViewResonses.setBounds(225, 489, 167, 54);
		contentPane.add(btnViewResonses);
		btnViewResonses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					if (textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please select an Equiry to view response", "View Response",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						logger.info("Student ID: " + getLoginId() + " Opted To View Responses: " + textField.getText());
						dispose();
						Past_Responses s;
						s = new Past_Responses(getLoginId(), textField.getText());
						Past_Responses.textField.setText(textField.getText());
						s.setVisible(true);
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.BLACK, 1, true));
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField.setBounds(10, 296, 167, 39);
		contentPane.add(textField);
		textField.setEditable(false);
		textField.setColumns(10);

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
				textField.setText(model.getValueAt(selectedRowIndex, 0).toString());
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);

		try {
			show_enquiry(textArea_1.getText());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
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
			TextArea_1.setText(getLoginId());
			frame.setVisible(true);
		} catch (Exception D) {
			D.printStackTrace();
		}
	}
}
