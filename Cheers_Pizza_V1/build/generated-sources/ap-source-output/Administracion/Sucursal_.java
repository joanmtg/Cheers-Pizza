package Administracion;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Sucursal.class)
public abstract class Sucursal_ {

	public static volatile SingularAttribute<Sucursal, Long> codigo;
	public static volatile SingularAttribute<Sucursal, String> direccion;
	public static volatile ListAttribute<Sucursal, Empleado> empleados;
	public static volatile ListAttribute<Sucursal, Pedido> pedidos;
	public static volatile SingularAttribute<Sucursal, String> telefono;
	public static volatile SingularAttribute<Sucursal, String> nombre;

}

