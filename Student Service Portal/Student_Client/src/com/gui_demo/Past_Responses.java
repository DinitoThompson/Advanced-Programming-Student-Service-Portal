package com.gui_demo;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import jdbc.connection.SQLProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Past_Responses extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected static JTextField textField;
	private JTable table;
	private String login_id;
	private String enquiry_id;
	private static final Logger logger = LogManager.getLogger(Past_Responses.class);

	public String getEnquiry_id() {
		return enquiry_id;
	}

	public void setEnquiry_id(String enquiry_id) {
		this.enquiry_id = enquiry_id;
	}

	public void setLoginId(String login_id) {
		this.login_id = login_id;
	}

	public String getLoginId() {
		return this.login_id;
	}

	/**
	 * Create the frame.
	 */
	public Past_Responses(String login_id, String enquiry_id) {

		setLoginId(login_id);
		setEnquiry_id(enquiry_id);

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

		JTextArea txtrNoResponseMade = new JTextArea("");
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

		JRadioButton rdbtnUrgent = new JRadioButton("Live Chat");
		rdbtnUrgent.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnUrgent.setBackground(Color.WHITE);
		rdbtnUrgent.setBounds(222, 483, 139, 21);
		contentPane.add(rdbtnUrgent);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(new Color(25, 25, 112));
		btnSubmit.setBorder(null);
		btnSubmit.setBounds(520, 480, 85, 21);
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnUrgent.isSelected()) {
					logger.info(
							"Student ID: " + getLoginId() + " Opted To Schedule A Live For Enquiry: " + getEnquiry_id());
					Client_Chat c = new Client_Chat();
					c.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Select An Option", "Selection Error",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		contentPane.add(btnSubmit);

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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Response", "Response Date" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				txtrNoResponseMade.setText(model.getValueAt(selectedRowIndex, 0).toString());
			}

		});
		scrollPane.setViewportView(table);
		repaint();
		try {
			showResponse(getEnquiry_id());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void showResponse(String enquiry_id) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_services_portal", "root",
				"");
		SQLProvider sql = new SQLProvider(conn);
		ArrayList<Enquiry> List = sql.EnquiryResponse(enquiry_id);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[3];
		for (int i = 0; i < List.size(); i++) {
			row[0] = List.get(i).getEnquiry_response();
			row[1] = List.get(i).getEnquiry_response_date();
			model.addRow(row);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			Past_Responses frame = new Past_Responses(getLoginId(), getEnquiry_id());
			frame.setVisible(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
