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
 * file: ItemFactura.java
 * 
 */
package Administracion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author invitado
 */
@Entity
@Table(name = "ItemFactura")
public class ItemFactura implements Serializable{
    
    private static final long serialVersionUID = 4L;
    
    @Id
    @GenericGenerator(name = "item_fact_gen", strategy = "increment")
    @GeneratedValue(generator = "item_fact_gen")
    private Long codigo;
     
    @Column(name = "nombre", nullable = false)
    private String nombre;
     
    @Column(name = "descripcion")
    private String descripcion;
     
    @Column(name = "precio", nullable = false)
    private double precioActual;
    
    @Column(name = "foto", columnDefinition = "TEXT")
    private String fotografia;
    
    @Column(name = "categoria")
    private String categoria;
    
    @ManyToOne
    @JoinColumn(name = "num_factura", nullable = false)
    private Factura itemFactura;
    
    public ItemFactura(){        
    }
    
    public ItemFactura(String nombre, String descripcion, double precioActual, String fotografia, String categoria, Factura factura){        
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.fotografia = fotografia;
        this.categoria = categoria;
        this.itemFactura = factura;        
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo){
        this.codigo = codigo;        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Factura getItemFactura() {
        return itemFactura;
    }

    public void setItemFactura(Factura itemFactura) {
        this.itemFactura = itemFactura;
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
        if (!(object instanceof ItemFactura)) {
            return false;
        }
        ItemFactura other = (ItemFactura) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemFactura{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioActual=" + precioActual + ", fotografia=" + fotografia + ", categoria=" + categoria + ", itemFactura=" + itemFactura + '}';
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
