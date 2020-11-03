package chats;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.pruebaps.Crick;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import java.awt.Font;

public class chat_client extends JFrame {
	
	private JPanel contentPane;
	private static JTextArea msg_area;
	private JScrollPane scrollingArea;

	private static void meterinfo(String info) {
		msg_area.setText(msg_area.getText() + '\n'
                + info);
	}
	

	
public static void main(String[] args) {
	
	
	//prueba 
	final Crick publicacion = new Crick("Selena Gomez", "Unete a Pantene y notarás la diferencia la la la la la la Unete a Pantene y notarás la diferencia la la la la la la ");
	
	//final String mensaje=publicacion.transform(publicacion.getMensaje());
	
	final String texto =  
			"\n" + "  Artista : " + publicacion.getN_artista() +
			"\n" + "  Mensaje : " + publicacion.getMensaje() +
			"\n" + "  Publicado el " + publicacion.getFecha() +
			"\n" + "  A las: " + publicacion.getHora() + "\n"
			+ "\n  ";
	
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				chat_client frame = new chat_client();
				frame.setVisible(true);
				for (int i=0; i<20; i++) {
					meterinfo(texto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}


/**
 * Create the frame.
 */
public chat_client() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 510, 300);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 228, 225));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JCheckBox chckbxArtista = new JCheckBox("Shakira");
	chckbxArtista.setBounds(17, 106, 122, 23);
	contentPane.add(chckbxArtista);
	
	JCheckBox chckbxArtista_1 = new JCheckBox("Maluma");
	chckbxArtista_1.setBounds(17, 151, 122, 23);
	contentPane.add(chckbxArtista_1);
	
	JCheckBox chckbxArtista_2 = new JCheckBox("Bad bunny ");
	chckbxArtista_2.setBounds(17, 194, 122, 23);
	contentPane.add(chckbxArtista_2);
	
	JCheckBox chckbxNewCheckBox = new JCheckBox("Juanes");
	chckbxNewCheckBox.setBounds(17, 63, 122, 23);
	contentPane.add(chckbxNewCheckBox);
	
	JTextArea title2 = new JTextArea();
	title2.setBackground(new Color(255, 228, 225));
	title2.setText("                Crick de Artistas");
	title2.setEditable(false);
	title2.setBounds(185, 6, 259, 23);
	contentPane.add(title2);
	
	JTextArea Title1 = new JTextArea();
	Title1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
	Title1.setBackground(new Color(255, 228, 225));
	Title1.setText("       Artistas");
	Title1.setEditable(false);
	Title1.setBounds(10, 6, 129, 23);
	contentPane.add(Title1);
	
	msg_area = new JTextArea(10,10);
	msg_area.setForeground(Color.BLACK);
	msg_area.setBackground(Color.WHITE);
	msg_area.setEditable(false);
	//msg_area.setBounds(171, 30, 313, 226);
	//contentPane.add(msg_area);
	scrollingArea = new JScrollPane(msg_area);
	scrollingArea.setBounds(153, 30, 327,230);
	scrollingArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrollingArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	contentPane.add(scrollingArea);
	
	
}
}


