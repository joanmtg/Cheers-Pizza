/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import java.io.Serializable;

/**
 *
 * @author Jhonier Andrés
 */
public class PedidoItemPK implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long numeroPedido;
    
    private Long codigoItem;

    //Constructor N°1

    public PedidoItemPK() {
    }
    
    //Constructor N°2

    public PedidoItemPK(Long numeroFactura, Long codigoItem) {
        this.numeroPedido = numeroFactura;
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
        hash += (codigoItem != null ? numeroPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidoItemPK)) {
            return false;
        }
        PedidoItemPK other = (PedidoItemPK) object;
        if ((this.numeroPedido == null && other.numeroPedido != null) || (this.numeroPedido != null && !this.numeroPedido.equals(other.numeroPedido))) {
            return false;
        }
        
        if ((this.codigoItem == null && other.codigoItem != null) || (this.codigoItem != null && !this.codigoItem.equals(other.codigoItem))) {
            return false;
        }
        
        return true;
    }
    
    
}
