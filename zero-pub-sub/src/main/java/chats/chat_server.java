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
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSpinner;

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
	public chat_server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollingArea = new JScrollPane((Component) null);
		scrollingArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollingArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollingArea.setBounds(6, 6, 438, 233);
		contentPane.add(scrollingArea);
		
		msg_text = new JTextField();
		msg_text.setBounds(6, 243, 274, 29);
		contentPane.add(msg_text);
		msg_text.setColumns(10);
		
		JButton msg_send = new JButton("send");
		msg_send.setForeground(new Color(0, 0, 0));
		msg_send.setBackground(new Color(199, 21, 133));
		msg_send.setBounds(281, 244, 87, 29);
		contentPane.add(msg_send);
		
		JTextArea msg_area = new JTextArea();
		msg_area.setBounds(35, 8, 322, 211);
		contentPane.add(msg_area);
		msg_area.setEditable(false);
		msg_area.setBackground(Color.WHITE);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(363, 244, 81, 28);
		contentPane.add(spinner);
	}
}
