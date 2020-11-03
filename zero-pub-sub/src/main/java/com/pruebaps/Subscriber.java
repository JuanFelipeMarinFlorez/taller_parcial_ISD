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
public class Subscriber
{
    public static void main(String[] args)
    {
        //Establece el ambiente o contexto zeromq
        try (ZContext context = new ZContext()) {
            //  Socket to talk to server
            System.out.println("Collecting updates from weather server");
            //Crea un socket tipo SUB
            ZMQ.Socket subscriber = context.createSocket(SocketType.SUB);
            //Conecta el socket a un puerto
            //subscriber.connect("tcp://localhost:5556");
            //Prueba red domestica
            subscriber.connect("tcp://192.168.0.14:5558");
            //subscriber.connect("tcp://25.77.197.91:5556");
            subscriber.connect("ipc://Selena3");
            String filter = (args.length > 0) ? args[0] : "10001 ";
            String filter2 = (args.length > 0) ? args[0] : "10002 ";
            //Se suscribe con codigo especial que le permitira filtar los mensajes del publicador
            subscriber.subscribe(filter.getBytes(ZMQ.CHARSET));
            subscriber.subscribe(filter2.getBytes(ZMQ.CHARSET));
            //  Procesa 100 actualizaciones
            int update_nbr;
            long total_temp = 0;
            
            
            for (update_nbr = 0; update_nbr < 100; update_nbr++) {
                //Recibe el mensaje en cadena de caracteres
                //Remueve el caracter '0' de la cola
                String string = subscriber.recvStr();
                System.out.println( string );
                
            }

            
        }
    }
}