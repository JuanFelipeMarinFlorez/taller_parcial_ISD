package com.pruebaps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Nombre del artista, fecha de publicación, hora de publicación y el mensaje.
public class Crick {
	
	public Crick(String n_artista, String mensaje) {
		this.n_artista = n_artista;
		this.fecha = this.formatof.format(now);
		this.hora = this.formatoh.format(now);
		this.mensaje = mensaje;
	}
	
	public Crick() {
		// TODO Auto-generated constructor stub
		this.fecha = this.formatof.format(now);
		this.hora = this.formatoh.format(now);
	}

	//Atributos
	private String n_artista;
	private DateTimeFormatter formatof = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private DateTimeFormatter formatoh = DateTimeFormatter.ofPattern("HH:mm a");
	private LocalDateTime now = LocalDateTime.now();
	private String fecha;
	private String hora;
	private String mensaje;
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	
	
	
	// Set y get
	public String getN_artista() {
		return n_artista;
	}
	public void setN_artista(String n_artista) {
		this.n_artista = n_artista;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String toString(){
		return n_artista+ " / "+ fecha + " / "+ hora + " / "+  mensaje ;
	}

}
