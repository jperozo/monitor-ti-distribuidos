/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author juan
 */
public class UiOpciones extends javax.swing.JFrame {

    private UiMonitor padre;
    /**
     * Creates new form UiOpciones
     */
    public UiOpciones(UiMonitor padre) {
        initComponents();
        this.padre = padre;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTFNick = new javax.swing.JTextField();
        JTFCliente = new javax.swing.JTextField();
        JTFServer = new javax.swing.JTextField();
        JLNick = new javax.swing.JLabel();
        JLCliente = new javax.swing.JLabel();
        JLServer = new javax.swing.JLabel();
        JBAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLNick.setText("Nickname: ");

        JLCliente.setText("IP Cliente: ");

        JLServer.setText("IP Servidor: ");

        JBAceptar.setText("Aceptar");
        JBAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBAceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLNick)
                            .addComponent(JLCliente)
                            .addComponent(JLServer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTFNick)
                            .addComponent(JTFCliente)
                            .addComponent(JTFServer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLNick))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLCliente))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTFServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLServer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(JBAceptar)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean comprobarSintaxis(String direccion){
        return direccion.contains(":");
    }
    
    private String obtenerIPPropia(){
        String[] direccion = JTFCliente.getText().split(":");
        return direccion[0];
    }
    
    private int obtenerPuertoPropio(){
        String[] direccion = JTFCliente.getText().split(":");
        return Integer.parseInt(direccion[1]);
    }
    
    private String obtenerIPServer(){
        String[] direccion = JTFServer.getText().split(":");
        return direccion[0];
    }
    
    private int obtenerPuertoServer(){
        String[] direccion = JTFServer.getText().split(":");
        return Integer.parseInt(direccion[1]);
    }
    
    private void JBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAceptarActionPerformed
        int activar = 0;
        if (JTFNick.getText().isEmpty() == false){
            Logica.LogicaCliente.getInstance().setNick(JTFNick.getText());
            activar++;
        }
        else{
            activar++;
        }
        if (JTFCliente.getText().isEmpty() == false && 
                (comprobarSintaxis(JTFCliente.getText()) == true)){
            Logica.LogicaCliente.getInstance()
                    .setDireccionIpPropia(obtenerIPPropia());
            Logica.LogicaCliente.getInstance()
                    .setPortPropio(obtenerPuertoPropio());
            activar++;
        }
        if (JTFServer.getText().isEmpty() == false && 
                (comprobarSintaxis(JTFServer.getText()) == true)){
            Logica.LogicaCliente.getInstance()
                    .setDireccionIpServer(obtenerIPServer());
            Logica.LogicaCliente.getInstance()
                    .setPortServer(obtenerPuertoServer());
            activar++;
        }
        if (activar == 3){
            padre.desbloquearChat();
            Thread conectividad = new Thread(new Comunicacion.EnviaChat(padre));
            conectividad.start();
        }
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_JBAceptarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UiOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UiOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UiOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UiOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UiOpciones(new UiMonitor()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAceptar;
    private javax.swing.JLabel JLCliente;
    private javax.swing.JLabel JLNick;
    private javax.swing.JLabel JLServer;
    private javax.swing.JTextField JTFCliente;
    private javax.swing.JTextField JTFNick;
    private javax.swing.JTextField JTFServer;
    // End of variables declaration//GEN-END:variables
}
