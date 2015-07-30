package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.presentacion.swing;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.data.daos.EstadisticasDao;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.EstadisticaController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.GraficasController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.IngresoController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.OperarioController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Ingreso;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Operario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.OperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoOperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.entities.HoraDelDiaEstadistica;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.stadistics.graphics.implement.Grafica;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author Teban-Ing
 */
public class PrincipalAdmin extends javax.swing.JFrame {

    /**
     * Controlador para gestionar la lógica de los operarios.
     */
    private final OperarioController operarioController;

    /**
     * Controlador para los ingresos.
     */
    private final IngresoController ingresoController;
    
    /**
     * Controlador para las estadísticas.
     */
    
    private final GraficasController graficasController;

    /**
     * Los ingresos para las estadísticas.
     */
    private List<Ingreso> ingresos;

    /**
     * Datos del operario
     */
    private String cedula;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String nombreUsuario;
    private String password;
    private String identificacion;
    /**
     * Operario en la sesión.
     */
    private Operario operario;
    /**
     * Controla la operacion
     */
    private boolean esNuevoOperario;

    /**
     * Coincide la contraseña
     */
    private boolean coindiceContrasena = true;

    private List<TipoOperarioUser> tiposOperario;

    /**
     * Variables para los graficos de las estadisticas
     */
    private JFreeChart chartTipoVehiculo;
    private JFreeChart chartTipoUsuario;
    private JFreeChart chartHorasDelDia;

    public PrincipalAdmin() {
        
        operarioController = new OperarioController();
        ingresoController = new IngresoController();
        graficasController= new GraficasController();
        crearGraficos(new Date(), new Date());
        initComponents();
        this.setLocationRelativeTo(null);
        panelHoras.setPreferredSize(new Dimension(50, 50));
        panelHoras.setMaximumSize(new Dimension(50, 50));
        panelTipoUsuario.setPreferredSize(new Dimension(228, 211));
        panelTipoVehiculo.setPreferredSize(new Dimension(228, 211));

        operario = null;
        esNuevoOperario = false;
        coindiceContrasena = false;
        agregarItems(jcTipoUsuarioOperario);
        jcTipoUsuarioOperario.setEditable(false);
        jbOperacion.setVisible(false);
    }

    private void crearGraficos(Date fechaInicial,Date FechaFinal) {
        try {
            
            chartHorasDelDia = graficasController.getChartToHourOfDay(fechaInicial, FechaFinal);
            
            chartTipoUsuario = graficasController.getChartToTypeUser(fechaInicial, FechaFinal);
            chartTipoVehiculo = graficasController.getChartToTypeVehicle(fechaInicial, FechaFinal);
        } catch (BussinessException ex) {
            Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("images/logotipo-udea_opt.png"));
        return retValue;
    }

    private void habilitarCamposUsuarioNuevo() {
        jtNombresOperario.setEditable(true);
        jtApellidosOperario.setEditable(true);
        jtDireccionOperario.setEditable(true);
        jtTelefonoOperario.setEditable(true);
        jtNombreUsuarioOperario.setEditable(true);
        jPContrasenaOperario.setEditable(true);
        jpConfirmarContrasenaOperario.setEditable(true);
        jcTipoUsuarioOperario.setEditable(true);
        jcActivoOperario.setEnabled(true);
        esNuevoOperario = true;
        jbOperacion.setText("Agregar");
        jbOperacion.setVisible(true);
    }

