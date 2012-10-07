/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacion;

import UI.EstiloChat;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class EscuchaChat implements Runnable{
    EstiloChat interfaz;
    
    public EscuchaChat(EstiloChat interfaz){
        this.interfaz = interfaz;
    }
    
    public void escribirMensaje(MensajeChat mensaje){
        if (mensaje.isAlarma() == false){
            interfaz.insertarTextoAjeno(mensaje.getNick(), mensaje.getMensaje(),
                                        mensaje.getColor());
        }
        else{
            interfaz.insertarAlarma(mensaje.getMensaje());
        }
    }
    
    @Override
    public void run() {
        Logica.LogicaCliente miLogica = Logica.LogicaCliente.getInstance();
        ServerSocket server = null;
        try {
            server = new ServerSocket(miLogica.getPortPropio());
        } catch (IOException ex) {
            System.out.println("Se ha producido un error iniciando el Socket");
            System.out.println(ex.getMessage());
        }
        while (true){
            try {
                Socket aceptar = server.accept();
                ObjectInputStream peticion = new ObjectInputStream
                                                     (aceptar.getInputStream());
                try {
                    MensajeChat mensaje = (MensajeChat)peticion.readObject();
                    escribirMensaje(mensaje);
                } catch (ClassNotFoundException ex) {
                    System.out.println("La clase MensajeChat no existe");
                }
            } catch (IOException ex) {
                System.out.println("Se ha producido el siguiente error"
                        + " aceptando la peticion:");
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
