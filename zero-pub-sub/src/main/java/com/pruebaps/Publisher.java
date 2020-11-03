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
    public static void main(String[] args) throws Exception
    {
        //Establece el ambiente o contexto zeromq
        try (ZContext context = new ZContext()) {
            //Crea un socket tipo PUB
            ZMQ.Socket publisher = context.createSocket(SocketType.PUB);
            //Ata el socket a un puerto
            publisher.bind("tcp://*:5558");
            publisher.bind("ipc://Selena3");
            Random srandom = new Random(System.currentTimeMillis());
            while (!Thread.currentThread().isInterrupted()) {
                //  Obtiene los valores
                Crick mensaje= new Crick("Selena Gomez", "Unete a Pantene y notarás la diferencia");
                Crick mensaje2= new Crick("Selena Gomez", "amo aun a justin");
                int zipcode;
                zipcode = 10001;
                String update = String.format(
                    "%05d %s ", zipcode, mensaje.toString()
                );
                //Envia el mensaje a todos los suscriptores
                publisher.send(update, 0);
                zipcode = 10002;
                update = String.format(
                    "%05d %s ", zipcode, mensaje2.toString()
                );
                //Envia el mensaje a todos los suscriptores
                publisher.send(update, 0);
                
            }
        }
    }
}