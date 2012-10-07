/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author juan
 */
public class LogicaCliente {
    //private static LogicaCliente Instancia = new LogicaCliente("Anonimous","127.0.0.1","1202","127.0.0.1","1201");
    private static LogicaCliente Instancia = new LogicaCliente("Anonimous","","","","");
    private String nick;
    private String direccionIpPropia;
    private int portPropio;
    private String direccionIpServer;
    private int portServer;
    
    private LogicaCliente(String nick, String direccionIp){
        this.nick = nick;
        this.direccionIpPropia = direccionIp;
    }
    
    private LogicaCliente(String nick, String direccionIp, String servidor){
        this(nick, direccionIp);
        this.direccionIpServer = servidor;
    }
    
    private LogicaCliente(String nick, String direccionIp, String portPropio,
                          String servidor, String portServer){
        this(nick, direccionIp, servidor);
        try{
            this.portPropio = Integer.parseInt(portPropio);
            this.portServer = Integer.parseInt(portServer);
        }
        catch(Exception ex){
            System.out.println("Por favor, coloque un puerto propio y de servidor");
        }
    }
    
    public static LogicaCliente getInstance(){
        return Instancia;
    }
    
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDireccionIpPropia() {
        return direccionIpPropia;
    }

    public void setDireccionIpPropia(String direccionIpPropia) {
        this.direccionIpPropia = direccionIpPropia;
    }

    public String getDireccionIpServer() {
        return direccionIpServer;
    }

    public void setDireccionIpServer(String direccionIpServer) {
        this.direccionIpServer = direccionIpServer;
    }
    
    public int getPortPropio() {
        return portPropio;
    }

    public void setPortPropio(int portPropio) {
        this.portPropio = portPropio;
    }

    public int getPortServer() {
        return portServer;
    }

    public void setPortServer(int portServer) {
        this.portServer = portServer;
    }
    
}
