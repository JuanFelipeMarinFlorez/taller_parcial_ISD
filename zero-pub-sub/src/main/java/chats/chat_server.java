package chats;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;

public class chat_server extends JFrame {

	private JPanel contentPane;
	private JTextField msg_text;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chat_server frame = new chat_server();
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
	private chat_server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea msg_area = new JTextArea();
		msg_area.setBackground(new Color(255, 255, 255));
		msg_area.setEditable(false);
		msg_area.setBounds(44, 6, 350, 220);
		contentPane.add(msg_area);
		
		msg_text = new JTextField();
		msg_text.setBounds(39, 235, 270, 26);
		contentPane.add(msg_text);
		msg_text.setColumns(10);
		
		JButton msg_send = new JButton("send");
		msg_send.setForeground(new Color(0, 0, 0));
		msg_send.setBackground(new Color(199, 21, 133));
		msg_send.setBounds(307, 235, 87, 29);
		contentPane.add(msg_send);
	}
}
