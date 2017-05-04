/**
 * Proyecto Desarrollo de Software II
 * Fecha de entrega: 19/04/2017
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


import AccesoDatosORM.AdaptadorSucursalControlador;
import Administracion.*;
import Reportes.Reportes;
import java.awt.event.KeyEvent;
import javax.swing.*;
import Validaciones.Validaciones;
import AccesoDatosORM.SucursalJpaController;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fabio Andres
 */
public class VentanaLogin extends javax.swing.JFrame {

    Validaciones validaciones = new Validaciones();
    AdaptadorSucursalControlador controladorSucursal = new AdaptadorSucursalControlador();
    
    public VentanaLogin() {
        super("Bienvenido a Pizzeria Cheers");
        initComponents();
        
        /* PRUEBA SINGLETON */
        /* Para probar el patron singleton, cuando se ejecuta el programa se presenta una ventana
           de login, al presionar el botón ingresar, se genera un reporte y se abre la visualizacion
           del mismo. El singleton se puede evidenciar cuando teniendo abierta la visualizacion, se
           presiona de nuevo el boton ingresar y no se abre una nueva visualizacion del reporte. 
           Ademas, en la consola se imprime un mensaje que dice "Este reporte ya ha sido abierto"
        */
        
        /* PRUEBA FACTORY METHOD */
        System.out.println("Prueba de patron Factory Method");
        FabricaPedidos fabrica = new FabricaPedidos();
        // Se crea un nuevo pedido en mesa, utilizando la fabrica de pedidos
        Pedido nuevoPedido = fabrica.crearPedido("En mesa");
        nuevoPedido.setNumeroMesa(4);
        System.out.println("Se ha registrado un nuevo pedido en la mesa "+nuevoPedido.getNumeroMesa());
        
        /* PRUEBA OBSERVER */
        System.out.println("\nPrueba de patrón Observer");
        //Se crea un objeto de la mesaOcupada, del cual van a estar pendiente los meseros
        //Al principio, colocamos la mesaOcupada de manera general. Este objeto será el único que se cree de su clase
        //Y a medida que se ocupe alguna mesa, se llama a setMesaOcupada
        mesasOcupadas mesaOcupada = new mesasOcupadas(0, 0); 
        
        //Se crean dos meseros con el constructor de la clase Empleado. (El null es de la foto)
        Mesero mesero_uno = new Mesero("11440927462", "Cedula", "Vin" , "Diesel",  "Mesero" , "Lunes a Viernes", "Ciudad 2000", "___", "contraseña", "3775696", "315879461", null);
        
        Mesero mesero_dos = new Mesero("1144150569", "Cedula", "Paul" , "Walker",  "Mesero" , "Sábado y Domingo", "El Caney" , "___", "contraseña", "3854318", "310963215", null);
        
        //Se pone a que los meseros estés pendientes (Observen) una mesa que se va a ocupar
        mesero_uno.observarMesasOcupadas(mesaOcupada);
        mesero_dos.observarMesasOcupadas(mesaOcupada);
        
        //Se ocupa la mesa 7
        mesaOcupada.ocuparMesa(7);
        
        //Se ocupa la mesa 9
        mesaOcupada.ocuparMesa(9);
        
        //Se ocupa 17
        mesaOcupada.ocuparMesa(17);
        
        //Se desocupa la mesa 9
        mesaOcupada.desocuparMesa(9);
        
        
        /* PRUEBA ITERATOR */
        System.out.println("\nPrueba de patrón Iterator");
        
        
        //Se crea una lista de prueba para pasársela al construtor de ListaItems
        Item[] items = new Item[10];        
        
        //Se llena la lista con Items genéricos        
        for (int i = 0; i < 10; i++) {
            items[i] = new Item("Item " + i, "Desc " + i, "Categoría " + i, new ImageIcon(), 1000 + 1000 * i);            
        }
        
        //Se crea una instancia de la clase ListaItems, pasando como parámetro la lista creada        
        ListaItems lista = new ListaItems(items);
        
        Item item = null;
        
        //Se recorre la lista con un iterador y se imprimen los nombres de cada ´Ítem        
        for(Iterator iter = lista.getIterator(); iter.hasNext();){
            item = (Item)iter.next();               
            System.out.println(item.getNombre());
        } 
        
        /* PRUEBA ADAPTER */
        
        System.out.println("\nPrueba de patrón Adapter");
        
        Sucursal nuevaSucursal = new Sucursal(01L, "Cheers Cali", "Calle 20", "2945423");
        
        // Uso del patrón adaptador para llamar el método crear
        
        //Para realizar esta prueba, se debe crear una BD vacia llamada "cheers_bd" y
        //modificar el archivo persistence.xml ubicado en el paquete META-INF con el
        //usuario y contraseña del propietario. Luego, en la clase FachadaSucursal
        //descomentar la asignacion del atributo EntityManager y comentar la
        //declaracion. Por ultimo, descomentar la siguiente linea
        
        //controladorSucursal.crear(nuevaSucursal);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelInfoVentanaP = new javax.swing.JPanel();
        labelInfoUsuarioVentanaP = new javax.swing.JLabel();
        tfUsuarioVentanaP = new javax.swing.JTextField();
        labelInfoContraseñaVentanaP = new javax.swing.JLabel();
        separatorVentanaP = new javax.swing.JSeparator();
        tfContraseñaVentanaP = new javax.swing.JPasswordField();
        botonIngresarVentanaP = new javax.swing.JButton();
        labelInfoOlvidoPass = new javax.swing.JLabel();
        labelImagenVentanaP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(65, 105, 225));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 0, 51));

        panelInfoVentanaP.setBackground(new java.awt.Color(102, 0, 51));
        panelInfoVentanaP.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Acceso al sistema", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 14))); // NOI18N
        panelInfoVentanaP.setForeground(new java.awt.Color(255, 255, 255));
        panelInfoVentanaP.setToolTipText("");
        panelInfoVentanaP.setName(""); // NOI18N

        labelInfoUsuarioVentanaP.setBackground(new java.awt.Color(255, 255, 255));
        labelInfoUsuarioVentanaP.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        labelInfoUsuarioVentanaP.setForeground(new java.awt.Color(255, 255, 255));
        labelInfoUsuarioVentanaP.setText("USUARIO");

        tfUsuarioVentanaP.setToolTipText("");
        tfUsuarioVentanaP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tfUsuarioVentanaP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfUsuarioVentanaPKeyTyped(evt);
            }
        });

        labelInfoContraseñaVentanaP.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        labelInfoContraseñaVentanaP.setForeground(new java.awt.Color(255, 255, 255));
        labelInfoContraseñaVentanaP.setText("CONTRASEÑA");

        tfContraseñaVentanaP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfContraseñaVentanaPKeyTyped(evt);
            }
        });

        botonIngresarVentanaP.setText("Ingresar");
        botonIngresarVentanaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarVentanaPActionPerformed(evt);
            }
        });

        labelInfoOlvidoPass.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        labelInfoOlvidoPass.setForeground(new java.awt.Color(255, 255, 255));
        labelInfoOlvidoPass.setText("Los datos no coinciden. Intentelo nuevamente");

        javax.swing.GroupLayout panelInfoVentanaPLayout = new javax.swing.GroupLayout(panelInfoVentanaP);
        panelInfoVentanaP.setLayout(panelInfoVentanaPLayout);
        panelInfoVentanaPLayout.setHorizontalGroup(
            panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoVentanaPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(separatorVentanaP)
                .addContainerGap())
            .addGroup(panelInfoVentanaPLayout.createSequentialGroup()
                .addGroup(panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoVentanaPLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelInfoVentanaPLayout.createSequentialGroup()
                                .addComponent(labelInfoUsuarioVentanaP)
                                .addGap(37, 37, 37))
                            .addGroup(panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfUsuarioVentanaP, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfContraseñaVentanaP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelInfoVentanaPLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(labelInfoContraseñaVentanaP))
                    .addGroup(panelInfoVentanaPLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(botonIngresarVentanaP)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInfoVentanaPLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(labelInfoOlvidoPass)
                .addGap(62, 62, 62))
        );
        panelInfoVentanaPLayout.setVerticalGroup(
            panelInfoVentanaPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoVentanaPLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(labelInfoUsuarioVentanaP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfUsuarioVentanaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelInfoContraseñaVentanaP)
                .addGap(13, 13, 13)
                .addComponent(tfContraseñaVentanaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(botonIngresarVentanaP)
                .addGap(18, 18, 18)
                .addComponent(separatorVentanaP, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(labelInfoOlvidoPass)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        labelImagenVentanaP.setBackground(new java.awt.Color(204, 204, 204));
        labelImagenVentanaP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoVentanaP.png"))); // NOI18N
        labelImagenVentanaP.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInfoVentanaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(labelImagenVentanaP)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(labelImagenVentanaP, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelInfoVentanaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsuarioVentanaPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUsuarioVentanaPKeyTyped
        // Para que capture el ENTER
        char cTeclaPresionada = evt.getKeyChar();
        
        if(cTeclaPresionada == KeyEvent.VK_ENTER){
            botonIngresarVentanaP.doClick();
        }
        /*                
        validaciones.validarTamano(tfUsuarioVentanaP, evt, 10);
        validaciones.validarNumeros(evt);*/
        
    }//GEN-LAST:event_tfUsuarioVentanaPKeyTyped

    private void tfContraseñaVentanaPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfContraseñaVentanaPKeyTyped
        // Para que capture el ENTER
        char cTeclaPresionada = evt.getKeyChar();
        
        if(cTeclaPresionada == KeyEvent.VK_ENTER){
            botonIngresarVentanaP.doClick();
        }
    }//GEN-LAST:event_tfContraseñaVentanaPKeyTyped

    private void botonIngresarVentanaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarVentanaPActionPerformed
        // TODO add your handling code here:
        if(tfUsuarioVentanaP.getText().equals("") || tfContraseñaVentanaP.getText().equals("")){
            separatorVentanaP.setVisible(true);
            labelInfoOlvidoPass.setVisible(true);
        }
        
        Reportes prueba = new Reportes();
        prueba.reportePrueba();
    }//GEN-LAST:event_botonIngresarVentanaPActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                /*if ("Nimbus".equals(info.getName())) {
                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
                 break;
                 }*/
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaLogin objVentanaPrincipal = new VentanaLogin();
                objVentanaPrincipal.setVisible(true);
                objVentanaPrincipal.separatorVentanaP.setVisible(false);
                objVentanaPrincipal.labelInfoOlvidoPass.setVisible(false);
                
                
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIngresarVentanaP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelImagenVentanaP;
    private javax.swing.JLabel labelInfoContraseñaVentanaP;
    private javax.swing.JLabel labelInfoOlvidoPass;
    private javax.swing.JLabel labelInfoUsuarioVentanaP;
    private javax.swing.JPanel panelInfoVentanaP;
    public javax.swing.JSeparator separatorVentanaP;
    private javax.swing.JPasswordField tfContraseñaVentanaP;
    private javax.swing.JTextField tfUsuarioVentanaP;
    // End of variables declaration//GEN-END:variables
}
