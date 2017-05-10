/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administracion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author invitado
 */
@Entity
@Table(name = "FormaPago")
public class FormaPago implements Serializable{
    
    private static final long serialVersionUID = 4L;
    
    @Id    
    private Long codigo;
    
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "formaPago" , cascade = CascadeType.ALL)
    private List<Factura_FormaPago> formaPagoFacturas = new ArrayList<>();

    public FormaPago() {
    }
    
    
    
    public FormaPago(Long codigo, String nombre){
        
        this.codigo = codigo;
        this.nombre = nombre;        
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Factura_FormaPago> getFormaPagoFacturas() {
        return formaPagoFacturas;
    }

    public void setFormaPagoFacturas(List<Factura_FormaPago> formaPagoFacturas) {
        this.formaPagoFacturas = formaPagoFacturas;
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
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FormaPago{" + "codigo=" + codigo + ", nombre=" + nombre + ", formaPagoFacturas=" + formaPagoFacturas + '}';
    }   
    
    
}
