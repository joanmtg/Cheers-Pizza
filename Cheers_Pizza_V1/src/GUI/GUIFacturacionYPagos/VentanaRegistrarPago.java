/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.GUIFacturacionYPagos;

import AccesoDatosORM.AdaptadorEmpleadoControlador;
import AccesoDatosORM.AdaptadorFacturaControlador;
import AccesoDatosORM.AdaptadorFacturaFormaPagoControlador;
import AccesoDatosORM.AdaptadorItemFacturaControlador;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.time.LocalTime;
import Administracion.Pedido;
import Administracion.Pedido_Item;
import Administracion.Item;
import AccesoDatosORM.AdaptadorPedidoItemControlador;
import Administracion.Empleado;
import Administracion.Factura;
import Administracion.Factura_FormaPago;
import Administracion.ItemFactura;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author invitado
 */
public class VentanaRegistrarPago extends javax.swing.JFrame {

    /**
     * Creates new form VentanaRegistrarPago
     */
    JFrame ventanaAnterior;
    Pedido pedido = new Pedido();
    String codigoEmpleado;
    List<ItemFactura> itemsFactura = new ArrayList<>();
    AdaptadorPedidoItemControlador controladorPedidoItem = new AdaptadorPedidoItemControlador();
    AdaptadorEmpleadoControlador controladorEmpleado = new AdaptadorEmpleadoControlador();
    AdaptadorFacturaControlador controladorFactura = new AdaptadorFacturaControlador();
    AdaptadorFacturaFormaPagoControlador controladorFacturaFormaPago = new AdaptadorFacturaFormaPagoControlador();
    AdaptadorItemFacturaControlador controladorItemFactura = new AdaptadorItemFacturaControlador();
    double precioNeto;
    double total;
    double descuento;
    double impuesto;
    double propina;
    Factura factura;
    String operacion;

    public VentanaRegistrarPago(JFrame anterior, Pedido pedido, List<ItemFactura> itemsFactura, Factura factura, String operacion, String codEmpleado) {
        super("Registro de Pago");
        initComponents();

        this.ventanaAnterior = anterior;
        this.pedido = pedido;
        this.itemsFactura = itemsFactura;
        this.codigoEmpleado = codEmpleado;
        this.factura = factura;
        this.precioNeto = pedido.getTotal();
        this.total = pedido.getTotal();
        this.descuento = 0;
        this.impuesto = 0;
        this.propina = 0;
        this.operacion = operacion;
        setLocationRelativeTo(null);

        cbTipoPago2.setVisible(false);
        tfOpcion2.setVisible(false);
        
        if(operacion.equals("Visualizar")){
            
            llenarTablaItems();
            spDescuento.setEnabled(false);
            spImpuesto.setEnabled(false);
            spPropina.setEnabled(false);
            tfOpcion1.setEditable(false);
            tfOpcion2.setEditable(false);
            lDescuento.setText("" + factura.getDescuento());
            lImpuesto.setText("" + factura.getImpuestos());
            lPropina.setText("" + factura.getPropina());
            lTotal.setText("" + factura.getTotalPago());
            lInfo1.setVisible(false);
            lPrecioNeto.setVisible(false);
            cbFormaPago.setEnabled(false);
            cbTipoPago1.setEnabled(false);
            cbTipoPago2.setEnabled(false);            
            bLimpiar.setEnabled(false);
            bLimpiar.setVisible(false);
            bFinalizar.setEnabled(false);
            bFinalizar.setVisible(false);
            
            if(factura.getFacturaFormasPago().size() > 1){
                
                cbFormaPago.setSelectedItem("Mixto");
                cbTipoPago1.setSelectedItem("Efectivo");
                cbTipoPago2.setSelectedItem(factura.getFacturaFormasPago().get(1).getCodigoFormaPago());
                tfOpcion1.setText("" + factura.getFacturaFormasPago().get(0).getMonto());
                tfOpcion2.setText("" + factura.getFacturaFormasPago().get(1).getMonto());
                
                
            }else if(factura.getFacturaFormasPago().size() == 1){
                cbFormaPago.setSelectedItem("Simple");
                cbTipoPago1.setSelectedItem(factura.getFacturaFormasPago().get(0).getCodigoFormaPago());
                tfOpcion1.setText("" + factura.getFacturaFormasPago().get(0).getMonto());
                cbTipoPago2.setVisible(false);
                tfOpcion2.setVisible(false);
            }
            
        }else{

            llenarTablaItems();
        
            lPrecioNeto.setText("" + precioNeto);
            lTotal.setText("" + total);
            lIDCliente.setText(pedido.getCliente().getId());
        }
    }    
    

