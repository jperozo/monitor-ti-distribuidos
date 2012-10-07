/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author juan
 */
public class Usuario{
    private String username;
    private String ip;
    private int port;
    private Color color;
    
    public Usuario(String username, String ip, int port){
        this.username = username;
        this.ip = ip;
        this.port = port;
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        this.color = new Color(r,g,b);
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    

}
