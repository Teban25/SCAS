package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.presentacion.swing;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.AlprController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.IngresoController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.VehiculoController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoVehiculo;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
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

    //Variables para pestaña de registro de vehiculos
    private String placa;
    private String marca;
    private String color;
    private String tipoVehiculo;
    private String tipRegistro;
    private String modelo;
    VehiculoController vehiculoController;
    
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
        agregarItems(this.jCBPrincipalVigilanteTipoVehiculo);
    }
    
    private void agregarItems(JComboBox caja){
        vehiculoController=new VehiculoController();
        try {
            List<TipoVehiculo> tiposVehiculos=null;
            try {
                tiposVehiculos = vehiculoController.getTiposVehiculos();
            } catch (PersistentException ex) {
                JOptionPane.showMessageDialog(this,"Ocurrio un error al recuperar"
                        + " los tipos de vehiculos, mensaje del sistema: "+ex.getMessage(),
                        "Error",JOptionPane.ERROR_MESSAGE);
            }
            for (TipoVehiculo tiposVehiculo : tiposVehiculos) {
                caja.addItem(tiposVehiculo.getTipoVehiculoDescripcion());
            }
        } catch (BussinessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFPrincipalVigilantePlaca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFPrincipalVigilanteMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFPrincipalVigilanteColor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFPrincipalVigilanteModelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCBPrincipalVigilanteTipoVehiculo = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTFPrincipalVigilanteTipRegistro = new javax.swing.JTextField();
        jBPrincipalVigilanteRegistrar = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
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

        jTFTip.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFTip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFTipActionPerformed(evt);
            }
        });
        jTFTip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFTipKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFTipKeyTyped(evt);
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
        jTFResultado.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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
        jTFPlacaResult.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTPPrincipalVigilante.addTab("Ingreso o salida ", jPPrincipalVigilanteIngreso);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Información del vehiculo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Placa:");

        jTFPrincipalVigilantePlaca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFPrincipalVigilantePlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFPrincipalVigilantePlacaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFPrincipalVigilantePlacaKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Marca:");

        jTFPrincipalVigilanteMarca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFPrincipalVigilanteMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFPrincipalVigilanteMarcaKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Color:");

        jTFPrincipalVigilanteColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFPrincipalVigilanteColor.setMinimumSize(new java.awt.Dimension(6, 26));
        jTFPrincipalVigilanteColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFPrincipalVigilanteColorKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Modelo:");

        jTFPrincipalVigilanteModelo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFPrincipalVigilanteModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFPrincipalVigilanteModeloKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Tipo de vehiculo:");

        jCBPrincipalVigilanteTipoVehiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCBPrincipalVigilanteTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Información del vinculado");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("TIP:");

        jTFPrincipalVigilanteTipRegistro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTFPrincipalVigilanteTipRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFPrincipalVigilanteTipRegistroKeyTyped(evt);
            }
        });

        jBPrincipalVigilanteRegistrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBPrincipalVigilanteRegistrar.setText("Registrar vehiculo");
        jBPrincipalVigilanteRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPrincipalVigilanteRegistrarActionPerformed(evt);
            }
        });

        jBLimpiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/broom.png"))); // NOI18N
        jBLimpiar.setToolTipText("Buscar un operario por cédula, si no existe, se permitira agregarlo.");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPPrincipalVigilanteRegistroVLayout = new javax.swing.GroupLayout(jPPrincipalVigilanteRegistroV);
        jPPrincipalVigilanteRegistroV.setLayout(jPPrincipalVigilanteRegistroVLayout);
        jPPrincipalVigilanteRegistroVLayout.setHorizontalGroup(
            jPPrincipalVigilanteRegistroVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(372, 372, 372))
            .addGroup(jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                .addGroup(jPPrincipalVigilanteRegistroVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addComponent(jLabel1))
                    .addGroup(jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFPrincipalVigilanteTipRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBPrincipalVigilanteTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPPrincipalVigilanteRegistroVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFPrincipalVigilanteColor, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFPrincipalVigilantePlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(jPPrincipalVigilanteRegistroVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFPrincipalVigilanteMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFPrincipalVigilanteModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                        .addGap(386, 386, 386)
                        .addComponent(jBPrincipalVigilanteRegistrar)))
                .addContainerGap(382, Short.MAX_VALUE))
        );
        jPPrincipalVigilanteRegistroVLayout.setVerticalGroup(
            jPPrincipalVigilanteRegistroVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPPrincipalVigilanteRegistroVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPPrincipalVigilanteRegistroVLayout.createSequentialGroup()
                        .addGroup(jPPrincipalVigilanteRegistroVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTFPrincipalVigilantePlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTFPrincipalVigilanteMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPPrincipalVigilanteRegistroVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTFPrincipalVigilanteColor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTFPrincipalVigilanteModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPPrincipalVigilanteRegistroVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jCBPrincipalVigilanteTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPPrincipalVigilanteRegistroVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTFPrincipalVigilanteTipRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(jBPrincipalVigilanteRegistrar)
                .addGap(151, 151, 151))
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

    private void jTFPrincipalVigilantePlacaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrincipalVigilantePlacaKeyPressed
        
    }//GEN-LAST:event_jTFPrincipalVigilantePlacaKeyPressed

    private void jTFPrincipalVigilantePlacaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrincipalVigilantePlacaKeyReleased
        String textoPlaca=jTFPrincipalVigilantePlaca.getText().toUpperCase();
        jTFPrincipalVigilantePlaca.setText(textoPlaca);
    }//GEN-LAST:event_jTFPrincipalVigilantePlacaKeyReleased

    private void jTFPrincipalVigilanteMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrincipalVigilanteMarcaKeyReleased
        String textoPlaca=jTFPrincipalVigilanteMarca.getText().toUpperCase();
        jTFPrincipalVigilanteMarca.setText(textoPlaca);
    }//GEN-LAST:event_jTFPrincipalVigilanteMarcaKeyReleased

    private void jTFPrincipalVigilanteColorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrincipalVigilanteColorKeyReleased
        String textoPlaca=jTFPrincipalVigilanteColor.getText().toUpperCase();
        jTFPrincipalVigilanteColor.setText(textoPlaca);
    }//GEN-LAST:event_jTFPrincipalVigilanteColorKeyReleased

    private void jTFPrincipalVigilanteModeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrincipalVigilanteModeloKeyReleased
        String textoPlaca=jTFPrincipalVigilanteModelo.getText().toUpperCase();
        jTFPrincipalVigilanteModelo.setText(textoPlaca);
    }//GEN-LAST:event_jTFPrincipalVigilanteModeloKeyReleased

    private void jTFPrincipalVigilanteTipRegistroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPrincipalVigilanteTipRegistroKeyTyped
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTFPrincipalVigilanteTipRegistroKeyTyped

    private void jTFTipKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFTipKeyTyped
        char c=evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTFTipKeyTyped

    private void jBPrincipalVigilanteRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPrincipalVigilanteRegistrarActionPerformed
        placa=jTFPrincipalVigilantePlaca.getText();
        marca=jTFPrincipalVigilanteMarca.getText();
        color=jTFPrincipalVigilanteColor.getText();
        tipoVehiculo=jCBPrincipalVigilanteTipoVehiculo.getSelectedItem().toString();
        tip=jTFPrincipalVigilanteTipRegistro.getText();
        modelo=jTFPrincipalVigilanteModelo.getText();
        if((!placa.equals("")) & (!marca.equals("")) & (!color.equals("")) &
                (!tipoVehiculo.equals("Seleccionar"))& (!tip.equals(""))){
            vehiculoController=new VehiculoController(placa, marca,modelo, color, tipoVehiculo, tip);
            try {
                vehiculoController.registroVehiculo();
                limpiarItems();
                JOptionPane.showMessageDialog(null, "Vehiculo registrado correctamente"
                    + " al usuario ingresado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } catch (BussinessException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 
                        JOptionPane.ERROR_MESSAGE);
            } catch (PersistentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Falta algún campo por ingresar, "
                    + "por favor verifique", "Atención!", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBPrincipalVigilanteRegistrarActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        limpiarItems();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jTFTipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFTipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFTipActionPerformed

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
                jTFTip.setText("");
            } catch (BussinessException | PersistentException ex) {
                jTFResultado.setSelectedTextColor(Color.red);
                jTFResultado.setForeground(Color.red);
                jTFResultado.setText(mensajeResultadoNegativo);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un numero de TIP",
                    "Error al intentar verificar", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limpiarItems(){
        jTFPrincipalVigilantePlaca.setText("");
        jTFPrincipalVigilanteMarca.setText("");
        jTFPrincipalVigilanteColor.setText("");
        jCBPrincipalVigilanteTipoVehiculo.setSelectedIndex(0);
        jTFPrincipalVigilanteTipRegistro.setText("");
        jTFPrincipalVigilanteModelo.setText("");
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
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBPrincipalVigilanteRegistrar;
    private javax.swing.JComboBox jCBPrincipalVigilanteTipoVehiculo;
    private javax.swing.JLabel jLLogoUdeA;
    private javax.swing.JLabel jLPrincipalVigilanteTituloCamara;
    private javax.swing.JLabel jLPrincipalVigilanteTituloFoto;
    private javax.swing.JLabel jLPrincipalVigilanteTituloResultadoE;
    private javax.swing.JLabel jLPrincipalVigilanteTituloResultadoP;
    private javax.swing.JLabel jLPrincipalVigilanteTituloTIP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTFPlacaResult;
    private javax.swing.JTextField jTFPrincipalVigilanteColor;
    private javax.swing.JTextField jTFPrincipalVigilanteMarca;
    private javax.swing.JTextField jTFPrincipalVigilanteModelo;
    private javax.swing.JTextField jTFPrincipalVigilantePlaca;
    private javax.swing.JTextField jTFPrincipalVigilanteTipRegistro;
    private javax.swing.JTextField jTFResultado;
    private javax.swing.JTextField jTFTip;
    private javax.swing.JTabbedPane jTPPrincipalVigilante;
    // End of variables declaration//GEN-END:variables
}
