/**
 * Proyecto Desarrollo de Software II
 * Fecha de entrega: 19/04/2017
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
 * file: Item.java
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
 * @author Fabio Andres
 */

@Entity
@Table(name = "Item")
public class Item implements Serializable {
    
    private static final long serialVersionUID = 4L;
    
    @Id
    @GenericGenerator(name = "item_gen", strategy = "increment")
    @GeneratedValue(generator = "item_gen")
    private Long codigo;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "precio", nullable = false)
    private double precioActual;
    
    @Column(name = "foto", columnDefinition = "TEXT")
    
    private String fotografia;
    
    @ManyToOne
    @JoinColumn(name = "cod_categoria", nullable = false)
    private Categoria categoria;
    
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<Pedido_Item> pedidosItem = new ArrayList<>();
    
    
    //Constructor N°1

    public Item() {
    }
    
    //Constructor N°2

    public Item(String nombre, String descripcion, double precioActual, String fotografia, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.fotografia = fotografia;
        this.categoria = categoria;
    }
    
    
    //Setters & Getters 

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Pedido_Item> getPedidosItem() {
        return pedidosItem;
    }

    public void setPedidosItem(List<Pedido_Item> pedidosItem) {
        this.pedidosItem = pedidosItem;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precioActual=" + precioActual + ", fotografia=" + fotografia + ", categoria=" + categoria + ", pedidosItem=" + pedidosItem + '}';
    }

    
    

       
    
    
    
}
