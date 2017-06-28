package domainapp.dom.tipoVehiculo;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QTipoVehiculo extends PersistableExpressionImpl<TipoVehiculo> implements PersistableExpression<TipoVehiculo>
{
    public static final QTipoVehiculo jdoCandidate = candidate("this");

    public static QTipoVehiculo candidate(String name)
    {
        return new QTipoVehiculo(null, name, 5);
    }

    public static QTipoVehiculo candidate()
    {
        return jdoCandidate;
    }

    public static QTipoVehiculo parameter(String name)
    {
        return new QTipoVehiculo(TipoVehiculo.class, name, ExpressionType.PARAMETER);
    }

    public static QTipoVehiculo variable(String name)
    {
        return new QTipoVehiculo(TipoVehiculo.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Integer> NAME_LENGTH;
    public final StringExpression tipoVehiculoNombre;
    public final ObjectExpression<java.lang.Boolean> tipoVehiculoActivo;
    public final ObjectExpression<org.apache.isis.applib.services.repository.RepositoryService> repositoryService;
    public final ObjectExpression<org.apache.isis.applib.services.title.TitleService> titleService;
    public final ObjectExpression<org.apache.isis.applib.services.message.MessageService> messageService;

    public QTipoVehiculo(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.NAME_LENGTH = new NumericExpressionImpl<Integer>(this, "NAME_LENGTH");
        this.tipoVehiculoNombre = new StringExpressionImpl(this, "tipoVehiculoNombre");
        this.tipoVehiculoActivo = new ObjectExpressionImpl<java.lang.Boolean>(this, "tipoVehiculoActivo");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }

    public QTipoVehiculo(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.NAME_LENGTH = new NumericExpressionImpl<Integer>(this, "NAME_LENGTH");
        this.tipoVehiculoNombre = new StringExpressionImpl(this, "tipoVehiculoNombre");
        this.tipoVehiculoActivo = new ObjectExpressionImpl<java.lang.Boolean>(this, "tipoVehiculoActivo");
        this.repositoryService = new ObjectExpressionImpl<org.apache.isis.applib.services.repository.RepositoryService>(this, "repositoryService");
        this.titleService = new ObjectExpressionImpl<org.apache.isis.applib.services.title.TitleService>(this, "titleService");
        this.messageService = new ObjectExpressionImpl<org.apache.isis.applib.services.message.MessageService>(this, "messageService");
    }
}
