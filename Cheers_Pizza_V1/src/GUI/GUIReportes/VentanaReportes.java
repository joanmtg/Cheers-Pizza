/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.GUIReportes;

import Administracion.Empleado;
import Reportes.Reportes;
import javax.swing.*;

/**
 *
 * @author Joan
 */
public class VentanaReportes extends javax.swing.JFrame {

    JFrame ventanaAnterior;
    Empleado empleadoActual;
    Reportes reportes = new Reportes();
    
    public VentanaReportes(JFrame ventana, Empleado empleado) {
        super("Reportes");
        initComponents();
        
        ventanaAnterior = ventana;
        empleadoActual = empleado;         
        setLocationRelativeTo(null);
        
        if(empleado.getCargo().equals("Mesero")){
            bIngresosDiariosSemana.setEnabled(false);            
            bIngresosDiariosMes.setEnabled(false);               
        }
        else if(empleado.getCargo().equals("Cajero")){
            bTiempoAtencion.setEnabled(false);
            bMeserosDelMes.setEnabled(false);                        
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
        bMasVendidos = new javax.swing.JButton();
        bTiempoAtencion = new javax.swing.JButton();
        bMenosVendidos = new javax.swing.JButton();
        bIngresosDiariosMes = new javax.swing.JButton();
        bMeserosDelMes = new javax.swing.JButton();
        bIngresosDiariosSemana = new javax.swing.JButton();
        lGraficos = new javax.swing.JLabel();
        lTablas = new javax.swing.JLabel();
        lLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(89, 30, 27));

        panelInferior.setBackground(new java.awt.Color(89, 30, 27));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Seleccione un reporte", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Eras Medium ITC", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N

        bAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtras.png"))); // NOI18N
        bAtras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bAtrasPR.png"))); // NOI18N
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        bMasVendidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bTop10MasVendidos.png"))); // NOI18N
        bMasVendidos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bTop10MasVendidosPR.png"))); // NOI18N
        bMasVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMasVendidosActionPerformed(evt);
            }
        });

        bTiempoAtencion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bTiempoAtencion.png"))); // NOI18N
        bTiempoAtencion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bTiempoAtencionPR.png"))); // NOI18N
        bTiempoAtencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTiempoAtencionActionPerformed(evt);
            }
        });

        bMenosVendidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bTop10MenosVendidos.png"))); // NOI18N
        bMenosVendidos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bTop10MenosVendidosPR.png"))); // NOI18N
        bMenosVendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMenosVendidosActionPerformed(evt);
            }
        });

        bIngresosDiariosMes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bIngresosDiaMes.png"))); // NOI18N
        bIngresosDiariosMes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bIngresosDiaMesPR.png"))); // NOI18N
        bIngresosDiariosMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIngresosDiariosMesActionPerformed(evt);
            }
        });

        bMeserosDelMes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bMeserosDelMes.png"))); // NOI18N
        bMeserosDelMes.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bMeserosDelMesPR.png"))); // NOI18N
        bMeserosDelMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMeserosDelMesActionPerformed(evt);
            }
        });

        bIngresosDiariosSemana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bIngresosDiaSemana.png"))); // NOI18N
        bIngresosDiariosSemana.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bIngresosDiaSemanaPR.png"))); // NOI18N
        bIngresosDiariosSemana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIngresosDiariosSemanaActionPerformed(evt);
            }
        });

        lGraficos.setFont(new java.awt.Font("Eras Demi ITC", 0, 16)); // NOI18N
        lGraficos.setForeground(new java.awt.Color(255, 255, 255));
        lGraficos.setText("Gráficos:");

        lTablas.setFont(new java.awt.Font("Eras Demi ITC", 0, 16)); // NOI18N
        lTablas.setForeground(new java.awt.Color(255, 255, 255));
        lTablas.setText("Tablas:");

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lGraficos, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bTiempoAtencion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(bMasVendidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bMeserosDelMes, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bIngresosDiariosSemana, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(bMenosVendidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bIngresosDiariosMes, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lGraficos)
                .addGap(30, 30, 30)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMasVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bMenosVendidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bIngresosDiariosSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bTiempoAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(lTablas)
                .addGap(30, 30, 30)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMeserosDelMes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bIngresosDiariosMes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(35, 35, 35)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void bMasVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMasVendidosActionPerformed
        
        VentanaReporteMasVendidos vRepMasVendidos = new VentanaReporteMasVendidos(this, empleadoActual);
        vRepMasVendidos.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bMasVendidosActionPerformed

    private void bMenosVendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMenosVendidosActionPerformed
        
        reportes.reporteTopMenosVendidos(empleadoActual.getId(), empleadoActual.getNombre());
        
    }//GEN-LAST:event_bMenosVendidosActionPerformed

    private void bTiempoAtencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTiempoAtencionActionPerformed
        
        reportes.reporteTiempoPromedioAtencion(empleadoActual.getId(), empleadoActual.getNombre());
        
    }//GEN-LAST:event_bTiempoAtencionActionPerformed

    private void bIngresosDiariosSemanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIngresosDiariosSemanaActionPerformed
        
        VentanaReporteIngresosSemana vReporte = new VentanaReporteIngresosSemana(this, empleadoActual);
        vReporte.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bIngresosDiariosSemanaActionPerformed

    private void bMeserosDelMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMeserosDelMesActionPerformed
        
        // Reporte en construcción
        
    }//GEN-LAST:event_bMeserosDelMesActionPerformed

    private void bIngresosDiariosMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIngresosDiariosMesActionPerformed
        
        VentanaReporteIngresosMes vReporte = new VentanaReporteIngresosMes(this, empleadoActual);
        vReporte.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bIngresosDiariosMesActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Empleado empleado = new Empleado();
                empleado.setCargo("Gerente");
                new VentanaReportes(null, empleado).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bIngresosDiariosMes;
    private javax.swing.JButton bIngresosDiariosSemana;
    private javax.swing.JButton bMasVendidos;
    private javax.swing.JButton bMenosVendidos;
    private javax.swing.JButton bMeserosDelMes;
    private javax.swing.JButton bTiempoAtencion;
    private javax.swing.JLabel lGraficos;
    private javax.swing.JLabel lLogo;
    private javax.swing.JLabel lTablas;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
