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
public class FacturaItemPK implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long numeroFactura;
    
    private Long codigoItem;

    //Constructor N°1

    public FacturaItemPK() {
    }
    
    //Constructor N°2

    public FacturaItemPK(Long numeroFactura, Long codigoItem) {
        this.numeroFactura = numeroFactura;
        this.codigoItem = codigoItem;
    }
    
    
    // Getters and Setters
    
    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
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
        hash += (numeroFactura != null ? numeroFactura.hashCode() : 0);
        hash += (codigoItem != null ? numeroFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaItemPK)) {
            return false;
        }
        FacturaItemPK other = (FacturaItemPK) object;
        if ((this.numeroFactura == null && other.numeroFactura != null) || (this.numeroFactura != null && !this.numeroFactura.equals(other.numeroFactura))) {
            return false;
        }
        
        if ((this.codigoItem == null && other.codigoItem != null) || (this.codigoItem != null && !this.codigoItem.equals(other.codigoItem))) {
            return false;
        }
        
        return true;
    }
    
    
}
