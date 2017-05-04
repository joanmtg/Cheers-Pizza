package Administracion;

import java.time.LocalTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Empleado.class)
public abstract class Empleado_ {

	public static volatile SingularAttribute<Empleado, String> apellidos;
	public static volatile SingularAttribute<Empleado, LocalTime> horaFin;
	public static volatile SingularAttribute<Empleado, String> fotoURL;
	public static volatile SingularAttribute<Empleado, String> tipoId;
	public static volatile SingularAttribute<Empleado, String> password;
	public static volatile SingularAttribute<Empleado, String> direccion;
	public static volatile SingularAttribute<Empleado, String> id;
	public static volatile SingularAttribute<Empleado, String> telefono;
	public static volatile SingularAttribute<Empleado, String> cargo;
	public static volatile SingularAttribute<Empleado, String> nombre;
	public static volatile SingularAttribute<Empleado, LocalTime> horaInicio;
	public static volatile SingularAttribute<Empleado, Long> cod_sucursal;

}

