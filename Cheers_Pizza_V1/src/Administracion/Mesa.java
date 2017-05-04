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
 * file: Mesa.java
 * 
 */


package Administracion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Fabio Andres
 */
@Entity
@Table(name = "Mesa")
public class Mesa implements Serializable {
    
    private static final long serialVersionUID = 7L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "mesa_gen")
    @SequenceGenerator(name = "mesa_gen", sequenceName = "MESA_SEQ")
    private Long numero;
    
    @Column(name = "capacidad")
    private int cantidadPersonas;
    
    //Constructor N°1
    
    public Mesa() {
    }

    //Constructor N°2

    public Mesa(Long numero, int cantidadPersonas) {
        this.numero = numero;
        this.cantidadPersonas = cantidadPersonas;
    }
    
    
    //Setters & Getters

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mesa{" + "numero=" + numero + ", cantidadPersonas=" + cantidadPersonas + '}';
    }
    
    
    
    
    
}
