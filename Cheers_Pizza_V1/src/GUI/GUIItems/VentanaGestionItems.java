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
 * file: VentanaGestionItems.java
 * 
 */
package GUI.GUIItems;

import AccesoDatosORM.AdaptadorItemControlador;
import Administracion.Item;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Joan
 */
public class VentanaGestionItems extends javax.swing.JFrame {

    /**
     * Creates new form VentanaGestionItems
     */
    JFrame ventanaAnterior;
    AdaptadorItemControlador controladorItem = new AdaptadorItemControlador();
    TableRowSorter trsFiltro;

    public VentanaGestionItems(JFrame anterior) {
        super("Gestión de Items");
        initComponents();

        ventanaAnterior = anterior;
        setLocationRelativeTo(null);

        llenarTablaItems();

        trsFiltro = new TableRowSorter(tablaItems.getModel());
        tablaItems.setRowSorter(trsFiltro);

    }

    public void llenarTablaItems() {

        DefaultTableModel modelo = (DefaultTableModel) tablaItems.getModel();
        modelo.setRowCount(0);

        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }

        ArrayList<Item> items = controladorItem.obtenerTodosItems();

        if (items != null) {

            for (int i = 0; i < items.size(); i++) {

                Object[] fila = new Object[3];

                fila[0] = items.get(i).getCodigo();
                fila[1] = items.get(i).getNombre();
                fila[2] = items.get(i).getPrecioActual();

                modelo.addRow(fila);
            }

            tablaItems.setModel(modelo);

        } else {

            JOptionPane.showMessageDialog(null, "No hay items registrados", "Warning", JOptionPane.WARNING_MESSAGE);

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
        tablaItems = new javax.swing.JTable();
        bRegistrar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        bVerItem = new javax.swing.JButton();
        lFiltroCodigo = new javax.swing.JLabel();
        tfFiltroNombre = new javax.swing.JTextField();
        tfFiltroCodigo = new javax.swing.JTextField();
        lFiltroCodigo1 = new javax.swing.JLabel();
        lLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(89, 30, 27));

        panelInferior.setBackground(new java.awt.Color(89, 30, 27));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Gestión de Ítems", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Eras Medium ITC", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N

        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtras.png"))); // NOI18N
        bAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtrasPR.png"))); // NOI18N
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        tablaItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaItems);

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

        bVerItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bVerItem.png"))); // NOI18N
        bVerItem.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bVerItemPR.png"))); // NOI18N
        bVerItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerItemActionPerformed(evt);
            }
        });

        lFiltroCodigo.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lFiltroCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lFiltroCodigo.setText("Filtrar por:      Código:");

        tfFiltroNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltroNombreKeyReleased(evt);
            }
        });

        tfFiltroCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltroCodigoKeyReleased(evt);
            }
        });

        lFiltroCodigo1.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lFiltroCodigo1.setForeground(new java.awt.Color(255, 255, 255));
        lFiltroCodigo1.setText("Nombre:");

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bVerItem, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(bRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(lFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(lFiltroCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(30, 30, 30))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lFiltroCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bVerItem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30))
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
                        .addGap(301, 301, 301)
                        .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed

        this.dispose();
        ventanaAnterior.setVisible(true);

    }//GEN-LAST:event_bAtrasActionPerformed

    private void bRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarActionPerformed

        Item item = new Item();
        
        VentanaRegistrarModificarItem ventanaRegistro = new VentanaRegistrarModificarItem(this, "Registro", item);
        ventanaRegistro.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_bRegistrarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed

        //Validar que se seleccione un elemento de la tabla
        int filasSeleccionadas = tablaItems.getSelectedRowCount();

        if (filasSeleccionadas == 1) {

            int filaSeleccionada = tablaItems.getSelectedRow();

            DefaultTableModel modelo = (DefaultTableModel) tablaItems.getModel();

            filaSeleccionada = tablaItems.getRowSorter().convertRowIndexToModel(filaSeleccionada);

            Long codigoItem = (Long) modelo.getValueAt(filaSeleccionada, 0);

            Item itemSeleccionado = controladorItem.obtenerItem(codigoItem);

            VentanaRegistrarModificarItem ventanaRegistro = new VentanaRegistrarModificarItem(this, "Modificacion", itemSeleccionado);
            ventanaRegistro.setVisible(true);
            this.setVisible(false);

        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila del item a modificar", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_bModificarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed

        //Validar que se seleccione un elemento de la tabla
        int filasSeleccionadas = tablaItems.getSelectedRowCount();

        if (filasSeleccionadas == 1) {

            int filaSeleccionada = tablaItems.getSelectedRow();

            DefaultTableModel modelo = (DefaultTableModel) tablaItems.getModel();

            filaSeleccionada = tablaItems.getRowSorter().convertRowIndexToModel(filaSeleccionada);

            Long codigoItem = (Long) modelo.getValueAt(filaSeleccionada, 0);
            Item itemAEliminar = controladorItem.obtenerItem(codigoItem);

            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el ítem " + itemAEliminar.getNombre() + " con código " + itemAEliminar.getCodigo() + "?");

            if (opcion == JOptionPane.YES_OPTION) {

                //Eliminar item 
                controladorItem.eliminarItem(itemAEliminar);

                //Actualizar tabla
                JOptionPane.showMessageDialog(null, "Se ha eliminado el ítem " + itemAEliminar.getNombre() + " con codigo " + itemAEliminar.getCodigo(), "Eliminación realizada", JOptionPane.INFORMATION_MESSAGE);

                llenarTablaItems();

            }

        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila del item que desea eliminar", "Warning", JOptionPane.WARNING_MESSAGE);

        }


    }//GEN-LAST:event_bEliminarActionPerformed

    private void bVerItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVerItemActionPerformed

        //Validar que se seleccione un elemento de la tabla
        int filasSeleccionadas = tablaItems.getSelectedRowCount();

        if (filasSeleccionadas == 1) {

            int filaSeleccionada = tablaItems.getSelectedRow();

            DefaultTableModel modelo = (DefaultTableModel) tablaItems.getModel();

            filaSeleccionada = tablaItems.getRowSorter().convertRowIndexToModel(filaSeleccionada);

            Long codigoItem = (Long) modelo.getValueAt(filaSeleccionada, 0);
            Item itemAVisualizar = controladorItem.obtenerItem(codigoItem);

            VentanaRegistrarModificarItem ventanaRegistro = new VentanaRegistrarModificarItem(this, "Visualizacion", itemAVisualizar);
            ventanaRegistro.setVisible(true);
            this.setVisible(false);

        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila del item que desea visualizar", "Warning", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_bVerItemActionPerformed

    private void tfFiltroCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroCodigoKeyReleased

        int columna = 0;

        trsFiltro.setRowFilter(RowFilter.regexFilter(tfFiltroCodigo.getText(), columna));

    }//GEN-LAST:event_tfFiltroCodigoKeyReleased

    private void tfFiltroNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroNombreKeyReleased

        int columna = 1;

        trsFiltro.setRowFilter(RowFilter.regexFilter(tfFiltroNombre.getText(), columna));

    }//GEN-LAST:event_tfFiltroNombreKeyReleased

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
            java.util.logging.Logger.getLogger(VentanaGestionItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGestionItems(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bRegistrar;
    private javax.swing.JButton bVerItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lFiltroCodigo;
    private javax.swing.JLabel lFiltroCodigo1;
    private javax.swing.JLabel lLogo;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tablaItems;
    private javax.swing.JTextField tfFiltroCodigo;
    private javax.swing.JTextField tfFiltroNombre;
    // End of variables declaration//GEN-END:variables
}
