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
 * file: VentanaGestionEmpleados.java
 * 
 */
package GUI.GUIUsuarios;

import AccesoDatosORM.AdaptadorEmpleadoControlador;
import Administracion.Empleado;
import Administracion.Item;
import static GUI.GUIItems.VentanaRegistrarModificarItem.decodeToImage;
import GUI.VentanaGerente;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author invitado
 */
public class VentanaGestionEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form VentanaGestionUsuarios
     */
    AdaptadorEmpleadoControlador controladorEmpleados = new AdaptadorEmpleadoControlador();
    
    JFrame ventanaAnterior;
    TableRowSorter trsFiltro;
    Empleado empleadoActual;
    
    public VentanaGestionEmpleados(JFrame anterior, Empleado empleadoActual) {
        super("Gestión de Usuarios");
        initComponents();
        
        this.ventanaAnterior = anterior;
        this.setLocationRelativeTo(null);
        this.empleadoActual = empleadoActual;
        
        
        llenarTablaEmpleados();
        
        
        trsFiltro = new TableRowSorter(tablaEmpleados.getModel());
        tablaEmpleados.setRowSorter(trsFiltro);
        
    }

    
    public void llenarTablaEmpleados() {
        
        DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
        modelo.setRowCount(0);
        
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        
        ArrayList<Empleado> empleados = controladorEmpleados.obtenerTodosEmpleados();
        
        if (empleados != null) {
            
            for (int i = 0; i < empleados.size(); i++) {
                
                Object[] fila = new Object[7];
                
                fila[0] = empleados.get(i).getId();
                fila[1] = empleados.get(i).getNombre();
                fila[2] = empleados.get(i).getApellidos();
                fila[3] = empleados.get(i).getTelefono();
                fila[4] = empleados.get(i).getDireccion();
                fila[5] = empleados.get(i).getCargo();
                fila[6] = empleados.get(i).getSucursal().getNombre();
                
                modelo.addRow(fila);
            }
            
            tablaEmpleados.setModel(modelo);
            
        } else {
            
            JOptionPane.showMessageDialog(null, "No hay empleados registrados", "Warning", JOptionPane.WARNING_MESSAGE);
            
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        bRegistrar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        lFiltroCodigo = new javax.swing.JLabel();
        tfFiltro = new javax.swing.JTextField();
        cbColumnaFiltro = new javax.swing.JComboBox<>();
        bVerFoto = new javax.swing.JButton();
        lLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(89, 30, 27));

        panelInferior.setBackground(new java.awt.Color(89, 30, 27));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Gestión de Usuarios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Eras Medium ITC", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N

        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtras.png"))); // NOI18N
        bAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtrasPR.png"))); // NOI18N
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellidos", "Teléfono", "Dirección", "Cargo", "Sucursal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaEmpleados);

        bRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bRegistrar.png"))); // NOI18N
        bRegistrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bRegistrarPR.png"))); // NOI18N
        bRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarActionPerformed(evt);
            }
        });

        bModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bModificar.png"))); // NOI18N
        bModificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bModificarPR.png"))); // NOI18N
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        bEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bEliminar.png"))); // NOI18N
        bEliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bEliminarPR.png"))); // NOI18N
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        lFiltroCodigo.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lFiltroCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lFiltroCodigo.setText("Filtrar por:");

        tfFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltroKeyReleased(evt);
            }
        });

        cbColumnaFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Nombre", "Apellidos", "Cargo", "Sucursal" }));

        bVerFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bInformacion.png"))); // NOI18N
        bVerFoto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bInformacionPR.png"))); // NOI18N
        bVerFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(lFiltroCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbColumnaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bVerFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(bRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE))
                        .addGap(25, 25, 25))))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbColumnaFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bVerFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addGap(35, 35, 35)
                        .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed

        this.dispose();
        VentanaGerente vGerente = (VentanaGerente) ventanaAnterior;
        vGerente.empleadoIngresado = empleadoActual;
        vGerente.colocarInfoEmpleado();
        vGerente.setVisible(true);
        
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarActionPerformed
         
        try {
            Empleado empleado = new Empleado();
            
            VentanaRegistrarModificarEmpleado vRegistro = new VentanaRegistrarModificarEmpleado(this, "Registro", empleado, empleadoActual);
            vRegistro.setVisible(true);
            this.setVisible(false); 
        } catch (Exception ex) {
            Logger.getLogger(VentanaGestionEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bRegistrarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed

        //Validar que se seleccione un elemento de la tabla
        int filasSeleccionadas = tablaEmpleados.getSelectedRowCount();
        
        if (filasSeleccionadas == 1) {
            
            try {
                int filaSeleccionada = tablaEmpleados.getSelectedRow();
                
                DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
                
                filaSeleccionada = tablaEmpleados.getRowSorter().convertRowIndexToModel(filaSeleccionada);
                
                String idEmpleado = (String) modelo.getValueAt(filaSeleccionada, 0);
                
                Empleado empleadoSeleccionado = controladorEmpleados.obtenerEmpleado(idEmpleado);
                
                VentanaRegistrarModificarEmpleado ventanaRegistro = new VentanaRegistrarModificarEmpleado(this, "Modificacion", empleadoSeleccionado, empleadoActual);
                ventanaRegistro.setVisible(true);
                this.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(VentanaGestionEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila del empleado a modificar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
        }

        
    }//GEN-LAST:event_bModificarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed

        //Validar que se seleccione un elemento de la tabla
        int filasSeleccionadas = tablaEmpleados.getSelectedRowCount();
        
        if (filasSeleccionadas == 1) {
            
            int filaSeleccionada = tablaEmpleados.getSelectedRow();
            
            DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
            
            filaSeleccionada = tablaEmpleados.getRowSorter().convertRowIndexToModel(filaSeleccionada);
            
            String idEmpleado = (String) modelo.getValueAt(filaSeleccionada, 0);
            Empleado empleadoAEliminar = controladorEmpleados.obtenerEmpleado(idEmpleado);
            
            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el empleado " + empleadoAEliminar.getNombre() + " con identificación " + empleadoAEliminar.getId() + "?");
            
            if (opcion == JOptionPane.YES_OPTION) {

                //Eliminar Empleado
                controladorEmpleados.eliminarEmpleado(empleadoAEliminar);

                //Actualizar tabla
                JOptionPane.showMessageDialog(null, "Se ha eliminado el empleado " + empleadoAEliminar.getNombre() + " con identificacion " + empleadoAEliminar.getId(), "Eliminación realizada", JOptionPane.INFORMATION_MESSAGE);
                
                llenarTablaEmpleados();
                
            }
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila del empleado que desea eliminar", "Warning", JOptionPane.WARNING_MESSAGE);
            
        }
        
    }//GEN-LAST:event_bEliminarActionPerformed

    private void bVerFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerFotoActionPerformed
        
        //Validar que se seleccione un elemento de la tabla
        int filasSeleccionadas = tablaEmpleados.getSelectedRowCount();

        if (filasSeleccionadas == 1) {

            try {
                int filaSeleccionada = tablaEmpleados.getSelectedRow();
                
                DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
                
                filaSeleccionada = tablaEmpleados.getRowSorter().convertRowIndexToModel(filaSeleccionada);
                
                String idUsuario = (String) modelo.getValueAt(filaSeleccionada, 0);
                
                
                Empleado usuarioAVisualizar = controladorEmpleados.obtenerEmpleado(idUsuario);
                           
                
                VentanaRegistrarModificarEmpleado ventanaRegistro = new VentanaRegistrarModificarEmpleado(this, "Visualizacion", usuarioAVisualizar, empleadoActual);
                ventanaRegistro.setVisible(true);
                this.setVisible(false);
            } catch (Exception ex) {
                Logger.getLogger(VentanaGestionEmpleados.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila del empleado que desea visualizar", "Warning", JOptionPane.WARNING_MESSAGE);

        }
        
    }//GEN-LAST:event_bVerFotoActionPerformed

    private void tfFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroKeyReleased
        
        String filtro = (String) cbColumnaFiltro.getSelectedItem();
        int columna = 0;
        
        switch (filtro) {
            
            case "Código":
                columna = 0;
                break;
            case "Nombre":
                columna = 1;
                break;
            case "Apellidos":
                columna = 2;
                break;
            case "Cargo":
                columna = 5;
                break;
            case "Sucursal":
                columna = 6;
                break;
            
        }
        
        trsFiltro.setRowFilter(RowFilter.regexFilter(tfFiltro.getText(), columna)); 
        
    }//GEN-LAST:event_tfFiltroKeyReleased

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
            java.util.logging.Logger.getLogger(VentanaGestionEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGestionEmpleados(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bRegistrar;
    private javax.swing.JButton bVerFoto;
    private javax.swing.JComboBox<String> cbColumnaFiltro;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lFiltroCodigo;
    private javax.swing.JLabel lLogo;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tablaEmpleados;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
