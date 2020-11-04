package com.pruebaps;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	
    	 System.out.println ("Por favor introduzca una cadena por teclado:");
         String entradaTeclado = "";
         Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
         entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
         System.out.println ("Entrada recibida por teclado es: \"" + entradaTeclado +"\"");
       
        if(entradaTeclado.equals("hola")) {
        	 System.out.println( "Hello World!" );
        	Publisher publicador= new Publisher();
            String [] art={"Shakira","Juanes","Maluma","BadBunny"};
            publicador.setArtistas(art);
            publicador.newMessage("Shakira", "hola miamiiii");
            publicador.start();
            publicador.newMessage("Shakira", "waka waka");
        }
        else {
        	Subscriber sub= new Subscriber();
        	sub.newSubscription("Shakira");
        	sub.start();
        }
        
    }
}
