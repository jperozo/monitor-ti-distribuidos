/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacion;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import Comunicacion.MensajeChat;
import Logica.LogicaCliente;

/**
 *
 * @author juan
 */
public class EnviaChat implements Runnable{
    private LogicaCliente miLogica = LogicaCliente.getInstance();
    private MensajeChat mensaje;
    private UI.UiMonitor pantalla;
    
    public EnviaChat(UI.UiMonitor pantalla){
        mensaje = new MensajeChat(miLogica.getDireccionIpPropia(),
                                  miLogica.getPortPropio(),
                                  miLogica.getNick());
        this.pantalla = pantalla;
    }   
    
    public EnviaChat(UI.UiMonitor pantalla, String cuerpoMensaje){
        mensaje = new MensajeChat(miLogica.getDireccionIpPropia(),
                                  miLogica.getPortPropio(),
                                  miLogica.getNick(),
                                  cuerpoMensaje);
        this.pantalla = pantalla;
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(miLogica.getDireccionIpServer(), 
                                        miLogica.getPortServer());
            ObjectOutputStream peticion = new ObjectOutputStream(
                                                     socket.getOutputStream());
            peticion.writeObject(mensaje);
            peticion.close();
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            this.pantalla.bloquearChat();
        }
    }
}
