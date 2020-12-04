package com.staff_demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class Head extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application, Main class
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Head frame = new Head();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Head() throws IOException {
		setResizable(false);
		setTitle("Utech JA - Staff");
		setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getResource("/res/utech.jpg"))));
		setBounds(new Rectangle(100, 100, 800, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 469);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Gabriola", Font.ITALIC, 28));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(1, 1, 200, 200);
		label.setIcon(new ImageIcon((getClass().getResource("/res/FrameLiner.png"))));
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(299, 1, 220, 229);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon((getClass().getResource("/res/utech.jpg"))));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 1, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_1.setIcon(new ImageIcon((getClass().getResource("/res/Frame1.png"))));
		lblNewLabel_1.setBounds(552, 164, 294, 268);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblStudentServicesPortal = new JLabel("Staff Services Portal");
		lblStudentServicesPortal.setBounds(329, 265, 210, 26);
		lblStudentServicesPortal.setFont(new Font("Times New Roman", Font.ITALIC, 22));
		lblStudentServicesPortal.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblStudentServicesPortal);
		
		JPanel panel = new JPanel();
		panel.setBounds(364, 327, 132, 41);
		panel.setBackground(new Color(25, 25, 112));
		panel.setLayout(null);
		contentPane.add(panel);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setForeground(Color.WHITE);
		btnContinue.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		btnContinue.setBackground(new Color(25, 25, 112));
		btnContinue.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		Login s;
				try {
					s = new Login();
					s.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
		btnContinue.setBorder(null);
		btnContinue.setBounds(0, 0, 132, 41);
		panel.add(btnContinue);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Head frame = new Head();
			frame.setVisible(true);
		} catch (Exception o) {
			o.printStackTrace();
		}
		
	}
}
