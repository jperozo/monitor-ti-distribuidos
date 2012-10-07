/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author juan
 */
public class EstiloChat {
    StyledDocument estiloDocumento;
    SimpleAttributeSet nickPropio = new SimpleAttributeSet();
    SimpleAttributeSet nickAjeno = new SimpleAttributeSet();
    SimpleAttributeSet mensaje = new SimpleAttributeSet();
    SimpleAttributeSet alarma = new SimpleAttributeSet();
    
    public EstiloChat(javax.swing.JTextPane salida){
        estiloDocumento = salida.getStyledDocument();
        StyleConstants.setForeground(nickPropio, Color.BLACK);
        StyleConstants.setBold(nickPropio, true);
        StyleConstants.setBold(nickAjeno, true);
        StyleConstants.setForeground(mensaje, Color.BLACK);
        StyleConstants.setForeground(alarma, Color.RED);
        StyleConstants.setBold(alarma, true);
    }
    
    public boolean insertarTextoAjeno(String username, String textoNuevo,
                                      Color color){
        int tamanho = estiloDocumento.getLength();
        try {
            String texto = textoNuevo + "\n";
            estiloDocumento.insertString(tamanho, texto, mensaje);
            StyleConstants.setForeground(nickAjeno, color);
            String nick = username + ": ";
            estiloDocumento.insertString(tamanho, nick, nickAjeno);
        } catch (BadLocationException ex) {
            return false;
        }
        return true;
    }
    
    public boolean insertarTexto(String username, String textoNuevo){
        int tamanho = estiloDocumento.getLength();
        try {
            String texto = textoNuevo + "\n";
            estiloDocumento.insertString(tamanho, texto, mensaje);
            String nick = username + ": ";
            estiloDocumento.insertString(tamanho, nick, nickPropio);
        } catch (BadLocationException ex) {
            return false;
        }
        return true;
    }
    
    public boolean insertarAlarma(String alarma){
        int tamanho = estiloDocumento.getLength();
        try {
            String alarmaLanzada = "SISTEMA: " + alarma +"\n";
            estiloDocumento.insertString(tamanho, alarmaLanzada, this.alarma);
        } catch (BadLocationException ex) {
            return false;
        }
        return true;
    }
    
}
