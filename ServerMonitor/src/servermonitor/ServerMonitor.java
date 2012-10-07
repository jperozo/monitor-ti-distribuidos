/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servermonitor;

import Dominio.ControlChat;
import Logica.Usuario;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Comunicacion.MensajeChat;
import java.awt.Color;
/**
 *
 * @author juan
 */
public class ServerMonitor {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Thread chat = new Thread(new ControlChat());
       chat.start();
    }
}
