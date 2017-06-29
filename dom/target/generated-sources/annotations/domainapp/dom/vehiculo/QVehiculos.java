package domainapp.dom.vehiculo;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QVehiculos extends PersistableExpressionImpl<Vehiculos> implements PersistableExpression<Vehiculos>
{
    public static final QVehiculos jdoCandidate = candidate("this");

    public static QVehiculos candidate(String name)
    {
        return new QVehiculos(null, name, 5);
    }

    public static QVehiculos candidate()
    {
        return jdoCandidate;
    }

    public static QVehiculos parameter(String name)
    {
        return new QVehiculos(Vehiculos.class, name, ExpressionType.PARAMETER);
    }

    public static QVehiculos variable(String name)
    {
        return new QVehiculos(Vehiculos.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Integer> NAME_LENGTH;
    public final StringExpression dominio;
    public final NumericExpression<Integer> anio;
    public final StringExpression numeroMotor;
    public final StringExpression numeroChasis;
    public final BooleanExpression activo;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QVehiculos(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.NAME_LENGTH = new NumericExpressionImpl<Integer>(this, "NAME_LENGTH");
        this.dominio = new StringExpressionImpl(this, "dominio");
        this.anio = new NumericExpressionImpl<Integer>(this, "anio");
        this.numeroMotor = new StringExpressionImpl(this, "numeroMotor");
        this.numeroChasis = new StringExpressionImpl(this, "numeroChasis");
        this.activo = new BooleanExpressionImpl(this, "activo");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QVehiculos(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.NAME_LENGTH = new NumericExpressionImpl<Integer>(this, "NAME_LENGTH");
        this.dominio = new StringExpressionImpl(this, "dominio");
        this.anio = new NumericExpressionImpl<Integer>(this, "anio");
        this.numeroMotor = new StringExpressionImpl(this, "numeroMotor");
        this.numeroChasis = new StringExpressionImpl(this, "numeroChasis");
        this.activo = new BooleanExpressionImpl(this, "activo");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
