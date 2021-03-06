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
 * file: VentanaAgregarItem.java
 * 
 */
package GUI.GUIPedidos;

import AccesoDatosORM.AdaptadorItemControlador;
import Administracion.Item;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joan
 */
public class VentanaAgregarItem extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAgregarItem
     */
    
    JFrame ventanaAnterior;
    AdaptadorItemControlador adaptadorItem = new AdaptadorItemControlador();
    
    public VentanaAgregarItem(JFrame anterior) {        
        super("Agregar Ítem a un Pedido");        
        initComponents();
        
        this.ventanaAnterior = anterior;
        setLocationRelativeTo(null);
        
        //Llenamos la tabla con los Items registrados en la BD
        llenarTablaItems();
                
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
        tablaAgregarItem = new javax.swing.JTable();
        bAgregarItem = new javax.swing.JButton();
        lFiltroCodigo = new javax.swing.JLabel();
        tfFiltroNombre = new javax.swing.JTextField();
        tfFiltroCodigo = new javax.swing.JTextField();
        lFiltroNombre = new javax.swing.JLabel();
        lLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(89, 30, 27));

        panelInferior.setBackground(new java.awt.Color(89, 30, 27));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Agregar Item", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Eras Medium ITC", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N

        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtras.png"))); // NOI18N
        bAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtrasPR.png"))); // NOI18N
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        tablaAgregarItem.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaAgregarItem);

        bAgregarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAgregarItem.png"))); // NOI18N
        bAgregarItem.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAgregarItemPR.png"))); // NOI18N
        bAgregarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarItemActionPerformed(evt);
            }
        });

        lFiltroCodigo.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lFiltroCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lFiltroCodigo.setText("Filtrar por:      Código:");

        lFiltroNombre.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lFiltroNombre.setForeground(new java.awt.Color(255, 255, 255));
        lFiltroNombre.setText("Nombre:");

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAgregarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addComponent(lFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(lFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAgregarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
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
                        .addGap(278, 278, 278)
                        .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
        
        this.dispose();
        ventanaAnterior.setVisible(true);
        
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bAgregarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarItemActionPerformed
        
        //Validar que se seleccione un elemento de la tabla
        int filasSeleccionadas = tablaAgregarItem.getSelectedRowCount();

        if (filasSeleccionadas == 1) {
            int filaSeleccionada = tablaAgregarItem.getSelectedRow();
            Long codigoItem = (Long) tablaAgregarItem.getValueAt(filaSeleccionada, 0);
            //Se obtiene el item
            Item itemSelected = adaptadorItem.obtenerItem(codigoItem);
            VentanaRegistrarModificarPedido vRegistro = (VentanaRegistrarModificarPedido)ventanaAnterior;
            
            //En caso de que ya se hubiera agregado el Item
            if(vRegistro.agregarItem(itemSelected)){
               JOptionPane.showMessageDialog(null, "El item " + itemSelected.getNombre() + " fue agregado al pedido", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "El item '"+ itemSelected.getNombre() + "' ya se agregó al pedido", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
        }  
        else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila del item a agregar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_bAgregarItemActionPerformed

    public void llenarTablaItems() {
        
        DefaultTableModel modelo = (DefaultTableModel) tablaAgregarItem.getModel();
        modelo.setRowCount(0);
        
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        
        ArrayList<Item> items = adaptadorItem.obtenerTodosItems();
        
        if (items != null) {
            
            for (int i = 0; i < items.size(); i++) {
                
                Object[] fila = new Object[4];
                
                fila[0] = items.get(i).getCodigo();
                fila[1] = items.get(i).getNombre();
                fila[2] = items.get(i).getPrecioActual();
                fila[3] = 0;
                
                modelo.addRow(fila);
            }
            
            tablaAgregarItem.setModel(modelo);
            
        } else {
            
            JOptionPane.showMessageDialog(null, "No hay items registrados", "Warning", JOptionPane.WARNING_MESSAGE);
            
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
            java.util.logging.Logger.getLogger(VentanaAgregarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgregarItem(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregarItem;
    private javax.swing.JButton bAtras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lFiltroCodigo;
    private javax.swing.JLabel lFiltroNombre;
    private javax.swing.JLabel lLogo;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tablaAgregarItem;
    private javax.swing.JTextField tfFiltroCodigo;
    private javax.swing.JTextField tfFiltroNombre;
    // End of variables declaration//GEN-END:variables
}
