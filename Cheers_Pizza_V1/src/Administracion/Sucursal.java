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
 * file: Sucursal.java
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Jhonier Andrés
 */
@Entity
@Table(name = "Sucursal")
public class Sucursal implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GenericGenerator(name = "suc_gen", strategy = "increment")
    @GeneratedValue(generator = "suc_gen")
    private Long codigo;
    
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;
    
    @Column(name = "direccion", nullable = false)
    private String direccion;
    
    @Column(name = "telefono", nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<Empleado> empleados = new ArrayList<>();
    
    
    @OneToMany(mappedBy = "sucursalPedido", cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();
    
    
    //Constructor N°1

    public Sucursal() {
    }
    
    
    //Constructor N°2
    
    public Sucursal(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    
    //Setters & Getters

     public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
  
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
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
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", empleados=" + empleados + ", pedidos=" + pedidos + '}';
    }

    

    
    
    
}
