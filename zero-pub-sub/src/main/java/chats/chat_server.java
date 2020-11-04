package chats;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerListModel;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.pruebaps.Crick;
import com.pruebaps.Publisher;

import javax.swing.JSpinner;

public class chat_server extends JFrame {

	private JPanel contentPane;
	private  JTextField msg_text;
	private  JTextArea msg_area;
	private JScrollPane scrollingArea;

	/**
	 * Launch the application.
	 */
	
	
	public  void meterinfo(String info) {
		msg_area.setText(msg_area.getText() + '\n'
                + info);
	}
	
	/**
	 * Create the frame.
	 */
	public chat_server(Publisher pub) {
		
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		msg_text = new JTextField();
		msg_text.setBounds(6, 243, 274, 29);
		contentPane.add(msg_text);
		msg_text.setColumns(10);
		
		 msg_area = new JTextArea();
		 msg_area.setBounds(35, 8, 322, 211);
	   	 contentPane.add(msg_area);
		 msg_area.setEditable(false);
		 msg_area.setBackground(Color.WHITE);
			
		scrollingArea = new JScrollPane(msg_area);
		scrollingArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollingArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollingArea.setBounds(6, 6, 466, 233);
		contentPane.add(scrollingArea);
		
		SpinnerListModel listModel = new SpinnerListModel(new String[] {"Shakira ","Bad Bunny","Juanes","Maluma"});
	    JSpinner spinner = new JSpinner(listModel);
	    spinner.setValue("Shakira ");
		spinner.setToolTipText("");
		spinner.setBounds(363, 244, 109, 28);
		contentPane.add(spinner);
		
		JButton msg_send = new JButton("send");
		msg_send.setForeground(new Color(0, 0, 0));
		msg_send.setBackground(new Color(199, 21, 133));
		msg_send.setBounds(281, 244, 87, 29);
		msg_send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Crick mensajito = new Crick((String)spinner.getValue(),msg_text.getText());
				meterinfo((String)spinner.getValue()+mensajito.toString());
				pub.newMessage((String)spinner.getValue(), mensajito.toString());
				msg_text.setText("");
			}
		});
		contentPane.add(msg_send);
		
		
		
	}
}
