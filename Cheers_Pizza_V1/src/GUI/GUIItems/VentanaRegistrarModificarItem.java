/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.GUIItems;

import AccesoDatosORM.AdaptadorCategoriaControlador;
import AccesoDatosORM.AdaptadorItemControlador;
import Administracion.Categoria;
import Administracion.Item;
import Validaciones.Validaciones;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Joan
 */
public class VentanaRegistrarModificarItem extends javax.swing.JFrame {

    Validaciones validacion = new Validaciones();
    AdaptadorCategoriaControlador controladorCategoria = new AdaptadorCategoriaControlador();
    AdaptadorItemControlador controladorItem = new AdaptadorItemControlador();
    
    Item itemAModificar = new Item();
    /**
     * Creates new form VentanaRegistrarItem
     */
    
    String operacion; //"Registro" o "Modificación"
    JFrame ventanaAnterior;

    public VentanaRegistrarModificarItem(JFrame anterior, String operacion) {
        super(operacion + " de Item");
        initComponents();

        this.operacion = operacion;
        this.ventanaAnterior = anterior;
        
        setLocationRelativeTo(null);
        
        ArrayList<Categoria> categorias = controladorCategoria.obtenerTodasCategorias();
        
        for(int i = 0; i < categorias.size(); i++){
            String categoria = categorias.get(i).getNombre();
            cbCategoria.addItem(categoria);
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
        lPrecio = new javax.swing.JLabel();
        tfPrecio = new javax.swing.JTextField();
        lCategoria = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescripcion = new javax.swing.JTextArea();
        lDescription = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<String>();
        lImagen = new javax.swing.JLabel();
        bFinalizar2 = new javax.swing.JButton();
        bFinalizar3 = new javax.swing.JButton();
        lLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelPrincipal.setBackground(new java.awt.Color(89, 30, 27));

        panelInferior.setBackground(new java.awt.Color(89, 30, 27));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ingrese los datos del Ítem", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Eras Medium ITC", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        panelInferior.setMaximumSize(new java.awt.Dimension(524, 448));
        panelInferior.setMinimumSize(new java.awt.Dimension(524, 448));
        panelInferior.setName(""); // NOI18N

        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtras.png"))); // NOI18N
        bAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtrasPR.png"))); // NOI18N
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        bFinalizar.setText("Finalizar");
        bFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFinalizarActionPerformed(evt);
            }
        });

        bLimpiar.setText("Limpiar");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });

        lNombre.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lNombre.setForeground(new java.awt.Color(255, 255, 255));
        lNombre.setText("Nombre:");

        lPrecio.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lPrecio.setForeground(new java.awt.Color(255, 255, 255));
        lPrecio.setText("Precio:");

        tfPrecio.setText("0");
        tfPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPrecioKeyTyped(evt);
            }
        });

        lCategoria.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lCategoria.setText("Categoría:");

        taDescripcion.setColumns(20);
        taDescripcion.setRows(5);
        taDescripcion.setMaximumSize(new java.awt.Dimension(164, 94));
        taDescripcion.setMinimumSize(new java.awt.Dimension(164, 94));
        jScrollPane1.setViewportView(taDescripcion);

        lDescription.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lDescription.setForeground(new java.awt.Color(255, 255, 255));
        lDescription.setText("Descripción:");

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una categoría" }));

        lImagen.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lImagen.setForeground(new java.awt.Color(255, 255, 255));
        lImagen.setText("Imagen:");

        bFinalizar2.setText("Ver Imagen");

        bFinalizar3.setText("Cambiar");

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lCategoria)
                            .addComponent(lImagen))
                        .addGap(18, 18, 18)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addComponent(bFinalizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bFinalizar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lPrecio)
                            .addComponent(lDescription)
                            .addComponent(lNombre))
                        .addGap(18, 18, 18)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(tfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bFinalizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bFinalizar3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed

        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea cancelar la operación actual?");

        if (opcion == JOptionPane.YES_OPTION) {
            
            this.dispose();
            VentanaGestionItems ventanaItems = (VentanaGestionItems)ventanaAnterior;
            ventanaItems.llenarTablaItems();
            ventanaItems.setVisible(true);
            
        }
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFinalizarActionPerformed

        // Obteniendo los campos
        String nombre = tfNombre.getText();
        double precio = Double.parseDouble(tfPrecio.getText());
        String descripcion = taDescripcion.getText();
        
        Long codCategoria = (long)cbCategoria.getSelectedIndex();
        Categoria categoria = controladorCategoria.obtenerCategoria(codCategoria);

        if (nombre.equals("") || precio == 0 || descripcion.equals("")) {
            
            JOptionPane.showMessageDialog(null, "Debe ingresar todos los campos solicitados", "Mensaje", JOptionPane.WARNING_MESSAGE);
            
        } else {
            
            Item nuevoItem = new Item(nombre, descripcion, precio, null, categoria);
            
            if(operacion.equalsIgnoreCase("Registro")){
                
                controladorItem.crearItem(nuevoItem);
                JOptionPane.showMessageDialog(null, "El item "+nuevoItem.getNombre()+" fue registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                
            }else if(operacion.equalsIgnoreCase("Modificacion")){
                
                nuevoItem.setCodigo(itemAModificar.getCodigo());
                controladorItem.editarItem(nuevoItem);
                JOptionPane.showMessageDialog(null, "El item "+nuevoItem.getNombre()+" fue modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                
                VentanaGestionItems ventanaItems = (VentanaGestionItems)ventanaAnterior;
                ventanaItems.llenarTablaItems();
                ventanaItems.setVisible(true);
                this.setVisible(false);
                        
            }
            
            
            
        }
        
    }//GEN-LAST:event_bFinalizarActionPerformed

    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_bLimpiarActionPerformed

    private void tfPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPrecioKeyTyped
        validacion.validarNumeros(evt);
    }//GEN-LAST:event_tfPrecioKeyTyped

    public void modificacionItem(Item item){
        
        itemAModificar = item;
        
        tfNombre.setText(itemAModificar.getNombre());
        tfPrecio.setText(""+itemAModificar.getPrecioActual());
        taDescripcion.setText(itemAModificar.getDescripcion());
        cbCategoria.setSelectedItem(itemAModificar.getCategoria().getNombre());
        
    }
    
    public void limpiarCampos(){
        
        tfNombre.setText("");
        tfPrecio.setText(""+0);
        taDescripcion.setText("");
        cbCategoria.setSelectedIndex(0);
        
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
            java.util.logging.Logger.getLogger(VentanaRegistrarModificarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarModificarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarModificarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarModificarItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistrarModificarItem(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bFinalizar;
    private javax.swing.JButton bFinalizar2;
    private javax.swing.JButton bFinalizar3;
    private javax.swing.JButton bLimpiar;
    public javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCategoria;
    private javax.swing.JLabel lDescription;
    private javax.swing.JLabel lImagen;
    private javax.swing.JLabel lLogo;
    private javax.swing.JLabel lNombre;
    private javax.swing.JLabel lPrecio;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    public javax.swing.JTextArea taDescripcion;
    public javax.swing.JTextField tfNombre;
    public javax.swing.JTextField tfPrecio;
    // End of variables declaration//GEN-END:variables
}
