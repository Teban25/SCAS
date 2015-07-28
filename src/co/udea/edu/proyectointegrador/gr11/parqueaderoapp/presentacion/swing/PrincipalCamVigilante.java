package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.presentacion.swing;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.AlprController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.IngresoController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamLock;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Teban-Ing
 */
public class PrincipalCamVigilante extends javax.swing.JFrame {

    Webcam webcam;
    WebcamPanel panel;
    String tip;
    String operario;
    JLabel lFotoPlaca;
    ImageIcon icon;
    Icon icono;
    AlprController controladorAlpr;
    String rutaPlaca;
    String resultado;
    private final String mensajeResultadoPositivo = "Concedido";
    private final String mensajeResultadoNegativo = "Denegado";
    IngresoController ingresos;

    public PrincipalCamVigilante() {
        initComponents();
        operario = InicioSesion.usuario;
        this.getContentPane().setBackground(new Color(204, 204, 204));
        webcam = Webcam.getDefault();
        if (webcam == null) {
            JOptionPane.showMessageDialog(null, "No se puede encontrar una cámara disponible",
                    "Error al buscar la cámara", JOptionPane.ERROR_MESSAGE);
            this.JBEntrada.setEnabled(false);
            return;
        }
        WebcamLock lock = webcam.getLock();
        if (lock.isLocked()) {
            JOptionPane.showMessageDialog(null, "La camara definida por defecto esta ocupada",
                    "Error al buscar la cámara", JOptionPane.ERROR_MESSAGE);
            this.JBEntrada.setEnabled(false);
            return;
        }
        webcam.setViewSize(new Dimension(640, 480));
        lFotoPlaca = new JLabel();
        lFotoPlaca.setSize(new Dimension(640, 480));
        panel = new WebcamPanel(webcam);
        panel.setVisible(true);
        panel.setBounds(0, 0, 640, 480);
        jPanelCamara.add(panel);
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
        jTPPrincipalVigilante = new javax.swing.JTabbedPane();
        jPPrincipalVigilanteIngreso = new javax.swing.JPanel();
        jLPrincipalVigilanteTituloCamara = new javax.swing.JLabel();
        jPanelCamara = new javax.swing.JPanel();
        jLPrincipalVigilanteTituloTIP = new javax.swing.JLabel();
        jTFTip = new javax.swing.JTextField();
        JBEntrada = new javax.swing.JButton();
        jLPrincipalVigilanteTituloResultadoE = new javax.swing.JLabel();
        jTFResultado = new javax.swing.JTextField();
        jPFotoPlaca = new javax.swing.JPanel();
        jLPrincipalVigilanteTituloFoto = new javax.swing.JLabel();
        jLPrincipalVigilanteTituloResultadoP = new javax.swing.JLabel();
        jTFPlacaResult = new javax.swing.JTextField();
        jLLogoUdeA = new javax.swing.JLabel();
        jPPrincipalVigilanteRegistroV = new javax.swing.JPanel();
        jMBPrincipalVigilanteArchivo = new javax.swing.JMenuBar();
        jMPrincipalVigilanteMenu = new javax.swing.JMenu();
        jMIPrincipalVigilanteCerrar = new javax.swing.JMenuItem();
        jMIPrincipalVigilanteSalir = new javax.swing.JMenuItem();
        jMPrincipalVigilanteAyuda = new javax.swing.JMenu();
        jMIPrincipalVigilanteAsistencia = new javax.swing.JMenuItem();
        jMIPrincipalVigilanteAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingreso y salida de la UdeA");
        setIconImage(getIconImage());
        setResizable(false);

        jPPrincipalVigilante.setBackground(new java.awt.Color(204, 204, 204));

        jLPrincipalVigilanteTituloCamara.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPrincipalVigilanteTituloCamara.setText("Camara en vivo");

        jPanelCamara.setBackground(new java.awt.Color(204, 204, 204));
        jPanelCamara.setPreferredSize(new java.awt.Dimension(640, 480));

        javax.swing.GroupLayout jPanelCamaraLayout = new javax.swing.GroupLayout(jPanelCamara);
        jPanelCamara.setLayout(jPanelCamaraLayout);
        jPanelCamaraLayout.setHorizontalGroup(
            jPanelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        jPanelCamaraLayout.setVerticalGroup(
            jPanelCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jLPrincipalVigilanteTituloTIP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPrincipalVigilanteTituloTIP.setText("TIP");

        jTFTip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFTipKeyPressed(evt);
            }
        });

