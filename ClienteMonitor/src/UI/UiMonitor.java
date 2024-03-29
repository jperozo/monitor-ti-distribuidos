/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UiMonitor.java
 *
 * Created on Oct 05, 2012, 12:37:08 PM
 */
package UI;

import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author juan
 */
public class UiMonitor extends javax.swing.JFrame {

    private Thread enviar = null;
    private Thread recibir = null;
    private EstiloChat interfazGraficaChat;
    
    /**
     * Creates new form UiMonitor
     */
    public UiMonitor() {
        initComponents();
        interfazGraficaChat = new EstiloChat(JTPOutputChat);
        enviar = new Thread(new Comunicacion.EnviaChat(this));
        enviar.start();
        iniciarRecepcion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogAbout = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JSPOutputChat = new javax.swing.JScrollPane();
        JTPOutputChat = new javax.swing.JTextPane();
        JSPInputChat = new javax.swing.JScrollPane();
        JTAInputChat = new javax.swing.JTextArea();
        JBEnviarChat = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMConfig = new javax.swing.JMenu();
        JMINuevaConfig = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        dialogAbout.setTitle("About");
        dialogAbout.setModal(true);
        dialogAbout.setResizable(false);

        jLabel1.setText("2 ejemplos de manejo de hilos utlizando la interfaz");

        jLabel2.setText("Runnable y la clase Thread");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Hecho por David Hernandez");

        org.jdesktop.layout.GroupLayout dialogAboutLayout = new org.jdesktop.layout.GroupLayout(dialogAbout.getContentPane());
        dialogAbout.getContentPane().setLayout(dialogAboutLayout);
        dialogAboutLayout.setHorizontalGroup(
            dialogAboutLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(dialogAboutLayout.createSequentialGroup()
                .addContainerGap()
                .add(dialogAboutLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jLabel1))
                .addContainerGap(58, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, dialogAboutLayout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .add(jLabel3)
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, dialogAboutLayout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .add(jButton1)
                .addContainerGap())
        );
        dialogAboutLayout.setVerticalGroup(
            dialogAboutLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(dialogAboutLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .add(7, 7, 7)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton1)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chat"));

        JTPOutputChat.setEditable(false);
        JSPOutputChat.setViewportView(JTPOutputChat);

        JSPInputChat.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JTAInputChat.setColumns(20);
        JTAInputChat.setLineWrap(true);
        JTAInputChat.setRows(5);
        JTAInputChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTAInputChatKeyPressed(evt);
            }
        });
        JSPInputChat.setViewportView(JTAInputChat);

        JBEnviarChat.setText("Enviar");
        JBEnviarChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEnviarChatActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(JSPOutputChat)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(JSPInputChat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 233, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(JBEnviarChat, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(JSPOutputChat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 301, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(JSPInputChat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(JBEnviarChat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JMConfig.setText("Configuracion");

        JMINuevaConfig.setText("Nueva Configuracion");
        JMINuevaConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMINuevaConfigActionPerformed(evt);
            }
        });
        JMConfig.add(JMINuevaConfig);

        jMenuBar1.add(JMConfig);

        jMenu2.setText("Help");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(606, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("chat");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarRecepcion(){
        recibir = new Thread(new Comunicacion.EscuchaChat(interfazGraficaChat));
        recibir.start();
    }
    
    public void bloquearChat(){
        JTAInputChat.setEnabled(false);
        JTPOutputChat.setText("Debe configurar la direccion IP local\n"
                + "y del servidor al igual que los puertos,\n"
                + "en el menu de configuracion");
        JBEnviarChat.setEnabled(false);
    }
    
    public void desbloquearChat(){
        JTAInputChat.setEnabled(true);
        JTPOutputChat.setText(null);
        JTPOutputChat.setEnabled(true);
        JBEnviarChat.setEnabled(true);
        iniciarRecepcion();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JBEnviarChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEnviarChatActionPerformed
        enviarTexto();
    }//GEN-LAST:event_JBEnviarChatActionPerformed
    
    private void JTAInputChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTAInputChatKeyPressed
        KeyStroke lecturaTeclado = KeyStroke.getKeyStrokeForEvent(evt);
        //Salto de Linea en caso de "Ctrl + Enter"
        JTAInputChat.getInputMap().put(
                KeyStroke.getKeyStroke("ctrl pressed ENTER"), "insert-break");
        //Elimina propiedad de salto de linea en caso "Enter"
        JTAInputChat.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),"none");
        if (lecturaTeclado.equals(KeyStroke.getKeyStroke("ENTER")) == true){
            enviarTexto();
        }        
    }//GEN-LAST:event_JTAInputChatKeyPressed

    private void JMINuevaConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMINuevaConfigActionPerformed
        UiOpciones config = new UiOpciones(this);
        config.setVisible(true);
    }//GEN-LAST:event_JMINuevaConfigActionPerformed

    private void enviarTexto() {
        //Hacer con la logica del Socket
        String username = Logica.LogicaCliente.getInstance().getNick();
        String texto = JTAInputChat.getText();
        enviar = new Thread(new Comunicacion.EnviaChat(this, texto));
        enviar.start();
        interfazGraficaChat.insertarTexto(username, texto);
        JTAInputChat.setText(null);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UiMonitor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBEnviarChat;
    private javax.swing.JMenu JMConfig;
    private javax.swing.JMenuItem JMINuevaConfig;
    private javax.swing.JScrollPane JSPInputChat;
    private javax.swing.JScrollPane JSPOutputChat;
    private javax.swing.JTextArea JTAInputChat;
    private javax.swing.JTextPane JTPOutputChat;
    private javax.swing.JDialog dialogAbout;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
