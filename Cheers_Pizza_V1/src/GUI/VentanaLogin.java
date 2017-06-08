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
 * file: VentanaLogin.java
 * 
 */
package GUI;

import AccesoDatosORM.*;
import Administracion.Empleado;
import Validaciones.Encriptar;
import Validaciones.Validaciones;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Joan
 */
public class VentanaLogin extends javax.swing.JFrame {

    Validaciones validador = new Validaciones();
    Encriptar encriptador = new Encriptar();
    AdaptadorEmpleadoControlador adaptadorEmpleado = new AdaptadorEmpleadoControlador();

    /**
     * Creates new form GUILogin
     */
    public VentanaLogin() {
        super("Bienvenido a la Pizzería Cheers");
        initComponents();
        setLocationRelativeTo(null);

    }

    public void limpiarCampos() {
        setLocationRelativeTo(null);
        tfUser.setText("");
        tfPasswd.setText("");
        tfUser.requestFocus();
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
        tfUser = new javax.swing.JTextField();
        tfPasswd = new javax.swing.JPasswordField();
        lLogo = new javax.swing.JLabel();
        bLogin = new javax.swing.JButton();
        lInfoIngreso = new javax.swing.JLabel();
        lUser = new javax.swing.JLabel();
        lPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(89, 30, 27));

        tfUser.setFont(new java.awt.Font("Eras Medium ITC", 0, 16)); // NOI18N
        tfUser.setPreferredSize(new java.awt.Dimension(53, 30));
        tfUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfUserKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfUserKeyTyped(evt);
            }
        });

        tfPasswd.setFont(new java.awt.Font("Eras Medium ITC", 0, 16)); // NOI18N
        tfPasswd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPasswdKeyPressed(evt);
            }
        });

        lLogo.setBackground(new java.awt.Color(89, 30, 27));
        lLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        bLogin.setFont(new java.awt.Font("Eras Medium ITC", 0, 16)); // NOI18N
        bLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bLogin.png"))); // NOI18N
        bLogin.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bLoginPR.png"))); // NOI18N
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

        lInfoIngreso.setFont(new java.awt.Font("Eras Medium ITC", 0, 16)); // NOI18N
        lInfoIngreso.setForeground(new java.awt.Color(255, 255, 255));
        lInfoIngreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lInfoIngreso.setText("Por favor, ingrese sus datos para iniciar sesión");

        lUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N

        lPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lock.png"))); // NOI18N

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lInfoIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(lUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(lPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(tfPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(100, 100, 100))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lPass, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(bLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(lInfoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
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

    private void bLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoginActionPerformed

        String username = tfUser.getText();
        //String pass_desencriptada = tfPasswd.getText(); //COMENTAR ESTA LINEA UNA VEZ HAYAN CREADO UN EMPLEADO CON ESTA ACTUALIZACIÓN
        
           /*DESCOMENTAR PARA QUE FUNCIONE TRAYENDO LA CONTRASEÑA Y DESENCRIPTANDOLA*/
        //Se desencripta la contraseña primero
        
        String pass_desencriptada="__*__*_";
        try {
            pass_desencriptada = encriptador.encriptar(tfPasswd.getText());
        } catch (Exception ex) {
            System.out.println("Salió una excepción al momento de desencriptar contraseña en el acceso del Logini");
        }

        if (username.equals("") || pass_desencriptada.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese usuario y contraseña", "Advertencia", JOptionPane.WARNING_MESSAGE);
            tfUser.setText("");
            tfPasswd.setText("");
        } else {
            //Obtengo el empleado para comparar la contraseña
            Empleado empleadoAIngresar = adaptadorEmpleado.obtenerEmpleado(username);

            //Si el empleadoAIngresar == null, entonces no existe empleado con ese id
            if (empleadoAIngresar == null) {
                JOptionPane.showMessageDialog(null, "Username incorrecto", "Advertencia", JOptionPane.WARNING_MESSAGE);
                tfUser.setText("");
            } else {
                
                //
                System.out.println("Lo que escribi en el tfPass: "+tfPasswd.getText());
                System.out.println("pass Empleado: "+empleadoAIngresar.getPassword());
                try {
                    System.out.println("Pass desencriptada: "+ encriptador.desencriptar(empleadoAIngresar.getPassword()));
                } catch (Exception ex) {
                    Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //De lo contrario, el username(id) dado existe
                if (empleadoAIngresar.getPassword().equals(pass_desencriptada)) {
                    //En caso de que el username y la contraseña concuerde
                    //Se evalúa que tipo de Empleado acaba de ingresar a la base de datos
                    String cargo = empleadoAIngresar.getCargo();
                    System.out.println(cargo);
                    
                    switch(cargo){
                        case "Gerente":
                            VentanaGerente ventGerente = new VentanaGerente(this, empleadoAIngresar);
                            ventGerente.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "Mesero":
                            VentanaMesero ventMesero = new VentanaMesero(this, empleadoAIngresar);
                            ventMesero.setVisible(true);
                            this.setVisible(false);
                            break;
                        case "Cajero":
                            VentanaCajero ventCajero = new VentanaCajero(this, empleadoAIngresar);
                            ventCajero.setVisible(true);
                            this.setVisible(false);
                            break;
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    tfPasswd.setText("");
                }

            }

        }


    }//GEN-LAST:event_bLoginActionPerformed

    private void tfUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUserKeyTyped
        // Solo se permiten numeros (id en la BD 
        validador.validarNumeros(evt);
    }//GEN-LAST:event_tfUserKeyTyped

    private void tfUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUserKeyPressed
        // cuando presione la tecla ENTER, ocurra un evento dado
        char cTeclaPresionada = evt.getKeyChar();

        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            bLogin.doClick();
        }

    }//GEN-LAST:event_tfUserKeyPressed

    private void tfPasswdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPasswdKeyPressed
        // cuando presione la tecla ENTER, ocurra un evento dado
        char cTeclaPresionada = evt.getKeyChar();

        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            bLogin.doClick();
        }
    }//GEN-LAST:event_tfPasswdKeyPressed

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
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               VentanaLogin vLogin = new VentanaLogin();
               vLogin.setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bLogin;
    private javax.swing.JLabel lInfoIngreso;
    private javax.swing.JLabel lLogo;
    private javax.swing.JLabel lPass;
    private javax.swing.JLabel lUser;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPasswordField tfPasswd;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
