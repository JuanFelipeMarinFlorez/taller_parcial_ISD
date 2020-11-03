package com.pruebaps;

import java.util.StringTokenizer;

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
public class Subscriber{
	
	String[] artistas = new String[4];
	
	
	/*
	 * constructor de Subscriber
	 * crea los artistas vacios.
	 */
    public Subscriber() {
    	for (int i=0; i<4; i++) {
    		artistas[i]= new String();
        }     
	}
    
    
    
    public String[] getArtistas() {
		return artistas;
	}



	public void setArtistas(String[] artistas) {
		this.artistas = artistas;
	}



	public void  newSubscription(String artista) {
    	for (int i=0; i<4; i++) {
        	if(artistas[i].isEmpty()) {
        		artistas[i]=artista;
        		
        	}
    	}
    }
    
    public void deleteSubscription(String artista) {
    	for (int i=0; i<4; i++) {
    		if(artistas[i]== artista) {
    			artistas[i]="";
    		}
    	}
    }
    public void subcripcion(){
    	
    		try (ZContext context = new ZContext()) {
    			ZMQ.Socket subscriber = context.createSocket(SocketType.SUB);
                subscriber.connect("tcp://192.168.0.14:5558");
                //subscriber.connect("tcp://25.77.197.91:5556");
                subscriber.connect("ipc://Cricks");
    			while(true) {
	                //  Socket to talk to server
	                System.out.println("Collecting updates from weather server");
	                for (int i=0; i<4; i++) {
	                	if( ! artistas[i].isEmpty()) {
	                		subscriber.subscribe(artistas[i].getBytes(ZMQ.CHARSET));
	                		
	                	}
	                }         
	                String string = subscriber.recvStr();
	                System.out.println( string );
	              
    			}
    			
    		}
    	
    	
    	
    }

}