    private void agregarItems(JComboBox caja) {
        try {
            tiposOperario = operarioController.getTiposOperario();
            for (TipoOperarioUser tipoOperario : tiposOperario) {
                caja.addItem(tipoOperario.getDescripcion());
            }
        } catch (BussinessException | PersistentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validarDatosdeIngreso() {
        if (jtNombresOperario.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hay campos sin llenar en el formulario", "Advertencia", JOptionPane.ERROR_MESSAGE);
            jtNombresOperario.grabFocus();
            return false;
        }
        if (jtApellidosOperario.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hay campos sin llenar en el formulario", "Advertencia", JOptionPane.ERROR_MESSAGE);
            jtApellidosOperario.grabFocus();
            return false;
        }
        if (jtDireccionOperario.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hay campos sin llenar en el formulario", "Advertencia", JOptionPane.ERROR_MESSAGE);
            jtDireccionOperario.grabFocus();
            return false;
        }

        if (jtTelefonoOperario.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hay campos sin llenar en el formulario", "Advertencia", JOptionPane.ERROR_MESSAGE);
            jtTelefonoOperario.grabFocus();
            return false;
        }
        if (jtNombreUsuarioOperario.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hay campos sin llenar en el formulario", "Advertencia", JOptionPane.ERROR_MESSAGE);
            jtNombreUsuarioOperario.grabFocus();
            return false;
        }
        if (jPContrasenaOperario.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Hay campos sin llenar en el formulario", "Advertencia", JOptionPane.ERROR_MESSAGE);
            jPContrasenaOperario.grabFocus();
            return false;
        }
        if (jpConfirmarContrasenaOperario.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Hay campos sin llenar en el formulario", "Advertencia", JOptionPane.ERROR_MESSAGE);
            jpConfirmarContrasenaOperario.grabFocus();
            return false;
        }
        if (!coindiceContrasena) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (jcTipoUsuarioOperario.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de operario", "Advertencia", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }

    public boolean crearOperario(boolean operacion) {

        if (!validarDatosdeIngreso()) {
            return false;
        }
        String funcion = (operacion) ? "agregará" : "actualizará";

        if (!jcActivoOperario.isSelected()) {
            if (JOptionPane.showConfirmDialog(this, "Está seguro que el usuario que "
                    + "se " + funcion + " esté inactivo?", "Advertencia",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) != JOptionPane.YES_OPTION) {
                return false;
            }
        }
        identificacion = jtCedulaOperario.getText();
        nombres = jtNombresOperario.getText();
        apellidos = jtApellidosOperario.getText();
        direccion = jtDireccionOperario.getText();
        telefono = jtTelefonoOperario.getText();
        nombreUsuario = jtNombreUsuarioOperario.getText();
        password = String.copyValueOf(jPContrasenaOperario.getPassword());

        operario = new Operario();
        operario.setOperarioUser(new OperarioUser());
        operario.setIdentificacion(identificacion);
        operario.setNombre(nombres);
        operario.setApellido(apellidos);
        operario.setDireccion(direccion);
        operario.setTelefono(telefono);
        operario.getOperarioUser().setActivo(jcActivoOperario.isSelected());
        operario.getOperarioUser().setNombreUsuarioOperario(nombreUsuario);
        operario.getOperarioUser().setPassword(password);
        for (TipoOperarioUser tiposOperario1 : tiposOperario) {
            if (tiposOperario1.getDescripcion().equals((String) jcTipoUsuarioOperario.getSelectedItem())) {
                operario.getOperarioUser().setTipoOperarioUser(
                        new TipoOperarioUser(tiposOperario1.getIdTipoOperarioUser(), null));
            }
        }
        return true;
    }

    private void vaciarCampos() {

        jtCedulaOperario.setText("");
        jtNombresOperario.setText("");
        jtApellidosOperario.setText("");
        jtDireccionOperario.setText("");
        jtTelefonoOperario.setText("");
        jtNombreUsuarioOperario.setText("");
        jcTipoUsuarioOperario.setSelectedIndex(0);
        jcActivoOperario.setSelected(true);
        jbOperacion.setVisible(false);
        jBBuscarOperario.setEnabled(true);
        jPContrasenaOperario.setText("");
        jpConfirmarContrasenaOperario.setText("");
        jtCedulaOperario.setEditable(true);
        jtNombreUsuarioOperario.setEditable(true);

    }

    public void habilitarCamposUsuarioExistente() {
        jtNombresOperario.setText(operario.getNombre());
        jtApellidosOperario.setText(operario.getApellido());
        jtDireccionOperario.setText(operario.getDireccion());
        jtTelefonoOperario.setText(operario.getTelefono());
        jPContrasenaOperario.setText(operario.getOperarioUser().getPassword());
        jpConfirmarContrasenaOperario.setText(operario.getOperarioUser().getPassword());
        jtNombreUsuarioOperario.setText(operario.getOperarioUser().getNombreUsuarioOperario());
        int idtipoOperario = operario.getOperarioUser().getTipoOperarioUser().getIdTipoOperarioUser();
        jcTipoUsuarioOperario.setSelectedIndex(idtipoOperario + 1);
        jcActivoOperario.setSelected(operario.getOperarioUser().isActivo());
        jtNombresOperario.setEditable(true);
        jtApellidosOperario.setEditable(true);
        jtDireccionOperario.setEditable(true);
        jtTelefonoOperario.setEditable(true);
        jpConfirmarContrasenaOperario.setEditable(true);
        jtNombreUsuarioOperario.setEditable(false);
        jPContrasenaOperario.setEditable(true);
        jbOperacion.setEnabled(true);
        jbOperacion.setVisible(true);
        jbOperacion.setText("Actualizar");
        esNuevoOperario = false;
        jtCedulaOperario.setEditable(false);
        jBBuscarOperario.setEnabled(false);
    }

    private void validarCoincidencia() {
        String password1 = String.copyValueOf(jPContrasenaOperario.getPassword());
        String passwordCoincidencia = String.copyValueOf(jpConfirmarContrasenaOperario.getPassword());

        if (password1.equals(passwordCoincidencia)) {
            jtCoinciden.setText("Coinciden");
            jtCoinciden.setForeground(new Color(48, 147, 38));
            coindiceContrasena = true;
        } else {
            jtCoinciden.setText("No coinciden.");
            jtCoinciden.setForeground(Color.red);
            coindiceContrasena = false;
        }
    }

    private void mostrarIngresos() {
        try {
            ingresos = ingresoController.getIngresosByDate(
                    seleccionadorFechaInicial.getSelectedDate().getTime(),
                    seleccionadorFechaFinal.getSelectedDate().getTime());
        } catch (PersistentException ex) {
            JOptionPane.showMessageDialog(this, "Hubo Un error con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } catch (BussinessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (ingresos == null || ingresos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay datos para mostrar con el filtro indicado", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[][] datosTabla = new String[ingresos.size()][tablaIngresos.getColumnCount()];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");
        DefaultTableModel tableModel = (DefaultTableModel) tablaIngresos.getModel();
        tableModel.getDataVector().clear();

        for (int i = 0; i < ingresos.size(); i++) {
            Ingreso ingreso = ingresos.get(i);
            datosTabla[i][0] = ingreso.getId().getUsuarioIdentificacion();
            datosTabla[i][1] = ingreso.getUsuarioVehiculo()
                    .getUsuario().getNombre().
                    concat(" ").
                    concat(ingreso.getUsuarioVehiculo().getUsuario().getApellido());
            datosTabla[i][2] = ingreso.getUsuarioVehiculo()
                    .getUsuario().getTipoUsuario()
                    .getTipoUsuarioDescripcion();
            datosTabla[i][3] = ingreso.getUsuarioVehiculo().getVehiculo().getPlaca();

            datosTabla[i][4] = dateFormat.format(ingreso.getId().getFechaIngreso());
            if (ingreso.getFechaSalida() != null) {
                datosTabla[i][5] = dateFormat.format(ingreso.getFechaSalida());
            } else {
                datosTabla[i][5] = "";
            }
            tableModel.addRow(datosTabla[i]);
            revalidate();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTPPrincipalAdmin = new javax.swing.JTabbedPane();
        jPPrincipalAdminOperarios = new javax.swing.JPanel();
        jPPrincipalAdminBusquedaOperario = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtCedulaOperario = new javax.swing.JTextField();
        jBBuscarOperario = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        panelDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jcActivoOperario = new javax.swing.JCheckBox();
        jcTipoUsuarioOperario = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jtNombresOperario = new javax.swing.JTextField();
        jtApellidosOperario = new javax.swing.JTextField();
        jtDireccionOperario = new javax.swing.JTextField();
        jtTelefonoOperario = new javax.swing.JTextField();
        jtNombreUsuarioOperario = new javax.swing.JTextField();
        jPContrasenaOperario = new javax.swing.JPasswordField();
        jpConfirmarContrasenaOperario = new javax.swing.JPasswordField();
        jbOperacion = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jtCoinciden = new javax.swing.JLabel();
        jPanelEstadistica = new javax.swing.JPanel();
        panelFiltros = new javax.swing.JPanel();
        jBBuscarIngresos = new javax.swing.JButton();
        jBLimpiarIngresos = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        seleccionadorFechaFinal = new datechooser.beans.DateChooserCombo();
        seleccionadorFechaInicial = new datechooser.beans.DateChooserCombo();
        jSeparator4 = new javax.swing.JSeparator();
        panelIngresos = new javax.swing.JScrollPane();
        tablaIngresos = new javax.swing.JTable();
        panelEstadistica = new javax.swing.JPanel();
        panelFiltrosEstadisticas = new javax.swing.JPanel();
        jBBuscarEstadisticas = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        seleccionadorFechaFinalEstadistica = new datechooser.beans.DateChooserCombo();
        seleccionadorFechaInicialEstadistica = new datechooser.beans.DateChooserCombo();
        panelTipoUsuario = new ChartPanel(this.chartTipoUsuario);
        panelTipoVehiculo = new ChartPanel(this.chartTipoVehiculo);
        panelHoras = new ChartPanel(this.chartHorasDelDia);
        jMBPrincipalAdminArchivo = new javax.swing.JMenuBar();
        jMPrincipalAdminMenu = new javax.swing.JMenu();
        jMIPrincipalAdminCerrar = new javax.swing.JMenuItem();
        jMIPrincipalAdminSalir = new javax.swing.JMenuItem();
        jMPrincipalAdminAyuda = new javax.swing.JMenu();
        jMIPrincipalAdminAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de la administración");
        setIconImage(getIconImage());
        setResizable(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoudea.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cedula:");

        jtCedulaOperario.setMinimumSize(new java.awt.Dimension(6, 10));
        jtCedulaOperario.setPreferredSize(new java.awt.Dimension(6, 10));

        jBBuscarOperario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBBuscarOperario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jBBuscarOperario.setToolTipText("Buscar un operario por cédula, si no existe, se permitira agregarlo.");
        jBBuscarOperario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarOperarioActionPerformed(evt);
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

        javax.swing.GroupLayout jPPrincipalAdminBusquedaOperarioLayout = new javax.swing.GroupLayout(jPPrincipalAdminBusquedaOperario);
        jPPrincipalAdminBusquedaOperario.setLayout(jPPrincipalAdminBusquedaOperarioLayout);
        jPPrincipalAdminBusquedaOperarioLayout.setHorizontalGroup(
            jPPrincipalAdminBusquedaOperarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrincipalAdminBusquedaOperarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtCedulaOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBBuscarOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPPrincipalAdminBusquedaOperarioLayout.setVerticalGroup(
            jPPrincipalAdminBusquedaOperarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrincipalAdminBusquedaOperarioLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPPrincipalAdminBusquedaOperarioLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPPrincipalAdminBusquedaOperarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtCedulaOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPPrincipalAdminBusquedaOperarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPPrincipalAdminBusquedaOperarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscarOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Nombres:");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Dirección:");

        jLabel6.setText("Telefono:");

        jLabel7.setText("Nombre de usuario:");

        jLabel8.setText("Contraseña:");

        jLabel9.setText("Confirmar: ");

        jcActivoOperario.setText("Activo");

        jcTipoUsuarioOperario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de usuario" }));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPContrasenaOperario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPContrasenaOperarioKeyReleased(evt);
            }
        });

        jpConfirmarContrasenaOperario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jpConfirmarContrasenaOperarioKeyReleased(evt);
            }
        });

        jbOperacion.setText("Agregar");
        jbOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOperacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtApellidosOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtDireccionOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtNombresOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtTelefonoOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelDatosLayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPContrasenaOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelDatosLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtNombreUsuarioOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelDatosLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtCoinciden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jpConfirmarContrasenaOperario))))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addComponent(jcTipoUsuarioOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jcActivoOperario)))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addComponent(jSeparator3))
                .addContainerGap())
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jbOperacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jtNombresOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtNombreUsuarioOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jtApellidosOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPContrasenaOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jtCoinciden, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jtDireccionOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jpConfirmarContrasenaOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))))
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jtTelefonoOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelDatosLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcTipoUsuarioOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcActivoOperario))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbOperacion)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPPrincipalAdminOperariosLayout = new javax.swing.GroupLayout(jPPrincipalAdminOperarios);
        jPPrincipalAdminOperarios.setLayout(jPPrincipalAdminOperariosLayout);
        jPPrincipalAdminOperariosLayout.setHorizontalGroup(
            jPPrincipalAdminOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPPrincipalAdminOperariosLayout.createSequentialGroup()
                .addComponent(jPPrincipalAdminBusquedaOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPrincipalAdminOperariosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPPrincipalAdminOperariosLayout.setVerticalGroup(
            jPPrincipalAdminOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrincipalAdminOperariosLayout.createSequentialGroup()
                .addComponent(jPPrincipalAdminBusquedaOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTPPrincipalAdmin.addTab("Gestión de operarios", jPPrincipalAdminOperarios);

        jBBuscarIngresos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBBuscarIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jBBuscarIngresos.setToolTipText("Buscar un operario por cédula, si no existe, se permitira agregarlo.");
        jBBuscarIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarIngresosActionPerformed(evt);
            }
        });

        jBLimpiarIngresos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBLimpiarIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/broom.png"))); // NOI18N
        jBLimpiarIngresos.setToolTipText("Buscar un operario por cédula, si no existe, se permitira agregarlo.");
        jBLimpiarIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarIngresosActionPerformed(evt);
            }
        });

        jLabel10.setText("Fecha Inicial");

        jLabel11.setText("Fecha Final");

        javax.swing.GroupLayout panelFiltrosLayout = new javax.swing.GroupLayout(panelFiltros);
        panelFiltros.setLayout(panelFiltrosLayout);
        panelFiltrosLayout.setHorizontalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seleccionadorFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seleccionadorFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBBuscarIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBLimpiarIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        panelFiltrosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11});

        panelFiltrosLayout.setVerticalGroup(
            panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosLayout.createSequentialGroup()
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFiltrosLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFiltrosLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(seleccionadorFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBLimpiarIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seleccionadorFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscarIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        panelFiltrosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11});

        tablaIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Identificacion", "Nombres", "Tipo de usuario", "Placa", "Fecha Ingreso", "Fecha Salida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        panelIngresos.setViewportView(tablaIngresos);
        if (tablaIngresos.getColumnModel().getColumnCount() > 0) {
            tablaIngresos.getColumnModel().getColumn(0).setResizable(false);
            tablaIngresos.getColumnModel().getColumn(0).setPreferredWidth(25);
            tablaIngresos.getColumnModel().getColumn(1).setResizable(false);
            tablaIngresos.getColumnModel().getColumn(1).setPreferredWidth(120);
            tablaIngresos.getColumnModel().getColumn(2).setResizable(false);
            tablaIngresos.getColumnModel().getColumn(2).setPreferredWidth(40);
            tablaIngresos.getColumnModel().getColumn(3).setResizable(false);
            tablaIngresos.getColumnModel().getColumn(3).setPreferredWidth(6);
            tablaIngresos.getColumnModel().getColumn(4).setResizable(false);
            tablaIngresos.getColumnModel().getColumn(4).setPreferredWidth(50);
            tablaIngresos.getColumnModel().getColumn(5).setResizable(false);
            tablaIngresos.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanelEstadisticaLayout = new javax.swing.GroupLayout(jPanelEstadistica);
        jPanelEstadistica.setLayout(jPanelEstadisticaLayout);
        jPanelEstadisticaLayout.setHorizontalGroup(
            jPanelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEstadisticaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFiltros, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelEstadisticaLayout.setVerticalGroup(
            jPanelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadisticaLayout.createSequentialGroup()
                .addComponent(panelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPPrincipalAdmin.addTab("Busqueda de Ingresos", jPanelEstadistica);

        jBBuscarEstadisticas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jBBuscarEstadisticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jBBuscarEstadisticas.setToolTipText("Buscar un operario por cédula, si no existe, se permitira agregarlo.");
        jBBuscarEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarEstadisticasActionPerformed(evt);
            }
        });

        jLabel12.setText("Fecha Inicial");

        jLabel13.setText("Fecha Final");

        javax.swing.GroupLayout panelFiltrosEstadisticasLayout = new javax.swing.GroupLayout(panelFiltrosEstadisticas);
        panelFiltrosEstadisticas.setLayout(panelFiltrosEstadisticasLayout);
        panelFiltrosEstadisticasLayout.setHorizontalGroup(
            panelFiltrosEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosEstadisticasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seleccionadorFechaInicialEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(seleccionadorFechaFinalEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBBuscarEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        panelFiltrosEstadisticasLayout.setVerticalGroup(
            panelFiltrosEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosEstadisticasLayout.createSequentialGroup()
                .addGroup(panelFiltrosEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFiltrosEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFiltrosEstadisticasLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFiltrosEstadisticasLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(seleccionadorFechaInicialEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFiltrosEstadisticasLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panelFiltrosEstadisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBBuscarEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionadorFechaFinalEstadistica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelTipoUsuarioLayout = new javax.swing.GroupLayout(panelTipoUsuario);
        panelTipoUsuario.setLayout(panelTipoUsuarioLayout);
        panelTipoUsuarioLayout.setHorizontalGroup(
            panelTipoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );
        panelTipoUsuarioLayout.setVerticalGroup(
            panelTipoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelTipoVehiculoLayout = new javax.swing.GroupLayout(panelTipoVehiculo);
        panelTipoVehiculo.setLayout(panelTipoVehiculoLayout);
        panelTipoVehiculoLayout.setHorizontalGroup(
            panelTipoVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );
        panelTipoVehiculoLayout.setVerticalGroup(
            panelTipoVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelHorasLayout = new javax.swing.GroupLayout(panelHoras);
        panelHoras.setLayout(panelHorasLayout);
        panelHorasLayout.setHorizontalGroup(
            panelHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelHorasLayout.setVerticalGroup(
            panelHorasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelEstadisticaLayout = new javax.swing.GroupLayout(panelEstadistica);
        panelEstadistica.setLayout(panelEstadisticaLayout);
        panelEstadisticaLayout.setHorizontalGroup(
            panelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadisticaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelEstadisticaLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(panelTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(panelTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelFiltrosEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 569, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelEstadisticaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {panelTipoUsuario, panelTipoVehiculo});

        panelEstadisticaLayout.setVerticalGroup(
            panelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstadisticaLayout.createSequentialGroup()
                .addComponent(panelFiltrosEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelEstadisticaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {panelTipoUsuario, panelTipoVehiculo});

        jTPPrincipalAdmin.addTab("Estadisticas de Ingresos", panelEstadistica);

        jMPrincipalAdminMenu.setText("Archivo");

        jMIPrincipalAdminCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoOut.png"))); // NOI18N
        jMIPrincipalAdminCerrar.setText("Cerrar sesión");
        jMIPrincipalAdminCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrincipalAdminCerrarActionPerformed(evt);
            }
        });
        jMPrincipalAdminMenu.add(jMIPrincipalAdminCerrar);

        jMIPrincipalAdminSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/liberar-icono-6437-16.png"))); // NOI18N
        jMIPrincipalAdminSalir.setText("Salir");
        jMIPrincipalAdminSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrincipalAdminSalirActionPerformed(evt);
            }
        });
        jMPrincipalAdminMenu.add(jMIPrincipalAdminSalir);

        jMBPrincipalAdminArchivo.add(jMPrincipalAdminMenu);

        jMPrincipalAdminAyuda.setText("Ayuda");

        jMIPrincipalAdminAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMIPrincipalAdminAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoudea16x16.png"))); // NOI18N
        jMIPrincipalAdminAcerca.setText("Acerca de...");
        jMIPrincipalAdminAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrincipalAdminAcercaActionPerformed(evt);
            }
        });
        jMPrincipalAdminAyuda.add(jMIPrincipalAdminAcerca);

        jMBPrincipalAdminArchivo.add(jMPrincipalAdminAyuda);

        setJMenuBar(jMBPrincipalAdminArchivo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPPrincipalAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 590, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPPrincipalAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIPrincipalAdminCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrincipalAdminCerrarActionPerformed
        InicioSesion cerrarSesion = new InicioSesion();
        cerrarSesion.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jMIPrincipalAdminCerrarActionPerformed

    private void jMIPrincipalAdminSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrincipalAdminSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMIPrincipalAdminSalirActionPerformed

    private void jBBuscarOperarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarOperarioActionPerformed
        cedula = jtCedulaOperario.getText();
        if (cedula.equals("")) {
            JOptionPane.showMessageDialog(this, "El campo de cédula no puede estar vacio",
                    "Verifique el campo de cédula", JOptionPane.ERROR_MESSAGE);
            jtCedulaOperario.grabFocus();
            return;
        }
        try {
            operario = operarioController.buscarOperario(jtCedulaOperario.getText());
            habilitarCamposUsuarioExistente();
        } catch (BussinessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Mensaje", JOptionPane.PLAIN_MESSAGE);
            habilitarCamposUsuarioNuevo();

        } catch (PersistentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBBuscarOperarioActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        vaciarCampos();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void jbOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOperacionActionPerformed
        String funcion = esNuevoOperario ? "agregar" : "actualizar";

        if (!crearOperario(esNuevoOperario)) {
            return;
        }
        try {

            if (JOptionPane.showConfirmDialog(this, "Está seguro de "
                    + funcion + " el usuario?", "Advertencia",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) != JOptionPane.YES_OPTION) {
                return;
            }
            if (esNuevoOperario) {
                operarioController.insertarOperario(operario);
                JOptionPane.showMessageDialog(this, "El operario se agegó correctamente",
                        "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                operarioController.actualizarOperario(operario);
                JOptionPane.showMessageDialog(this, "El operario se actualizó correctamente",
                        "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            }

            vaciarCampos();
        } catch (BussinessException | PersistentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbOperacionActionPerformed

    private void jpConfirmarContrasenaOperarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpConfirmarContrasenaOperarioKeyReleased
        validarCoincidencia();
    }//GEN-LAST:event_jpConfirmarContrasenaOperarioKeyReleased

    private void jPContrasenaOperarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPContrasenaOperarioKeyReleased
        validarCoincidencia();
    }//GEN-LAST:event_jPContrasenaOperarioKeyReleased

    private void jBLimpiarIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarIngresosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBLimpiarIngresosActionPerformed

    private void jBBuscarIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarIngresosActionPerformed

        mostrarIngresos();
    }//GEN-LAST:event_jBBuscarIngresosActionPerformed

    private void jBBuscarEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarEstadisticasActionPerformed
        try {
            Date fechaFinal=seleccionadorFechaFinalEstadistica.getSelectedDate().getTime();
            Date fechaInicial= seleccionadorFechaInicialEstadistica.getSelectedDate().getTime();

           graficasController.updateAllCharts(chartTipoVehiculo, chartTipoUsuario, chartHorasDelDia, fechaInicial, fechaFinal);
        } catch (BussinessException ex) {
           JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jBBuscarEstadisticasActionPerformed

    private void jMIPrincipalAdminAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrincipalAdminAcercaActionPerformed
       About nuevo = new About(this, true);
       nuevo.setLocationRelativeTo(this);
        nuevo.setVisible(true);
    }//GEN-LAST:event_jMIPrincipalAdminAcercaActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscarEstadisticas;
    private javax.swing.JButton jBBuscarIngresos;
    private javax.swing.JButton jBBuscarOperario;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBLimpiarIngresos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMBPrincipalAdminArchivo;
    private javax.swing.JMenuItem jMIPrincipalAdminAcerca;
    private javax.swing.JMenuItem jMIPrincipalAdminCerrar;
    private javax.swing.JMenuItem jMIPrincipalAdminSalir;
    private javax.swing.JMenu jMPrincipalAdminAyuda;
    private javax.swing.JMenu jMPrincipalAdminMenu;
    private javax.swing.JPasswordField jPContrasenaOperario;
    private javax.swing.JPanel jPPrincipalAdminBusquedaOperario;
    private javax.swing.JPanel jPPrincipalAdminOperarios;
    private javax.swing.JPanel jPanelEstadistica;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTPPrincipalAdmin;
    private javax.swing.JButton jbOperacion;
    private javax.swing.JCheckBox jcActivoOperario;
    private javax.swing.JComboBox jcTipoUsuarioOperario;
    private javax.swing.JPasswordField jpConfirmarContrasenaOperario;
    private javax.swing.JTextField jtApellidosOperario;
    private javax.swing.JTextField jtCedulaOperario;
    private javax.swing.JLabel jtCoinciden;
    private javax.swing.JTextField jtDireccionOperario;
    private javax.swing.JTextField jtNombreUsuarioOperario;
    private javax.swing.JTextField jtNombresOperario;
    private javax.swing.JTextField jtTelefonoOperario;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelEstadistica;
    private javax.swing.JPanel panelFiltros;
    private javax.swing.JPanel panelFiltrosEstadisticas;
    private javax.swing.JPanel panelHoras;
    private javax.swing.JScrollPane panelIngresos;
    private javax.swing.JPanel panelTipoUsuario;
    private javax.swing.JPanel panelTipoVehiculo;
    private datechooser.beans.DateChooserCombo seleccionadorFechaFinal;
    private datechooser.beans.DateChooserCombo seleccionadorFechaFinalEstadistica;
    private datechooser.beans.DateChooserCombo seleccionadorFechaInicial;
    private datechooser.beans.DateChooserCombo seleccionadorFechaInicialEstadistica;
    private javax.swing.JTable tablaIngresos;
    // End of variables declaration//GEN-END:variables

}
