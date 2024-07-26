package FinalProject;

import java.awt.EventQueue; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JProgressBar;

public class LoadingScreen {

	private JFrame LoadingFrame;
	private JProgressBar progressBar;
	private static int count;
	private static Timer timer1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadingScreen window = new LoadingScreen();
					window.LoadingFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoadingScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LoadingFrame = new JFrame();
		LoadingFrame.setResizable(false);
		LoadingFrame.getContentPane().setBackground(Color.WHITE);
		LoadingFrame.setBounds(500, 100, 452, 303);
		LoadingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoadingFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Loading....");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel.setBounds(174, 41, 98, 19);
		LoadingFrame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoadingScreen.class.getResource("/FinalProject/245d9d30b0ba45ce3b9768b8e5b52b2b (1).gif")));
		lblNewLabel_1.setBounds(149, 71, 155, 90);
		LoadingFrame.getContentPane().add(lblNewLabel_1);

		progressBar = new JProgressBar();
		progressBar.setBorderPainted(false);
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(new Color(51, 255, 51));
		progressBar.setBounds(82, 172, 267, 28);
		progressBar.setMaximum(50);
		loadProgressBar();
		LoadingFrame.getContentPane().add(progressBar);
	}

	private void loadProgressBar() {
		ActionListener al = new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				count++;
				progressBar.setValue(count);
				if (count == 50) {
					FinalProject_Manalili call = new FinalProject_Manalili();
					call.frame.setVisible(true);
					LoadingFrame.setVisible(false);
					timer1.stop();
				}
			}
		};
		timer1 = new Timer(50, al);
		timer1.start();
	}

}























