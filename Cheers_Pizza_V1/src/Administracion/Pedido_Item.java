/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Jhonier Andrés
 */
@Entity
@Table(name = "Pedido_Item")

public class Pedido_Item implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GenericGenerator(name = "ped_item_gen", strategy = "increment")
    @GeneratedValue(generator = "ped_item_gen")
    private Long codigo;
    
    @ManyToOne
    @JoinColumn(name = "numero_pedido", nullable = false)
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "codigo_item", nullable = false)
    private Item item;
    
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    
    @Column(name = "entregado", nullable = false)
    private boolean entregado;
    
    //Constructor N°1

    public Pedido_Item() {
    }

    
    
    //Constructor N°2
    public Pedido_Item(Pedido pedido, Item item, int cantidad, boolean entregado) {    
        this.pedido = pedido;
        this.item = item;
        this.cantidad = cantidad;
        this.entregado = entregado;
    }

    //Setters & Getters

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido_Item)) {
            return false;
        }
        Pedido_Item other = (Pedido_Item) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "Pedido_Item{" + "codigo=" + codigo + ", pedido=" + pedido + ", item=" + item + ", cantidad=" + cantidad + ", entregado=" + entregado + '}';
    }

    

    
    

    

    

    
    
    
}