        JBEntrada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JBEntrada.setText("Entrada-Salida");
        JBEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEntradaActionPerformed(evt);
            }
        });

        jLPrincipalVigilanteTituloResultadoE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPrincipalVigilanteTituloResultadoE.setText("Resultado E/S");

        jTFResultado.setEditable(false);
        jTFResultado.setPreferredSize(new java.awt.Dimension(6, 28));
        jTFResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFResultadoActionPerformed(evt);
            }
        });

        jPFotoPlaca.setBackground(new java.awt.Color(204, 204, 204));
        jPFotoPlaca.setPreferredSize(new java.awt.Dimension(320, 240));

        javax.swing.GroupLayout jPFotoPlacaLayout = new javax.swing.GroupLayout(jPFotoPlaca);
        jPFotoPlaca.setLayout(jPFotoPlacaLayout);
        jPFotoPlacaLayout.setHorizontalGroup(
            jPFotoPlacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPFotoPlacaLayout.setVerticalGroup(
            jPFotoPlacaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        jLPrincipalVigilanteTituloFoto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPrincipalVigilanteTituloFoto.setText("Foto de placa");

        jLPrincipalVigilanteTituloResultadoP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLPrincipalVigilanteTituloResultadoP.setText("Placa-Resultado");

        jTFPlacaResult.setEditable(false);
        jTFPlacaResult.setPreferredSize(new java.awt.Dimension(6, 58));

        jLLogoUdeA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoudeaVigilante.png"))); // NOI18N

        javax.swing.GroupLayout jPPrincipalVigilanteIngresoLayout = new javax.swing.GroupLayout(jPPrincipalVigilanteIngreso);
        jPPrincipalVigilanteIngreso.setLayout(jPPrincipalVigilanteIngresoLayout);
        jPPrincipalVigilanteIngresoLayout.setHorizontalGroup(
            jPPrincipalVigilanteIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                .addGroup(jPPrincipalVigilanteIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPPrincipalVigilanteIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTFPlacaResult, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                                .addGroup(jPPrincipalVigilanteIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                                        .addGap(117, 117, 117)
                                        .addComponent(jLPrincipalVigilanteTituloFoto))
                                    .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLPrincipalVigilanteTituloResultadoE)
                                        .addGap(48, 48, 48)
                                        .addComponent(jLPrincipalVigilanteTituloResultadoP))
                                    .addGroup(jPPrincipalVigilanteIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                                            .addGroup(jPPrincipalVigilanteIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                                                    .addGap(83, 83, 83)
                                                    .addComponent(jLPrincipalVigilanteTituloTIP)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addGroup(jPPrincipalVigilanteIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                                                            .addComponent(JBEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(27, 27, 27))
                                                        .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                                                            .addComponent(jTFTip, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(10, 10, 10)))))
                                            .addComponent(jLLogoUdeA, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPFotoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(1, 1, 1))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLPrincipalVigilanteTituloCamara)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPPrincipalVigilanteIngresoLayout.setVerticalGroup(
            jPPrincipalVigilanteIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPPrincipalVigilanteIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                        .addComponent(jLPrincipalVigilanteTituloCamara)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPPrincipalVigilanteIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPPrincipalVigilanteIngresoLayout.createSequentialGroup()
                                .addComponent(jLPrincipalVigilanteTituloTIP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFTip, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JBEntrada)
                                .addGap(12, 12, 12))
                            .addComponent(jLLogoUdeA, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLPrincipalVigilanteTituloFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPFotoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(jPPrincipalVigilanteIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLPrincipalVigilanteTituloResultadoE)
                            .addComponent(jLPrincipalVigilanteTituloResultadoP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPPrincipalVigilanteIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFPlacaResult, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTPPrincipalVigilante.addTab("Ingreso o salida ", jPPrincipalVigilanteIngreso);

        javax.swing.GroupLayout jPPrincipalVigilanteRegistroVLayout = new javax.swing.GroupLayout(jPPrincipalVigilanteRegistroV);
        jPPrincipalVigilanteRegistroV.setLayout(jPPrincipalVigilanteRegistroVLayout);
        jPPrincipalVigilanteRegistroVLayout.setHorizontalGroup(
            jPPrincipalVigilanteRegistroVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
        );
        jPPrincipalVigilanteRegistroVLayout.setVerticalGroup(
            jPPrincipalVigilanteRegistroVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );

        jTPPrincipalVigilante.addTab("Registro de vehiculos", jPPrincipalVigilanteRegistroV);

        javax.swing.GroupLayout jPPrincipalVigilanteLayout = new javax.swing.GroupLayout(jPPrincipalVigilante);
        jPPrincipalVigilante.setLayout(jPPrincipalVigilanteLayout);
        jPPrincipalVigilanteLayout.setHorizontalGroup(
            jPPrincipalVigilanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrincipalVigilanteLayout.createSequentialGroup()
                .addComponent(jTPPrincipalVigilante, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPPrincipalVigilanteLayout.setVerticalGroup(
            jPPrincipalVigilanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPPrincipalVigilante, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jMPrincipalVigilanteAyuda.setText("Ayuda");

        jMIPrincipalVigilanteAsistencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoDocumento.png"))); // NOI18N
        jMIPrincipalVigilanteAsistencia.setText("Asistencia y documentación");
        jMPrincipalVigilanteAyuda.add(jMIPrincipalVigilanteAsistencia);

        jMIPrincipalVigilanteAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoudea16x16.png"))); // NOI18N
        jMIPrincipalVigilanteAcerca.setText("Acerca de...");
        jMIPrincipalVigilanteAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrincipalVigilanteAcercaActionPerformed(evt);
            }
        });
        jMPrincipalVigilanteAyuda.add(jMIPrincipalVigilanteAcerca);

        jMBPrincipalVigilanteArchivo.add(jMPrincipalVigilanteAyuda);

        setJMenuBar(jMBPrincipalVigilanteArchivo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPrincipalVigilante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPPrincipalVigilante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIPrincipalVigilanteCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrincipalVigilanteCerrarActionPerformed
        InicioSesion cerrarSesion = new InicioSesion();
        cerrarSesion.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jMIPrincipalVigilanteCerrarActionPerformed

    private void jMIPrincipalVigilanteSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrincipalVigilanteSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMIPrincipalVigilanteSalirActionPerformed

    private void jTFResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFResultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFResultadoActionPerformed

    private void jTFTipKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTipKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            actionTipedTIP();
        }
    }//GEN-LAST:event_jTFTipKeyPressed

    private void jMIPrincipalVigilanteAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrincipalVigilanteAcercaActionPerformed
        About nuevo = new About(this, true);
        nuevo.setVisible(true);
    }//GEN-LAST:event_jMIPrincipalVigilanteAcercaActionPerformed

    private void JBEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEntradaActionPerformed
        actionTipedTIP();
    }//GEN-LAST:event_JBEntradaActionPerformed

    private void actionTipedTIP() {
        tip = jTFTip.getText();
        if (!tip.equals("")) {
            try {
                ImageIO.write(webcam.getImage(), "JPG", new File("./images/" + tip + ".jpg"));
            } catch (IOException ex) {
                Logger.getLogger(PrincipalCamVigilante.class.getName()).log(Level.SEVERE, null, ex);
            }
            rutaPlaca = "./images/" + tip + ".jpg";
            icon = new ImageIcon(rutaPlaca);
            icono = new ImageIcon(icon.getImage().
                    getScaledInstance(340, 280,
                            Image.SCALE_AREA_AVERAGING));
            lFotoPlaca.setBounds(0, 0, 340, 280);
            lFotoPlaca.setIcon(icono);
            lFotoPlaca.setVisible(true);
            jPFotoPlaca.setSize(340, 280);
            jPFotoPlaca.add(lFotoPlaca);
            controladorAlpr = new AlprController(rutaPlaca);
            try {
                resultado = controladorAlpr.recognizePlateFromUser(tip);
                jTFPlacaResult.setText(resultado);
                jTFResultado.setForeground(new Color(85, 168, 73));
                jTFResultado.setText(mensajeResultadoPositivo);
                ingresos=new IngresoController();
                ingresos.insertarIngreso(new Date(), resultado, tip, operario);
            } catch (BussinessException | PersistentException ex) {
                jTFResultado.setSelectedTextColor(Color.red);
                jTFResultado.setText(mensajeResultadoNegativo);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un numero de TIP",
                    "Error al intentar verificar", JOptionPane.ERROR_MESSAGE);
        }
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
    private javax.swing.JButton JBEntrada;
    private javax.swing.JLabel jLLogoUdeA;
    private javax.swing.JLabel jLPrincipalVigilanteTituloCamara;
    private javax.swing.JLabel jLPrincipalVigilanteTituloFoto;
    private javax.swing.JLabel jLPrincipalVigilanteTituloResultadoE;
    private javax.swing.JLabel jLPrincipalVigilanteTituloResultadoP;
    private javax.swing.JLabel jLPrincipalVigilanteTituloTIP;
    private javax.swing.JMenuBar jMBPrincipalVigilanteArchivo;
    private javax.swing.JMenuItem jMIPrincipalVigilanteAcerca;
    private javax.swing.JMenuItem jMIPrincipalVigilanteAsistencia;
    private javax.swing.JMenuItem jMIPrincipalVigilanteCerrar;
    private javax.swing.JMenuItem jMIPrincipalVigilanteSalir;
    private javax.swing.JMenu jMPrincipalVigilanteAyuda;
    private javax.swing.JMenu jMPrincipalVigilanteMenu;
    private javax.swing.JPanel jPFotoPlaca;
    private javax.swing.JPanel jPPrincipalVigilante;
    private javax.swing.JPanel jPPrincipalVigilanteIngreso;
    private javax.swing.JPanel jPPrincipalVigilanteRegistroV;
    private javax.swing.JPanel jPanelCamara;
    private javax.swing.JTextField jTFPlacaResult;
    private javax.swing.JTextField jTFResultado;
    private javax.swing.JTextField jTFTip;
    private javax.swing.JTabbedPane jTPPrincipalVigilante;
    // End of variables declaration//GEN-END:variables
}
