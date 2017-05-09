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
 * @author invitado
 */
@Entity
@Table(name = "Factura_FormaPago")
@IdClass(FacturaFormaPagoPK.class)
public class Factura_FormaPago implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "factura_numero")
    private Long numeroFactura;
    
    @Id
    @Column(name = "formaPago_codigo")
    private Long codigoFormaPago;
    
    @ManyToOne
    @JoinColumn(name = "factura_numero", insertable = false, updatable = false)
    private Factura factura;
    
    @ManyToOne
    @JoinColumn(name = "formaPago_codigo", insertable = false, updatable = false)
    private FormaPago formaPago;
    
    @Column(name = "monto")
    private double monto;
    
    public Factura_FormaPago(){
        
    }
    
    public Factura_FormaPago(Long numeroFactura, Long codigoFormaPago, double monto){
        this.numeroFactura = numeroFactura;
        this.codigoFormaPago = codigoFormaPago;
        this.monto = monto;
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

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
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
        if (!(object instanceof Factura_FormaPago)) {
            return false;
        }
        Factura_FormaPago other = (Factura_FormaPago) object;
        if ((this.numeroFactura == null && other.numeroFactura != null) || (this.numeroFactura != null && !this.numeroFactura.equals(other.numeroFactura))) {
            return false;
        }
        
        if ((this.codigoFormaPago == null && other.codigoFormaPago != null) || (this.codigoFormaPago != null && !this.codigoFormaPago.equals(other.codigoFormaPago))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "Factura_FormaPago{" + "numeroFactura=" + numeroFactura + ", codigoFormaPago=" + codigoFormaPago + ", factura=" + factura + ", formaPago=" + formaPago + ", monto=" + monto + '}';
    }
    
    
        
    
}
