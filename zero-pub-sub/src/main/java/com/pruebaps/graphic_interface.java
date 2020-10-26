package com.pruebaps;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class graphic_interface {

	private JFrame frame;
	private JTextField escribir_mensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graphic_interface window = new graphic_interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public graphic_interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		escribir_mensaje = new JTextField();
		escribir_mensaje.setBounds(22, 228, 292, 20);
		panel.add(escribir_mensaje);
		escribir_mensaje.setColumns(10);
		
		JButton boton_enviar = new JButton("Enviar");
		boton_enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		boton_enviar.setBounds(324, 227, 89, 23);
		panel.add(boton_enviar);
		
		JScrollPane ver_mensaje = new JScrollPane();
		ver_mensaje.setBounds(22, 11, 390, 206);
		panel.add(ver_mensaje);
	}
}
