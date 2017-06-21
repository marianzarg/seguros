package domainapp.dom.cliente;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QClientes extends PersistableExpressionImpl<Clientes> implements PersistableExpression<Clientes>
{
    public static final QClientes jdoCandidate = candidate("this");

    public static QClientes candidate(String name)
    {
        return new QClientes(null, name, 5);
    }

    public static QClientes candidate()
    {
        return jdoCandidate;
    }

    public static QClientes parameter(String name)
    {
        return new QClientes(Clientes.class, name, ExpressionType.PARAMETER);
    }

    public static QClientes variable(String name)
    {
        return new QClientes(Clientes.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Integer> NAME_LENGTH;
    public final StringExpression nombre;
    public final StringExpression apellido;
    public final NumericExpression<Integer> dni;
    public final StringExpression direccion;
    public final StringExpression telefono;
    public final StringExpression mail;
    public final StringExpression cuitcuil;
    public final DateTimeExpression fechaNacimiento;
    public final BooleanExpression notificacionCumpleanios;
    public final BooleanExpression activo;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QClientes(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.NAME_LENGTH = new NumericExpressionImpl<Integer>(this, "NAME_LENGTH");
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.dni = new NumericExpressionImpl<Integer>(this, "dni");
        this.direccion = new StringExpressionImpl(this, "direccion");
        this.telefono = new StringExpressionImpl(this, "telefono");
        this.mail = new StringExpressionImpl(this, "mail");
        this.cuitcuil = new StringExpressionImpl(this, "cuitcuil");
        this.fechaNacimiento = new DateTimeExpressionImpl(this, "fechaNacimiento");
        this.notificacionCumpleanios = new BooleanExpressionImpl(this, "notificacionCumpleanios");
        this.activo = new BooleanExpressionImpl(this, "activo");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QClientes(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.NAME_LENGTH = new NumericExpressionImpl<Integer>(this, "NAME_LENGTH");
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.dni = new NumericExpressionImpl<Integer>(this, "dni");
        this.direccion = new StringExpressionImpl(this, "direccion");
        this.telefono = new StringExpressionImpl(this, "telefono");
        this.mail = new StringExpressionImpl(this, "mail");
        this.cuitcuil = new StringExpressionImpl(this, "cuitcuil");
        this.fechaNacimiento = new DateTimeExpressionImpl(this, "fechaNacimiento");
        this.notificacionCumpleanios = new BooleanExpressionImpl(this, "notificacionCumpleanios");
        this.activo = new BooleanExpressionImpl(this, "activo");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