    public void llenarTablaItems() {

        DefaultTableModel modelo = (DefaultTableModel) tablaItemsPedido.getModel();
        modelo.setRowCount(0);

        for (int i = 0; i < modelo.getRowCount(); i++) {

            modelo.removeRow(i);
            i -= 1;
        }

        List<Pedido_Item> pedidoItems = pedido.getPedidoItems();

        if (pedidoItems != null) {

            for (int i = 0; i < pedidoItems.size(); i++) {

                Object[] fila = new Object[5];

                fila[0] = pedidoItems.get(i).getItem().getCodigo();
                fila[1] = pedidoItems.get(i).getItem().getNombre();
                fila[2] = pedidoItems.get(i).getItem().getPrecioActual();
                fila[3] = pedidoItems.get(i).getCantidad();
                fila[4] = pedidoItems.get(i).getItem().getPrecioActual() * pedidoItems.get(i).getCantidad();

                modelo.addRow(fila);

            }
        } else {

            JOptionPane.showMessageDialog(null, "No hay items registrados", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }
    
    public void registrarItemsFactura(List<Pedido_Item> items, Factura factura){
        
        ItemFactura itemFact;
        Long codigo;
        String nombre;
        String categoria;
        String descripcion;
        String fotografia;
        double precioActual;
        
        for(int i = 0; i < items.size(); i++){
            
            //System.out.println("Código item: " + codigo);
            nombre = items.get(i).getItem().getNombre();
            //System.out.println("Nombre item: " + nombre);
            categoria = items.get(i).getItem().getCategoria().getNombre();
            descripcion = items.get(i).getItem().getDescripcion();
            fotografia = items.get(i).getItem().getFotografia();
            precioActual = items.get(i).getItem().getPrecioActual();
            
            itemFact = new ItemFactura(nombre, descripcion, precioActual, fotografia, categoria, factura);
            
            controladorItemFactura.crearItemFactura(itemFact);           
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaItemsPedido = new javax.swing.JTable();
        lInfoIDCliente = new javax.swing.JLabel();
        lIDCliente = new javax.swing.JLabel();
        panelPrecio = new javax.swing.JPanel();
        lInfo1 = new javax.swing.JLabel();
        lInfo2 = new javax.swing.JLabel();
        lInfo3 = new javax.swing.JLabel();
        lInfo4 = new javax.swing.JLabel();
        lPrecioNeto = new javax.swing.JLabel();
        spDescuento = new javax.swing.JSpinner();
        spImpuesto = new javax.swing.JSpinner();
        spPropina = new javax.swing.JSpinner();
        lPorc1 = new javax.swing.JLabel();
        lPorc2 = new javax.swing.JLabel();
        lPorc3 = new javax.swing.JLabel();
        lDescuento = new javax.swing.JLabel();
        lImpuesto = new javax.swing.JLabel();
        lPropina = new javax.swing.JLabel();
        lInfo5 = new javax.swing.JLabel();
        lTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lInfo6 = new javax.swing.JLabel();
        cbFormaPago = new javax.swing.JComboBox<>();
        tfOpcion1 = new javax.swing.JTextField();
        cbTipoPago1 = new javax.swing.JComboBox<>();
        cbTipoPago2 = new javax.swing.JComboBox<>();
        tfOpcion2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(89, 30, 27));

        panelInferior.setBackground(new java.awt.Color(89, 30, 27));
        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Detalles del Pago", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Eras Medium ITC", 0, 16), new java.awt.Color(255, 255, 255))); // NOI18N

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

        tablaItemsPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Precio Unitario", "Cantidad", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaItemsPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaItemsPedidoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaItemsPedido);

        lInfoIDCliente.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lInfoIDCliente.setForeground(new java.awt.Color(255, 255, 255));
        lInfoIDCliente.setText("ID Cliente:");

