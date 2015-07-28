package co.udea.edu.proyectointegrador.gr11.parqueaderoapp.presentacion.swing;

import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.controller.OperarioController;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.Operario;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.OperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.entities.TipoOperarioUser;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.BussinessException;
import co.udea.edu.proyectointegrador.gr11.parqueaderoapp.domain.exception.PersistentException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Teban-Ing
 */
public class PrincipalAdmin extends javax.swing.JFrame {

    /**
     * Controlador para gestionar la lógica de los operarios
     */
    private OperarioController operarioController;

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
    private String confirmPassword;
    private String identificacion;
    private int idTipoOperarioUser;
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
    private boolean coindiceContrasena= true;

    private List<TipoOperarioUser> tiposOperario;

    public PrincipalAdmin() {
        initComponents();
        operarioController = new OperarioController();
        operario = null;
        esNuevoOperario = false;
        coindiceContrasena = true;
        agregarItems(jcTipoUsuarioOperario);
        jcTipoUsuarioOperario.setEditable(false);
        jbOperacion.setVisible(false);
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
        identificacion= jtCedulaOperario.getText();
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
        jtNombreUsuarioOperario.setText("");
        jtApellidosOperario.setText("");
        jtDireccionOperario.setText("");
        jtTelefonoOperario.setText("");
        jtNombreUsuarioOperario.setText("");
        jcTipoUsuarioOperario.setSelectedIndex(0);
        jcActivoOperario.setSelected(true);
        jbOperacion.setVisible(false);
        jBBuscarOperario.setEnabled(true);

    }

    public void habilitarCamposUsuarioExistente() {
        jtNombresOperario.setText(operario.getNombre());
        jtApellidosOperario.setText(operario.getApellido());
        jtDireccionOperario.setText(operario.getDireccion());
        jtTelefonoOperario.setText(operario.getTelefono());
        jtNombreUsuarioOperario.setText(operario.getOperarioUser().getNombreUsuarioOperario());
        int idtipoOperario = operario.getOperarioUser().getTipoOperarioUser().getIdTipoOperarioUser();
        jcTipoUsuarioOperario.setSelectedIndex(idtipoOperario + 1);
        jcActivoOperario.setSelected(operario.getOperarioUser().isActivo());
        jtNombresOperario.setEditable(true);
        jtApellidosOperario.setEditable(true);
        jtDireccionOperario.setEditable(true);
        jtTelefonoOperario.setEditable(true);
        jpConfirmarContrasenaOperario.setEditable(true);
        jPContrasenaOperario.setEditable(true);
        jbOperacion.setEnabled(true);
        jbOperacion.setVisible(true);
        jbOperacion.setText("Actualizar");
        esNuevoOperario = false;
        jtCedulaOperario.setEditable(false);
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
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
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
        jbCancelarOperacion = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jMBPrincipalAdminArchivo = new javax.swing.JMenuBar();
        jMPrincipalAdminMenu = new javax.swing.JMenu();
        jMIPrincipalAdminCerrar = new javax.swing.JMenuItem();
        jMIPrincipalAdminSalir = new javax.swing.JMenuItem();
        jMPrincipalAdminAyuda = new javax.swing.JMenu();
        jMIPrincipalAdminAsistencia = new javax.swing.JMenuItem();
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
                .addContainerGap(145, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPPrincipalAdminBusquedaOperarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBBuscarOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jbOperacion.setText("Agregar");
        jbOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOperacionActionPerformed(evt);
            }
        });

        jbCancelarOperacion.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbOperacion)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtApellidosOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtDireccionOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtNombresOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtTelefonoOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPContrasenaOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jpConfirmarContrasenaOperario))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jtNombreUsuarioOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jcTipoUsuarioOperario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcActivoOperario))))
                            .addComponent(jbCancelarOperacion))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addComponent(jSeparator3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jtNombresOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtNombreUsuarioOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jtApellidosOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPContrasenaOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jtDireccionOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpConfirmarContrasenaOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jtTelefonoOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcTipoUsuarioOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcActivoOperario))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbOperacion)
                    .addComponent(jbCancelarOperacion))
                .addGap(17, 17, 17))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPPrincipalAdminOperariosLayout.setVerticalGroup(
            jPPrincipalAdminOperariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPPrincipalAdminOperariosLayout.createSequentialGroup()
                .addComponent(jPPrincipalAdminBusquedaOperario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPPrincipalAdmin.addTab("Gestión de operarios", jPPrincipalAdminOperarios);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );

        jTPPrincipalAdmin.addTab("Reportes e Ingresos", jPanel2);

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

        jMIPrincipalAdminAsistencia.setText("Asistencia y documentación");
        jMIPrincipalAdminAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPrincipalAdminAsistenciaActionPerformed(evt);
            }
        });
        jMPrincipalAdminAyuda.add(jMIPrincipalAdminAsistencia);

        jMIPrincipalAdminAcerca.setText("Acerca de...");
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTPPrincipalAdmin)
                .addContainerGap())
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

    private void jMIPrincipalAdminAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPrincipalAdminAsistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMIPrincipalAdminAsistenciaActionPerformed

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

    private void jbOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOperacionActionPerformed
        String funcion = esNuevoOperario ? "agregar" : "actualizar";

        if(!crearOperario(esNuevoOperario)){
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
    private javax.swing.JButton jBBuscarOperario;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JMenuItem jMIPrincipalAdminAsistencia;
    private javax.swing.JMenuItem jMIPrincipalAdminCerrar;
    private javax.swing.JMenuItem jMIPrincipalAdminSalir;
    private javax.swing.JMenu jMPrincipalAdminAyuda;
    private javax.swing.JMenu jMPrincipalAdminMenu;
    private javax.swing.JPasswordField jPContrasenaOperario;
    private javax.swing.JPanel jPPrincipalAdminBusquedaOperario;
    private javax.swing.JPanel jPPrincipalAdminOperarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTPPrincipalAdmin;
    private javax.swing.JButton jbCancelarOperacion;
    private javax.swing.JButton jbOperacion;
    private javax.swing.JCheckBox jcActivoOperario;
    private javax.swing.JComboBox jcTipoUsuarioOperario;
    private javax.swing.JPasswordField jpConfirmarContrasenaOperario;
    private javax.swing.JTextField jtApellidosOperario;
    private javax.swing.JTextField jtCedulaOperario;
    private javax.swing.JTextField jtDireccionOperario;
    private javax.swing.JTextField jtNombreUsuarioOperario;
    private javax.swing.JTextField jtNombresOperario;
    private javax.swing.JTextField jtTelefonoOperario;
    // End of variables declaration//GEN-END:variables

}
