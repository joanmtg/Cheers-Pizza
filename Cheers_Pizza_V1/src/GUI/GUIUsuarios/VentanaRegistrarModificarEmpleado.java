/**
 * Proyecto Desarrollo de Software II
 * Universidad del Valle
 * EISC
 *
 * Integrantes: 
 *
 * Jhonier Andrés Calero Rodas		1424599
 * Fabio Andrés Castañeda Duarte	1424386
 * Juan Pablo Moreno Muñoz		1423437
 * Joan Manuel Tovar Guzmán		1423124
 *
 * file: VentanaRegistrarModificarEmpleado.java
 * 
 */
package GUI.GUIUsuarios;

import AccesoDatosORM.AdaptadorEmpleadoControlador;
import AccesoDatosORM.AdaptadorSucursalControlador;
import Administracion.Empleado;
import Administracion.Sucursal;
import GUI.GUIItems.VentanaRegistrarModificarItem;
import GUI.VentanaCajero;
import GUI.VentanaMesero;
import Validaciones.Validaciones;
import Validaciones.Encriptar;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.persistence.EntityExistsException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author invitado
 */
public class VentanaRegistrarModificarEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form VentanaRegistrarModificarUsuario
     */
    AdaptadorEmpleadoControlador controladorEmpleado = new AdaptadorEmpleadoControlador();
    AdaptadorSucursalControlador controladorSucursal = new AdaptadorSucursalControlador();
    Validaciones validacion = new Validaciones();
    Encriptar encriptador = new Encriptar();
    File ficheroImagen;

    JFrame ventanaAnterior;
    String operacion; //"Registro" o "Modificación"
    Empleado empleado;
    Empleado empleadoActual;
    boolean nuevaImagen;

    public VentanaRegistrarModificarEmpleado(JFrame anterior, String operacion, Empleado empleado, Empleado empleadoActual) {
        super(operacion + " de Empleado");
        initComponents();

        setLocationRelativeTo(null);

        this.ventanaAnterior = anterior;
        this.operacion = operacion;
        this.empleado = empleado;
        this.empleadoActual = empleadoActual;
        
        
        ponerTodasLasSucursales();

        defaultImage();
                      

        if (operacion.equals("Modificacion")) {
            
            String cargo = this.empleado.getCargo();  
            if(cargo.equals("Mesero") || cargo.equals("Cajero")){                
                cbCargo.setEnabled(false);
                cbSucursales.setEnabled(false);
            }

            cbTipoID.setSelectedItem(empleado.getTipoId());
            tfIdentificacion.setText(empleado.getId());
            tfIdentificacion.setEditable(false);

            tfNombre.setText(empleado.getNombre());
            tfApellidos.setText(empleado.getApellidos());
            tfTelefono.setText(empleado.getTelefono());
            tfDireccion.setText(empleado.getDireccion());
            cbCargo.setSelectedItem(empleado.getCargo());
            cbSucursales.setSelectedItem(empleado.getSucursal().getNombre());

            spHoraInicio.setValue(empleado.getHoraInicio().getHour());
            spHoraFin.setValue(empleado.getHoraFin().getHour());

            BufferedImage img = decodeToImage(empleado.getFotoURL());
            ImageIcon icon = new ImageIcon(img);
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lFoto.getWidth(), lFoto.getHeight(), Image.SCALE_DEFAULT));
            lFoto.setIcon(icono);

            //Se desencripta la contraseña primero
            String pass_desencriptada = null;
            try {
                pass_desencriptada = encriptador.desencriptar(empleado.getPassword());
            } catch (Exception ex) {
                System.out.println("Error al momento de desencriptar la contraseña. Constructor. 'Modificación'");
            }
            tfPassword.setText(pass_desencriptada);

        } else if (operacion.equals("Visualizacion")) {

            cbTipoID.setEnabled(false);
            tfIdentificacion.setEditable(false);
            tfNombre.setEditable(false);
            tfApellidos.setEditable(false);
            cbCargo.setEnabled(false);
            cbSucursales.setEnabled(false);
            spHoraInicio.setEnabled(false);
            spHoraFin.setEnabled(false);
            tfPassword.setEditable(false);
            bCambiarFoto.setEnabled(false);
            bLimpiar.setEnabled(false);
            bFinalizar.setEnabled(false);

            cbTipoID.setSelectedItem(empleado.getTipoId());
            tfIdentificacion.setText(empleado.getId());

            tfNombre.setText(empleado.getNombre());
            tfApellidos.setText(empleado.getApellidos());
            tfTelefono.setText(empleado.getTelefono());
            tfDireccion.setText(empleado.getDireccion());
            cbCargo.setSelectedItem(empleado.getCargo());
            cbSucursales.setSelectedItem(empleado.getSucursal().getNombre());

            spHoraInicio.setValue(empleado.getHoraInicio().getHour());
            spHoraFin.setValue(empleado.getHoraFin().getHour());

            BufferedImage img = decodeToImage(empleado.getFotoURL());
            ImageIcon icon = new ImageIcon(img);
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lFoto.getWidth(), lFoto.getHeight(), Image.SCALE_DEFAULT));
            lFoto.setIcon(icono);

            //Se desencripta la contraseña primero
            String pass_desencriptada = null;
            try {
                pass_desencriptada = encriptador.desencriptar(empleado.getPassword());
            } catch (Exception ex) {
                System.out.println("Error al momento de desencriptar la contraseña. Constructor. 'Visualización'");
            }
            tfPassword.setText(pass_desencriptada);

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

        panelPrincipal = new javax.swing.JPanel();
        panelInferior = new javax.swing.JPanel();
        bAtras = new javax.swing.JButton();
        bFinalizar = new javax.swing.JButton();
        bLimpiar = new javax.swing.JButton();
        lNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        LTipoID = new javax.swing.JLabel();
        cbTipoID = new javax.swing.JComboBox<>();
        lIdentificacion = new javax.swing.JLabel();
        tfIdentificacion = new javax.swing.JTextField();
        lApellidos = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        lCargo = new javax.swing.JLabel();
        lCargo1 = new javax.swing.JLabel();
        lTelefono = new javax.swing.JLabel();
        lTelefono1 = new javax.swing.JLabel();
        lTurno = new javax.swing.JLabel();
        tfApellidos = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        bCambiarFoto = new javax.swing.JButton();
        lSucursal = new javax.swing.JLabel();
        cbSucursales = new javax.swing.JComboBox<>();
        lInicio = new javax.swing.JLabel();
        lFin = new javax.swing.JLabel();
        spHoraInicio = new javax.swing.JSpinner();
        spHoraFin = new javax.swing.JSpinner();
        lFoto = new javax.swing.JLabel();
        lPassword = new javax.swing.JLabel();
        tfPassword = new javax.swing.JPasswordField();
        lLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(89, 30, 27));

        panelInferior.setBackground(new java.awt.Color(89, 30, 27));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ingrese los datos del empleado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Eras Medium ITC", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N

        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtras.png"))); // NOI18N
        bAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtrasPR.png"))); // NOI18N
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        bFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bFinalizar.png"))); // NOI18N
        bFinalizar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bFinalizarPR.png"))); // NOI18N
        bFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFinalizarActionPerformed(evt);
            }
        });

        bLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bLimpiar.png"))); // NOI18N
        bLimpiar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bLimpiarPR.png"))); // NOI18N

        lNombre.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lNombre.setForeground(new java.awt.Color(255, 255, 255));
        lNombre.setText("Nombre:");

        LTipoID.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        LTipoID.setForeground(new java.awt.Color(255, 255, 255));
        LTipoID.setText("Tipo de ID:");

        cbTipoID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo", "Cédula de ciudadanía", "NIT" }));
        cbTipoID.setPreferredSize(new java.awt.Dimension(127, 30));

        lIdentificacion.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lIdentificacion.setForeground(new java.awt.Color(255, 255, 255));
        lIdentificacion.setText("Identificación:");

        tfIdentificacion.setPreferredSize(new java.awt.Dimension(6, 30));
        tfIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfIdentificacionKeyTyped(evt);
            }
        });

        lApellidos.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lApellidos.setForeground(new java.awt.Color(255, 255, 255));
        lApellidos.setText("Apellidos:");

        cbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un cargo", "Gerente", "Mesero", "Cajero" }));
        cbCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCargoActionPerformed(evt);
            }
        });

        lCargo.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lCargo.setForeground(new java.awt.Color(255, 255, 255));
        lCargo.setText("Cargo:");

        lCargo1.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lCargo1.setForeground(new java.awt.Color(255, 255, 255));
        lCargo1.setText("Dirección:");

        lTelefono.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lTelefono.setText("Teléfono:");

        lTelefono1.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lTelefono1.setForeground(new java.awt.Color(255, 255, 255));
        lTelefono1.setText("Foto:");

        lTurno.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lTurno.setForeground(new java.awt.Color(255, 255, 255));
        lTurno.setText("Turno:");

        tfTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelefonoKeyTyped(evt);
            }
        });

        bCambiarFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bCambiar.png"))); // NOI18N
        bCambiarFoto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bCambiarPR.png"))); // NOI18N
        bCambiarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCambiarFotoActionPerformed(evt);
            }
        });

        lSucursal.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lSucursal.setForeground(new java.awt.Color(255, 255, 255));
        lSucursal.setText("Sucursal:");

        cbSucursales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una sucursal" }));

        lInicio.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lInicio.setForeground(new java.awt.Color(255, 255, 255));
        lInicio.setText("Inicio:");

        lFin.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lFin.setForeground(new java.awt.Color(255, 255, 255));
        lFin.setText("Fin:");

        spHoraInicio.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));
        spHoraInicio.setEditor(new javax.swing.JSpinner.NumberEditor(spHoraInicio, ""));
        spHoraInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spHoraInicioKeyTyped(evt);
            }
        });

        spHoraFin.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));
        spHoraFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spHoraFinKeyTyped(evt);
            }
        });

        lFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/imageUser.jpg"))); // NOI18N

        lPassword.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lPassword.setForeground(new java.awt.Color(255, 255, 255));
        lPassword.setText("Password:");

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(LTipoID)
                            .addGap(32, 32, 32)
                            .addComponent(cbTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(lIdentificacion)
                            .addGap(26, 26, 26)
                            .addComponent(tfIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelInferiorLayout.createSequentialGroup()
                            .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelInferiorLayout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(lNombre)
                                    .addGap(32, 32, 32)
                                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(71, 71, 71)
                                    .addComponent(lApellidos)
                                    .addGap(26, 26, 26)
                                    .addComponent(tfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelInferiorLayout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelInferiorLayout.createSequentialGroup()
                                            .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lTelefono1)
                                                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelInferiorLayout.createSequentialGroup()
                                                    .addGap(41, 41, 41)
                                                    .addComponent(lFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(panelInferiorLayout.createSequentialGroup()
                                                    .addGap(36, 36, 36)
                                                    .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(bFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(lCargo))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelInferiorLayout.createSequentialGroup()
                                            .addComponent(lPassword)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(bCambiarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelInferiorLayout.createSequentialGroup()
                                            .addComponent(lTurno)
                                            .addGap(27, 27, 27)
                                            .addComponent(lInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(spHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lFin)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(spHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lTelefono)
                        .addGap(32, 32, 32)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addComponent(lCargo1)
                                .addGap(26, 26, 26)
                                .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addComponent(lSucursal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lIdentificacion))
                    .addComponent(tfIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lNombre))
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lTelefono)
                            .addComponent(lCargo1))))
                .addGap(32, 32, 32)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lSucursal))
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lCargo)
                        .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lTelefono1)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lPassword)
                                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lTurno)
                                    .addComponent(lInicio)
                                    .addComponent(spHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lFin)
                                    .addComponent(spHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addComponent(bCambiarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bFinalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lLogo.setBackground(new java.awt.Color(89, 30, 27));
        lLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoPequeno.png"))); // NOI18N
        lLogo.setMaximumSize(new java.awt.Dimension(140, 140));
        lLogo.setMinimumSize(new java.awt.Dimension(140, 140));
        lLogo.setPreferredSize(new java.awt.Dimension(140, 140));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed

        this.dispose();
        
        if(empleadoActual.getCargo().equals("Mesero")){
            VentanaMesero ventMesero = (VentanaMesero) ventanaAnterior;
            ventMesero.setVisible(true);
        } else if(empleadoActual.getCargo().equals("Cajero")){
            VentanaCajero ventCajero = (VentanaCajero) ventanaAnterior;
            ventCajero.setVisible(true);
        }
        else{//Gerente
            VentanaGestionEmpleados ventanaEmpleados = (VentanaGestionEmpleados) ventanaAnterior;
            ventanaEmpleados.llenarTablaEmpleados();
            ventanaAnterior.setVisible(true);
        }
        

    }//GEN-LAST:event_bAtrasActionPerformed

    private void bFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFinalizarActionPerformed

        if (cbTipoID.getSelectedIndex() == 0 || tfIdentificacion.getText().equals("") || tfNombre.getText().equals("")
                || tfApellidos.getText().equals("") || tfTelefono.getText().equals("") || tfDireccion.getText().equals("")
                || cbCargo.getSelectedIndex() == 0 || cbSucursales.getSelectedIndex() == 0 || tfPassword.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Debe ingresar todos los campos solicitados", "Mensaje", JOptionPane.WARNING_MESSAGE);

        } else if (tfIdentificacion.getText().length() != 8 && tfIdentificacion.getText().length() != 10) {

            JOptionPane.showMessageDialog(null, "Debe ingresar un número de identificación válido", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if ((Integer) spHoraInicio.getValue() < 0 || (Integer) spHoraInicio.getValue() > 23
                || (Integer) spHoraFin.getValue() < 0 || (Integer) spHoraFin.getValue() > 23) {

            JOptionPane.showMessageDialog(null, "Debe ingresar una hora válida", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (tfNombre.getText().length() > 80) {

            JOptionPane.showMessageDialog(null, "El nombre del empleado no debe exceder los 80 caracteres", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (tfApellidos.getText().length() > 80) {

            JOptionPane.showMessageDialog(null, "Los apellidos del empleado no deben exceder los 80 caracteres", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (tfDireccion.getText().length() > 100) {

            JOptionPane.showMessageDialog(null, "La dirección del empleado no debe exceder los 100 caracteres", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (tfPassword.getText().length() > 50) {

            JOptionPane.showMessageDialog(null, "La contraseña no debe exceder los 50 caracteres", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (tfTelefono.getText().length() != 7 && tfTelefono.getText().length() != 10) {

            JOptionPane.showMessageDialog(null, "Debe ingresar un número de teléfono válido", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (!validacion.esAlfanumerico(tfPassword.getText())) {

            JOptionPane.showMessageDialog(null, "Debe ingresar una contraseña alfanumérica", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            try {
                // Obteniendo los campos
                String tipoDocumento = (String) cbTipoID.getSelectedItem();
                String identificacion = tfIdentificacion.getText();
                String nombre = tfNombre.getText();
                String apellidos = tfApellidos.getText();
                String telefono = tfTelefono.getText();
                String direccion = tfDireccion.getText();
                String cargo = (String) cbCargo.getSelectedItem();

                LocalTime horaInicio = LocalTime.of((Integer) spHoraInicio.getValue(), 0);
                LocalTime horaFin = LocalTime.of((Integer) spHoraFin.getValue(), 0);

                /*Long codSucursal = (long) cbSucursales.getSelectedIndex();*/
                String nombre_sucursal = cbSucursales.getSelectedItem().toString();
                Long codSucursal = (Long) controladorSucursal.obtenerCodigoSucursal(nombre_sucursal).longValue();
                Sucursal sucursal = controladorSucursal.obtenerSucursal(codSucursal);

                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(ficheroImagen.toString()));
                } catch (IOException ex) {
                    Logger.getLogger(VentanaRegistrarModificarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
                String image_string = encodeImageToString(img);

                String password = tfPassword.getText();
                //Se procede a encriptar la contraseña
                String pass_encriptada = encriptador.encriptar(password);

                Empleado nuevoEmpleado = new Empleado(identificacion, tipoDocumento, nombre, apellidos, direccion, telefono, cargo, pass_encriptada, horaInicio, horaFin, image_string, sucursal);

                if (operacion.equalsIgnoreCase("Registro")) {

                    controladorEmpleado.crearEmpleado(nuevoEmpleado);
                    JOptionPane.showMessageDialog(null, "El empleado " + nuevoEmpleado.getNombre() + " fue registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();

                } else if (operacion.equalsIgnoreCase("Modificacion")) {

                    if (!nuevaImagen) {
                        nuevoEmpleado.setFotoURL(empleado.getFotoURL()); //Si la foto no cambió, se asigna la anterior
                    }

                    controladorEmpleado.editarEmpleado(nuevoEmpleado);
                    JOptionPane.showMessageDialog(null, "El empleado " + nuevoEmpleado.getNombre() + " fue modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarCampos();

                    VentanaGestionEmpleados ventanaEmpleados = (VentanaGestionEmpleados) ventanaAnterior;
                    ventanaEmpleados.empleadoActual = nuevoEmpleado;
                    ventanaEmpleados.llenarTablaEmpleados();
                    ventanaEmpleados.setVisible(true);
                    this.setVisible(false);

                }
            } catch (EntityExistsException e) {
                JOptionPane.showMessageDialog(null, "El usuario con ID " + tfIdentificacion.getText() + " ya se encuentra registado", "Warning", JOptionPane.WARNING_MESSAGE);
                limpiarCampos();
            } catch (javax.persistence.RollbackException e) {
                JOptionPane.showMessageDialog(null, "El usuario con ID " + tfIdentificacion.getText() + " ya se encuentra registado", "Warning", JOptionPane.WARNING_MESSAGE);
                limpiarCampos();
            }
        }

    }//GEN-LAST:event_bFinalizarActionPerformed

    private void bCambiarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCambiarFotoActionPerformed

        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg, *.png", "jpg", "png");
        file.setFileFilter(filtro);

        int seleccion = file.showOpenDialog(new JPanel());

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            //Seleccionamos el fichero
            ficheroImagen = file.getSelectedFile();

            int verificarJPG = ficheroImagen.getName().lastIndexOf(".jpg");
            int verificarPNG = ficheroImagen.getName().lastIndexOf(".png");

            if (verificarJPG == -1 && verificarPNG == -1) {
                JOptionPane.showMessageDialog(null, "Sólo se permiten imagenes con formato JPEG y PNG", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                ImageIcon icon = new ImageIcon(ficheroImagen.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lFoto.getWidth(), lFoto.getHeight(), Image.SCALE_DEFAULT));
                lFoto.setIcon(icono);
                nuevaImagen = true;
            }

        }

    }//GEN-LAST:event_bCambiarFotoActionPerformed

    private void tfIdentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfIdentificacionKeyTyped
        validacion.validarNumeros(evt);
    }//GEN-LAST:event_tfIdentificacionKeyTyped

    private void tfTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonoKeyTyped
        validacion.validarNumeros(evt);
    }//GEN-LAST:event_tfTelefonoKeyTyped

    private void spHoraInicioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spHoraInicioKeyTyped
        validacion.validarNumeros(evt);
    }//GEN-LAST:event_spHoraInicioKeyTyped

    private void spHoraFinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spHoraFinKeyTyped
        validacion.validarNumeros(evt);
    }//GEN-LAST:event_spHoraFinKeyTyped

    private void cbCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCargoActionPerformed
        // TODO add your handling code here:
        if (cbCargo.getSelectedIndex() == 1) {
            //Primero se limpia el cb
            cbSucursales.removeAllItems();
            cbSucursales.addItem("Seleccione una sucursal");
            
            //si elige gerente, solo se muestran las sucursales que no tienen gerente
            ArrayList<String> sucursales = controladorSucursal.obtenerSucursalesSinGerente();

            for (int i = 0; i < sucursales.size(); i++) {
                String categoria = sucursales.get(i);
                cbSucursales.addItem(categoria);
            }
        }
        else{
            //Se ponen todas las sucursales
            //Primero se limpia el cb
            cbSucursales.removeAllItems();
            cbSucursales.addItem("Seleccione la sucursal");
            ponerTodasLasSucursales();
        }
    }//GEN-LAST:event_cbCargoActionPerformed

    public void limpiarCampos() {

        cbTipoID.setSelectedIndex(0);
        tfIdentificacion.setText("");
        tfNombre.setText("");
        tfApellidos.setText("");
        tfTelefono.setText("");
        tfDireccion.setText("");
        //Se ponen todas las sucursales
        ponerTodasLasSucursales();
        cbCargo.setSelectedIndex(0);
        cbSucursales.setSelectedIndex(0);
        tfPassword.setText("");
        spHoraInicio.setValue(0);
        spHoraFin.setValue(0);

        defaultImage();

    }
    
    public void ponerTodasLasSucursales(){
        ArrayList<Sucursal> sucursales = controladorSucursal.obtenerTodasLasSucursales();

        for (int i = 0; i < sucursales.size(); i++) {
            String categoria = sucursales.get(i).getNombre();
            cbSucursales.addItem(categoria);
        }
    }

    public void defaultImage() {
        try {
            ficheroImagen = new File(getClass().getResource("/images/imageUser.jpg").toURI());
            ImageIcon icon = new ImageIcon(ficheroImagen.toString());
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lFoto.getWidth(), lFoto.getHeight(), Image.SCALE_DEFAULT));
            lFoto.setIcon(icono);

        } catch (URISyntaxException ex) {
            Logger.getLogger(VentanaRegistrarModificarItem.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String encodeImageToString(BufferedImage image) {

        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {

            ImageIO.write(image, "jpg", bos);
            byte[] imageBytes = bos.toByteArray();
            imageString = Base64.getEncoder().encodeToString(imageBytes);

            bos.close();

        } catch (IOException e) {

            System.out.println("No se pudo codificar la imagen");

        }
        return imageString;
    }

    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;

        try {

            imageByte = Base64.getDecoder().decode(imageString);
            ByteArrayInputStream bis;
            bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);

            bis.close();

        } catch (Exception e) {

            System.out.println("No se pudo decodificar la imagen");

        }
        return image;
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
            java.util.logging.Logger.getLogger(VentanaRegistrarModificarEmpleado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarModificarEmpleado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarModificarEmpleado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarModificarEmpleado.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VentanaRegistrarModificarEmpleado(null, null, null, null).setVisible(true);
                } catch (Exception ex) {
                    System.out.println("Se lanzó una Excepción");
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LTipoID;
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bCambiarFoto;
    private javax.swing.JButton bFinalizar;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JComboBox<String> cbCargo;
    private javax.swing.JComboBox<String> cbSucursales;
    private javax.swing.JComboBox<String> cbTipoID;
    private javax.swing.JLabel lApellidos;
    private javax.swing.JLabel lCargo;
    private javax.swing.JLabel lCargo1;
    private javax.swing.JLabel lFin;
    private javax.swing.JLabel lFoto;
    private javax.swing.JLabel lIdentificacion;
    private javax.swing.JLabel lInicio;
    private javax.swing.JLabel lLogo;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lPassword;
    private javax.swing.JLabel lSucursal;
    private javax.swing.JLabel lTelefono;
    private javax.swing.JLabel lTelefono1;
    private javax.swing.JLabel lTurno;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JSpinner spHoraFin;
    private javax.swing.JSpinner spHoraInicio;
    private javax.swing.JTextField tfApellidos;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfIdentificacion;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
