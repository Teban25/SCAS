package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.presentacion.swing;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.InicioSesionController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoOperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Teban-Ing
 */
public class InicioSesion extends javax.swing.JFrame {

    public static String usuario;
    private String password;
    InicioSesionController iniciar;

    public InicioSesion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPSesion = new javax.swing.JPanel();
        jTFSesionUsuario = new javax.swing.JTextField();
        jPFSesionPassword = new javax.swing.JPasswordField();
        jBSesionIniciar = new javax.swing.JButton();
        jLSesionContrasena = new javax.swing.JLabel();
        jLSesionUsuario = new javax.swing.JLabel();
        jLSesionTitulo = new javax.swing.JLabel();
        jMBSesion = new javax.swing.JMenuBar();
        jMSesionSalir = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar sesión en el sistema");
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(400, 100, 0, 0));
        setIconImage(getIconImage());
        setResizable(false);

        jPSesion.setBackground(new java.awt.Color(204, 204, 204));
        jPSesion.setForeground(new java.awt.Color(153, 153, 153));

        jTFSesionUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFSesionUsuarioActionPerformed(evt);
            }
        });
        jTFSesionUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTFSesionUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFSesionUsuarioFocusLost(evt);
            }
        });
        jTFSesionUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFSesionUsuarioKeyPressed(evt);
            }
        });

        jPFSesionPassword.setPreferredSize(new java.awt.Dimension(96, 20));
        jPFSesionPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPFSesionPasswordActionPerformed(evt);
            }
        });
        jPFSesionPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPFSesionPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPFSesionPasswordFocusLost(evt);
            }
        });
        jPFSesionPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPFSesionPasswordKeyPressed(evt);
            }
        });

        jBSesionIniciar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBSesionIniciar.setText("Iniciar sesión");
        jBSesionIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSesionIniciarActionPerformed(evt);
            }
        });

        jLSesionContrasena.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLSesionContrasena.setText("Contraseña");

        jLSesionUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLSesionUsuario.setText("Nombre de usuario");

        jLSesionTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLSesionTitulo.setText("Ingreso a SCAS");

        javax.swing.GroupLayout jPSesionLayout = new javax.swing.GroupLayout(jPSesion);
        jPSesion.setLayout(jPSesionLayout);
        jPSesionLayout.setHorizontalGroup(
            jPSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPSesionLayout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(jPSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPSesionLayout.createSequentialGroup()
                        .addGroup(jPSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPFSesionPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFSesionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPSesionLayout.createSequentialGroup()
                        .addComponent(jLSesionContrasena)
                        .addGap(237, 237, 237))))
            .addGroup(jPSesionLayout.createSequentialGroup()
                .addGroup(jPSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPSesionLayout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addGroup(jPSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLSesionUsuario)
                            .addComponent(jLSesionTitulo)))
                    .addGroup(jPSesionLayout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jBSesionIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPSesionLayout.setVerticalGroup(
            jPSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLSesionTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLSesionUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFSesionUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLSesionContrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPFSesionPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jBSesionIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        jMSesionSalir.setText("Archivo");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/liberar-icono-6437-16.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMSesionSalir.add(jMenuItem1);

        jMBSesion.add(jMSesionSalir);

        setJMenuBar(jMBSesion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTFSesionUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFSesionUsuarioFocusGained

    }//GEN-LAST:event_jTFSesionUsuarioFocusGained

    private void jTFSesionUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFSesionUsuarioFocusLost

    }//GEN-LAST:event_jTFSesionUsuarioFocusLost

    private void jTFSesionUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFSesionUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFSesionUsuarioActionPerformed

    private void jPFSesionPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPFSesionPasswordFocusGained

    }//GEN-LAST:event_jPFSesionPasswordFocusGained

    private void jPFSesionPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPFSesionPasswordFocusLost

    }//GEN-LAST:event_jPFSesionPasswordFocusLost

    private void jPFSesionPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPFSesionPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPFSesionPasswordActionPerformed

    private void jBSesionIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSesionIniciarActionPerformed
        actionIniciarsesion();
    }//GEN-LAST:event_jBSesionIniciarActionPerformed

    private void actionIniciarsesion() {
        TipoOperarioUser role;
        usuario = jTFSesionUsuario.getText();
        password = String.copyValueOf(jPFSesionPassword.getPassword());
        if ((!usuario.equals("")) && (!password.equals(""))) {
            iniciar = new InicioSesionController(usuario, password);
            try {
                role = iniciar.permitirSesion();
                switch (role.getIdTipoOperarioUser()) {
                    case 0:
                        PrincipalAdmin nuevoAdmin = new PrincipalAdmin();
                        nuevoAdmin.setVisible(true);
                        this.hide();
                        break;
                    case 1:
                        PrincipalCamVigilante nuevoVigilante = new PrincipalCamVigilante();
                        nuevoVigilante.setVisible(true);
                        this.hide();
                        break;
                    default:
                        break;
                }
            } catch (PersistentException | BussinessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Mensaje de error", JOptionPane.ERROR_MESSAGE);
                if (ex.getMessage().equals("Verifique el nombre de usuario")) {
                    jTFSesionUsuario.requestFocus();
                } else {
                    if (ex.getMessage().equals("Verifique la contraseña e "
                            + "intentelo de nuevo")) {
                        jPFSesionPassword.requestFocus();
                    } else {
                        if (ex.getMessage().equals("El usuario no se encuentra"
                                + " activo en el sistema, contacte a un administrador")) {
                            jTFSesionUsuario.setText("");
                            jPFSesionPassword.setText("");
                            jTFSesionUsuario.requestFocus();
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese los datos de usuario"
                    + " y contraseña para iniciar sesión", "Verifique los campos",
                    JOptionPane.ERROR_MESSAGE);
            if (usuario.equals("")) {
                jTFSesionUsuario.requestFocus();
            } else {
                jPFSesionPassword.requestFocus();
            }
        }
    }

    private void jTFSesionUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFSesionUsuarioKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            actionIniciarsesion();
        }
    }//GEN-LAST:event_jTFSesionUsuarioKeyPressed

    private void jPFSesionPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPFSesionPasswordKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            actionIniciarsesion();
        }
    }//GEN-LAST:event_jPFSesionPasswordKeyPressed
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("images/logotipo-udea_opt.png"));
        return retValue;
    }

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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSesionIniciar;
    private javax.swing.JLabel jLSesionContrasena;
    private javax.swing.JLabel jLSesionTitulo;
    private javax.swing.JLabel jLSesionUsuario;
    private javax.swing.JMenuBar jMBSesion;
    private javax.swing.JMenu jMSesionSalir;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPasswordField jPFSesionPassword;
    private javax.swing.JPanel jPSesion;
    private javax.swing.JTextField jTFSesionUsuario;
    // End of variables declaration//GEN-END:variables
}
