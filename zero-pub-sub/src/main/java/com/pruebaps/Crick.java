package com.pruebaps;

import java.time.format.DateTimeFormatter;

//Nombre del artista, fecha de publicación, hora de publicación y el mensaje.
public class Crick {
	
	//Atributos
	private String n_artista;
	private DateTimeFormatter fecha_hora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private String mensaje;
	
	
	// Set y get
	public String getN_artista() {
		return n_artista;
	}
	public void setN_artista(String n_artista) {
		this.n_artista = n_artista;
	}
	public DateTimeFormatter getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(DateTimeFormatter fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
