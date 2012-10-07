/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Comunicacion.MensajeChat;
import Logica.Usuario;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class ControlChat implements Runnable{
    private ServerSocket server;
    private List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    
    public ControlChat(){
        try {
            server = new ServerSocket(1201);
        } catch (IOException ex) {
            System.out.println("Se ha producido un error iniciando el Socket");
            System.out.println(ex.getMessage());
        }
    }
    
    private MensajeChat notificarNuevoIngreso(MensajeChat mensaje){
        String cuerpoMensaje = "Ha entrado el nuevo usuario: " 
                                                            + mensaje.getNick();
        MensajeChat nuevoIngreso = new MensajeChat("127.0.0.1", 1201, "Sistema",
                                       cuerpoMensaje, mensaje.getColor());
        return nuevoIngreso;
    }
    
    private Color obtenerColorDestinatario(String ip, int port){
        Iterator recorreUsuarios = listaUsuarios.iterator();
        while(recorreUsuarios.hasNext()){
            Usuario usuario = (Usuario)recorreUsuarios.next();
            if (usuario.getIp().compareTo(ip) == 0 && usuario.getPort() == port){
                return usuario.getColor();
            }
        }
        return null;
    }
      
    private Color setColorMensaje(MensajeChat mensaje){
        Color color = null;
        if (mensaje.getNick().compareTo("Sistema") != 0){
            color = obtenerColorDestinatario(mensaje.getDireccionIp(),
                                                   mensaje.getPort());
        }
        else{
            color = mensaje.getColor();
        }
        return color;
    }
        
    private void enviarMensaje(MensajeChat mensaje){
        Color color = setColorMensaje(mensaje);
        Iterator recorreUsuarios = listaUsuarios.iterator();
        while(recorreUsuarios.hasNext()){
            Usuario usuario = (Usuario)recorreUsuarios.next();
            if (usuario.getIp().compareTo(mensaje.getDireccionIp()) != 0
                    || (usuario.getPort() != mensaje.getPort())){
                try {
                    Socket enviar = new Socket(usuario.getIp(),usuario.getPort());
                    ObjectOutputStream broadcast = new ObjectOutputStream
                                                     (enviar.getOutputStream());
                    MensajeChat nuevo = new MensajeChat(mensaje.getDireccionIp(),
                        mensaje.getPort(),mensaje.getNick(),
                        mensaje.getMensaje(),color);
                    broadcast.writeObject(nuevo);
                    broadcast.close();
                    enviar.close();
                } catch (UnknownHostException ex) {
                    System.out.println(ex.getMessage());
                    recorreUsuarios.remove();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    recorreUsuarios.remove();
                }
            }
        }
    }
    
    @Override
    public void run() {
        while (true){
            try {
                Socket aceptar = server.accept();
                ObjectInputStream peticion = new ObjectInputStream
                                                     (aceptar.getInputStream());
                try {
                    MensajeChat mensaje = 
                            (MensajeChat) peticion.readObject();
                    if (mensaje.isSaludo() == true){
                        listaUsuarios.add(new Usuario(mensaje.getNick(),
                                mensaje.getDireccionIp(), mensaje.getPort()));
                        MensajeChat nuevoIngreso = notificarNuevoIngreso(mensaje);
                        enviarMensaje(nuevoIngreso);
                    }else{
                        enviarMensaje(mensaje);
                    }
                } catch (ClassNotFoundException ex) {
                    System.out.println("No existe la Clase MensajeChat");
                    System.out.println(ex.getMessage());
                }
                peticion.close();
                aceptar.close();
            } catch (IOException ex) {
                System.out.println("Se ha producido el siguiente error"
                        + "aceptando la peticion:");
                System.out.println(ex.getMessage());
            }
        }
    }
}
