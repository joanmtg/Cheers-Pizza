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
 * file: PedidoItemPK.java
 * 
 */
package Administracion;

import java.io.Serializable;

/**
 *
 * @author jacrodas
 */
public class PedidoItemPK implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Long numeroPedido;
    
    private Long codigoItem;
    
    
    //Constructor N°1

    public PedidoItemPK() {
    }
    
    //Constructor N°2

    public PedidoItemPK(Long numeroPedido, Long codigoItem) {
        this.numeroPedido = numeroPedido;
        this.codigoItem = codigoItem;
    }
    
    // Getters and Setters

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
    
    
    @Override
    public int hashCode() {
 
        int hash = 0;
        
        hash += (numeroPedido != null ? numeroPedido.hashCode() : 0);
 
        hash += (codigoItem != null ? codigoItem.hashCode() : 0);
 
        return hash;
 
    }
    
    @Override
    public boolean equals(Object object) {
 
        // TODO: Warning - this method won't work in the case the id fields are not set
 
        if (!(object instanceof PedidoItemPK)) {
 
            return false;
 
        }
 
        PedidoItemPK other = (PedidoItemPK) object;
 
        if ((this.numeroPedido == null && other.numeroPedido != null) || (this.numeroPedido != null && !this.numeroPedido.equals(other.numeroPedido))){
 
            return false;
 
        }
 
        return true;
    }

    @Override
    public String toString() {
        return "PedidoItemPK{" + "numeroPedido=" + numeroPedido + ", codigoItem=" + codigoItem + '}';
    }
    
    
    
    
    
 
    
}
