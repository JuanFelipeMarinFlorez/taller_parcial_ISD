package com.pruebaps;

import java.util.StringTokenizer;

import javax.swing.JTextArea;

import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;

//
// Patron distribucion one-way data, Publicador Suscriptor
// Tomado de: http://zguide.zeromq.org/java:chapter1
//  Weather update client in Java
//  Connects SUB socket to tcp://localhost:5556
//  Collects weather updates and finds avg temp in zipcode
//
public class Subscriber extends Thread{
	
	String[] artistas = new String[4];
	String mensaje= new String();
	private JTextArea msg_area;
	String menInicial="";
	ZMQ.Socket subscriber;
	
	
	
	
	public ZMQ.Socket getSubscriber() {
		return subscriber;
	}




	public void setSubscriber(ZMQ.Socket subscriber) {
		this.subscriber = subscriber;
	}




	/*
	 * constructor de Subscriber
	 * crea los artistas vacios.
	 */
    public Subscriber() {
    	for (int i=0; i<4; i++) {
    		artistas[i]= "";
        }     
	}
    
    
    
    
    public JTextArea getMsg_area() {
		return msg_area;
	}




	public void setMsg_area(JTextArea msg_area) {
		this.msg_area = msg_area;
	}




	public String getMensaje() {
		return mensaje;
	}




	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}




	public String[] getArtistas() {
		return artistas;
	}



	public void setArtistas(String[] artistas) {
		this.artistas = artistas;
	}



	public void  newSubscription(String artista) {
		boolean encontrado=false;
    	for (int i=0; i<4; i++) {
        	if(artistas[i].isEmpty() && !encontrado) {
        		artistas[i]=artista;
        		encontrado=true;
        		
        	}
		}
		for (int i=0; i<4; i++) {
	                	 
			if( ! artistas[i].isEmpty()) {
				subscriber.subscribe(artistas[i].getBytes(ZMQ.CHARSET));
				
			}
		} 
    }
    
    public void deleteSubscription(String artista) {
    	for (int i=0; i<4; i++) {
    		if(artistas[i]== artista) {
    			artistas[i]="";
    		}
		}
		for (int i=0; i<4; i++) {
	                	 
			if( ! artistas[i].isEmpty()) {
				subscriber.subscribe(artistas[i].getBytes(ZMQ.CHARSET));
				
			}
		} 
    }
    public void run(){
    	
    		try (ZContext context = new ZContext()) {
    			subscriber = context.createSocket(SocketType.SUB);
                subscriber.connect("tcp://192.168.0.14:5559");
                //subscriber.connect("tcp://25.77.197.91:5556");
                subscriber.connect("ipc://Cricks");
    			while(true) {
  
	                //  Socket to talk to server
	               // System.out.println("Collecting updates from weather server");
	               
	                mensaje = subscriber.recvStr(0).trim();
	    	        System.out.println ("Entrada \"" + mensaje +"\"");
	                if( ! menInicial.equals(mensaje)) {
	        			msg_area.setText(msg_area.getText() + '\n'
		                        + mensaje);
	        			menInicial=mensaje;
	        		}
	                
	              
    			}
    			
    		}
    	
    	
    	
    }

}