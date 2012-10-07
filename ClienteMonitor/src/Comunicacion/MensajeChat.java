/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Comunicacion;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author juan
 */
public class MensajeChat implements Serializable{
    private String direccionIp;
    private int port;
    private String nick;
    private String mensaje;
    private Color color;
    private boolean saludo;
    private boolean alarma;

    public MensajeChat(String direccionIp, int port, String nick) {
        this.direccionIp = direccionIp;
        this.port = port;
        this.nick = nick;
        this.saludo = true;
        this.alarma = false;
        this.color = Color.GREEN;
    }
    
    public MensajeChat(String direccionIp, int port, String nick,
                       String mensaje) {
        this.direccionIp = direccionIp;
        this.port = port;
        this.nick = nick;
        this.mensaje = mensaje;
        this.saludo = false;
        this.alarma = false;
        this.color = Color.BLACK;
    }
    
    public MensajeChat(String direccionIp, int port, String nick,
                       String mensaje, Color color) {
        this(direccionIp, port, nick, mensaje);
        this.color = color;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public boolean isSaludo() {
        return saludo;
    }

    public void setSaludo(boolean saludo) {
        this.saludo = saludo;
    }

    public boolean isAlarma() {
        return alarma;
    }

    public void setAlarma(boolean alarma) {
        this.alarma = alarma;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
