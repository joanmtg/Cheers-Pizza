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
 * file: VentanaGestionPedidos.java
 * 
 */
package GUI.GUIPedidos;

import Administracion.*;
import AccesoDatosORM.*;
import Administracion.Mesa;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Joan
 */
public class VentanaGestionPedidos extends javax.swing.JFrame {

    /**
     * Creates new form VentanaGestionPedidos
     */
    JFrame ventanaAnterior;
    AdaptadorPedidoControlador adaptadorPedido = new AdaptadorPedidoControlador();
    AdaptadorPedidoItemControlador adaptadorPedidoItem = new AdaptadorPedidoItemControlador();
    TableRowSorter trsFiltro = new TableRowSorter();

    public VentanaGestionPedidos(JFrame anterior) {
        super("Gestión de Pedidos");
        initComponents();

        this.ventanaAnterior = anterior;
        setLocationRelativeTo(null);

        llenarTablaPedidos();
        
        trsFiltro = new TableRowSorter(tablaPedidos.getModel());
        tablaPedidos.setRowSorter(trsFiltro);
    }
    
    public String extraerHoraDateTime(LocalDateTime dateTime){
        
        if(dateTime != null){            
            return dateTime.format(DateTimeFormatter.ofPattern("H:m:s"));            
        }
        else {
            return null;
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
        tablaPedidos = new javax.swing.JTable();
        bRegistrar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        lFiltroCodigo = new javax.swing.JLabel();
        tfFiltroCodigo = new javax.swing.JTextField();
        lFiltroCodigo1 = new javax.swing.JLabel();
        lFiltroCodigo2 = new javax.swing.JLabel();
        tfFiltroIDCliente = new javax.swing.JTextField();
        bEliminar = new javax.swing.JButton();
        bInformacion = new javax.swing.JButton();
        lLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(89, 30, 27));

        panelInferior.setBackground(new java.awt.Color(89, 30, 27));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Gestión de Pedidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Eras Medium ITC", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N

        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtras.png"))); // NOI18N
        bAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtrasPR.png"))); // NOI18N
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Tipo", "Hora Inicio", "Hora Entrega", "Mesa", "ID Cliente", "ID Mesero", "Sucursal", "Entregado", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPedidos);

        bRegistrar.setText("Registrar");
        bRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarActionPerformed(evt);
            }
        });

        bModificar.setText("Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        lFiltroCodigo.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lFiltroCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lFiltroCodigo.setText("Filtrar por:");

        tfFiltroCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltroCodigoKeyReleased(evt);
            }
        });

        lFiltroCodigo1.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lFiltroCodigo1.setForeground(new java.awt.Color(255, 255, 255));
        lFiltroCodigo1.setText("Código:");

        lFiltroCodigo2.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lFiltroCodigo2.setForeground(new java.awt.Color(255, 255, 255));
        lFiltroCodigo2.setText("ID Cliente:");

        tfFiltroIDCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltroIDClienteKeyReleased(evt);
            }
        });

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        bInformacion.setText("Información");
        bInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInformacionActionPerformed(evt);
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
                        .addGap(18, 18, 18)
                        .addComponent(lFiltroCodigo1)
                        .addGap(18, 18, 18)
                        .addComponent(tfFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(lFiltroCodigo2)
                        .addGap(18, 18, 18)
                        .addComponent(tfFiltroIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bInformacion)
                                .addGap(18, 18, 18)
                                .addComponent(bRegistrar)
                                .addGap(18, 18, 18)
                                .addComponent(bModificar)
                                .addGap(21, 21, 21)
                                .addComponent(bEliminar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE))
                        .addGap(25, 25, 25))))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfFiltroIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lFiltroCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfFiltroCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lFiltroCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bAtras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bRegistrar)
                        .addComponent(bInformacion)))
                .addGap(21, 21, 21))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        ventanaAnterior.setVisible(true);

    }//GEN-LAST:event_bAtrasActionPerformed

    private void bRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarActionPerformed

        Pedido pedido = new Pedido();

        VentanaRegistrarModificarPedido vRegistroPedido = new VentanaRegistrarModificarPedido(this, "Registro", pedido);
        vRegistroPedido.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_bRegistrarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed

        int filaSeleccionada = tablaPedidos.getSelectedRow();

        if (filaSeleccionada != -1) {

            Long numPedido = Long.parseLong(tablaPedidos.getValueAt(filaSeleccionada, 0).toString());

            Pedido pedidoAModificar = adaptadorPedido.obtenerPedido(numPedido);

            VentanaRegistrarModificarPedido vModificacionPedido = new VentanaRegistrarModificarPedido(this, "Modificación", pedidoAModificar);
            vModificacionPedido.setVisible(true);
            double total = pedidoAModificar.getTotal();
            vModificacionPedido.lbValorTotal.setText("$ " + total);
            this.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un pedido a modificar", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_bModificarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        
        //Validar que se seleccione un elemento de la tabla
        int filasSeleccionadas = tablaPedidos.getSelectedRowCount();

        if (filasSeleccionadas == 1) {

            int filaSeleccionada = tablaPedidos.getSelectedRow();

            DefaultTableModel modelo = (DefaultTableModel) tablaPedidos.getModel();

            filaSeleccionada = tablaPedidos.getRowSorter().convertRowIndexToModel(filaSeleccionada);

            Long numeroPedido = (Long) modelo.getValueAt(filaSeleccionada, 0);
            Pedido pedidoAEliminar = adaptadorPedido.obtenerPedido(numeroPedido);

            int opcion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el pedido con código " + pedidoAEliminar.getNumero()+ "?");

            if (opcion == JOptionPane.YES_OPTION) {

                //Eliminar item 
                adaptadorPedido.eliminarPedido(pedidoAEliminar);

                //Actualizar tabla
                JOptionPane.showMessageDialog(null, "Se ha eliminado el ítem con codigo " + pedidoAEliminar.getNumero(), "Eliminación realizada", JOptionPane.INFORMATION_MESSAGE);

                llenarTablaPedidos();

            }

        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila del item que desea eliminar", "Warning", JOptionPane.WARNING_MESSAGE);

        }
        
    }//GEN-LAST:event_bEliminarActionPerformed

    private void tfFiltroCodigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroCodigoKeyReleased
        
        int columna = 0;

        trsFiltro.setRowFilter(RowFilter.regexFilter(tfFiltroCodigo.getText(), columna));
        
    }//GEN-LAST:event_tfFiltroCodigoKeyReleased

    private void tfFiltroIDClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroIDClienteKeyReleased
        
        int columna = 5;

        trsFiltro.setRowFilter(RowFilter.regexFilter(tfFiltroIDCliente.getText(), columna));
        
    }//GEN-LAST:event_tfFiltroIDClienteKeyReleased

    private void bInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInformacionActionPerformed
       
        //Validar que se seleccione un elemento de la tabla
        int filasSeleccionadas = tablaPedidos.getSelectedRowCount();

        if (filasSeleccionadas == 1) {

            int filaSeleccionada = tablaPedidos.getSelectedRow();

            DefaultTableModel modelo = (DefaultTableModel) tablaPedidos.getModel();

            filaSeleccionada = tablaPedidos.getRowSorter().convertRowIndexToModel(filaSeleccionada);

            Long numeroPedido = (Long) modelo.getValueAt(filaSeleccionada, 0);
            Pedido pedidoAVisualizar = adaptadorPedido.obtenerPedido(numeroPedido);

            VentanaRegistrarModificarPedido ventanaPedidos = new VentanaRegistrarModificarPedido(this, "Visualizacion", pedidoAVisualizar);
            ventanaPedidos.setVisible(true);
            this.setVisible(false);
            

        } else {

            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila del item que desea eliminar", "Warning", JOptionPane.WARNING_MESSAGE);

        }
        
    }//GEN-LAST:event_bInformacionActionPerformed

    //Llena la tabla con los pedidos realizados
    public void llenarTablaPedidos() {
        DefaultTableModel modelo = (DefaultTableModel) tablaPedidos.getModel();
        modelo.setRowCount(0);

        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }

        ArrayList<Pedido> pedidos = adaptadorPedido.obtenerTodosPedidos();

        if (pedidos != null) {

            for (int i = 0; i < pedidos.size(); i++) {

                Object[] fila = new Object[11];

                fila[0] = pedidos.get(i).getNumero();
                fila[1] = pedidos.get(i).getTipoPedido();
                fila[2] = extraerHoraDateTime(pedidos.get(i).getHoraInicio());
                fila[3] = extraerHoraDateTime(pedidos.get(i).getHoraEntrega());
                Mesa mesa = pedidos.get(i).getMesa();
                if (mesa == null) {
                    fila[4] = null;
                } else {
                    fila[4] = mesa.getNumero();
                }

                Cliente cliente = pedidos.get(i).getCliente();
                if (cliente == null) {
                    fila[5] = null;
                } else {
                    fila[5] = cliente.getId();
                }

                Empleado mesero = pedidos.get(i).getMesero();
                if (mesero == null) {
                    fila[6] = null;
                } else {
                    fila[6] = mesero.getId();
                }

                Sucursal sucursal = pedidos.get(i).getSucursalPedido();
                if (sucursal == null) {
                    fila[7] = null;
                } else {
                    fila[7] = sucursal.getCodigo();
                }

                String infoEntregado = "";
                if (pedidos.get(i).isEntregado()) {infoEntregado = "Sí";} else {infoEntregado = "No";}
                fila[8] = infoEntregado;
                fila[9] = pedidos.get(i).getTotal();

                modelo.addRow(fila);
            }

            tablaPedidos.setModel(modelo);

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
            java.util.logging.Logger.getLogger(VentanaGestionPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaGestionPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaGestionPedidos(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bInformacion;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bRegistrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lFiltroCodigo;
    private javax.swing.JLabel lFiltroCodigo1;
    private javax.swing.JLabel lFiltroCodigo2;
    private javax.swing.JLabel lLogo;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTextField tfFiltroCodigo;
    private javax.swing.JTextField tfFiltroIDCliente;
    // End of variables declaration//GEN-END:variables
}