        lIDCliente.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lIDCliente.setForeground(new java.awt.Color(255, 255, 255));
        lIDCliente.setText("1113672677");

        panelPrecio.setBackground(new java.awt.Color(89, 30, 27));

        lInfo1.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lInfo1.setForeground(new java.awt.Color(255, 255, 255));
        lInfo1.setText("Precio neto:");

        lInfo2.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lInfo2.setForeground(new java.awt.Color(255, 255, 255));
        lInfo2.setText("Descuento:");

        lInfo3.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lInfo3.setForeground(new java.awt.Color(255, 255, 255));
        lInfo3.setText("Impuesto:");

        lInfo4.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lInfo4.setForeground(new java.awt.Color(255, 255, 255));
        lInfo4.setText("Propina:");

        lPrecioNeto.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lPrecioNeto.setForeground(new java.awt.Color(255, 255, 255));
        lPrecioNeto.setText("0");

        spDescuento.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        spDescuento.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spDescuentoStateChanged(evt);
            }
        });
        spDescuento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spDescuentoMouseClicked(evt);
            }
        });

        spImpuesto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        spImpuesto.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spImpuestoStateChanged(evt);
            }
        });

        spPropina.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        spPropina.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spPropinaStateChanged(evt);
            }
        });

        lPorc1.setFont(new java.awt.Font("Eras Demi ITC", 0, 16)); // NOI18N
        lPorc1.setForeground(new java.awt.Color(255, 255, 255));
        lPorc1.setText("%");

        lPorc2.setFont(new java.awt.Font("Eras Demi ITC", 0, 16)); // NOI18N
        lPorc2.setForeground(new java.awt.Color(255, 255, 255));
        lPorc2.setText("%");

        lPorc3.setFont(new java.awt.Font("Eras Demi ITC", 0, 16)); // NOI18N
        lPorc3.setForeground(new java.awt.Color(255, 255, 255));
        lPorc3.setText("%");

        lDescuento.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lDescuento.setForeground(new java.awt.Color(255, 255, 255));
        lDescuento.setText("0");

        lImpuesto.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lImpuesto.setForeground(new java.awt.Color(255, 255, 255));
        lImpuesto.setText("0");

        lPropina.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lPropina.setForeground(new java.awt.Color(255, 255, 255));
        lPropina.setText("0");

        lInfo5.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        lInfo5.setForeground(new java.awt.Color(255, 255, 255));
        lInfo5.setText("Total:");

        lTotal.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        lTotal.setForeground(new java.awt.Color(255, 255, 255));
        lTotal.setText("0");

        javax.swing.GroupLayout panelPrecioLayout = new javax.swing.GroupLayout(panelPrecio);
        panelPrecio.setLayout(panelPrecioLayout);
        panelPrecioLayout.setHorizontalGroup(
            panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrecioLayout.createSequentialGroup()
                .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrecioLayout.createSequentialGroup()
                        .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrecioLayout.createSequentialGroup()
                                .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPrecioLayout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(lInfo5))
                                    .addComponent(lInfo4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrecioLayout.createSequentialGroup()
                                .addComponent(lInfo3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPrecioLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(spPropina, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(lPorc3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lPropina, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelPrecioLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrecioLayout.createSequentialGroup()
                                .addComponent(lInfo1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lPrecioNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPrecioLayout.createSequentialGroup()
                                .addComponent(lInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spImpuesto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lPorc1)
                                    .addComponent(lPorc2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lImpuesto, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(lDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(26, 26, 26))
        );
        panelPrecioLayout.setVerticalGroup(
            panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrecioLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPrecioNeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPorc1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lInfo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPorc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lImpuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lInfo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spPropina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lPorc3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lPropina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(panelPrecioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lInfo5)
                    .addComponent(lTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(89, 30, 27));

        lInfo6.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lInfo6.setForeground(new java.awt.Color(255, 255, 255));
        lInfo6.setText("Forma de Pago:");

        cbFormaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simple", "Mixto" }));
        cbFormaPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbFormaPagoItemStateChanged(evt);
            }
        });

        cbTipoPago1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Débito", "Crédito" }));

        cbTipoPago2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Crédito", "Débito" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lInfo6)
                            .addComponent(cbTipoPago1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbFormaPago, 0, 122, Short.MAX_VALUE)
                            .addComponent(tfOpcion1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbTipoPago2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(tfOpcion2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lInfo6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFormaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfOpcion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoPago1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoPago2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfOpcion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(lInfoIDCliente)
                        .addGap(18, 18, 18)
                        .addComponent(lIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(460, Short.MAX_VALUE))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelInferiorLayout.createSequentialGroup()
                                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInferiorLayout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(bFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelInferiorLayout.createSequentialGroup()
                                        .addComponent(panelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(3, 3, 3)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 40, Short.MAX_VALUE))))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lInfoIDCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(lIDCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(35, 35, 35)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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

    private void bFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFinalizarActionPerformed

        String formaPago = cbFormaPago.getSelectedItem().toString();
        String tipoPago1;
        String tipoPago2;
        Factura factura = new Factura();
        List<Pedido_Item> items = pedido.getPedidoItems();
        Factura_FormaPago facturaFormaPago;        
        Empleado cajero = controladorEmpleado.obtenerEmpleado(codigoEmpleado);        
        double impuestos = Double.parseDouble(lImpuesto.getText());
        double propinas = Double.parseDouble(lPropina.getText());
        double descuentos = Double.parseDouble(lDescuento.getText());
        double totalPago = Double.parseDouble(lTotal.getText());
        double monto1;
        double monto2;
        LocalTime horaPago = LocalTime.now();
        Long numeroPedido = pedido.getNumero();
        int tipoPagoRegistro1;
        int tipoPagoRegistro2;

        if (formaPago.equals("Simple")) {

            if (tfOpcion1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Por favor llene el campo del monto", "Aviso", JOptionPane.WARNING_MESSAGE);
                
            } else {

                tipoPago1 = cbTipoPago1.getSelectedItem().toString();
                monto1 = Double.parseDouble(tfOpcion1.getText());
                
                if(monto1 == totalPago){
                
                    if (tipoPago1.equals("Efectivo")) {

                        tipoPagoRegistro1 = 1;
                    
                        factura = new Factura(horaPago, impuestos, propinas, descuentos, totalPago, cajero, pedido);
                        controladorFactura.crearFactura(factura);
                        facturaFormaPago = new Factura_FormaPago(factura.getNumero(), Long.valueOf(tipoPagoRegistro1), monto1);
                        controladorFacturaFormaPago.crearFacturaFormaPago(facturaFormaPago);
                        registrarItemsFactura(items, factura);
                    
                        JOptionPane.showMessageDialog(null, "El pago se ha realizado con éxito", "Pago exitoso", JOptionPane.INFORMATION_MESSAGE);

                        VentanaPedidosAPagar ventanaPedidosPagar = (VentanaPedidosAPagar) ventanaAnterior;
                        ventanaPedidosPagar.llenarTablaPedidos();
                        ventanaPedidosPagar.setVisible(true);
                        this.setVisible(false);
                    

                    } else if (tipoPago1.equals("Crédito")) {

                        tipoPagoRegistro1 = 2;
                        factura = new Factura(horaPago, impuestos, propinas, descuentos, totalPago, cajero, pedido);
                        controladorFactura.crearFactura(factura);
                        facturaFormaPago = new Factura_FormaPago(factura.getNumero(), Long.valueOf(tipoPagoRegistro1), monto1);
                        controladorFacturaFormaPago.crearFacturaFormaPago(facturaFormaPago);
                        registrarItemsFactura(items, factura);
                    
                        JOptionPane.showMessageDialog(null, "El pago se ha realizado con éxito", "Pago exitoso", JOptionPane.INFORMATION_MESSAGE);

                        VentanaPedidosAPagar ventanaPedidosPagar = (VentanaPedidosAPagar) ventanaAnterior;
                        ventanaPedidosPagar.llenarTablaPedidos();
                        ventanaPedidosPagar.setVisible(true);
                        this.setVisible(false);

                    } else if (tipoPago1.equals("Débito")) {

                        tipoPagoRegistro1 = 3;
                        factura = new Factura(horaPago, impuestos, propinas, descuentos, totalPago, cajero, pedido);
                        controladorFactura.crearFactura(factura);
                        facturaFormaPago = new Factura_FormaPago(factura.getNumero(), Long.valueOf(tipoPagoRegistro1), monto1);
                        controladorFacturaFormaPago.crearFacturaFormaPago(facturaFormaPago);
                        registrarItemsFactura(items, factura);
                    
                        JOptionPane.showMessageDialog(null, "El pago se ha realizado con éxito", "Pago exitoso", JOptionPane.INFORMATION_MESSAGE);

                        VentanaPedidosAPagar ventanaPedidosPagar = (VentanaPedidosAPagar) ventanaAnterior;
                        ventanaPedidosPagar.llenarTablaPedidos();
                        ventanaPedidosPagar.setVisible(true);
                        this.setVisible(false);
                    }
                }else{
                    
                    JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad igual al total", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }

        } else if (formaPago.equals("Mixto")) {

            tipoPagoRegistro1 = 1;
            tipoPago2 = cbTipoPago2.getSelectedItem().toString();            
            
            if(tfOpcion1.getText().equals("") || tfOpcion2.getText().equals("")){
                
                JOptionPane.showMessageDialog(null, "Por favor llene los campos del monto", "Aviso", JOptionPane.WARNING_MESSAGE);
                
            }else {
                
                monto1 = Double.parseDouble(tfOpcion1.getText());
                monto2 = Double.parseDouble(tfOpcion2.getText());
                
                if(monto1 + monto2 == totalPago){

                    if (tipoPago2.equals("Crédito")) {

                        tipoPagoRegistro2 = 2;

                        factura = new Factura(horaPago, impuestos, propinas, descuentos, totalPago, cajero, pedido);
                        controladorFactura.crearFactura(factura);

                        facturaFormaPago = new Factura_FormaPago(factura.getNumero(), Long.valueOf(tipoPagoRegistro1), monto1);
                        controladorFacturaFormaPago.crearFacturaFormaPago(facturaFormaPago);
                        facturaFormaPago = new Factura_FormaPago(factura.getNumero(), Long.valueOf(tipoPagoRegistro2), monto2);
                        controladorFacturaFormaPago.crearFacturaFormaPago(facturaFormaPago);
                        registrarItemsFactura(items, factura);
                    
                        JOptionPane.showMessageDialog(null, "El pago se ha realizado con éxito", "Pago exitoso", JOptionPane.INFORMATION_MESSAGE);

                        VentanaPedidosAPagar ventanaPedidosPagar = (VentanaPedidosAPagar) ventanaAnterior;
                        ventanaPedidosPagar.llenarTablaPedidos();
                        ventanaPedidosPagar.setVisible(true);
                        this.setVisible(false);

                    } else if (tipoPago2.equals("Débito")) {

                        tipoPagoRegistro2 = 3;

                        factura = new Factura(horaPago, impuestos, propinas, descuentos, totalPago, cajero, pedido);
                        controladorFactura.crearFactura(factura);

                        facturaFormaPago = new Factura_FormaPago(factura.getNumero(), Long.valueOf(tipoPagoRegistro1), monto1);
                        controladorFacturaFormaPago.crearFacturaFormaPago(facturaFormaPago);
                        facturaFormaPago = new Factura_FormaPago(factura.getNumero(), Long.valueOf(tipoPagoRegistro2), monto2);
                        controladorFacturaFormaPago.crearFacturaFormaPago(facturaFormaPago);
                        registrarItemsFactura(items, factura);
                    
                        JOptionPane.showMessageDialog(null, "El pago se ha realizado con éxito", "Pago exitoso", JOptionPane.INFORMATION_MESSAGE);

                        VentanaPedidosAPagar ventanaPedidosPagar = (VentanaPedidosAPagar) ventanaAnterior;
                        ventanaPedidosPagar.llenarTablaPedidos();
                        ventanaPedidosPagar.setVisible(true);
                        this.setVisible(false);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Las cantidades ingresadas deben sumar un valor igual al total", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        }     

    }//GEN-LAST:event_bFinalizarActionPerformed

    private void tablaItemsPedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaItemsPedidoKeyReleased

        int columnaSeleccionada = tablaItemsPedido.getSelectedColumn();

        if (columnaSeleccionada == 3) {

            System.out.println("Actualizar subtotales");
            //Actualizar subtotales
        }
    }//GEN-LAST:event_tablaItemsPedidoKeyReleased

    private void cbFormaPagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbFormaPagoItemStateChanged

        int indiceSeleccionado = cbFormaPago.getSelectedIndex();

        switch (indiceSeleccionado) {

            case 0: //Simple
                cbTipoPago1.setEnabled(true);
                cbTipoPago2.setVisible(false);
                tfOpcion2.setVisible(false);

                break;
            case 1: //Mixto
                cbTipoPago1.setSelectedItem("Efectivo");
                cbTipoPago1.setEnabled(false);
                cbTipoPago2.setVisible(true);
                tfOpcion2.setVisible(true);

                break;
        }

    }//GEN-LAST:event_cbFormaPagoItemStateChanged

    private void spDescuentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spDescuentoMouseClicked
        // TODO add your handling code here:        
    }//GEN-LAST:event_spDescuentoMouseClicked

    private void spDescuentoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spDescuentoStateChanged
        // TODO add your handling code here:
        double totalProvisional = Double.parseDouble(lTotal.getText());
        double descuento1 = ((Integer) spDescuento.getValue() * precioNeto) / 100;
        if (descuento < descuento1) {
            totalProvisional = totalProvisional - (descuento1 - descuento);
        } else if (descuento > descuento1) {
            totalProvisional = totalProvisional + (descuento - descuento1);
        }

        descuento = descuento1;
        lDescuento.setText("" + descuento1);
        lTotal.setText("" + totalProvisional);

    }//GEN-LAST:event_spDescuentoStateChanged

    private void spImpuestoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spImpuestoStateChanged
        // TODO add your handling code here:double
        double totalProvisional = Double.parseDouble(lTotal.getText());
        double impuesto1 = ((Integer) spImpuesto.getValue() * precioNeto) / 100;

        if (impuesto < impuesto1) {
            totalProvisional = totalProvisional + (impuesto1 - impuesto);
        } else if (impuesto > impuesto1) {
            totalProvisional = totalProvisional - (impuesto - impuesto1);
        }
        impuesto = impuesto1;
        lImpuesto.setText("" + impuesto);
        lTotal.setText("" + totalProvisional);
    }//GEN-LAST:event_spImpuestoStateChanged

    private void spPropinaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spPropinaStateChanged
        // TODO add your handling code here:
        double totalProvisional = Double.parseDouble(lTotal.getText());
        double propina1 = ((Integer) spPropina.getValue() * precioNeto) / 100;

        if (propina < propina1) {
            totalProvisional = totalProvisional + (propina1 - propina);
        } else if (propina > propina1) {
            totalProvisional = totalProvisional - (propina - propina1);
        }
        propina = propina1;
        lPropina.setText("" + propina);
        lTotal.setText("" + totalProvisional);
    }//GEN-LAST:event_spPropinaStateChanged

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
            java.util.logging.Logger.getLogger(VentanaRegistrarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrarPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistrarPago(null, null, null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bFinalizar;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JComboBox<String> cbFormaPago;
    private javax.swing.JComboBox<String> cbTipoPago1;
    private javax.swing.JComboBox<String> cbTipoPago2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lDescuento;
    private javax.swing.JLabel lIDCliente;
    private javax.swing.JLabel lImpuesto;
    private javax.swing.JLabel lInfo1;
    private javax.swing.JLabel lInfo2;
    private javax.swing.JLabel lInfo3;
    private javax.swing.JLabel lInfo4;
    private javax.swing.JLabel lInfo5;
    private javax.swing.JLabel lInfo6;
    private javax.swing.JLabel lInfoIDCliente;
    private javax.swing.JLabel lLogo;
    private javax.swing.JLabel lPorc1;
    private javax.swing.JLabel lPorc2;
    private javax.swing.JLabel lPorc3;
    private javax.swing.JLabel lPrecioNeto;
    private javax.swing.JLabel lPropina;
    private javax.swing.JLabel lTotal;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelPrecio;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JSpinner spDescuento;
    private javax.swing.JSpinner spImpuesto;
    private javax.swing.JSpinner spPropina;
    private javax.swing.JTable tablaItemsPedido;
    private javax.swing.JTextField tfOpcion1;
    private javax.swing.JTextField tfOpcion2;
    // End of variables declaration//GEN-END:variables
}
