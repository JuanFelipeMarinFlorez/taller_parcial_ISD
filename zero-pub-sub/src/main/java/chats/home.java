package chats;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.pruebaps.Publisher;
import com.pruebaps.Subscriber;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home extends JFrame {

	private JPanel contentPane;
	private JTextField txtSeleccionaTuUsuario;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
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
	private home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Publisher pub= new Publisher();	
		pub.start();
		pub.setArtistas(new String[] {"Shakira ","Bad Bunny","Juanes","Maluma"});
		
		JButton msg_send = new JButton("Artista");
		msg_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				chat_server artista = new chat_server(pub);
				artista.setVisible(true);
			}
		});
		msg_send.setForeground(new Color(0, 0, 0));
		msg_send.setBackground(new Color(199, 21, 133));
		msg_send.setBounds(6, 121, 221, 100);
		contentPane.add(msg_send);
		
		JButton msg_send_1 = new JButton("Suscriptor");
		msg_send_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Subscriber sub= new Subscriber();
				chat_client suscriptor = new chat_client(sub);
				suscriptor.setVisible(true);
			}
		});
		msg_send_1.setForeground(Color.BLACK);
		msg_send_1.setBackground(new Color(199, 21, 133));
		msg_send_1.setBounds(223, 121, 221, 100);
		contentPane.add(msg_send_1);
		
		txtSeleccionaTuUsuario = new JTextField();
		txtSeleccionaTuUsuario.setBackground(new Color(255, 204, 204));
		txtSeleccionaTuUsuario.setEditable(false);
		txtSeleccionaTuUsuario.setText(" Selecciona tu usuario");
		txtSeleccionaTuUsuario.setBounds(148, 30, 156, 56);
		contentPane.add(txtSeleccionaTuUsuario);
		txtSeleccionaTuUsuario.setColumns(10);
	}
}
