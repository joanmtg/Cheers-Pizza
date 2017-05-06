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
 * file: Factura.java
 * 
 */


package Administracion;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Fabio Andres
 */

@Entity
@Table(name = "Factura")
public class Factura implements Serializable {
    
    private static final long serialVersionUID = 5L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "fac_gen")
    @SequenceGenerator(name = "fac_gen", sequenceName = "FACTURA_SEQ")
    private Long numero;
    
    @Column(name = "tipo_pago")
    private String tipoPago;
    
    @Column(name = "horaPago")
    private LocalTime horaPago;
    
    @Column(name = "impuestos")
    private double impuestos;
    
    @Column(name = "propina")
    private double propina;
    
    @Column(name = "descuento")
    private double descuento;
    
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado cajero;
    
    
    
    //Constructor N°1
    
    public Factura() {
    }

    //Constructor N°2

    public Factura(String tipoPago, LocalTime horaPago, double impuestos, double propina, double descuento, Empleado cajero) {
        this.tipoPago = tipoPago;
        this.horaPago = horaPago;
        this.impuestos = impuestos;
        this.propina = propina;
        this.descuento = descuento;
        this.cajero = cajero;
    }

    
    
    //Setters & Getters

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public LocalTime getHoraPago() {
        return horaPago;
    }

    public void setHoraPago(LocalTime horaPago) {
        this.horaPago = horaPago;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getPropina() {
        return propina;
    }

    public void setPropina(double propina) {
        this.propina = propina;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Empleado getCajero() {
        return cajero;
    }

    public void setCajero(Empleado cajero) {
        this.cajero = cajero;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Factura{" + "numero=" + numero + ", tipoPago=" + tipoPago + ", horaPago=" + horaPago + ", impuestos=" + impuestos + ", propina=" + propina + ", descuento=" + descuento + ", cajero=" + cajero + '}';
    }

    
    
    
    
    
    
}
