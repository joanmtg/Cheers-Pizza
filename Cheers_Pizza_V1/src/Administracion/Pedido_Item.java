/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jhonier Andrés
 */
@Entity
@Table(name = "Pedido_Item")
@IdClass(PedidoItemPK.class)

public class Pedido_Item implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "numero_pedido")
    private Long numeroPedido;

    @Id
    @Column(name = "codigo_item")
    private Long codigoItem;
    
    @ManyToOne
    @JoinColumn(name = "numero_pedido", insertable = false, updatable = false)
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "codigo_item", insertable = false, updatable = false)
    private Item item;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "entregado")
    private boolean entregado;
    
    //Constructor N°1

    public Pedido_Item() {
    }

    
    
    //Constructor N°2
    public Pedido_Item(Long numeroPedido, Long codigoItem, int cantidad, boolean entregado) {    
        this.numeroPedido = numeroPedido;
        this.codigoItem = codigoItem;
        this.cantidad = cantidad;
        this.entregado = entregado;
    }

    //Setters & Getters
    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    

    public Long getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(Long codigoItem) {
        this.codigoItem = codigoItem;
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
        hash += (numeroPedido != null ? numeroPedido.hashCode() : 0);
        hash += (codigoItem != null ? numeroPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido_Item)) {
            return false;
        }
        Pedido_Item other = (Pedido_Item) object;
        if ((this.numeroPedido == null && other.numeroPedido != null) || (this.numeroPedido != null && !this.numeroPedido.equals(other.numeroPedido))) {
            return false;
        }
        
        if ((this.codigoItem == null && other.codigoItem != null) || (this.codigoItem != null && !this.codigoItem.equals(other.codigoItem))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "Pedido_Item{" + "numeroPedido=" + numeroPedido + ", codigoItem=" + codigoItem + ", pedido=" + pedido + ", item=" + item + ", cantidad=" + cantidad + ", entregado=" + entregado + '}';
    }

    
    

    

    

    
    
    
}



