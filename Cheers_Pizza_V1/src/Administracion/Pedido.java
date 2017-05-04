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
 * file: Pedido.java
 * 
 */


package Administracion;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Fabio Andres
 */

@Entity
@Table(name = "Pedido")
public class Pedido implements Serializable {
    
    private static final long serialVersionUID = 5L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ped_gen")
    @SequenceGenerator(name = "ped_gen", sequenceName = "PEDIDO_SEQ")
    private Long numero;
    
    @Column(name = "tipo_pedido")
    private String tipoPedido;
    
    @Column(name = "hora_inicio")
    private LocalTime horaInicio;
    
    @Column(name = "hora_entrega")
    private LocalTime horaEntrega;
   
    @ManyToOne
    @JoinColumn(name = "numero_mesa")
    private Mesa mesa;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    
    @ManyToOne
    @JoinColumn(name = "cod_sucursal")
    private Sucursal sucursal;
    
    //Constructor N°1
    
    public Pedido() {
    }

    //Constructor N°2

    public Pedido(String tipoPedido, LocalTime horaInicio, LocalTime horaEntrega, Mesa mesa, Cliente cliente, Empleado empleado, Sucursal sucursal) {
        this.tipoPedido = tipoPedido;
        this.horaInicio = horaInicio;
        this.horaEntrega = horaEntrega;
        this.mesa = mesa;
        this.cliente = cliente;
        this.empleado = empleado;
        this.sucursal = sucursal;
    }
    
    //Constructor N°3

    public Pedido(String tipoPedido, LocalTime horaInicio, LocalTime horaEntrega, Cliente cliente, Sucursal sucursal) {
        this.tipoPedido = tipoPedido;
        this.horaInicio = horaInicio;
        this.horaEntrega = horaEntrega;
        this.cliente = cliente;
        this.sucursal = sucursal;
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
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
        return "Pedido{" + "numero=" + numero + ", tipoPedido=" + tipoPedido + ", horaInicio=" + horaInicio + ", horaEntrega=" + horaEntrega + ", mesa=" + mesa + ", cliente=" + cliente + ", empleado=" + empleado + ", sucursal=" + sucursal + '}';
    }
    
    
    
    
    
}
