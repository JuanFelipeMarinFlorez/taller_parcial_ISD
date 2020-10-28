package chats;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Color;

public class chat_client extends JFrame {private JPanel contentPane;

/**
 * Launch the application.
 */
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				chat_client frame = new chat_client();
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
private chat_client() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 228, 225));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JTextArea msg_area = new JTextArea();
	msg_area.setBackground(new Color(255, 228, 225));
	msg_area.setEditable(false);
	msg_area.setBounds(227, 46, 217, 226);
	contentPane.add(msg_area);
	
	JCheckBox chckbxNewCheckBox = new JCheckBox("Artista1");
	chckbxNewCheckBox.setBounds(17, 63, 156, 23);
	contentPane.add(chckbxNewCheckBox);
	
	JCheckBox chckbxArtista = new JCheckBox("Artista2");
	chckbxArtista.setBounds(17, 106, 156, 23);
	contentPane.add(chckbxArtista);
	
	JCheckBox chckbxArtista_1 = new JCheckBox("Artista3");
	chckbxArtista_1.setBounds(17, 151, 156, 23);
	contentPane.add(chckbxArtista_1);
	
	JCheckBox chckbxArtista_2 = new JCheckBox("Artista4");
	chckbxArtista_2.setBounds(17, 194, 156, 23);
	contentPane.add(chckbxArtista_2);
	
	JTextArea title2 = new JTextArea();
	title2.setBackground(new Color(255, 228, 225));
	title2.setText("                Crick de Artistas");
	title2.setEditable(false);
	title2.setBounds(227, 6, 217, 30);
	contentPane.add(title2);
	
	JTextArea Title1 = new JTextArea();
	Title1.setBackground(new Color(255, 228, 225));
	Title1.setText("                    Artistas");
	Title1.setEditable(false);
	Title1.setBounds(6, 6, 217, 30);
	contentPane.add(Title1);
}
}
