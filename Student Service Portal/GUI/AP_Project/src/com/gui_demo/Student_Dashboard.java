package com.gui_demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Student_Dashboard extends JFrame implements ActionListener {

	private JPanel contentPane;

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
		
		JButton btnNewButton_1 = new JButton("Cancel Enquiry");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(25, 25, 112));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(0, 0, 167, 54);
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// run database query to delete enquiry selected
			}	
		});
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(25, 25, 112));
		panel_2.setBounds(10, 359, 167, 54);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("View Enquiry");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				// connect database and run view/select query based on the student id to display the necessary info on the table in Past_Enquiries()
				Past_Enquiries p;
				try {
					p = new Past_Enquiries();
					p.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(0, 0, 167, 54);
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(25, 25, 112));
		panel_3.setBounds(10, 507, 167, 45);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Submit Enquiry");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnNewButton_2.setBackground(new Color(25, 25, 112));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBounds(0, 0, 167, 45);
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
		panel_3.add(btnNewButton_2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Student_Dashboard frame = new Student_Dashboard();
			frame.setVisible(true);
		} catch (Exception D) {
			D.printStackTrace();
		}
		
	}

}
