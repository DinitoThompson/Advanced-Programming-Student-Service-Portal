package chat_video;

/*
Member Contribution
Shanice Facey 
Dinito Thompson
*/ 


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.io.IOException;
import com.github.sarxos.webcam.Webcam;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class client extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel img_client;

	/**
	 * Create the frame.
	 */
	public client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 602);
		setTitle("Video Chat - Client");

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

		img_client = new JLabel("");
		img_client.setHorizontalAlignment(SwingConstants.CENTER);
		img_client.setBounds(34, 48, 694, 467);
		contentPane.add(img_client);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new client().setVisible(true);

			}
		});

		Socket s = new Socket("127.0.0.1", 7800);
		ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());

		ImageIcon ic = new ImageIcon();
		BufferedImage br;
		Webcam cam = Webcam.getDefault();
		cam.open();

		while (true) {
			br = cam.getImage();
			ic = new ImageIcon(br);
			out.writeObject(ic);
			out.flush();
			img_client.setIcon(ic);

		}

	}

}
