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
@Table(name = "Factura_Item")
@IdClass(FacturaItemPK.class)

public class Factura_Item implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "numero_factura")
    private Long numeroFactura;

    @Id
    @Column(name = "codigo_item")
    private Long codigoItem;
    
    @ManyToOne
    @JoinColumn(name = "numero_factura", insertable = false, updatable = false)
    private Factura factura;
    
    @ManyToOne
    @JoinColumn(name = "codigo_item", insertable = false, updatable = false)
    private Item item;
    
    //Constructor N°1

    public Factura_Item() {
    }
    
    //Constructor N°2

    public Factura_Item(Long numeroFactura, Long codigoItem) {
        this.numeroFactura = numeroFactura;
        this.codigoItem = codigoItem;
    }
    
    //Setters & Getters

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

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
        if (!(object instanceof Factura_Item)) {
            return false;
        }
        Factura_Item other = (Factura_Item) object;
        if ((this.numeroFactura == null && other.numeroFactura != null) || (this.numeroFactura != null && !this.numeroFactura.equals(other.numeroFactura))) {
            return false;
        }
        
        if ((this.codigoItem == null && other.codigoItem != null) || (this.codigoItem != null && !this.codigoItem.equals(other.codigoItem))) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "Factura_Item{" + "numeroFactura=" + numeroFactura + ", codigoItem=" + codigoItem + ", factura=" + factura + ", item=" + item + '}';
    }

    
    
    
}



