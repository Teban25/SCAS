/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.view.stadistics;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.GraficasController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author ASUS
 */
public class EstadisticaUI extends javax.swing.JDialog {

    private final Date fechaInicio;
    private final Date fechaFin;
    private final GraficasController controller;
    private JFreeChart chartTypeVehicle;
    private JFreeChart chartTypeUser;
    private JFreeChart chartHourOfDay;

    /**
     * Creates new form EstadisticaUI
     *
     * @param parent
     * @param modal
     * @param fechaInicio
     * @param fechaFin
     */
    public EstadisticaUI(java.awt.Frame parent, boolean modal, Date fechaInicio, Date fechaFin) {
        super(parent, modal);
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        controller = new GraficasController();
        iniciarGraficos();
        initComponents();
        jPanelHorasDelDia.setPreferredSize(new Dimension(300, 300));
        jPanelTipoUsuario.setPreferredSize(new Dimension(300, 300));
        jPanelTipoVehiculo.setPreferredSize(new Dimension(300, 300));
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd-mm-yyyy");
        jLabelFechaInicial.setText(dateFormat.format(fechaInicio));
        jLabelFechaFinal.setText(dateFormat.format(fechaFin));

    }

    private void iniciarGraficos() {
        try {
            chartTypeVehicle = controller.getChartToTypeVehicle(fechaInicio, fechaFin);
            chartTypeUser = controller.getChartToTypeUser(fechaInicio, fechaFin);
            chartHourOfDay= controller.getChartToHourOfDay(fechaInicio, fechaFin);
            

        } catch (BussinessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTipoVehiculo = new ChartPanel(this.chartTypeVehicle);
        jPanelTipoUsuario = new ChartPanel(this.chartTypeUser);
        jPanelHorasDelDia = new ChartPanel(this.chartHourOfDay);
        jLabel1 = new javax.swing.JLabel();
        jLabelFechaFinal = new javax.swing.JLabel();
        jLabelFechaInicial = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estadisticas");
        setResizable(false);

        javax.swing.GroupLayout jPanelTipoVehiculoLayout = new javax.swing.GroupLayout(jPanelTipoVehiculo);
        jPanelTipoVehiculo.setLayout(jPanelTipoVehiculoLayout);
        jPanelTipoVehiculoLayout.setHorizontalGroup(
            jPanelTipoVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
        jPanelTipoVehiculoLayout.setVerticalGroup(
            jPanelTipoVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelTipoUsuarioLayout = new javax.swing.GroupLayout(jPanelTipoUsuario);
        jPanelTipoUsuario.setLayout(jPanelTipoUsuarioLayout);
        jPanelTipoUsuarioLayout.setHorizontalGroup(
            jPanelTipoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
        jPanelTipoUsuarioLayout.setVerticalGroup(
            jPanelTipoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );

        jPanelHorasDelDia.setToolTipText("");

        javax.swing.GroupLayout jPanelHorasDelDiaLayout = new javax.swing.GroupLayout(jPanelHorasDelDia);
        jPanelHorasDelDia.setLayout(jPanelHorasDelDiaLayout);
        jPanelHorasDelDiaLayout.setHorizontalGroup(
            jPanelHorasDelDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );
        jPanelHorasDelDiaLayout.setVerticalGroup(
            jPanelHorasDelDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 317, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Fecha inicial");

        jLabelFechaFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFechaFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabelFechaInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelFechaInicial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Fecha Final");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanelTipoVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jPanelTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jPanelHorasDelDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanelHorasDelDia, jPanelTipoUsuario, jPanelTipoVehiculo});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel3, jLabelFechaFinal, jLabelFechaInicial});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTipoVehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanelHorasDelDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanelHorasDelDia, jPanelTipoUsuario, jPanelTipoVehiculo});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel3, jLabelFechaFinal, jLabelFechaInicial});

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(EstadisticaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstadisticaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstadisticaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstadisticaUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String startDate = "2014-07-04 18:14:29.000";
                    String endDate = "2017-07-04 18:14:29.000";
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                    Date startD = dateFormat.parse(startDate);
                    Date endD = dateFormat.parse(endDate);
                    EstadisticaUI dialog = new EstadisticaUI(new javax.swing.JFrame(), true, startD, endD);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.pack();
                    dialog.setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(EstadisticaUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFechaFinal;
    private javax.swing.JLabel jLabelFechaInicial;
    private javax.swing.JPanel jPanelHorasDelDia;
    private javax.swing.JPanel jPanelTipoUsuario;
    private javax.swing.JPanel jPanelTipoVehiculo;
    // End of variables declaration//GEN-END:variables

}
