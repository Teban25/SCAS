
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.presentacion.swing;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Teban-Ing
 */
public class PrincipalCamVigilante extends javax.swing.JFrame {

    
    public PrincipalCamVigilante() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("images/logotipo-udea_opt.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPPrincipalVigilante = new javax.swing.JPanel();
        jMBPrincipalVigilanteArchivo = new javax.swing.JMenuBar();
        jMPrincipalVigilanteMenu = new javax.swing.JMenu();
        jMIPrincipalVigilanteCerrar = new javax.swing.JMenuItem();
        jMIPrincipalVigilanteSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingreso y salida de la UdeA");
        setIconImage(getIconImage());

        jPPrincipalVigilante.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPPrincipalVigilanteLayout = new javax.swing.GroupLayout(jPPrincipalVigilante);
        jPPrincipalVigilante.setLayout(jPPrincipalVigilanteLayout);
        jPPrincipalVigilanteLayout.setHorizontalGroup(
            jPPrincipalVigilanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPPrincipalVigilanteLayout.setVerticalGroup(
            jPPrincipalVigilanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        jMPrincipalVigilanteMenu.setText("Archivo");

        jMIPrincipalVigilanteCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoOut.png"))); // NOI18N
        jMIPrincipalVigilanteCerrar.setText("Cerrar sesión");
        jMIPrincipalVigilanteCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrincipalVigilanteCerrarActionPerformed(evt);
            }
        });
        jMPrincipalVigilanteMenu.add(jMIPrincipalVigilanteCerrar);

        jMIPrincipalVigilanteSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/liberar-icono-6437-16.png"))); // NOI18N
        jMIPrincipalVigilanteSalir.setText("Salir");
        jMIPrincipalVigilanteSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrincipalVigilanteSalirActionPerformed(evt);
            }
        });
        jMPrincipalVigilanteMenu.add(jMIPrincipalVigilanteSalir);

        jMBPrincipalVigilanteArchivo.add(jMPrincipalVigilanteMenu);

        setJMenuBar(jMBPrincipalVigilanteArchivo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPrincipalVigilante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPrincipalVigilante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIPrincipalVigilanteCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrincipalVigilanteCerrarActionPerformed
        InicioSesion cerrarSesion=new InicioSesion();
        cerrarSesion.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jMIPrincipalVigilanteCerrarActionPerformed

    private void jMIPrincipalVigilanteSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrincipalVigilanteSalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jMIPrincipalVigilanteSalirActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalCamVigilante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalCamVigilante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalCamVigilante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalCamVigilante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalCamVigilante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMBPrincipalVigilanteArchivo;
    private javax.swing.JMenuItem jMIPrincipalVigilanteCerrar;
    private javax.swing.JMenuItem jMIPrincipalVigilanteSalir;
    private javax.swing.JMenu jMPrincipalVigilanteMenu;
    private javax.swing.JPanel jPPrincipalVigilante;
    // End of variables declaration//GEN-END:variables
}
