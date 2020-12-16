package chat_video;

/*
Member Contribution
Shanice Facey 
Dinito Thompson
*/ 

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class sever extends JFrame {

	private JPanel contentPane;
	private static JLabel img_server;

	/**
	 * Create the frame.
	 */
	public sever() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Video Chat - Server");
		setBounds(100, 100, 775, 602);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("End");
		button.setBounds(500, 425, 88, 30);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose(); 
			}
			
		});
		contentPane.add(button);

		img_server = new JLabel("");
		img_server.setHorizontalAlignment(SwingConstants.CENTER);
		img_server.setBounds(34, 48, 694, 467);
		contentPane.add(img_server);
	}

	/**
	 * Launch the application.
	 * 
	 * @throws ClassNotFoundException
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new sever().setVisible(true);

			}
		});

		ServerSocket server = new ServerSocket(7800);

		System.out.println("wait....");

		Socket s = server.accept();

		System.out.println("connecting....");

		ObjectInputStream in = new ObjectInputStream(s.getInputStream());

		ImageIcon ic;

		while (true) {
			ic = (ImageIcon) in.readObject();
			img_server.setIcon(ic);
		}

	}

}
