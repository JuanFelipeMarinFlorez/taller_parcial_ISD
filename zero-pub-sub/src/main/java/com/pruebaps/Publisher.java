package com.pruebaps;

import java.util.Random;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

//
// Patron distribucion one-way data, Publicador Suscriptor
// Tomado de: http://zguide.zeromq.org/java:chapter1
//  Actualizacion del clima server en Java
//  Ata el socket PUB a tcp://*:5556
//  Publica actualizaciones del clima aleatorias
//
public class Publisher
{
	String[] artistas = new String[4];
	String[] mensajes = new String[4];
	
	
	
	public String[] getArtistas() {
		return artistas;
	}
	public void setArtistas(String[] artistas) {
		this.artistas = artistas;
	}
	public String[] getMensajes() {
		return mensajes;
	}
	public void setMensajes(String[] mensajes) {
		this.mensajes = mensajes;
	}
	public Publisher() {
		for (int i=0; i<4; i++) {
    		artistas[i]= new String();
    		mensajes[i]= new String();
        }     
		
	}
	 public void  newMessage(String artista, String mensaje) {
	    	for (int i=0; i<4; i++) {
	        	if(artistas[i]==artista) {
	        		mensajes[i]=mensaje;
	        		
	        	}
	    	}
	    }	
    public void publicar(){
        //Establece el ambiente o contexto zeromq
        try (ZContext context = new ZContext()) {
            //Crea un socket tipo PUB
            ZMQ.Socket publisher = context.createSocket(SocketType.PUB);
            //Ata el socket a un puerto
            publisher.bind("tcp://*:5558");
            publisher.bind("ipc://Cricks");
            Random srandom = new Random(System.currentTimeMillis());
            while (true) {
            	
            	for (int i=0; i<4; i++) {
            		if(!mensajes[i].isEmpty()) {
            			String update = String.format(
                                "%s %s ", artistas[i], mensajes[i]
                            );
            			publisher.send(update, 0);
            			mensajes[i]="";
            		}
            	}
            }
        }
    }
}