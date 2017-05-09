/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import java.io.Serializable;

/**
 *
 * @author invitado
 */
public class FacturaFormaPagoPK implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Long numeroFactura;
    private Long codigoFormaPago;
    
    public FacturaFormaPagoPK(){
        
    }
    
    public FacturaFormaPagoPK(Long numeroFactura, Long codigoFormaPago){
        
        this.numeroFactura = numeroFactura;
        this.codigoFormaPago = codigoFormaPago;
    }

    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Long getCodigoFormaPago() {
        return codigoFormaPago;
    }

    public void setCodigoFormaPago(Long codigoFormaPago) {
        this.codigoFormaPago = codigoFormaPago;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroFactura != null ? numeroFactura.hashCode() : 0);
        hash += (codigoFormaPago != null ? codigoFormaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaFormaPagoPK)) {
            return false;
        }
        FacturaFormaPagoPK other = (FacturaFormaPagoPK) object;
        if ((this.numeroFactura == null && other.numeroFactura != null) || (this.numeroFactura != null && !this.numeroFactura.equals(other.numeroFactura))) {
            return false;
        }
        
        if ((this.codigoFormaPago == null && other.codigoFormaPago != null) || (this.codigoFormaPago != null && !this.codigoFormaPago.equals(other.codigoFormaPago))) {
            return false;
        }
        
        return true;
    }
    
    
    
    
}
