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
 * file: Pedido.java
 * 
 */


package Administracion;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Fabio Andres
 */

@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable {
    
    private static final long serialVersionUID = 5L;
    
    @Id
    @GenericGenerator(name = "pedido_gen", strategy = "increment")
    @GeneratedValue(generator = "pedido_gen")
    private Long numero;
    
    @Column(name = "tipo_pedido", nullable = false)
    private String tipoPedido;
    
    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;
    
    @Column(name = "hora_entrega")
    private LocalTime horaEntrega;
    
    @Column(name = "entregado", nullable = false)
    private boolean entregado;
    
    @Column(name = "total", nullable = false)
    private double total;
   
    @ManyToOne
    @JoinColumn(name = "numero_mesa")
    private Mesa mesa;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado mesero;
    
    @ManyToOne
    @JoinColumn(name = "cod_sucursal", nullable = false)
    private Sucursal sucursalPedido;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Pedido_Item> pedidoItems = new ArrayList<>();
    
    //Constructor N°1
    
    public Pedido() {
    }

    //Constructor N°2

    public Pedido(String tipoPedido, LocalTime horaInicio, LocalTime horaEntrega, boolean entregado, double total, Mesa mesa, Cliente cliente, Empleado mesero, Sucursal sucursalPedido) {
        this.tipoPedido = tipoPedido;
        this.horaInicio = horaInicio;
        this.horaEntrega = horaEntrega;
        this.entregado = entregado;
        this.total = total;
        this.mesa = mesa;
        this.cliente = cliente;
        this.mesero = mesero;
        this.sucursalPedido = sucursalPedido;
    }

    
    //Constructor N°3

    public Pedido(String tipoPedido, LocalTime horaInicio, LocalTime horaEntrega, boolean entregado, double total, Cliente cliente, Sucursal sucursalPedido) {
        this.tipoPedido = tipoPedido;
        this.horaInicio = horaInicio;
        this.horaEntrega = horaEntrega;
        this.entregado = entregado;
        this.total = total;
        this.cliente = cliente;
        this.sucursalPedido = sucursalPedido;
    }
 
    
    //Setters & Getters

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(LocalTime horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getMesero() {
        return mesero;
    }

    public void setMesero(Empleado mesero) {
        this.mesero = mesero;
    }

    public Sucursal getSucursalPedido() {
        return sucursalPedido;
    }

    public void setSucursalPedido(Sucursal sucursalPedido) {
        this.sucursalPedido = sucursalPedido;
    }

    public List<Pedido_Item> getPedidoItems() {
        return pedidoItems;
    }

    public void setPedidoItems(List<Pedido_Item> pedidoItems) {
        this.pedidoItems = pedidoItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", tipoPedido=" + tipoPedido + ", horaInicio=" + horaInicio + ", horaEntrega=" + horaEntrega + ", entregado=" + entregado + ", total=" + total + ", mesa=" + mesa + ", cliente=" + cliente + ", mesero=" + mesero + ", sucursalPedido=" + sucursalPedido + ", pedidoItems=" + pedidoItems + '}';
    }

    
    

    
    

    
    
    
    
    
}
