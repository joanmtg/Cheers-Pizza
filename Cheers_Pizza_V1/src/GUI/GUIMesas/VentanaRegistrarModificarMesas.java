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
 * file: VentanaRegistrarModificarMesas.java
 * 
 */
package GUI.GUIMesas;

import AccesoDatosORM.AdaptadorMesaControlador;
import Administracion.Mesa;
import javax.swing.*;
import Validaciones.Validaciones;

/**
 *
 * @author fabioacd
 */

public class VentanaRegistrarModificarMesas extends javax.swing.JFrame {

    /**
     * Creates new form VentanaRegistrarModificarRecursos
     */
    String operacion; //"Registro" o "Modificación"
    JFrame ventanaAnterior;

    Validaciones validador = new Validaciones();
    AdaptadorMesaControlador adaptadorMesa = new AdaptadorMesaControlador();
    Mesa mesa;

    public VentanaRegistrarModificarMesas(JFrame anterior, String operacion, Mesa mesa) {
        super(operacion + " de Mesa");
        initComponents();

        this.operacion = operacion;
        this.ventanaAnterior = anterior;
        this.mesa = mesa;

        setLocationRelativeTo(null);

        /*if (operacion.equals("Registro")) {
            lbNumero.setVisible(false);
            tfNumero.setVisible(false);
        }
        else{
            if(!lbNumero.isVisible() && !tfNumero.isVisible())
            lbNumero.setVisible(true);
            tfNumero.setVisible(true);
        }*/
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
        bFinalizar1 = new javax.swing.JButton();
        lbNumero = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        lCodigo2 = new javax.swing.JLabel();
        tfCapacidad = new javax.swing.JTextField();
        lLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(89, 30, 27));

        panelInferior.setBackground(new java.awt.Color(89, 30, 27));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ingrese los datos de la Mesa", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Eras Medium ITC", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N

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

        bFinalizar1.setText("Limpiar");

        lbNumero.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lbNumero.setForeground(new java.awt.Color(255, 255, 255));
        lbNumero.setText("Número:");

        tfNumero.setEditable(false);
        tfNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNumeroKeyTyped(evt);
            }
        });

        lCodigo2.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lCodigo2.setForeground(new java.awt.Color(255, 255, 255));
        lCodigo2.setText("Capacidad:");

        tfCapacidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCapacidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lCodigo2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbNumero, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(37, 37, 37)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(bFinalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(bFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                        .addComponent(tfCapacidad, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCodigo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(83, 83, 83)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bFinalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed

        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea cancelar la operación actual?");

        if (opcion == JOptionPane.YES_OPTION) {
            this.dispose();
            VentanaGestionMesas vGest = (VentanaGestionMesas) ventanaAnterior;
            vGest.llenarTablaMesas();
            vGest.setVisible(true);
        }
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFinalizarActionPerformed
        // TODO add your handling code here:
        int capacidad = Integer.parseInt(tfCapacidad.getText());

        //Campos vacíos
        if (tfCapacidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la capacidad de la mesa", "Mensaje", JOptionPane.WARNING_MESSAGE);
        } else {
            

            //Se verifica la operación
            if (operacion.equals("Registro")) {
                Mesa nuevaMesa = new Mesa(capacidad);
                adaptadorMesa.crearMesa(nuevaMesa);
                JOptionPane.showMessageDialog(null, "La mesa " + nuevaMesa.getNumero() + " con capacidad " + nuevaMesa.getCantidadPersonas()
                        + " fue registrada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                tfNumero.setText(""+ (nuevaMesa.getNumero() +1) );

            } else if (operacion.equals("Modificación")) {
                mesa.setCantidadPersonas(capacidad);
                adaptadorMesa.editarMesa(mesa);
                JOptionPane.showMessageDialog(null, "La mesa " + mesa.getNumero() + " fue modificada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();

                //Una vez se haya modificado, se muestra la ventana anterior
                VentanaGestionMesas ventanaMesas = (VentanaGestionMesas) ventanaAnterior;
                ventanaMesas.llenarTablaMesas();
                ventanaMesas.setVisible(true);
                this.setVisible(false);

            }

        }

    }//GEN-LAST:event_bFinalizarActionPerformed

    private void tfCapacidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCapacidadKeyTyped
        // TODO add your handling code here:
        validador.validarNumeros(evt);
    }//GEN-LAST:event_tfCapacidadKeyTyped

    private void tfNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumeroKeyTyped
        // TODO add your handling code here:
        validador.validarNumeros(evt);
    }//GEN-LAST:event_tfNumeroKeyTyped

    public void limpiarCampos() {
        tfCapacidad.setText("");
    }

    public void modificacionMesa(Mesa mesa) {

        tfNumero.setText("" + mesa.getNumero());
        tfCapacidad.setText("" + mesa.getCantidadPersonas());

    }
    
    //cuando se vaya a registrar una nueva mesa, se pone el numMesa nuevo que va a tener
    public void nuevoNumeroMesaRegistro(int num){
        tfNumero.setText(""+num);
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
            java.util.logging.Logger.getLogger(VentanaRegistrarModificarMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarModificarMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarModificarMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarModificarMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistrarModificarMesas(null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bFinalizar;
    private javax.swing.JButton bFinalizar1;
    private javax.swing.JLabel lCodigo2;
    private javax.swing.JLabel lLogo;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField tfCapacidad;
    private javax.swing.JTextField tfNumero;
    // End of variables declaration//GEN-END:variables
}
